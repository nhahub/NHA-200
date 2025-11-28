package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class OverviewPage {


    Bot bot;

    // Locators
    public By firstInventoryItemName = By.className("inventory_item_name");
    public By finishButton = By.id("finish");
    public By cancelButton = By.id("cancel");

    // Constructor


    public OverviewPage(Bot bot) {
        this.bot = bot;

    }

    public void navigateToOverviewPage(){

       /* driver.get(URL);*/
        bot.navigateTo("https://www.saucedemo.com/checkout-step-two.html");
    }
    public String getFirstInventoryItemName(){
        /*String FirstItemName  = "";
        return driver.findElement(firstInventoryItemName).getText();*/
        return bot.displayedText(firstInventoryItemName);
    }
    public void clickOnFirstItemName(){
      /*  driver.findElement(firstInventoryItemName).click();*/
        bot.clickOn(firstInventoryItemName);

    }
    public  void clickOnFinishButton(){
        /*driver.findElement(finishButton).click();*/
        bot.clickOn(finishButton);

    }
    public void clickOnCancelButton(){
        /*driver.findElement(cancelButton).click();*/
        bot.clickOn(cancelButton);

    }


}





