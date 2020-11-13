package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Practitioner_Q_A_Page extends BasePage
{
    public Practitioner_Q_A_Page(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "h4.text-uppercase")
    public WebElement Q_A_Text;

    @FindBy(css = "select.nav-button")
    public WebElement ModalityDropDown;

    @FindBy(css = "select.nav-button.ng-pristine.ng-valid.ng-touched")
    public WebElement AllQuestions;

    @FindBy(css = "button.ans-btn")
    public WebElement RefreshButton;

    @FindBy(xpath = "//button[text()=' VIEW APPOINTMENTS ']")
    public WebElement ViewAppointments;

    @FindBy(xpath = "//div[text()='MANAGE ORDERS']")
    public WebElement ManageOrders;
}

