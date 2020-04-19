package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderConfirmedPage extends BasePage{





    /**** repozytorium elementów ****/
     @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/div[2]")
    private WebElement infoAboutOrders;




    /**** konstruktor ****/
    public OrderConfirmedPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/
    public String getInfoAboutOrders(){
        String message = infoAboutOrders.getText();
        System.out.println("MessageAboutOrders: " + message);
        return message;
    }






}
