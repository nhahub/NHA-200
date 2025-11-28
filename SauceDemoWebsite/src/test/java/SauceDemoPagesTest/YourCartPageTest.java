package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductListingPage;
import SauceDemoPages.YourCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourCartPageTest extends BaseTest
{


    @Test
    public void removeButtonFunctionality()
    {
        YourCartPage crtPg=new YourCartPage(bot);
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
        YourCartPage crtPg=new YourCartPage(bot);
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
        YourCartPage crtPg=new YourCartPage(bot);
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
        YourCartPage crtPg=new YourCartPage(bot);
        crtPg.navigateToYourCartPage();
        crtPg.clickOnCartIcon();
        crtPg.clickOnProductName();
        String actualName=crtPg.getProductName();
        String expectedName="Sauce Labs Backpack";
        Assert.assertEquals(actualName,expectedName);

    }

    @BeforeMethod
    public  void login_and_AddProducts()
    {
        LoginPage lP=new LoginPage(bot);
        ProductListingPage pLP= new ProductListingPage(bot);

        // 1. successful Login
        lP.navigateToLoginPage();
        lP.enterValidUserName();
        lP.enterValidPassword();
        lP.clickOnLoginButton();

        //2. add products to cart
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        pLP.addSecondProductToCart();


    }
}
