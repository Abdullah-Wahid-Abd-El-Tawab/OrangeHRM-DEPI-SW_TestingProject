import Pages.RecruitmentPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.qameta.allure.*; // Import Allure annotations
import java.time.Duration;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestNg.class)
public class RecruitmentTesting {
    WebDriver driver;
    LoginPage loginPage;
    RecruitmentPage recruitmentPage;
    DashboardPage dashboardPage;
    WebDriverWait wait;

    // Test data
    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";
    String Firstname = "Mohamed";
    String Middlename = "Abdelrehem";
    String LastName = "Ali";
    String Email = "mohamedabdelrehem32@gg.com";
    String ContactNumber = "123456789";
    String Vacancy = "Software Engineer";
    String filePath = "D:\\CV\\Global CV\\Aug-2024\\Testing\\Mohamed Abdelrehem Ali.pdf"; // Replace with the actual file path
    String DateOfApplication = "2024-18-10";
    String message = "Candidate name does not match!";

    public RecruitmentTesting() {
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

    @Test(priority = 1)
    @Epic("Recruitment Functionality")
    @Feature("Login and Navigation")
    @Story("Successful Login")
    @Severity(SeverityLevel.BLOCKER)
    public void validLogin() {
        this.loginPage.typeUsername(this.UserNameLogin);
        this.loginPage.typePassword(this.PasswordLogin);
        this.dashboardPage = this.loginPage.clickLogin();
        this.waitForElement(this.dashboardPage.DashboardLocator, 30);
    }

    @Test(priority = 2, dependsOnMethods = {"validLogin"})
    @Epic("Recruitment Functionality")
    @Feature("Candidate Management")
    @Story("Adding a New Candidate")
    @Severity(SeverityLevel.CRITICAL)
    public void addNewCandidate() {
        // Navigate to Recruitment Page
        this.recruitmentPage = this.dashboardPage.goToRecruitmentPage();
        this.waitForElement(this.recruitmentPage.RecruitmentButton, 30);

        // Click Add button
        this.recruitmentPage.clickAddButton();
        this.waitForElement(this.recruitmentPage.FirstName, 30);

        // Fill in candidate details
        this.recruitmentPage.typeFirstName(this.Firstname);
        this.recruitmentPage.typeMiddleName(this.Middlename);
        this.recruitmentPage.typeLastName(this.LastName);
        this.recruitmentPage.typeEmail(this.Email);
        this.recruitmentPage.typeContactNumber(this.ContactNumber);
        this.recruitmentPage.selectVacancy(this.Vacancy);
//        this.recruitmentPage.uploadResume(this.filePath); // Uncomment this and replace the file path
        this.recruitmentPage.typeDateOfApplication(this.DateOfApplication);

        // Save candidate details
        this.recruitmentPage.clickSaveButton();
        this.waitForElement(By.xpath("//div[@aria-live='assertive']"), 20);

        // Verify candidate is added
        String expectedFullName = this.Firstname + " " + this.Middlename +  " " + this.LastName;
        String actualFullName = recruitmentPage.getFinalNameFromUI();
        Assert.assertEquals(actualFullName, expectedFullName, this.message);

    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}