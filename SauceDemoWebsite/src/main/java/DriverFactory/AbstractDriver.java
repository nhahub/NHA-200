package DriverFactory;

import org.openqa.selenium.WebDriver;

//An abstract (general) class to be implemented when initializing the driver
public abstract class AbstractDriver {

    public abstract WebDriver initDriver();

}
