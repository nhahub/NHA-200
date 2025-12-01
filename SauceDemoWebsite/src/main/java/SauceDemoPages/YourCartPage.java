package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class YourCartPage {

    // 1. Locators and Variables
    By firstProductInCartLocator= By.xpath("(//div[@data-test='inventory-item-name'])[1]");
    By firstProductInCartRemoveButtonLocator=By.xpath("(//button[@class='btn btn_secondary btn_small cart_button'])[1]");

    By cartIconNumberLocator =By.xpath("//span[@class='shopping_cart_badge']");
    By cartIconLocator=By.xpath("//a[@class='shopping_cart_link']");
    By continueShoppingButtonLocator=By.xpath("//button[@id='continue-shopping']");
    By checkoutButtonLocator=By.xpath("//button[@id='checkout']");

    // 2. Driver and Wait declaration
    Bot bot;

    // 3. Class Constructor
    public YourCartPage(Bot bot)
    {
       this.bot=bot;

    }

    // 4. Action Methods to interact with the page
    public void navigateToYourCartPage()
    {
        bot.navigateTo("https://www.saucedemo.com/cart.html");
        System.out.println("Navigated to https://www.saucedemo.com/cart.html");
    }

    public void clickOnCartIcon()
    {
        bot.clickOn(cartIconLocator);
    }

    public void clickOnRemoveButtonOfProductCart()
    {
        bot.clickOn(firstProductInCartRemoveButtonLocator);
        System.out.println("Product Removed from cart successfully ");
    }

    public int cartIconDisplayedNumber()
    {
        return Integer.parseInt(bot.displayedText(cartIconNumberLocator));
    }

    public void clickOnContinueShoppingButton()
    {
        bot.clickOn(continueShoppingButtonLocator);
    }

    public String pageURL()
    {
        return bot.currentURL();
    }

    public void clickOnCheckoutButton()
    {
        bot.clickOn(checkoutButtonLocator);
    }

    public void clickOnProductName()
    {
        bot.clickOn(firstProductInCartLocator);
    }

    public String getProductName()
    {
        return bot.displayedText(firstProductInCartLocator);
    }

    public void moveToCheckoutPage()
    {
        bot.navigateTo("https://www.saucedemo.com/cart.html");
        bot.clickOn(checkoutButtonLocator);
        System.out.println("Navigated to Checkout page successfully ");
    }

}
