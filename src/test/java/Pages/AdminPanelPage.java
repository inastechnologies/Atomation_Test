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

    public void EnterUserNamePassword()
    {
        UserNameInputField.sendKeys("7026562080");
        PasswordInputField.sendKeys("Sushma@123");
        //LoginButton.click();
    }

}