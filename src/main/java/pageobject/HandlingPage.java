package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HandlingPage extends BasePage {
    WebDriver driver;

    public HandlingPage(WebDriver driver){
    super(driver);

    }

    @FindBy(css=".oxd-table-body div div  div:nth-child(4)")
    List<WebElement> listName;

    public List<String> getListOfElement(){
        List<String> names = listName.stream().map(name->name.getText()).collect(Collectors.toList());
        return names;
    }




}
