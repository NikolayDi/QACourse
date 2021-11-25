import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_6 {
    @Test
    public void Task_6Test() {
        System.out.println("text");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nub12\\IdeaProjects\\QACourse\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        String searchFieldXpath = "//input[@title='Поиск']";


        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys( "softserve learning and certification");
        searchElement.submit();

        driver.findElement(By.className("g")).click();

        try {
            String url = driver.getCurrentUrl();
            Assert.assertEquals("https://career.softserveinc.com/uk-ua/learning-and-certification", url);
        }
        catch (InternalError e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}