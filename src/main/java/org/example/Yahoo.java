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

public class Yahoo {
    static protected WebDriver driver;

    // Reuasable method for open browser @before

    @Before
     public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    }

    //    TO ADD @AFTER METHOD FOR CLOSE BROWSER
    @After
    public void closeBrowser(){
      //  driver.quit();
    }
    // reusable for click method

          public void clickOnElement(By by) {driver.findElement(by).click();
    }

    // Wait for clickable method

    public void waitForClickable(By by,int time){
    WebDriverWait wait = new WebDriverWait(driver,time);
    wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //   Timestamp method for register email so we dnt have to keep changing the email in register page.
        public String timeStamp(){
        DateFormat dateFormat = new SimpleDateFormat( "ddmmyyhhmmss");
        Date date = new Date();
        return (dateFormat.format(date));
    }
    //    REUSABLE METHOD FOR SEND KEYS.

    public void enterText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    @Test
    public void userShouldBeAbleToRegisterSuccessfully(  )
    {

        driver.get("https://login.yahoo.com/");
        clickOnElement(By.id("createacc"));
//        WebDriverWait wait =new WebDriverWait(driver, 10);
//        waitForClickable(By.id("createacc"),10) ;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        enterText(By.id("usernamereg-firstName"),"John");
        enterText(By.id("usernamereg-lastName"),"Smith");
       enterText(By.id("usernamereg-yid"),"johnsmith124"+timeStamp());
       enterText(By.id("usernamereg-password"),"J12");
        enterText(By.id("usernamereg-phone"),"07594533766");
        clickOnElement(By.id("reg-submit-button"));

    }

}
