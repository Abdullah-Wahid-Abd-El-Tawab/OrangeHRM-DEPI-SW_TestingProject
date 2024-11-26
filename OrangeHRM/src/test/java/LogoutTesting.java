import Pages.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.*; // Import Allure annotations

import java.time.Duration;

@Listeners(AllureTestNg.class)
public class LogoutTesting {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    PIMPage pimPage;
    LogoutPage logoutPage;
    WebDriverWait wait;

    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";

    public void waitForElement(By locator, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @BeforeClass
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
    public void validLogin() {
        loginPage.typeUsername(UserNameLogin);
        loginPage.typePassword(PasswordLogin);
        dashboardPage = loginPage.clickLogin();
        waitForElement(dashboardPage.DashboardLocator, 30);
    }

    @Test(priority = 2, dependsOnMethods = "validLogin")
    @Epic("Authentication Functionality")
    @Feature("User Logout")
    @Story("Successful Logout")
    @Severity(SeverityLevel.CRITICAL)
    public void logout() {
        logoutPage = dashboardPage.goTologoutPage();
        logoutPage.selectLogoutfromdropdown("Logout");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}