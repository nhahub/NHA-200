package SauceDemoPages;
import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

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
    Bot bot;


    // 3. Class Constructor
    public ProductListingPage(Bot bot) {
       this.bot=bot;

    }

    // 4. Action Methods to interact with the page
    public void navigateToProductListingPage()
    {
        bot.navigateTo(pLPURL);
        System.out.println("Navigated to "+pLPURL);
    }

    public void clickOnDropDownList()
    {
        bot.clickOn(filterDropDownListLocator);
    }

    public void choosePrice_LowToHigh()
    {
        bot.selectFromList(filterDropDownListLocator,"low to high");
        System.out.println("Price(high to low) option selected");
    }
    public void chooseName_ZtoA()
    {
        bot.selectFromList(filterDropDownListLocator,"Z to A");
        System.out.println("Name(Z to A) option selected");
    }

    public void addFirstProductToCart()
    {
        bot.clickOn(addToCartButton_1stProductLocator);
        System.out.println("First product added to cart successfully ");
    }

    public void addSecondProductToCart()
    {
        bot.clickOn(addToCartButton_2ndProductLocator);
        System.out.println("Second product added to cart successfully ");
    }

    public void removeFirstProduct()
    {
        bot.clickOn(removeButton_1stProductLocator);
        System.out.println("First product Removed from cart successfully ");
    }

    public double firstProductDisplayedPrice()
    {

        String price= bot.displayedText(firstProductDisplayedPriceLocator);
        price= price.replace("$","");    //to remove the $ sign from the extracted text
        return  Double.parseDouble(price);
    }
    public double secondProductDisplayedPrice()
    {

        String price= bot.displayedText(secondProductDisplayedPriceLocator);
        price= price.replace("$","");    //to remove the $ sign from the extracted text
        return  Double.parseDouble(price);

    }

    public double thirdProductDisplayedPrice() {
        return Double.parseDouble((bot.displayedText(thirdProductDisplayedPriceLocator).replace("$", "")));

    }

    public int shoppingCartDisplayedNumber()
    {
        return Integer.parseInt(bot.displayedText(shoppingCartBadgeLocator));
    }

    public String firstProductDisplayedName()
    {
        return bot.displayedText(firstProductDisplayedNameLocator);
    }

    public String secondProductDisplayedName()
    {
        return bot.displayedText(secondProductDisplayedNameLocator);
    }

    public void add2ProductsToCart()
    {
        bot.navigateTo(pLPURL);
        bot.clickOn(addToCartButton_1stProductLocator);
        bot.clickOn(addToCartButton_2ndProductLocator);
        System.out.println("Two products added to cart successfully ");
    }
    public void addProductToCart()
    {
        bot.navigateTo(pLPURL);
        bot.clickOn(addToCartButton_1stProductLocator);
        System.out.println("A product added to cart successfully ");
    }


}
