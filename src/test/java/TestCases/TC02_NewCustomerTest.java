package TestCases;

import Pages.P01_LoginPage;
import Pages.P02_NewCustomer;
import RetryAnalyser.MyRetry;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TC02_NewCustomerTest extends TestBase {

    Faker faker = new Faker();

    String customerName = faker.name().firstName();
    String dateOfBirth = generateRandomBirthDate(faker, 18, 65); // Generate a random birthdate
    String address = faker.address().streetAddress();
    String city = faker.address().city();
    String state = faker.address().state();
    String pin = "375345";                          //faker.address().zipCode();
    String mobileNumber = "01196856848";
    String email = faker.internet().emailAddress(); // Generate a random email
    String password = "P@ssword123";
    String userName = "mngr578408";
    String Password = "ezejUvU";
    String successMsg = "Customer Registered Successfully!!!";

    private String generateRandomBirthDate(Faker faker, int minAge, int maxAge) {
        LocalDate currentDate = LocalDate.now();
        int age = faker.number().numberBetween(minAge, maxAge);
        LocalDate birthDate = currentDate.minusYears(age);
        int dayOfYear = faker.number().numberBetween(1, birthDate.lengthOfYear());
        birthDate = birthDate.withDayOfYear(dayOfYear);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return birthDate.format(formatter);
    }

    @Test(priority = 1, description = "Create New Customer with Valid Data", groups = "smoke", retryAnalyzer = MyRetry.class, timeOut = 20000)
    public void CreateNewCustomer_P() {

        new P01_LoginPage(driver).setUserID(userName).setPassword(Password).clickLogin();
        P02_NewCustomer newCustomerPage = new P02_NewCustomer(driver);
        newCustomerPage.clickNewCustomer()
                .setCustomerName(customerName)
                .setDateOfBirth(dateOfBirth) // Set the birthdate
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setPIN(pin)
                .setMobileNumber(mobileNumber)
                .setEmail(email) // Set the email
                .setPassword(password)
                .clickSubmit();

        Assert.assertTrue(newCustomerPage.verifySuccessMessage(successMsg), "Customer creation not completed");

        // Get and store the customer ID
        String customerID = newCustomerPage.getCustomerID();
        System.out.println("Customer ID: " + customerID);
    }
}
