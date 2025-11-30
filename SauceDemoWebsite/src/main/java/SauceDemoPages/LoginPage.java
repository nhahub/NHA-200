package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;

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



    Bot loginBot;


    public LoginPage(Bot bot)
    {
        this.loginBot =bot;
    }


    // 4. Action Methods to interact with the page
    public void navigateToLoginPage()
    {
        loginBot.navigateTo(loginPageURL);
        System.out.println("navigated to "+loginPageURL);
    }

    public void enterUserName(String userName)
    {
        loginBot.typeInto(usernameFieldLocator,userName);
        System.out.println("Entered first name "+userName);
    }


    public void enterPassword(String password)
    {
        loginBot.typeInto(passwordFieldLocator,password);
        System.out.println("Entered password "+password);
    }


    public void clickOnLoginButton()
    {
        loginBot.clickOn(loginButtonLocator);
        System.out.println("clicked on login button");
    }

    public String pageURL()
    {

        return loginBot.currentURL();
    }

    public String ErrorMsgText()
    {
        return loginBot.displayedText(errorMessageLocator);
    }

    public void successfulLogin()
    {
        navigateToLoginPage();
        enterUserName(validUserName);
        enterPassword(validPassword);
        clickOnLoginButton();
    }

}
