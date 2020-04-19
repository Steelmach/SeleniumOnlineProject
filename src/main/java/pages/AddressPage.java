package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressPage extends  BasePage{

    /**** repozytorium elementów ****/
   @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*//parent::*/address")
   private WebElement infoDeliveryAddress;

    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*/a")
    private WebElement addDeliveryAddress;

    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*/parent::*/address")
    private WebElement deliveryAddress;



    /**** konstruktor ****/
    public AddressPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/
   public String getInfoDeliveryAddress(){
       String message = infoDeliveryAddress.getText();
       System.out.println("Message delivery address: " + message);
       return message;
   }

   public DeliveryAddressDetailsPage goToAddDeliveryAddress(){
       addDeliveryAddress.click();
       return new DeliveryAddressDetailsPage(driver);
   }

   public String getDeliveryAddress(){
       String address = deliveryAddress.getText();
       return address;
   }




}
