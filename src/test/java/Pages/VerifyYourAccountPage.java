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

    @FindBy(css = "div.title")
    public WebElement VerificationCodeText;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement PhoneEmailInputField;

    @FindBy(css = "button.verification-btn")
    public WebElement GetVerificationCodeButton;

    @FindBy(css = "input.grid-ite")
    public List<WebElement> OTPInputField;

    @FindBy(xpath = "//button[text()='Verify']")
    public WebElement SubmitButton;


    public void EnterPhoneEmailAndClickGetVerificationCode()
    {
        Utils.WaitForAnElementToExist(driver, PhoneEmailInputField);
        PhoneEmailInputField.sendKeys("9000000001");
        GetVerificationCodeButton.click();
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

    public ResetPasswordPage EnterOTPAndClickSubmitForResetPassword()
    {
        Utils.WaitForElementsToExist(driver, OTPInputField);
        OTPInputField.get(0).sendKeys("1");
        OTPInputField.get(1).sendKeys("2");
        OTPInputField.get(2).sendKeys("3");
        OTPInputField.get(3).sendKeys("4");
        Utils.WaitForAnElementToExist(driver, SubmitButton);
        SubmitButton.click();
        return new ResetPasswordPage(driver);
    }
}
