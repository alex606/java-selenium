package tests;

import org.example.drivers.WebDriverConfig;
import org.example.pages.HomePage;
import org.example.pages.TagsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = WebDriverConfig.class)
public class PostTests extends  AbstractTestNGSpringContextTests{


    private WebDriver driver;


    @Autowired
    public PostTests(WebDriver driver) {
        this.driver = driver;
    }


    @BeforeEach
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    @Test
    public void firstPostLinkMatchesExpected() {
        driver.get("https://www.code-more.com");
        HomePage homePage = new HomePage(driver);
        String href = homePage.getFirstPostHref();
        homePage.clickFirstPostReadMore();
        String actualURL = driver.getCurrentUrl();
        String expectedURL =  href;
        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void firstTaggedPostFoundThroughTagsPage() {
        driver.get("https://www.code-more.com");
        HomePage homePage = new HomePage(driver);
        String tag = homePage.getFirstPostTag();
        String homePagePostLink = homePage.getFirstPostHref();
        homePage.clickNavBarTag();
        TagsPage tagsPage = new TagsPage(driver);
        tagsPage.clickTagByText(tag);
        String tagPagePostLink = tagsPage.getFirstPostHref();

        Assert.assertEquals(homePagePostLink,tagPagePostLink);


    }

}
