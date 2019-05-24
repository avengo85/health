package caspar;

import caspar.Pages.*;
import caspar.framework.BasePage;
import caspar.framework.BaseTest;
import org.testng.annotations.*;


public class WebTest extends BaseTest {
    private AddNewPatientPage addNewPatientPage;
    private LoginPage loginPage;
    private static final String INITIAL_ID = "IXE0865";
    private static final String INITIAL_PASSWORD = "78350619";
    private static final String FIRST_NAME = "First";
    private static final String LAST_NAME = "Last";
    private static final String COUNTRY = "Germany";

    @Test
    public void addNewPatientTest() {

        loginPage = BasePage.initPage(LoginPage.class);
        MyPatientsPage myPatientsPage = loginPage.login(INITIAL_ID, INITIAL_PASSWORD);
        addNewPatientPage = myPatientsPage.clickAddNewPatient();
        addNewPatientPage.fillFirstName(FIRST_NAME);
        addNewPatientPage.fillLastName(LAST_NAME);
        addNewPatientPage.fillDateOfBirthByTestValues();
        addNewPatientPage.selectCountryByText(COUNTRY);
        PatientCreatedPage patientCreatedPage = addNewPatientPage.clickSubmitButton();
        String newUserId = patientCreatedPage.getNewId();
        String newUserPassword = patientCreatedPage.getNewPassword();
        loginPage = patientCreatedPage.logout();
        TermsOfUsePage termsOfUsePage = loginPage.login1stTime(newUserId, newUserPassword);
        termsOfUsePage.assertRelease();
        termsOfUsePage.assertTermOfUse();
    }

}


