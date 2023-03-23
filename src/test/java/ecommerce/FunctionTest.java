//package ecommerce;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import implementation.BrowserManager;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//import pageobject.LandingPage;
//import utils.ScreenShot;
//
//import javax.naming.NameNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//
////import static ecommerce.Base.screenShot;
//import static ecommerce.Base.urlUsed;
//
//public class FunctionTest<driver> {
//    static WebDriver driver;
//
//
//
//    public FunctionTest() throws NameNotFoundException, IOException {
//    }
//
//
//    public static void Test() throws NameNotFoundException, IOException {
////        LandingPage landingPage = new LandingPage(driver);
//        driver = BrowserManager.getChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://rahulshettyacademy.com/client");
//
////        landingPage.loginApplication(wrongEmail,pass);
//        ScreenShot screenShot = new ScreenShot(driver);
//
//        screenShot.getScreenShoot("go to");
//
//    }
//}
