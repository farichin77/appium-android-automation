package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitFor(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitFor(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitFor(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitFor(locator).getText();
    }

    //scroll Down
    protected void scrollDown() {
        Dimension size = driver.manage().window().getSize();

        driver.executeScript("mobile: scrollGesture", Map.of(
                "left", size.width / 2,
                "top", size.height / 4,
                "width", 1,
                "height", size.height / 2,
                "direction", "down",
                "percent", 0.8
        ));
    }

    // Scroll sampe locator ketemu
    protected void scrollTo(By locator) {
        int maxScroll = 5;

        for (int i = 0; i < maxScroll; i++) {
            if (!driver.findElements(locator).isEmpty()) {
                return;
            }
            scrollDown();
        }
        throw new RuntimeException("Element not found after scrolling");
    }
}
