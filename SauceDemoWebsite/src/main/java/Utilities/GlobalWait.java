package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class GlobalWait
{
    public static WebDriver waitDriver;
    private static Wait<WebDriver> wait;

        public GlobalWait(WebDriver driver)
        {
            waitDriver=driver;
            wait=new FluentWait<>(waitDriver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotInteractableException.class);
        }

        //Just to reuse not repeat the same steps
        public  static boolean elementChecking(By elementLocator)
        {
            if( waitDriver.findElement(elementLocator).isEnabled() &&
                waitDriver.findElement(elementLocator).isDisplayed())
            {
               return  true;
            }
            return false;
        }

        public static WebElement waitToBeVisible(By elementToBeDisplayed)
        {
            return wait.until(d->{
                if ( elementChecking(elementToBeDisplayed) )
                {
                    return d.findElement(elementToBeDisplayed);
                }
                return null;
            });
        }

    public static WebElement waitToBeClickable(By elementToClickOn)
    {
        return wait.until(waitDriver->{
            if ( elementChecking(elementToClickOn) )
            {
                return waitDriver.findElement(elementToClickOn);
            }
            return null;
        });
    }

    public static Select waitToSelect(By dropMenuLocator)
    {
        return wait.until(f-> {
           return  new Select(f.findElement(dropMenuLocator));
        });
    }

    public static WebElement waitToBeAbleToType(By elementToTypeInto)
    {
       return wait.until(d->{
           if ( elementChecking(elementToTypeInto))
           {
               return d.findElement(elementToTypeInto);
           }
           return null;
       });
    }


    public static WebElement waitToGetAttribute(By elementToGetAttribute)
    {
       return wait.until( d -> {
            if (elementChecking(elementToGetAttribute))
            {
                return d.findElement(elementToGetAttribute);
            }
            return null;
        });

    }



    public WebElement waitUntilTextDisplayed(By elementToGetItsText)
    {
        return wait.until(d->{
            return d.findElement(elementToGetItsText);
        });
    }

}
