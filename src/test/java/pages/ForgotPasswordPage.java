package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    private By clickForgotPassword = By.xpath("//a[text()='Forgotten password?']");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickForgotPass(){
        driver.findElement(clickForgotPassword).click();
    }

}
