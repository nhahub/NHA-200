package SauceDemoPagesTest;

import SauceDemoPages.YourCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourCartPageTest {

    ChromeOptions cartPgTestBrowserOptions;
    WebDriver cartPgTestDriver;
    Wait<WebDriver> cartPgTestWait;

    YourCartPage crtPg;

    @Test
    public void removeButtonFunctionality()
    {
        crtPg.navigateToProductListingPage();
        crtPg.addFirstProductToCart();
        crtPg.addSecondProductToCart();
        int productsInCart=crtPg.cartIconDisplayedNumber();
        crtPg.clickOnCartIcon();
        crtPg.clickOnRemoveButtonOfProdcutCart();
        int productsInCartAfterRemoving=crtPg.cartIconDisplayedNumber();

        Assert.assertTrue((productsInCartAfterRemoving==(productsInCart-1)));

    }

    @Test
    public void continueShoppingButtonFunctionality()
    {
        crtPg.navigateToProductListingPage();
        crtPg.addFirstProductToCart();
        crtPg.addSecondProductToCart();
        crtPg.clickOnCartIcon();
        crtPg.clickOnContinueShoppingButton();
        String actualURL=crtPg.pageURL();
        String expectedURL="https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(expectedURL,actualURL);
    }

    @Test
    public void checkOutButtonFunctionality()
    {
        crtPg.navigateToProductListingPage();
        crtPg.addFirstProductToCart();
        crtPg.addSecondProductToCart();
        crtPg.clickOnCartIcon();
        crtPg.clickOnCheckoutButton();
        String actualURL=crtPg.pageURL();
        String expectedURL="https://www.saucedemo.com/checkout-step-one.html";

        Assert.assertEquals(expectedURL,actualURL);
    }

    @Test
    public void productNavigation()
    {
        crtPg.navigateToProductListingPage();
        crtPg.addFirstProductToCart();
        crtPg.addSecondProductToCart();
        crtPg.clickOnCartIcon();
        crtPg.clickOnProductName();
        String actualName=crtPg.getProductName();
        String expectedName="Sauce Labs Backpack";
        Assert.assertEquals(expectedName,actualName);

    }


    @BeforeMethod
    public void testSessionStartup()
    {
        crtPg=new YourCartPage(cartPgTestDriver,cartPgTestWait,cartPgTestBrowserOptions);
        crtPg.navigateToLoginPage();
        crtPg.enterValidUserName();
        crtPg.enterValidPassword();
        crtPg.clickOnLoginButton();
    }

    @AfterMethod
    public void testSessionTearDown()
    {
        crtPg.endCartPageSession();
    }
}
