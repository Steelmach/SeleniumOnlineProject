package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends BasePage  {


    /**** zmienne ****/
    String correctNameAccount = "Jan Testowy1";

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
    public String getNameAccount(){
        String  nameAccount = nameAccountLabel.getText();
        System.out.println("Jesteś zalogowany jako: " + nameAccount);
        return nameAccount;
    }

    public OrderConfirmedPage goToOrders(){
        zamowieniaMenuBoczne.click();
        return new OrderConfirmedPage(driver);
    }

    public AddressPage goToAddresses(){
        adresyMenuBoczne.click();
        return new AddressPage(driver);
    }


}
