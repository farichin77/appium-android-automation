package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.MyCartPage;
import pages.ProductPage;


public class RemoveItemTest extends BaseTest {

    @Test(priority = 1 )
    public void removeItemFromCart() {
       loginValid();
        String noItemText = new ProductPage(driver)
                .openFirstProduct()
                .clickAddToCart()
                .goToCartSidebar()
                .clickRemoveItem()
                .getNoItemText();

        Assert.assertEquals(noItemText, "No Items", "Cart should be empty after removing the item!");
    }


    @Test(priority = 2 )
    public void verifyClickIncreament () {
        loginValid();
        String counter = new ProductPage(driver)
                .openFirstProduct()
                .clickAddToCart()
                .goToCartSidebar()
                .clickIncrement()
                .getQuantityCounter();
        Assert.assertEquals(counter, "2", "Cart counter harus bertambah menjadi 1");
    }

    @Test(priority = 3 )
    public void verifyClickDecrement () {
        loginValid();
        String noItemText = new ProductPage(driver)
                .openFirstProduct()
                .clickAddToCart()
                .goToCartSidebar()
                .clickDecrement()
                .getNoItemText();

        Assert.assertEquals(noItemText, "No Items", "Cart should be empty after removing the item!");
    }

}
