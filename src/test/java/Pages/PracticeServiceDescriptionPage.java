package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PracticeServiceDescriptionPage extends BasePage
{
    public PracticeServiceDescriptionPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(css = "div.text-style")
    public WebElement HeadingText;

    @FindBy(xpath = "//select[@formcontrolname='service_type']")
    public WebElement ServiceTypeInput;

    @FindBy(xpath = "//span[text()='Describe yourself '] ")
    public WebElement DescribeUrSelfText;

    @FindBy(xpath = "//span[text()='Describe about practice '] ")
    public WebElement DescribePracticeText;

    @FindBy(xpath = "//span[text()='Describe areas of special Interests & Services '] ")
    public WebElement DescribeSplInterestsText;

    @FindBy(xpath = "//span[text()='Describe Your Qualifications & Registrations '] ")
    public WebElement DescribeQualificationsRegistrationsText;

    @FindBy(xpath = "//span[text()='Upload Logo & Images :'] ")
    public WebElement UploadLogoText;

    @FindBy(xpath = "//span[text()='Additional Information :'] ")
    public WebElement AdditionalInfoText;

    @FindBy(xpath = "//textarea[@formcontrolname='describe_about_yourself']")
    public WebElement DescribeYourselfInputField;

    @FindBy(xpath = "//textarea[@formcontrolname='describe_about_practice']")
    public WebElement DescribePracticeInputField;

    @FindBy(xpath = "//textarea[@formcontrolname='about_your_area_of_special_interest_and_services']")
    public WebElement DescribeInterestsInputField;

    @FindBy(xpath = "//textarea[@formcontrolname='describe_your_qualifications_and_registrations']")
    public WebElement DescribeQualificationAndRegistrationInputField;

    @FindBy(xpath = "//textarea[@formcontrolname='info']")
    public WebElement AdditionalInfoInputField;

    @FindBy(id = "cfile")
    public WebElement ChooseFile;

    @FindBy(css = "button.next-btn.additional-add")
    public WebElement AddButton;

    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//input[@value='Skip']")
    public WebElement SkipButton;

    @FindBy(css = "div.info-boxes")
    public List<WebElement> Breadcrumbs;

    @FindBy(css = "div.text-error")
    public List<WebElement> ErrorMessages;



    public VerifyYourAccountPage EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext(String VisibleText, String DescribeYourself, String DescribePractice, String DescribeInterests, String Qualification, String AdditionalInfo )
    {
       Utils.WaitForAnElementToExist(driver, ServiceTypeInput);
       Utils.SelectFromDropDownUsingVisibleText(ServiceTypeInput, VisibleText);
       DescribeYourselfInputField.sendKeys(DescribeYourself);
       DescribePracticeInputField.sendKeys(DescribePractice);
       DescribeInterestsInputField.sendKeys(DescribeInterests);
       DescribeQualificationAndRegistrationInputField.sendKeys(Qualification);
       //Utils.WaitForAnElementToExist(driver, ChooseFile);
       ChooseFile.sendKeys("D:\\Flower.jpg");
       AddButton.click();
       AdditionalInfoInputField.sendKeys(AdditionalInfo);
       Utils.WaitForAnElementToExist(driver, SubmitButton);
       SubmitButton.click();
       return new VerifyYourAccountPage(driver);
    }

    public void CLickEveryFieldInPracticeServiceInfoPage()
    {
        Utils.WaitForAnElementToExist(driver, ServiceTypeInput);
        ServiceTypeInput.click();
        DescribeYourselfInputField.click();
        DescribePracticeInputField.click();
        DescribeInterestsInputField.click();
        DescribeQualificationAndRegistrationInputField.click();
    }

    public VerifyYourAccountPage ClickSkipAndNavigateToNextPage()
    {
        Utils.WaitForAnElementToExist(driver, SkipButton);
        SkipButton.click();
        return new VerifyYourAccountPage(driver);
    }
}
