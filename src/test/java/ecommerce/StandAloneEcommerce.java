//package ecommerce;
//
//import implementation.AbstractComponent;
//import implementation.BrowserManager;
//import implementation.CommonDriver;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import pageobject.LandingPage;
//import utils.DataReader;
//import utils.ExtentReport;
//
//import javax.naming.NameNotFoundException;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//public class StandAloneEcommerce<emailEcommerce, passEcommerce> extends AbstractComponent {
//    static WebDriver driver;
//    static Properties properties;
//
//    static String workingDirectory = System.getProperty("user.dir");
//    static String fileName = workingDirectory + "/config/config.properties";
//
//
//
//    static LandingPage landingPage = new LandingPage(driver);
//
//
//    public StandAloneEcommerce(WebDriver driver) throws IOException {
//        super(driver);
//        this.driver = driver;
//
//    }
//
//
//
//
//    public static void main(String[] args) throws NameNotFoundException, IOException {
//        CommonDriver cmnDriver = new CommonDriver("chrome");
//        driver = cmnDriver.getDriver();
//
//    }
//
//    @BeforeTest
//    public static void logApp(){
//        landingPage.loginApplication(email,pass);
//        ExtentReport.getReport();
//    }
//
//    @Test
//    public static void startApp(){
//        landingPage.goTo(urlUsed);
//        ExtentReport.getReport();
//    }
//
//
//}
