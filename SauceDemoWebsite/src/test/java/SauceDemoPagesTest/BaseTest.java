package SauceDemoPagesTest;

import Engine.Bot;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;


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
