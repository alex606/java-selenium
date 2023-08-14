package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitUtils {

    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public ExpectedCondition<WebElement> elementIsClickable(By locator) {
        return driver -> {
            WebElement element = driver.findElement(locator);
            return element.isEnabled() ? element : null;
        };
    }
}