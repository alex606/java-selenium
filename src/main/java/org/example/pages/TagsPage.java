package org.example.pages;
import org.example.utilities.UIHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
public class TagsPage {

    private UIHelper uiHelper;
    WebDriver driver;


    public TagsPage(WebDriver driver) {
        this.driver = driver;
        this.uiHelper = new UIHelper(this.driver);
    }

    public String getFirstPostHref() {
        WebElement postPreviewDiv =  driver.findElement(By.cssSelector(".col-start-2"));
        WebElement anchor = postPreviewDiv.findElement(By.cssSelector("a"));
        return anchor.getAttribute("href");
    }


    public void clickTagByText(String tagText) {
        String split = "";
        List<WebElement> listItems = driver.findElements(By.xpath("//*[@id='flexWrapper']/div[1]/div[2]/ul/li/a"));
        for (WebElement listItem : listItems) {
            String text = listItem.getText();
            System.out.println(text);
            split = text.split(" ")[0];
            if (split.equals(tagText)) {
                listItem.click();
                break;
            }
        }
    }
}
