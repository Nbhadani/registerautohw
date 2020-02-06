package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Amazon {
     static protected WebDriver driver;

        @Test
        public void userShouldBeAbleToRegisterSuccessfully() {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.get("https://www.amazon.co.uk/");
            driver.findElement(By.className("nav-line-2 nav-long-width")).click();
            driver.findElement(By.id("createAccountSubmit")).click();
           WebDriverWait wait = new WebDriverWait(driver, 50);
           wait.until(ExpectedConditions.elementToBeClickable(By.id("createAccountSubmit")));


        }

    }


