import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import java.time.Duration;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@Listeners(AllureTestNg.class)
public class AdminTesting {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    WebDriverWait wait;
    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";
    String UserNameForadmin = "Abdullah Wahid";
    String Passwordforadmin = "Abdullah123@";
    String ConfirmPasswordforadmin = "Abdullah123@";
    String EmployeeNameSelectFirst = "Abdullah";
    String Statusforadminpage = "Enabled";
    String UserRoleforadminpage = "Admin";
    String Shiftname = "morning shift";
    String Expected = "Abdullah Wahid";
    String message = "not same";

    public AdminTesting() {
    }

    public void waitForElement(By locator, int seconds) {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds((long)seconds));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @BeforeClass
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(this.driver);
        this.waitForElement(this.loginPage.loginButtonLocator, 30);
    }

    @Test(
            priority = 1
    )
    @Epic("Login Functionality")
    @Feature("User Login")
    @Story("Successful Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify successful login with valid credentials")
    public void validLogin() {
        this.loginPage.typeUsername(this.UserNameLogin);
        this.loginPage.typePassword(this.PasswordLogin);
        this.dashboardPage = this.loginPage.clickLogin();
        this.waitForElement(this.dashboardPage.DashboardLocator, 30);
    }

    @Test(
            priority = 2,
            dependsOnMethods = {"validLogin"}
    )
    @Epic("Admin Management")
    @Feature("User Management")
    @Story("Adding a User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the ability to add a new user in the Admin module")
    public void AdminAddEmployee() {
        this.adminPage = this.dashboardPage.goToAdminPage();
        this.waitForElement(this.adminPage.AdmintextLocator, 30);
        this.adminPage.clickAddButton();
        this.waitForElement(this.adminPage.AddUserTextLocator, 30);
        this.adminPage.typeUserName(this.UserNameForadmin);
        this.adminPage.typePassword(this.Passwordforadmin);
        this.adminPage.typeconfirmPassword(this.ConfirmPasswordforadmin);
        this.adminPage.selectUserRole(this.UserRoleforadminpage);
        this.adminPage.selectStatus(this.Statusforadminpage);
        this.adminPage.typeEmployeeNameAndSelectFirst(this.EmployeeNameSelectFirst);
        this.adminPage.clickSaveButton();
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("window.scrollBy(0,350)", new Object[]{""});
    }

    @Test(
            priority = 3,
            dependsOnMethods = {"AdminAddEmployee"}
    )
    @Epic("Admin Management")
    @Feature("User Management")
    @Story("Searching for a User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the ability to search for a newly added user")
    public void AdminSearchEmployee() {
        this.waitForElement(this.adminPage.SystemUserLocator, 30);
        this.adminPage.typeUserName2(this.UserNameForadmin);
        this.adminPage.selectStatus2(this.Statusforadminpage);
        this.adminPage.selectUserRole2(this.UserRoleforadminpage);
        this.adminPage.typeEmployeeNameAndSelectFirst2(this.EmployeeNameSelectFirst);
        this.adminPage.clickSearchButton();
        this.waitForElement(this.adminPage.PersonalNameLocator, 30);
        String actualResult = this.adminPage.getPersonalName();
        Assert.assertEquals(actualResult, this.Expected, this.message);
        this.waitForElement(this.adminPage.UserName3Locator, 30);
    }

    @Test(
            dependsOnMethods = {"AdminSearchEmployee"}
    )
    @Epic("Admin Management")
    @Feature("Work Shift Management")
    @Story("Adding a Work Shift")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the ability to add a new work shift for an employee")
    public void AddShift() {
        this.adminPage.SelectJobdropdown();
        this.waitForElement(this.adminPage.WorkShiftTextLocator, 30);
        this.adminPage.AddWorkshiftButton();
        this.waitForElement(this.adminPage.AddWorkShiftTextLocator, 30);
        this.adminPage.typeShiftName(this.Shiftname);
        this.adminPage.typeAssignedEmployeeAndSelectFirst(this.EmployeeNameSelectFirst);
        this.adminPage.clickSaveShiftButton();
        this.waitForElement(this.adminPage.WorkshiftLocator, 30);
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}