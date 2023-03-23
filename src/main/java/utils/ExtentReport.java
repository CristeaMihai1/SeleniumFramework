package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
   public String pathReport;
    final ExtentReports extent;
    static ExtentTest extentTest;

    public ExtentReport(String pathReport){


        ExtentSparkReporter reporter = new ExtentSparkReporter(pathReport);
        reporter.config().setReportName("Web Automation");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();

        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Cristea Mihai");
    }


    public void flushReport(){

        extent.flush();
    }


    public void createTestCare(String testCaseName) {


        extentTest = extent.createTest(testCaseName);
    }

    public void addTestLog(Status status, String comment) {


        extentTest.log(status, comment);
    }



}
