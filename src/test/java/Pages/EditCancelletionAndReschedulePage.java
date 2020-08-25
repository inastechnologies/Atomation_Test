package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditCancelletionAndReschedulePage extends BasePage
{
    public EditCancelletionAndReschedulePage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//button[text()=' Cancellation or Reschedule Policy '] ")
    public WebElement EditCancellationRescheduleHeading;

    @FindBy(xpath = "//Select[@formcontrolname='c_time']")
    public WebElement CustomerCancelHours1;

    @FindBy(xpath = "//input[@formcontrolname='c_price']")
    public WebElement RefundPrice1;

    @FindBy(xpath = "//Select[@formcontrolname='c_type_of_price']")
    public WebElement TypeOfPrice1;

    @FindBy(xpath = "//Select[@formcontrolname='lc_type_of_price']")
    public WebElement TypeOfPrice2;

    @FindBy(xpath = "//Select[@formcontrolname='lc_time']")
    public WebElement CustomerCancelHours2;

    @FindBy(xpath = "//input[@formcontrolname='lc_price']")
    public WebElement RefundPrice2;

    @FindBy(name = "policy_description_type_for_cancel")
    public List<WebElement> PolicyDescription1;

    @FindBy(xpath = "//textarea[@formcontrolname='policy_description_for_cancel']")
    public WebElement PolicyDescriptionTextArea1;

    @FindBy(name = "cancellation_reason")
    public List<WebElement> CustomerCancellationReason1;

    @FindBy(xpath = "//Select[@formcontrolname='r_time']")
    public WebElement RescheduleHours1;

    @FindBy(xpath = "//input[@formcontrolname='r_price']")
    public WebElement ReschedulePrice1;

    @FindBy(xpath = "//Select[@formcontrolname='r_type_of_price']")
    public WebElement RescheduleTypeOfPrice1;

    @FindBy(xpath = "//Select[@formcontrolname='lr_type_of_price']")
    public WebElement RescheduleTypeOfPrice2;

    @FindBy(xpath = "//Select[@formcontrolname='lr_time']")
    public WebElement RescheduleHours2;

    @FindBy(xpath = "//input[@formcontrolname='lr_price']")
    public WebElement ReschedulePrice2;

    @FindBy(name = "policy_description_type_for_reschedule")
    public List<WebElement> PolicyDescription2;

    @FindBy(xpath = "//textarea[@formcontrolname='policy_description_for_reschedule']")
    public WebElement PolicyDescriptionTextArea2;

    @FindBy(name = "reschedule_reason")
    public List<WebElement> CustomerCancellationReason2;

    @FindBy(css = "i.fa.fa-pencil")
    public WebElement EditPencil;

    @FindBy(css = "button.q-button.view-button")
    public WebElement SaveAndContinue;

    public void EditTheFieldsInCancellationAndReschedulingPage()
    {
        Utils.WaitForAnElementToExist(driver, EditPencil);
        EditPencil.click();
        Utils.SelectFromDropDownUsingVisibleText(CustomerCancelHours1, "23");
        Utils.SelectFromDropDownUsingVisibleText(TypeOfPrice1, "AUD $ value");
        Utils.SelectFromDropDownUsingVisibleText(CustomerCancelHours2, "5");
        Utils.SelectFromDropDownUsingVisibleText(TypeOfPrice2, "AUD $ value");
        PolicyDescription1.get(1).click();
        Utils.WaitForAnElementToExist(driver, PolicyDescriptionTextArea1);
        PolicyDescriptionTextArea1.clear();
        PolicyDescriptionTextArea1.sendKeys("hhgytycbv jhjsa ghsgah");
        CustomerCancellationReason1.get(2).click();

        Utils.SelectFromDropDownUsingVisibleText(RescheduleHours1, "20");
        Utils.SelectFromDropDownUsingVisibleText(RescheduleTypeOfPrice1, "AUD $ value");
        Utils.SelectFromDropDownUsingVisibleText(RescheduleHours2, "1");
        Utils.SelectFromDropDownUsingVisibleText(RescheduleTypeOfPrice2, "AUD $ value");
        Utils.WaitForAnElementToExist(driver, PolicyDescriptionTextArea2);
        PolicyDescriptionTextArea2.clear();
        PolicyDescriptionTextArea2.sendKeys("trrw poppppp uyiuy");
        SaveAndContinue.click();
    }
}
