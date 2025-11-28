package Engine;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Bot
{

    ChromeOptions options ;
    WebDriver driver;
    Wait<WebDriver> wait;

    public Bot() {

        options = new ChromeOptions().addArguments("--start-maximized").addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public void navigateTo(String URL) {
        driver.navigate().to(URL);
    }

    public void clickOn(By objectLocator) {
        wait.until((f) -> {
            f.findElement(objectLocator).click();
            return true;
        });
    }

    public void typeInto(By fieldLocator, String text) {
        wait.until((f) -> {
            f.findElement(fieldLocator).click();
            f.findElement(fieldLocator).clear();
            f.findElement(fieldLocator).sendKeys(text);
            return true;
        });
    }

    public String currentURL() {

        return wait.until(f ->
        {
            return f.getCurrentUrl();
        });
    }


    public String displayedText(By displayedTextLocator) {
        return wait.until(f->
        {
            return f.findElement(displayedTextLocator).getText();
        });
    }

    public void selectFromList(By listLocator, String textToSelect)
    {
        wait.until(f->{
            Select select =new Select(f.findElement(listLocator));
            select.selectByContainsVisibleText(textToSelect);
            return true;
        });

    }

    public boolean checkObjectDisplay(By objectLocator)
    {
        return wait.until(f->{
            return f.findElement(objectLocator).isDisplayed();
        });
    }

    public void sessionTearDown() {
        driver.quit();
    }
}
