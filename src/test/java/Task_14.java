import Amazon_Pages.*;
import Factory.DriverType;
import Factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task_14 {
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    WebDriver driver = webDriverFactory.createWebDriver(DriverType.CHROME);
    @BeforeMethod
    public void setUpBrowser(){
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    @Test
    public void searchResultsTitleTest(){
        String query = "monitor";
        int number_element = 5;
        HomePage homePage = new HomePage(driver);
        ProductResultPage searchResultPage = homePage.search(query);
        List<String> resultTitles = searchResultPage.getResultsTitles();
        Assert.assertTrue(resultTitles.get(number_element).toLowerCase().contains(query));
    }

    @Test
    public void searchBrendTest() {
        String query = "keyboard";
        String nameBrand = "Razer";
        Integer numberProduct = 0;

        HomePage homePage = new HomePage(driver);
        ProductResultPage searchResultPage = homePage.search(query);
        searchResultPage.BrandSelection(nameBrand);
        ProductPage productPage = searchResultPage.getProduct(numberProduct);
        String brand = productPage.findBrend();
        Assert.assertTrue(brand.contains(nameBrand));
    }
    @Test
    public void BuyProduct() {
        String query = "monitor";
        Integer numberProduct = 0;

        HomePage homePage = new HomePage(driver);
        ProductResultPage searchResultPage = homePage.search(query);
        ProductPage productPage = searchResultPage.getProduct(numberProduct);
        CartPage cartPage = productPage.buyProduct();
        Assert.assertTrue(cartPage.Checkout());
    }
    @Test
    public void switchLanguage() {
        int indexLanguage = 3;
        HomePage homePage = new HomePage(driver);
        LanguagePage languagePage = homePage.openLanguagePage();
        languagePage.SelectLenguage(indexLanguage);
        homePage.openLanguagePage();
        int index = languagePage.getLenguageIbdex();
        Assert.assertEquals(index, indexLanguage);
    }
    @AfterSuite
    public void quiteBrowser(){
        driver.quit();
    }
}
