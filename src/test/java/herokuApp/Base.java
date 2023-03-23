package herokuApp;

import com.aventstack.extentreports.Status;
import implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobject.LandingPage;
import utils.DataReader;
import utils.ExtentReport;
import utils.ScreenShot;
import javax.naming.NameNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Base extends LandingPage {
    static WebDriver driver;
    String workingDirectory;
    String configFileName;
    static CommonDriver cmnDriver;
    static String browserType;
    static Properties configProperties;
    String pathReport;
    static LandingPage landingPage;
    ScreenShot screenShot;
    public static ExtentReport extentReport;



    public Base(WebDriver driver) {
        super(driver);
    }


    @BeforeSuite
    public void preSetup() throws IOException {
        workingDirectory = System.getProperty("user.dir");
        configFileName = workingDirectory + "/data/config.properties";
        pathReport = workingDirectory + "/ReportHeroku/report.html";
        configProperties = DataReader.readProperties(configFileName);
        browserType = configProperties.getProperty("browserType");
        extentReport = new ExtentReport(pathReport);
//        extentReport.createTestCare("Log in application");

    }


    @BeforeMethod
    public void setUp() throws NameNotFoundException {
        cmnDriver = new CommonDriver(browserType);
        driver = cmnDriver.getDriver();
        landingPage = new LandingPage(driver);
        screenShot = new ScreenShot(driver);
        landingPage.goTo(configProperties.getProperty("urlHeroku"));
    }


    @AfterMethod
    public void postTestAction(ITestResult result) throws NameNotFoundException, IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            extentReport.addTestLog(Status.FAIL, "Test Fail");
            screenShot.getScreenShoot(result.getMethod().getMethodName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentReport.addTestLog(Status.PASS, "Test Pass");

        }
        landingPage.closeBrowser();
    }

    @AfterSuite
    public void clearReport() {
        extentReport.flushReport();

    }



}