package Pages;

import Utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubscriptionPage extends BasePage
{
    public SubscriptionPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.image-circle.hand-pointer")
    public List<WebElement> HeaderIcons;

    @FindBy(xpath = "//h2[text()='ESSENTIAL']")
    public WebElement EssentialSubscription;

    @FindBy(xpath = "//h2[text()='DYNAMIC']")
    public WebElement DynamicSubscription;

    @FindBy(xpath = "//h2[text()='ENTERPRISE']")
    public WebElement EnterpriseSubscription;

    @FindBy(xpath = "//button[text()='Try']")
    public WebElement TryButton;

    @FindBy(xpath = "//button[text()='Buy']")
    public WebElement BuyButton;

    @FindBy(css = "button.swal2-confirm")
    public WebElement Confirm;

    @FindBy(css = "button.swal2-confirm.swal2-styled")
    public WebElement OkButton;

    public BusinessInfoPage ClickOnTryButtonAndNavigateToBusinessInfoPage()
    {
        Utils.WaitForAnElementToExist(driver, TryButton);
        TryButton.click();
        Confirm.click();
        return new BusinessInfoPage(driver);
    }

    public EssentialSubscriptionPage ClickOnBuyButtonAndNavigateToEssentialSubscriptionPage()
    {
        Utils.WaitForAnElementToExist(driver, BuyButton);
        BuyButton.click();
        return new EssentialSubscriptionPage(driver);
    }
}
