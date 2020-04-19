package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static Properties prop;


    public BaseTest(){
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/config/config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Konfiguracja początkowa
    @BeforeTest
    public void startSetUp() {

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new ChromeDriver(capabilities);

        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("ie")){

        }



        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);

        driver.get(prop.getProperty("url"));

    }

    //Czynności zamykające testy
    @AfterTest
    public void closeBrowser() {
        System.out.println("AfterTest");
        driver.quit();
    }
}
