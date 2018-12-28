package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By byUid = By.name("uid");
    private By byPassword = By.name("password");
    private By byTitle = By.xpath("//div//*[@class='barone']");
    private By byBtnLogin = By.name("btnLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(byUid).sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        driver.findElement(byPassword).sendKeys(strPassword);
    }

    public String getLoginTitle(){
        return driver.findElement(byTitle).getText();
    }

    public void clickLogin(){
        driver.findElement(byBtnLogin).click();
    }

    public void loginToGuru(String strUserName, String strPassword){
        //Fill username
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click login
        this.clickLogin();
    }
}
