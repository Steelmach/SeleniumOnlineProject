package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties config;
    public static Properties testdata;



    public TestBase(){
        try {

            config = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/config/config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/testdata/testdata.properties");
            testdata.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void initialization(){
        String browserName = config.getProperty("browser");

        if(config.getProperty("browser").equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/src/main/resources/chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new ChromeDriver(capabilities);

        }
        else if(config.getProperty("browser").equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                    "/src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else if(config.getProperty("browser").equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +
                    "/src/main/resources/IEDriverServer.exe");
            driver= new InternetExplorerDriver();
        }

        if(config.getProperty("deleteAllCookies").equalsIgnoreCase("true")) {
            driver.manage().deleteAllCookies();
        }
        if(config.getProperty("windowsMaximize").equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }




        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);

        driver.get(config.getProperty("URL"));

    }









}