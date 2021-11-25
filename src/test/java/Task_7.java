import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_7 {
    WebDriver driver;
    WebDriverWait wait;
    private final String searchFieldXpath = "//input";
    private String buttonFoundCSS = ".button.search-form__submit";
    private  String firstElement = "//span[@class='goods-tile__title']";

    @BeforeClass
    public void settings() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nub12\\IdeaProjects\\QACourse\\chromedriver.exe");
    }

    @BeforeMethod
    public void startBrowser(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void testCase(){
        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.clear();
        searchElement.sendKeys( "Монитор");

        WebElement searchButton = driver.findElement(By.cssSelector(buttonFoundCSS));
        searchButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(firstElement)));

        WebElement firstProductElement = driver.findElement(By.xpath(firstElement));
        String firstElementTitle =firstProductElement.getText();

        Assert.assertTrue(firstElementTitle.contains("Mонитор"), "Not contain");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}