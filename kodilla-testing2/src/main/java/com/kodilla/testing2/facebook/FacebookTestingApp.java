package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    private final static String ALLOWCOOKIES = "//div[contains(@class, \"4-i2 _pig\")]/div[3]/button[2]";
    private final static String CREATEACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    private final static String XPATH_WAIT1 = "firstname";
    private final static String XPATH_WAIT2 = "reg_email_confirmation__";
    private final static String SEXINPUT = "//input[@name = \"sex\" and @value = \"2\"]";
    private final static WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);

    public static void main(String[] args) {

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath(ALLOWCOOKIES)).click();
        driver.findElement(By.xpath(CREATEACCOUNT)).click();

        waitForDisplay(XPATH_WAIT1);

        driver.findElement(By.name("firstname")).sendKeys("FirstName");
        driver.findElement(By.name("lastname")).sendKeys("LastName");
        driver.findElement(By.name("reg_email__")).sendKeys("email@email.com");

        waitForDisplay(XPATH_WAIT2);

        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("email@email.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("WhoWillKnowThat");

        selectByName("birthday_day").selectByValue("27");
        selectByName("birthday_month").selectByValue("10");
        selectByName("birthday_year").selectByValue("1998");

        driver.findElement(By.xpath(SEXINPUT)).click();


    }

    public static Select selectByName(String name){
        WebElement selectedElement = driver.findElement(By.name(name));
        return new Select(selectedElement);
    }

    public static void waitForDisplay(String elementName){
        try {
            driver.findElement(By.name(elementName)).isDisplayed();
        } catch (NoSuchElementException e) {
            waitForDisplay(elementName);
        }
    }

}
