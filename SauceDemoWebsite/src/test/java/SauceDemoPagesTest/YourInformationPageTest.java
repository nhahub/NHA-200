package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductListingPage;
import SauceDemoPages.YourCartPage;
import SauceDemoPages.YourInformationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YourInformationPageTest extends BaseTest {

    YourInformationPage infoPage;

   /* @Test
    public void validCheckout_ValidData()
    {

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
        YourInformationPage infoPage = new YourInformationPage(bot);
        infoPage.navigateToCheckoutPage();
        infoPage.enterValidFirstName();
        infoPage.enterValidPostalCode();
        infoPage.clickOnContinueButton();


        String errorText = infoPage.errorMessageContent();
        Assert.assertEquals(errorText, "Error: Last Name is required");
    }*/

    @Test (dataProvider = "checkOutData")
    public void checkoutForm(String firstName, String lastName, String postalCode,String testCase)
    {
        infoPage.navigateToCheckoutPage();
        infoPage.enterFirstName(firstName);
        infoPage.enterLastName(lastName);
        infoPage.enterPostalCode(postalCode);
        infoPage.clickOnContinueButton();

        switch (testCase){

            case "Successful Checkout":
                String expectedURL="https://www.saucedemo.com/checkout-step-two.html";
                Assert.assertEquals(infoPage.pageURL(),expectedURL);
                break;

            case "Last Name Field is Empty":
                String errorText = infoPage.errorMessageContent();
                Assert.assertEquals(errorText, "Error: Last Name is required");
                break;
        }
    }

    @Test
    public void checkoutCancellation()
    {

        infoPage.navigateToCheckoutPage();
        infoPage.clickOnCancelButton();
        Assert.assertTrue(infoPage.pageURL().contains("cart.html"));
    }



    @DataProvider(name = "checkOutData")
    public Object [][] checkoutDataDetails()
    {
        return new Object[][] {
                {"Mayar","Magdy","52017","Successful Checkout"},
                {"Mayar", "" ,"1213","Field is Empty"}

        } ;
    }

    @BeforeMethod
    public void yrInfoPrecondition()
    {
        LoginPage lP= new LoginPage(bot);
        ProductListingPage pLP= new ProductListingPage(bot);
        YourCartPage yrCartP= new YourCartPage(bot);

        lP.successfulLogin();
        pLP.addProductToCart();
        yrCartP.moveToCheckoutPage();
        infoPage = new YourInformationPage(bot);

    }


}
