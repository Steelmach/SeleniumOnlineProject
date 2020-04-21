package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage  extends TestBase {

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/sklep/']")
    private WebElement shopMenu;


    /**** konstruktor ****/
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/
    // Przejście na stronę sklepu z produktami
    public ProductListPage goToProductPage(){
        shopMenu.click();
        return new ProductListPage();
    }

    // Pobranie i zwrócenie aktualnego tytułu strony
    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("HomePage tytuł: " + title);
        return title;
    }

}
