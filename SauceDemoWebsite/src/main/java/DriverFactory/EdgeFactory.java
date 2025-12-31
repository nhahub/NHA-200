package DriverFactory;

import Utilities.PropertiesUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstractDriver implements BaseWebDriverOptions<EdgeOptions>{

    @Override // from BaseWebDriverOptions
    public EdgeOptions getOptions() //initialize the customized browser options
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--inprivate");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--remote-allow-origins=*");
      if (!PropertiesUtility.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            edgeOptions.addArguments("--headless");
        }

        return edgeOptions;
    }

    @Override //from AbstractDriver
    public WebDriver initDriver()
    {
        return new EdgeDriver(getOptions());
    }
}
