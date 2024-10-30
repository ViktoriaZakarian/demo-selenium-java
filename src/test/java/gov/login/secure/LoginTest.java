package gov.login.secure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    @Test
    public void test1() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        String buttonSignInXpath = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = webDriver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        WebElement emailAddressThisFieldIsRequiredWebElement = webDriver.findElement(By.xpath("/html/body/main/div/form/lg-validated-field/div/div"));
        String actualEmailAddress = emailAddressThisFieldIsRequiredWebElement.getText();
        Assertions.assertEquals("This field is required", actualEmailAddress);

        WebElement passwordThisFieldIsRequiredWebElement = webDriver.findElement(By.xpath("/html/body/main/div/form/lg-password-toggle/lg-validated-field/div/div"));
        String actualPassword = passwordThisFieldIsRequiredWebElement.getText();
        Assertions.assertEquals("This field is required", actualPassword);
    }

    @Test
    public void test2() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        String inputEmailXpath = "//input[@id='user_email']";
        By inputEmailBy = By.xpath(inputEmailXpath);
        WebElement inputEmailWebElement = webDriver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys("testA@test.com");

        String buttonSignInXpath = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = webDriver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        WebElement passwordThisFieldIsRequiredWebElement = webDriver.findElement(By.xpath("/html/body/main/div/form/lg-password-toggle/lg-validated-field/div/div"));
        String actualPassword = passwordThisFieldIsRequiredWebElement.getText();
        Assertions.assertEquals("This field is required", actualPassword);
    }

    @Test
    public void test3() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://secure.login.gov/");

        String inputPasswordXpath = "//input[@name='user[password]']";
        By inputPasswordBy = By.xpath(inputPasswordXpath);
        WebElement inputPasswordWebElement = webDriver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys("1q2w#E4r");

        String buttonSignInXpath = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = webDriver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        WebElement emailAddressThisFieldIsRequiredWebElement = webDriver.findElement(By.xpath("/html/body/main/div/form/lg-validated-field/div/div"));
        String actualEmailAddress = emailAddressThisFieldIsRequiredWebElement.getText();
        Assertions.assertEquals("This field is required", actualEmailAddress);
    }

    @Test
    public void test4() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        webDriver.get("https://secure.login.gov/");

        String inputEmailXpath = "//input[@id='user_email']";
        By inputEmailBy = By.xpath(inputEmailXpath);
        WebElement inputEmailWebElement = webDriver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys("testB@test.com");

        String inputPasswordXpath = "//input[@name='user[password]']";
        By inputPasswordBy = By.xpath(inputPasswordXpath);
        WebElement inputPasswordWebElement = webDriver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys("a1S@d3F$");

        String buttonSignInXpath = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = webDriver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        WebElement theEamailOrPasswordIsWrongWEbElement = webDriver.findElement(By.xpath("//div[@class='usa-alert__body']"));
        String actual = theEamailOrPasswordIsWrongWEbElement.getText();
        Assertions.assertEquals("The email or password you’ve entered is wrong. Try resetting your password.", actual);
    }
}
