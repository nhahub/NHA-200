package SauceDemoPagesTest;

import SauceDemoPages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OverviewPageTest extends BaseTest
{
    OverviewPage overviewpage;

    @Test
    public void productNavigation()
    {
        overviewpage.navigateToOverviewPage();
        overviewpage.clickOnFirstItemName();

        String displayedProductName=overviewpage.getFirstInventoryItemName();

        Assert.assertTrue(displayedProductName.contains("Backpack"));
    }




    @Test
    public void finishButtonFunctionality()
    {
        overviewpage.navigateToOverviewPage();
        overviewpage.clickOnFinishButton();

        String actualURL =overviewpage.pageURL();
        String expectedURL="https://www.saucedemo.com/checkout-complete.html";

        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void cancelButtonFunctionality()
    {
        overviewpage.navigateToOverviewPage();
        overviewpage.clickOnCancelButton();

        String actualURL =overviewpage.pageURL();
        String expectedURL="https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(actualURL,expectedURL);
    }


    @BeforeMethod
    public void ovPgPrecondition()
    {
        LoginPage lP= new LoginPage(bot);
        ProductListingPage pLP= new ProductListingPage(bot);
        YourCartPage yrCartP= new YourCartPage(bot);
        YourInformationPage infoPage = new YourInformationPage(bot);

        lP.successfulLogin();
        pLP.add2ProductsToCart();
        yrCartP.moveToCheckoutPage();
        infoPage.fillValidInformationAndContinue();

        overviewpage = new OverviewPage(bot);

    }



}
