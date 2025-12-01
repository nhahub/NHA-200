package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class OverviewPage {


    Bot bot;

    // Locators
    By itemInOverviewPage=By.xpath("//div[@class='inventory_item_name']");
    public By itemNamedClicked = By.xpath("//div[contains(@class,'inventory_details_name')]");
    public By finishButton = By.id("finish");
    public By cancelButton = By.id("cancel");

    // Constructor


    public OverviewPage(Bot bot) {
        this.bot = bot;

    }

    public void navigateToOverviewPage(){

        bot.navigateTo("https://www.saucedemo.com/checkout-step-two.html");
        System.out.println("Navigated to https://www.saucedemo.com/checkout-step-two.html");
    }
    public String getFirstInventoryItemName(){
        return bot.displayedText(itemNamedClicked);
    }
    public void clickOnFirstItemName(){

        bot.clickOn(itemInOverviewPage);

    }
    public  void clickOnFinishButton(){

        bot.clickOn(finishButton);

    }
    public void clickOnCancelButton(){

        bot.clickOn(cancelButton);

    }
    public String pageURL()
    {
        return  bot.currentURL();
    }


}





