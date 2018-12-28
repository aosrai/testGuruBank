package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class CreateCusPage {
    private WebDriver driver;
    private By byCustomerName = By.name("name");
    private By byMaleGender = By.xpath("//*[@value='m']");
    private By byFemaleGender = By.xpath("//*[@value='f']");
    private By byAdd = By.name("addr");
    private By byCity = By.name("city");
    private By byState = By.name("state");
    private By byPIN = By.name("pinno");
    private By byMobileNumber = By.name("telephoneno");
    private By byEmail = By.name("emailid");
    private By byPassword = By.name("password");
    private By bySubmit = By.name("sub");

    public CreateCusPage(WebDriver driver){
        this.driver = driver;
    }

    public void setCusName(String strCusName){
        driver.findElement(byCustomerName).sendKeys(strCusName);
    }

    public void setGender(){
        WebElement mGender = driver.findElement(byMaleGender);
        WebElement fGender = driver.findElement(byFemaleGender);
        if(mGender.isSelected()){
            fGender.click();
        }
    }

    public void setDob(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#dob').value='" + today + "'");
        js.executeScript("return document.getElementById('dob').onblur('validatedob()')");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void setAddress(String strAddress){
        driver.findElement(byAdd).sendKeys(strAddress);
    }

    public void setCity(String strCity){
        driver.findElement(byCity).sendKeys(strCity);
    }

    public void setState(String strState){
        driver.findElement(byState).sendKeys(strState);
    }

    public void setPin(String strPin){
        driver.findElement(byPIN).sendKeys(strPin);
    }

    public void setMobileNumber(String strMobileNumber){
        driver.findElement(byMobileNumber).sendKeys(strMobileNumber);
    }

    public void setEmail(String strEmail){
        driver.findElement(byEmail).sendKeys(strEmail);
    }

    public void setPassword(String strPassword){
        driver.findElement(byPassword).sendKeys(strPassword);
    }

    public void clickSubmit(){
        driver.findElement(bySubmit).click();
    }


    public void createCus(String strCusName, String strAddress, String strCity, String strState, String strPin, String strMobileNumber, String strEmail, String strPassword){
        this.setCusName(strCusName);
        //this.setGender();
        this.setDob();
        this.setAddress(strAddress);
        this.setCity(strCity);
        this.setState(strState);
        this.setPin(strPin);
        this.setMobileNumber(strMobileNumber);
        this.setEmail(strEmail);
        this.setPassword(strPassword);
        this.clickSubmit();
    }
}
