package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage {

    public WebDriver driver;
    //Locators:


    public By firstProductAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    public By firstProductRemoveButton = By.id("remove-sauce-labs-backpack");
    public By backToProductsButton = By.id("back-to-products");
    public By productItem = By.cssSelector(".inventory_item_name");


    public ProductPage(WebDriver driver) {

        this.driver = driver;
    }


    public ProductPage(WebDriver driver, Wait<WebDriver> wait, ChromeOptions options) {
        this.driver = driver;

    }




    public void navigateToProductpage(String URL){

        driver.get(URL);

    }
    public void clickOnProduct() {
        driver.findElement(productItem).click();

    }
    public void clickOnAddToCartButton(){
        driver.findElement(firstProductAddToCartButton).click();

    }
    public void clickOnRemoveButton(){
        driver.findElement(firstProductRemoveButton).click();

    }
    public  void clickOnBackToProductButton(){
        driver.findElement(backToProductsButton).click();

    }

    public boolean isRemoveButtonDisplayed() {

        return true;
    }

    public boolean isAddToCartDisplayed() {
        return true;
    }
}
