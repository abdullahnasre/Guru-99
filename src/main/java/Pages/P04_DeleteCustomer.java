package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_DeleteCustomer {
    // TODO Web driver
    WebDriver driver;

    private final By DeleteCustomer = By.xpath("//a[normalize-space()='Delete Customer']");
    private final By CustomerID = By.xpath("//input[@name='cusid']");
    private final By Submit = By.xpath("//input[@name='AccSubmit']");

    public P04_DeleteCustomer(WebDriver driver) {
        this.driver = driver;
    }

    public P04_DeleteCustomer clickDeleteCustomer() {
        driver.findElement(DeleteCustomer).click();
        return this;
    }

    public P04_DeleteCustomer setCustomerID(String customerID) {
        driver.findElement(CustomerID).sendKeys(customerID);
        return this;
    }

    public P04_DeleteCustomer clickSubmit() {
        driver.findElement(Submit).click();
        return this;
    }

    public void acceptConfirmationPopup() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
