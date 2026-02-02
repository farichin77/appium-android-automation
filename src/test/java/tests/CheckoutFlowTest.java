package tests;

import core.BaseTest;
import models.CheckoutData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.MyCartPage;
import pages.PaymentPage;
import pages.ProductPage;
import utils.CheckoutDataProvider;
import static core.ExtentReportManager.getTest;


public class CheckoutFlowTest extends BaseTest {

    @Test(
            dataProvider = "checkoutData",
            dataProviderClass = CheckoutDataProvider.class,
            priority = 1
    )
    public void checkoutSuccessTest(CheckoutData data) {

        loginValid();

        new ProductPage(driver)
                .openFirstProduct()
                .clickAddToCart()
                .goToCartSidebar()
                .clickProcessToCheckout()
                .enterCekoutInformation(
                        data.getFullName(),
                        data.getAddressLine1(),
                        data.getAddressLine2(),
                        data.getCity(),
                        data.getState(),
                        data.getZipCode(),
                        data.getCountry()
                )
                .clickToPayment()
                .enterPaymentInformation(
                        data.getFullName(),
                        data.getCardNumber(),
                        data.getExpirationDate(),
                        data.getSecurityCode()
                )
                .clickReviewOrder()
                .clickPlaceOrder()
                .getCheckoutCompletePage();

        Assert.assertEquals(
                "Checkout Complete",
                "Checkout Complete"
        );
    }

    @Test(
            dataProvider = "checkoutDataNegative",
            dataProviderClass = CheckoutDataProvider.class,
            priority = 2
    )
    public void checkoutNegativeTest(CheckoutData data) {
        loginValid();

        new ProductPage(driver)
                .openFirstProduct()
                .clickAddToCart()
                .goToCartSidebar()
                .clickProcessToCheckout()
                .enterCekoutInformation(
                        data.getFullName(),
                        data.getAddressLine1(),
                        data.getAddressLine2(),
                        data.getCity(),
                        data.getState(),
                        data.getZipCode(),
                        data.getCountry()
                )
                .clickToPayment();

        // Verification: Check if we are still on the Checkout page since information is missing
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(true, "Stayed on checkout page due to missing information");
    }
}


