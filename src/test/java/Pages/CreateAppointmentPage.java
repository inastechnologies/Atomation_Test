package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAppointmentPage extends BasePage
{
    public CreateAppointmentPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(css = "div.title")
    public List<WebElement> LocationModalityFieldsText;

    @FindBy(css = "span.title")
    public List<WebElement> MandatoryFieldsText;

    @FindBy(xpath = "//select[@formcontrolname='pract_location']")
    public WebElement LocationInput;

    @FindBy(css = "i.tool-tip__icon")
    public List<WebElement> ToolTipIcons;

    @FindBy(css = "p.tool-tip__info")
    public List<WebElement> ToolTipInfo;

    @FindBy(xpath = "//input[@formcontrolname='type']")
    public List<WebElement> SessionTypeRadioButtons;

    @FindBy(name = "from_date")
    public WebElement FromDateField;

    @FindBy(name = "to_date")
    public WebElement ToDateField;

    @FindBy(id = "swal2-title")
    public WebElement SwalTitle;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CancelButton;

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

    @FindBy(xpath = "//input[@type='date']")
    public WebElement DateInput;

    @FindBy(xpath = "//select[@formcontrolname='select_day']")
    public WebElement SelectDayInput;

    @FindBy(xpath = "//div[text()=' Opening Hours : ']")
    public WebElement OpeningHoursText;

    @FindBy(css = "span.slot")
    public List<WebElement> OpeningHoursSlots;

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
    public WebElement AddButton;

    @FindBy(xpath = "//div[text()='Above field is required']")
    public WebElement DateErrorMessage;

    @FindBy(css = "div.text-error")
    public List<WebElement> ErrorMessages;


    public void SelectLocationAndModalityInCreateAppointmentPage(String Location, String Modality) {

        Utils.WaitForAnElementToExist(driver, LocationInput);
        Utils.SelectFromDropDownUsingVisibleText(LocationInput, Location);
        Utils.SelectFromDropDownUsingVisibleText(ModalityInput, Modality);
    }

    public void SelectDayAndOpeningHoursInCreateAppointmentPage(String Day, String FromTime, String ToTime) {

        Utils.WaitForAnElementToExist(driver, SelectDayInput);
        Utils.SelectFromDropDownUsingVisibleText(SelectDayInput, Day);

        TimeInput.get(0).sendKeys(FromTime);
        TimeInput.get(1).sendKeys(ToTime);
    }

    public void SelectRecurringWithDateRangeSessionTypeAndEnterFromDateAndToDate(String FromDate, String ToDate) {

        Utils.WaitForElementsToExist(driver, SessionTypeRadioButtons);
        SessionTypeRadioButtons.get(1).click();

        FromDateField.sendKeys(FromDate);
        ToDateField.sendKeys(ToDate);
    }

    public void SelectRecurringWithDateSpecificSessionTypeAndEnterDate(String Date, String FromTime, String ToTime) {

        Utils.WaitForElementsToExist(driver, SessionTypeRadioButtons);
        SessionTypeRadioButtons.get(2).click();

        DateInput.sendKeys(Date);
        TimeInput.get(0).sendKeys(FromTime);
        TimeInput.get(1).sendKeys(ToTime);
    }

}
