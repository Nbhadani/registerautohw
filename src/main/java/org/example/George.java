package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

    public class George {
        static protected WebDriver driver;

        //    TO ADD @BEFORE METHOD FOR OPEN BROWSER
        @Before
        public void openBrowser(){

            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        //    TO ADD @AFTER METHOD FOR OPEN BROWSER
        @After
        public void closeBrowser(){
            driver.quit();
        }

//   timestamp method for register email so we dnt have to keep changing the email in register page.

        public String timeStamp(){
            DateFormat dateFormat = new SimpleDateFormat( "ddmmyyhhmmss");
            Date date = new Date();
            return (dateFormat.format(date));
        }

        // reusable for click method

        public void clickOnElement(By by){
            driver.findElement(by).click();
        }

        // wait for clickable method
        public void waitForClickable(By by,int time){
            WebDriverWait wait = new WebDriverWait(driver,time);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }

        //    REUSABLE METHOD FOR SEND KEYS.

        public void enterText(By by,String text){
            driver.findElement(by).sendKeys(text);
        }


        @Test
        public void userShouldBeAbleToRegisterSuccessfully(  )

        {
            driver.get("https://direct.asda.com/");
            clickOnElement(By.linkText("Create account"));
//           WebDriverWait wait =new WebDriverWait(driver, 5);
//            waitForClickable(By.linkText("Create account"),5);

//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            enterText(By.id("dwfrm_profile_customer_email"),"johnsmith123@yahoo.com");
            enterText(By.id("dwfrm_profile_login_password"),"John12");
            clickOnElement(By.name("dwfrm_profile_register"));

        }

    }



