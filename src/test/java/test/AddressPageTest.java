package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import base.*;

public class AddressPageTest extends TestBase{
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;




    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        addressPage = new AddressPage();

        accountPage = loginPage.login(testdata.getProperty("userLogin"),testdata.getProperty("userPassword"));
        addressPage = accountPage.goToAddresses();
    }


    @Test(priority = 0)
    public void verifyNoDeliveryAddress() {
        Assert.assertTrue(addressPage.getInfoDeliveryAddress().equalsIgnoreCase
                (testdata.getProperty("correctInfoAboutDeliveryAddress")));

    }

}
