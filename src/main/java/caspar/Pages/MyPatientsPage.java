package caspar.Pages;

import caspar.framework.BasePage;
import caspar.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class MyPatientsPage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String ADD_PATIENT_BUTTON_XPATH = "//button[contains(text(),'Add Patient')]";


    @FindBy(xpath = ADD_PATIENT_BUTTON_XPATH)
    private WebElement addPatientButton;


    public AddNewPatientPage clickAddNewPatient() {
        test.log(LogStatus.INFO, "Clicking 'Add New Patient' button...");
        addPatientButton.click();
        return initPage(AddNewPatientPage.class);
    }
}


