package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;


public class OrderConfirmedPageTest extends BaseTest {
    LoginPage loginPage;
    AccountPage accountPage;
    OrderConfirmedPage orderConfirmedPage;


    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        orderConfirmedPage = new OrderConfirmedPage(driver);

        accountPage = loginPage.login(testdata.getProperty("userLogin"),testdata.getProperty("userPassword"));
        accountPage.goToOrders();
    }

    @Test(priority = 0)
    public void verifyNoOrders(){
        Assert.assertTrue(orderConfirmedPage.getInfoAboutOrders().contains(testdata.getProperty("correctInfoAboutOrder")),
                "Istnieją już złożone zamówienia!");

    }

}
