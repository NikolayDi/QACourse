import Factory.DriverType;
import Factory.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.apache.commons.io.FileUtils.copyFile;

public class Task_9 {

    By LoadElement = By.xpath("//p[@class='title__paragraph title__paragraph_listed smaller-font']");
    By FirstElement = By.xpath("//div//h3[@class='LC20lb DKV0Md']");
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    WebDriver driver = webDriverFactory.createWebDriver(DriverType.FIREFOX);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    @Test
    public void test1(){
        driver.get("https://www.google.com/");
        String searchFieldXpath = "//input[@name='q']";
        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("SoftServe");
        searchElement.submit();

        WebElement FirstEl = driver.findElement(FirstElement);
        FirstEl.click();

        wait.until(driver -> driver.findElement(LoadElement).isDisplayed());
        try {
            String url = driver.getCurrentUrl();
            Assert.assertEquals("https://www.softserveinc.com/uk-ua", url);
        }
        catch (InternalError e) {
            e.printStackTrace();
        }
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
