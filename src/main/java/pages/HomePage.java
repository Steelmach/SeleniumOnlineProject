package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage  extends  BasePage{

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/sklep/']")
    private WebElement shopMenu;


    /**** konstruktor ****/
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/
    // Przejście na stronę sklepu z produktami
    public ShopPage goToShopPage(){
        shopMenu.click();
        return new ShopPage(driver);
    }

    // Pobranie i zwrócenie aktualnego tytułu strony
    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("HomePage tytuł: " + title);
        return title;
    }

}
