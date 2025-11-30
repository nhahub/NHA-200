package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductListingPage;
import SauceDemoPages.YourCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourCartPageTest extends BaseTest
{
    YourCartPage crtPg;

    @Test
    public void removeButtonFunctionality()
    {
        crtPg.navigateToYourCartPage();
        int productsInCart=crtPg.cartIconDisplayedNumber();
        crtPg.clickOnCartIcon();
        crtPg.clickOnRemoveButtonOfProductCart();
        int productsInCartAfterRemoving=crtPg.cartIconDisplayedNumber();

        Assert.assertTrue((productsInCartAfterRemoving==(productsInCart-1)));

    }

    @Test
    public void continueShoppingButtonFunctionality()
    {
        crtPg.navigateToYourCartPage();
        crtPg.clickOnCartIcon();
        crtPg.clickOnContinueShoppingButton();
        String actualURL=crtPg.pageURL();
        String expectedURL="https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(actualURL,expectedURL);
    }



    @Test
    public void checkOutButtonFunctionality()
    {
        crtPg.navigateToYourCartPage();
        crtPg.clickOnCartIcon();
        crtPg.clickOnCheckoutButton();
        String actualURL=crtPg.pageURL();
        String expectedURL="https://www.saucedemo.com/checkout-step-one.html";

        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void productNavigation()
    {
        crtPg.navigateToYourCartPage();
        crtPg.clickOnCartIcon();
        crtPg.clickOnProductName();
        String actualName=crtPg.getProductName();
        String expectedName="Sauce Labs Backpack";
        Assert.assertEquals(actualName,expectedName);

    }

    @BeforeMethod
    public  void yrCartPrecondition()
    {
        LoginPage lP=new LoginPage(bot);
        ProductListingPage pLP= new ProductListingPage(bot);

        // 1. successful Login
        lP.successfulLogin();

        //2. add products to cart
        pLP.addProductToCart();

        //3. initializing cartPage object
        crtPg=new YourCartPage(bot);

    }

}
