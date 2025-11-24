package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductListingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductListingPageTest extends BaseTest
{

    @Test
    public void sortingByPrice_HighToLow()
    {
        ProductListingPage pLP = new ProductListingPage(driver, wait, options);
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
        ProductListingPage pLP = new ProductListingPage(driver, wait, options);
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
        ProductListingPage pLP = new ProductListingPage(driver, wait, options);
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        int numberAfterAddingFirstProduct =pLP.shoppingCartDisplayedNumber();
        pLP.addSecondProductToCart();
        int numberAfterAddingSecProduct =pLP.shoppingCartDisplayedNumber();

        Assert.assertEquals((numberAfterAddingFirstProduct + 1), numberAfterAddingSecProduct);
    }

    @Test (dependsOnMethods = {"addToCartButtonFunctionality"})
    public void removeButtonFunctionality()
    {
        ProductListingPage pLP = new ProductListingPage(driver, wait, options);
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        int numberAfterAddingFirstProduct =pLP.shoppingCartDisplayedNumber();
        pLP.addSecondProductToCart();
        pLP.removeFirstProduct();
        int numberAfterRemovingFirstProduct =pLP.shoppingCartDisplayedNumber();

        Assert.assertEquals(numberAfterAddingFirstProduct, numberAfterRemovingFirstProduct);

    }

    /*!!! Should be BeforeMethod not before test cus before method comes after calling before test
   --->the normal calling arrangement is as follows
   /*
   * 1.before suite     Done once before test suite
   * 2.before test      Done once before test BLOCK
   * 3.before class     Done once before specific class
   * 4.before method    Done before each method
   *
    So if before test used before successful login method, will cuz null pointer in the driver

   */
    /*
    this will be called before each method, we can use before class
    ( to call it once and all tests done faster without multiple sessions i.e. login once before all tests)
     and in the base test:
     will use (before test which is a common setup for all tests like initializing the driver)

    */
    @BeforeMethod
    public void successfulLogin()
    {
        LoginPage lP= new LoginPage(driver,wait,options);
        lP.navigateToLoginPage();
        lP.enterValidUserName();
        lP.enterValidPassword();
        lP.clickOnLoginButton();
    }


}
