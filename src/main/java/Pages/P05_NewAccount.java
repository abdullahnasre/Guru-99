package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_NewAccount {
    //TODO Web driver
    WebDriver driver;

    //TODO Locators
    private final By CustomerId = By.xpath("//input[@name='cusid']");
    private final By InitialDeposit = By.xpath("//input[@name='inideposit']");
    private final By SubmitButton = By.xpath("//input[@name='button2']");
    private final By accountGenerated = By.xpath("//p[@class='heading3']");
    private final By NewAccount = By.xpath("//a[normalize-space()='New Account']");

    // TODO constructor
    public P05_NewAccount(WebDriver driver) {
        this.driver = driver;
    }

    // TODO Action methods
    public P05_NewAccount ClickNewAccount() {
        driver.findElement(NewAccount).click();
        return this;
    }

    public P05_NewAccount SetInitialDeposit(String initialDeposit) {
        driver.findElement(InitialDeposit).sendKeys(initialDeposit);
        return this;
    }

    public P05_NewAccount setCustomerID(String customerID) {
        driver.findElement(CustomerId).sendKeys(customerID);
        return this;
    }

    public P05_NewAccount ClickSubmit() {
        driver.findElement(SubmitButton).click();
        return this;
    }

    // TODO Assertion
    public boolean VerifyAccountGeneratedSuccessfully(String accountMsg) {
        return driver.findElement(accountGenerated).getText().contains(accountMsg);
    }
}
