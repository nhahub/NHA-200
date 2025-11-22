package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    public WebDriver driver;
    //Locators :
    public By finishButton = By.id("finish");
    public By backHomeButton = By.id("back-to-products");
    public By successMessage = By.className("complete-header");

    public CompletePage(WebDriver driver) {
    }


    public void navigateToCompletePage(String URL){

        driver.get(URL);
    }
    public void clickOnFinishButton(){
        driver.findElement(finishButton).click();
    }
    public void clickOnBackHomeButton(){
        driver.findElement(backHomeButton).click();
    }
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}




