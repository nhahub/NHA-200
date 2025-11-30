package SauceDemoPagesTest;

import SauceDemoPages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompletePageTest extends BaseTest {

    CompletePage completePage;
    @Test
    public void backHomeButtonFunctionality()
    {

        completePage.navigateToCompletePage();
        completePage.clickOnBackHomeButton();

        String expectedURL="https://www.saucedemo.com/inventory.html";
        String actualURL = completePage.pageURL();
        Assert.assertEquals(actualURL,expectedURL);

    }


    @BeforeMethod
    public void cPgPrecondition()
    {
        LoginPage lP= new LoginPage(bot);
        ProductListingPage pLP= new ProductListingPage(bot);
        YourCartPage yrCartP= new YourCartPage(bot);
        YourInformationPage infoPage = new YourInformationPage(bot);

        lP.successfulLogin();
        pLP.add2ProductsToCart();
        yrCartP.moveToCheckoutPage();
        infoPage.fillValidInformationAndContinue();

        completePage = new CompletePage(bot); // initialize it

    }



}
