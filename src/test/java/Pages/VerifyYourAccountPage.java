package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VerifyYourAccountPage extends BasePage
{
    public VerifyYourAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(css = "div.text-forgot.text-center")
    public WebElement VerifyYourAccountText;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement PhoneEmailInputField;

    @FindBy(css = "div.text-field-name-click")
    public WebElement PhoneEmailFieldText;

    @FindBy(css = "button.verification-btn")
    public WebElement GetVerificationCodeButton;

    @FindBy(css = "div.text-error")
    public WebElement PhoneEmailError;

    public VerificationCodePage EnterPhoneOrEmailAndClickGetVerificationCode(String PhoneEmail)
    {
        Utils.WaitForAnElementToExist(driver, PhoneEmailInputField);
        PhoneEmailInputField.sendKeys(PhoneEmail);
        GetVerificationCodeButton.click();
        return new VerificationCodePage(driver);
    }
}
