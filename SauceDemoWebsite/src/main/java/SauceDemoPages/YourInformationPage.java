package SauceDemoPages;

import Engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class YourInformationPage
    {


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

            this.bot =bot;
        }

        //Methods
        public void navigateToCheckoutPage()
        {
           bot.navigateTo(informationPage);
            System.out.println("Navigated to "+informationPage);
        }

        public void enterFirstName(String firstName)
        {
            bot.typeInto(firstNameField,firstName);
            System.out.println("Entered first name "+firstName);
        }

        public void enterLastName(String lastName)
        {
            bot.typeInto(lastNameField,lastName);
            System.out.println("Entered Last name "+lastName);
        }

        public void enterPostalCode(String postalCode)
        {
          bot.typeInto(postalCodeField,postalCode);
            System.out.println("Entered postalCode "+postalCode);

        }

        public void clickOnContinueButton()
        {
            bot.clickOn(continueButton);
        }

        public void clickOnCancelButton()
        {
            bot.clickOn(cancelButton);
        }

        public String pageURL()
        {
            return bot.currentURL();
        }

        public String errorMessageContent()
        {
            return bot.displayedText(errorMessageLocator);
        }


 //ALL THE INFO
         public void fillValidInformationAndContinue() {
                navigateToCheckoutPage();
                enterFirstName(validFirstName);
                enterLastName(validLastName);
                enterPostalCode(validPostalCode);
                clickOnContinueButton();
             System.out.println("Order information filled successfully");
            }
}
