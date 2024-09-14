package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    private WebDriver driver;

    private By CreateAccountButton = By.xpath("//a[contains(., 'Create new account')]");
    private By firstNameField = By.xpath("//input[@placeholder='First name']");
    private By surnameField = By.xpath("//input[@name='lastname']");
    private By emailOrMobileField = By.xpath("//input[@name='reg_email__']");
    private By passwordField = By.xpath("//input[@name='reg_passwd__']");
    private By dayDropdown = By.xpath("//select[@name='birthday_day']");
    private By monthDropdown = By.xpath("//select[@name='birthday_month']");
    private By yearDropdown = By.xpath("//select[@name='birthday_year']");
    private By genderCheckBox = By.xpath("//input[@id='sex' and @value='2']");
    private By signUpButton = By.xpath("//button[@name='websubmit']");



    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateAccount(){
        driver.findElement(CreateAccountButton).click();
    }
    public void enterFirstName(String FirstName){
        driver.findElement(firstNameField).sendKeys(FirstName);
    }
    public void enterSurname(String Surname){
        driver.findElement(surnameField).sendKeys(Surname);
    }
    public void enterEmailorPhone(String Email){
        driver.findElement(emailOrMobileField).sendKeys(Email);
    }
    public void enterPassword(String Password){
        driver.findElement(passwordField).sendKeys(Password);
    }
    public void selectDay(String day){
        Select daySelect = new Select(driver.findElement(dayDropdown));
        daySelect.selectByVisibleText(day);
    }
    public void selectMonth(String Month){
        Select monthSelect = new Select(driver.findElement(monthDropdown));
        monthSelect.selectByVisibleText(Month);
    }
    public void selectYear(String Year){
        Select yearSelect = new Select(driver.findElement(yearDropdown));
        yearSelect.selectByVisibleText(Year);
    }
    public void selectGender(){
        driver.findElement(genderCheckBox).click();

    }
    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }
}
