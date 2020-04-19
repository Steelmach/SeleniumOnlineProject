package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//a[@href='http://www.selenium-shop.pl/moje-konto/']")
    private WebElement myAccountMenu;

    @FindBy(id = "username")
    public WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement  logInButton;



    private String loginPageURL = "http://www.selenium-shop.pl/moje-konto/";

    /**** konstruktor ****/
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /****  metody  ****/
    public LoginPage goToLoginPage(){
        myAccountMenu.click();
        return new LoginPage(driver);
    }

    public String getPageTitle(){
        String title = driver.getTitle();
        System.out.println("LoginPage title: " + title);
        return title;
    }

    public void setLoginInput(String login){
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void setPasswordInput(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        logInButton.click();
    }

    public AccountPage login(String login, String password){
        goToLoginPage();
        setLoginInput(login);
        setPasswordInput(password);
        clickLoginButton();

        return new AccountPage(driver);
    }






}
