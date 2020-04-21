package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import base.*;


public class OrderConfirmedPageTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;
    OrderConfirmedPage orderConfirmedPage;


    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        orderConfirmedPage = new OrderConfirmedPage();

        accountPage = loginPage.login(testdata.getProperty("userLogin"),testdata.getProperty("userPassword"));
        accountPage.goToOrders();
    }

    @Test(priority = 0)
    public void verifyNoOrders(){
        Assert.assertTrue(orderConfirmedPage.getInfoAboutOrders().contains(testdata.getProperty("correctInfoAboutOrder")),
                "Istnieją już złożone zamówienia!");

    }

}
