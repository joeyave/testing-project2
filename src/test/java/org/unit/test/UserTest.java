package org.unit.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.unit.page.*;

public class UserTest {
    private static final String url = "https://petstore.octoperf.com/actions/Catalog.action";
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void addFishToACartNotSignedIn() {
        WelcomePage welcomePage = new WelcomePage(driver);
        AnimalPage fish = welcomePage.selectAnimal(1);
        CurrentAnimalPage currentFish = fish.selectAnimal();
        ShoppingCartPage shoppingCartPage = currentFish.addToCart();
        SignInPage sign = shoppingCartPage.proceed();
        Assert.assertEquals("You must sign on before attempting to check out. Please sign on and try checking out again.", sign.getMessage());
    }

    @Test
    public void addDogToACartSignedIn() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.signInLink().signIn("Joseph", "1234");
        CurrentAnimalPage dog = welcomePage.selectAnimal(2).selectAnimal();
        String dogDescription = dog.getDescription();
        ShoppingCartPage shoppingCart = dog.addToCart();
        Assert.assertEquals(shoppingCart.getDescription(), dogDescription);
    }

    @Test
    public void removeAnimal() {
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertEquals("Your cart is empty.", welcomePage.selectAnimal(3).selectAnimal().addToCart().remove().emptyCartMessage());
    }

    @Test
    public void signOut() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.signInLink().signIn("Joseph", "1234");
        String welcomeMessage = welcomePage.getWelcomeMessage();
        Assert.assertEquals("Welcome Jos!", welcomeMessage);
        String welcomeMessageSignedOut = welcomePage.signOutLink().getWelcomeMessage();
        Assert.assertEquals("", welcomeMessageSignedOut);
    }

    @After
    public void close() {
        driver.close();
    }
}
