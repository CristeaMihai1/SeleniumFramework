//package utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import javax.naming.NameNotFoundException;
//import java.io.IOException;
//
//public class Listeners extends Base implements ITestListener {
//    ExtentTest test;
//    ExtentReports extentReport= new ExtentReports();
//
//    public Listeners(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ITestListener.super.onTestStart(result);
//        test = extentReport.createTest(result.getMethod().getMethodName());
//    }
//
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ITestListener.super.onTestSuccess(result);
//        test.log(Status.PASS,"Test Pass");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        ITestListener.super.onTestFailure(result);
//        //get error message
//        test.fail(result.getThrowable());
//        String filePath = null;
//        try {
//            filePath = getScreenShoot(result.getMethod().getMethodName());
//        } catch (NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//        extentReport.flush();
//
//    }
//}
