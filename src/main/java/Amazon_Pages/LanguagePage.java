package Amazon_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class LanguagePage extends BasePage{
    private final By radioButton = new By.ByXPath("//div[@class='a-radio a-radio-fancy']");
    private final By radio = new By.ByXPath("//input[@type='radio']");
    private  final By saveButton = new By.ByXPath("//span[@id='icp-btn-save']");
    public LanguagePage(WebDriver driver){this.driver = driver;}
    public void SelectLenguage(int index){
        List<WebElement> radioButtons = driver.findElements(radioButton);
        radioButtons.get(index).click();
        driver.findElement(saveButton).click();
    }
    public int getLenguageIbdex(){
        int index = 0;
        List<WebElement> radioButtons = driver.findElements(radio);
        for(WebElement element : radioButtons){
            String str = element.getAttribute("checked");
            System.out.println(str);
            if (Objects.equals(str, "true")) break;
            index++;
        }
        return index;
    }
}
