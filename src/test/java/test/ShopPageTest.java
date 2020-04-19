package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShopPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopPageTest extends BaseTest {
    HomePage homePage;
    ShopPage shopPage;

    ArrayList<String> correctProductListSortByPriceFromLowest = new ArrayList<>(Arrays.asList
    ("PIŁKA NOŻNA KIPSTA F100", "KOSZULKA NEWCASTLE FC UNITED", "KOSZULKA WEST HAM UNITED", "PIŁKA NOŻNA ADIDAS REPLIKA LIGA MISTRZÓW",
     "PIŁKA NOŻNA ADIDAS EURO 2020", "KOSZULKA TOTTENHAM HOTSPUR F.C.", "KOSZULKA ARSENAL LONDON", "KOSZULKA CHELSEA LONDON",
     "KOSZULKA MANCHESTER UNITED", "KOSZULKA MANCHESTER FC CITY", "KOSZULKA LIVERPOOL FC", "KOSZULKA LEICESTER FC CITY"));




    @BeforeMethod
    public void setUp(){
         homePage = new HomePage(driver);
         shopPage = new ShopPage(driver);

    }

    @Test(priority = 1)
    public void verifyProductNumber(){
        shopPage = homePage.goToShopPage();

        Assert.assertEquals(shopPage.getProductsNumber(),12);
    }

    @Test(priority = 2)
    public void verifySortProducts(){
        shopPage = homePage.goToShopPage();
        Assert.assertEquals(shopPage.getProductsNameAfterOrderByPrice(), correctProductListSortByPriceFromLowest);
    }
}
