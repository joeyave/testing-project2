package org.unit.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.unit.page.RegistrationPage;

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
        registrationPage.userInformationTesting("Joseph12", "1234", "1234").positiveAccountInformation().profileInformationTesting();
        Assert.assertNotEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void negativeTesting() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.negativeUserInformation().negativeAccountInformation().profileInformationTesting();
        Assert.assertEquals(registrationPage.exceptionHeader.getText(), "HTTP Status 500 – Internal Server Error");
    }

    @After
    public void close() {
        driver.close();
    }
}
