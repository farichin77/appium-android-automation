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
        caps.setCapability("appium:app", config.getProperty("appPath"));
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:disableWindowAnimation", true);

        return new AndroidDriver(
                new URL(config.getProperty("appiumServer")),
                caps
        );
    }
}



