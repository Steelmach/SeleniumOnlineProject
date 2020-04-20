package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;


public class AddressPageTest extends BaseTest{
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;




    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        addressPage = new AddressPage(driver);

        accountPage = loginPage.login(testdata.getProperty("userLogin"),testdata.getProperty("userPassword"));
        addressPage = accountPage.goToAddresses();
    }


    @Test(priority = 0)
    public void verifyNoDeliveryAddress() {
        Assert.assertTrue(addressPage.getInfoDeliveryAddress().equalsIgnoreCase
                (testdata.getProperty("correctInfoAboutDeliveryAddress")));

    }

}
