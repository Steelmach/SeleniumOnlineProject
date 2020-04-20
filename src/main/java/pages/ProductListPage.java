package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductListPage extends BasePage {

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//ul[contains(@class,'products')]/li")
    List<WebElement> productsItems;

    @FindBy(xpath = "//ul[contains(@class,'products')]/li/a/h2")
    List<WebElement> productsName;

    @FindBy(name = "orderby")
    WebElement orderbyList;


    /**** konstruktor ****/
    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);


    }


    /****  metody  ****/
    // Pobranie i zwrócenie ilości produktów
    public int getProductsNumber() {
        int allProductsNumber = productsItems.size();
        return allProductsNumber;
    }

    // Wybranie z listy sortującej, pozycji: Sortuj wg ceny: od najniższej
    public void sortProductByPrice(){
        Select orderByList = new Select(orderbyList);
        orderByList.selectByValue("price");
    }

    // Sortowanie listy po cenie od najniższej
    // pobieranie przesortowanej listy produktów
    // Wypisywanie produktów do konsoli
    public ArrayList getProductsNameAfterOrderByPrice() {
        sortProductByPrice();
        ArrayList productsNameList = new ArrayList();
        for (int i = 0; i < productsItems.size(); i++) {
            productsNameList.add(productsName.get(i).getText());
            System.out.println(productsNameList.get(i));
        }
        return productsNameList;
    }

}