package Pages;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage extends BasePage
{
    public LandingPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "h1.text-line-1")
    public WebElement BecomeTheNaturallyYouText;

    @FindBy(css = "img.header-image-size")
    public WebElement QNatureLogo;

    @FindBy(css = "span.header-labels")
    public List<WebElement> HeaderTabs;

    @FindBy(css = "span.header-image-circle")
    public List<WebElement> HeaderIcons;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement LoginTab;

    @FindBy(xpath = "//span[text()='Signup']")
    public WebElement SignUpTab;

    @FindBy(css = "button.list-business-button")
    public WebElement ListYourBusinessTab;

    @FindBy(css = "div.text-size-50.txt-align-center.welcome-text")
    public WebElement LoginInWelcomeText;

    @FindBy(css = "span.circle-outer")
    public List<WebElement> OfferNameButton;

    @FindBy(css = "div.image-content")
    public WebElement OfferDescription;

    @FindBy(css = "div.circle-div")
    public WebElement AvailNowButton;

    @FindBy(css = "Img.testi-heading-image-size")
    public List<WebElement> HeartAndMessageSymbol;

    @FindBy(css = "button.ask-button")
    public WebElement AskButton;

    @FindBy(css = "input.input-modalities.input2-w")
    public WebElement ModalitiesSearchInput;

    @FindBy(xpath = "//div[text()='Nutrition']")
    public WebElement Nutrition;

    @FindBy(xpath = "//div[text()='Homeopathy']")
    public WebElement Homeopathy;

    @FindBy(xpath = "//div[text()='Allergy Treatments']")
    public WebElement AllergyTreatments;

    @FindBy(xpath = "//img[@src='assets/images/icons8-forward-24.png']")
    public WebElement RightScroll;

    @FindBy(xpath = "//img[@src='../assets/images/icons8-back-24.png']")
    public WebElement LeftScroll;

    @FindBy(css = "button.sec-7-list-business-button")
    public WebElement ListYourBusinessButton;

    @FindBy(css = "button.sec-9-button")
    public WebElement GetTheLinkButton;

    @FindBy(css = "input.sec-9-form-control")
    public WebElement GetTheLinkInputField;


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

    public SignUpPage ClickListYourBusinessAndNavigateToLogInPage()
    {
        Utils.WaitForAnElementToExist(driver, LoginTab);
        ListYourBusinessTab.click();
        return new SignUpPage(driver);
    }

    public void ClickOnFindIconAndEnterDataForSearch(String Text)
    {
        Utils.WaitForAnElementToExist(driver, LoginTab);
        HeaderIcons.get(0).click();
        HeaderIcons.get(0).sendKeys(Text);
    }

    public void ClickOnAskIconAndNavigateToPractitionerPage()
    {
        Utils.WaitForAnElementToExist(driver, LoginTab);
        HeaderIcons.get(1).click();
    }

    public void ClickOnBookIconAndNavigateToPractitionerPage()
    {
        Utils.WaitForAnElementToExist(driver, LoginTab);
        HeaderIcons.get(2).click();
    }

    public void SearchForTheModalities(String Text)
    {
        Utils.WaitForAnElementToExist(driver, ModalitiesSearchInput);
        ModalitiesSearchInput.sendKeys(Text);
    }
}
