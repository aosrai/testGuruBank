package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccPage {
    private WebDriver driver;
    private By byCusID = By.name("cusid");
    private By byAccType = By.name("selaccount");
    private By byInDeposit = By.name("inideposit");
    private By bySubmit = By.name("button2");

    public CreateAccPage(WebDriver driver){
        this.driver = driver;
    }

    public void setCusId(){
        MsgCusPage crm = new MsgCusPage(driver);
        driver.findElement(byCusID).sendKeys(crm.cusId);
    }

    public void setAccType(){
        Select drpAccType = new Select(driver.findElement(byAccType));
        drpAccType.selectByValue("Current");
    }

    public void setDepoIn(String strDepoIn){
        driver.findElement(byInDeposit).sendKeys(strDepoIn);
    }

    public void clickSubmit(){
        driver.findElement(bySubmit).click();
    }

    public void createAcc(String strDepoIn){
        this.setCusId();
        //this.setAccType();
        this.setDepoIn(strDepoIn);
        this.clickSubmit();
    }
}
