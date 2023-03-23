package pageobject;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.NameNotFoundException;
import java.time.Duration;

public class AbstractPageObject extends BasePage {

    static WebDriverWait wait;



    public AbstractPageObject(WebDriver driver) {
        super(driver);
    }


    public static void waitElementToAppear(By findBy) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public static void waitWebElementToAppear(WebElement findBy) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }


    public void waitElementToDisappear(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


}