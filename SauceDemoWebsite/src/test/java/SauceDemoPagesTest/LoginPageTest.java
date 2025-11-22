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

public class LoginPageTest
{
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    //Declaring Driver, Wait, and BrowserOptions
    WebDriver loginPageTestDriver;
    Wait<WebDriver> loginPageTestwait;
    ChromeOptions loginPageTestBrowserOptions;

    LoginPage loginPage;

    String productListingPageURL="https://www.saucedemo.com/inventory.html";


    @Test
    public void successfulLogin_ValidCredentials()
    {
        loginPage.navigateToLoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();

        String currentURL=loginPage.urlAfterLogin();

        Assert.assertEquals(currentURL,productListingPageURL);
    }


    @Test
    public void unsuccessfulLogin_BothFieldsEmpty()
    {
        loginPage.navigateToLoginPage();
        loginPage.clickOnLoginButton();
        String actual= loginPage.ErrorMsgText();
        Assert.assertTrue(actual.contains("Username is required"));


    }

    @Test
    public void unsuccessfulLogin_OnlyPasswordFieldEmpty()
    {
        loginPage.navigateToLoginPage();
        loginPage.enterInvalidUserName();
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.ErrorMsgText().contains("Password is required"));


    }

    @Test
    public void unsuccessfulLogin_InvalidCredentials()
    {
        loginPage.navigateToLoginPage();
        loginPage.enterInvalidUserName();
        loginPage.enterInvalidPassword();
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.ErrorMsgText().contains("do not match"));


    }



    /*****************************************************************************/

    @BeforeMethod
    public void testSessionStartup()
    {
       loginPage = new LoginPage(loginPageTestDriver,loginPageTestwait,loginPageTestBrowserOptions);
    }

    @AfterMethod
    public void testSessionTearDown()
    {
       loginPage.closeLoginPageSession();
    }

}
