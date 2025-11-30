package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

     ProductPage productPage;  // Class-level instance

    @Test
    public void addToCartButtonFunctionality() {
        productPage.navigateToProductpage();
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.isRemoveButtonDisplayed(), "Remove button should appear after adding to cart");
    }

    @Test
    public void removeButtonFunctionality() {
        productPage.navigateToProductpage();
        productPage.clickOnRemoveButton();
        Assert.assertTrue(productPage.isAddToCartDisplayed(), "Add To Cart button should return after Remove");
    }


    @Test
    public void backToProductButtonFunctionality() {

        productPage.navigateToProductpage();
        productPage.clickOnBackToProductButton();
        String actualUrl = productPage.pageURL();
        Assert.assertTrue(actualUrl.contains("inventory.html"),
                "Back button did not redirect to inventory page");
    }

    @BeforeMethod
    public void pPgPrecondition() {
        LoginPage lP = new LoginPage(bot);
         lP.successfulLogin();
        // Initialize object for all test methods
        productPage = new ProductPage(bot);
    }


}
