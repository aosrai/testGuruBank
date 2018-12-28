package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class FirefoxDefaultTest {
    WebDriver driver;
    LoginPage objLoginPage;
    HomePage objHomePage;
    CreateCusPage objCreateCusPage;
    MsgCusPage objMsgCusPage;
    CreateAccPage objCreateAccPage;
    MsgAccPage objMsgAccPage;
    DepoPage objDepoPage;
    MsgDepoPage objMsgDepoPage;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "D:/testGuruBank/Webdriver/geckodriver.exe");
        //Create firefox profile
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
        firefoxProfile.setPreference("security.insecure_field_warning.contextual.enabled", false);
        firefoxProfile.setPreference("security.insecure_password.ui.enabled", false);
        //Create firefox options
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        firefoxOptions.setCapability("marionette", true);
        //Create firefox driver
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/v4/");
    }

    @Test(priority=0)
    public void testLogIn(){
        //Create login page object
        objLoginPage = new LoginPage(driver);
        //Verify login page title
        String loginPageTitle = objLoginPage.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        //Login
        objLoginPage.loginToGuru("mngr168091", "AjUdUhU");
        objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageNotiBar().toLowerCase().contains("manger id : mngr168091"));
    }
    @Test(priority=1)
    public void testCreateCustomer(){
        //Create add customer page object
        driver.findElement(By.linkText("New Customer")).click();
        objCreateCusPage = new CreateCusPage(driver);
        objCreateCusPage.createCus("ffCus", "123 Address", "City", "State", "000000", "0", "ffCus1@mail.com", "ffCus1@123");
        objMsgCusPage = new MsgCusPage(driver);
        objMsgCusPage.getCusId();
        Assert.assertTrue(objMsgCusPage.getNotiCusSuccess().toLowerCase().contains("successfully!"));
    }

    @Test(priority=2)
    public void testCreateAccount(){
        objMsgCusPage.getCusId();
        driver.findElement(By.linkText("New Account")).click();
        objCreateAccPage = new CreateAccPage(driver);
        objCreateAccPage.createAcc("500");
        objMsgAccPage = new MsgAccPage(driver);
        Assert.assertTrue(objMsgAccPage.getNotiAccSuccess().toLowerCase().contains("successfully!"));
    }

    @Test(priority=3)
    public void testDepoIn(){
        objMsgAccPage.getAccId();
        driver.findElement(By.linkText("Deposit")).click();
        objDepoPage = new DepoPage(driver);
        objDepoPage.depoIn("0", "1@Desc");
        objMsgDepoPage = new MsgDepoPage(driver);
        Assert.assertTrue(objMsgDepoPage.getNotiDepoSuccess().toLowerCase().contains("transaction details"));
    }

   @AfterTest
    public void closeBrowser() {
       driver.close();
    }
}
