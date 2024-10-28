package com.netflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void test1() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickButtonEntrance();

        String actualEmail = loginPage.getValidationMessageEmail();
        String exceptedEmail = LoginMessage.INVALID_EMAIL;
        Assertions.assertEquals(exceptedEmail, actualEmail);

        String actualPassword = loginPage.getValidationMessagePassword();
        String exceptedPassword = LoginMessage.INVALID_PASSWORD;
        Assertions.assertEquals(actualPassword, exceptedPassword);
    }

    @Test
    public void test2(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.sendKeysInputEmail("zakarianviktoria@gmail.com");
        loginPage.clickButtonEntrance();

        String actualEmail = loginPage.getValidationMessagePassword();
        String exceptedPassword = LoginMessage.INVALID_PASSWORD;
        Assertions.assertEquals(exceptedPassword, actualEmail);
    }
}
