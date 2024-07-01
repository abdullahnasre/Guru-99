package TestCases;

import Pages.P01_LoginPage;
import Pages.P05_NewAccount;
import Util.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_AccountGeneratedTest extends TestBase {
    String userName = "mngr578408";
    String Password = "ezejUvU";
    String initialDeposit = "10000";
    String accountMsg = "Account Generated Successfully!!!"; // Expected message

    @Test(priority = 2, description = "Create Account with Valid Data", groups = "smoke")
    public void CreateAccount_P() {
        String customerID = Utility.TestContext.getCustomerID(); // Retrieve the dynamically captured customer ID
        System.out.println("Created Account with Customer ID: " + customerID);

        new P01_LoginPage(driver).setUserID(userName).setPassword(Password).clickLogin();
        P05_NewAccount newAccountPage = new P05_NewAccount(driver);
        newAccountPage.ClickNewAccount()
                .setCustomerID(customerID)
                .SetInitialDeposit(initialDeposit)
                .ClickSubmit();

        // Assert that the account generation confirmation message appeared
        Assert.assertTrue(newAccountPage.VerifyAccountGeneratedSuccessfully(accountMsg), "Account creation not completed");

        // Retrieve and store the generated account ID
        String accountID = driver.findElement(By.xpath("//td[text()='Account ID']/following-sibling::td")).getText();
        Utility.TestContext.setAccountID(accountID);
    }
}
