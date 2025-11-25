package SauceDemoPagesTest;

import SauceDemoPages.OverviewPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OverviewPageTest extends BaseTest
{
    public OverviewPage Overviewpage;

    @BeforeMethod
public void testSessionStart()
{
    driver.get("https://www.saucedemo.com/checkout-step-two.html");
    OverviewPage OverviewPage = new OverviewPage(driver);


}


    @Test
    public void productNavigation()
    {

    }

    @Test
    public void finishButtonFunctionality()
    {
        OverviewPage.clickOnFinishButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }

    @Test
    public void cancelButtonFunctionality()
    {
            OverviewPage.clickOnCancelButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }




    @AfterMethod
    public void testSessionTearDown()
    {
        driver.quit();
    }
}
