package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MyCartPage extends BasePage {

    //locator remove item button
    private final By removeItemButton = By.id("com.saucelabs.mydemoapp.android:id/removeBt");

    //locator process to cekout button
    private final By processToCheckoutButton = By.id("com.saucelabs.mydemoapp.android:id/cartBt");

    //locator increment and decreament button
    private final By incrementButton = By.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private final By decrementButton = By.id("com.saucelabs.mydemoapp.android:id/minusIV");

    //get counter cart sidebar
    private final By cartCounter = By.id("com.saucelabs.mydemoapp.android:id/cartTV");

    //locator no item text
     private final By noItemText = By.id("com.saucelabs.mydemoapp.android:id/noItemTitleTV");

    public MyCartPage(AndroidDriver driver) {
        super(driver);
    }


    //klik tombol remove item
    public MyCartPage clickRemoveItem() {
        click(removeItemButton);
        return this;
    }
    //klik tombol process to checkout
    public CheckoutPage clickProcessToCheckout() {
        click(processToCheckoutButton);
        return new CheckoutPage(driver);
    }
    //klik tombol +
    public MyCartPage clickIncrement() {
        click(incrementButton);
        return this; // kembalikan object untuk chaining
    }

    //klik tombol -
    public MyCartPage clickDecrement() {
        click(decrementButton);
        return this;
    }
    //get cart counter
    public String getQuantityCounter () {
        return waitFor(cartCounter).getText();
    }
    //get no item text
    public String getNoItemText() {
        return waitFor(noItemText).getText();
    }

}
