package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginErrorPage;
import pages.LoginPage;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    public void testValidLogin() throws InterruptedException, IOException {
        test = extent.createTest("testValidLogin");

        try {
            driver.get("https://www.facebook.com");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterEmail("test@gmail.com"); //that also not a actual one using actual email & password get true result.
            loginPage.enterPassword("tesT6@#");
            loginPage.clickLogin();
            Thread.sleep(5000);
            String divXPath = "//div[contains(@class, 'x1n2onr6') and contains(@aria-label, 'Messenger')]";


            WebElement element = driver.findElement(By.xpath(divXPath));


            if (element.isDisplayed()) {
                test.pass("Successfully logged in and the div is visible.");
            } else {
                test.fail("The div is not visible after login.")
                        .addScreenCaptureFromPath(takeScreenshot(driver,"loginFailure"));
            }
        }catch(Exception e){
            test.fail("Login test failed due to: " + e.getMessage())
                    .addScreenCaptureFromPath(takeScreenshot(driver,"loginException"));
        }
    }

    @Test
    public void testInvalidLoginRedirection() throws InterruptedException {

        driver.get("https://www.facebook.com");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("wrongemail@mailinator.com");
        loginPage.enterPassword("wrongPassword123");
        loginPage.clickLogin();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("https://www.facebook.com/login/"));

        String currentUrl = driver.getCurrentUrl();


        Assert.assertTrue(currentUrl.startsWith("https://www.facebook.com/login/"), "Redirected to the wrong URL");


        LoginErrorPage loginErrorPage = new LoginErrorPage(driver);
        String actualErrorMessage = loginErrorPage.getErrorMessage();


        Assert.assertTrue(actualErrorMessage.contains("The email address you entered isn't connected to an account."),
                "Error message not as expected!");
    }

    @Test
    public void testEmptyCredentials(){
        driver.get("https://www.facebook.com");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("https://www.facebook.com/login/"));

        String currentUrl = driver.getCurrentUrl();


        Assert.assertTrue(currentUrl.startsWith("https://www.facebook.com/login/"), "Redirected to the wrong URL");


        LoginErrorPage loginErrorPage = new LoginErrorPage(driver);
        String actualErrorMessage = loginErrorPage.getErrorMessage();


        Assert.assertTrue(actualErrorMessage.contains("The email address or mobile number you entered isn't connected to an account."),
                "Error message not as expected!");
    }
}
