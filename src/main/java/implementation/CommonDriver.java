package implementation;

import org.openqa.selenium.WebDriver;

import javax.naming.NameNotFoundException;

public class CommonDriver {
    WebDriver driver;

    public CommonDriver(String browserType) throws NameNotFoundException {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = BrowserManager.getChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = BrowserManager.getFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = BrowserManager.getEdgeDriver();
        }else {
            throw  new NameNotFoundException("Invalid browser type" + browserType);
        }
    }


    public WebDriver getDriver(){
        return driver;
    }
}


