package caspar.Pages;

import caspar.framework.BasePage;
import caspar.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import java.awt.*;
import java.awt.event.KeyEvent;

public class AddNewPatientPage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String FIRST_NAME_BOX_XPATH = "//input[@formcontrolname='first_name']";
    private static final String LAST_NAME_BOX_XPATH = "//input[@formcontrolname='last_name']";
    private static final String COUNTRY_SELECTOR_XPATH = "//span[contains(text(), 'Country')]";
    private static final String SUBMIT_BUTTON_XPATH = "//button[@type='submit']";


    @FindBy(xpath = FIRST_NAME_BOX_XPATH)
    private WebElement firstNameTextbox;

    @FindBy(xpath = LAST_NAME_BOX_XPATH)
    private WebElement lastNameTextbox;

    @FindBy(xpath = COUNTRY_SELECTOR_XPATH)
    private WebElement countrySelector;

    @FindBy(xpath = SUBMIT_BUTTON_XPATH)
    private WebElement submitButton;


    public void fillFirstName(String value) {
        test.log(LogStatus.INFO, "Filling First Name by '" + value + "'...");
        firstNameTextbox.sendKeys(value);
    }

    public void fillLastName(String value) {
        test.log(LogStatus.INFO, "Filling Last Name by '" + value + "'...");
        lastNameTextbox.sendKeys(value);
    }

    public void fillDateOfBirthByTestValues() {
        test.log(LogStatus.INFO, "Filling Date of birth by test values...");
        lastNameTextbox.sendKeys(Keys.TAB);
        try {
            Robot rb = new Robot();
            rb.keyPress(KeyEvent.VK_NUMPAD2);
            rb.keyRelease(KeyEvent.VK_NUMPAD2);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyPress(KeyEvent.VK_DOWN);
            rb.keyRelease(KeyEvent.VK_DOWN);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyPress(KeyEvent.VK_DOWN);
            rb.keyRelease(KeyEvent.VK_DOWN);
        } catch (AWTException ex) {
            System.err.println("Robot error");
        }
    }


    public PatientCreatedPage clickSubmitButton() {
        test.log(LogStatus.INFO, "Clicking Submit button...");
        submitButton.click();
        return initPage(PatientCreatedPage.class);
    }

    public void selectCountryByText(String text) {
        test.log(LogStatus.INFO, "Filling Country by '" + text + "'...");
        new Actions(driver).pause(500).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", countrySelector);
//        js.executeScript("window.scrollBy(0,500)");
        countrySelector.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + text + "')]")).click();
    }

}
