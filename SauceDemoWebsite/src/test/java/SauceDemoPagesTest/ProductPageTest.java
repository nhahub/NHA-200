package SauceDemoPagesTest;

import SauceDemoPages.LoginPage;
import SauceDemoPages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    private ProductPage productPage;  // Class-level instance

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
        Assert.assertTrue(driver.getPageSource().contains("REMOVE"), "Add to Cart failed");
    }

    @Test
    public void removeButtonFunctionality() {
        productPage.clickOnAddToCartButton();
        productPage.clickOnRemoveButton();
        Assert.assertTrue(driver.getPageSource().contains("ADD TO CART"), "Remove button failed");
    }

    @Test
    public void backToProductButtonFunctionality() {
        productPage.clickOnBackToProductButton();
    }

    @AfterMethod
    public void testSessionTearDown() {
        driver.quit();
    }
}
