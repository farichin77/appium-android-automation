package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddToCartPage extends BasePage {
    //Locator tombol add to cart
    private final By addToCartButton = By.id("com.saucelabs.mydemoapp.android:id/cartBt");

    //locator Button + & -
    private final By incrementButton = By.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private final By decrementButton = By.id("com.saucelabs.mydemoapp.android:id/minusIV");

    //button cart sidebar
    private final By cartSidebarButton = By.id("com.saucelabs.mydemoapp.android:id/cartIV");

    //get counter cart sidebar
    private final By cartCounter = By.id("com.saucelabs.mydemoapp.android:id/cartTV");


    public AddToCartPage(AndroidDriver driver) {
        super(driver);
    }


    public AddToCartPage clickAddToCart() {
        scrollTo(addToCartButton);
        click(addToCartButton);
        return this;
    }

    //klik tombol +
    public void clickIncrement() {
        scrollTo(incrementButton);
        click(incrementButton);
    }

    //klik tombol -
    public void clickDecrement() {
        scrollTo(decrementButton);
        click(decrementButton);
    }

    //klik tombol cart sidebar
    public void clickCartSidebar() {
        click(cartSidebarButton);
    }
    //get cart counter
    public String getCartCounter () {
        return waitFor(cartCounter).getText();
    }
    //check add to cart button is disabled
    public boolean isAddToCartDisabled() {
        return !driver.findElement(addToCartButton).isEnabled();
    }

    //add product to cart and get counter
    public String addProductToCartAndGetCounter() {
        clickAddToCart();
        return getCartCounter();
    }
    //increment product and add to cart then get counter
    public String incrementProductAndAddToCart() {
        clickIncrement();
        clickAddToCart();
        return getCartCounter();
    }
    public AddToCartPage decrementProductAndAddToCart() {
        clickDecrement();
        clickAddToCart();
        return this;
    }

    // Klik icon cart sidebar → pindah ke MyCartPage
    public MyCartPage goToCartSidebar() {
        click(cartSidebarButton);
        return new MyCartPage(driver);
    }

}




