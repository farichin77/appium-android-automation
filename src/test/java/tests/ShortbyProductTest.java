package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ShortbyProductTest extends BaseTest {

    @Test
    public void shortByNameAscending() {
        ProductPage productPage = new ProductPage(driver);

        productPage
                .clickSortButton()
                .sortByProductNameAscending();

        Assert.assertEquals(
                productPage.getBackpackTitle(),
                "Sauce Labs Backpack",
                "First product should be Sauce Labs Backpack"
        );
    }
    @Test
    public void shortByNameDescending() {
        ProductPage productPage = new ProductPage(driver);

        productPage
                .clickSortButton()
                .sortByProductNameDescending();

        Assert.assertEquals(
                productPage.getFirstProductNameDescending(),
                "Test.allTheThings() T-Shirt (yellow)",
                "First product should be Test.allTheThings() T-Shirt (Red)"
        );
    }
    @Test
    public void shortByPriceAscending() {
        ProductPage productPage = new ProductPage(driver);
        productPage
                .clickSortButton()
                .sortByProductPriceAscending();
        Assert.assertEquals(
                productPage.getFirstProductPriceAscending(),
                "$ 7.99",
                "First product should be $7.99"
        );
    }
    @Test
    public void shortByPriceDescending() {
        ProductPage productPage = new ProductPage(driver);
        productPage
                .clickSortButton()
                .sortByProductPriceDescending();
        Assert.assertEquals(
                productPage.getFirstProductPriceDescending(),
                "$ 49.99",
                "First product should be $49.99"
        );
    }
}
