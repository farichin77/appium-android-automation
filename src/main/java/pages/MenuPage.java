package pages;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class MenuPage extends BasePage {

    private final By menuButton =
            AppiumBy.accessibilityId("View menu");
    private final By loginMenu =
            AppiumBy.accessibilityId("Login Menu Item");
    private final By logoutMenu =
            AppiumBy.accessibilityId("Logout Menu Item");

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    public void openMenu() {
        click(menuButton);
    }

    public void clickLoginMenu() {
        click(loginMenu);
    }

    public LoginPage goToLoginPage() {
        openMenu();
        clickLoginMenu();
        return new LoginPage(driver);
    }


    public boolean isLogoutVisible() {
        try {
            return waitFor(logoutMenu).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
