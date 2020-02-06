package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Ebay {
    static protected WebDriver driver;

    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.ebay.co.uk/");
        driver.findElement(By.linkText("register")).click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.findElement(By.id("firstname")).sendKeys("John");
            driver.findElement(By.id("lastname")).sendKeys("Smith");
            driver.findElement(By.id("email")).sendKeys("johnsmith124@test.com");
            driver.findElement(By.id("PASSWORD")).sendKeys("J12");
            driver.findElement(By.id("Register")).click();

    }

}
