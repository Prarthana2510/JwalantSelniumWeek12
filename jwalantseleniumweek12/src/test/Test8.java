package test;

import homework2.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Test8 extends BaseTest {
    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void products() {

        WebElement productsLink = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]"));
        productsLink.click();
        String expectedProductsText = "https://automationexercise.com/products";
        String actualProductsText = driver.getCurrentUrl();
        Assert.assertEquals(expectedProductsText, actualProductsText);
        System.out.println("Proucts navigation url verified, test passed");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(100,650)", "");
        WebElement firstPoduct = driver.findElement(By.xpath("//div[@class = 'choose']/ul/li/a"));
        firstPoduct.click();
        WebElement top = driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        String actualTopText = top.getText();
        String expectedTopText = "Blue Top";
        Assert.assertEquals(actualTopText, expectedTopText);
        System.out.println("Page varified, test Passed");


    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
