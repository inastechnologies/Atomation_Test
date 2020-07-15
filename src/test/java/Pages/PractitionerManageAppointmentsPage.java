package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PractitionerManageAppointmentsPage extends BasePage
{
    public PractitionerManageAppointmentsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[text()='MANAGE APPOINTMENTS']")
    public WebElement ManageAppointments;

    @FindBy(css = "button.q-button.set-button")
    public WebElement SetAvailability;

    @FindBy(xpath = "//button[text()=' VIEW APPOINTMENTS ']")
    public WebElement ViewAppointments;

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

    @FindBy(css = "button.time.add-button")
    public List<WebElement> AddButtons;

    @FindBy(xpath = "//button[text()=' SUBMIT ']")
    public WebElement SubmitButton;

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(css = "img.image-size-user")
    public WebElement ProfileIcon;

    @FindBy(css = "div.options-pop")
    public WebElement LogoutButton;

    public LoginPage ClickLogoutToGoOutOfThePage()
    {
        Utils.WaitForAnElementToExist(driver, ProfileIcon);
        ProfileIcon.click();
        Utils.WaitForAnElementToExist(driver, LogoutButton);
        LogoutButton.click();

        return new LoginPage(driver);
    }

    public void ClickOnDateToCheckTheAppointments(String Date) throws InterruptedException
    {
        Utils.WaitForAnElementToExist(driver, ManageAppointments);
        ManageAppointments.click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='" + Date + "']")).click();
    }

    public void ClickAppointmentsAndEnterDataInSetAvailabilityPage(String Location, String Modality, String ConsultationType, String NoOfDays, String Day, String ToTime, String FromTime, String Name, String NoOfMIns, String Fee, String SessionsIncludeUpto)
    {
        Utils.WaitForAnElementToExist(driver, ManageAppointments);
        ManageAppointments.click();
        SetAvailability.click();

        Utils.WaitForAnElementToExist(driver, LocationInput);
        Utils.SelectFromDropDownUsingVisibleText(LocationInput, Location);
        Utils.SelectFromDropDownUsingVisibleText(ModalityInput, Modality);
        Utils.SelectFromDropDownUsingVisibleText(ConsultationTypeInput, ConsultationType);
        Utils.SelectFromDropDownUsingVisibleText(NOOfBookingDaysInput, NoOfDays);
        Utils.SelectFromDropDownUsingVisibleText(SelectDayInput, Day);

        TimeInput.get(0).sendKeys(FromTime);
        TimeInput.get(1).sendKeys(ToTime);

        AddButtons.get(0).click();

        NameInput.sendKeys(Name);
        NoOfMinsInput.sendKeys(NoOfMIns);
        FeesInput.sendKeys(Fee);
        SessionCanIncludeUpToInput.sendKeys(SessionsIncludeUpto);

        AddButtons.get(1).click();

        SubmitButton.click();
    }

    public void EnterFromTimeAndToTimeToAddSlots(String FromTime, String ToTime)
    {
        TimeInput.get(0).sendKeys(FromTime);
        TimeInput.get(1).sendKeys(ToTime);
    }

}

