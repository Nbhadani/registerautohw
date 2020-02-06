package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Yahoo {
    static protected WebDriver driver;

    @Test
    public void userShouldBeAbleToRegisterSuccessfully(  )
    {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.get("https://login.yahoo.com/");
        driver.findElement(By.id("createacc")).click();
        WebDriverWait wait =new WebDriverWait(driver, 50);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("usernamereg-firstName")).sendKeys("John");
        driver.findElement(By.id("usernamereg-lastName")).sendKeys("Smith");
        driver.findElement(By.id("usernamereg-yid")).sendKeys("johnsmith124");
        driver.findElement(By.id("usernamereg-password")).sendKeys("J12");
        driver.findElement(By.id("usernamereg-phone")).sendKeys("7594533799");
        driver.findElement(By.id("reg-submit-button")).click();

    }

}
