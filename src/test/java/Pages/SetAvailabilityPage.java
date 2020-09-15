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

    @FindBy(xpath = "//div[text()='MANAGE APPOINTMENTS']")
    public WebElement ManageAppointments;

    @FindBy(css = "h4.text-uppercase")
    public WebElement AppointmentsHeading;

    @FindBy(xpath = "//div[text()=' SET AVAILABILITY ']")
    public WebElement SetAvailability;

    @FindBy(css = "input.radio")
    public List<WebElement> SessionTypeRadioButtons;

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

    @FindBy(css = "div.calender-head")
    public WebElement CalendarHeading;

    @FindBy(css = "div.pointer.forward-button")
    public WebElement ForwardButton;

    @FindBy(css = "div.pointer.reverse-button")
    public WebElement ReverseButton;

    @FindBy(xpath = "//span[text()='10']")
    public WebElement June10;

    @FindBy(xpath = "//span[text()='1 appointments Confirmed']")
    public WebElement ConfirmedAppointment;

    @FindBy(id = "swal2-title")
    public WebElement SwalTitle;

    @FindBy(xpath = "//button[text()='Reject Appointment']")
    public WebElement RejectAppointmentButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CancelButton;

    @FindBy(xpath = "//span[text()='Location ']")
    public WebElement LocationText;

    @FindBy(xpath = "//select[@formcontrolname='pract_location']")
    public WebElement LocationInput;

    @FindBy(xpath = "//span[text()='Modality ']")
    public WebElement ModalityText;

    @FindBy(xpath = "//select[@formcontrolname='modality']")
    public WebElement ModalityInput;

    @FindBy(xpath = "//span[text()='Consultation Type ']")
    public WebElement ConsultationTypeText;

    @FindBy(xpath = "//select[@formcontrolname='consultation_type']")
    public WebElement ConsultationTypeInput;

    @FindBy(xpath = "//span[text()='Do not offer booking more than ']")
    public WebElement NoOfBookingsDaysText;

    @FindBy(xpath = "//select[@formcontrolname='no_of_booking_days']")
    public WebElement NOOfBookingDaysInput;

    @FindBy(xpath = "//span[text()='Select Day ']")
    public WebElement SelectDayText;

    @FindBy(xpath = "//select[@formcontrolname='select_day']")
    public WebElement SelectDayInput;

    @FindBy(xpath = "//div[text()=' Opening Hours : ']")
    public WebElement OpeningHoursText;

    @FindBy(css = "span.slot")
    public List<WebElement> FromToTimeSlots;

    @FindBy(xpath = "//span[text()='X']")
    public List<WebElement> CancelSlot;

    @FindBy(css = "button.swal2-confirm.swal2-styled")
    public WebElement DeleteItButton;

    @FindBy(xpath = "//div[text()=' Appointment type : ']")
    public WebElement AppointmentTypeText;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement NameInput;

    @FindBy(xpath = "//input[@formcontrolname='no_of_min']")
    public WebElement NoOfMinsInput;

    @FindBy(xpath = "//input[@formcontrolname='fee']")
    public WebElement FeesInput;

    @FindBy(xpath = "//input[@formcontrolname='session_can_include_upto']")
    public WebElement SessionCanIncludeUpToInput;

    @FindBy(css = "span.fromToSlot.fromToSlot-type.hand-pointer")
    public List<WebElement> AppointmentTypeSlots;

    @FindBy(css = "span.weeks.hand-pointer")
    public List<WebElement> Days;

    @FindBy(xpath = "//input[@type='time']")
    public List<WebElement> TimeInput;


    public CreateAppointmentPage ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage()
    {
        SessionTypeRadioButtons.get(1).click();

        return new CreateAppointmentPage(driver);
    }

}
