package SauceDemoPages;

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
    WebDriver cartPageDriver;
    Wait<WebDriver> cartPageWait;
    ChromeOptions cartPageBrowserOptions;

    // 3. Class Constructor
    public YourCartPage(WebDriver driver, Wait<WebDriver> wait, ChromeOptions options)
    {
        cartPageBrowserOptions=options;
        cartPageDriver=driver;
        cartPageWait=wait;

    }

    // 4. Action Methods to interact with the page
    public void navigateToYourCartPage()
    {
        cartPageDriver.navigate().to("https://www.saucedemo.com/cart.html");
    }

    public void clickOnCartIcon()
    {
        cartPageDriver.findElement(cartIconLocator).click();
    }

    public void clickOnRemoveButtonOfProductCart()
    {
        cartPageWait.until(c->{
           c.findElement(firstProductInCartRemoveButtonLocator).click();
           return true;
        });
    }

    public int cartIconDisplayedNumber()
    {
        return cartPageWait.until(x->{
            String price= x.findElement(cartIconNumberLocator).getText();
            return  Integer.parseInt(price);
        });

    }

    public void clickOnContinueShoppingButton()
    {
        cartPageWait.until(c->{
            c.findElement(continueShoppingButtonLocator).click();
            return true;
        });
    }

    public String pageURL()
    {
        return cartPageDriver.getCurrentUrl();
    }

    public void clickOnCheckoutButton()
    {
        cartPageWait.until(c->{
            c.findElement(checkoutButtonLocator).click();
            return true;
        });
    }

    public void clickOnProductName()
    {
        cartPageWait.until(c->{
            c.findElement(firstProductInCartLocator).click();
            return true;
        });
    }

    public String getProductName()
    {
       return cartPageWait.until(c->{
          return c.findElement(firstProductInCartLocator).getText();
       });
    }


}
