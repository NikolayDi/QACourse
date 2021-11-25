package Amazon_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{
    private final By buttonBuy = new By.ByXPath("//span[@id='submit.add-to-cart']");
    private final By description = new By.ByXPath("//table//tr[@class='a-spacing-small']");
    private final By close = new By.ByXPath("//a[@id='attach-close_sideSheet-link']");
    private final By cart = new By.ByXPath("//a[@id='nav-cart']");
    public ProductPage(WebDriver driver){this.driver = driver;}
    public CartPage buyProduct(){
        driver.findElement(buttonBuy).click();
        //driver.findElement(close).click();
        driver.findElement(cart).click();
        return new CartPage(driver);
    }
    public String findBrend(){
        List<WebElement> Arr = driver.findElements(description);
        String result = "";

        for(WebElement b : Arr){
            if(b.getText().contains("Brand")){
                System.out.println(b.getText());
                result = b.getText();
                break;
            }
        }
        return result;
    }
}
