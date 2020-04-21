package test;
import pages.*;
import base.*;

import org.testng.Assert;
import org.testng.annotations.*;


public class LoginPageTest extends TestBase {
    AccountPage accountPage;
    LoginPage loginPage;


    public LoginPageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    // Przed każdym testem uruchomienie przeglądarki
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        accountPage = new AccountPage();

        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));

    }



    @Test(priority = 0)
    public void verifyPageTitle(){
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        Assert.assertTrue(loginPage.getPageTitle().equals(testdata.getProperty("correctLoginPageTitle")));
    }


}
