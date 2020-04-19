package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AddressPage;
import pages.LoginPage;
import pages.OrderConfirmedPage;

public class AddressPageTest extends BaseTest{
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;

    String correctLogin = "UserTest2";
    String correctPassword = "HasloTestowe2";
    String correctInfoAboutDeliveryAddress = "Nie ustawiłeś jeszcze tego adresu.";

    @BeforeTest
    public void setUpBeforeClass(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        addressPage = new AddressPage(driver);
    }


    @Test(priority = 1)
    public void verifyNoDeliveryAddress() {
        accountPage = loginPage.login(correctLogin, correctPassword);

        addressPage = accountPage.goToAddresses();

        Assert.assertTrue(addressPage.getInfoDeliveryAddress().equalsIgnoreCase(correctInfoAboutDeliveryAddress));

    }




}
