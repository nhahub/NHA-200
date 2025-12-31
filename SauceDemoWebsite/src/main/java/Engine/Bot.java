package Engine;

import DriverFactory.SystemDriver;
import Utilities.BrowserActions;
import Utilities.ElementInteractions;
import org.openqa.selenium.*;


import static DriverFactory.SystemDriver.driverQuit;

public class Bot
{
    WebDriver driver;

    public Bot(String targetBrowserName) {
        SystemDriver.driverSet(targetBrowserName);
    }

    private WebDriver driver() {
        return SystemDriver.driverGet();
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
        driverQuit();
    }
}
