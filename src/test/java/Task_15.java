import Pages.HomePage;
import Factory.DriverType;
import Factory.WebDriverFactory;
import Pages.ProductResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class Task_15 {
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    WebDriver driver = webDriverFactory.createWebDriver(DriverType.CHROME);

    @DataProvider(name = "testTitle")
    public Object[][] createData1() {
        return new Object[][]{
                {"selenium"},
                {"mонитор"},
                {"холодильник"},
        };
    }
    @BeforeMethod
    public void setUpBrowser(){
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua");
    }
    @Test(testName = "Test Basics 1", dataProvider = "testTitle")
    public void searchResultsTitleTest(String query) {
        HomePage homePage = new HomePage(driver);
        ProductResultPage searchResultPage = homePage.search(query);
        List<String> resultTitles = searchResultPage.getResultsTitles();

        for (String title : resultTitles) {
            //System.out.println(title);
            Assert.assertTrue(title.toLowerCase().contains(query));
        }
    }

    @AfterSuite
    public void quiteBrowser(){
        driver.quit();
    }
}