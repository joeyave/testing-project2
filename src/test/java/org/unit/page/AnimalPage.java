package org.unit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnimalPage {

    WebDriver driver;
    public AnimalPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

        if(!driver.getTitle().equals("JPetStore Demo")){
            throw new IllegalStateException("This is not Animal breed page" +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public String getName(){
        return driver.findElement(By.tagName("h2")).getText();
    }


    public String getCurrentAnimalName(){
        return driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2")).getText();
    }

    public CurrentAnimalPage selectAnimal(){
        driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
        return new CurrentAnimalPage(driver);
    }

}
