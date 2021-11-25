package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{
    private String buttonBuyCSS = "button.button_color_green span";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public CartPage buyProduct(){
        WebElement Buy = driver.findElement(By.cssSelector(buttonBuyCSS));
        Buy.click();
        return new CartPage(driver);
    }
}
