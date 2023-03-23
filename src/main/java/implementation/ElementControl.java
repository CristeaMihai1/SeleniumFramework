package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementControl {

    WebDriver driver;
    public ElementControl(WebDriver driver){
        this.driver=driver;
    }

    public void multipleClick(WebElement element, Integer clickNumber){
        Integer i = 1;
        while ( i<=clickNumber ){
            element.click();
            i++;
        }
    }
    public void clickElement(WebElement element){
        element.click();
    }

    public void clear(WebElement element){
        element.clear();
    }

    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void okAlert() {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    public String getTitleOfThePage(){
        return driver.getTitle();
    }
}


