package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductListingPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductListingPageTest extends BaseTest
{
    ProductListingPage pLP;

    @Test
    public void sortingByPrice_HighToLow()
    {
       // ProductListingPage pLP = new ProductListingPage(bot);
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

    }

    @Test  (dependsOnMethods = {"sortingByPrice_HighToLow","sortingByName_ZtoA"})
    public void addToCartButtonFunctionality()
    {
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        int numberAfterAddingFirstProduct =pLP.shoppingCartDisplayedNumber();
        pLP.addSecondProductToCart();
        int numberAfterAddingSecProduct =pLP.shoppingCartDisplayedNumber();

        Assert.assertEquals((numberAfterAddingFirstProduct + 1), numberAfterAddingSecProduct);
    }

    @Test(dependsOnMethods = {"sortingByPrice_HighToLow","sortingByName_ZtoA"})
    public void removeButtonFunctionality()
    {
        pLP.navigateToProductListingPage();
        pLP.addFirstProductToCart();
        int numberAfterAddingFirstProduct =pLP.shoppingCartDisplayedNumber();
        pLP.addSecondProductToCart();
        pLP.removeFirstProduct();
        int numberAfterRemovingFirstProduct =pLP.shoppingCartDisplayedNumber();

        Assert.assertEquals(numberAfterAddingFirstProduct, numberAfterRemovingFirstProduct);

    }



    @BeforeMethod
    public void pLPPrecondition()
    {
        LoginPage lP= new LoginPage(bot);
        lP.successfulLogin();
         pLP = new ProductListingPage(bot);

    }


}
