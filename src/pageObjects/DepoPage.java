package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepoPage {
    private WebDriver driver;
    private By byAccNo = By.name("accountno");
    private By byAmount = By.name("ammount");
    private By byDesc = By.name("desc");
    private By byAccSubmit = By.name("AccSubmit");

    public DepoPage(WebDriver driver){
        this.driver = driver;
    }

    public void setAccId(){
        MsgAccPage acm = new MsgAccPage(driver);
        driver.findElement(byAccNo).sendKeys(acm.accId);
    }

    public void setAmount(String setAmount){
        driver.findElement(byAmount).sendKeys(setAmount);
    }

    public void setDesc(String setDesc){
        driver.findElement(byDesc).sendKeys(setDesc);
    }

    public void clickSubmit(){
        driver.findElement(byAccSubmit).click();
    }

    public void depoIn(String setAmount, String setDesc){
        this.setAccId();
        this.setAmount(setAmount);
        this.setDesc(setDesc);
        this.clickSubmit();
    }
}
