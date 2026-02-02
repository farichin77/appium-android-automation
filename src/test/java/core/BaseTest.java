
package core;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import pages.MenuPage;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected static AndroidDriver driver;
    protected static Properties config;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        loadConfig();
        driver = DriverManager.createDriver(config);
    }

    @BeforeMethod
    public void resetApp() {
        driver.terminateApp(config.getProperty("app.package"));
        driver.activateApp(config.getProperty("app.package"));
    }

    protected void loginValid() {
        new MenuPage(driver)
                .goToLoginPage()
                .login(
                        config.getProperty("valid.username"),
                        config.getProperty("valid.password")
                );
    }



    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void loadConfig() throws Exception {
        config = new Properties();
        FileInputStream fis = new FileInputStream(
                "config.properties"
        );
        config.load(fis);
        
        // Override with system properties if provided
        for (String key : config.stringPropertyNames()) {
            String systemValue = System.getProperty(key);
            if (systemValue != null) {
                config.setProperty(key, systemValue);
            }
        }
    }
}

