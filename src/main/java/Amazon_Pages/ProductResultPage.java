package Amazon_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductResultPage extends BasePage{
    private final By results = new By.ByXPath("//span[@class='a-size-medium a-color-base a-text-normal']");
    private final By titleXpath = new By.ByXPath("//span[@class='a-size-medium a-color-base a-text-normal']");
    private final By Rewiew = new By.ByXPath("//span[@class='a-size-small a-color-base'][@dir='auto']");
    private final By SeeMoreBrend = new By.ByXPath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div/div[4]/ul/li[8]/span/div/a/span");
    private final By NameBrends = new By.ByXPath("//div[@id='brandsRefinements']//li[@class='a-spacing-micro']//span[@class='a-size-base a-color-base']");

    public ProductResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getResultsTitles(){
        List<WebElement> resultsWebElements = driver.findElements(results);
        List<String> titles = new ArrayList<>();

        resultsWebElements.forEach(result -> {
            result.findElements(titleXpath);
            System.out.println(result.getText());
            titles.add(result.getText());
        });
        return titles;
    }

    public void BrandSelection(String brend){
        WebElement seeMore = driver.findElement(SeeMoreBrend);
        seeMore.click();
        List<WebElement> ArrBrends = driver.findElements(NameBrends);
        for(WebElement b : ArrBrends){
            if(b.getText().contains(brend)){
                b.click();
                break;
            }
        }
    }

    public ProductPage getProduct(Integer number){
        List<WebElement> resultsWebElements = driver.findElements(results);
        resultsWebElements.get(number).click();
        return new ProductPage(driver);
    }
}
