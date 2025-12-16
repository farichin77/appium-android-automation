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

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    // Klik product pertama
    public AddToCartPage openFirstProduct() {
        click(firstProductImage);
        return new AddToCartPage(driver);
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
