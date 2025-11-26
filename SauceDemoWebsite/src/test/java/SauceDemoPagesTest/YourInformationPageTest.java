package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductListingPage;
import SauceDemoPages.YourCartPage;
import SauceDemoPages.YourInformationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourInformationPageTest extends BaseTest {


    @Test
    public void validCheckout_ValidData()
    {
        YourInformationPage infoPage = new YourInformationPage(driver,wait,options);
        infoPage.navigateToCheckoutPage();
        infoPage.enterValidFirstName();
        infoPage.enterValidLastName();
        infoPage.enterValidPostalCode();
        infoPage.clickOnContinueButton();

        String expectedURL="https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(infoPage.pageURL(),expectedURL);
    }

    @Test
    public void inValidCheckout_LastNameFieldEmpty()
    {
        YourInformationPage infoPage = new YourInformationPage(driver,wait,options);
        infoPage.navigateToCheckoutPage();
        infoPage.enterValidFirstName();
        infoPage.enterValidPostalCode();
        infoPage.clickOnContinueButton();


        String errorText = infoPage.errorMessageContent();
        Assert.assertEquals(errorText, "Error: Last Name is required");
    }

    @Test
    public void checkoutCancellation()
    {
        YourInformationPage infoPage = new YourInformationPage(driver,wait,options);
        infoPage.navigateToCheckoutPage();
        infoPage.clickOnCancelButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }

    @BeforeMethod
    public void precondition()
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

}
