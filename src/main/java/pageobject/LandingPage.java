package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LandingPage extends BasePage {
    public LandingPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;


    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;



    public void goTo(String url){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);

    }

//    public void loginOrange(){
//        username.sendKeys(userOrange);
//        password.sendKeys(passOrange);
//        submit.click();
//
//    }

    public void loginApplication(String email, String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        login.click();
    }


    public String getEroorMessege(){

        AbstractPageObject.waitWebElementToAppear(errorMessage);
        return errorMessage.getText();

    }


    public void closeBrowser(){
        driver.close();
    }

}
