package DriverFactory;

import Utilities.PropertiesUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxFactory extends AbstractDriver implements BaseWebDriverOptions<FirefoxOptions>
{
    @Override // from BaseWebDriverOptions
    public FirefoxOptions getOptions() //initialize the customized browser options
    {
        FirefoxOptions firefoxOptions =new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("-private");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--remote-allow-origins=*");
        if (!PropertiesUtility.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            firefoxOptions.addArguments("--headless");
        }

        return firefoxOptions;
    }

    @Override //from AbstractDriver
    public WebDriver initDriver()
    {
        return new FirefoxDriver(getOptions());
    }
}
