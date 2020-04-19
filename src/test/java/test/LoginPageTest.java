package test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.*;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    String correctPageTitle = "Selenium Shop Automatyzacja Testów";

    @BeforeClass
    public void setUpBeforeClass(){
        loginPage = new LoginPage(driver);


    }


    @Test
    public void verifyPageTitle(){

        Assert.assertTrue(loginPage.getPageTitle().equals(correctPageTitle));
    }
}
