package homework1.browserfactory.testsuite2;

import homework1.browserfactory.browserfactory2.BaseTest2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest2 {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void forgotPasswordverification() throws InterruptedException {
        Thread.sleep(5000);
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//form[@class='oxd-form']/div[4]/p"));
        forgotPasswordLink.click();
        Thread.sleep(5000);
        WebElement resetPassword = driver.findElement(By.xpath("//button[@type='submit']"));
        String actualResetPasswordText = resetPassword.getText();
        String expectedResetPasswordText = "Reset Password";
        Assert.assertEquals(expectedResetPasswordText, actualResetPasswordText);
        if (true) {
            System.out.println("Forgot password text verified, test passed");
        }

    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
