package Engine;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.sql.DriverManager;
import java.time.Duration;

public class Bot
{
    WebDriver driver;
    Wait<WebDriver> wait;

    public WebDriver setUpBrowserOptions(String targetBrowserName)
    {
        switch (targetBrowserName.toLowerCase())
        {
            case "firefox":
                FirefoxOptions fOptions= new FirefoxOptions();
                fOptions.addArguments("-private");
                System.setProperty("webdriver.gecko.driver", "D:\\DEPI\\firefox\\geckodriver-v0.36.0-win32\\geckodriver.exe");
                FirefoxDriver fDriver=new FirefoxDriver(fOptions);
                fDriver.manage().window().maximize();
                return fDriver;

            case "edge" :
                EdgeOptions eOptions= new EdgeOptions();
                eOptions.addArguments("--start-maximized");
                eOptions.addArguments("--inprivate");
                EdgeDriver eDriver=new EdgeDriver(eOptions);
                return eDriver;

            default:
                ChromeOptions cOptions=new ChromeOptions();
                cOptions.addArguments("--start-maximized").addArguments("--incognito");
                ChromeDriver cDriver = new ChromeDriver(cOptions);
                return cDriver;

        }
    }

    public Bot(String targetBrowserName) {

        this.driver=setUpBrowserOptions(targetBrowserName);

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
