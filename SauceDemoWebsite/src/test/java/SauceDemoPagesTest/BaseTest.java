package SauceDemoPagesTest;

import Engine.Bot;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public abstract class BaseTest {
/*
    ChromeOptions options;
    WebDriver driver;
    Wait<WebDriver> wait;*/

    Bot bot;


    @BeforeMethod
    public void sessionStartup()
    {
        /*options=new ChromeOptions().addArguments("--start-maximized").addArguments("--incognito");
        driver=new ChromeDriver(options);
        wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);*/
        bot = new Bot();
    }

    @AfterMethod
    public void sessionTearDown()
    {
        /*driver.quit();*/
        bot.sessionTearDown();
    }

}
