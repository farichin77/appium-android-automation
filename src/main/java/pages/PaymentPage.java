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

    //input name
    public void inputName(String name) {
        type(nameField, name);
    }
    //input card number
    public void inputCardNumber(String cardNumber) {
        type(cardNumberField, cardNumber);
    }
    //input expiry date
    public void inputExpiryDate(String expiryDate) {
        type(expiryDateField, expiryDate);
    }
    //input cvv
    public void inputCvv(String cvv) {
        type(cvvField, cvv);
    }
    //klik pay now review order button
    public void clickReviewOrder() {
        click(reviewOrder);
    }
    //klik place order button
    public void clickPlaceOrder() {
        click(placeOrderButton);
    }
    //get checkout complete page
    public String getCheckoutCompletePage() {
        return waitFor(checkoutCompletePage).getText();
    }

}
