package herokuApp;

import implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.AlertPage;
import pageobject.LandingPage;
import utils.DataReader;
import utils.ExtentReport;
import utils.ScreenShot;

import javax.naming.NameNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class TestHeroku extends LandingPage{
    static Logger logger;


    public TestHeroku(WebDriver driver) {
        super(driver);
    }

    public static void main (String[] args) throws IOException, NameNotFoundException {
        String workingDirectory = System.getProperty("user.dir");
        String configFileName = workingDirectory + "/data/config.properties";
        String pathReport = workingDirectory + "/ReportHeroku/report.html";
        Properties configProperties = DataReader.readProperties(configFileName);
        String browserType = configProperties.getProperty("browserType");
        ExtentReport extentReport = new ExtentReport(pathReport);

        CommonDriver cmnDriver = new CommonDriver(browserType);
        WebDriver driver = cmnDriver.getDriver();
        LandingPage landingPage = new LandingPage(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        landingPage.goTo(configProperties.getProperty("urlHeroku"));
        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickAlertBox();

        Assert.assertTrue(alertPage.isAlertPresent());
        driver.switchTo().alert().getText();
        logger = Logger.getLogger("Logs1");
        logger.info("Alert Box:" + driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

    }

}
