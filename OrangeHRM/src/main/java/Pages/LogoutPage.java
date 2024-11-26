package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {

    WebDriver logoutDriver;
    //Locators
    public By textForLogoutLocator=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");


    // Constructor
    public LogoutPage(WebDriver driver) {
        this.logoutDriver = driver;
    }

    //methods
    public void selectLogoutfromdropdown(String status) {
        // Click the dropdown to expand options
        // WebElement logoutDropdown = logoutDriver.findElement(textForLogoutLocator);
        //logoutDropdown.click(); // Open the dropdown

        // Now find the option with the visible text "Single"
        WebElement statusOption =logoutDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));

        // Click on the desired option
        statusOption.click();
    }


}
