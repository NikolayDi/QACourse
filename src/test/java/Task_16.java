import Pages.CartPage;
import Factory.DriverType;
import Factory.WebDriverFactory;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.ProductResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class Task_16 {
    private WebDriverFactory webDriverFactory;
    private WebDriver driver;
    private String query;
    private HomePage homePage;
    private ProductResultPage searchResultPage;

    @BeforeSuite
    public void setDriver(){
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(DriverType.CHROME);
    }
    @BeforeClass
    public void SettingsBrowser(){
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void GetWebsite(){
        driver.get("https://rozetka.com.ua");
        query = "selenium";
        homePage = new HomePage(driver);
        searchResultPage = homePage.search(query);
    }
    @Test(testName = "Test Basics 1")
    public void searchResultsTitleTest(){
        List<String> resultTitles = searchResultPage.getResultsTitles();

        for(String title : resultTitles){
            System.out.println(title);
            Assert.assertTrue(title.toLowerCase().contains(query));
        }
    }
    @Test(testName = "Test Basics 1")
    public void purchaseProduct (){
        int numberProduct = 0;
        ProductPage productPage = searchResultPage.getProduct(numberProduct);
        CartPage cartPage = productPage.buyProduct();
        cartPage.Checkout();
    }
    @AfterSuite
    public void quiteBrowser(){
        driver.quit();
    }
}
