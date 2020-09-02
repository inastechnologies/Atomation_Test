package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccessManagementAndPrivilegesPage extends BasePage
{
    public AccessManagementAndPrivilegesPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.title")
    public WebElement AdminPanelText;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement UserNameInputField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement PasswordInputField;

    @FindBy(css = "button.button")
    public WebElement LoginButton;

    @FindBy(xpath = "//span[text()=' Access Management & Privileges ']")
    public WebElement AccessManagementTab;

    @FindBy(xpath = "//span[text()='Access Management & Privileges']")
    public WebElement AccessManagementAndPrivilegesText;

    @FindBy(xpath = "//img[@src='assets/images/q_1.png']")
    public WebElement QNatureLogo;

    @FindBy(css = "img.image-size-round")
    public List<WebElement> HeaderIcons;

    @FindBy(xpath = "//th[@role='columnheader']")
    public List<WebElement> ColumnHeader;

    @FindBy(css = "div.total")
    public WebElement TotalRows;

    @FindBy(css = "div.mat-paginator-range-label")
    public WebElement RowsRange;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement SearchInput;

    @FindBy(css = "div.add-button")
    public WebElement AddButton;

    @FindBy(css = "span.title")
    public WebElement AddSubAdminText;

    @FindBy(css = "td.mat-cell.cdk-cell.cdk-column-person_name.mat-column-person_name")
    public List<WebElement> SubAdminList;

    @FindBy(css = "ul.custom-bread-crumb")
    public WebElement SubAdminProfileText;

    @FindBy(xpath = "//input[@type='file']")
    public List<WebElement> ChooseFile;

    @FindBy(xpath = "//img[@src='assets/images/profile.png']")
    public WebElement SubAdminProfilePic;

    @FindBy(css = "div.title")
    public WebElement SubAdminTitleText;

    @FindBy(css = "p.sub-title")
    public WebElement SubAdminSubTitleText;

    @FindBy(css = "button.button-1.ng-star-inserted")
    public WebElement SubAdminActiveInactiveText;

    @FindBy(xpath = "//input[@formcontrolname='person_name']")
    public WebElement SubAdminNameInput;

    @FindBy(xpath = "//input[@formcontrolname='roll_name']")
    public WebElement RollNameInput;

    @FindBy(xpath = "//input[@formcontrolname='no_of_rolls']")
    public WebElement NoOfRollsInput;

    @FindBy(xpath = "//mat-select[@formcontrolname='status']")
    public WebElement StatusInput;

    @FindBy(css = "span.mat-option-text")
    public List<WebElement> StatusOptions;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement CreateUpdateButton;

    @FindBy(xpath = "//mat-error[text()=' Person Name Required field. ']")
    public WebElement SubAdminNameError;

    @FindBy(xpath = "//mat-error[text()=' Required RollName. ']")
    public WebElement RollNameError;

    @FindBy(xpath = "//mat-error[text()=' No_Of_Rolls Required ']")
    public WebElement NoOfRollError;

    @FindBy(xpath = "//mat-error[text()=' Required status. ']")
    public WebElement StatusError;

    @FindBy(css = "div.mat-tab-label-content")
    public List<WebElement> SubAdminProfileTabs;

    @FindBy(css = "div.heading")
    public List<WebElement> SubAdminTabsHeadings;

    @FindBy(xpath = "//mat-icon[@mattooltip='View']")
    public List<WebElement> ViewIcon;

    @FindBy(xpath = "//mat-icon[@mattooltip='Edit']")
    public List<WebElement> EditIcons;

    @FindBy(xpath = "//img[@mattooltip='Edit']")
    public List<WebElement> SubAdminEditIcon;

    @FindBy(xpath = "//mat-icon[@mattooltip='Delete']")
    public List<WebElement> DeleteIcon;

    @FindBy(css = "p.title")
    public WebElement DeletePopup;

    @FindBy(css = "button.button")
    public List<WebElement> DeletePopupButtons;

    @FindBy(css = "div.mat-checkbox-inner-container.mat-checkbox-inner-container-no-side-margin")
    public List<WebElement> CheckBoxes;

    @FindBy(css = "span.multselecteddelete.ng-star-inserted")
    public WebElement RowSelected;

    @FindBy(css = "button.mat-focus-indicator.mat-paginator-navigation-next.mat-icon-button.mat-button-base")
    public WebElement NextPageIcon;

    @FindBy(css = "button.mat-focus-indicator.mat-paginator-navigation-previous.mat-icon-button.mat-button-base")
    public WebElement PreviousPageIcon;

    @FindBy(css = "mat-icon.mat-icon.notranslate.multselecteddeleteicon.material-icons.mat-icon-no-color")
    public WebElement RowSelectedDelete;

    @FindBy(css = "span.closeicon")
    public WebElement CloseIcon;

    @FindBy(xpath = "//input[@formcontrolname='first_name']")
    public WebElement SubAdminFirstName;

    @FindBy(xpath = "//input[@formcontrolname='middle_name']")
    public WebElement SubAdminMiddleName;

    @FindBy(xpath = "//input[@formcontrolname='last_name']")
    public WebElement SubAdminLastName;

    @FindBy(xpath = "//input[@formcontrolname='date_of_birth']")
    public WebElement SubAdminDOB;

    @FindBy(xpath = "//input[@formcontrolname='email_id']")
    public WebElement SubAdminEmail;

    @FindBy(xpath = "//input[@formcontrolname='mobile_number']")
    public WebElement SubAdminMobile;

    @FindBy(xpath = "//input[@formcontrolname='blood_group']")
    public WebElement SubAdminBloodGroup;

    @FindBy(xpath = "//mat-select[@formcontrolname='gender']")
    public WebElement SubAdminGender;

    @FindBy(css = "span.mat-option-text")
    public List<WebElement> SubAdminGenderOptions;

    @FindBy(xpath = "//input[@formcontrolname='short_biography']")
    public WebElement SubAdminBiography;

    @FindBy(xpath = "//input[@formcontrolname='address_line']")
    public WebElement SubAdminAddress;

    @FindBy(xpath = "//input[@formcontrolname='city']")
    public WebElement SubAdminCity;

    @FindBy(xpath = "//input[@formcontrolname='pincode']")
    public WebElement SubAdminPicCode;

    @FindBy(xpath = "//input[@formcontrolname='state']")
    public WebElement SubAdminState;

    @FindBy(xpath = "//input[@formcontrolname='country']")
    public WebElement SubAdminCountry;

    @FindBy(xpath = "//span[text()=' Update ']")
    public WebElement UpdateButton;

    @FindBy(css = "label.label")
    public List<WebElement> BasicInformationFields;

    @FindBy(xpath = "//mat-error[@role='alert']")
    public List<WebElement> SubAdminErrorMessages;

    @FindBy(css = "svg.mat-datepicker-toggle-default-icon.ng-star-inserted")
    public WebElement SubAdminDOBPicker;

    @FindBy(css = "button.mat-focus-indicator.mat-calendar-period-button.mat-button.mat-button-base")
    public WebElement CalenderHeading;

    @FindBy(css = "button.mat-focus-indicator.mat-calendar-next-button.mat-icon-button.mat-button-base")
    public WebElement CalenderRightArrow;

    @FindBy(css = "button.mat-focus-indicator.mat-calendar-previous-button.mat-icon-button.mat-button-base")
    public WebElement CalenderLeftArrow;

    @FindBy(css = "div.mat-calendar-body-cell-content")
    public List<WebElement> CalenderListOfYearsAndMonths;

    @FindBy(css = "div.mat-select-arrow-wrapper.ng-tns-c218-25")
    public WebElement GenderDropDown;

    @FindBy(xpath = "//input[@formcontrolname='company_email']")
    public WebElement CompanyEmailField;

    @FindBy(xpath = "//input[@formcontrolname='date_of_joining']")
    public WebElement DOJField;

    @FindBy(xpath = "//input[@formcontrolname='department']")
    public WebElement DepartmentField;

    @FindBy(xpath = "//input[@formcontrolname='roll']")
    public WebElement RollField;

    @FindBy(css = "button.button")
    public List<WebElement> EduAndExpAdd;

    @FindBy(css = "span.title")
    public WebElement PopUpHeadingText;

    @FindBy(xpath = "//img[@mattooltip='Upload']")
    public WebElement AddDocumentsButton;

    @FindBy(xpath = "//button[@type='submit']")
    public List<WebElement> DocumentsUploadAndCancel;

    @FindBy(css = "div.sub-2-label")
    public WebElement DocumentFileName;

    @FindBy(css = "div.heading")
    public WebElement DocumentsText;

    @FindBy(css = "div.content")
    public List<WebElement> FieldsContent;



    public void EnterUserNamePassword(String UserName, String Password) {
        UserNameInputField.sendKeys(UserName);
        PasswordInputField.sendKeys(Password);
        LoginButton.click();
    }

    public void ClickEveryFieldInSubAdminScreenBeforeEnteringDetails() {
        SubAdminNameInput.click();
        RollNameInput.click();
        NoOfRollsInput.click();
        StatusInput.click();
    }

    public void FillAllTheFieldsInAddSubAdminScreenAndClickCreate(String SudAdminName, String RollName, String NoOfRolls) {
        SubAdminNameInput.sendKeys(SudAdminName);
        RollNameInput.sendKeys(RollName);
        NoOfRollsInput.sendKeys(NoOfRolls);
        StatusInput.click();
        StatusOptions.get(0).click();
        CreateUpdateButton.click();
    }

    public void ClickOnDateToCheckTheAppointments(String Name, String RollName) throws InterruptedException {

        driver.findElement(By.xpath("//span[text()='" + Name + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + Name + "']")).click();
    }

    public void FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen(String FirstName, String MiddleName, String LastName, String Dob, String Email, String Mobile, String BloodGroup, String Biography, String Address, String City, String PinCode, String State, String Country) {
        Utils.WaitForAnElementToExist(driver, SubAdminFirstName);
        SubAdminFirstName.sendKeys(FirstName);
        SubAdminMiddleName.sendKeys(MiddleName);
        SubAdminLastName.sendKeys(LastName);
        SubAdminDOB.sendKeys(Dob);
        SubAdminEmail.sendKeys(Email);
        SubAdminMobile.sendKeys(Mobile);
        SubAdminBloodGroup.sendKeys(BloodGroup);
        SubAdminGender.click();
        SubAdminGenderOptions.get(0).click();
        SubAdminBiography.sendKeys(Biography);
        SubAdminAddress.sendKeys(Address);
        SubAdminCity.sendKeys(City);
        SubAdminPicCode.sendKeys(PinCode);
        SubAdminState.sendKeys(State);
        SubAdminCountry.sendKeys(Country);
        //UpdateButton.click();
    }

    public void FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen(String CompanyEmail, String DOJ, String Department, String Roll) {
        Utils.WaitForAnElementToExist(driver, CompanyEmailField);
        CompanyEmailField.sendKeys(CompanyEmail);
        DOJField.sendKeys(DOJ);
        DepartmentField.sendKeys(Department);
        RollField.sendKeys(Roll);
    }
}