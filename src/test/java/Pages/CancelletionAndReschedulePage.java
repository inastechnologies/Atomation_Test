package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CancelletionAndReschedulePage extends BasePage
{
    public CancelletionAndReschedulePage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(css = "span.title")
    public List<WebElement> MandatoryFields;

    @FindBy(xpath = "//h6[text()='(i) Refunds are not processed automatically via Q nature, It happens via Latpay']")
    public List<WebElement> CancellationReschedulingPolicyInRed;

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

    @FindBy(css = "button.q-button.view-button")
    public WebElement SaveAndContinue;

    public void FillAlTheFieldsInCancellationAndReschedulingPage()
    {
        Utils.SelectFromDropDownUsingVisibleText(CustomerCancelHours1, "24");
        RefundPrice1.sendKeys("50");
        Utils.SelectFromDropDownUsingVisibleText(TypeOfPrice1, "%of the price");
        Utils.SelectFromDropDownUsingVisibleText(CustomerCancelHours2, "1");
        RefundPrice2.sendKeys( "10");
        Utils.SelectFromDropDownUsingVisibleText(TypeOfPrice2, "%of the price");
        PolicyDescription1.get(1).click();
        Utils.WaitForAnElementToExist(driver, PolicyDescriptionTextArea1);

        PolicyDescriptionTextArea1.sendKeys("ghfhgfh");
        CustomerCancellationReason1.get(2).click();

        Utils.SelectFromDropDownUsingVisibleText(RescheduleHours1, "24");
        ReschedulePrice1.sendKeys( "50");
        Utils.SelectFromDropDownUsingVisibleText(RescheduleTypeOfPrice1, "%of the price");
        Utils.SelectFromDropDownUsingVisibleText(RescheduleHours2, "1");
        ReschedulePrice2.sendKeys( "10");
        Utils.SelectFromDropDownUsingVisibleText(RescheduleTypeOfPrice2, "%of the price");
        PolicyDescription2.get(1).click();
        Utils.WaitForAnElementToExist(driver, PolicyDescriptionTextArea2);
        PolicyDescriptionTextArea2.sendKeys("ghfhgfh");
        CustomerCancellationReason2.get(2).click();
        SaveAndContinue.click();
    }
}
