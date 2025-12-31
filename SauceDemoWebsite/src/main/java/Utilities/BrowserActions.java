package Utilities;

import DriverFactory.SystemDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    // returning the current thread driver to be used
    /*Note: should always use the thread driver not a static one to prevent any error in the parallel execution*/
    private static WebDriver driver() {
        return SystemDriver.driverGet();
    }

    public static void navigateToURL(String URL)
    {
        driver() .navigate().to(URL);
    }

    public static String currentURL()
    {
        return driver() .getCurrentUrl();
    }

   public static String currentPageTitle()
   {
       return driver().getTitle();
   }

   public static Alert switchToAlert()
   {
       LoggerFactory.logInfo("Moving to the poppedUp Alert");
       return driver() .switchTo().alert();
   }

   public static void closeBrowser()
   {
       driver() .quit();
   }


}
