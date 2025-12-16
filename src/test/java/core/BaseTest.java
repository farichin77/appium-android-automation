
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

    @AfterMethod
    public void resetApp() {
        driver.terminateApp(config.getProperty("appPackage"));
        driver.activateApp(config.getProperty("appPackage"));
    }

    protected void loginValid() {
        new MenuPage(driver)
                .goToLoginPage()
                .login(
                        config.getProperty("username"),
                        config.getProperty("password")
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
                "src/test/resources/config.properties"
        );
        config.load(fis);
    }
}

