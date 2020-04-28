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

    @FindBy(xpath = "//span[text()='Describe yourself '] ")
    public WebElement DescribeUrSelfText;

    @FindBy(xpath = "//span[text()='Describe about practice '] ")
    public WebElement DescribePracticeText;

    @FindBy(xpath = "//span[text()='Describe areas of special Interests & Services '] ")
    public WebElement DescribeSplInterestsText;

    @FindBy(xpath = "//span[text()='Additional Information '] ")
    public WebElement AdditionalInfoText;

    @FindBy(xpath = "//textarea[@formcontrolname='describe_about_yourself']")
    public WebElement DescribeYourselfInputField;

    @FindBy(xpath = "//textarea[@formcontrolname='about_your_practice']")
    public WebElement DescribePracticeInputField;

    @FindBy(xpath = "//textarea[@formcontrolname='about_your_area_of_special_interest_and_services']")
    public WebElement DescribeInterestsInputField;

    @FindBy(xpath = "//textarea[@formcontrolname='practitioner_description']")
    public WebElement AdditionalInfoInputField;

    @FindBy(css = "input.signUp-btn.border-0")
    public WebElement SubmitButton;

    @FindBy(css = "div.info-boxes")
    public List<WebElement> Breadcrumbs;

    @FindBy(css = "div.text-error")
    public List<WebElement> ErrorMessages;



    public VerifyYourAccountPage EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext(String DescribeYourself, String DescribePractice, String DescribeInterests, String AdditionalInfo )
    {
       Utils.WaitForAnElementToExist(driver, DescribeYourselfInputField);
       DescribeYourselfInputField.sendKeys(DescribeYourself);
       DescribePracticeInputField.sendKeys(DescribePractice);
       DescribeInterestsInputField.sendKeys(DescribeInterests);
       AdditionalInfoInputField.sendKeys(AdditionalInfo);
       Utils.WaitForAnElementToExist(driver, SubmitButton);
       SubmitButton.click();
       return new VerifyYourAccountPage(driver);
    }

    public void CLickEveryFieldInPracticeServiceInfoPage()
    {
        Utils.WaitForAnElementToExist(driver, DescribeYourselfInputField);
        DescribeYourselfInputField.click();
        DescribeInterestsInputField.click();
        DescribePracticeInputField.click();
        AdditionalInfoInputField.click();
    }

}
