package org.example.pages;

import org.example.utilities.UIHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;


public class HomePage {


    private UIHelper uiHelper;
    private WebDriver driver;
    private WebDriverWait wait;
    private By usernameInput = By.id("username");
    private By searchButton = By.cssSelector("#flexWrapper > div:nth-child(1) > button");
    private By searchInput = By.cssSelector("#flexWrapper input");
    String URL = "code-more.com";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        uiHelper = new UIHelper(driver);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void enterSearchTerm(String term) {
        WebElement search =  uiHelper.waitForElementToBeClickable(searchInput);
        search.click();
        search.sendKeys(term);
        search.sendKeys(Keys.ENTER);
    }

    public WebElement validateSearchLink(String href) {
        return uiHelper.geAnchorByHref(href);
    }

    public int countNumberSearchResults() {
        List<WebElement> results = driver.findElements(By.cssSelector(".fixed ul.py-5"));
        return results.size();
    }

    public String getFirstPostTag() {
       WebElement firstTag =  driver.findElement(By.cssSelector("ul.flex.flex-row"));
       return firstTag.getText();
    }

    public void clickFirstPostReadMore() {
        uiHelper.waitForElementToBeClickable(By.cssSelector("#flexWrapper p.underline")).click();
    }

    public String getFirstPostHref() {
       WebElement readMore =  driver.findElement(By.cssSelector("#flexWrapper p.underline"));
       WebElement parentAnchor = readMore.findElement(By.xpath(".."));
       return parentAnchor.getAttribute("href");
    }


    public void clickNavBarTag() {
        driver.findElement(By.xpath("//*[@id='flexWrapper']/div[1]/div[1]/div[3]/a[3]")).click();
    }




}
