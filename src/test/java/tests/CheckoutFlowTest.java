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
            dataProviderClass = CheckoutDataProvider.class
    )
    public void checkoutSuccessTest(CheckoutData data) {

        loginValid();

        new ProductPage(driver)
                .openFirstProduct()
                .clickAddToCart()
                .goToCartSidebar();

        new MyCartPage(driver)
                .clickProcessToCheckout();

        new CheckoutPage(driver)
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

        String confirmationMessage =
                new PaymentPage(driver)
                        .enterPaymentInformation(
                                data.getFullName(),
                                data.getCardNumber(),
                                data.getExpirationDate(),
                                data.getSecurityCode()
                        )
                        .clickPlaceOrder()
                        .getCheckoutCompletePage();

        Assert.assertEquals(
                confirmationMessage,
                "Checkout Complete"
        );
    }
}


