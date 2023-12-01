package homework1.browserfactory.testsuite;

import homework1.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void computers() {
        WebElement computersTab = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a"));
        computersTab.click();
        WebElement computerText = driver.findElement(By.xpath("//h1[text()='Computers']"));
        String actualComputersText = computerText.getText();
        String expectedComputersText = "Computers";
        Assert.assertEquals(actualComputersText, expectedComputersText);
        if (true){
            System.out.println("Computer text test passed");
        }
        driver.navigate().back();

        WebElement electronicsTab = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a"));
        electronicsTab.click();
        WebElement electronicsText = driver.findElement(By.xpath("//h1[text()='Electronics']"));
        String actualElectronicsText = electronicsText.getText();
        String exptectedElectronicsText = "Electronics";
        Assert.assertEquals(actualElectronicsText, exptectedElectronicsText);

        if (true){
            System.out.println("Electronics text test passed");
        }else{
            System.out.println("Electronics text test failed");
        }
        driver.navigate().back();

        WebElement apparelTab = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a"));
        apparelTab.click();

        //this is the xpath for partial text I had looked for, the whole text was "Apparel" you can put whole text also
        WebElement apparelText = driver.findElement(By.xpath("//h1[contains(text(), 'Appar')]"));
        String actualApparelText = apparelText.getText();
        String expectedApparelText = "Apparel";
        Assert.assertEquals(actualApparelText, expectedApparelText);
        if (true){
            System.out.println("Apparel text test passed");
        }else{
            System.out.println("Apparel text test failed");
        }
        driver.navigate().back();

        //linkText locator
        WebElement digitalTab = driver.findElement(By.linkText("Digital downloads"));

        //Partial linkText locator
        //WebElement digitalTab = driver.findElement(By.partialLinkText("Digital"));
        digitalTab.click();
        WebElement digitalText = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualdigitalText = digitalText.getText();
        String expecteddigitalText = "Digital downloads";
        Assert.assertEquals(expecteddigitalText, actualdigitalText);
        if (true){
            System.out.println("Digital downloads text test passed");
        }else{
            System.out.println("Digital downloads text test failed");
        }
        driver.navigate().back();


        WebElement booksTab = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a"));
        booksTab.click();
        WebElement booksText = driver.findElement(By.xpath("//h1[contains(text(), 'Books')]"));
        String actualBooksText = booksText.getText();
        String expectedBooksText = "Books";
        Assert.assertEquals(expectedBooksText, actualBooksText);
        if (true){
            System.out.println("Books text test passed");
        }else{
            System.out.println("Books text test failed");
        }
        driver.navigate().back();

        WebElement jewelryTab = driver.findElement(By.linkText("Jewelry"));
        jewelryTab.click();
        WebElement jewelryText = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualjewelryText = jewelryText.getText();
        String expectedJewelryText = "Jewelry";
        Assert.assertEquals(expectedJewelryText, actualjewelryText);
        if (true){
            System.out.println("Jewelry text test passed");
        }else{
            System.out.println("Jewelry text test failed");
        }
        driver.navigate().back();

        WebElement giftTab = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a"));
        giftTab.click();
        WebElement giftText = driver.findElement(By.xpath("//h1[contains(text(), 'Gift Cards')]"));
        String actualGiftText = giftText.getText();
        String expectedGiftText = "Gift Cards";
        Assert.assertEquals(expectedGiftText, actualGiftText);
        if (true){
            System.out.println("Gift cards text test passed");
        }else{
            System.out.println("Gift cards text test failed");
        }


    }


    @After
    public void endTest() {
        closeBrowser();
    }


}
