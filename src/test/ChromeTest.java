package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class ChromeTest {
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
        System.setProperty("webdriver.chrome.driver", "D:/testGuruBank/Webdriver/chromedriver.exe");
        //Create chrome driver
        driver = new ChromeDriver();
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
        objCreateCusPage.createCus("crCus", "000 addRess", "cIty", "stAte", "999999", "9999999999999999", "crCus1@somemail.com", "crCus$789");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objMsgCusPage = new MsgCusPage(driver);
        Assert.assertTrue(objMsgCusPage.getNotiCusSuccess().toLowerCase().contains("successfully!"));
    }

    @Test(priority=2)
    public void testCreateAccount(){
        objMsgCusPage.getCusId();
        driver.findElement(By.linkText("New Account")).click();
        objCreateAccPage = new CreateAccPage(driver);
        objCreateAccPage.createAcc("99999999");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        objMsgAccPage = new MsgAccPage(driver);
        Assert.assertTrue(objMsgAccPage.getNotiAccSuccess().toLowerCase().contains("successfully!"));
    }

    @Test(priority=3)
    public void testDepoIn(){
        objMsgAccPage.getAccId();
        driver.findElement(By.linkText("Deposit")).click();
        objDepoPage = new DepoPage(driver);
        objDepoPage.depoIn("999999", "9#rAnDom");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        objMsgDepoPage = new MsgDepoPage(driver);
        Assert.assertTrue(objMsgDepoPage.getNotiDepoSuccess().toLowerCase().contains("transaction details"));
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
