package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends BasePage  {


    /**** repozytorium elementów ****/
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/p/strong")
    private WebElement nameAccountLabel;

    @FindBy(xpath = "//a[contains(text(),'Zamówienia')]")
    private WebElement zamowieniaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(),'Adresy')]")
    private WebElement adresyMenuBoczne;


    /**** konstruktor ****/
    public AccountPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    /****  metody  ****/
    // Pobranie i zwrócenie nazwy konta (imie i nazwisko)
    public String getNameAccount(){
        String  nameAccount = nameAccountLabel.getText();
        System.out.println("Jesteś zalogowany jako: " + nameAccount);
        return nameAccount;
    }

    // Przejście na zakładkę Zamówienia (dotyczny zamówień potwierdzonych)
    public OrderConfirmedPage goToOrders(){
        zamowieniaMenuBoczne.click();
        return new OrderConfirmedPage(driver);
    }

    // Przejście na zakładkę Adresy
    public AddressPage goToAddresses(){
        adresyMenuBoczne.click();
        return new AddressPage(driver);
    }


}
