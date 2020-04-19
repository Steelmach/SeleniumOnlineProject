package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ShopPage extends BasePage {


    @FindBy(xpath = "//ul[contains(@class,'products')]/li")
    List<WebElement> productsItems;

    @FindBy(xpath = "//ul[contains(@class,'products')]/li/a/h2")
    List<WebElement> productsName;

    @FindBy(name = "orderby")
    WebElement lista;

    public ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);


    }

    public int getProductsNumber() {
        int allProductsNumber = productsItems.size();
        return allProductsNumber;
    }

    public ArrayList getProductsNameAfterOrderByPrice() {
        Select orderByList = new Select(lista);
        orderByList.selectByValue("price");
        ArrayList productsNameList = new ArrayList();
        for (int i = 0; i < productsItems.size(); i++) {
            productsNameList.add(productsName.get(i).getText());
            System.out.println(productsNameList.get(i));
        }
        return productsNameList;

    }
}