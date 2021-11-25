package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{
    private  String buttonCheckoutCSS = "a.button_color_green";
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void Checkout(){
        WebElement Checkout = driver.findElement(By.cssSelector(buttonCheckoutCSS));
        Checkout.click();
    }
}
