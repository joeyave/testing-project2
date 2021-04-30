package org.unit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
    WebDriver driver;
    WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        if (!driver.getTitle().equals("JPetStore Demo")) {
            throw new IllegalStateException("This is not Welcome page" +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    @FindBy(linkText = "Proceed to Checkout")
    WebElement proceedButton;

    @FindBy(name = "updateCartQuantities")
    WebElement updateButton;

    @FindBy(linkText = "Remove")
    WebElement removeButton;

    @FindBy(linkText = "Return to Main Menu")
    WebElement returnToMenuButton;


    public SignInPage proceed() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton));
        proceedButton.click();
        return new SignInPage(driver);
    }

    public ShoppingCartPage remove() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
        return this;
    }

    public String emptyCartMessage() {
        return driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td/b")).getText();
    }

    public WelcomePage welcomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        returnToMenuButton.click();
        return new WelcomePage(driver);
    }

    public String getDescription() {
        return driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[3]")).getText();
    }

}
