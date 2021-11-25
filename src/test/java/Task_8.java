import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.apache.commons.io.FileUtils.copyFile;

public class Task_8 {
    WebDriver driver;
    WebDriverWait wait;
    private final String searchFieldXpath = "//input";
    private String buttonFoundCSS = ".button.search-form__submit";
    private  String firstElement = "//span[@class='goods-tile__title']";
    private String buttonBuyCSS = "button.button_color_green span";
    private  String buttonCheckoutCSS = "a.button_color_green";

    @BeforeClass
    public void settings() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nub12\\IdeaProjects\\QACourse\\chromedriver.exe");
    }

    @BeforeMethod
    public void startBrowser(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);
        //driver.manage().window().maximize();
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

        WebElement first_Element = driver.findElement(By.xpath(firstElement));
        first_Element.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(buttonBuyCSS)));

        WebElement Buy = driver.findElement(By.cssSelector(buttonBuyCSS));
        Buy.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(buttonCheckoutCSS)));

        WebElement Checkout = driver.findElement(By.cssSelector(buttonCheckoutCSS));
        Checkout.click();

    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess())
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                copyFile(scrFile, new File(result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            } catch (
                    IOException e) {
                e.printStackTrace();
            }

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
