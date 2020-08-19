package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SetConfirmationsRemindersPage extends BasePage
{
    public SetConfirmationsRemindersPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//input[@formcontrolname='pract_email_id']")
    public WebElement PractitionerEmail;

    @FindBy(xpath = "//input[@formcontrolname='remainders_email']")
    public WebElement ReminderEmail;

    @FindBy(xpath = "//input[@formcontrolname='cancellation_email']")
    public WebElement CancellationEmail;

    @FindBy(css = "button.q-button.view-button")
    public WebElement SaveAndContinue;

    public CancelletionAndReschedulePage EnterEmail_SelectCheckBoxesAndNavigateToCancellationAndReschedulingPage(String Email)
    {
        PractitionerEmail.sendKeys(Email);
        ReminderEmail.click();
        CancellationEmail.click();
        SaveAndContinue.click();

        return new CancelletionAndReschedulePage(driver);

    }
}
