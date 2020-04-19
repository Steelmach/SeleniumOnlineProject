package test;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AddressPage;
import pages.LoginPage;
import pages.OrderConfirmedPage;


public class AccountPageTest extends BaseTest {
    LoginPage loginPage;
    AccountPage accountPage;
    String correctLogin = "UserTest2";
    String correctPassword = "HasloTestowe2";

    @BeforeTest
    public void setUpBeforeClass(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

    }


   @Test(priority = 1)
  public void verifyNameAccountAfterLogin(){
        accountPage = loginPage.login(correctLogin,);

        Assert.assertEquals(accountPage.getNameAccount(), "Jan Testowy2",
                "Nie jesteś zalogowany na własciwe konto!");
   }



}
