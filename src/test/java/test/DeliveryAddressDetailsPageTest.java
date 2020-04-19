package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AddressPage;
import pages.DeliveryAddressDetailsPage;
import pages.LoginPage;

public class DeliveryAddressDetailsPageTest extends BaseTest{
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    DeliveryAddressDetailsPage billingAddressDetailsPage;

    String correctLogin = "UserTest2";
    String correctPassword = "HasloTestowe2";

    @BeforeTest
    public void setUpBeforeClass(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        addressPage = new AddressPage(driver);
        billingAddressDetailsPage = new DeliveryAddressDetailsPage(driver);
    }


    @Test(priority = 1)
    public void addDeliveryAddress() {
        accountPage = loginPage.login(correctLogin, correctPassword);

        addressPage = accountPage.goToAddresses();

        billingAddressDetailsPage = addressPage.goToAddDeliveryAddress();

        addressPage = billingAddressDetailsPage.fillForm("Jan","Testowy2","Polska",
                                        "Słoneczna","00-001","Warszawa");


    }


}
