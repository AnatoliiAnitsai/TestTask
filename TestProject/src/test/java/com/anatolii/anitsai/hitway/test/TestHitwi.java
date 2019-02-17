package com.anatolii.anitsai.hitway.test;

import com.anatolii.anitsai.hitway.data.ConfigPropertiesWorker;
import com.anatolii.anitsai.hitway.data.EmailGenerator;
import com.anatolii.anitsai.hitway.data.ImageGenerator;
import com.anatolii.anitsai.hitway.pages.MainTitlePage;
import com.anatolii.anitsai.hitway.pages.RegisterFormPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestHitwi {
    private String url = "https://hitwe.com/landing/inter?p=15276";
    private String pathToFireFoxDriver;
    private String pathToChromeDriver;
    private String fireFoxDriverPropertyKey="path.fireFoxDriver";
    private String chromeDriverPropertyKey="path.chromeDriver";
    private String avatarPropertyKey="path.avatar";
    private String browserType = "";
    private WebDriver driver;
    private RegisterFormPage registerFormPage;
    private MainTitlePage titlePage;
    private String email;
    private String name = "UserName";
    private String ageValue = "18";
    private String genderValue = "m";
    private int imageWidth = 640;
    private int imageHeight = 320;
    private String pathToAvatar;
    private String fileName = "avatar";
    private ConfigPropertiesWorker propertiesWorker = new ConfigPropertiesWorker();

    @BeforeClass
    @Parameters("browserType")
    public void setup(String browserType) {
        pathToFireFoxDriver = propertiesWorker.getPropertyByKey(fireFoxDriverPropertyKey);
        pathToChromeDriver = propertiesWorker.getPropertyByKey(chromeDriverPropertyKey);
        pathToAvatar = propertiesWorker.getPropertyByKey(avatarPropertyKey);
        this.browserType = browserType;

        if ("Firefox".equalsIgnoreCase(browserType)) {
            System.setProperty("webdriver.gecko.driver", pathToFireFoxDriver);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
            this.driver = new FirefoxDriver(capabilities);
        }

        if ("Chrome".equalsIgnoreCase(browserType)) {
            System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            driver = new ChromeDriver(chromeOptions);
        }
        EmailGenerator emailGenerator = new EmailGenerator();
        email = emailGenerator.getRandomEmail();
        ImageGenerator generator = new ImageGenerator(imageWidth, imageHeight);
        generator.generateRandImage(pathToAvatar, fileName);
        registerFormPage = new RegisterFormPage(driver);
        titlePage = new MainTitlePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAddingAvatar() {
        driver.get(url);
        registerFormPage.clickGirlBtn();
        registerFormPage.clickGirlDarkHairBtn();
        registerFormPage.clickGirlDarkEysBtn();
        registerFormPage.clickGirlWithFormsBtn();
        registerFormPage.inputName(name);
        registerFormPage.inputEmail(email);
        registerFormPage.selectGender(genderValue);
        registerFormPage.selectAge(ageValue);
        registerFormPage.clickRegisterBtn();
        titlePage.closePopUp();
        titlePage.clickAvatarElem();
        titlePage.uploadAvatar(pathToAvatar + fileName + ".jpg");
        titlePage.finishedAddingAvatar();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
