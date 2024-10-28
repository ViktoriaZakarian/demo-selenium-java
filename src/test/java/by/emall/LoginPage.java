package by.emall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

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

    public String getErrorMessageNoPhoneNumberNoPassword() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement errorMessageNoPhoneNumberNoPasswordWebElement = webDriver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_NO_PHONE_NUMBER_NO_PASSWORD_XPATH));
        return errorMessageNoPhoneNumberNoPasswordWebElement.getText();
    }

    public String getErrorMessageNoPhoneNumber() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement errorMessageNoPhoneNumberWebElement = webDriver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_NO_PHONE_NUMBER_XPATH));
        return errorMessageNoPhoneNumberWebElement.getText();
    }

    public String getErrorMessageNoPassword() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement errorMessageNoPasswordWebElement = webDriver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_NO_PASSWORD_XPATH));
        return errorMessageNoPasswordWebElement.getText();
    }

    public String getErrorMessageInvalidPhoneNumberOrPassword() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement errorMessageInvalidPhoneNumberOrPasswordWebElement = webDriver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_INVALID_PHONE_NUMBER_OR_PASSWORD_XPATH));
        return errorMessageInvalidPhoneNumberOrPasswordWebElement.getText();
    }

    public void clickButtonAcceptAllCookies() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement buttonAcceptAllCookiesWebElement = webDriver.findElement(By.xpath(LoginXpath.BUTTON_ACCEPT_ALL_COOKIES_XPATH));
        buttonAcceptAllCookiesWebElement.click();
    }
}
