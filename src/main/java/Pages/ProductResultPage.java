package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductResultPage extends BasePage{
    private By results = new By.ByCssSelector("section.content .goods-tile");
    private By titleXpath = new By.ByXPath(".//span[@class='goods-tile__title']");

    public ProductResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getResultsTitles(){
        List<WebElement> resultsWebElements = driver.findElements(results);
        List<String> titles = new ArrayList<>();
        for(WebElement result : resultsWebElements){
            WebElement title = result.findElement(titleXpath);
            titles.add(title.getText());
        }
        return titles;
    }

    public ProductPage getProduct(int number){
        List<WebElement> resultsWebElements = driver.findElements(results);
        WebElement product = resultsWebElements.get(number);
        product.click();
        return new ProductPage(driver);
    }
}
