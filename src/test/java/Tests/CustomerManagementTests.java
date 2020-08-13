package Tests;

import Pages.AccessManagementAndPrivilegesPage;
import Pages.CustomerManagementPage;
import Utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CustomerManagementTests {
    public WebDriver driver;

    @BeforeMethod
    public void OpenAdminPanelWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://13.232.236.88/qnatureadmin/");
        driver.manage().window().maximize();

        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

    }

    @AfterMethod
    public void CloseAdMinPanelURL() {
        driver.quit();
    }

    @Test
    public void VerifyThatUserCanSeeCustomerManagementTabInTheSideBar() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerManagementTab), "Customer Management");
    }

    @Test
    public void VerifyIfUserClicksOnCustomerManagementTabItNavigatesToCustomerManagementPage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerManagementPageHeading), "Dashboard / Customer Management");
    }

    @Test
    public void VerifyIfAllTheRequiredFieldsAreThereInCustomerManagementPage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForAnElementToExist(driver, customerManagementPage.TotalRows);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.TotalRows));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.SearchInput));

        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ColumnHeader.get(7)));
    }

    @Test
    public void VerifyStatusColumnHasActiveOrInActiveStateInCustomerManagementPage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ActiveStatus);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ActiveStatus.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.InActiveStatus.get(0)));
    }

    @Test
    public void VerifyStatusOfCustomerActiveOrInActiveCanBeClickableInCustomerManagementPage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ActiveStatus);
        Assert.assertTrue(Utils.isClickable(driver, customerManagementPage.ActiveStatus.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, customerManagementPage.InActiveStatus.get(0)));
    }

    @Test
    public void VerifyIfStatusOfTheCustomerCanBeChangedToActiveOrInActive() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForAnElementToExist(driver, customerManagementPage.ActiveStatus.get(0));
        customerManagementPage.ActiveStatus.get(0).click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.InActiveStatus);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.InActiveStatus.get(0)));
    }

    @Test
    public void VerifyUserShouldBeAbleToSeeViewAndDeleteIconsUnderActionsColumnInCustomerManagementPage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        Assert.assertTrue(Utils.ElementsDisplayed(driver, customerManagementPage.ViewIcon));
        Assert.assertTrue(Utils.ElementsDisplayed(driver, customerManagementPage.DeleteIcon));
    }

    @Test
    public void VerifyIfUserCanSeeNextAvailableRowsByClickingNextPageIconInCustomerManagementPage() throws InterruptedException {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        customerManagementPage.NextPageIcon.click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));
    }

    @Test
    public void VerifyIfUserCanClickRightAndLeftArrowToNavigateBetweenPreviousPageAndNextPageInCustomerManagementPage() throws InterruptedException {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        customerManagementPage.NextPageIcon.click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));

        customerManagementPage.PreviousPageIcon.click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 1 ']"))));
    }

    @Test
    public void VerifyIfUserClicksOnLeftArrowTheOrderShouldContinueInNextPageInCustomerManagementPage() throws InterruptedException {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        customerManagementPage.NextPageIcon.click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));
    }

    @Test
    public void VerifyThatNumberOfRowsPresentInTheListIsMatchingWithTotalRowsInCustomerManagementScreen() throws InterruptedException {

        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();
        Thread.sleep(3000);

        int Total = Utils.extractMaximum(customerManagementPage.TotalRows.getText());

        String TotalRows = Integer.toString(Total);

        int Count = Utils.extractMaximum(customerManagementPage.RowsRange.getText());

        String RowCount = Integer.toString(Count);
        Thread.sleep(3000);

        Assert.assertEquals((TotalRows), RowCount);
    }

    @Test
    public void VerifyThatAllCheckboxesOfTheRowsAreCheckedUponClickingOnNoCheckBox() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.CheckBoxes);
        customerManagementPage.CheckBoxes.get(0).click();

        Assert.assertNull(customerManagementPage.CheckBoxes.get(2).getAttribute("checked"));
        Assert.assertNull(customerManagementPage.CheckBoxes.get(3).getAttribute("checked"));
        Assert.assertNull(customerManagementPage.CheckBoxes.get(5).getAttribute("checked"));
    }

    @Test
    public void VerifyThatDeleteIconForParticularRowIsClickableInCustomerManagementPage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.DeleteIcon);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.DeleteIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.DeleteIcon.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.DeleteIcon.get(6)));
    }

    @Test
    public void VerifyThatAfterClickingDeleteIconPoUpScreenWithDeleteAndCancelButtonAppears() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.DeleteIcon);
        customerManagementPage.DeleteIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, customerManagementPage.DeletePopup);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, customerManagementPage.DeletePopup), "Are you sure?");
    }

    @Test
    public void VerifyThatWhenClickedOnDeleteInTheDeletePopupTheRowShouldGetDeleteInCustomerManagementScreen() throws InterruptedException {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Thread.sleep(3000);

        customerManagementPage.DeleteIcon.get(0).click();
        customerManagementPage.DeletePopupButtons.get(0).click();

        driver.navigate().refresh();

        int Total = Utils.extractMaximum(customerManagementPage.TotalRows.getText());

        String TotalRows = Integer.toString(Total);

        int Count = Utils.extractMaximum(customerManagementPage.RowsRange.getText());

        String RowCount = Integer.toString(Count);
        Thread.sleep(3000);

        Assert.assertEquals((TotalRows), RowCount);
    }

    @Test
    public void VerifyThatWhenClickedOnCancelInTheDeletePopupTheRowShouldNotGetDeleteInCustomerManagementScreen() throws InterruptedException {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Thread.sleep(3000);

        customerManagementPage.DeleteIcon.get(0).click();
        customerManagementPage.DeletePopupButtons.get(1).click();

        driver.navigate().refresh();

        int Total = Utils.extractMaximum(customerManagementPage.TotalRows.getText());

        String TotalRows = Integer.toString(Total);

        int Count = Utils.extractMaximum(customerManagementPage.RowsRange.getText());

        String RowCount = Integer.toString(Count);
        Thread.sleep(3000);

        Assert.assertEquals((TotalRows), RowCount);
    }

    @Test
    public void VerifyThatIfTheSearchBarFieldIsClickableAndEditableInCustomerManagementScreen() {

        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        customerManagementPage.SearchInput.sendKeys("Cind");

        Assert.assertEquals(customerManagementPage.SearchInput.getAttribute("value"), "Cind");
    }

    @Test
    public void VerifyThatIfTheSearchBarFieldIsAcceptingAlphabetsAndListingOutRowsWhichMatchesWithNameInCustomerManagementScreen() {

        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        String First = Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerNameList.get(0));

        customerManagementPage.SearchInput.sendKeys(First);

        Assert.assertEquals(customerManagementPage.SearchInput.getAttribute("value"), First);
    }

    @Test
    public void VerifyThatWhenTheUserClicksOnViewIconItShouldBeClickable() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        Assert.assertTrue(Utils.isClickable(driver, customerManagementPage.ViewIcon.get(0)));
    }

    @Test
    public void VerifyThatWhenTheUserClicksOnViewIconItNavigatesToCustomerProfileScreen() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerProfileText), "Dashboard / Customer Management");
    }

    @Test
    public void VerifyThatIfTheCustomerProfilePageHasProfilePictureCustomerNamePhoneEmailAndCustomerStatus() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.CustomerProfilePic.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.CustomerProfileTitleText));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.CustomerSubTitleText.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.CustomerSubTitleText.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.CustomerStatusText));
    }

    @Test
    public void VerifyThatIfTheUserCanSeeThreeTabsInCustomerProfilePage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerProfileTabs.get(0)), "BASIC INFORMATION");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerProfileTabs.get(1)), "SERVICES TAKEN");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerProfileTabs.get(2)), "UPLOAD");
    }

    @Test
    public void VerifyThatIfTheUserCanSeeRequiredFieldsUnderBasicInformationTabInCustomerProfilePage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.ElementsDisplayed(driver, customerManagementPage.BasicInfoFieldsText));
    }

    @Test
    public void VerifyThatIfTheUserCanClickServiceTakenTabInCustomerProfilePage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, customerManagementPage.CustomerProfileTabs.get(1)));
    }

    @Test
    public void VerifyThatIfTheUserClickServiceTakenTabAllTheRequiredFieldsAreVisibleInCustomerProfilePage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();
        customerManagementPage.CustomerProfileTabs.get(1).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.TotalRows));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(7)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(8)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, customerManagementPage.ServiceTakenFieldsText.get(9)));
    }

    @Test
    public void VerifyThatIfCheckBoxCanBeTickedUnderServiceTakenTabInCustomerProfilePage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();
        customerManagementPage.CustomerProfileTabs.get(1).click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ServiceTakenFieldsText);
        Assert.assertNull(customerManagementPage.ServiceTakenFieldsText.get(1).getAttribute("checked"));
    }

    @Test
    public void VerifyThatIfEachPageAcceptsTenRowsAndWhenClickedOnNextArrowItShouldContinueFrom11UnderServiceTakenTab() throws InterruptedException {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();
        customerManagementPage.CustomerProfileTabs.get(1).click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//div[text()=' 1 – 10 of 100 ']"))));

        customerManagementPage.NextPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//div[text()=' 11 – 20 of 100 ']"))));
    }

    @Test
    public void VerifyThatIfTheUserIsAbleToNavigateBetweenThePreviousPageAndNextPageUnderServiceTakenTabInCustomerProfilePage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();
        customerManagementPage.CustomerProfileTabs.get(1).click();

        Utils.WaitForAnElementToExist(driver, customerManagementPage.NextPageIcon);
        customerManagementPage.NextPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//div[text()=' 11 – 20 of 100 ']"))));

        customerManagementPage.PreviousPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//div[text()=' 1 – 10 of 100 ']"))));
    }

    @Test
    public void VerifyThatIfTheSearchBarFieldIsClickableAndEditableUnderServiceTakenTabInCustomerProfilePage() {

        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();
        customerManagementPage.CustomerProfileTabs.get(1).click();

        Utils.WaitForAnElementToExist(driver, customerManagementPage.SearchInput);
        customerManagementPage.SearchInput.sendKeys("Kia");

        Assert.assertEquals(customerManagementPage.SearchInput.getAttribute("value"), "Kia");
    }

    @Test
    public void VerifyThatIfTheSearchBarFieldIsAcceptingAlphabetsUnderServicesTakenTabInCustomerProfilePage() {

        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        String First = Utils.GetTextFromAnElement(driver, customerManagementPage.CustomerNameList.get(0));

        customerManagementPage.SearchInput.sendKeys("hjgjhjg");

        Assert.assertEquals(customerManagementPage.SearchInput.getAttribute("value"), "hjgjhjg");
    }

    @Test
    public void VerifyThatIfTheUserCanClickUploadTabInCustomerProfilePage() {
        CustomerManagementPage customerManagementPage = new CustomerManagementPage(driver);

        Utils.WaitForAnElementToExist(driver, customerManagementPage.CustomerManagementTab);
        customerManagementPage.CustomerManagementTab.click();

        Utils.WaitForElementsToExist(driver, customerManagementPage.ViewIcon);
        customerManagementPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, customerManagementPage.CustomerProfileTabs.get(2)));
    }

}







