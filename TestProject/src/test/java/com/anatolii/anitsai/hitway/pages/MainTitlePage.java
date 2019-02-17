package com.anatolii.anitsai.hitway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTitlePage {
    private WebDriver driver;
    private final String avatarElemXpath = "//*[@id=\"content\"]/div/div/div[1]/div/div[2]/div[1]/div[1]/div[2]";
    private final String addAvatarInpId = "photo";
    private final String addAvatarBtnXpath = "//*[@id=\"content\"]/div/div/div[1]/div/div[2]/div[1]/div[1]/div[2]";
    private final String closePopUpBtnXpath = "/html/body/div[1]/div/a";
    private final String startElemXpath = "//*[@id=\"Dialog\"]/div/div/div[2]/div[3]/a";

    public MainTitlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = avatarElemXpath)
    private WebElement avatarElem;

    @FindBy(id = addAvatarInpId)
    private WebElement addAvatarInp;

    @FindBy(xpath = addAvatarBtnXpath)
    private WebElement addAvatarBtn;

    @FindBy(xpath = closePopUpBtnXpath)
    private WebElement closePopUpBtn;

    @FindBy(xpath = startElemXpath)
    private WebElement startElem;



    public void clickAvatarElem(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(avatarElem));
       avatarElem.click();
    }

    public void uploadAvatar(String pathToAvatar){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(addAvatarInpId)));
        addAvatarInp.sendKeys(pathToAvatar);
    }

    public void clickAddAvatarBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addAvatarBtnXpath)));
        addAvatarBtn.click();
    }

    public void closePopUp(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closePopUpBtnXpath)));
        closePopUpBtn.click();
    }

   public void finishedAddingAvatar(){
       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(startElem, "class", "disabled")));
       startElem.click();

   }
}
