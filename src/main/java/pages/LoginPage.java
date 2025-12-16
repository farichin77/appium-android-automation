package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By passwordField = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By loginButton = By.id("com.saucelabs.mydemoapp.android:id/loginBtn");
    private final By errorMessage = By.id("com.saucelabs.mydemoapp.android:id/loginErrorTV");
    private final By lockedOutErrorMessage = By.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void login(String username , String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public String getLockedOutErrorMessage() {
        return waitFor(lockedOutErrorMessage).getText();
    }

    public String getErrorMessage() {
        return waitFor(errorMessage).getText();
    }
}
