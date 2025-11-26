package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletePage {

    public WebDriver driver;
    //Locators :
    public By finishButton = By.id("finish");
    public By backHomeButton = By.id("back-to-products");
    public By successMessage = By.className("complete-header");

    public CompletePage(WebDriver driver) {

        this.driver = driver;
    }

    public CompletePage(WebDriver driver, Wait<WebDriver> wait, ChromeOptions options) {
        this.driver = driver;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)); return driver.findElement(successMessage).getText();
    }
}




