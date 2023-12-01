package test;

import homework2.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test3 extends BaseTest {
    String baseUrl = "https://automationexercise.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void login() {

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
        email.sendKeys("jay55685@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("jay5545866");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//form[@action='/login']/p"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Your email or password is incorrect!";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        if (true){
            System.out.println("Error message verified, test passed");
        }
    }
}
