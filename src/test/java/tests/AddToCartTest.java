package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test(priority = 1)
    public void addToCart() {
        loginValid();
        String counter = new ProductPage(driver)
                .openFirstProduct()
                .addProductToCartAndGetCounter();
        Assert.assertEquals(counter, "1", "Cart counter harus bertambah menjadi 1");
    }

    @Test(priority = 2)
    public void encreamentProduct() {
        loginValid();
        String counter = new ProductPage(driver)
                .openFirstProduct()
                .incrementProductAndAddToCart();

        Assert.assertEquals(counter, "2", "Cart counter harus bertambah menjadi 2");
    }
    @Test(priority = 3)
    public void decrementProduct() {
        loginValid();

        AddToCartPage addToCartPage = new ProductPage(driver)
                .openFirstProduct()
                .decrementProductAndAddToCart();

        Assert.assertTrue(addToCartPage.isAddToCartDisabled(),
                "Add to Cart button should be disabled when quantity is zero!");
    }


}
