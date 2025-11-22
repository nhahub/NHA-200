package SauceDemoPagesTest;

import SauceDemoPages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest
{
    private WebDriver driver;
    private ProductPage productPage;



    @BeforeMethod
    public void testSessionStart()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



    @Test
    public void addToCartButtonFunctionality()
    {
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(driver.getPageSource().contains("REMOVE"), "Add to Cart failed");
    }

    @Test
    public void removeButtonFunctionality()
    {
        productPage.clickOnAddToCartButton();
        productPage.clickOnRemoveButton();
        Assert.assertTrue(driver.getPageSource().contains("ADD TO CART"), "Remove button failed");}

    @Test
    public void backToProductButtonFunctionality()
    {
        productPage.clickOnBackToProductButton();

    }



    @AfterMethod
    public void testSessionTearDown()
    {
        driver.quit();

    }

}
