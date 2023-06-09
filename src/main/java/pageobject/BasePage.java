package pageobject;

import implementation.ElementControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;


public class BasePage {
    static WebDriver driver;
    ElementControl elementControl;
    Logger logger;
    public BasePage(WebDriver driver){
        this.driver = driver;
        elementControl = new ElementControl(driver);
        this.logger = Logger.getLogger(this.getClass().getName());
        PageFactory.initElements(driver,this);

    }

}
