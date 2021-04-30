package org.unit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    WebDriver driver;
    WebDriverWait wait;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
        if (!driver.getTitle().equals("JPetStore Demo")) {
            throw new IllegalStateException("This is not Welcome page" +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public AnimalPage selectAnimal(Integer animal) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SidebarContent\"]/a[" + animal + "]")));
        driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[" + animal + "]")).click();
        return new AnimalPage(driver);
    }

    @FindBy(linkText = "Sign In")
    WebElement signInRef;

    @FindBy(linkText = "Sign Out")
    WebElement signOutRef;

    public SignInPage signInLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signInRef)).click();
        return new SignInPage(driver);
    }

    public WelcomePage signOutLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signOutRef)).click();
        return this;
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.id("WelcomeContent")).getText();
    }


}
