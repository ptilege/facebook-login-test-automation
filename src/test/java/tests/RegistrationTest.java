package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTest extends BaseTest{

    @Test
    public void testValidRegistration() throws InterruptedException {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.facebook.com");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickCreateAccount();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div[1]/div[1]")));
        registrationPage.enterFirstName("Pasindu");
        registrationPage.enterSurname("Tharaka");
        registrationPage.enterEmailorPhone("testemail@mailinator.com");
        registrationPage.enterPassword("Test123@@");
        registrationPage.selectDay("12");
        registrationPage.selectMonth("Dec");
        registrationPage.selectYear("1998");
        registrationPage.selectGender();
        registrationPage.clickSignUpButton();
        Thread.sleep(10000);

    }
}
