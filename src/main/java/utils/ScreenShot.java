package utils;

import implementation.CommonDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.naming.NameNotFoundException;
import java.io.File;
import java.io.IOException;

public class ScreenShot {
    WebDriver driver;

    public ScreenShot(WebDriver driver){
        this.driver = driver;

    }

    public String getScreenShoot(String testCaseName) throws NameNotFoundException, IOException {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"/ScreenShot/"+ testCaseName +".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"/ScreenShot/"+ testCaseName +".png" ;
    }

}
