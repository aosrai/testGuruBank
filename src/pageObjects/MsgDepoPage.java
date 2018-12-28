package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MsgDepoPage {
    private WebDriver driver;
    private By byDepoSuccess = By.xpath("//*[@id='deposit']/tbody/tr[1]");
    private By byCurBalance = By.xpath("//*[@id='deposit']/tbody/tr[23]/td[2]");

    public MsgDepoPage(WebDriver driver){
        this.driver = driver;
    }

    public String getNotiDepoSuccess(){
        return driver.findElement(byDepoSuccess).getText();
    }

    //public String getCurrentBalance(){
        //return driver.findElement(byCurBalance).getText();
    //}
}
