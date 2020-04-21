package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage
{
    public LandingPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//div[text()=' LOGIN '] ")
    public WebElement LoginTab;

    @FindBy(xpath = "//span[text()='Sign Up']")
    public WebElement SignUpLink;

    @FindBy(xpath = "//div[text()=' SIGN UP ']")
    public WebElement SignUpTab;

    @FindBy(css = "span.welcome-text")
    public WebElement LoginInWelcomeText;

    public SignUpPage NavigateToSignUpPage()
    {
        Utils.WaitForAnElementToExist(driver, SignUpTab);
        SignUpTab.click();
        return new SignUpPage(driver);
    }

    public LoginPage NavigateToLogInPage()
    {
        Utils.WaitForAnElementToExist(driver, LoginTab);
        LoginTab.click();
        return new LoginPage(driver);
    }
}
