package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_EditCustomer {
    //TODO Web driver
    WebDriver driver;
    private final WebDriverWait wait;

    private final By EditCustomer = By.xpath("//a[normalize-space()='Edit Customer']");
    private final By CustomerID = By.xpath("//input[@name='cusid']");
    private final By Submit = By.xpath("//input[@name='AccSubmit']");
    private final By City = By.xpath("//input[@name='city']");
    private final By submit = By.xpath("//input[@name='sub']");

    public P03_EditCustomer(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public P03_EditCustomer clickEditCustomer() {
        driver.findElement(EditCustomer).click();
        return this;
    }

    public P03_EditCustomer setCustomerID(String customerID) {
        driver.findElement(CustomerID).sendKeys(customerID);
        return this;
    }

    public P03_EditCustomer clickSubmit() {
        driver.findElement(Submit).click();
        return this;
    }

    public P03_EditCustomer setCity(String city) {
        driver.findElement(City).clear();
        driver.findElement(City).sendKeys(city);
        return this;
    }

    public P03_EditCustomer clickSubmitAfterEdit() {
        driver.findElement(submit).click();
        return this;
    }

    public boolean verifyLinkCorrect() {
        driver.get("https://demo.guru99.com/V4/manager/editCustomerPage.php");
        return false;
    }
}
