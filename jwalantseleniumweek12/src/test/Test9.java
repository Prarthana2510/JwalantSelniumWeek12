package test;

import homework2.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test9 extends BaseTest {
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

        WebElement searchBar = driver.findElement(By.id("search_product"));
        searchBar.sendKeys("blue top");
        WebElement searchButton = driver.findElement(By.id("submit_search"));
        searchButton.click();
        WebElement searchResult = driver.findElement(By.xpath("//p[contains(text(), 'Blue Top')]"));
        System.out.println(searchResult.isDisplayed());

    }

}
