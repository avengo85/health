package caspar.Pages;

import caspar.framework.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import caspar.framework.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TermsOfUsePage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String TERM_OF_USE_LINK_XPATH = "//span[contains(text(),'terms of use')]";
    private static final String RELEASE_LINK_XPATH = "//span[contains(text(),'release of medical information')]";

    @FindBy(xpath = TERM_OF_USE_LINK_XPATH)
    private WebElement termOfUseLink;

    @FindBy(xpath = RELEASE_LINK_XPATH)
    private WebElement releaseLink;


    public void  assertTermOfUse() {
        test.log(LogStatus.INFO, "Checking 'terms of use' is displayed...");
        Assert.assertTrue(termOfUseLink.isDisplayed());
    }

    public void  assertRelease() {
        test.log(LogStatus.INFO, "Checking 'release of medical information' is displayed...");
        Assert.assertTrue(releaseLink.isDisplayed());
    }
}
