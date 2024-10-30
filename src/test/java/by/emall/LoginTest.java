package by.emall;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    WebDriver webdriver;
    LoginPage loginPage;

    @BeforeEach
    public void setup() {
        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webdriver.get("https://emall.by/login/password");

        loginPage = new LoginPage(webdriver);
    }

    @Test
    public void test1() {
        loginPage.clickButtonAcceptAllCookies();
        loginPage.clickButtonEnter();

        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED_THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageNoPhoneNumberNoPassword());
    }

    @Test
    public void test2() {
        loginPage.sendKeysInputPhoneNumber("255756476");
        loginPage.clickButtonAcceptAllCookies();
        loginPage.clickButtonEnter();

        Assertions.assertEquals(LoginMessage.THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageNoPassword());
    }

    @Test
    public void test3() {
        loginPage.sendKeysInputPassword("dcvcv");
        loginPage.clickButtonAcceptAllCookies();
        loginPage.clickButtonEnter();

        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED, loginPage.getErrorMessageNoPhoneNumber());
    }

    @Test
    public void test4() {
        loginPage.sendKeysInputPhoneNumber("255756476");
        loginPage.sendKeysInputPassword("dcvcv");
        loginPage.clickButtonAcceptAllCookies();
        loginPage.clickButtonEnter();

        Assertions.assertEquals(LoginMessage.INVALID_LOGIN_OR_PASSWORD, loginPage.getErrorMessageInvalidPhoneNumberOrPassword());
    }

    @AfterEach
    public void tearDown() {
        webdriver.quit();
    }
}
