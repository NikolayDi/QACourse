package Amazon_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    private final By  searchInput = new By.ByXPath("//*[@id=\"twotabsearchtextbox\"]");
    private final By  searchButton = new By.ByCssSelector("#nav-search-submit-button");
    private final By  lenguage = new By.ByXPath("//span[@class='icp-nav-link-inner']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public ProductResultPage search(String searchQuery){
        WebElement searchInoutElement = driver.findElement(searchInput);
        searchInoutElement.clear();
        searchInoutElement.sendKeys(searchQuery);
        driver.findElement(searchButton).click();
        return new ProductResultPage(driver);
    }
    public LanguagePage openLanguagePage(){
        driver.findElement(lenguage).click();
        return new LanguagePage(driver);
    }
}
