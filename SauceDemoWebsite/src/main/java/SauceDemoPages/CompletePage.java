package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletePage {

   Bot bot;
    //Locators :
    public By finishButton = By.id("finish");
    public By backHomeButton = By.id("back-to-products");
    public By successMessage = By.className("complete-header");


    public CompletePage(Bot bot) {
        this.bot = bot;

    }


    public void navigateToCompletePage(){

       bot.navigateTo("https://www.saucedemo.com/checkout-complete.html");
        System.out.println("navigated to https://www.saucedemo.com/checkout-complete.html");
    }
    public void clickOnFinishButton(){
        bot.clickOn(finishButton);
        System.out.println("Clicked on Finish Button");
    }
    public void clickOnBackHomeButton(){

        bot.clickOn(backHomeButton);
        System.out.println("Clicked on BackHome Button");
    }
    public String getSuccessMessage()
    {
        return bot.displayedText(successMessage);
    }

    public String pageURL()
    {
       return bot.currentURL();
    }
}




