package orangeHRM;

import dev.failsafe.internal.util.Assert;
import implementation.ElementControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.AbstractPageObject;
import pageobject.LandingPage;

import javax.naming.NameNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class StandAloneTests extends AbstractPageObject {
    static WebDriver driver;
    static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public StandAloneTests(WebDriver driver) throws NameNotFoundException {
        super(driver);
    }

    public static void main (String[] args) throws InterruptedException, NameNotFoundException {



//        driver = BrowserManager.getChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LandingPage landingPage= new LandingPage(driver);
        ElementControl elementControl = new ElementControl(driver);

        landingPage.goTo(url);
        landingPage.loginApplication(null,null);
        Thread.sleep(3000);

        String text = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")).getText();
        WebElement admin = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
        elementControl.multipleClick(admin,2);

        Thread.sleep(3000);

        //wait after click
        AbstractPageObject abstractComponent = new AbstractPageObject(driver);
        abstractComponent.waitElementToAppear(By.cssSelector(".oxd-table-body div div  div:nth-child(4)"));



        List<WebElement> listName = driver.findElements(By.cssSelector(".oxd-table-body div div  div:nth-child(4)"));
        List<String> names = listName.stream().map(name->name.getText()).collect(Collectors.toList());
        Boolean match = listName.stream().anyMatch(name->name.getText().equalsIgnoreCase("Aony Nolan"));
        Assert.isTrue(match,"This name does not exist in table");




//        List<String> names = listName.stream().map(s -> s.getText()).collect(Collectors.toList());
//        List<String> nameSorted = listName.stream().sorted().collect(Collectors.toList());
//        nameSorted.forEach(a-> System.out.println(a));
//        System.out.println(names);







}}
