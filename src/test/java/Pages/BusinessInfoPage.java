package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusinessInfoPage extends BasePage
{

    public BusinessInfoPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(xpath = "//div[text()='Business Information']")
    public WebElement BusinessInfoText;

    @FindBy(xpath = "//div[text()=' Clinic/Institute/Organization Name (Opt) : ']")
    public WebElement ClinicInstituteOrganizationName;

    @FindBy(xpath = "//div[text()=' Australian Business Number(ABN) : ']")
    public WebElement AustralianBusinessNo;

    @FindBy(xpath = "//div[text()=' Address ']")
    public WebElement Address;

    @FindBy(xpath = "//div[text()=' Address2 : ']")
    public WebElement Address2;

    @FindBy(xpath = "//div[text()=' City / Suburb / Town ']")
    public WebElement CitySuburbTown;

    @FindBy(xpath = "//div[text()=' Area Code ']")
    public WebElement AreaCode;

    @FindBy(xpath = "//div[text()=' State / Province ']")
    public WebElement StateProvince;

    @FindBy(xpath = "//div[text()=' Country ']")
    public WebElement Country;

    @FindBy(xpath = "//input[@formcontrolname='clinicname']")
    public WebElement ClinicInputBox;

    @FindBy(xpath = "//div[text()='Special characters are not acceptable']")
    public WebElement ClinicErrorMessage;

    @FindBy(xpath = "//input[@formcontrolname='abn']")
    public WebElement AUSBusinessNoInputBox;

    @FindBy(xpath = "//div[text()='Australian Business Number(ABN) should be 11 digits']")
    public WebElement ABNErrorMessage;

    @FindBy(xpath = "//input[@formcontrolname='address1']")
    public WebElement AddressInputBox;

    @FindBy(xpath = "//label[text()='Address1 is required']")
    public WebElement Address1ErrorMessage;

    @FindBy(xpath = "//input[@formcontrolname='address2']")
    public WebElement Address2InputBox;

    @FindBy(xpath = "//input[@formcontrolname='city']")
    public WebElement CityInputBox;

    @FindBy(xpath = "//label[text()='City is required']")
    public WebElement CityErrorMessage;

    @FindBy(xpath = "//input[@formcontrolname='areaCode']")
    public WebElement AreaCodeInputBox;

    @FindBy(xpath = "//div[text()='Area Code should be 4 digits']")
    public WebElement AreaCodeErrorMessage;

    @FindBy(xpath = "//input[@formcontrolname='state']")
    public WebElement StateInputBox;

    @FindBy(xpath = "//label[text()='State is required']")
    public WebElement StateErrorMessage;

    @FindBy(xpath = "//input[@formcontrolname='country']")
    public WebElement CountryInputBox;

    @FindBy(xpath = "//label[text()='Country is required']")
    public WebElement CountryErrorMessage;

    @FindBy(xpath = "//input[@value='Next']")
    public WebElement NextButton;

    @FindBy(xpath = "//input[@value='Skip']")
    public WebElement SkipButton;

    @FindBy(css = "div.text-error")
    public List<WebElement> ErrorMessages;

    public void EnterDataIntoAfield(String Text, WebElement element)
    {
        Utils.WaitForAnElementToExist(driver, element);
        element.sendKeys(Text);
    }

    public PersonalInfoPage EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext(String Clinic, String AUsBusinessNo, String Address1, String Country, String City, String AreaCode, String State)
    {
        EnterDataIntoAfield(Clinic, ClinicInputBox);
        EnterDataIntoAfield(AUsBusinessNo, AUSBusinessNoInputBox);
        EnterDataIntoAfield(Address1, AddressInputBox);
        EnterDataIntoAfield(Country, CountryInputBox);
        EnterDataIntoAfield(City, CityInputBox);
        EnterDataIntoAfield(AreaCode, AreaCodeInputBox);
        EnterDataIntoAfield(State, StateInputBox);
        NextButton.click();
        return new PersonalInfoPage(driver);
    }
    public PersonalInfoPage CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage()
    {
        Utils.WaitForAnElementToExist(driver, ClinicInputBox);
        ClinicInputBox.click();
        AUSBusinessNoInputBox.click();
        AddressInputBox.click();
        CountryInputBox.click();
        CityInputBox.click();
        AreaCodeInputBox.click();
        StateInputBox.click();
        return new PersonalInfoPage(driver);
    }

    public PersonalInfoPage ClickSkipAndNavigateToNextPage()
    {
        Utils.WaitForAnElementToExist(driver, SkipButton);
        SkipButton.click();
        return new PersonalInfoPage(driver);
    }

}


