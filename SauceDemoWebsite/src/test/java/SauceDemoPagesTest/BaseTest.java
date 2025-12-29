package SauceDemoPagesTest;

import Engine.Bot;

import org.testng.annotations.*;

import static Utilities.PropertiesUtility.getPropertyValue;
import static Utilities.PropertiesUtility.propertiesLoading;

@Listeners (listener.TestListener.class)
public abstract class BaseTest {

    Bot bot;


    @BeforeClass
    public void sessionStartup()
    {
        propertiesLoading();
        bot = new Bot(getPropertyValue("browser"));
    }

    @AfterClass
    public void sessionTearDown()
    {
        bot.sessionTearDown();
    }

}
