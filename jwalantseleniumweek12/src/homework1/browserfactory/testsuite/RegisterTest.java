package homework1.browserfactory.testsuite;

import homework1.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void registerLinkVerification() {
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        registerLink.click();
        WebElement registerText = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualRegisterText = registerText.getText();
        String expectedRegisterText = "Register";
        Assert.assertEquals(expectedRegisterText, actualRegisterText);
        if (true) {
            System.out.println("Register text verified, test passed");
        } else {
            System.out.println("Register text not verified, test failed");
        }

        WebElement maleRadioButton = driver.findElement(By.id("gender-male"));
        maleRadioButton.click();
        WebElement firstname = driver.findElement(By.id("FirstName"));
        firstname.sendKeys("Jay");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Shuk");
        WebElement birthDay = driver.findElement(By.name("DateOfBirthDay"));
        //birthDay.click();
        Select day = new Select(birthDay);
        day.selectByIndex(28);
        WebElement birthMonth = driver.findElement(By.name("DateOfBirthMonth"));
        Select month = new Select(birthMonth);
        month.selectByValue("2");
        WebElement birthyear = driver.findElement(By.name("DateOfBirthYear"));
        Select year = new Select(birthyear);
        year.selectByVisibleText("1987");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("jay7@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("123456");
        WebElement register = driver.findElement(By.xpath("//button[@name='register-button']"));
        register.click();
        WebElement registerationText = driver.findElement(By.xpath("//div[contains(text(), 'Your registration completed')]"));
        String actualRegisterationText = registerationText.getText();
        String expectedRegistrationText = "Your registration completed";
        Assert.assertEquals(expectedRegistrationText, actualRegisterationText);
        if (true) {
            System.out.println("Registration completed, test passed");
        } else {
            System.out.println("Registration test failed");
        }


    }
@After
    public void endTest() {
        closeBrowser();
    }

}














