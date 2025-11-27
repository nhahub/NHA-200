package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    public ProductPage productPage;  // Class-level instance





    @BeforeMethod
    public void testSessionStart() {
        LoginPage lP = new LoginPage(driver, wait, options);
        lP.navigateToLoginPage();
        lP.enterValidUserName();
        lP.enterValidPassword();
        lP.clickOnLoginButton();

        // Initialize object for all test methods
        productPage = new ProductPage(driver, wait, options);
    }


    @Test
    public void addToCartButtonFunctionality() {
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.isRemoveButtonDisplayed(), "Remove button should appear after adding to cart");
    }

    @Test
    public void removeButtonFunctionality() {
        productPage.clickOnAddToCartButton();
        productPage.clickOnRemoveButton();
        Assert.assertTrue(productPage.isAddToCartDisplayed(), "Add To Cart button should return after Remove");
    }


    @Test
    public void backToProductButtonFunctionality() {
        productPage.clickOnProduct();
        productPage.clickOnBackToProductButton();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("inventory.html"),
                "Back button did not redirect to inventory page");
    }


    @AfterMethod
    public void testSessionTearDown() {
        driver.quit();
    }

}
