package Pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerManagementPage extends BasePage {
    public CustomerManagementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()=' Customer Management ']")
    public WebElement CustomerManagementTab;

    @FindBy(css = "ul.custom-bread-crumb")
    public WebElement CustomerManagementPageHeading;

    @FindBy(css = "div.total")
    public WebElement TotalRows;

    @FindBy(css = "div.mat-paginator-range-label")
    public WebElement RowsRange;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement SearchInput;

    @FindBy(xpath = "//th[@role='columnheader']")
    public List<WebElement> ColumnHeader;

    @FindBy(xpath = "//button[text()='Active']")
    public List<WebElement> ActiveStatus;

    @FindBy(xpath = "//button[text()='Inactive']")
    public List<WebElement> InActiveStatus;

    @FindBy(css = "button.button-2.ng-star-inserted")
    public WebElement CustomerStatusText;

    @FindBy(xpath = "//mat-icon[@mattooltip='View']")
    public List<WebElement> ViewIcon;

    @FindBy(xpath = "//mat-icon[@mattooltip='Delete']")
    public List<WebElement> DeleteIcon;

    @FindBy(css = "button.mat-focus-indicator.mat-paginator-navigation-next.mat-icon-button.mat-button-base")
    public WebElement NextPageIcon;

    @FindBy(css = "button.mat-focus-indicator.mat-paginator-navigation-previous.mat-icon-button.mat-button-base")
    public WebElement PreviousPageIcon;

    @FindBy(css = "div.mat-checkbox-inner-container.mat-checkbox-inner-container-no-side-margin")
    public List<WebElement> CheckBoxes;

    @FindBy(css = "p.title")
    public WebElement DeletePopup;

    @FindBy(css = "button.button")
    public List<WebElement> DeletePopupButtons;

    @FindBy(css = "td.mat-cell.cdk-cell.action-width.cdk-column-first_name")
    public List<WebElement> CustomerNameList;

    @FindBy(css = "ul.custom-bread-crumb")
    public WebElement CustomerProfileText;

    @FindBy(css = "div.title")
    public WebElement CustomerProfileTitleText;

    @FindBy(css = "p.sub-title")
    public List<WebElement> CustomerSubTitleText;

    @FindBy(css = "div.mat-tab-label-content")
    public List<WebElement> CustomerProfileTabs;

    @FindBy(xpath = "//img[@src='assets/images/profile.png']")
    public List<WebElement> CustomerProfilePic;

    @FindBy(css = "label.label")
    public List<WebElement> BasicInfoFieldsText;

}