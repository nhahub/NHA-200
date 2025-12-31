package SauceDemoPagesTest;

import Engine.Bot;

import org.testng.annotations.*;

import static Utilities.PropertiesUtility.*;


@Listeners (listener.TestListener.class)
public abstract class BaseTest {

    Bot bot;

    @BeforeMethod
    public void sessionStartup()
    {
        bot = new Bot(getPropertyValue("browser"));
    }

    @AfterMethod
    public void sessionTearDown()
    {
        bot.sessionTearDown();
    }

}
