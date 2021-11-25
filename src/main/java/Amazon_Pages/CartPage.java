package Amazon_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{
    private final By buttonCheckout = new By.ByXPath("//input[@name='proceedToRetailCheckout']");
    public CartPage(WebDriver driver){this.driver = driver;}
    public boolean сheckout(){
        try {
            driver.findElement(buttonCheckout).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
