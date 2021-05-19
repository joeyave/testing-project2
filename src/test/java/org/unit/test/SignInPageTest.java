package org.unit.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.unit.page.SignInPage;
import org.unit.page.WelcomePage;

public class SignInPageTest {
    private static final String url = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void signIn() {
        SignInPage sign = new SignInPage(driver);
        sign.signIn("Joseph", "1234");

        WelcomePage welcomePage = new WelcomePage(driver);
        String welcomeMessage = welcomePage.getWelcomeMessage();
        Assert.assertEquals("Welcome Jos!", welcomeMessage);
    }

    @After
    public void close() {
        driver.close();
    }
}
