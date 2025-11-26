package SauceDemoPagesTest;

import SauceDemoPages.CompletePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompletePageTest {
    public CompletePage completePage;
    public WebDriver driver;
    @BeforeMethod
    public void testSessionStart()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        completePage = new CompletePage(driver);
        completePage.navigateToCompletePage("https://www.saucedemo.com/checkout-complete.html");
    }


    @Test
    public void backHomeButtonFunctionality()
    {
        String message = completePage.getSuccessMessage();
        Assert.assertEquals(message, "Thank you for your order!");
        completePage.clickOnBackHomeButton();

    }



    @AfterMethod
    public void testSessionTearDown()
    {
        driver.quit();
    }
}
