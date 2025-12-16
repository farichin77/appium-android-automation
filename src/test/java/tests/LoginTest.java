package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void loginInvalidCredential() {

        new MenuPage(driver)
                .goToLoginPage()
                .login("alice@example.com", "wrongpassword");

            LoginPage loginPage = new LoginPage(driver);
            String error = loginPage.getLockedOutErrorMessage();

            Assert.assertEquals(error, "Sorry this user has been locked out.");
        }

    @Test(priority = 2)
    public void loginValidCredential() {
        loginValid();

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isBackpackVisible(), "Backpack title should be visible");

        String title = productPage.getBackpackTitle();
        Assert.assertEquals(title, "Sauce Labs Backpack", "Product title should match 'Sauce Labs Backpack'");
    }
}

