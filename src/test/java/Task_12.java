import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.ProductResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_12 {
    WebDriver driver;

    @BeforeSuite
    public void setDriversProperties(){
        System.setProperty("webdriwer.crome.driver", "chromedriver.exe");
    }
    @BeforeMethod
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua");
    }
    @Test
    public void searchResultsTitleTest(){
        String query = "selenium";
        HomePage homePage = new HomePage(driver);
        ProductResultPage searchResultPage = homePage.search(query);
        List<String> resultTitles = searchResultPage.getResultsTitles();

        for(String title : resultTitles){
            System.out.println(title);
            Assert.assertTrue(title.toLowerCase().contains(query));
        }
    }
    @Test
    public void purchaseProduct (){
        String query = "selenium";
        int numberProduct = 0;
        HomePage homePage = new HomePage(driver);
        ProductResultPage searchResultPage = homePage.search(query);
        ProductPage productPage = searchResultPage.getProduct(numberProduct);
        CartPage cartPage = productPage.buyProduct();
        cartPage.сheckout();
    }
    @AfterMethod
    public void quiteBrowser(){
        driver.quit();
    }
}
