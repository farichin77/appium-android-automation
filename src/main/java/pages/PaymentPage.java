package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    //locator full name input field
    private final By nameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");

    //locator card number input field
    private final By cardNumberField = By.id("com.saucelabs.mydemoapp.android:id/cardNumberET");

    //locator expiry date input field
    private final By expiryDateField = By.id("com.saucelabs.mydemoapp.android:id/expirationDateET");

    //locator cvv input field
    private final By cvvField = By.id("com.saucelabs.mydemoapp.android:id/securityCodeET");

    //locator pay now review order button
    private final By reviewOrder = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    //locator place order button
    private final By placeOrderButton = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    // checkout complete page
    private final By checkoutCompletePage = By.id("com.saucelabs.mydemoapp.android:id/completeTV");


    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public PaymentPage enterPaymentInformation(String fullName, String cardNumber, String expirationDate, String securityCode) {
        inputName(fullName);
        inputCardNumber(cardNumber);
        inputExpiryDate(expirationDate);
        inputCvv(securityCode);
        return this;
    }

    //input name
    public PaymentPage inputName(String name) {
        type(nameField, name);
        return this;
    }
    //input card number
    public PaymentPage inputCardNumber(String cardNumber) {
        type(cardNumberField, cardNumber);
        return this;
    }
    //input expiry date
    public PaymentPage inputExpiryDate(String expiryDate) {
        type(expiryDateField, expiryDate);
        return this;
    }
    //input cvv
    public PaymentPage inputCvv(String cvv) {
        type(cvvField, cvv);
        return this;
    }
    //klik pay now review order button
    public PaymentPage clickReviewOrder() {
        click(reviewOrder);
        return this;
    }
    //klik place order button
    public PaymentPage clickPlaceOrder() {
        click(placeOrderButton);
        return this;
    }
    //get checkout complete page
    public String getCheckoutCompletePage() {
        return waitFor(checkoutCompletePage).getText();
    }

}
