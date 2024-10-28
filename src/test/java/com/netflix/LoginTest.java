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
    public void test2() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.sendKeysInputEmail("zakarianviktoria@gmail.com");
        loginPage.clickButtonEntrance();

        String actualPassword = loginPage.getValidationMessagePassword();
        String exceptedPassword = LoginMessage.INVALID_PASSWORD;
        Assertions.assertEquals(exceptedPassword, actualPassword);
    }

    @Test
    public void test3() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.sendKeysInputPassword("12345");
        loginPage.clickButtonEntrance();

        String actualEmail = loginPage.getValidationMessageEmail();
        String exceptedEmail = LoginMessage.INVALID_EMAIL;
        Assertions.assertEquals(exceptedEmail, actualEmail);
    }

    @Test
    public void test4() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.sendKeysInputEmail("zakarianviktoria@gmail.com");
        loginPage.sendKeysInputPassword("12345");
        loginPage.clickButtonEntrance();

        String actualMessage = loginPage.getErrorMessage();
        String exceptedMessage = LoginMessage.ERROR_MESSAGE;
        Assertions.assertEquals(exceptedMessage, actualMessage);
    }
}
