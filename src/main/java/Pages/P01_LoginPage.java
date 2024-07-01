package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //TODO Web driver
    WebDriver driver;

    // TODO locators fields
    private final By UserID = By.xpath("//input[@name='uid']");
    private final By Password = By.xpath("//input[@name='password']");
    private final By LOGINBUTTON = By.xpath("//input[@name='btnLogin']");
    private final By successText = By.xpath("//td[normalize-space()='Manger Id : mngr578408']");

    // TODO constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // TODO action methods

    public P01_LoginPage setUserID(String userID) {
        driver.findElement(UserID).sendKeys(userID);
        return this;
    }

    public P01_LoginPage setPassword(String password) {
        driver.findElement(Password).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickLogin() {
        driver.findElement(LOGINBUTTON).click();
        return this;
    }

    // TODO Verify  Manger Id : mngr578408
    public boolean verifySuccessMessage(String welocmeMsg) {
        return driver.findElement(successText).getText().contains(welocmeMsg);
    }
}
