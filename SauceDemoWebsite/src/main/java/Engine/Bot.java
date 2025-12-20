package Engine;

import DriverFactory.SystemDriver;
import Utilities.BrowserActions;
import Utilities.ElementInteractions;
import Utilities.GlobalWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Bot
{
    WebDriver driver;

    public Bot(String targetBrowserName) {

        this.driver= new SystemDriver(targetBrowserName).driverGet();
        new ElementInteractions(this.driver);
        new BrowserActions(this.driver);

    }

    public void navigateTo(String URL) {
       BrowserActions.navigateToURL(URL);
    }

    public void clickOn(By objectLocator) {
        ElementInteractions.clickON(objectLocator);
    }

    public void typeInto(By fieldLocator, String text) {
        ElementInteractions.typeTextInto(fieldLocator,text);
    }

    public String currentURL() {
        return BrowserActions.currentURL();
    }


    public String displayedText(By displayedTextLocator) {
        return ElementInteractions.displayedTextOf(displayedTextLocator);
    }

    public void selectFromList(By listLocator, String textToSelect)
    {
        ElementInteractions.select(listLocator,textToSelect);
    }

    public boolean checkObjectDisplay(By objectLocator)
    {
        return ElementInteractions.checkVisibility(objectLocator);
    }

    public void alertOK()
    {
        BrowserActions.switchToAlert().accept();
    }

    public void sessionTearDown() {
       //driver.quit();
        BrowserActions.closeBrowser();
    }
}
