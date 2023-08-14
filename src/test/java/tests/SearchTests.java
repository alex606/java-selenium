package tests;
import org.example.drivers.WebDriverConfig;
import org.example.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;


@SpringBootTest(classes = WebDriverConfig.class)
public class SearchTests {


    @Autowired
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }



    @Test
    public void testSearchTermReact() {
        driver.get("https://www.code-more.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 3 seconds timeout
        HomePage homePage = new HomePage(driver);
        homePage.clickSearchButton();
        homePage.enterSearchTerm("react");
        WebElement anchor = homePage.validateSearchLink("/blog/Use-react-to-track-scroll-position");
        Assert.assertNotNull(anchor);
    }


    @Test
    public void testBogusSearchTerm() {
        driver.get("https://www.code-more.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 3 seconds timeout
        HomePage homePage = new HomePage(driver);
        homePage.clickSearchButton();
        homePage.enterSearchTerm("bogus");
        int numberOfResults = homePage.countNumberSearchResults();
        assertEquals(0, numberOfResults);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.close();  // Close the current browser window
                driver.quit();   // Close all the windows and quit the browser
            } catch (Exception e) {
                System.out.println("Error while trying to close the browser: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}
