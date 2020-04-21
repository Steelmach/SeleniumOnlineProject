package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import base.*;

public class DeliveryAddressDetailsPageTest extends TestBase{
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    DeliveryAddressDetailsPage deliveryAddressDetailsPage;

    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        addressPage = new AddressPage();
        deliveryAddressDetailsPage = new DeliveryAddressDetailsPage();

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
