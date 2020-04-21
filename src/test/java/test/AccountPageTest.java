package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import base.*;

public class AccountPageTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;


    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage();
        accountPage = new AccountPage();

        accountPage = loginPage.login(testdata.getProperty("userLogin"),testdata.getProperty("userPassword"));
    }


   @Test(priority = 0)
  public void verifyNameAccountAfterLogin(){
        Assert.assertEquals(accountPage.getNameAccount(), testdata.getProperty("correctNameAccount"),
                "Nie jesteś zalogowany na własciwe konto! Proszę o wylogowanie się");
   }



}
