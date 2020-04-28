package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VerificationCodePage extends BasePage
{
    public VerificationCodePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "div.title")
    public WebElement VerificationCodeText;

    @FindBy(css = "div.sub")
    public WebElement VerificationSubject;

    @FindBy(css = "input.grid-ite")
    public List<WebElement> OTPInputField;

    @FindBy(css = "button.login-btn.border-0")
    public WebElement VerifyButton;

    @FindBy(css = "div.text-error")
    public WebElement VerificationErrorText;



    public AdminPanelPage EnterCodeAndClickSubmit(String one, String Two, String Three, String Four)
    {
        Utils.WaitForElementsToExist(driver, OTPInputField);
        OTPInputField.get(0).sendKeys(one);
        OTPInputField.get(1).sendKeys(Two);
        OTPInputField.get(2).sendKeys(Three);
        OTPInputField.get(3).sendKeys(Four);
        Utils.WaitForAnElementToExist(driver, VerifyButton);
        VerifyButton.click();
        return new AdminPanelPage(driver);
    }

    public ResetPasswordPage EnterOTPAndClickSubmitForResetPassword(String One, String Two, String Three, String Four)
    {
        Utils.WaitForElementsToExist(driver, OTPInputField);
        OTPInputField.get(0).sendKeys(One);
        OTPInputField.get(1).sendKeys(Two);
        OTPInputField.get(2).sendKeys(Three);
        OTPInputField.get(3).sendKeys(Four);
        Utils.WaitForAnElementToExist(driver, VerifyButton);
        VerifyButton.click();
        return new ResetPasswordPage(driver);
    }
}
