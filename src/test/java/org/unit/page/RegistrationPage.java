package org.unit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    private WebDriver driver;

    //User information
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "repeatedPassword")
    private WebElement repeatedPassword;

    //Account information
    @FindBy(name = "account.firstName")
    private WebElement firstName;
    @FindBy(name = "account.lastName")
    private WebElement lastName;
    @FindBy(name = "account.email")
    private WebElement email;
    @FindBy(name = "account.phone")
    private WebElement phone;
    @FindBy(name = "account.address1")
    private WebElement address1;
    @FindBy(name = "account.address2")
    private WebElement address2;
    @FindBy(name = "account.city")
    private WebElement city;
    @FindBy(name = "account.state")
    private WebElement state;
    @FindBy(name = "account.zip")
    private WebElement zip;
    @FindBy(name = "account.country")
    private WebElement country;

    //Profile information
    @FindBy(name = "account.languagePreference")
    private WebElement languagePreference;
    @FindBy(name = "account.favouriteCategoryId")
    private WebElement accountFavouriteCategoryId;
    @FindBy(name = "account.listOption")
    private WebElement myListCheckBox;
    @FindBy(name = "account.bannerOption")
    private WebElement myBannerCheckBox;
    @FindBy(name = "newAccount")
    private WebElement saveAccButton;

    @FindBy(xpath = "/html/body/h1")
    public WebElement exceptionHeader;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage userInformationTesting(String username, String password, String repeatedTest) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.repeatedPassword.sendKeys(repeatedTest);
        return this;
    }

    public RegistrationPage accountInformationTesting(String firstName, String lastName, String email, String phone, String address1, String address2, String city, String state, String zip, String country) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);
        this.country.sendKeys(country);
        return this;
    }

    public RegistrationPage positiveUserInformation() {
        username.sendKeys("Bee marley");
        password.sendKeys("1234");
        repeatedPassword.sendKeys("1234");
        return this;
    }

    public RegistrationPage negativeUserInformation() {
        username.sendKeys("-1");
        password.sendKeys("1234");
        repeatedPassword.sendKeys("3456");
        return this;
    }

    public RegistrationPage positiveAccountInformation() {
        firstName.sendKeys("Jos");
        lastName.sendKeys("sdf");
        email.sendKeys("someemail@gmail.com");
        phone.sendKeys("+380992484111");
        address1.sendKeys("st. Pridniprovska 6");
        address2.sendKeys("st. Manuilovskiy");
        city.sendKeys("Dnipro");
        state.sendKeys("AND district");
        zip.sendKeys("zip");
        country.sendKeys("UKR");
        return this;
    }

    public RegistrationPage negativeAccountInformation() {
        firstName.sendKeys("Joseph");
        lastName.sendKeys("Me");
        email.sendKeys("sdfawerq.com");
        phone.sendKeys("this is not even a number");
        address1.sendKeys("same");
        address2.sendKeys("same");
        city.sendKeys("Dnipro");
        state.sendKeys("Dniprooo");
        zip.sendKeys("zip");
        country.sendKeys("UKR");
        return this;
    }

    public void profileInformationTesting() {
        Select languagePreference = new Select(this.languagePreference);
        Select favouriteCategory = new Select(this.accountFavouriteCategoryId);
        languagePreference.selectByIndex(languagePreference.getAllSelectedOptions().size() - 1);
        favouriteCategory.selectByIndex(favouriteCategory.getAllSelectedOptions().size() - 1);
        myBannerCheckBox.click();
        myListCheckBox.click();
        saveAccButton.click();
//        return new WelcomePage(driver);
    }
}
