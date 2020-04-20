package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    public static Properties prop;
    public static Properties testdata;

    public BaseTest(){
        try {

            prop = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/test/java/config/config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/test/java/testdata/testdata.properties");
            testdata.load(file);
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

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/src/main/resources/chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new ChromeDriver(capabilities);

        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                    "/src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else if(prop.getProperty("browser").equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +
                    "/src/main/resources/IEDriverServer.exe");
            driver= new InternetExplorerDriver();
        }

        if(prop.getProperty("deleteAllCookies").equalsIgnoreCase("true")) {
            driver.manage().deleteAllCookies();
        }
        if(prop.getProperty("windowsMaximize").equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);

        driver.get(prop.getProperty("URL"));

    }

    //Czynności zamykające testy
    @AfterTest
    public void closeBrowser() {
        System.out.println("AfterTest");
        driver.quit();
    }
}
