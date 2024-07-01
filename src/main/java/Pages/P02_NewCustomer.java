package Pages;

import Util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_NewCustomer {
    WebDriver driver;
    private final WebDriverWait wait;

    private final By NewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private final By CustomerName = By.xpath("//input[@name='name']");
    private final By DateOfBirth = By.xpath("//input[@id='dob']");
    private final By Address = By.xpath("//textarea[@name='addr']");
    private final By City = By.xpath("//input[@name='city']");
    private final By State = By.xpath("//input[@name='state']");
    private final By PIN = By.xpath("//input[@name='pinno']");
    private final By MobileNumber = By.xpath("//input[@name='telephoneno']");
    private final By Email = By.xpath("//input[@name='emailid']");
    private final By Password = By.xpath("//input[@name='password']");
    private final By Submit = By.xpath("//input[@name='sub']");
    private final By successText = By.xpath("//p[@class='heading3']");
    private final By customerID = By.xpath("//td[normalize-space()='Customer ID']/following-sibling::td");

    public P02_NewCustomer(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public P02_NewCustomer clickNewCustomer() {
        driver.findElement(NewCustomer).click();
        return this;
    }

    public P02_NewCustomer setCustomerName(String customerName) {
        driver.findElement(CustomerName).sendKeys(customerName);
        return this;
    }

    public P02_NewCustomer setDateOfBirth(String dateOfBirth) {
        driver.findElement(DateOfBirth).sendKeys(dateOfBirth);
        return this;
    }

    public P02_NewCustomer setAddress(String address) {
        driver.findElement(Address).sendKeys(address);
        return this;
    }

    public P02_NewCustomer setCity(String city) {
        driver.findElement(City).sendKeys(city);
        return this;
    }

    public P02_NewCustomer setState(String state) {
        driver.findElement(State).sendKeys(state);
        return this;
    }

    public P02_NewCustomer setPIN(String pin) {
        driver.findElement(PIN).sendKeys(pin);
        return this;
    }

    public P02_NewCustomer setMobileNumber(String mobileNumber) {
        driver.findElement(MobileNumber).sendKeys(mobileNumber);
        return this;
    }

    public P02_NewCustomer setEmail(String email) {
        driver.findElement(Email).sendKeys(email);
        return this;
    }

    public P02_NewCustomer setPassword(String password) {
        driver.findElement(Password).sendKeys(password);
        return this;
    }

    public P02_NewCustomer clickSubmit() {
        driver.findElement(Submit).click();
        return this;
    }

    public boolean verifySuccessMessage(String successMsg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successText));
        return driver.findElement(successText).getText().contains(successMsg);
    }

    public String getCustomerID() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerID));
        String id = driver.findElement(customerID).getText();
        Utility.TestContext.setCustomerID(id);
        return id;
    }
}
