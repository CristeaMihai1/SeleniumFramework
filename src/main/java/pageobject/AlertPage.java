package pageobject;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{


    public AlertPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "alertexamples")
    private WebElement showAlertBox;

    @FindBy(id ="confirmexample")
    private WebElement showConfirmBox;

    @FindBy(id = "promptexample")
    private WebElement showPromptBox;


    public void clickAlertBox() {
        elementControl.clickElement(showAlertBox);
        logger.info("Click on showAlertBox");

    }
    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            logger.info("Allert is present");
            return true;
        }
        catch (NoAlertPresentException e){
            logger.info("Allert is not present");
            return false;

        }
    }

}
