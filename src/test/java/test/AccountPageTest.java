package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import base.*;

public class AccountPageTest extends TestBase {
    LoginPage loginPage;
    AccountPage accountPage;


    /********* konstruktor ***********/
    public AccountPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        accountPage = new AccountPage();

        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



    /*********  TESTY *********/
   @Test(priority = 0)
    public void verifyNameAccountAfterLogin(){
        Assert.assertEquals(accountPage.getNameAccount(), testdata.getProperty("correctNameAccount"),
                "Nie jesteś zalogowany na własciwe konto! Proszę o wylogowanie się");
   }



}
