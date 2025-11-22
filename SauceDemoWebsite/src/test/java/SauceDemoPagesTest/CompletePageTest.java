package SauceDemoPagesTest;

import SauceDemoPages.CompletePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompletePageTest {
    public CompletePage completePage;
    public WebDriver driver;
    @Test
   public void backHomeButtonFunctionality()
   {
       String message = completePage.getSuccessMessage();
       Assert.assertEquals(message, "Thank you for your order!");
   }


    @BeforeMethod
    public void testSessionStart()
    {

        completePage = new CompletePage(driver);
        completePage.navigateToCompletePage("https://www.saucedemo.com/checkout-complete.html");
    }

    @AfterMethod
    public void testSessionTearDown()
    {
driver.quit();
    }
}
