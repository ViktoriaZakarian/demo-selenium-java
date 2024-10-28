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
}
