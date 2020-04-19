package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.OrderConfirmedPage;

public class OrderConfirmedPageTest extends BaseTest {
    LoginPage loginPage;
    AccountPage accountPage;
    OrderConfirmedPage orderConfirmedPage;

    String correctLogin = "UserTest2";
    String correctPassword = "HasloTestowe2";
    String correctInfoAboutOrder = "Żadne zamówienia nie zostały jeszcze złożone.";

    @BeforeClass
    public void setUpBeforeClass(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        orderConfirmedPage = new OrderConfirmedPage(driver);

        accountPage = loginPage.login(correctLogin,correctPassword);

        accountPage.goToOrders();

    }

    @Test(priority = 1)
    public void verifyNoOrders(){

        //tak to ma być zrobione
        Assert.assertTrue(orderConfirmedPage.getInfoAboutOrders().contains(correctInfoAboutOrder), "Istnieją złożone zamówienia");


    }

}
