package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class RecruitmentPage {
    WebDriver RecruitmentPageDriver;
    WebDriverWait wait;

    //************************************** Locators **************************************//
    public By MenuImage = By.xpath("//img[@alt='client brand banner']");
    public By RecruitmentButton = By.xpath("//a[contains(@href, 'Recruitment')]");
    public By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    // AddPage
    public By FirstName = By.xpath("//input[@name='firstName']");
    public By MiddleName = By.xpath("//input[@name='middleName']");
    public By LastName = By.xpath("//input[@name='lastName']");
    public By VacancyDropdown = By.xpath("//div[contains(@class, 'oxd-select-text--active')]");
    public By Email = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    public By ContactNumber = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    public By ResumeUploadButton = By.xpath("//div[@class='oxd-file-button']");
    public By Keywords = By.xpath("//input[contains(@placeholder, 'Enter')]");
    public By dateOfApplicationInput = By.xpath("//input[@placeholder='yyyy-dd-mm']");
    public By SaveButton = By.xpath("//button[@type='submit']");
    public By FinalName = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[1]/div/div[2]/p");
    // Constructor
    public RecruitmentPage(WebDriver driver) {
        this.RecruitmentPageDriver = driver;
    }

    // Method to click Recruitment button
    public void clickRecruitmentButton() {
        WebElement recruitmentButtonElement = this.RecruitmentPageDriver.findElement(this.RecruitmentButton);
        recruitmentButtonElement.click();
    }

    // Method to click Add button
    public void clickAddButton() {
        WebElement addButtonElement = this.RecruitmentPageDriver.findElement(this.AddButton);
        addButtonElement.click();
    }

    // Method to type in First Name
    public void typeFirstName(String firstName) {
        WebElement firstNameElement = this.RecruitmentPageDriver.findElement(this.FirstName);
        firstNameElement.sendKeys(firstName);
    }
    public void typeMiddleName(String middleName) {
        WebElement middleNameField = this.RecruitmentPageDriver.findElement(this.MiddleName);
        middleNameField.sendKeys(middleName);
    }
    // Method to type in Last Name
    public void typeLastName(String lastName) {
        WebElement lastNameElement = this.RecruitmentPageDriver.findElement(this.LastName);
        lastNameElement.sendKeys(lastName);
    }

    // Method to upload a resume
    public void uploadResume(String filePath) {
        WebElement uploadButton = this.RecruitmentPageDriver.findElement(this.ResumeUploadButton);
        uploadButton.sendKeys(new CharSequence[]{filePath});
    }

    public void typeEmail(String email) {
        WebElement emailField = this.RecruitmentPageDriver.findElement(this.Email);
        emailField.sendKeys(email);
    }

    // Method to type in Contact Number
    public void typeContactNumber(String contactNumber) {
        WebElement contactNumberElement = this.RecruitmentPageDriver.findElement(this.ContactNumber);
        contactNumberElement.sendKeys(contactNumber);
    }

    // Method to select Vacancy from dropdown
    public void selectVacancy(String vacancy) {
        WebElement vacancyDropdown = this.RecruitmentPageDriver.findElement(this.VacancyDropdown);
        vacancyDropdown.click();
        WebElement vacancyOption = this.RecruitmentPageDriver.findElement(By.xpath("//span[text()='" + vacancy + "']"));
        vacancyOption.click();
    }

    // Method to type Date of Application
    public void typeDateOfApplication(String date) {
        WebElement dateOfApplicationElement = this.RecruitmentPageDriver.findElement(this.dateOfApplicationInput);
        //delete old data
        dateOfApplicationElement.sendKeys(Keys.CONTROL + "a");
        dateOfApplicationElement.sendKeys(Keys.DELETE);
        dateOfApplicationElement.sendKeys(date);
    }

    // Method to click Save button
    public void clickSaveButton() {
        WebElement saveButtonElement = this.RecruitmentPageDriver.findElement(this.SaveButton);
        saveButtonElement.click();
    }

    // Utility method to wait for an element
    public void waitForElement(By locator, int seconds) {
        this.wait = new WebDriverWait(this.RecruitmentPageDriver, Duration.ofSeconds(seconds));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public String getFinalNameFromUI() {
        this.waitForElement(FinalName,10);
        WebElement fullNameElement = this.RecruitmentPageDriver.findElement(this.FinalName);
        return fullNameElement.getText();
    }

}
