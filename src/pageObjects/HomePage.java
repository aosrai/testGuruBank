package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By byManagerId = By.xpath("//table//tr[@class='heading3']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHomePageNotiBar(){
        return driver.findElement(byManagerId).getText();
    }
}
