package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditConfirmationsRemindersPage extends BasePage
{
    public EditConfirmationsRemindersPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.title")
    public List<WebElement> RequiredFields;

    @FindBy(xpath = "//input[@disabled='false']")
    public List<WebElement> DisabledFields;

    @FindBy(xpath = "//input[@formcontrolname='pract_email_id']")
    public WebElement PractitionerEmail;

    @FindBy(xpath = "//input[@formcontrolname='conformation_sms']")
    public WebElement ConfirmationSms;

    @FindBy(xpath = "//input[@formcontrolname='remainders_sms']")
    public WebElement ReminderSms;

    @FindBy(xpath = "//input[@formcontrolname='cancellation_sms']")
    public WebElement CancellationSms;

    @FindBy(xpath = "//input[@formcontrolname='third']")
    public WebElement FirstReminder;

    @FindBy(xpath = "//select[@formcontrolname='third_remainder']")
    public WebElement FirstReminderDays;

    @FindBy(xpath = "//input[@formcontrolname='second']")
    public WebElement SecondReminder;

    @FindBy(xpath = "//select[@formcontrolname='second_remainder']")
    public WebElement SecondReminderHours;

    @FindBy(xpath = "//input[@formcontrolname='first']")
    public WebElement ThirdReminder;

    @FindBy(xpath = "//select[@formcontrolname='first_remainder']")
    public WebElement ThirdReminderMins;

    @FindBy(css = "i.fa.fa-pencil")
    public WebElement EditPencil;

    @FindBy(css = "button.q-button.view-button")
    public WebElement SaveAndContinue;

    @FindBy(css = "div.mat-tab-label")
    public List<WebElement> Group_OneOnOne;


    public CancelletionAndReschedulePage EnterEmail_SelectCheckBoxesAndNavigateToCancellationAndReschedulingPage(String Email)
    {
        PractitionerEmail.sendKeys(Email);
        ConfirmationSms.click();
        ReminderSms.click();
        CancellationSms.click();
        FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(FirstReminderDays, "1Day");
        SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(SecondReminderHours, "1Hours");
        ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(ThirdReminderMins, "1Minutes");
        SaveAndContinue.click();
        return new CancelletionAndReschedulePage(driver);
    }
}
