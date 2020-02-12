package org.example;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static javax.print.attribute.standard.MediaSizeName.C;

    public class bloomandwild {

        static protected WebDriver driver;

        //    TO ADD @BEFORE METHOD FOR OPEN BROWSER
        @Before
        public void openBrowser() {

            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        //    TO ADD @AFTER METHOD FOR CLOSE BROWSER

        @After
        public void closeBrowser() {
            driver.quit();

        }
//   timestamp method for register email so we dnt have to keep changing the email in register page.

        public String timeStamp() {
            DateFormat dateFormat = new SimpleDateFormat("ddmmyyhhmmss");
            Date date = new Date();
            return (dateFormat.format(date));
        }


            public void waitForClickable(By by, int time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(by));

            @Test
                public void userShouldBeAbleToRegisterSuccessfully() {
                System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.get("https://www.facebook.com/");
            }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                driver.findElement(By.name("firstname")).sendKeys("John");
                driver.findElement(By.name("lastname")).sendKeys("Smith");
                driver.findElement(By.name("reg_email__")).sendKeys("johnsmith124@test.com");
                driver.findElement(By.name("reg_email_confirmation__")).sendKeys("johnsmith124@test.com");
                driver.findElement(By.name("reg_passwd__")).sendKeys("John123");

                // Dropdown by Index
                WebElement date_dd = driver.findElement(By.name("birthday_day"));
                Select date_dropdown = new Select(date_dd);
                date_dropdown.selectByIndex(3);

                // Dropdown by Value
                WebElement month_dd = driver.findElement(By.name("birthday_month"));
                Select month_dropdown = new Select(month_dd);
                month_dropdown.selectByValue("9");

                // Dropdown by VisibleText
                WebElement year_dd = driver.findElement(By.name("birthday_year"));
                Select year_dropdown = new Select(year_dd);
                year_dropdown.selectByVisibleText("1985");


                /* Select the sex Radio btn */
                WebElement sex_radiobtn = driver.findElement(By.id("u_0_9"));
                sex_radiobtn.click();
                waitForClickable(By.id("u_0_9"), 10);

                // Submit the form
                driver.findElement(By.name("websubmit")).click();

                String expected = "Enter the code from your email";
                String Actual = driver.findElement(By.className("uiHeaderTitle")).getText();
                Assert.assertEquals("Test case Failed", expected, Actual);


            }

        }


