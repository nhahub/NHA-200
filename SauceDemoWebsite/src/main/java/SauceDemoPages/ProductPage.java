package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;
    //Locators:
    private By firstProductAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By firstProductRemoveButton = By.id("remove-sauce-labs-backpack");
    private By backToProductsButton = By.id("back-to-products");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
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
    public void clickOnBackToProductButton(){
        driver.findElement(backToProductsButton).click();

    }

























}
