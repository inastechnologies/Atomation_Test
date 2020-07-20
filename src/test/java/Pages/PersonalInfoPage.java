package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PersonalInfoPage extends BasePage {
    public PersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(css = "div.upload-mrg")
    public WebElement UploadPictureText;

    @FindBy(css = "div.text-field-name.text-field-name-click")
    public WebElement DOBFieldText;

    @FindBy(xpath = "//input[@formcontrolname='dob']")
    public WebElement DOBInputField;

    @FindBy(css = "div.text-error")
    public WebElement DOBFieldError;

    @FindBy(xpath = "//input[@value='Next']")
    public WebElement PInfoNextButton;

    @FindBy(xpath = "//input[@value='Skip']")
    public WebElement SkipButton;

    @FindBy(id = "file")
    public WebElement BrowseButton;

    @FindBy(css = "input.form-check-input")
    public List<WebElement> GenderRadioButtons;


    public EducationalInfoPage EnterDateOfBirthUploadPictureAndClickNext(String text, WebElement element)
    {
        Utils.WaitForAnElementToExist(driver, element);
        element.sendKeys(text);
        BrowseButton.sendKeys("D:\\Doctor Pic.jpg");
        Utils.WaitForAnElementToExist(driver, PInfoNextButton);
        PInfoNextButton.click();
        return new EducationalInfoPage(driver);
    }

    public EducationalInfoPage ClickSkipAndNavigateToNextPage()
    {
        Utils.WaitForAnElementToExist(driver, SkipButton);
        SkipButton.click();
        return new EducationalInfoPage(driver);
    }

}