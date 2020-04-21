package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EducationalInfoPage extends BasePage
{
    public EducationalInfoPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Educational Information']")
    public WebElement EduInfoText;

    @FindBy(xpath = "//div[text()=' Education Details ']")
    public WebElement EduDetailsText;

    @FindBy(xpath = "//div[text()=' Association ']")
    public WebElement AssociationText;

    @FindBy(xpath = "//div[text()=' Registration Number ']")
    public WebElement RegNoText;

    @FindBy(xpath = "//div[text()=' Year Of Registration ']")
    public WebElement RegYearText;

    @FindBy(xpath = "//div[text()=' Registration Renewal Date ']")
    public WebElement RegRenewalText;

    @FindBy(xpath = "//div[text()='Upload Registration Documents :']")
    public WebElement UploadDocsText;

    @FindBy(xpath = "//input[@formcontrolname='educationDetails']")
    public WebElement EducationDetailsInputField;

    @FindBy(xpath = "//input[@formcontrolname='association']")
    public WebElement AssociationInputField;

    @FindBy(xpath = "//input[@formcontrolname='registrationNo']")
    public WebElement RegNoInputField;

    @FindBy(xpath = "//input[@formcontrolname='yearOfRegistration']")
    public WebElement RegYearInputField;

    @FindBy(xpath = "//input[@formcontrolname='registrationReneual']")
    public WebElement RegRenewalInputField;

    @FindBy(id = "file")
    public WebElement BrowseField;

    @FindBy(css = "input.next-btn.border-0")
    public WebElement EduIfoNextButton;

    @FindBy(css = "div.text-error")
    public List<WebElement> ErrorMessages;

    @FindBy(xpath = "//div[text()='Special characters are not acceptable']")
    public WebElement EducationalDetailsError;

    @FindBy(xpath = "//div[text()='Association Details is required']")
    public WebElement AssociationError;

    @FindBy(xpath = "//div[text()='Registration Number is required']")
    public WebElement RegistrationNoError;

    @FindBy(xpath = "//div[text()='Year Of Registration should be 4 digits']")
    public WebElement YearOfRegError;

    @FindBy(xpath = "//div[text()='Registration Renewal Date is required']")
    public WebElement RegistrationRenewalDateError;

    @FindBy(xpath = "//div[text()='Flower.jpg']")
    public WebElement DocDownloadFile;

    public void EnterDataIntoAfield(String Text, WebElement element)
    {
        Utils.WaitForAnElementToExist(driver, element);
        element.sendKeys(Text);
    }

    public PracticeServiceDescriptionPage EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext(String Education, String Association, String RegNo, String RegYear, String RegRenewalDate)
    {
        EnterDataIntoAfield(Education, EducationDetailsInputField);
        EnterDataIntoAfield(Association, AssociationInputField);
        EnterDataIntoAfield(RegNo, RegNoInputField);
        EnterDataIntoAfield(RegYear, RegYearInputField);
        EnterDataIntoAfield(RegRenewalDate, RegRenewalInputField);
        BrowseField.sendKeys("D:\\Flower.jpg");
        EduIfoNextButton.click();
        return new PracticeServiceDescriptionPage(driver);
    }

    public void CLickEveryFieldInEducationalInfoPage() {
        Utils.WaitForAnElementToExist(driver, EducationDetailsInputField);
        EducationDetailsInputField.click();
        AssociationInputField.click();
        RegNoInputField.click();
        RegYearInputField.click();
        RegRenewalInputField.click();
    }
}
