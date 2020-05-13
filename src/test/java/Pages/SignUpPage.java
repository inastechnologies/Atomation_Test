package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BasePage
{
    public SignUpPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//div[text()=' LOGIN ']")
    public WebElement LoginButton;

    @FindBy(css = "div.text-signUp")
    public WebElement SignUpText;

    @FindBy(xpath = "//div[text()=' First Name ']")
    public WebElement FirstNameFieldText;

    @FindBy(xpath = "//div[text()=' Last Name ']")
    public WebElement LastNameFieldText;

    @FindBy(xpath = "//div[text()=' Mobile No ']")
    public WebElement MobileNumberFieldText;

    @FindBy(xpath = "//div[text()= ' Email Id ']")
    public WebElement EmailFieldText;

    @FindBy(xpath = "//div[text()=' Location ']")
    public WebElement LocationFieldText;

    @FindBy(xpath = "//div[text()=' Password ']")
    public WebElement PasswordFieldText;

    @FindBy(xpath = "//div[text()=' Confirm Password ']")
    public WebElement ConfirmPasswordFieldText;

    @FindBy(xpath = "//label[text()='Practitioner']")
    public WebElement PractitionerText;

    @FindBy(xpath = "//label[text()='Clinic / Organizer / Enterprise']")
    public WebElement ClinicOrganizerEnterpriseText;

    @FindBy(xpath = "//label[text()='Customer']")
    public WebElement CustomerText;

    @FindBy(xpath = "//label[text()='Health Store Owner']")
    public WebElement HealthStoreOwnerText;

    @FindBy(xpath = "//label[text()='Institution / College']")
    public WebElement InstitutionCollageText;

    @FindBy(xpath = "//label[text()='Event Organizer']")
    public WebElement EventOrganizerText;

    @FindBy(xpath = "//div[@class='text-field-name']")
    public List<WebElement> InputFields ;

    @FindBy(xpath = "//input[@formcontrolname='first_name']")
    public WebElement FirstNameInputBox;

    @FindBy(xpath = "//input[@formcontrolname='last_name']")
    public WebElement LastNameInputBox;

    @FindBy(xpath = "//input[@formcontrolname='mobile_number']")
    public WebElement MobileNumberInputBox;

    @FindBy(xpath = "//input[@formcontrolname='email_id']")
    public WebElement EmailInputBox;

    @FindBy(xpath = "//input[@formcontrolname='dob']")
    public WebElement DOBInputBox;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement PasswordInputBox;

    @FindBy(xpath = "//input[@formcontrolname='confirm_password']")
    public WebElement ConfirmPasswordInputBox;

    @FindBy(xpath = "//input[@formcontrolname='location']")
    public WebElement LocationInputBox;

    @FindBy(xpath = "//input[@value='Practitioner']")
    public WebElement PractitionerRadioButton;

    @FindBy(xpath = "//input[@value='Clinic / Organizer / Enterprise']")
    public WebElement ClinicRadioButton;

    @FindBy(xpath = "//input[@value='Customer']")
    public WebElement CustomerRadioButton;

    @FindBy(xpath = "//input[@value='Event Organizer']")
    public WebElement EventOrganizerRadioButton;

    @FindBy(xpath = "//input[@value='Health Store Owner']")
    public WebElement HealthStoreOwnerRadioButton;

    @FindBy(xpath = "//input[@value='Institution / College']")
    public WebElement InstitutionRadioButton;

    @FindBy(xpath = "//input[@value='SIGN UP']")
    public WebElement SignUpButton;

    @FindBy(xpath = "//input[@formcontrolname='acceptTerms']")
    public WebElement AcceptTermsCheckBox;

    @FindBy(css = "div.text-error")
    public List<WebElement> FirstNameErrorMessage;

    @FindBy(xpath = "//label[text()='Name is required']")
    public WebElement ValidNameErrorMessage;

    @FindBy(xpath = "//div[text()='Special characters are not acceptable']")
    public WebElement LastNameErrorMessage1;

    @FindBy(xpath = "//div[text()='Numbers are not acceptable']")
    public WebElement LastNameErrorMessage2;

    @FindBy(xpath = "//div[text()='Mobile Number is required']")
    public WebElement MobileErrorMessage;

    @FindBy(xpath = "//div[text()='Mobile Number should be 10 digits']")
    public WebElement validMobileErrorMessage;

    @FindBy(xpath = "//div[text()='Email is required']")
    public WebElement EmailErrorMessage;

    @FindBy(xpath = "//div[text()='Email must be a valid email address']")
    public WebElement ValidEmailErrorMessage;

    @FindBy(xpath = "//div[text()='Password is required']")
    public WebElement PasswordErrorMessage;

    @FindBy(xpath = "//div[text()='Password length must be atleast 8 letters']")
    public WebElement InvalidPasswordLengthError;

    @FindBy(xpath = "//div[text()='It should contain one Number']")
    public WebElement InvalidPasswordOneNumberError;

    @FindBy(xpath = "//div[text()='It should contain only one SpecialChar']")
    public WebElement InvalidPasswordOneSplCharError;

    @FindBy(xpath = "//div[text()='Password should not start with Special Character']")
    public WebElement PasswordStartingWithSplCharError;

    @FindBy(xpath = "//div[text()='It should contain one UpperCase']")
    public WebElement InvalidPasswordUpperCaseError;

    @FindBy(xpath = "//div[text()='It should contain one LowerCase']")
    public WebElement InvalidPasswordLowerCaseError;

    @FindBy(xpath = "//div[text()='Confirm Password is required']")
    public WebElement ConfirmPasswordErrorMessage;

    @FindBy(css = "i.fa.fa-eye-slash")
    public List<WebElement> PasswordEye;

    @FindBy(xpath = "//div[text()='Passwords must match']")
    public WebElement ValidConfirmPasswordErrorMessage;

    @FindBy(xpath = "//div[text()='Location is required']")
    public WebElement LocationErrorMessage;

    @FindBy(xpath = "//div[text()='Location must be in Alphabets']")
    public WebElement InvalidLocationErrorMessage;

    @FindBy(xpath = "//div[text()='Please agree']")
    public WebElement TermsAndConditionsErrorMessage;

    //public By NamesErrorMessage = By.xpath("//label[text()='Name is required']");

    public void EnterDataIntoAfield(String Text, WebElement element)
    {
        Utils.WaitForAnElementToExist(driver, element);
        element.sendKeys(Text);
    }

    public SubscriptionPage EnterDataIntoAllTheFieldsInSignUpPage(String FirstName, String LastName, String Email, String MobileNumber, String Location, String Password, String ConfirmPassword)
    {
        EnterDataIntoAfield(FirstName, FirstNameInputBox);
        EnterDataIntoAfield(LastName, LastNameInputBox);
        EnterDataIntoAfield(Email, EmailInputBox);
        EnterDataIntoAfield(MobileNumber, MobileNumberInputBox);
        EnterDataIntoAfield(Location, LocationInputBox);
        EnterDataIntoAfield(Password, PasswordInputBox);
        EnterDataIntoAfield(ConfirmPassword, ConfirmPasswordInputBox);
        return new SubscriptionPage(driver);
    }

    public SubscriptionPage ClickPractitionerCategoryClickTermsAndConditionsAndSignUp()
    {
        Utils.WaitForAnElementToExist(driver, PractitionerRadioButton);
        PractitionerRadioButton.click();
        Utils.WaitForAnElementToExist(driver, AcceptTermsCheckBox);
        AcceptTermsCheckBox.click();
        Utils.WaitForAnElementToExist(driver, SignUpButton);
        SignUpButton.click();
        return new SubscriptionPage(driver);
    }

    public void ClickSignUpButtonWithEmptyFields()
    {
        Utils.WaitForAnElementToExist(driver, SignUpButton);
        SignUpButton.click();
    }

    public void ClearDataFromField(WebElement element)
    {
        Utils.WaitForAnElementToExist(driver, element);
        element.clear();
    }

    public void CLickEveryFieldBeforeEnteringTheData()
    {
        Utils.WaitForAnElementToExist(driver, FirstNameInputBox);
        FirstNameInputBox.click();
        LastNameInputBox.click();
        EmailInputBox.click();
        MobileNumberInputBox.click();
        LocationInputBox.click();
        PasswordInputBox.click();
        ConfirmPasswordInputBox.click();
    }
}