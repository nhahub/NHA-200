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
    }
    public void clickOnFinishButton(){
      /*  driver.findElement(finishButton).click();*/
        bot.clickOn(finishButton);
    }
    public void clickOnBackHomeButton(){
        /*driver.findElement(backHomeButton).click();*/
        bot.clickOn(backHomeButton);
    }
    public String getSuccessMessage()
    {
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)); return driver.findElement(successMessage).getText();*/

        return bot.displayedText(successMessage);
    }
}




