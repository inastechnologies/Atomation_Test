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

    @FindBy(css = "div.upload-mrg")
    public WebElement UploadPictureText;

    @FindBy(css = "div.text-field-name.text-field-name-click")
    public WebElement DOBFieldText;

    @FindBy(xpath = "//input[@formcontrolname='dob']")
    public WebElement DOBInputField;

    @FindBy(css = "div.text-error")
    public WebElement DOBFieldError;

    @FindBy(css = "div.txt-align-center.next-btn-mrgn")
    public WebElement PInfoNextButton;

    @FindBy(id = "file")
    public WebElement BrowseButton;

    @FindBy(css = "input.form-check-input")
    public List<WebElement> GenderRadioButtons;


    public EducationalInfoPage EnterDateOfBirthUploadPictureAndClickNext(String text, WebElement element)
    {
        Utils.WaitForAnElementToExist(driver, element);
        element.sendKeys(text);
        BrowseButton.sendKeys("D:\\Flower.jpg");
        Utils.WaitForAnElementToExist(driver, PInfoNextButton);
        PInfoNextButton.click();
        return new EducationalInfoPage(driver);
    }
}