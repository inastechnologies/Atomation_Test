package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage extends BasePage
{
    public AdminPanelPage(WebDriver driver)
    {
    super(driver);
     }

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement UserNameInputField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement PasswordInputField;

    @FindBy(css = "button.button")
    public WebElement LoginButton;

    @FindBy(xpath = "//span[text()='Access Management & Privileges']")
    public WebElement AccessManagementAndPrivilegesText;

    public void EnterUserNamePassword(String UserName, String Password)
    {
        UserNameInputField.sendKeys(UserName);
        PasswordInputField.sendKeys(Password);
        LoginButton.click();
    }
}