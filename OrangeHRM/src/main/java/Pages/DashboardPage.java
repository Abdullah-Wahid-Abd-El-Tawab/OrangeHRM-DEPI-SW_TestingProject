//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver DashboardPageDriver;
    WebDriverWait wait;
//    public By DashboardLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By PIMButtonLocator = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    public By AdminButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    public By textForLogoutLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");
    public By RecruitmentButtonLocator =  By.xpath("//a[contains(@href, 'Recruitment')]");
    public By BuzzButtonLocator = By.xpath("//a[contains(@href, 'Buzz')]");
    public By DashboardLocator = By.xpath("//a[@href='/web/index.php/dashboard/index']");
    public By BuzzLastPost = By.xpath("(//div[@class=\"oxd-grid-item oxd-grid-item--gutters orangehrm-buzz-widget-card\"])[1]");
    public DashboardPage(WebDriver driver) {
        this.DashboardPageDriver = driver;
    }

    public AdminPage goToAdminPage() {
        WebElement AdminButton = this.DashboardPageDriver.findElement(this.AdminButtonLocator);
        AdminButton.click();
        return new AdminPage(this.DashboardPageDriver);
    }

    public BuzzPage goToBuzzPage() {
        WebElement BuzzButton = this.DashboardPageDriver.findElement(this.BuzzButtonLocator);
        BuzzButton.click();
        return new BuzzPage(this.DashboardPageDriver);
    }

    public RecruitmentPage goToRecruitmentPage() {
        WebElement RecruitmentButton = this.DashboardPageDriver.findElement(this.RecruitmentButtonLocator);
        RecruitmentButton.click();
        return new RecruitmentPage(this.DashboardPageDriver);
    }

    public DashboardPage goToDashboardPage() {
        WebElement DashboardButton = this.DashboardPageDriver.findElement(this.DashboardLocator);
        DashboardButton.click();
        return new DashboardPage(this.DashboardPageDriver);
    }


    public PIMPage goTopimPage() {
        WebElement pimButton = this.DashboardPageDriver.findElement(this.PIMButtonLocator);
        pimButton.click();
        return new PIMPage(this.DashboardPageDriver);
    }

    public LogoutPage goTologoutPage() {
        WebElement LogoutElement = this.DashboardPageDriver.findElement(this.textForLogoutLocator);
        LogoutElement.click();
        return new LogoutPage(this.DashboardPageDriver);
    }

    public void waitForElement(By locator, int seconds) {
        this.wait = new WebDriverWait(this.DashboardPageDriver, Duration.ofSeconds(seconds));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getBuzzPostWithIndex() {

        this.waitForElement(BuzzLastPost,10);
        WebElement BuzzText = this.DashboardPageDriver.findElement(this.BuzzLastPost);
        WebElement paragraphElement = this.DashboardPageDriver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[4]/div/div[2]/div/div[1]/p"));
        return paragraphElement.getText();
    }
}
