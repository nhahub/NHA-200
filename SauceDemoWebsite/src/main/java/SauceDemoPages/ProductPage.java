package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage {

   /* public WebDriver driver;*/
    Bot bot;
    //Locators:


    public By firstProductAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    public By firstProductRemoveButton = By.id("remove-sauce-labs-backpack");
    public By backToProductsButton = By.id("back-to-products");
    public By productItem = By.cssSelector(".inventory_item_name");
    By productAddorRemoveButtonLocator=By.xpath("//button[contains(@class,\"btn_small btn_inventory\")]");

    public ProductPage(  Bot bot) {

        this.bot = bot;
    }




    public void navigateToProductpage(String URL){

        bot.navigateTo("https://www.saucedemo.com/inventory-item.html?id=4");

    }
    public void clickOnProduct() {
       /* driver.findElement(productItem).click();*/
        bot.clickOn(productItem);

    }
    public void clickOnAddToCartButton(){
       /* driver.findElement(firstProductAddToCartButton).click();*/
        bot.clickOn(firstProductAddToCartButton);

    }
    public void clickOnRemoveButton(){
        /*driver.findElement(firstProductRemoveButton).click();*/
        bot.clickOn(firstProductRemoveButton);
    }
    public  void clickOnBackToProductButton(){
       /* driver.findElement(backToProductsButton).click();*/
        bot.clickOn(backToProductsButton);

    }
    public String pageURL()
    {
        return bot.currentURL();
    }

    public boolean isRemoveButtonDisplayed() {

       /* return true;*/
        return  bot.checkObjectDisplay(productAddorRemoveButtonLocator);
    }

    public boolean isAddToCartDisplayed() {
     //   return true;
        return  bot.checkObjectDisplay(productAddorRemoveButtonLocator);
    }
}
