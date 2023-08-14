package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class StartChromeDriver {

    public StartChromeDriver(WebDriver driver) throws InterruptedException {
        driver.get("https://www.google.com");

        Thread.sleep(5000);
    }
}
