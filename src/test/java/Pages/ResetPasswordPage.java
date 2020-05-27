package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResetPasswordPage extends BasePage
{
    public ResetPasswordPage(WebDriver driver)

    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(xpath = "//div[text()='Reset Password']")
    public WebElement ResetPasswordMessage;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement PasswordInputField;

    @FindBy(xpath = "//input[@formcontrolname='confirm_password']")
    public WebElement ConfirmPasswordField;

    @FindBy(css = "button.verification-btn")
    public WebElement ConfirmButton;

    public LoginPage EnterPasswordConfirmPasswordAndClickConfirm()
    {
        Utils.WaitForAnElementToExist(driver, PasswordInputField);
        PasswordInputField.sendKeys("!tTghf65ghgfh");
        ConfirmPasswordField.sendKeys("!tTghf65ghgfh");
        ConfirmButton.click();
        return new LoginPage(driver);
    }
}
