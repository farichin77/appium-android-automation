package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {
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

    public CheckoutPage(AndroidDriver driver) {
        super(driver);
    }

    public CheckoutPage enterCekoutInformation(String fullName, String address1, String address2, String city, String state, String zip, String country) {
        inputFullName(fullName);
        inputAddressLine1(address1);
        inputAddressLine2(address2);
        inputCity(city);
        inputState(state);
        inputZip(zip);
        inputCountry(country);
        return this;
    }

    //input full name
    public CheckoutPage inputFullName(String fullName) {
        type(fullNameField, fullName);
        return this;
    }
    //input address line 1
    public CheckoutPage inputAddressLine1(String address1) {
        type(addressLine1, address1);
        return this;
    }
    //input address line 2
    public CheckoutPage inputAddressLine2(String address2) {
        type(addressLine2, address2);
        return this;
    }
    //input city
    public CheckoutPage inputCity(String city) {
        type(cityField, city);
        return this;
    }
    //input state
    public CheckoutPage inputState(String state) {
        type(stateField, state);
        return this;
    }
    //input zip
    public CheckoutPage inputZip(String zip) {
        type(zipField, zip);
        return this;
    }
    //input country
    public CheckoutPage inputCountry(String country) {
        type(countryField, country);
        return this;
    }
    //klik to payment button
    public PaymentPage clickToPayment() {
        click(toPaymentButton);
        return new PaymentPage(driver);
    }
}
