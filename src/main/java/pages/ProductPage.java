package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    // Locator pertama product image
    private final By firstProductImage = By.xpath("(//android.widget.ImageView[@content-desc='Product Image'])[1]");

    // Locator untuk product title & price di detail page
    private final By backpackTitle = By.xpath("//android.widget.TextView[@content-desc='Product Title' and @text='Sauce Labs Backpack']");

    // Sorting Locators
    private final By sortButton = By.id("com.saucelabs.mydemoapp.android:id/sortIV");
    private final By nameAscending = By.xpath("//android.widget.TextView[@text='Name - Ascending']");
    private final By nameDescending = By.xpath("//android.widget.TextView[@text='Name - Descending']");
    private final By priceAscending = By.xpath("//android.widget.TextView[@text='Price - Ascending']");
    private final By priceDescending = By.xpath("//android.widget.TextView[@text='Price - Descending']");
    private final By productTitle = By.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private final By productPrice = By.id("com.saucelabs.mydemoapp.android:id/priceTV");

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    // Klik product pertama
    public AddToCartPage openFirstProduct() {
        click(firstProductImage);
        return new AddToCartPage(driver);
    }

    // Sorting methods
    public ProductPage clickSortButton() {
        click(sortButton);
        return this;
    }

    public ProductPage sortByProductNameAscending() {
        click(nameAscending);
        return this;
    }

    public ProductPage sortByProductNameDescending() {
        click(nameDescending);
        return this;
    }

    public ProductPage sortByProductPriceAscending() {
        click(priceAscending);
        return this;
    }

    public ProductPage sortByProductPriceDescending() {
        click(priceDescending);
        return this;
    }

    public String getFirstProductNameDescending() {
        return getText(productTitle);
    }

    public String getFirstProductPriceAscending() {
        return getText(productPrice);
    }

    public String getFirstProductPriceDescending() {
        return getText(productPrice);
    }

    // Validasi apakah backpack muncul
    public boolean isBackpackVisible() {
        return waitFor(backpackTitle).isDisplayed();
    }

    // Ambil title backpack
    public String getBackpackTitle() {
        return getText(backpackTitle);
    }


}
