package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


   /* // 2. Driver and Wait declaration
    ChromeOptions loginPageBrowserOptions;
    WebDriver loginPageDriver;
    Wait<WebDriver> loginPageWait;*/

    //Instead of all of these, only Bot object will be declared
    Bot loginBot;

    // 3. Class Constructor
    /*public LoginPage (WebDriver loginPageDriver, Wait<WebDriver> loginPageWait, ChromeOptions loginPageBrowserOptions)
    {

        this.loginPageBrowserOptions=loginPageBrowserOptions;
        this.loginPageDriver=loginPageDriver;
        this.loginPageWait=loginPageWait;

    }*/
    //And instead of initializing all of them, only Bot will be initialized

    public LoginPage(Bot bot)
    {
        this.loginBot =bot;
    }


    public LoginPage(WebDriver driver) {
    }

    // 4. Action Methods to interact with the page
    public void navigateToLoginPage()
    {
        loginBot.navigateTo(loginPageURL);
    }

    public void enterValidUserName()
    {
        /*loginPageWait.until(x->{
            x.findElement(usernameFieldLocator).sendKeys(validUserName);
            return true;
        });*/
        loginBot.typeInto(usernameFieldLocator,validUserName);

    }

    public void enterValidPassword()
    {
       /* loginPageWait.until(x->{
            x.findElement(passwordFieldLocator).sendKeys(validPassword);
            return true;
        });*/
        loginBot.typeInto(passwordFieldLocator,validPassword);
    }


    public void enterInvalidUserName()
    {
       /* loginPageWait.until(x->{
            x.findElement(usernameFieldLocator).sendKeys(invalidUserName);
            return true;
        });*/
        loginBot.typeInto(usernameFieldLocator,invalidUserName);
    }

    public void enterInvalidPassword()
    {
        /*loginPageWait.until(x->{
            x.findElement(passwordFieldLocator).sendKeys(invalidPassword);
            return true;
        });*/
        loginBot.typeInto(passwordFieldLocator,invalidPassword);
    }

    public void clickOnLoginButton()
    {
        /*loginPageWait.until(x->{
           x.findElement(loginButtonLocator).click();
            return true;
        });*/
        loginBot.clickOn(loginButtonLocator);
    }

    public String pageURL()
    {
       /*return loginPageDriver.getCurrentUrl();*/
        return loginBot.currentURL();
    }

    public String ErrorMsgText()
    {

       /* return loginPageWait.until(x->{
            return x.findElement(errorMessageLocator).getText();
        });*/
        return loginBot.displayedText(errorMessageLocator);


    }


}
