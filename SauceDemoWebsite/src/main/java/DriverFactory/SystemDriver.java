package DriverFactory;

import org.openqa.selenium.WebDriver;

public class SystemDriver {

    private  static final ThreadLocal<WebDriver> driverThread =new ThreadLocal<>();
    WebDriver driver;

    public SystemDriver (String browserName)
    {
        this.driver=diverSelections(browserName).initDriver();
        driverSet(driver);
    }

    private void driverSet(WebDriver driver)
    {
        driverThread.set(driver);
    }

    public WebDriver driverGet()
    {
        return driverThread.get();
    }

    private AbstractDriver diverSelections(String browserName)
    {

        return switch (browserName.toLowerCase()) {
            case "firefox" -> new FireFoxFactory();
            case "edge" -> new EdgeFactory();
            default -> new ChromeFactory();
        };

    }

    public void driverQuit()
    {
        driverThread.get().quit();
        driverThread.remove();
    }
}
