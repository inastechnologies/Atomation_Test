package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPanelPage extends BasePage {
    public AdminPanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.title")
    public WebElement AdminPanelText;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    public WebElement UserNameInputField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    public WebElement PasswordInputField;

    @FindBy(css = "button.button")
    public WebElement LoginButton;

    @FindBy(xpath = "//span[text()=' Access Management & Privileges ']")
    public WebElement AccessManagementTab;

    @FindBy(xpath = "//span[text()='Access Management & Privileges']")
    public WebElement AccessManagementAndPrivilegesText;

    @FindBy(xpath = "//img[@src='assets/images/q_1.png']")
    public WebElement QNatureLogo;

    @FindBy(css = "img.image-size-round")
    public List<WebElement> HeaderIcons;

    @FindBy(xpath = "//th[@role='columnheader']")
    public List<WebElement> ColumnHeader;

    @FindBy(xpath = "//mat-label[text()=' Total Rows:']")
    public WebElement TotalRows;

    @FindBy(id = "mat-input-2")
    public WebElement SearchInput;

    @FindBy(css = "div.add-button")
    public WebElement AddButton;

    @FindBy(css = "span.title")
    public WebElement AddSubAdminText;

    @FindBy(css = "ul.custom-bread-crumb")
    public WebElement SubAdminProfileText;

    @FindBy(xpath = "//input[@formcontrolname='person_name']")
    public WebElement SubAdminNameInput;

    @FindBy(xpath = "//input[@formcontrolname='roll_name']")
    public WebElement RollNameInput;

    @FindBy(xpath = "//input[@formcontrolname='no_of_rolls']")
    public WebElement NoOfRollsInput;

    @FindBy(xpath = "//mat-select[@formcontrolname='status']")
    public WebElement StatusInput;

    @FindBy(css = "span.mat-option-text")
    public List<WebElement> StatusOptions;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SubAdminCreateButton;

    @FindBy(xpath = "//mat-error[text()=' Person Name Required field. ']")
    public WebElement SubAdminNameError;

    @FindBy(xpath = "//mat-error[text()=' Required RollName. ']")
    public WebElement RollNameError;

    @FindBy(xpath = "//mat-error[text()=' No_Of_Rolls Required ']")
    public WebElement NoOfRollError;

    @FindBy(xpath = "//mat-error[text()=' Required status. ']")
    public WebElement StatusError;

    @FindBy(xpath = "//mat-icon[@mattooltip='View']")
    public List<WebElement> ViewIcon;

    @FindBy(xpath = "//mat-icon[@mattooltip='Edit']")
    public List<WebElement> EditIcon;

    @FindBy(xpath = "//mat-icon[@mattooltip='Delete']")
    public List<WebElement> DeleteIcon;

    @FindBy(css = "p.title")
    public WebElement DeletePopup;

    public void EnterUserNamePassword(String UserName, String Password) {
        UserNameInputField.sendKeys(UserName);
        PasswordInputField.sendKeys(Password);
        LoginButton.click();
    }

    public void ClickEveryFieldInSubAdminScreenBeforeEnteringDetails() {
        SubAdminNameInput.click();
        RollNameInput.click();
        NoOfRollsInput.click();
        StatusInput.click();
    }

    public void FillAllTheFieldsInAddSubAdminScreenAndClickCreate(String SudAdminName, String RollName, String NoOfRolls) {
        SubAdminNameInput.sendKeys(SudAdminName);
        RollNameInput.sendKeys(RollName);
        NoOfRollsInput.sendKeys(NoOfRolls);
        StatusInput.click();
        StatusOptions.get(0).click();
        SubAdminCreateButton.click();
    }

    public void ClickOnDateToCheckTheAppointments(String Name, String RollName) throws InterruptedException {

        driver.findElement(By.xpath("//span[text()='" + Name + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + Name + "']")).click();
    }
}