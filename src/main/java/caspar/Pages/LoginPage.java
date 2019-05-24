package caspar.Pages;

import caspar.framework.BasePage;
import caspar.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public ExtentTest test = BaseTest.test;
    private static final String USERNAME_BOX_XPATH = "//input[@placeholder='Email/Caspar ID']";
    private static final String PASSWORD_BOX_XPATH = "//input[@placeholder='Password']";
    private static final String LOGIN_BUTTON_XPATH = "//button[contains(@class,'login')]";


    @FindBy(xpath = USERNAME_BOX_XPATH)
    private WebElement usernameTextbox;

    @FindBy(xpath = PASSWORD_BOX_XPATH)
    private WebElement passwordTextbox;

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;


    public MyPatientsPage login(String email, String password) {
        test.log(LogStatus.INFO, "Logging in as the user " + email + "...");
        usernameTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        loginButton.click();
        return initPage(MyPatientsPage.class);
    }


    public TermsOfUsePage login1stTime(String id, String password) {
        test.log(LogStatus.INFO, "Logging in as the user " + id + " at the first time...");
        usernameTextbox.sendKeys(id);
        passwordTextbox.sendKeys(password);
        loginButton.click();
        return initPage(TermsOfUsePage.class);
    }


}
