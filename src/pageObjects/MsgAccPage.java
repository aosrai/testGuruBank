package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MsgAccPage {
    private WebDriver driver;
    private By byGeneratedAccSuccess = By.xpath("//*[@id='Accmsg']/tbody//*[@class='heading3']");
    private By byAccId = By.xpath("//table//tr[4]/td[2]");
    static String accId;

    public MsgAccPage(WebDriver driver){
        this.driver = driver;
    }

    public void getAccId(){
        WebElement eAccId = driver.findElement(byAccId);
        accId = eAccId.getText();
    }

    public String getNotiAccSuccess(){
        return driver.findElement(byGeneratedAccSuccess).getText();
    }
}
