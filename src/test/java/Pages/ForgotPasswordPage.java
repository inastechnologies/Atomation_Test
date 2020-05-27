package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ForgotPasswordPage extends BasePage
{
    public ForgotPasswordPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(css = "div.text-forgot.text-center")
    public WebElement ForgetPasswordText;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement PhoneEmailInputField;

    @FindBy(css = "button.verification-btn")
    public WebElement GetVerificationCodeButton;

    @FindBy(css = "input.grid-ite")
    public List<WebElement> OTPInputField;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement SubmitButton;

    public VerificationCodePage EnterPhoneEmailAndClickGetVerificationCode()
    {
        Utils.WaitForAnElementToExist(driver, PhoneEmailInputField);
        PhoneEmailInputField.sendKeys("9000000001");
        GetVerificationCodeButton.click();
        return new VerificationCodePage(driver);
    }

    public AdminPanelPage EnterOTPAndClickSubmit()
    {
        Utils.WaitForElementsToExist(driver, OTPInputField);
        OTPInputField.get(0).sendKeys("1");
        OTPInputField.get(1).sendKeys("2");
        OTPInputField.get(2).sendKeys("3");
        OTPInputField.get(3).sendKeys("4");
        Utils.WaitForAnElementToExist(driver, SubmitButton);
        SubmitButton.click();
        return new AdminPanelPage(driver);
    }
}
