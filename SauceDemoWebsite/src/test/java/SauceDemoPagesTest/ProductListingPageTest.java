package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductListingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductListingPageTest
{
    WebDriver pLPTestDriver;
    Wait<WebDriver> pLPTestwait;
    ChromeOptions pLPTestBrowserOptions;

    LoginPage loginPage;
    ProductListingPage pLP;

    @Test
    public void sortingByPrice_HighToLow()
    {
    }

    @Test
    public void sortingByName_ZtoA()
    {

    }

    @Test
    public void addToCartButtonFunctionality()
    {

    }

    @Test
    public void removeButtonFunctionality()
    {

    }



    @BeforeMethod
    public void testSessionStartup() {
        pLP = new ProductListingPage(pLPTestDriver, pLPTestwait, pLPTestBrowserOptions);
    }

    @AfterMethod
    public void testSessionTearDown()
    {
        pLP.endPLPSession();
    }
}
