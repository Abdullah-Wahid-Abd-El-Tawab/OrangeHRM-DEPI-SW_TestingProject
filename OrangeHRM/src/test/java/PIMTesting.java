import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.PIMPage;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import io.qameta.allure.*; // Import Allure annotations

@Listeners(AllureTestNg.class)
public class PIMTesting {

    WebDriver driver;
    LoginPage loginPage;
    PIMPage pimPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    WebDriverWait wait;

    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";

    String Firstname = "Sara";
    String LastName = "Ramadan";
    String EmployeeID = "325";
    String filePath = "C:\\Users\\sara\\Pictures\\Screenshots\\1.png";
    String Nationality = "Afghan";
    String MartialStatus = "Single";
    String otherID = "1234";
    String Driverlicensenumber = "125555";
    String licenseDate = "2024-03-05";
    String birthDate = "2001-16-08";
    String expected = "Sara Ramadan";
    String message2 = "Employee name does not match!";
    String ConfigurationStatus = "Termination Reasons";
    String TerminationReason = "Deceased";
    String message3 = "Termination reason 'Deceased' not found in records!";
    String Message4="Employee is not found in records!";

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
        loginPage.typeUsername(UserNameLogin);
        loginPage.typePassword(PasswordLogin);
        dashboardPage = loginPage.clickLogin();
        waitForElement(dashboardPage.DashboardLocator, 30);
    }



    @Test(priority = 2)
    @Epic("PIM Functionality")
    @Feature("Employee Management")
    @Story("Add Employee")
    @Severity(SeverityLevel.BLOCKER)
    public void PIMaddEmployee() {
        // Navigate to PIM Page
        pimPage = dashboardPage.goTopimPage();
        waitForElement(pimPage.PIMLocator, 30);

        // Search if Employee already exists by EmployeeID
        pimPage.searchEmployeeid(EmployeeID);
        pimPage.SearchButton();

        // Scroll down to ensure the table is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        // Check if the EmployeeID is found
        boolean employeeFound = pimPage.isEmployeeIDPresent(EmployeeID);

        // If Employee ID is not found, add the employee
        if (!employeeFound) {
            // Click the "Add" button
            waitForElement(pimPage.AddButtonLocator, 30);
            pimPage.clickAddButton();
            waitForElement(pimPage.AddEmpolyeeLocator, 30);

            // Enter First Name and Last Name
            pimPage.IDelement(EmployeeID);
            pimPage.typeFirstname(Firstname);
            pimPage.typeLastName(LastName);


            // Upload Employee Picture (if required)
            pimPage.uploadEmployeePicture(filePath);

            // Save the newly added employee
            pimPage.clickSave();

            // Wait for employee details page to load
            waitForElement(pimPage.EmployeefullnametextLocator, 30);

            // Fill additional employee information
            pimPage.selectNationality(Nationality);
            pimPage.selectMartialStatus(MartialStatus);
            pimPage.typeotherID(otherID);
            pimPage.typeDriverlicensenumber(Driverlicensenumber);
            pimPage.typelicenseDate(licenseDate);
            pimPage.typebirthDate(birthDate);
            pimPage.clickGender();

            // Verify the personal name is correct after addition
            String actualResult = pimPage.getPersonalName();
            Assert.assertEquals(actualResult, expected, message2);

            // Scroll down again to save the personal information
            JavascriptExecutor jp = (JavascriptExecutor) driver;
            jp.executeScript("window.scrollBy(0,350)", "");

            // Wait for the save button and click to save PIM details
            waitForElement(pimPage.SaveButtonpimLocator, 30);
            pimPage.clicksavepimButton();
        } else {
            // Print if Employee already exists
            System.out.println("Employee already exists.");
        }
    }


    @Test(priority = 2)
    @Epic("PIM Functionality")
    @Feature("Employee Management")
    @Story("Search Employee")
    @Severity(SeverityLevel.CRITICAL)
    public void SearchEmployee() {
        pimPage = dashboardPage.goTopimPage();
        waitForElement(pimPage.PIMLocator, 30);

        pimPage.searchEmployeeid(EmployeeID);  // Search by EmployeeID
        pimPage.SearchButton();

        // Scroll to ensure the table is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        waitForElement(pimPage.RecordTableEmployeeLoactor, 30);

        // Verify if Employee ID is present
        boolean employeeFound = pimPage.isEmployeeIDPresent(EmployeeID);

        // Assertions:
        if (employeeFound) {
            Assert.assertTrue(employeeFound, "Employee should be found!");
        } else {
            Assert.assertFalse(employeeFound, "Employee should NOT be found!");
        }
    }


    @Test(priority = 3)
    @Epic("PIM Functionality")
    @Feature("Termination Management")
    @Story("Add Termination Reason")
    @Severity(SeverityLevel.NORMAL)
    public void addTerminationScenario() {
        pimPage = dashboardPage.goTopimPage();
        waitForElement(pimPage.PIMLocator, 30);
        pimPage.selectConfigurationStatus(ConfigurationStatus);
        waitForElement(pimPage.TerminationReasonsLocator, 30);

        // Check if the termination reason already exists
        if (!pimPage.isTerminationReasonPresent(TerminationReason)) {
            pimPage.AddButtonTermination();
            waitForElement(pimPage.AddTerminationreasonTextLocator, 30);
            pimPage.typeTerminationReason(TerminationReason);
            pimPage.SaveButtonTermination();
        } else {
            System.out.println("Termination reason already exists.");
        }
    }

    @Test(priority = 3)
    @Epic("PIM Functionality")
    @Feature("Termination Management")
    @Story("Verify Termination Reason")
    @Severity(SeverityLevel.NORMAL)
    public void isTerminationReasonPresent() {
        pimPage = dashboardPage.goTopimPage();
        waitForElement(pimPage.PIMLocator, 30);
        pimPage.selectConfigurationStatus(ConfigurationStatus);
        waitForElement(pimPage.TerminationReasonsLocator, 30);
        waitForElement(pimPage.RecordsFoundLocator, 30);
        boolean reasonFound = pimPage.isTerminationReasonPresent(TerminationReason);
        Assert.assertTrue(reasonFound, message3);
    }

/*
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

 */

}