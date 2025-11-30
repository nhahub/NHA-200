package SauceDemoPagesTest;


import SauceDemoPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest
{

    @Test (dataProvider = "loginTestData")
    public void loginPageTest(String userName, String password, String testCase)
    {
            LoginPage lgP= new LoginPage(bot);
            lgP.navigateToLoginPage();
            lgP.enterUserName(userName);
            lgP.enterPassword(password);
            lgP.clickOnLoginButton();

        switch (testCase)
        {
            case "Successful Login":

                String expectedURL ="https://www.saucedemo.com/inventory.html";
                String currentURL=lgP.pageURL();
                Assert.assertEquals(currentURL, expectedURL);
                break;

            case "Empty Fields" :
                String actual= lgP.ErrorMsgText();
                Assert.assertTrue(actual.contains("Username is required"));
                break;

            case "Empty Password" :
                Assert.assertTrue(lgP.ErrorMsgText().contains("Password is required"));
                break;


            case "Invalid Credentials" :
                Assert.assertTrue(lgP.ErrorMsgText().contains("do not match"));
                break;
        }

    }


    @DataProvider(name = "loginTestData")
    public Object[][] loginTestDataDetails() {
        return new Object[][]{

                {"standard_user", "secret_sauce", "Successful Login"},
                {"", "", "Empty Fields"},
                {"standard_user", "", "Empty Password"},
                {"TestName", "InvalidPassword", "Invalid Credentials"}

        };
    }

}
