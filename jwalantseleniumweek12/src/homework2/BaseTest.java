package homework2;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;


    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String actualPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedPageUrl, actualPageUrl);
        if(true){
            System.out.println("Page url verified");
        }






    }

    public void closeBrowser() {
        driver.quit();
    }
}
