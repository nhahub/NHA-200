package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LoginPage
{
    // 1. Locators and Variables
    By usernameFieldLocator = By.xpath("//input[@id='user-name']");
    By passwordFieldLocator= By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//input[@id='login-button']");
    By errorMessageLocator =By.xpath("//h3[@data-test='error']");

    String loginPageURL="https://www.saucedemo.com/";
    String validUserName="standard_user";
    String validPassword="secret_sauce";
    String invalidUserName="Test_Name";
    String invalidPassword="Test_Password";


    // 2. Driver and Wait declaration
    ChromeOptions loginPageBrowserOptions;
    WebDriver loginPageDriver;
    Wait<WebDriver> loginPageWait;


    // 3. Class Constructor
    public LoginPage (WebDriver loginPageDriver, Wait<WebDriver> loginPageWait, ChromeOptions loginPageBrowserOptions)
    {

        this.loginPageBrowserOptions=loginPageBrowserOptions;
        this.loginPageDriver=loginPageDriver;
        this.loginPageWait=loginPageWait;


        this.loginPageBrowserOptions= new ChromeOptions().addArguments("--start-maximized").addArguments("--incognito");
        this.loginPageDriver=new ChromeDriver(this.loginPageBrowserOptions);
        this.loginPageWait= new FluentWait<>(this.loginPageDriver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);

    }

    // 4. Action Methods to interact with the page
    public void navigateToLoginPage()
    {
        loginPageDriver.navigate().to(loginPageURL);
    }

    public void enterValidUserName()
    {
        loginPageWait.until(x->{
            x.findElement(usernameFieldLocator).sendKeys(validUserName);
            return true;
        });

    }

    public void enterValidPassword()
    {
        loginPageWait.until(x->{
            x.findElement(passwordFieldLocator).sendKeys(validPassword);
            return true;
        });
    }


    public void enterInvalidUserName()
    {
        loginPageWait.until(x->{
            x.findElement(usernameFieldLocator).sendKeys(invalidUserName);
            return true;
        });
    }

    public void enterInvalidPassword()
    {
        loginPageWait.until(x->{
            x.findElement(passwordFieldLocator).sendKeys(invalidPassword);
            return true;
        });
    }

    public void clickOnLoginButton()
    {
        loginPageWait.until(x->{
           x.findElement(loginButtonLocator).click();
            return true;
        });
    }

    public String urlAfterLogin()
    {
       return loginPageDriver.getCurrentUrl();
    }

    public String ErrorMsgText()
    {

        return loginPageWait.until(x->{
          String msg= x.findElement(errorMessageLocator).getText();
            return msg;
        });



    }

    public void closeLoginPageSession()
    {
        loginPageDriver.quit();
    }

}
