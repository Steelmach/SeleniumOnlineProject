package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.LoginPage;


public class AccountPageTest extends BaseTest {
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeTest
    public void setUpBeforeClass(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        accountPage = loginPage.login(testdata.getProperty("userLogin"),testdata.getProperty("userPassword"));
    }


   @Test(priority = 1)
  public void verifyNameAccountAfterLogin(){


        Assert.assertEquals(accountPage.getNameAccount(), "Jan Testowy2",
                "Nie jesteś zalogowany na własciwe konto!");
   }



}
