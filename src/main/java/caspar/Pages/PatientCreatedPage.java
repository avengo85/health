package caspar.Pages;

import caspar.framework.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import caspar.framework.BaseTest;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PatientCreatedPage extends BasePage {

    public ExtentTest test = BaseTest.test;


    private static final String NEW_ID_XPATH = "//div[contains(text(),'Caspar ID')]/following::div[1]";
    private static final String NEW_PASSWORD_XPATH = "//div[contains(text(),'Temporary Password')]/following::div[1]";
    private static final String USER_LOGO_XPATH = "//app-user-logo";
    private static final String SIGN_OUT_BUTTON_XPATH = "//button[contains(text(),'Sign out')]";
    private static final String CLOSE_BUTTON_XPATH = " //span[contains(text(),'Close')]";


    @FindBy(xpath = NEW_ID_XPATH)
    private WebElement newIDTextPlace;

    @FindBy(xpath = NEW_PASSWORD_XPATH)
    private WebElement newPasswordPlace;

    @FindBy(xpath = USER_LOGO_XPATH)
    private WebElement userLogo;

    @FindBy(xpath = SIGN_OUT_BUTTON_XPATH)
    private WebElement signOutButton;

    @FindBy(xpath = CLOSE_BUTTON_XPATH)
    private WebElement closeButton;

    public String getNewId() {
        new Actions(driver).pause(500).perform();
        String id = newIDTextPlace.getText();
        test.log(LogStatus.INFO, "New user ID: " + id);
        return id;
    }

    public String getNewPassword() {
        String id = newPasswordPlace.getText();
        test.log(LogStatus.INFO, "New user password: " + id);
        closeButton.click();
        return id;
    }

    public LoginPage logout() {
        test.log(LogStatus.INFO, "Logging out...");
        userLogo.click();
        signOutButton.click();
        return initPage(LoginPage.class);
    }
}
