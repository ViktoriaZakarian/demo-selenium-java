package com.netflix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://www.netflix.com/login");

        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void test1() {
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.INVALID_EMAIL, loginPage.getValidationMessageEmail());
        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getValidationMessagePassword());
    }

    @Test
    public void test2() {
        loginPage.sendKeysInputEmail("zakarianviktoria@gmail.com");
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getValidationMessagePassword());
    }

    @Test
    public void test3() {
        loginPage.sendKeysInputPassword("12345");
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.INVALID_EMAIL, loginPage.getValidationMessageEmail());
    }

    @Test
    public void test4() {
        loginPage.sendKeysInputEmail("zakarianviktoria@gmail.com");
        loginPage.sendKeysInputPassword("12345");
        loginPage.clickButtonEntrance();

        Assertions.assertEquals(LoginMessage.ERROR_MESSAGE, loginPage.getErrorMessage());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
