package by.emall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void test1() {
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("https://emall.by/login/password");

        LoginPage loginPage = new LoginPage(webdriver);
        loginPage.clickButtonEnter();

        Assertions.assertEquals(LoginMessage.ERROR_MESSAGE_NO_PHONE_NUMBER_NO_PASSWORD, loginPage.getErrorMessageNoPhoneNumberNoPassword());
    }

    @Test
    public void test2() {
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("https://emall.by/login/password");

        LoginPage loginPage = new LoginPage(webdriver);
        loginPage.sendKeysInputPhoneNumber("255756476");
        loginPage.clickButtonEnter();

        Assertions.assertEquals(LoginMessage.ERROR_MESSAGE_NO_PASSWORD, loginPage.getErrorMessageNoPassword());
    }
}
