package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PIMPage {
    // Driver
    WebDriver PIMPageDriver;
    WebDriverWait wait;

    // Locators
    public By PIMLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By AddEmpolyeeLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By PIMButtonLocator = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    public By AddButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    public By FirstNameLocator = By.xpath("//input[@placeholder='First Name']");
    public By LastNameLocator = By.xpath("//input[@placeholder='Last Name']");
    public By SaveButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
    public By PersonalNameLocator = By.xpath("//div[@class=\"orangehrm-edit-employee-name\"]/h6");
    public By PersonalDetailsLocator = By.xpath("//a[ contains(text(), \"Personal Details\")]");
    public By EmpolyeePictureLocator =By.cssSelector("img[class=\"employee-image\"]");
    public By UploadButtonLocator = By.cssSelector("input[type='file']");
    public By EmployeeIDLocator =By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
    public By OtherIDLoactor = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input");
    public By DriverLicenseNumberLocator=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input");
    public By LicenseExpiryDateLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input");
    public By NationalitydropdownLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]");
    public By MaritalStatusdropdownLocator=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]");
    public By DateofBirthLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input");
    public By GenderFemaleLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label");
    public By EmployeefullnametextLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[1]/label");
    public By NationalityOptionsLocator = By.xpath("//div[@role='listbox']//span"); // Generic locator for options
    public By MaritalStatusOptionsLocator = By.xpath("//div[@role='listbox']//span");
    public By SaveButtonpimLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button");
    public By ReportLocator=By.xpath("//a[contains(text(),'Reports')]");
    public By ConfigurationLocator=By.cssSelector("span[class=\"oxd-topbar-body-nav-tab-item\"]");
    public By TerminationReasonsLocator =By.cssSelector("p[class=\"oxd-text oxd-text--p orangehrm-main-title\"]");
    public By AddButtonTerminationLocator=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    public By TerminationReasonLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    public By SaveButtonTerminationLocator =By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"");
    public By AddTerminationreasonTextLocator=By.cssSelector("p[class=\"oxd-text oxd-text--p orangehrm-main-title\"]");
    public By RecordsFoundLocator =By.cssSelector("span[class=\"oxd-text oxd-text--span\"]");
    public By recordsTableLocator =By.cssSelector("div[class=\"orangehrm-container\"]");
    public By textForLogoutLocator=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");
    public By EmployeeIDSearch=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");
    public By SearchButtonLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    public By RecordTableEmployeeLoactor =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]");
    public By RecordTableIDLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]");
    public By ContentEmployeeTableLocator =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[4]");
    // Constructor
    public PIMPage(WebDriver driver) {
        this.PIMPageDriver = driver;
    }

    // Actions - methods
    public void typeFirstname(String FirstName) {
        WebElement firstNameElement = PIMPageDriver.findElement(FirstNameLocator);
        firstNameElement.sendKeys(FirstName);
    }
    public void waitForElement(By locator, int seconds) {
        wait = new WebDriverWait(PIMPageDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void typeLastName(String LastName) {
        WebElement lastNameElement = PIMPageDriver.findElement(LastNameLocator);
        lastNameElement.sendKeys(LastName);
    }




    public void IDelement(String EmployeeID) {
        WebElement IDelement = PIMPageDriver.findElement(EmployeeIDLocator);

        // Click the field to make sure it's in focus

        IDelement.sendKeys(EmployeeID);
    }


/*
    public void typeEmployeeID(String EmployeeID) {
        WebElement EmployeeIDElement = PIMPageDriver.findElement(EmployeeIDLocator);

        EmployeeIDElement.sendKeys(EmployeeID); // Send the new EmployeeID
    }

 */

    public void clickSave() {
        WebElement saveButtonElement = PIMPageDriver.findElement(SaveButtonLocator);
        saveButtonElement.click();
    }

    public void clickPIMButton() {
        WebElement pimButtonElement = PIMPageDriver.findElement(PIMButtonLocator);
        pimButtonElement.click();
    }

    public void clickAddButton() {
        WebElement addButtonElement = PIMPageDriver.findElement(AddButtonLocator);
        addButtonElement.click();
    }


    // Fetch the PersonalName text after clicking save
    public String getPersonalName() {
        WebElement personalNameElement = PIMPageDriver.findElement(PersonalNameLocator);
        return personalNameElement.getText();

    }

    public void uploadEmployeePicture(String filePath) {
        WebElement uploadButton = PIMPageDriver.findElement(UploadButtonLocator);
        uploadButton.sendKeys(filePath);
    }
    public void typeotherID(String otherid) {
        WebElement otheridElement = PIMPageDriver.findElement(OtherIDLoactor);
        otheridElement.sendKeys(otherid);
    }
    public void typeDriverlicensenumber(String Driverlicensenumber) {
        WebElement DriverlicenseElement = PIMPageDriver.findElement(DriverLicenseNumberLocator);
        DriverlicenseElement.sendKeys(Driverlicensenumber);
    }
    public void typelicenseDate(String licenseDate) {
        WebElement licenseDateElement = PIMPageDriver.findElement(LicenseExpiryDateLocator);
        licenseDateElement.sendKeys(licenseDate);
    }
    public void typebirthDate(String birthDate) {
        WebElement birthDateElement = PIMPageDriver.findElement(DateofBirthLocator);
        birthDateElement.sendKeys(birthDate);
    }
    public void selectNationality(String nationality) {
        // Click the dropdown to expand options
        WebElement NationalityDropdown = PIMPageDriver.findElement(NationalitydropdownLocator);
        NationalityDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "Afghan"
        WebElement nationalityOption = PIMPageDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + nationality + "']"));

        // Click on the desired option
        nationalityOption.click();
    }

    public void selectMartialStatus(String status) {
        // Click the dropdown to expand options
        WebElement MartialStatusDropdown = PIMPageDriver.findElement(MaritalStatusdropdownLocator);
        MartialStatusDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "Single"
        WebElement statusOption = PIMPageDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + status + "']"));

        // Click on the desired option
        statusOption.click();
    }


    public void clickGender() {
        WebElement GenderButtonElement = PIMPageDriver.findElement(GenderFemaleLocator);
        GenderButtonElement.click();
    }
    public void clicksavepimButton() {
        WebElement addButtonElement = PIMPageDriver.findElement(SaveButtonpimLocator);
        addButtonElement.click();
    }
    public void clickReportButton() {
        WebElement ReportElement = PIMPageDriver.findElement(ReportLocator);
        ReportElement.click();
    }

    public void selectConfigurationStatus(String status) {
        // Click the dropdown to expand options
        WebElement ConfigurationStatusDropdown = PIMPageDriver.findElement(ConfigurationLocator);
        ConfigurationStatusDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "Single"
        WebElement statusOption = PIMPageDriver.findElement(By.xpath("//a[contains(text(),'Termination Reasons')]"));

        // Click on the desired option
        statusOption.click();
    }
    public void AddButtonTermination() {
        WebElement AddButtonTerminationElement = PIMPageDriver.findElement(AddButtonTerminationLocator);
        AddButtonTerminationElement.click();
    }
    public void typeTerminationReason(String TerminationReason) {
        WebElement TerminationReasonElement = PIMPageDriver.findElement(TerminationReasonLocator);

        TerminationReasonElement.sendKeys(TerminationReason); // Send the new EmployeeID
    }
    public void SaveButtonTermination() {
        WebElement SaveButtonTerminationElement = PIMPageDriver.findElement(SaveButtonTerminationLocator);
        SaveButtonTerminationElement.click();
    }


    public boolean isTerminationReasonPresent(String reason) {
        WebElement recordsTable = new WebDriverWait(PIMPageDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(recordsTableLocator));

        List<WebElement> rows = recordsTable.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]"));
        // List<WebElement> rows = recordsTable.findElements(By.xpath("recordsTableLocator"));

        for (WebElement row : rows) {
            System.out.println("Row Text: " + row.getText()); // Debugging Log
            if (row.getText().contains(reason)) {
                return true;
            }
        }
        return false;
    }
    public void searchEmployeeid(String searchTerm) {
        WebElement searchInput = PIMPageDriver.findElement(EmployeeIDSearch);
        searchInput.sendKeys(searchTerm);

    }
    public void SearchButton() {
        WebElement SearchButtonElement = PIMPageDriver.findElement(SearchButtonLocator);
        SearchButtonElement.click();
    }


    public boolean isEmployeeIDPresent(String Employeeid) {
        WebDriverWait wait = new WebDriverWait(PIMPageDriver, Duration.ofSeconds(30));
        WebElement recordsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(RecordTableEmployeeLoactor));

        // Assuming ContentEmployeeTableLocator points to a table header
        WebElement contentEmployeeTable = wait.until(ExpectedConditions.visibilityOfElementLocated(ContentEmployeeTableLocator));

        if (contentEmployeeTable.getText().contains(Employeeid)) {
            return true;
        }

        // More specific XPath for finding the ID within each row
        By recordTableIDLocator = By.xpath("//tr/td[2]"); // Adjust the XPath based on your table's HTML structure

        List<WebElement> rows = recordsTable.findElements(recordTableIDLocator);
        for (WebElement row : rows) {
            System.out.println("Row Text: " + row.getText());
            if (row.getText().contains(Employeeid)) {
                return true;
            }
        }

        return false;
    }
    /*
    public LogoutPage goTologoutPage() {
        WebElement LogoutElement = PIMPageDriver.findElement(textForLogoutLocator);
        LogoutElement.click(); // Click the PIM button

        return new LogoutPage(PIMPageDriver);  // Return the PIMPage instance
    }*/









}