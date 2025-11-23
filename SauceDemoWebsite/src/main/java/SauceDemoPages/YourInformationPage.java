package SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class YourInformationPage {
public WebDriver driver;

//Locators:
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");

    // Constructor
    public YourInformationPage(WebDriver driver) {
        this.driver = driver;
    }







    public void navigateToCheckoutPage(String URL)
    {
        driver.get(URL);

    }
    public void enterFirstName(String firstName)
    {
        driver.findElement(firstNameField).sendKeys(firstName);

    }
    public void enterLastName(String lastName)
    {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void enterPostalCode(String postalCode)
    {
        driver.findElement(postalCodeField).sendKeys(postalCode);

    }
    public void clickOnContinueButton()
    {
        driver.findElement(continueButton).click();

    }
    public void clickOnCancelButton()
    {
        driver.findElement(cancelButton).click();

    }
// ALL THE INFO
// public void fillInformationAndContinue(String firstName, String lastName, String postalCode) {
//        enterFirstName(firstName);
//        enterLastName(lastName);
//        enterPostalCode(postalCode);
//        clickOnContinueShoppingButton();
//    }
}
