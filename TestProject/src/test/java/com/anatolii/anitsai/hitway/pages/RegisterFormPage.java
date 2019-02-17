package com.anatolii.anitsai.hitway.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterFormPage {
    private WebDriver driver;
    private final String girlBtnXpath = "//*[@id=\"slide-01\"]/div/div[1]/a";
    private final String girlDarkHairBtnXpath = "//*[@id=\"slide-02-f\"]/div/div[1]/a";
    private final String girlDarkEysBtnXpath = "//*[@id=\"slide-03-f\"]/div/div[1]/a";
    private final String girlWithFormsBtnXpath = "//*[@id=\"slide-04-f\"]/div/div[1]/a";
    private final String nameInputXpath = "//*[@id=\"slide-06\"]/form/div[1]/input";
    private final String emailInputName = "email";
    private final String genderSelectName = "gender";
    private final String ageSelectName = "age";
    private final String registerBtnXpath = "//*[@id=\"slide-06\"]/form/div[4]/button";

    @FindBy(xpath = girlBtnXpath)
    private WebElement girlBtn;

    @FindBy(xpath = girlDarkHairBtnXpath)
    private WebElement girlDarkHairBtn;

    @FindBy(xpath = girlDarkEysBtnXpath)
    private WebElement girlDarkEysBtn;

    @FindBy(xpath = girlWithFormsBtnXpath)
    private WebElement girlWithFormsBtn;

    @FindBy(xpath = nameInputXpath)
    private WebElement nameInput;

    @FindBy(name = emailInputName)
    private WebElement emailInput;

    @FindBy(name = genderSelectName)
    private WebElement genderSelect;

    @FindBy(name = ageSelectName)
    private WebElement ageSelect;

    @FindBy(xpath = registerBtnXpath)
    private WebElement registerBtn;

    public RegisterFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void clickGirlBtn() {
        girlBtn.click();
    }

    public void clickGirlDarkHairBtn() {
        girlDarkHairBtn.click();
    }

    public void clickGirlDarkEysBtn() {
        girlDarkEysBtn.click();
    }

    public void clickGirlWithFormsBtn() {
        girlWithFormsBtn.click();
    }

    public void inputName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(name);
    }

    public void inputEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void selectGender(String genderValue) {
        Select select = new Select(genderSelect);
        select.selectByValue(genderValue);
    }

    public void selectAge(String ageValue) {
        Select select = new Select(ageSelect);
        select.selectByValue(ageValue);
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

}
