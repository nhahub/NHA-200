package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage {

    public WebDriver driver;
    //Locators:


    private static By firstProductAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private static By firstProductRemoveButton = By.id("remove-sauce-labs-backpack");
    private static By backToProductsButton = By.id("back-to-products");
    private static By firstProductDisplayedName= By.xpath("(//div[@class='inventory_item_name '])[1]");

    public ProductPage(WebDriver driver) {

        this.driver = driver;
    }


    public ProductPage(WebDriver driver, Wait<WebDriver> wait, ChromeOptions options) {
        this.driver = driver;  // REQUIRED
    }




    public void navigateToProductpage(String URL){

        driver.get(URL);

    }
    public void clickOnAddToCartButton(){
        driver.findElement(firstProductAddToCartButton).click();

    }
    public void clickOnRemoveButton(){
        driver.findElement(firstProductRemoveButton).click();

    }

    public void clickOnFirstPoductName()
    {
        driver.findElement(firstProductDisplayedName).click();
    }

    public String pageURL()
    {
        return driver.getCurrentUrl();
    }

    public  void clickOnBackToProductButton(){
        driver.findElement(backToProductsButton).click();

    }

}
