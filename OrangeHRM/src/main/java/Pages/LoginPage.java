package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    // WebDriver
    WebDriver LoginDriver;

    // Locators

    public By usernameLocator = By.xpath("//input[@name='username']");
    public By passwordLocator = By.xpath("//input[@type='password']");
    public By loginButtonLocator = By.xpath("//button[@type='submit']");
    public By DashboardLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]"); //PIM
    public By errorMessageLocator = By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]");
    public By requirednameerrormeaasaeLoactor=By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");
    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        this.LoginDriver = driver;
    }

    // Actions - methods
    public void typeUsername(String userName) {
        WebElement usernameElement = LoginDriver.findElement(usernameLocator);
        usernameElement.sendKeys(userName);
    }

    public void typePassword(String passWord) {
        WebElement passwordElement = LoginDriver.findElement(passwordLocator);
        passwordElement.sendKeys(passWord);
    }

    public DashboardPage clickLogin() {
        WebElement loginButtonElement = LoginDriver.findElement(loginButtonLocator);
        loginButtonElement.click();
        return new DashboardPage(LoginDriver);  // Return PIMPage instead of AdminPage
    }
}