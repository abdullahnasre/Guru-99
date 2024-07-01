package TestCases;

import Pages.P01_LoginPage;
import Pages.P04_DeleteCustomer;
import RetryAnalyser.MyRetry;
import Util.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_DeleteCustomerTest extends TestBase {

    String userName = "mngr578408";
    String Password = "ezejUvU";

    @Test(priority = 2, description = "Delete Customer with Valid Data", groups = "smoke", retryAnalyzer = MyRetry.class, timeOut = 20000)
    public void DeleteCustomer_P()  {

        String customerID = Utility.TestContext.getCustomerID(); // Retrieve the dynamically captured customer ID
        System.out.println("Deleting Customer ID: " + customerID);

        new P01_LoginPage(driver).setUserID(userName).setPassword(Password).clickLogin();
        P04_DeleteCustomer deleteCustomerPage = new P04_DeleteCustomer(driver);
        deleteCustomerPage.clickDeleteCustomer()
                .setCustomerID(customerID)
                .clickSubmit();

        // Handle confirmation popup
        deleteCustomerPage.acceptConfirmationPopup();

        // Assert that the confirmation popup appeared
        Assert.assertTrue(isConfirmationPopupDisplayed(), "Confirmation popup did not appear");
    }

    private boolean isConfirmationPopupDisplayed() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
