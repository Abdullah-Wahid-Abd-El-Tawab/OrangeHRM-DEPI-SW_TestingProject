package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {

    // Driver
    WebDriver AdminDriver;


    // Locators
    /*********************Add Empolyee******************/
    public By EmployeeDropdownOptionsLocator = By.xpath("//div[@role='listbox']//span");
    public By AdminButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    public By AdmintextLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By AddUserTextLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]");
    public By UserroleDropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]"); // Target the select element
    public By StatusDropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"); // Target the select element
    public By AddButtonLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    public By EmployeeNameLocator =By.cssSelector("input[placeholder=\"Type for hints...\"]");
    public By UserNameLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    public By PasswordLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    public By ConfirmpasswordLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    public By SaveButtonLocator =By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    public By SystemUserLocator =By.cssSelector("h5[class=\"oxd-text oxd-text--h5 oxd-table-filter-title\"]");
    /****************************************************************************************/

    /********************************Search Empolyee***********************/
    public By UserName2Locator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    public By EmpolyeeName2Locator =By.cssSelector("input[placeholder=\"Type for hints...\"]");
    public By UserRole2Locator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    public By Status2Locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]");
    public By EmployeeDropdownOptions2Locator = By.xpath("//div[@role='listbox']//span");
    public By SearchButtonLocator =By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    public By PersonalNameLocator=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");
    public By UserName3Locator=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]");
    public By JobButtonLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]");
    public By WorkShiftTextLocator =By.cssSelector("h6[class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]");
    public By AddWorkshiftButtonLocator =By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    public By ShiftNameLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input");
    public By AssignedEmployeeLocator=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div/div[2]/div/div[1]/input");
    public By AddWorkShiftTextLocator=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6");
    public By saveButtonShiftLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]");
    public By LastWorkShiftTextLocator =By.cssSelector("h6[class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]");
    public By PIMButtonLocator = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    public By WorkshiftLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/h6");


    /******************************************************************/
    // Constructor
    public AdminPage(WebDriver driver) {
        this.AdminDriver = driver;
    }

    // Methods


    // Updated method to select User Role from a custom dropdown
    public void selectUserRole(String role) {
        // Click the dropdown to expand options
        WebElement userRoleDropdown = AdminDriver.findElement(UserroleDropdownLocator);
        userRoleDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "ESS" or "Admin"
        WebElement roleOption = AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + role + "']"));

        // Click on the desired option
        roleOption.click();
    }

    // Updated method to select Status from a custom dropdown
    public void selectStatus(String status) {
        // Click the dropdown to expand options
        WebElement statusDropdown = AdminDriver.findElement(StatusDropdownLocator);
        statusDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "Enabled" or "Disabled"
        WebElement statusOption = AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + status + "']"));

        // Click on the desired option
        statusOption.click();
    }

    public void clickAddButton() {
        AdminDriver.findElement(AddButtonLocator).click();
    }
    public void clickSaveButton() {
        AdminDriver.findElement(SaveButtonLocator).click();
    }


    public void typeEmployeeNameAndSelectFirst(String employeeName) {
        // Type the employee name (partial name)
        WebElement employeeNameInput = AdminDriver.findElement(EmployeeNameLocator);
        employeeNameInput.sendKeys(employeeName);  // Type the partial employee name

        // Wait for the dropdown to populate and become visible
        WebDriverWait wait = new WebDriverWait(AdminDriver, Duration.ofSeconds(10)); // Increase the wait time if necessary
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeDropdownOptionsLocator));

        // Get all options from the dropdown
        List<WebElement> dropdownOptions = AdminDriver.findElements(EmployeeDropdownOptionsLocator);

        // Check if the dropdown has any options, then click the first one
        if (!dropdownOptions.isEmpty()) {
            WebElement firstOption = dropdownOptions.get(0);  // Get the first option in the list
            firstOption.click();  // Select the first employee
        } else {
            System.out.println("No options available in the dropdown");
        }
    }


    public void typeUserName(String UserName) {
        WebElement userename = AdminDriver.findElement(UserNameLocator);
        userename.sendKeys(UserName);
    }

    public void typePassword(String password) {
        WebElement Password = AdminDriver.findElement(PasswordLocator);
        Password.sendKeys(password);
    }

    public void typeconfirmPassword(String confirmpassword) {
        WebElement ConfirmPassword = AdminDriver.findElement(ConfirmpasswordLocator);
        ConfirmPassword.sendKeys(confirmpassword);
    }

    /**********************************Search**********************/
    public void typeUserName2(String UserName) {
        WebElement userename = AdminDriver.findElement(UserName2Locator);
        userename.sendKeys(UserName);
    }

    public void typeEmployeeNameAndSelectFirst2(String employeeName) {
        // Type the employee name (partial name)
        WebElement employeeNameInput = AdminDriver.findElement(EmpolyeeName2Locator);
        employeeNameInput.sendKeys(employeeName);  // Type the partial employee name

        // Wait for the dropdown to populate and become visible
        WebDriverWait wait = new WebDriverWait(AdminDriver, Duration.ofSeconds(10)); // Increase the wait time if necessary
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeDropdownOptions2Locator));

        // Get all options from the dropdown
        List<WebElement> dropdownOptions = AdminDriver.findElements(EmployeeDropdownOptions2Locator);

        // Check if the dropdown has any options, then click the first one
        if (!dropdownOptions.isEmpty()) {
            WebElement firstOption = dropdownOptions.get(0);  // Get the first option in the list
            firstOption.click();  // Select the first employee
        } else {
            System.out.println("No options available in the dropdown");
        }
    }
    public void selectStatus2(String status) {
        // Click the dropdown to expand options
        WebElement statusDropdown = AdminDriver.findElement(Status2Locator);
        statusDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "Enabled" or "Disabled"
        WebElement statusOption = AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + status + "']"));

        // Click on the desired option
        statusOption.click();
    }

    public void selectUserRole2(String role) {
        // Click the dropdown to expand options
        WebElement userRoleDropdown = AdminDriver.findElement(UserRole2Locator);
        userRoleDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "ESS" or "Admin"
        WebElement roleOption = AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + role + "']"));

        // Click on the desired option
        roleOption.click();
    }

    public void clickSearchButton() {
        AdminDriver.findElement(SearchButtonLocator).click();
    }
    public String getPersonalName() {
        WebElement personalNameElement = AdminDriver.findElement(PersonalNameLocator);
        return personalNameElement.getText();

    }

    public void SelectJobdropdown( ) {
        // Click the dropdown to expand options
        WebElement jobDropdown = AdminDriver.findElement(JobButtonLocator);
        jobDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "ESS" or "Admin"
        WebElement roleOption = AdminDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[5]/a"));

        // Click on the desired option
        roleOption.click();
    }
    public void AddWorkshiftButton() {
        AdminDriver.findElement(AddWorkshiftButtonLocator).click();
    }
    public void typeShiftName(String ShiftName) {
        WebElement shiftName = AdminDriver.findElement(ShiftNameLocator);
        shiftName.sendKeys(ShiftName);
    }







    public void typeAssignedEmployeeAndSelectFirst(String employeeName) {
        // Type the employee name (partial name)
        WebElement employeeNameInput = AdminDriver.findElement(AssignedEmployeeLocator);
        employeeNameInput.sendKeys(employeeName);  // Type the partial employee name

        // Wait for the dropdown to populate and become visible
        WebDriverWait wait = new WebDriverWait(AdminDriver, Duration.ofSeconds(10)); // Increase the wait time if necessary
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeDropdownOptionsLocator));

        // Get all options from the dropdown
        List<WebElement> dropdownOptions = AdminDriver.findElements(EmployeeDropdownOptionsLocator);

        // Check if the dropdown has any options, then click the first one
        if (!dropdownOptions.isEmpty()) {
            WebElement firstOption = dropdownOptions.get(0);  // Get the first option in the list
            firstOption.click();  // Select the first employee
        } else {
            System.out.println("No options available in the dropdown");
        }
    }

    public void clickSaveShiftButton()
    {
        AdminDriver.findElement(saveButtonShiftLocator).click();
    }

    public PIMPage goTopimPage() {
        WebElement pimButtonElement = AdminDriver.findElement(PIMButtonLocator);
        pimButtonElement.click(); // Click the PIM button

        return new PIMPage(AdminDriver);  // Return the PIMPage instance
    }





}




