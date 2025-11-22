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


    ProductListingPage pLP;

    @Test
    public void sortingByPrice_HighToLow()
    {
        pLP.navigateToProductListingPage();
        pLP.clickOnDropDownList();
        pLP.choosePrice_LowToHigh();
        double firstProductPice=pLP.firstProductDisplayedPrice();
        double secondProductPrice= pLP.secondProductDisplayedPrice();
        double thirdProductPrice=pLP.thirdProductDisplayedPrice();

        // asserting the 1st price is less than the 2 prices after it just to assure that
        Assert.assertTrue((firstProductPice<secondProductPrice)&&(firstProductPice<thirdProductPrice));

    }

    @Test
    public void sortingByName_ZtoA()
    {
        pLP.navigateToProductListingPage();
        pLP.clickOnDropDownList();
        pLP.chooseName_ZtoA();
        String firstProductName=pLP.firstProductDisplayedName();
        String secondProductName=pLP.secondProductDisplayedName();

        Assert.assertTrue(( (firstProductName.compareTo(secondProductName) )>0));
        /*
        * compare function returns -ve if the first string comes before the compared string
        *                           0 if they are equal
        *                           +ve if the first comes after
        * */

    }

    @Test  (dependsOnMethods = {"sortingByPrice_HighToLow","sortingByName_ZtoA"})
    public void addToCartButtonFunctionality()
    {
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        int numberAfterAddingFirstProduct =pLP.shoppingCartDisplayedNumber();
        pLP.addSecondProductToCart();
        int numberAfterAddingSecProduct =pLP.shoppingCartDisplayedNumber();

        Assert.assertTrue(numberAfterAddingSecProduct ==(numberAfterAddingFirstProduct +1));
    }

    @Test (dependsOnMethods = {"addToCartButtonFunctionality"})
    public void removeButtonFunctionality()
    {
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        int numberAfterAddingFirstProduct =pLP.shoppingCartDisplayedNumber();
        pLP.addSecondProductToCart();
        pLP.removeFirstProduct();
        int numberAfterRemovingFirstProduct =pLP.shoppingCartDisplayedNumber();

        Assert.assertTrue(numberAfterRemovingFirstProduct == numberAfterAddingFirstProduct);

    }

    /* ------------------------------- precondition test --------------------------------------*/

    @BeforeMethod
    public void testSessionStartup() {
            pLP = new ProductListingPage(pLPTestDriver, pLPTestwait, pLPTestBrowserOptions);
            pLP.navigateToLoginPage();
            pLP.enterValidUserName();
            pLP.enterValidPassword();
            pLP.clickOnLoginButton();

    }

    @AfterMethod
    public void testSessionTearDown()
    {
        pLP.endPLPSession();
    }
}
