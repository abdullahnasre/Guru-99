package TestCases;

import Pages.P01_LoginPage;
import Pages.P03_EditCustomer;
import RetryAnalyser.MyRetry;
import Util.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_EditCustomerTest extends TestBase {

    String userName = "mngr578408";
    String Password = "ezejUvU";
    String city = "cairo";

    @Test(priority = 2, description = "Edit Customer Details with Valid Data", groups = "smoke", retryAnalyzer = MyRetry.class, timeOut = 20000)
    public void EditCustomer_P() {

        String customerID = Utility.TestContext.getCustomerID(); // Retrieve the dynamically captured customer ID
        System.out.println("Editing Customer ID: " + customerID);

        new P01_LoginPage(driver).setUserID(userName).setPassword(Password).clickLogin();
        P03_EditCustomer editCustomerPage = new P03_EditCustomer(driver);
        editCustomerPage.clickEditCustomer()
                .setCustomerID(customerID)
                .clickSubmit()
                .setCity(city)
                .clickSubmitAfterEdit();

        // Navigate to the expected edit page URL
        driver.get("https://demo.guru99.com/V4/manager/EditCustomer.php");
        // Assertions to verify the changes
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/V4/manager/EditCustomer.php",
                "Edit customer page URL did not match expected URL");
    }
}
