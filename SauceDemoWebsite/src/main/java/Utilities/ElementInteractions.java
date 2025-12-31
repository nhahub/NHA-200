package Utilities;

import DriverFactory.SystemDriver;
import Utilities.GlobalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static Utilities.GlobalWait.*;

public class ElementInteractions {

    // returning the current thread driver to be used
    /*Note: should always use the thread driver not a static one to prevent any error in the parallel execution*/
    private static WebDriver driver() {
        return SystemDriver.driverGet();
    }


    public static void clickON(By elementToClickOnLocator)
    {
       waitToBeClickable(elementToClickOnLocator).click();
    }

    public static void typeTextInto(By fieldLocator, String textToType)
    {
        waitToBeAbleToType(fieldLocator).sendKeys(textToType);
    }

    public static  String displayedTextOf(By locator)
    {
       return waitToBeVisible(locator).getText();
    }

    public static boolean checkVisibility(By locator)
    {
        return waitToBeVisible(locator).isDisplayed();
    }
    public static String getElementAttribute(By elementLocator,String attributeName)
    {
       return waitToGetAttribute(elementLocator).getAttribute(attributeName);
    }

    public static void apiActionTabKey(By elementLocator)
    {
        driver().findElement(elementLocator).sendKeys(Keys.TAB);
    }
    public static void apiActionEnterKey(By elementLocator)
    {
        driver().findElement(elementLocator).sendKeys(Keys.ENTER);
    }

    public static void select(By dropDownLocator, String visibleText)
    {
        waitToSelect(dropDownLocator).selectByContainsVisibleText(visibleText);
    }
}
