package TestCases;

import Pages.P01_LoginPage;
import Pages.P06_EditAccount;
import Util.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_EditAccountTest extends TestBase {
    String userName = "mngr578408";
    String Password = "ezejUvU";
    String EditMsg = "Edit Account Form";

    @Test(priority = 3, description = "Edit Account with Valid Data", groups = "smoke")
    public void EditAccount_P() {
        String accountID = Utility.TestContext.getAccountID(); // Retrieve the dynamically captured account ID
        System.out.println("Editing Account with Account ID: " + accountID);

        new P01_LoginPage(driver).setUserID(userName).setPassword(Password).clickLogin();
        new P06_EditAccount(driver)
                .ClickEditAccount()
                .setEditAccountNumber(accountID);

        // Perform assertions
        Assert.assertTrue(new P06_EditAccount(driver).VerifyEditMessageDisplayed(EditMsg), "Account creation not completed");

    }
}
