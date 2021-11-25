package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    private By  searchInput = new By.ByXPath("//input[@name='search']");
    private By  searchButton = new By.ByCssSelector("button.button:nth-child(2)");

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
}
