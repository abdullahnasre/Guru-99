package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_EditAccount {
    WebDriver driver;

    private final By EditAccountNo = By.xpath("//input[@name='accountno']");
    private final By EditAccount = By.xpath("//a[normalize-space()='Edit Account']");
    private final By EditMessage = By.xpath("//p[@class='heading3']");

    public P06_EditAccount(WebDriver driver) {
        this.driver = driver;
    }

    public P06_EditAccount ClickEditAccount() {
        driver.findElement(EditAccount).click();
        return this;
    }

    public P06_EditAccount setEditAccountNumber(String accountID) {
        driver.findElement(EditAccountNo).sendKeys(accountID);
        return this;
    }

    // TODO Assertion
    public boolean VerifyEditMessageDisplayed(String EditMsg) {
        return driver.findElement(EditMessage).getText().contains(EditMsg);
    }


}
