package SauceDemoPages;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ProductListingPage
{
    // 1. Locators and Variables
    By filterDropDownListLocator =By.xpath("//select[@class='product_sort_container']");

    // By lowToHighSelectionOptionLocator=By.xpath("//option[@value='lohi']");  // not used because of using the Select class instead of normal way
    //By zToASelectionOptionLocator =By.xpath("//option[@value='za']");
    By firstProductDisplayedPriceLocator= By.xpath("(//div[@class='inventory_item_price'])[1]");
    By firstProductDisplayedNameLocator=By.xpath("(//div[@class='inventory_item_name '])[1]");
    By addToCartButton_1stProductLocator = By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]");
    By removeButton_1stProductLocator=By.xpath("(//button[@class='btn btn_secondary btn_small btn_inventory '])[1]");

    By secondProductDisplayedPriceLocator =By.xpath("(//div[@class='inventory_item_price'])[2]");
    By secondProductDisplayedNameLocator =By.xpath("(//div[@class='inventory_item_name '])[2]");
    By addToCartButton_2ndProductLocator= By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[2]");

    By thirdProductDisplayedPriceLocator =By.xpath("(//div[@class='inventory_item_price'])[3]");

    By shoppingCartBadgeLocator= By.xpath("//span[@class='shopping_cart_badge']"); //appears after adding a product

    String pLPURL="https://www.saucedemo.com/inventory.html";
    // 2. Driver and Wait declaration
    WebDriver pLPDriver;
    Wait<WebDriver> pLPWait;
    ChromeOptions pLPBrowserOptions;



    // 3. Class Constructor
    public ProductListingPage(WebDriver driver, Wait<WebDriver> wait, ChromeOptions options)
    {
       pLPDriver=driver;
        pLPWait=wait;
        pLPBrowserOptions=options;

        this.pLPBrowserOptions=new ChromeOptions().addArguments("--start-maximized").addArguments("--incognito");
        this.pLPDriver=new ChromeDriver(this.pLPBrowserOptions);
        this.pLPWait=new FluentWait<>(this.pLPDriver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);




    }

    // 4. Action Methods to interact with the page
    public void navigateToProductListingPage()
    {
        pLPDriver.navigate().to(pLPURL);
    }

    public void clickOnDropDownList()
    {
        pLPWait.until(x->{
            x.findElement(filterDropDownListLocator).click();
            return true;
        });
    }

    public void choosePrice_LowToHigh()
    {
        pLPWait.until(d->{
            Select select=new Select(d.findElement(filterDropDownListLocator));
               select.selectByContainsVisibleText("low to high");
               return true;
        });
        // previous used function using wait but using select better as it is best practice
       /* pLPWait.until(x->{
            x.findElement(lowToHighSelectionOptionLocator).click();
            return true;
        });*/
    }
    public void chooseName_ZtoA()
    {


        // previous used function using wait but using select better as it is best practice
       /* pLPWait.until(d->{
            d.findElement(zToASelectionOptionLocator).click();
            return true;
        });*/
    }

    public void addFirstProductToCart()
    {
        pLPWait.until(d->{
            d.findElement(addToCartButton_1stProductLocator).click();
            return true;
        });
    }

    public void addSecondProductToCart()
    {
        pLPWait.until(d->{
            d.findElement(addToCartButton_2ndProductLocator).click();
            return true;
        });
    }

    public void removeFirstProduct()
    {
        pLPWait.until(d->{
            d.findElement(removeButton_1stProductLocator).click();
            return true;
        });
    }

    public int firstProductDisplayedPrice()
    {
        return pLPWait.until(x->{
           String price= x.findElement(firstProductDisplayedPriceLocator).getText();
           return  Integer.parseInt(price);
        });

    }
    public int secondProductDisplayedPrice()
    {
        return pLPWait.until(x->{
            String price= x.findElement(secondProductDisplayedPriceLocator).getText();
            return  Integer.parseInt(price);
        });

    }

    public int thirdProductDisplayedPrice()
    {
        return pLPWait.until(x->{
            String price= x.findElement(thirdProductDisplayedPriceLocator).getText();
            return  Integer.parseInt(price);
        });

    }

    public int shoppingCartDisplayedNumber()
    {
        return pLPWait.until(x->{
            String price= x.findElement(shoppingCartBadgeLocator).getText();
            return  Integer.parseInt(price);
        });

    }

    public String firstProductDisplayedName()
    {
        return pLPWait.until(c->{
            return c.findElement(firstProductDisplayedNameLocator).getText();
        });
    }

    public String secondProductDisplayedName()
    {
        return pLPWait.until(c->
        {
            return c.findElement(secondProductDisplayedNameLocator).getText();
        });
    }

    public void endPLPSession()
    {
        pLPDriver.quit();
    }

}
