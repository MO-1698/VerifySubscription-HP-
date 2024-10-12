package org.example;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class VerifySubsPage {
    private SHAFT.GUI.WebDriver driver;

    public VerifySubsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private By HomePage = By.xpath("//a[@style=\"color: orange;\"]");
    private By SubscriptionText = By.xpath("//div[@class=\"single-widget\"]//h2");
    private By EmailTextField = By.xpath("//input[@id=\"susbscribe_email\"]");
    private By ArrowButton = By.xpath("//button[@id=\"subscribe\"]");
    private By SuccessMessage = By.xpath("//div[@class=\"alert-success alert\"]");

    public VerifySubsPage navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }

    public VerifySubsPage scrollToSubscriptionText() {
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(driver.getDriver().findElement(SubscriptionText)).perform();
        return this;
    }

    public VerifySubsPage fillEmailTextField(String email) {
        driver.element().type(EmailTextField, email);
        return this;
    }

    public VerifySubsPage clickOnArrowButton() {
        driver.element().click(ArrowButton );
        return this;

    }

    @Step("Validate that the user is on Home Page")
    public VerifySubsPage ValidateHomePage() {
        driver.element().verifyThat(HomePage).text().contains("Home");
        return this;
    }

    @Step("Validate that subscription text is appear")
    public VerifySubsPage ValidateSubscriptionText() {
        driver.element().verifyThat(SubscriptionText).text().contains("SUBSCRIPTION");
        return this;
    }

    @Step("Validate that success message is appear")
    public VerifySubsPage ValidateSuccessMessage() {
        driver.element().verifyThat(SuccessMessage).text().contains("You have been successfully subscribed!");
        return this;
    }



}
