package Task_13.steps;

import Factory.DriverType;
import Factory.WebDriverFactory;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.ProductResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserTestSteps {
    WebDriver driver;

    //WebDriverFactory webDriverFactory = new WebDriverFactory();
    //WebDriver driver = webDriverFactory.createWebDriver(DriverType.CHROME);
    ProductResultPage searchResultPage;
    @BeforeSuite
    public void setDriversProperties(){
        System.setProperty("webdriwer.crome.driver", "chromedriver.exe");
    }

    @Given("Launching the browser and opening the rozetka website")
    public void launchingTheBrowserAndOpeningTheRozetkaWebsite() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua");
    }

    @When("Search for a product by query {string}")
    public void searchForAProductByQuery(String query) {
        HomePage homePage = new HomePage(driver);
        searchResultPage = homePage.search(query);
    }

    @Then("Checking if the product name contains a word from the query {string}")
    public void checkingIfTheProductNameContainsAWordFromTheQuery(String query) {
        List<String> resultTitles = searchResultPage.getResultsTitles();
        for(String title : resultTitles){
            System.out.println(title);
            Assert.assertTrue(title.toLowerCase().contains(query));
        }
        driver.quit();
    }

    @Then("Opening the product under number {int} and placing an order")
    public void openingTheProductUnderNumberAndPlacingAnOrder(int numberProduct) {
        ProductPage productPage = searchResultPage.getProduct(numberProduct);
        CartPage cartPage = productPage.buyProduct();
        cartPage.сheckout();
        driver.quit();
    }
}