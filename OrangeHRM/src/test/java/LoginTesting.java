import Pages.DashboardPage;
import Pages.LoginPage;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@Listeners(AllureTestNg.class)
public class LoginTesting {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    // Valid Credentials
    String validUserName = "Admin";
    String validUserName2 = "admin"; // This is still an invalid username
    String validPassword = "admin123";

    // Invalid Credentials
    String invalidUserName = "InvalidUser";
    String invalidPassword = "wrongpassword";

    @Step("Waiting for element {locator} to be visible for {seconds} seconds.")
    public void waitForElement(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @BeforeMethod
    @Description("Setting up the ChromeDriver and opening the login page")
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        waitForElement(loginPage.loginButtonLocator, 30);
    }

    @Test(priority = 1)
    @Epic("Authentication Functionality")
    @Feature("User Login")
    @Story("Successful Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test valid login using username 'Admin'")
    public void validLogin() {
        loginPage.typeUsername(validUserName);
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        // Assert that the dashboard is displayed
        waitForElement(loginPage.DashboardLocator, 30);
        Assert.assertTrue(driver.findElement(loginPage.DashboardLocator).isDisplayed(), "Dashboard is not displayed");
    }

    @Test(priority = 2)
    @Epic("Authentication Functionality")
    @Feature("User Login")
    @Story("Login with Invalid Username")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test login with an invalid username 'admin'")
    public void validLoginwithInvalidUsername() {
        loginPage.typeUsername(validUserName2);
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        waitForElement(loginPage.DashboardLocator, 30);
        Assert.assertTrue(driver.findElement(loginPage.DashboardLocator).isDisplayed(), "Dashboard is not displayed"); // This should be an assertion failure
    }

    @Test(priority = 3)
    @Epic("Authentication Functionality")
    @Feature("Invalid Login Attempts")
    @Story("Invalid Username")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test invalid login with invalid username")
    public void invalidUserName() {
        loginPage.typeUsername(invalidUserName);
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        // Assert that the error message is displayed
        waitForElement(loginPage.errorMessageLocator, 30);
        String actualErrorMessage = driver.findElement(loginPage.errorMessageLocator).getText();
        Assert.assertTrue(actualErrorMessage.contains("Invalid credentials"), "Error message is not expected");
        attachScreenshot("Invalid Username Test");
    }

    @Test(priority = 4)
    @Epic("Authentication Functionality")
    @Feature("Invalid Login Attempts")
    @Story("Invalid Password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test invalid login with incorrect password")
    public void invalidPassword() {
        loginPage.typeUsername(validUserName);
        loginPage.typePassword(invalidPassword);
        loginPage.clickLogin();

        waitForElement(loginPage.errorMessageLocator, 30);
        String actualErrorMessage = driver.findElement(loginPage.errorMessageLocator).getText();
        Assert.assertTrue(actualErrorMessage.contains("Invalid credentials"), "Error message is not expected");
        attachScreenshot("Invalid Password Test");
    }

    @Test(priority = 5)
    @Epic("Authentication Functionality")
    @Feature("Invalid Login Attempts")
    @Story("Empty Username")
    @Severity(SeverityLevel.MINOR)
    @Description("Test login with empty username")
    public void emptyUserName() {
        loginPage.typeUsername(""); // Empty username
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        waitForElement(loginPage.requirednameerrormeaasaeLoactor, 30);
        String actualErrorMessage = driver.findElement(loginPage.requirednameerrormeaasaeLoactor).getText();
        Assert.assertTrue(actualErrorMessage.contains("Required"), "Error message is not expected");
    }

    @Test(priority = 6)
    @Epic("Authentication Functionality")
    @Feature("Invalid Login Attempts")
    @Story("Empty Password")
    @Severity(SeverityLevel.MINOR)
    @Description("Test login with empty password")
    public void emptyPassword() {
        loginPage.typeUsername(validUserName);
        loginPage.typePassword(""); // Empty password
        loginPage.clickLogin();

        waitForElement(loginPage.requirednameerrormeaasaeLoactor, 30);
        String actualErrorMessage = driver.findElement(loginPage.requirednameerrormeaasaeLoactor).getText();
        Assert.assertTrue(actualErrorMessage.contains("Required"), "Error message is not expected");
    }

    @AfterClass
    @Description("Closing the browser after tests")
    public void tearDown() {
        driver.quit();
    }

    @Attachment(value = "{testName} - Screenshot", type = "image/png")
    public byte[] attachScreenshot(String testName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}