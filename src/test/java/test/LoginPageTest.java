package test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.*;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;


    @BeforeTest
    public void setUpBeforeClass(){
        loginPage = new LoginPage(driver);
    }


    @Test
    public void verifyPageTitle(){

        Assert.assertTrue(loginPage.getPageTitle().equals(testdata.getProperty("loginPageCorrectPageTitle")));
    }

}
