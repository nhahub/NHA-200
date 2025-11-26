package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class OverviewPage {


    public WebDriver driver;

    // Locators
    public By firstInventoryItemName = By.className("inventory_item_name");
    public By finishButton = By.id("finish");
    public By cancelButton = By.id("cancel");

    // Constructor
    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public OverviewPage(WebDriver driver, Wait<WebDriver> wait, ChromeOptions options) {
        this.driver = driver;

    }


    public void navigateToOverviewPage(String URL){

        driver.get(URL);
    }
    public String getFirstInventoryItemName(){
        String FirstItemName  = "";
        return driver.findElement(firstInventoryItemName).getText();
    }
    public void clickOnFirstItemName(){
        driver.findElement(firstInventoryItemName).click();

    }
    public  void clickOnFinishButton(){
        driver.findElement(finishButton).click();

    }
    public void clickOnCancelButton(){
        driver.findElement(cancelButton).click();

    }


}





