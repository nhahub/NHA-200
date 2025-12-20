package DriverFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends AbstractDriver implements BaseWebDriverOptions<ChromeOptions> {

    @Override
    public ChromeOptions getOptions()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");
        /*
         if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            chromeOptions.addArguments("--headless");
        }
        */
        return chromeOptions;
    }

    @Override
    public WebDriver initDriver()
    {
        return new ChromeDriver(getOptions());
    }
}
