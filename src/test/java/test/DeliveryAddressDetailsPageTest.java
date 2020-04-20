package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class DeliveryAddressDetailsPageTest extends BaseTest{
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    DeliveryAddressDetailsPage deliveryAddressDetailsPage;

    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        addressPage = new AddressPage(driver);
        deliveryAddressDetailsPage = new DeliveryAddressDetailsPage(driver);

        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        addressPage = accountPage.goToAddresses();
        deliveryAddressDetailsPage = addressPage.goToAddDeliveryAddress();

    }


    @Test(priority = 0)
    public void addDeliveryAddress() {
        addressPage = deliveryAddressDetailsPage.fillForm("Jan","Testowy2","Polska",
                "Słoneczna","00-001","Warszawa");

        Assert.assertEquals(addressPage.getInfoDeliveryAddress(),
                "Jan Testowy2\n" +
                "Polska\n" +
                "00-001 Warszawa");
    }

}
