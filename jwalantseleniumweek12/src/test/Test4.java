package test;

import homework2.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test4 extends BaseTest {

    String baseUrl = "https://automationexercise.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void login() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]/a"));
        loginLink.click();
        WebElement loginText = driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]"));
        String actualLoginText = loginText.getText();
        String expectedLoginText = "Login to your account";
        Assert.assertEquals(expectedLoginText, actualLoginText);
        if (true) {
            System.out.println("Login text verified");
        }

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("jay55@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("jay55");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(5000);
        WebElement logggedInUser = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[10]"));
        logggedInUser.isDisplayed();
        String loggedInUserActualText = logggedInUser.getText();
        String loggedInUserExpectedText = "Logged in as jay";
        logggedInUser.isDisplayed();
        Assert.assertEquals(loggedInUserExpectedText, loggedInUserActualText);
        if (true) {
            System.out.println("User text verified, test passed");
        }
        WebElement logoutLink = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]"));
        logoutLink.click();



        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        String expectedUrl = "https://automationexercise.com/login";
        Assert.assertEquals(expectedUrl, actualUrl);
        if(true){
            System.out.println("Login page varified, test passed");
        }

    }
    public void endTest(){
        closeBrowser();
    }
}
