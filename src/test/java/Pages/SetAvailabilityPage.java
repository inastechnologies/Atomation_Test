package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SetAvailabilityPage extends BasePage
{
    public SetAvailabilityPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "h4.text-uppercase")
    public WebElement AppointmentsHeading;

    @FindBy(xpath = "//div[text()=' SET AVAILABILITY ']")
    public WebElement SetAvailability;

    @FindBy(css = "input.radio")
    public List<WebElement> SessionTypeRadioButtons;

    @FindBy(css = "button.button")
    public WebElement  NextButton;

    @FindBy(xpath = "//button[text()=' Create Appointment or Event '] ")
    public WebElement CreateAppointmentSessionTypeHeading;

    @FindBy(xpath = "//button[text()=' Set Confirmations & Reminders '] ")
    public WebElement SetConfirmationRemindersHeading;

    @FindBy(xpath = "//button[text()=' Cancellation or Reschedule Policy '] ")
    public WebElement CancellationRescheduleHeading;

    @FindBy(xpath = "//button[text()='   Payments &  Integrations '] ")
    public WebElement PaymentsIntegrationsHeading;

    @FindBy(xpath = "//div[text()='MANAGE ORDERS']")
    public WebElement ManageOrders;


    public CreateAppointmentPage ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage()
    {
        SessionTypeRadioButtons.get(1).click();
        NextButton.click();
        return new CreateAppointmentPage(driver);
    }

    public CreateAppointmentPage_Group ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage()
    {
        SessionTypeRadioButtons.get(0).click();
        NextButton.click();
        return new CreateAppointmentPage_Group(driver);
    }
}
