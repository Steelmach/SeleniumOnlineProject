package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressPage extends TestBase {


    /**** repozytorium elementów ****/
   @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*//parent::*/address")
   private WebElement infoDeliveryAddress;

    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*/a")
    private WebElement addDeliveryAddress;

    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*/parent::*/address")
    private WebElement deliveryAddress;



    /**** konstruktor ****/
    public AddressPage(){
        PageFactory.initElements(driver, this);
    }


    /****  metody  ****/
    // Przejście do strony z dodaniem/edytowaniem adresy dostowy
    public DeliveryAddressDetailsPage goToAddDeliveryAddress(){
        addDeliveryAddress.click();
        return new DeliveryAddressDetailsPage();
    }

    // Pobranie i zwrócenie komunikatu dotyczącego istnienia adresy dostawy
   public String getInfoDeliveryAddress(){
       String message = infoDeliveryAddress.getText();
       System.out.println("Komunikat adres dostawy: " + message);
       return message;
   }

    // Pobranie i zwrócenie adresu dostawy
   public String getDeliveryAddress(){
       String address = deliveryAddress.getText();
       return address;
   }




}
