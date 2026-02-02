package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Properties;

public class DriverManager {

    public static AndroidDriver createDriver(Properties config) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", config.getProperty("platformName"));
        caps.setCapability("appium:platformVersion", config.getProperty("platformVersion"));
        caps.setCapability("appium:deviceName", config.getProperty("deviceName"));
        caps.setCapability("appium:automationName", config.getProperty("automationName"));
        caps.setCapability("appium:app", config.getProperty("app.path"));
        
        if (config.getProperty("device.udid") != null && !config.getProperty("device.udid").isEmpty()) {
            caps.setCapability("appium:udid", config.getProperty("device.udid"));
        }

        if (config.getProperty("app.activity") != null) {
            caps.setCapability("appium:appActivity", config.getProperty("app.activity"));
        }
        if (config.getProperty("app.waitActivity") != null) {
            caps.setCapability("appium:appWaitActivity", config.getProperty("app.waitActivity"));
        } else {
            // Default to wildcard to avoid SplashActivity timeout issues
            caps.setCapability("appium:appWaitActivity", "*");
        }

        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:disableWindowAnimation", true);

        return new AndroidDriver(
                new URL(config.getProperty("appium.server.url")),
                caps
        );
    }
}



