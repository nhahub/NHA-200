package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class YourInformationPage
    {

   /*     public ChromeOptions options;
        public WebDriver driver;
        public Wait<WebDriver> wait;*/
        Bot bot;

        //Locators:
         By firstNameField = By.id("first-name");
         By lastNameField = By.id("last-name");
         By postalCodeField = By.id("postal-code");
         By continueButton = By.id("continue");
         By cancelButton = By.id("cancel");
         By errorMessageLocator = By.cssSelector("h3[data-test='error']");

         String informationPage="https://www.saucedemo.com/checkout-step-one.html";
         String validFirstName="Mayar";
         String validLastName="Magdy";
         String validPostalCode ="52017";


        // Constructor
        public YourInformationPage(Bot bot) {

           /* this.driver = driver;
            this.wait=wait;
            this.options=options;*/
            this.bot =bot;
        }

        //Methods
        public void navigateToCheckoutPage()
        {
           bot.navigateTo(informationPage);
        }

        public void enterValidFirstName()
        {
          /*  driver.findElement(firstNameField).sendKeys(validFirstName);*/
            bot.typeInto(firstNameField,validFirstName);
        }

        public void enterValidLastName()
        {
            /*driver.findElement(lastNameField).sendKeys(validFirstName);*/
            bot.typeInto(lastNameField,validFirstName);
        }

        public void enterValidPostalCode()
        {
          /*  driver.findElement(postalCodeField).sendKeys(validPostalCode)*/;
          bot.typeInto(postalCodeField,validPostalCode);

        }

        public void clickOnContinueButton()
        {
           // driver.findElement(continueButton).click();
            bot.clickOn(continueButton);
        }

        public void clickOnCancelButton()
        {
           /* driver.findElement(cancelButton).click();*/
            bot.clickOn(cancelButton);
        }

        public String pageURL()
        {
            /*return driver.getCurrentUrl();*/
            return bot.currentURL();
        }

        public String errorMessageContent()
        {
            /*return driver.findElement(errorMessageLocator).getText();*/
            return bot.displayedText(errorMessageLocator);
        }


// ALL THE INFO
// public void fillInformationAndContinue(String firstName, String lastName, String postalCode) {
//        enterFirstName(firstName);
//        enterLastName(lastName);
//        enterPostalCode(postalCode);
//        clickOnContinueShoppingButton();
//    }
}
