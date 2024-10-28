package by.emall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickButtonEnter() {
        WebElement buttonEnterWebElement = webDriver.findElement(By.xpath(LoginXpath.BUTTON_ENTER_XPATH));
        buttonEnterWebElement.click();
    }

    public void sendKeysInputPhoneNumber(String phoneNumber) {
        WebElement inputPhoneNumberWebElement = webDriver.findElement(By.xpath(LoginXpath.INPUT_PHONE_NUMBER_XPATH));
        inputPhoneNumberWebElement.sendKeys(phoneNumber);
    }

    public void sendKeysInputPassword(String password) {
        WebElement inputPasswordWebElement = webDriver.findElement(By.xpath(LoginXpath.INPUT_PASSWORD_XPATH));
        inputPasswordWebElement.sendKeys(password);
    }
}
