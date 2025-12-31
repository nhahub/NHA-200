package Utilities;

import DriverFactory.SystemDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class GlobalWait
{
    // returning fluent wait type using the current thread driver to maintain the same driver for the same thread
    /*Note: should always use the thread driver not a static one to prevent any error in the parallel execution*/
        private static Wait<WebDriver> getWait() {
        return new FluentWait<>(SystemDriver.driverGet())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
    }


        //Just to reuse not repeat the same steps
        public  static boolean elementChecking(By elementLocator)
        {
            WebDriver waitDriver = SystemDriver.driverGet();
            if( waitDriver.findElement(elementLocator).isEnabled() &&
                waitDriver.findElement(elementLocator).isDisplayed())
            {
               return  true;
            }
            return false;
        }

        public static WebElement waitToBeVisible(By elementToBeDisplayed)
        {
            return getWait().until(d->{
                if ( elementChecking(elementToBeDisplayed) )
                {
                    return d.findElement(elementToBeDisplayed);
                }
                return null;
            });
        }

    public static WebElement waitToBeClickable(By elementToClickOn)
    {
        return getWait().until(waitDriver->{
            if ( elementChecking(elementToClickOn) )
            {
                return waitDriver.findElement(elementToClickOn);
            }
            return null;
        });
    }

    public static Select waitToSelect(By dropMenuLocator)
    {
        return getWait().until(f-> {
           return  new Select(f.findElement(dropMenuLocator));
        });
    }

    public static WebElement waitToBeAbleToType(By elementToTypeInto)
    {
       return getWait().until(d->{
           if ( elementChecking(elementToTypeInto))
           {
               return d.findElement(elementToTypeInto);
           }
           return null;
       });
    }


    public static WebElement waitToGetAttribute(By elementToGetAttribute)
    {
       return getWait().until( d -> {
            if (elementChecking(elementToGetAttribute))
            {
                return d.findElement(elementToGetAttribute);
            }
            return null;
        });

    }



    public WebElement waitUntilTextDisplayed(By elementToGetItsText)
    {
        return getWait().until(d->{
            return d.findElement(elementToGetItsText);
        });
    }

}
