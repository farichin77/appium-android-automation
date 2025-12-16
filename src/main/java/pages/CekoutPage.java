package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CekoutPage extends BasePage {
    //locator full name input field
    private final By fullNameField = By.id("com.saucelabs.mydemoapp.android:id/fullNameET");

    //locator adress input field
    private final By addressLine1= By.id("com.saucelabs.mydemoapp.android:id/address1ET");
    private final By addressLine2= By.id("com.saucelabs.mydemoapp.android:id/address2ET");

    //city, state, zip, country input field
    private final By cityField = By.id("com.saucelabs.mydemoapp.android:id/cityET");
    private final By stateField = By.id("com.saucelabs.mydemoapp.android:id/stateET");
    private final By zipField = By.id("com.saucelabs.mydemoapp.android:id/zipET");
    private final By countryField = By.id("com.saucelabs.mydemoapp.android:id/countryET");

    //to payment button
    private final By toPaymentButton = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    public CekoutPage(AndroidDriver driver) {
        super(driver);
    }

    //input full name
    public void inputFullName(String fullName) {
        type(fullNameField, fullName);
    }
    //input address line 1
    public void inputAddressLine1(String address1) {
        type(addressLine1, address1);
    }
    //input address line 2
    public void inputAddressLine2(String address2) {
        type(addressLine2, address2);
    }
    //input city
    public void inputCity(String city) {
        type(cityField, city);
    }
    //input state
    public void inputState(String state) {
        type(stateField, state);
    }
    //input zip
    public void inputZip(String zip) {
        type(zipField, zip);
    }
    //input country
    public void inputCountry(String country) {
        type(countryField, country);
    }
    //klik to payment button
    public void clickToPayment() {
        click(toPaymentButton);
    }
}
