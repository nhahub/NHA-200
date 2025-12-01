package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage {


    Bot bot;
    //Locators:


    public By productAddToCartButton = By.id("add-to-cart");
    public By productRemoveButton = By.id("remove");
    public By backToProductsButton = By.id("back-to-products");
    public By productItem = By.cssSelector(".inventory_item_name");
    By productAddorRemoveButtonLocator=By.xpath("//button[contains(@class,\"btn_small btn_inventory\")]");

    public ProductPage(  Bot bot) {

        this.bot = bot;
    }


    public void navigateToProductpage(){

        bot.navigateTo("https://www.saucedemo.com/inventory-item.html?id=4");
        System.out.println("Navigated to https://www.saucedemo.com/inventory-item.html?id=4");

    }
    public void clickOnProduct() {

        bot.clickOn(productItem);

    }
    public void clickOnAddToCartButton(){
        bot.clickOn(productAddToCartButton);
        System.out.println("Product added to cart successfully ");

    }
    public void clickOnRemoveButton(){
        bot.clickOn(productRemoveButton);
        System.out.println("Product Removed from cart successfully ");
    }
    public  void clickOnBackToProductButton(){
        bot.clickOn(backToProductsButton);

    }
    public String pageURL()
    {
        return bot.currentURL();
    }

    public boolean isRemoveButtonDisplayed() {

        return  bot.checkObjectDisplay(productAddorRemoveButtonLocator);
    }

    public boolean isAddToCartDisplayed() {
        return  bot.checkObjectDisplay(productAddorRemoveButtonLocator);
    }
}
