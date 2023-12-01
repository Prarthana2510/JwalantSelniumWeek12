package test;

import homework2.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test6 extends BaseTest {
    String baseUrl = "https://automationexercise.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void testCases(){
       WebElement testCasesLink = driver.findElement(By.xpath("//a[text()=' Test Cases']"));
       testCasesLink.click();
       String actualPageUrl = driver.getCurrentUrl();
       String expectedPageUrl = "https://automationexercise.com/test_cases";
        Assert.assertEquals(expectedPageUrl, actualPageUrl);
        System.out.println("Test cases page varified, test passed");
    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
