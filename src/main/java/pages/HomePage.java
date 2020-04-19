package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  extends  BasePage{

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/sklep/']")
    private WebElement shoptMenu;



    private String loginPageURL = "http://www.selenium-shop.pl/moje-konto/";

    /**** konstruktor ****/
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/
    public ShopPage goToShopPage(){
        shoptMenu.click();
        return new ShopPage(driver);
    }





}
