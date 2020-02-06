package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

    public class George {
        static protected WebDriver driver;

        @Test
        public void userShouldBeAbleToRegisterSuccessfully(  )
        {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.get("https://direct.asda.com/");
            driver.findElement(By.linkText("Create account")).click();
//            WebDriverWait wait =new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create account")));


//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            driver.findElement(By.id("dwfrm_profile_customer_email")).sendKeys("johnsmith123@yahoo.com");
            driver.findElement(By.id("dwfrm_profile_login_password")).sendKeys("John12");
            driver.findElement(By.name("dwfrm_profile_register")).click();

        }

    }



