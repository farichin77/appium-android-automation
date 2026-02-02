package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {

    public static AndroidDriver createDriver(Properties config) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(config.getProperty("platformName"))
               .setPlatformVersion(config.getProperty("platformVersion"))
               .setDeviceName(config.getProperty("deviceName"))
               .setApp(config.getProperty("app.path"))
               .setNoReset(true)
               .setDisableWindowAnimation(true)
               .setAutoGrantPermissions(true)
               .setNewCommandTimeout(Duration.ofSeconds(60));

        if (config.getProperty("device.udid") != null && !config.getProperty("device.udid").isEmpty()) {
            options.setUdid(config.getProperty("device.udid"));
        }

        // Handle Activity Configuration
        String appPackage = config.getProperty("app.package");
        String appActivity = config.getProperty("app.activity");
        String appWaitActivity = config.getProperty("app.waitActivity");

        if (appPackage != null) options.setAppPackage(appPackage);
        if (appActivity != null) options.setAppActivity(appActivity);
        
        // Use wildcard or specific wait activity to prevent SplashActivity timeout
        if (appWaitActivity != null) {
            options.setAppWaitActivity(appWaitActivity);
        } else {
            options.setAppWaitActivity("*");
        }

        return new AndroidDriver(
                new URL(config.getProperty("appium.server.url")),
                options
        );
    }
}



