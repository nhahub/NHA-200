package SauceDemoPagesTest;

import SauceDemoPages.*;
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

        YourInformationPage infoPage = new YourInformationPage(driver, wait, options);
        infoPage.navigateToCheckoutPage();
        infoPage.enterValidFirstName();
        infoPage.enterValidLastName();
        infoPage.enterValidPostalCode();
        infoPage.clickOnContinueButton();
        Overviewpage = new OverviewPage(driver, wait, options);


    }





    @Test
    public void finishButtonFunctionality()
    {
        Overviewpage.clickOnFinishButton();
    }

    @Test
    public void cancelButtonFunctionality()
    {
        Overviewpage.clickOnCancelButton();

    }





    @AfterMethod
    public void testSessionTearDown()
    {
        driver.quit();
    }
}
