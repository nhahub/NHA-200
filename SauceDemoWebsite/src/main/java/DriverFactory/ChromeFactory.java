package DriverFactory;


import Utilities.PropertiesUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends AbstractDriver implements BaseWebDriverOptions<ChromeOptions> {

    @Override // from the baseWebDriverOptions
    public ChromeOptions getOptions() //initialize the customized browser options
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");

         if (!PropertiesUtility.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            chromeOptions.addArguments("--headless");
        }

        return chromeOptions;
    }

    @Override // from the abstract driver
    public WebDriver initDriver()
    {
        return new ChromeDriver(getOptions());
    }
}
