package org.unit.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.unit.page.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {
    private static final String url = "https://petstore.octoperf.com/actions/Account.action?newAccountForm=";
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }


    @Test
    public void positiveTesting() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.userInformationTesting("Mike", "1234", " 1234").positiveAccountInformation().profileInformationTesting();
    }

    @Test
    public void negativeTesting() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.negativeUserInformation().negativeAccountInformation().profileInformationTesting();
    }

    @After
    public void close() {
        driver.close();
    }
}
