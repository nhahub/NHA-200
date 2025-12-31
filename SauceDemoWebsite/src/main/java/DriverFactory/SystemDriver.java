package DriverFactory;

import org.openqa.selenium.WebDriver;

public class SystemDriver {


    private  static final ThreadLocal<WebDriver> driverThread =new ThreadLocal<>();

       private SystemDriver()
       {super(); }


    public static void driverSet(String browserName)
    {
        WebDriver driver = driverSelections(browserName).initDriver(); //initialize the selected driver
        driverThread.set(driver);           // has to be set using the thread local to be used in the parallel execution
    }

    public static WebDriver driverGet()
    {
        return driverThread.get();      // Returning the current thread driver
    }

    // A helper method to be used to return the target factory based on the user selection
    private static AbstractDriver driverSelections(String browserName)
    {

        return switch (browserName.toLowerCase()) {
            case "firefox" -> new FireFoxFactory();
            case "edge" -> new EdgeFactory();
            default -> new ChromeFactory();
        };

    }

    // this method used to quit from the thread driver and remove the reference to prevent any memory leaks
    public static void driverQuit()
    {
        driverThread.get().quit();
        driverThread.remove();
    }
}
