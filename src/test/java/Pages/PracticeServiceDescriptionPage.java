package Pages;

import Utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//div[text()='Practice / Service Description']")
    public WebElement ServicePageTab;

    @FindBy(css = "div.mat-select-arrow")
    public WebElement ServiceTypeArrow;

    @FindBy(xpath = "div.mat-ripple.mat-option-ripple")
    public WebElement ServiceTypeList;

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

    @FindBy(css = "div.angular-editor-textarea")
    public List<WebElement> TextInputField;

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

    public VerifyYourAccountPage EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext(String Modality, String DescribeYourself, String DescribePractice, String DescribeInterests, String Qualification, String AdditionalInfo )
    {
       Utils.WaitForAnElementToExist(driver, ServiceTypeArrow);
       ServiceTypeArrow.click();
       driver.findElement(By.xpath("//span[text()='" + Modality + "']")).click();

       TextInputField.get(0).sendKeys(DescribeYourself);
       TextInputField.get(1).sendKeys(DescribePractice);
       TextInputField.get(2).sendKeys(DescribeInterests);
       TextInputField.get(3).sendKeys(Qualification);
       //Utils.WaitForAnElementToExist(driver, ChooseFile);
       ChooseFile.sendKeys("D:\\Flower.jpg");

       JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("arguments[0].click()", AddButton);
       //AddButton.click();
       TextInputField.get(4).sendKeys(AdditionalInfo);

       JavascriptExecutor jse1 = (JavascriptExecutor)driver;
       jse1.executeScript("arguments[0].click()", SubmitButton);

       return new VerifyYourAccountPage(driver);
    }

    public void CLickEveryFieldInPracticeServiceInfoPage()
    {
        Utils.WaitForAnElementToExist(driver, ServiceTypeArrow);
        ServiceTypeArrow.click();
        TextInputField.get(0).click();
        TextInputField.get(1).click();
        TextInputField.get(2).click();
        TextInputField.get(3).click();
    }

    public VerifyYourAccountPage ClickSkipAndNavigateToNextPage()
    {
        Utils.WaitForAnElementToExist(driver, SkipButton);
        SkipButton.click();
        return new VerifyYourAccountPage(driver);
    }

    public VerifyYourAccountPage EnterDataIntoAllTheFieldsAndUploadFiveFiles(String VisibleText, String DescribeYourself, String DescribePractice, String DescribeInterests, String Qualification, String AdditionalInfo )
    {
        Utils.WaitForAnElementToExist(driver, ServiceTypeArrow);
        Utils.SelectFromDropDownUsingVisibleText(ServiceTypeArrow, VisibleText);
        TextInputField.get(0).sendKeys(DescribeYourself);
        TextInputField.get(1).sendKeys(DescribePractice);
        TextInputField.get(2).sendKeys(DescribeInterests);
        TextInputField.get(3).sendKeys(Qualification);
        //Utils.WaitForAnElementToExist(driver, ChooseFile);
        ChooseFile.sendKeys("D:\\Flower.jpg");
        ChooseFile.sendKeys("D:\\Flower.jpg");
        ChooseFile.sendKeys("D:\\Flower.jpg");

        ChooseFile.sendKeys("D:\\Flower.jpg");
        ChooseFile.sendKeys("D:\\Flower.jpg");
        AddButton.click();
        TextInputField.get(4).sendKeys(AdditionalInfo);
        Utils.WaitForAnElementToExist(driver, SubmitButton);
        SubmitButton.click();
        return new VerifyYourAccountPage(driver);
    }
    }

