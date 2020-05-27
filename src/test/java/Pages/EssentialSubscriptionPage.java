package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EssentialSubscriptionPage extends BasePage
{
    public EssentialSubscriptionPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(css = "div.head")
    public WebElement PaymentHeading;

    @FindBy(css = "input.input-type-2")
    public List<WebElement> InputFields;

    @FindBy(css = "div.available-txt")
    public WebElement AvailableAddOnsText;

    @FindBy(css = "input.checkbox-agree")
    public List<WebElement> CheckBox;

    @FindBy(xpath = "//input[@value='CONFIRM']")
    public WebElement ConfirmButton;

    public void EnterPaymentDetailsAndConfirm(String FirstName, String LastName, String CardNumber, String ExpiryDate)
    {
        Utils.WaitForElementsToExist(driver, InputFields);
        InputFields.get(0).sendKeys(FirstName);
        InputFields.get(1).sendKeys(LastName);
        InputFields.get(2).sendKeys(CardNumber);
        InputFields.get(3).sendKeys(ExpiryDate);

        CheckBox.get(0).click();
        ConfirmButton.click();
    }



}
