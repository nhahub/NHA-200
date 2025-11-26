package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.OverviewPage;
import SauceDemoPages.ProductListingPage;
import SauceDemoPages.YourCartPage;
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
        LoginPage lP= new LoginPage(driver,wait,options);
        lP.navigateToLoginPage();
        lP.enterValidUserName();
        lP.enterValidPassword();
        lP.clickOnLoginButton();

        ProductListingPage pLP= new ProductListingPage(driver,wait,options);
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        pLP.addSecondProductToCart();


        YourCartPage yrCartP= new YourCartPage(driver,wait,options);
        yrCartP.navigateToYourCartPage();
        yrCartP.clickOnCheckoutButton();

    }


    @Test
    public void productNavigation()
    {

    }
/*

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

*/



    @AfterMethod
    public void testSessionTearDown()
    {
        driver.quit();
    }
}
