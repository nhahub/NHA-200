package SauceDemoPagesTest;

import Engine.Bot;

import org.testng.annotations.*;

@Listeners (listener.TestListener.class)
public abstract class BaseTest {

    Bot bot;


    @BeforeClass
    public void sessionStartup()
    {
        bot = new Bot("chrome");
    }

    @AfterClass
    public void sessionTearDown()
    {

        bot.sessionTearDown();
    }

}
