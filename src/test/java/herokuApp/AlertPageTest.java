package herokuApp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.AlertPage;

public class AlertPageTest extends Base{
    static AlertPage alertPage;


    public AlertPageTest(WebDriver driver) {
        super(driver);
    }

    @Test
    public static void verifyAlert(){
        alertPage = new AlertPage(driver);
        alertPage.clickAlertBox();
        Assert.assertTrue(alertPage.isAlertPresent());

    }

}
