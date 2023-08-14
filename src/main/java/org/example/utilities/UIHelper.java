package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIHelper {


    private WebDriver driver;
    private WebDriverWait wait;
    public UIHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    public WebElement waitForElementToBeClickable(By locator) {
        try {
            wait.until(driver -> {
                WebElement element = driver.findElement(locator);
                return element.isDisplayed() && element.isEnabled();
            });
            return driver.findElement(locator);
        } catch (TimeoutException ex) {
            throw new RuntimeException("Element with locator: " + locator + " was not clickable after the timeout");
        }
    }

    public WebElement geAnchorByHref(String href) {
        return driver.findElement(By.cssSelector("a[href='" + href + "']"));
    }

}
