package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ProductListPage {
    private WebDriver driver;




    /**** repozytorium elementów ****/
    //  @FindBy(id = "username")
    // private WebElement loginInput;




    /**** konstruktor ****/
    public ProductListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/


    //   public AccountPage login(String login, String password){
    //      setLoginInput(login);
    //      setPasswordInput(password);
    //      clickLoginButton();

    //       return new AccountPage(driver);
    //   }




}