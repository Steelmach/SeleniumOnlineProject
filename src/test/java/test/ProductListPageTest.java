package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import java.util.*;

public class ProductListPageTest extends BaseTest {
    HomePage homePage;
    ProductListPage productListPage;

    ArrayList<String> correctProductListSortByPriceFromLowest = new ArrayList<>(Arrays.asList
            ("PIŁKA NOŻNA KIPSTA F100", "KOSZULKA NEWCASTLE FC UNITED", "KOSZULKA WEST HAM UNITED", "PIŁKA NOŻNA ADIDAS REPLIKA LIGA MISTRZÓW",
                    "PIŁKA NOŻNA ADIDAS EURO 2020", "KOSZULKA TOTTENHAM HOTSPUR F.C.", "KOSZULKA ARSENAL LONDON", "KOSZULKA CHELSEA LONDON",
                    "KOSZULKA MANCHESTER UNITED", "KOSZULKA MANCHESTER FC CITY", "KOSZULKA LIVERPOOL FC", "KOSZULKA LEICESTER FC CITY"));


    @BeforeMethod
    public void prepareTest(){
        homePage = new HomePage(driver);
        productListPage = new ProductListPage(driver);

        productListPage = homePage.goToProductPage();
    }

    @Test(priority = 0)
    public void verifyProductNumber(){
        Assert.assertEquals(productListPage.getProductsNumber(),
                Integer.parseInt(testdata.getProperty("correctProductNumber")));
    }

    @Test(priority = 1)
    public void verifySortProducts(){
        Assert.assertEquals(productListPage.getProductsNameAfterOrderByPrice(), correctProductListSortByPriceFromLowest);
    }
}
