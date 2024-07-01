package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_DeleteAccount {
    WebDriver driver;

    private final By DeleteAccountNo = By.xpath("//input[@name='accountno']");
    private final By DeleteAccount = By.xpath("//a[normalize-space()='Delete Account']");
    private final By DeleteMessage = By.xpath("//p[@class='heading3']");
    private final By Submit = By.xpath("//input[@name='AccSubmit']");

    public P07_DeleteAccount(WebDriver driver) {
        this.driver = driver;
    }

    public P07_DeleteAccount ClickDeleteAccount() {
        driver.findElement(DeleteAccount).click();
        return this;
    }

    public P07_DeleteAccount setDeleteAccountNumber(String accountID) {
        driver.findElement(DeleteAccountNo).sendKeys(accountID);
        return this;
    }

    public P07_DeleteAccount ClickSubmit (){
        driver.findElement(Submit).click();
        return this;
    }

    public void acceptConfirmationPopup() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean VerifyDeleteMessageDisplayed(String deleteMsg) {
        return driver.findElement(DeleteMessage).getText().contains(deleteMsg);
    }
}
