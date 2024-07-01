package TestCases;

import Pages.P01_LoginPage;
import Pages.P07_DeleteAccount;
import Util.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_DeleteAccountTest extends TestBase {
    String userName = "mngr578408";
    String Password = "ezejUvU";
    String deleteMsg = "Delete Account Form";

    @Test(priority = 4, description = "Delete Account with Valid Data", groups = "smoke")
    public void DeleteAccount_P() {
        String accountID = Utility.TestContext.getAccountID(); // Retrieve the dynamically captured account ID
        System.out.println("Deleting Account with Account ID: " + accountID);

        new P01_LoginPage(driver).setUserID(userName).setPassword(Password).clickLogin();
        new P07_DeleteAccount(driver)
                .ClickDeleteAccount()
                .setDeleteAccountNumber(accountID);

        // Perform assertions
        Assert.assertTrue(new P07_DeleteAccount(driver).VerifyDeleteMessageDisplayed(deleteMsg), "Account creation not completed");

    }
}
