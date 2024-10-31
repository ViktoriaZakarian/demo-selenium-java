package com.netflix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickButtonEntrance() {
        WebElement buttonEntranceWebElement = webDriver.findElement(By.xpath(LoginXpath.BUTTON_ENTRANCE_XPATH));
        buttonEntranceWebElement.click();
    }

    public void sendKeysInputEmail(String email) {
        WebElement inputEmailWebElement = webDriver.findElement(By.xpath(LoginXpath.INPUT_EMAIL_XPATH));
        inputEmailWebElement.sendKeys(email);
    }

    public void sendKeysInputPassword(String password) {
        WebElement inputPasswordWebElement = webDriver.findElement(By.xpath(LoginXpath.INPUT_PASSWORD_XPATH));
        inputPasswordWebElement.sendKeys(password);
    }

    public String getValidationMessageEmail() {
        WebElement validationMessageEmailWebElement = webDriver.findElement(By.xpath(LoginXpath.VALIDATION_MESSAGE_EMAIL));
        return validationMessageEmailWebElement.getText();
    }

    public String getValidationMessagePassword() {
        WebElement validationMessagePasswordWebElement = webDriver.findElement(By.xpath(LoginXpath.VALIDATION_MESSAGE_PASSWORD));
        return validationMessagePasswordWebElement.getText();
    }

    public String getErrorMessage() {
        WebElement errorMessageWebElement = webDriver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE));
        return errorMessageWebElement.getText();
    }
}
