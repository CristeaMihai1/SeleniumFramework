package ecommerce;

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
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class Base extends LandingPage {
    static WebDriver driver;
    String workingDirectory;
    String configFileName;
    static String urlUsed;
    static CommonDriver cmnDriver;
    static String browserType;
    static Properties configProperties;
    String jsonFileName;
    String pathReport;
    static LandingPage landingPage;
    ScreenShot screenShot;
    public static ExtentReport extentReport;


    public Base(WebDriver driver) {
        super(driver);
    }

//
//    @DataProvider
//    public Object[][] getData() throws IOException {
//        String pathJsonData = System.getProperty("user.dir") + "/data/EcommerceData.json";
//        List<HashMap<String, String>> data = DataReader.getJsonDataToMap(pathJsonData);
//        return new Object[][]{{data.get(0)}, {data.get(1)}};
//
//    }


    @BeforeSuite
    public void preSetup() throws IOException {
        workingDirectory = System.getProperty("user.dir");
        configFileName = workingDirectory + "/data/config.properties";
        jsonFileName = workingDirectory + "/data/EcommerceData.json";
        pathReport = workingDirectory + "/ReportEcommerce/report.html";
//        deleteDirectoryReport(pathReport);
        configProperties = DataReader.readProperties(configFileName);
        browserType = configProperties.getProperty("browserType");
        extentReport = new ExtentReport(pathReport);
        extentReport.createTestCare("Log in application");

    }


    @BeforeMethod
    public void setUp() throws NameNotFoundException {
        cmnDriver = new CommonDriver(browserType);
        driver = cmnDriver.getDriver();
        landingPage = new LandingPage(driver);
        screenShot = new ScreenShot(driver);
        landingPage.goTo(configProperties.getProperty("urlEcommerce"));
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


//public void deleteDirectory(String folder){
//    File dir = new File(folder);
//        for(File file : dir.listFiles())
//            if (!file.isDirectory())
//                file.delete();
//}

}
