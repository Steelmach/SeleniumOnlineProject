package pages;

import base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DeliveryAddressDetailsPage extends TestBase {


    /**** repozytorium elementów ****/
      @FindBy(id = "shipping_first_name")
      private WebElement name;

     @FindBy(id = "shipping_last_name")
     private WebElement lastName;

     @FindBy(xpath = "//span[@class='select2-selection__arrow']")
     private WebElement arrowInputCountry;

     @FindBy(xpath = "//input[@class='select2-search__field']")
     private  WebElement inputCountry;

     @FindBy(id = "shipping_address_1")
     private  WebElement address;

     @FindBy(id = "shipping_postcode")
     private  WebElement postcode;

     @FindBy(id = "shipping_city")
     private  WebElement city;

     @FindBy(name = "save_address")
     private WebElement saveAddressButton;


    /**** konstruktor ****/
    public DeliveryAddressDetailsPage(){
        PageFactory.initElements(driver, this);
    }


    /****  metody  ****/
    // Wpisanie wartości tekstowej w pole Imię
    public void setName(String nameStr){
        name.clear();
        name.sendKeys(nameStr);
    }

    // Wpisanie wartości tekstowej w pole Nazwisko
    public void setLastName(String lastNameStr){
        lastName.clear();
        lastName.sendKeys(lastNameStr);
    }

    // Wpisanie wartości tekstowej w pole Region
    public void setCountry(String country){
        arrowInputCountry.click();
        inputCountry.sendKeys(country, Keys.ENTER);

    }

    // Wpisanie wartości tekstowej w pole Ulica
    public void setAddress(String addressStr){
        address.clear();
        address.sendKeys(addressStr);
    }

    // Wpisanie wartości tekstowej w pole Kod Pocztowy
    public void setPostcode(String postcodeStr){
        postcode.clear();
        postcode.sendKeys(postcodeStr);
    }

    // Wpisanie wartości tekstowej w pole Miasto
    public void setCity(String cityStr){
        city.clear();
        city.sendKeys(cityStr);
    }

    // Kliknięcie przycisku: Zapisz adres
    public void clickSaveAddressButton() {
        saveAddressButton.click();
    }

    // Metoda wykonująca pełną akcję uzupełniania formularza adresy dostawy
    // zwracająca stronę AddressPage
    public AddressPage fillForm(String nameStr, String lastNameStr, String countryStr, String addressStr, String postcodeStr,
                         String cityStr) {
        setName(nameStr);
        setLastName(lastNameStr);
        setCountry(countryStr);
        setAddress(countryStr);
        setPostcode(postcodeStr);
        setCity(cityStr);
        clickSaveAddressButton();
        return new AddressPage();
    }

}
