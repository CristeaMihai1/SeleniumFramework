package ecommerce;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

public class LogInApplication extends Base {
    public LogInApplication() {
        super(driver);
    }


    @Test
    public static void LogInWithWrongEmail() throws IOException {
        extentReport.createTestCare(new Throwable().getStackTrace()[0].getMethodName());
        landingPage.loginApplication(configProperties.getProperty("wrongEmailEcommerce"),configProperties.getProperty("passEcommerce"));
        Assert.assertEquals("Incorrec email or password.",landingPage.getEroorMessege());

    }

    @Test
    public static void LogInWithCorrectEmail() throws IOException {
        extentReport.createTestCare(new Throwable().getStackTrace()[0].getMethodName());
        landingPage.loginApplication(configProperties.getProperty("emailEcommerce"),configProperties.getProperty("passEcommerce"));

    }


}
