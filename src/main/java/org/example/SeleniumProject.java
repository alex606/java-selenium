package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class SeleniumProject {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(SeleniumProject.class);

    }
}