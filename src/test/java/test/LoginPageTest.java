package test;
import pages.*;

import org.testng.Assert;
import org.testng.annotations.*;


public class LoginPageTest extends BaseTest {
    LoginPage loginPage;


    @BeforeTest
    public void prepareTest(){
        loginPage = new LoginPage(driver);
    }


    @Test(priority = 0)
    public void verifyPageTitle(){
        Assert.assertTrue(loginPage.getPageTitle().equals(testdata.getProperty("correctLoginPageTitle")));
    }


}
