package homework1.browserfactory.testsuite;

import homework1.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void login() {
        WebElement loginlink = driver.findElement(By.className("ico-login"));
        //driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginlink.click();

        String expectedText = "Welcome, Please Sign In!";
        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualText = welcomeMessage.getText();
        Assert.assertEquals(expectedText, actualText);

        if (true){
            System.out.println("Welcome message test passed");
        }else{
            System.out.println("Welcome message test failed");
        }

        WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
        email.sendKeys("jay@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();
        WebElement logoutLink = driver.findElement(By.xpath("//a[@class ='ico-logout']"));
        Assert.assertTrue(logoutLink.isDisplayed());
        if (true){
            System.out.println("Logout Link is displayed, test passed");
        }else{
            System.out.println("Logout Link is not displayed, test failed");
        }
        logoutLink.click();

        WebElement loginlink2 = driver.findElement(By.className("ico-login"));
        loginlink2.click();

        WebElement email2 = driver.findElement(By.xpath("//input[@class='email']"));
        email2.sendKeys("invalid@gd.com");

        WebElement password2 = driver.findElement(By.xpath("//input[@class='password']"));
        password2.sendKeys("abctyd");

        WebElement loginButton2 = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton2.click();
        String actualErrorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        String expectedErrorMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

        if (true){
            System.out.println("error message test passed");
        }else{
            System.out.println("Error message test failed");
        }


    }
    @After
public void endTest(){
        closeBrowser();
    }


}
