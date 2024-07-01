package TestCases;

import Pages.P01_LoginPage;
import RetryAnalyser.MyRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginTest extends TestBase {

    // define test data
    String userName = "mngr578408";
    String Password = "ezejUvU";
    String welocmeMsg = "Manger Id : mngr578408";

    // check login positive scenarios
    @Test(priority = 1, description = "Login with Valid Username and Password", groups = "smoke", retryAnalyzer = MyRetry.class, timeOut = 20000)
    public void loginWithValidData_P() {

        new P01_LoginPage(driver).setUserID(userName).setPassword(Password).clickLogin();

        // TODO assertion
        Assert.assertTrue(new P01_LoginPage(driver).verifySuccessMessage(welocmeMsg), "not completed");
    }
}