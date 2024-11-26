package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuzzPage {
    WebDriver BuzzPageDriver;
    WebDriverWait wait;

    //************************************** Locators **************************************//
    public By PostTextBox = By.xpath("//textarea");
    public By AddVideo = By.xpath("//button[.//span[contains(@class, 'videoglass')]]");
    public By PostButton = By.xpath("//button[@type='submit']");

    // Constructor
    public BuzzPage(WebDriver driver) {
        this.BuzzPageDriver = driver;
        this.wait = new WebDriverWait(this.BuzzPageDriver, Duration.ofSeconds(30));
    }

    // Type a post in the post text box
    public void typePost(String postContent) {
        WebElement postTextBoxElement = this.BuzzPageDriver.findElement(PostTextBox);
        wait.until(ExpectedConditions.visibilityOf(postTextBoxElement));
        postTextBoxElement.clear();
        postTextBoxElement.sendKeys(postContent);
    }

    // Click the Post button
    public void clickPostButton() {
        WebElement postButtonElement = this.BuzzPageDriver.findElement(PostButton);
        wait.until(ExpectedConditions.elementToBeClickable(postButtonElement));
        postButtonElement.click();
    }

    // Method to get the posted content (assuming it appears as text in a div or similar element)
    public String getPostedContent(String postContent) {
        By postedContentLocator = By.xpath("//div[contains(text(), '" + postContent + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(postedContentLocator));
        WebElement postedContentElement = this.BuzzPageDriver.findElement(postedContentLocator);
        return postedContentElement.getText();
    }
}
