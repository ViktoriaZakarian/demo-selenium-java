package com.netflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void test1() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.INVALID_EMAIL, loginPage.getValidationMessageEmail());

        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getValidationMessagePassword());
    }

    @Test
    public void test2() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.sendKeysInputEmail("zakarianviktoria@gmail.com");
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getValidationMessagePassword());
    }

    @Test
    public void test3() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.sendKeysInputPassword("12345");
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.INVALID_EMAIL, loginPage.getValidationMessageEmail());
    }

    @Test
    public void test4() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/login");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.sendKeysInputEmail("zakarianviktoria@gmail.com");
        loginPage.sendKeysInputPassword("12345");
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.ERROR_MESSAGE, loginPage.getErrorMessage());
    }
}
