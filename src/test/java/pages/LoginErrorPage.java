package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginErrorPage {

    private WebDriver driver;

    private By errorMessage = By.xpath("//div[@class='_9ay7']");

    public LoginErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
