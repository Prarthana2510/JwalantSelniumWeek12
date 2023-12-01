package homework1.browserfactory.testsuite2;

import homework1.browserfactory.browserfactory2.BaseTest2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest2 {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void login() throws InterruptedException {

        Thread.sleep(5000);

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//form/div/button"));
        loginButton.click();
        Thread.sleep(5000);
        WebElement dashBoardText = driver.findElement(By.xpath("//header/div/div/span/h6"));
        String actualDashBoardText = dashBoardText.getText();
        String expectedDashboardText = "Dashboard";
        Assert.assertEquals(expectedDashboardText, actualDashBoardText);
        if (true) {
            System.out.println("Dashboard text varified, test passed");
        } else {
            System.out.println("Dashboard text not varified, test failed ");
        }


    }
@After
    public void endTest() {
        closeBrowser();
    }
}
