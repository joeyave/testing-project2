package org.unit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrentAnimalPage {
    WebDriver driver;
    WebDriverWait wait;

    public CurrentAnimalPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[3]")
    WebElement description;

    public String getName() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        return driver.findElement(By.tagName("h2")).getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public ShoppingCartPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"))).click();
        return new ShoppingCartPage(driver);
    }
}
