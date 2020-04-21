package extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import base.TestBase;

public class DriverFactory extends TestBase {

    protected DriverFactory(WebDriver driver) {

    }

    public WebDriver setBrowser(String browser) {
        switch (browser) {
            case "chrome":
                return getChromeDriver();
          //  case "firefox":
              //  return getFirefoxDriver();
           // case "ie":
            //    return getIe();
            default:
                throw new IllegalArgumentException("Provided browser doesn't exist");
        }
    }
        // private WebDriver getFirefoxDriver() {

        //  }
        private WebDriver getChromeDriver() {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/src/main/resources/chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            return driver = new ChromeDriver(capabilities);
        }


    }

