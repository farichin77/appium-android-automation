
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
        
        // 1. Load from file
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
        } catch (Exception e) {
            System.out.println("Warning: config.properties not found, reading system properties only.");
        }
        
        // 2. Override/Add with EVERY system property that starts with our prefixes
        System.getProperties().forEach((key, value) -> {
            String sKey = key.toString();
            if (sKey.startsWith("app") || 
                sKey.startsWith("platform") || 
                sKey.startsWith("device") || 
                sKey.equals("appium.server.url") ||
                sKey.contains("automationName")) {
                config.setProperty(sKey, value.toString());
            }
        });
    }
}

