package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;


public class AccountPageTest extends BaseTest {
    LoginPage loginPage;
    AccountPage accountPage;


    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        accountPage = loginPage.login(testdata.getProperty("userLogin"),testdata.getProperty("userPassword"));
    }


   @Test(priority = 0)
  public void verifyNameAccountAfterLogin(){
        Assert.assertEquals(accountPage.getNameAccount(), testdata.getProperty("correctNameAccount"),
                "Nie jesteś zalogowany na własciwe konto! Proszę o wylogowanie się");
   }



}
