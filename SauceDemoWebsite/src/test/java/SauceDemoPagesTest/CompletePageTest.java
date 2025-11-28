package SauceDemoPagesTest;

import SauceDemoPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompletePageTest extends BaseTest {




    @Test
    public void backHomeButtonFunctionality()
    {
        CompletePage completePage = new CompletePage(bot); // initialize it
        String message = completePage.getSuccessMessage();
        Assert.assertEquals(message, "Thank you for your order!");
        completePage.clickOnBackHomeButton();

    }


    @BeforeMethod
    public void testSessionStart()
    {
        LoginPage lP= new LoginPage(bot);
        lP.navigateToLoginPage();
        lP.enterValidUserName();
        lP.enterValidPassword();
        lP.clickOnLoginButton();

        ProductListingPage pLP= new ProductListingPage(bot);
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        pLP.addSecondProductToCart();


        YourCartPage yrCartP= new YourCartPage(bot);
        yrCartP.navigateToYourCartPage();
        yrCartP.clickOnCheckoutButton();


        YourInformationPage infoPage = new YourInformationPage(bot);
        infoPage.navigateToCheckoutPage();
        infoPage.enterValidFirstName();
        infoPage.enterValidLastName();
        infoPage.enterValidPostalCode();
        infoPage.clickOnContinueButton();


        OverviewPage overview = new OverviewPage(bot);
        overview.clickOnFinishButton();



    }


}
