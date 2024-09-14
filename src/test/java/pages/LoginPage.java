package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailOrPhoneNumberField = By.xpath("//input[@name='email']");
    private By password = By.xpath("//input[@name='pass']");
    private By clickLoginButton = By.xpath("//button[@name='login']");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }




    public void enterEmail(String Email){
        driver.findElement(emailOrPhoneNumberField).sendKeys(Email);
    }
    public void enterPassword(String Password){
        driver.findElement(password).sendKeys(Password);
    }
    public void clickLogin(){
        driver.findElement(clickLoginButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();  // Returns the error message text
    }

}
