package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class YourInformationPage
    {

        public ChromeOptions options;
        public WebDriver driver;
        public Wait<WebDriver> wait;

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
        public YourInformationPage(WebDriver driver, Wait<WebDriver> wait, ChromeOptions options) {

            this.driver = driver;
            this.wait=wait;
            this.options=options;
        }

        //Methods
        public void navigateToCheckoutPage()
        {
            driver.navigate().to(informationPage);
        }

        public void enterValidFirstName()
        {
            driver.findElement(firstNameField).sendKeys(validFirstName);
        }

        public void enterValidLastName()
        {
            driver.findElement(lastNameField).sendKeys(validFirstName);
        }

        public void enterValidPostalCode()
        {
            driver.findElement(postalCodeField).sendKeys(validPostalCode);

        }

        public void clickOnContinueButton()
        {
            driver.findElement(continueButton).click();
        }

        public void clickOnCancelButton()
        {
            driver.findElement(cancelButton).click();
        }

        public String pageURL()
        {
            return driver.getCurrentUrl();
        }

        public String errorMessageContent()
        {
            return driver.findElement(errorMessageLocator).getText();
        }


// ALL THE INFO
// public void fillInformationAndContinue(String firstName, String lastName, String postalCode) {
//        enterFirstName(firstName);
//        enterLastName(lastName);
//        enterPostalCode(postalCode);
//        clickOnContinueShoppingButton();
//    }
}
