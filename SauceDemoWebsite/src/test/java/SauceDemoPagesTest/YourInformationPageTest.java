package SauceDemoPagesTest;

import SauceDemoPages.YourInformationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourInformationPageTest {

    private WebDriver driver;
    private YourInformationPage infoPage;
    @Test
    public void validCheckout_ValidData()
    {
infoPage.enterFirstName("M");
infoPage.enterLastName("M");
infoPage.enterPostalCode("12222");
infoPage.clickOnContinueButton();
    }
    @Test
    public void inValidCheckout_LastNameFieldEmpty()
    {

        infoPage.enterFirstName("M");
        infoPage.enterLastName("");
        infoPage.enterPostalCode("12222");
        infoPage.clickOnContinueButton();

        By errorMessage = By.cssSelector("h3[data-test='error']");
        String errorText = driver.findElement(errorMessage).getText();
        Assert.assertEquals(errorText, "Error: Last Name is required");
    }

    @Test
    public void checkoutCancellation()
    {
        infoPage.clickOnCancelButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }


    @BeforeMethod
    public void testSessionStartup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void testSessionTearDown()
    {
        driver.quit();
    }
}
