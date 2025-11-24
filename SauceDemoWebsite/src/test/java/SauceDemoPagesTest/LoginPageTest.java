package SauceDemoPagesTest;


import SauceDemoPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest
{


    @Test
    public void successfulLogin_ValidCredentials()
    {
        //constructor parameters should be the ones initialized in the base test

        LoginPage loginPage=new LoginPage(driver,wait,options);
        loginPage.navigateToLoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        String productListingPageURL="https://www.saucedemo.com/inventory.html";
        String currentURL=loginPage.pageURL();

        Assert.assertEquals(currentURL,productListingPageURL);
    }



    @Test
    public void unsuccessfulLogin_BothFieldsEmpty()
    {
      LoginPage loginPage=new LoginPage(driver,wait,options);
        loginPage.navigateToLoginPage();
        loginPage.clickOnLoginButton();
        String actual= loginPage.ErrorMsgText();
        Assert.assertTrue(actual.contains("Username is required"));


    }

    @Test
    public void unsuccessfulLogin_OnlyPasswordFieldEmpty()
    {
      LoginPage loginPage=new LoginPage(driver,wait,options);
        loginPage.navigateToLoginPage();
        loginPage.enterInvalidUserName();
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.ErrorMsgText().contains("Password is required"));


    }

    @Test
    public void unsuccessfulLogin_InvalidCredentials()
    {
      LoginPage loginPage=new LoginPage(driver,wait,options);
        loginPage.navigateToLoginPage();
        loginPage.enterInvalidUserName();
        loginPage.enterInvalidPassword();
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.ErrorMsgText().contains("do not match"));


    }


}
