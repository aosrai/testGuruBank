package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MsgCusPage {
    private WebDriver driver;
    private By byCreateCusSuccess = By.xpath("//*[@id='customer']/tbody//*[@class='heading3']");
    private By byCusId = By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]");
    static String cusId;

    public MsgCusPage(WebDriver driver){
        this.driver = driver;
    }

    public void getCusId(){
        WebElement eCusId = driver.findElement(byCusId);
        cusId = eCusId.getText();
    }

    public String getNotiCusSuccess(){
        return driver.findElement(byCreateCusSuccess).getText();
    }
}
