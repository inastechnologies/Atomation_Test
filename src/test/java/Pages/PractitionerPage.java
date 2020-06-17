package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PractitionerPage extends BasePage
{
    public PractitionerPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//div[text()='MANAGE APPOINTMENTS']")
    public WebElement ManageAppointments;

    @FindBy(xpath = "//div[text()='MANAGE ORDERS']")
    public WebElement ManageOrders;

    @FindBy(css = "div.calender-head")
    public WebElement CalendarHeading;

    @FindBy(css = "div.pointer.forward-button")
    public WebElement ForwardButton;

    @FindBy(css = "div.pointer.reverse-button")
    public WebElement ReverseButton;

    @FindBy(xpath = "//span[text()='10']")
    public WebElement June10;

    @FindBy(xpath = "//span[text()='1 appointments Confirmed']")
    public WebElement ConfirmedAppointment;

    @FindBy(id = "swal2-title")
    public WebElement SwalTitle;

    @FindBy(xpath = "//button[text()='Reject Appointment']")
    public WebElement RejectAppointmentButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CancelButton;

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(css = "img.image-size-user")
    public WebElement ProfileIcon;

    @FindBy(css = "div.options-pop")
    public WebElement LogoutButton;

    public LoginPage ClickLogoutToGoOutOfThePage()
    {
        Utils.WaitForAnElementToExist(driver, ProfileIcon);
        ProfileIcon.click();
        Utils.WaitForAnElementToExist(driver, LogoutButton);
        LogoutButton.click();

        return new LoginPage(driver);
    }

    public void ClickOnDateToCheckTheAppointments(String Date) throws InterruptedException {

        Utils.WaitForAnElementToExist(driver, ManageAppointments);
        ManageAppointments.click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='" + Date + "']")).click();
    }
}
