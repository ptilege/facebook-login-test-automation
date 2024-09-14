package tests;

import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

public class ForgotPasswordTest extends BaseTest{

    @Test
    public void testForgotPassword() throws InterruptedException {
        driver.get("https://www.facebook.com");
        ForgotPasswordPage forgotPasswordPage= new ForgotPasswordPage(driver);

        forgotPasswordPage.clickForgotPass();
        Thread.sleep(5000);


    }
}
