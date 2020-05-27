package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(xpath = "//div[text()=' LOGIN '] ")
    public WebElement LoginTab;

    @FindBy(xpath = "//span[text()='Sign Up']")
    public WebElement SignUpLink;

    @FindBy(css = "div.text-login")
    public WebElement LoginText;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement MobileEmailInputField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement PasswordInputField;

    @FindBy(xpath = "//input[@value='LOGIN']")
    public WebElement LoginButton;

    @FindBy(xpath = "//input[@value='GUEST']")
    public WebElement GuestButton;

    @FindBy(xpath = "//span[text()='Forgot Password?']")
    public WebElement ForGotPassword;

    @FindBy(css = "div.text-error")
    public List<WebElement> ValidMobileOrEmailMessage;

    @FindBy(xpath = "//div[text()=' Password is required ']")
    public WebElement ValidPasswordMessage;

    @FindBy(xpath = "//div[text()=' Phone Number or Email is required ']")
    public WebElement ValidMobileEmailErrMessage;

    @FindBy(css = "i.fa.fa-eye-slash")
    public WebElement PasswordEye;

    @FindBy(css = "span.image-circle")
    public List<WebElement> LoginPageIcons;

    public AdminPanelPage EnterMobileNumberOrEmailEnterPasswordAndClickLogin(String MobileOrEmail, String Password)
    {
        Utils.WaitForAnElementToExist(driver, MobileEmailInputField);
        MobileEmailInputField.sendKeys(MobileOrEmail);
        PasswordInputField.sendKeys(Password);
        LoginButton.click();
        return new AdminPanelPage(driver);
    }

    public ForgotPasswordPage ClickAndNavigateToForgetPasswordPage()
    {
        Utils.WaitForAnElementToExist(driver, ForGotPassword);
        ForGotPassword.click();
        return new ForgotPasswordPage(driver);
    }

    public AdminPanelPage ClickAndNavigateToGuestLoginPage()
    {
        Utils.WaitForAnElementToExist(driver, GuestButton);
        GuestButton.click();
        return new AdminPanelPage(driver);
    }
}
