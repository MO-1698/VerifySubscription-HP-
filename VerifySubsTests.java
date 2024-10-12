import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.example.VerifySubsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySubsTests {
    private SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validate user subscription Success")
    private void validateVerifySubs() {
        new VerifySubsPage(driver).navigateToURL("https://automationexercise.com/")
                .ValidateHomePage().scrollToSubscriptionText().ValidateSubscriptionText()
                .fillEmailTextField("Sam@yahoo.com").clickOnArrowButton().ValidateSuccessMessage();
    }
}