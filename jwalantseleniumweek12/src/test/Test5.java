package test;

import homework2.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test5 extends BaseTest {


    String baseUrl = "https://automationexercise.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void login() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]/a"));
        loginLink.click();
        WebElement signUp = driver.findElement(By.xpath("//div[@class='signup-form']/h2"));
        String actualSignUpText = signUp.getText();
        String expectedSignUpText = "New User Signup!";
        Assert.assertEquals(expectedSignUpText, actualSignUpText);
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Jay");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("jay55@gmail.com");

        WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa = 'signup-button']"));
        signUpButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//form/p[contains(text(), 'Email Address already exist!')]"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Email Address already exist!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        System.out.println("Error message verified, test passed");


    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
