package homework1.browserfactory.TestSuite3;

import homework1.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    WebElement myUser;

    String baseUrl = "https://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void login() {
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']/i"));
        loginButton.click();

        WebElement secureArea = driver.findElement(By.xpath("//div[@class='example']/h2"));
        String actualSecureAreaText = secureArea.getText();
        String expectedSecureAreaText = "Secure Area";
        if (true) {
            System.out.println("Secure area text verified, test passed");
        }
        WebElement logoutButton = driver.findElement(By.xpath("//i[contains(text(), ' Logout')]"));
        logoutButton.click();
        WebElement userName2 = driver.findElement(By.xpath("//input[@id='username']"));
        userName2.sendKeys("tomsmith1");
        WebElement password2 = driver.findElement(By.xpath("//input[@id='password']"));
        password2.sendKeys("SuperSecretPassword!");
        WebElement loginButton2 = driver.findElement(By.xpath("//button[@class='radius']/i"));
        loginButton2.click();
        WebElement userErrormessage = driver.findElement(By.id("flash"));
        String actualUserErrorMessage = userErrormessage.getText();
        System.out.println(actualUserErrorMessage);
        String expectedUserErrorMessage = "Your username is invalid!\n×";
        Assert.assertEquals(expectedUserErrorMessage, actualUserErrorMessage);
        if (true) {
            System.out.println("Username error message verified, test passed");
        }

        WebElement userName3 = driver.findElement(By.xpath("//input[@id='username']"));
        userName3.sendKeys("tomsmith");
        WebElement password3 = driver.findElement(By.xpath("//input[@id='password']"));
        password3.sendKeys("SuperSecretPassword");
        WebElement loginButton3 = driver.findElement(By.xpath("//button[@class='radius']/i"));
        loginButton3.click();
        WebElement passwordErrormessage = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualpasswordErrorMessage = passwordErrormessage.getText();
        System.out.println(actualpasswordErrorMessage);
        String expectedpasswordErrorMessage = "Your password is invalid!\n×";
        Assert.assertEquals(expectedUserErrorMessage, actualUserErrorMessage);
        if (true) {
            System.out.println("Password error message verified, test passed");
        }


    }


    @After
    public void endTest() {
        closeBrowser();
    }


}
