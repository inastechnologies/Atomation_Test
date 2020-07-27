package Tests;

import Pages.AdminPanelPage;
import Utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


public class AdminPanelTests {
    public WebDriver driver;

    @BeforeMethod
    public void OpenAdminPanelWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://13.232.236.88/qnatureadmin/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void CloseAdMinPanelURL() {
        driver.quit();
    }

    @Test
    public void VerifyThatUserIsAbleToLandOnToLoginPageOfTheApplication() {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelText), "Welcome To Admin");
    }

    @Test
    public void VerifyThatUserCanLoginWithValidUserNamePassword() {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AccessManagementAndPrivilegesText), "Access Management & Privileges");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithInvalidUsernameAndValidPassword() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("98661761", "Thannidi@270116");

        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithInvalidUsernameAndInvalidPassword() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("98661761", "Thannidi@");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithEmptyFieldsOfUsernameAndPasswordFields() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("", "");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatQNatureLogoAskBookFindIconsAccessManagementTabArePresent() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.QNatureLogo));
        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.HeaderIcons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.HeaderIcons.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.HeaderIcons.get(2)));
    }

    @Test
    public void VerifyThatAllTheRequiredFieldsArePresentInAccessManagementAndPrivilegesScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.TotalRows));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SearchInput));

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ColumnHeader.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ColumnHeader.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ColumnHeader.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ColumnHeader.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ColumnHeader.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ColumnHeader.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ColumnHeader.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.AddButton));
    }

    @Test
    public void VerifyThatWhenClickedOnAddButtonItDisplaysAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();
        
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AddSubAdminText), "ADD SUB-ADMIN");
    }

    @Test
    public void VerifyThatAddSubAdminScreenHasAllTheRequiredFieldsAndCreateButtonIsClickable() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.RollNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.NoOfRollsInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.StatusInput));
        Assert.assertFalse(Utils.isClickable(driver, adminPanelPage.CreateUpdateButton));
    }

    @Test
    public void VerifyThatIfSubAdminNameFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.AddButton.click();
        adminPanelPage.RollNameInput.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminNameError), "Person Name Required field.");
    }

    @Test
    public void VerifyThatIfSubAdminNameFieldIsAcceptingAlphabetsAndSpacesInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.AddButton.click();
        Thread.sleep(3000);
        adminPanelPage.SubAdminNameInput.sendKeys("ASD asd");
        Assert.assertFalse(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminNameError));
    }

    @Test
    public void VerifyThatIfSubAdminNameFieldIsNotAcceptingNumbersInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.AddButton.click();
        Thread.sleep(3000);
        adminPanelPage.SubAdminNameInput.sendKeys("76766 #@#@");
        adminPanelPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminNameError), "Person Name Required field.");
    }

    @Test
    public void VerifyThatIfRollNameFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();
        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.click();
        adminPanelPage.NoOfRollsInput.sendKeys("8");
        adminPanelPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.RollNameError), "Required RollName.");
    }

    @Test
    public void VerifyThatIfRollNameFieldIsAcceptingAlphabetsAndSpacesInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.AddButton.click();
        Thread.sleep(3000);
        adminPanelPage.RollNameInput.sendKeys("AAqw ds");
        Assert.assertFalse(Utils.IsElementDisplayed(driver, adminPanelPage.RollNameError));
    }

    @Test
    public void VerifyThatIfRollNameFieldIsNotAcceptingNumbersInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.AddButton.click();
        Thread.sleep(3000);
        adminPanelPage.RollNameInput.sendKeys("76766 #@#@");
        adminPanelPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.RollNameError), "Required RollName.");
    }

    @Test
    public void VerifyThatIfNoOfRollsFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();
        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("");
        adminPanelPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.NoOfRollError), "No_Of_Rolls Required");
    }

    @Test
    public void VerifyThatIfNoOfRollsFieldIsAcceptingNumbersInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();
        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("67587");
        adminPanelPage.CreateUpdateButton.click();
        Assert.assertFalse(Utils.IsElementDisplayed(driver, adminPanelPage.NoOfRollError));
    }

    @Test
    public void VerifyThatIfNoOfRollsFieldIsNotAcceptingAlphabetsAndSpecialCharactersInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        Thread.sleep(3000);

        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("hghfh@@");
        adminPanelPage.StatusInput.click();
        adminPanelPage.StatusOptions.get(0).click();
        adminPanelPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.NoOfRollError), "No_Of_Rolls Required");
    }

    @Test
    public void VerifyThatIfStatusFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.SubAdminNameInput.sendKeys("Expo");
        adminPanelPage.RollNameInput.sendKeys("abc");
        adminPanelPage.NoOfRollsInput.sendKeys("1");
        //adminPanelPage.StatusInput.click();

        Assert.assertFalse(adminPanelPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatIfStatusDropDownIsClickableInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.StatusInput.click();
        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("2");

        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.StatusInput));
    }

    @Test
    public void VerifyThatIfStatusDropDownHasActiveAndInActiveOptionsInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("2");
        adminPanelPage.StatusInput.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.StatusOptions.get(0)), "Active");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.StatusOptions.get(1)), "InActive");
    }

    @Test
    public void VerifyThatIfSelectedOptionIsAppearingInTheFieldInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("2");
        adminPanelPage.StatusInput.click();

        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.StatusOptions.get(0)));
    }

    @Test
    public void VerifyThatIfUserIsAbleToChangeTheOptionsInStatusFieldInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("2");
        adminPanelPage.StatusInput.click();

        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.StatusOptions.get(1)));
    }

    @Test
    public void VerifyThatCreateButtonIsDisabledIfTheFieldsAreNotFilledInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        Assert.assertFalse(adminPanelPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatCreateButtonIsEnabledIfAllTheFieldsAreFilledInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("2");
        adminPanelPage.StatusInput.click();
        adminPanelPage.StatusOptions.get(0).click();

        Assert.assertTrue(adminPanelPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatIfUserClicksCreateButtonAfterFillingAllTheFieldsItShouldNavigateToSubAdminProfilePage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Lisa", "Test", "1");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminProfileText), "Dashboard / Sub admin profile");
    }

    @Test
    public void VerifyThatIfUserIsAbleToAddNewSubAdminInSubAdminProfilePage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Jenn", "Test", "1");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminProfileText), "Dashboard / Sub admin profile");
    }

    @Test
    public void VerifyThatCreatedSubAdminDetailsArePresentInAccessManagementPage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Sanvi", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Sanvi']"))), "Sanvi");
    }

    @Test
    public void VerifyThatCreatedSubAdminListIsInChronologicalOrderAccessManagementPage() throws InterruptedException {
        String Characters = Utils.printRandomString(5);
        String Name = "Jenn" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']"))), Name);
    }

    @Test
    public void VerifyThatViewIconEditIconAndDeleteIconArePresentAccessManagementPage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(8)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcons.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcons.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcons.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.DeleteIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.DeleteIcon.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.DeleteIcon.get(2)));
    }

    @Test
    public void VerifyThatViewIconForParticularRowIsClickableInAccessManagementPage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.ViewIcon.get(8)));
    }

    @Test
    public void VerifyThatEditIconForParticularRowIsClickableInAccessManagementPage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcons.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcons.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcons.get(6)));
    }

    @Test
    public void VerifyThatAfterClickingEditIconOfARowTheDetailsShownInEditSubAdminScreenAreMatchingWithTheSelectedRow() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Jenn", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.EditIcons.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(adminPanelPage.SubAdminNameInput.getAttribute("value"), "Jenn");
    }

    @Test
    public void VerifyThatAfterEditingTheDetailsChangesAreReflectedInTheParticularRowFromTheList() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Jenn", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.EditIcons.get(0).click();

        adminPanelPage.SubAdminNameInput.clear();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Vibha", "Test", "1");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Vibha']"))), "Vibha");
    }

    @Test
    public void VerifyThatDeleteIconForParticularRowIsClickableInAccessManagementPage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.DeleteIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.DeleteIcon.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.DeleteIcon.get(6)));
    }

    @Test
    public void VerifyThatAfterClickingDeleteIconPoupScreenWithDeleteAndCancelButtonAppears() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.DeleteIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.DeletePopup), "Are you sure?");
    }

    @Test
    public void VerifyThatWhenClickedOnCancelInTheDeletePopupTheRowShouldNotGetDelete() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Ridhi", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.DeleteIcon.get(0).click();
        adminPanelPage.DeletePopupButtons.get(1).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Ridhi']"))), "Ridhi");
    }

    @Test
    public void VerifyThatWhenClickedOnDeleteInTheDeletePopupTheRowShouldGetDelete() throws InterruptedException {
        String Characters = Utils.printRandomString(5);
        String Name = "Kate" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminList.get(0)), Name);

        adminPanelPage.DeleteIcon.get(0).click();
        adminPanelPage.DeletePopupButtons.get(0).click();

        Utils.WaitForAnElementToExist(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']")));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']"))));
    }

    @Test
    public void VerifyThatUserIsAbleToCheckTheCheckBoxForAParticularRowInAccessManagementScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.CheckBoxes.get(1).click();

        Thread.sleep(3000);
        Assert.assertNull(adminPanelPage.CheckBoxes.get(1).getAttribute("checked"));
    }

    @Test
    public void VerifyThatTheCountOfTheSelectedRowsMustDisplayOnTopOfTheListInAccessManagementScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.CheckBoxes.get(1).click();
        adminPanelPage.CheckBoxes.get(2).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.RowSelected));
    }

    @Test
    public void VerifyThatIfUserClicksOnDeleteAfterSelectingMultipleRowsADeletePopupShouldAppear() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.CheckBoxes.get(1).click();
        adminPanelPage.CheckBoxes.get(2).click();
        adminPanelPage.RowSelectedDelete.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.DeletePopup), "Are you sure?");
    }

    @Test
    public void VerifyThatWhenClickedOnDeleteInTheDeletePopupTheRowsShouldGetDelete() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Jenn" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.CheckBoxes.get(1).click();
        adminPanelPage.CheckBoxes.get(2).click();
        adminPanelPage.RowSelectedDelete.click();
        adminPanelPage.DeletePopupButtons.get(0);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']"))));
    }

    @Test
    public void VerifyThatIfUserIsAbleToViewNextAvailableRowsByClickingLeftArrowInAccessManagementPage() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.NextPageIcon.click();

        Thread.sleep(3000);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));
    }

    @Test
    public void VerifyThatIfUserIsAbleToClickLeftAndRightArrowsToNavigateBetweenPreviousAndNextListOfRows() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.NextPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));

        adminPanelPage.PreviousPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 1 ']"))));
    }

    @Test
    public void VerifyThatWhenClickedOnLeftArrowColumnNoShouldContinueTheOrderInAccessManagementScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.NextPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));
    }

    @Test
    public void VerifyThatNumberOfRowsPresentInTheListIsMatchingWithTotalRows() throws InterruptedException {

        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        int Total = Utils.extractMaximum(adminPanelPage.TotalRows.getText());

        String TotalRows = Integer.toString(Total);

        int Count = Utils.extractMaximum(adminPanelPage.RowsRange.getText());

        String RowCount = Integer.toString(Count);
        Thread.sleep(3000);

        Assert.assertEquals((TotalRows), RowCount);
    }

    @Test
    public void VerifyThatAllCheckboxesOfTheRowsAreCheckedUponClickingOnNoCheckBox() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.CheckBoxes.get(0).click();

        Assert.assertNull(adminPanelPage.CheckBoxes.get(2).getAttribute("checked"));
        Assert.assertNull(adminPanelPage.CheckBoxes.get(3).getAttribute("checked"));
        Assert.assertNull(adminPanelPage.CheckBoxes.get(5).getAttribute("checked"));
    }

    @Test
    public void VerifyThatIfTheSearchBarFieldIsClickableAndEditable() throws InterruptedException {

        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.SearchInput.sendKeys("Cind");

        Assert.assertEquals(adminPanelPage.SearchInput.getAttribute("value"), "Cind");
    }

    @Test
    public void VerifyThatIfSearchBarFieldIsAcceptingAlphabetsAndListingOutRowsWhichMatchesWithName() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Jenn" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.SearchInput.sendKeys(Name);

        Assert.assertEquals(adminPanelPage.SearchInput.getAttribute("value"), Name);
    }

    @Test
    public void VerifyThatWhenTheUserClicksOnViewIconItNavigatesToSubAdminProfileScreen() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Tarley" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminProfileText), "Dashboard / Sub admin profile");
    }

    @Test
    public void VerifyThatSubAdminProfileScreenHasProfilePictureNameAndRollNameEditOptionAndStatusOfActiveInactive() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminProfilePic));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminTitleText));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminSubTitleText));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminEditIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminActiveInactiveText));
    }

    @Test
    public void VerifyThatThereIsChooseFileOptionToUploadAProfilePic() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminChooseFile));
    }

    @Test
    public void VerifyThatSelectedFileIsUploadedOnTheProfileScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        adminPanelPage.SubAdminChooseFile.sendKeys("D:\\admin1.jpeg");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminChooseFile));
    }

    @Test
    public void VerifyThatEditIconIsClickable() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminEditIcon.get(0)));
    }

    @Test
    public void VerifyThatEditSubAdminScreenHasAllTheRequiredFields() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        adminPanelPage.SubAdminEditIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.RollNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.NoOfRollsInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.StatusInput));
    }

    @Test
    public void VerifyThatEditSubAdminScreenCanBeEdited() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        adminPanelPage.SubAdminEditIcon.get(0).click();

        adminPanelPage.SubAdminNameInput.clear();
        adminPanelPage.RollNameInput.clear();
        adminPanelPage.NoOfRollsInput.clear();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminList.get(0)), Name);
    }

    @Test
    public void VerifyThatUpdateButtonIsEnabledAfterEditingTheFields() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        adminPanelPage.SubAdminEditIcon.get(0).click();

        Thread.sleep(3000);
        adminPanelPage.SubAdminNameInput.clear();
        adminPanelPage.RollNameInput.clear();
        adminPanelPage.NoOfRollsInput.clear();

        adminPanelPage.SubAdminNameInput.sendKeys("Jiha");
        adminPanelPage.RollNameInput.sendKeys("Edit");
        adminPanelPage.NoOfRollsInput.sendKeys("2");
        adminPanelPage.StatusInput.click();
        adminPanelPage.StatusOptions.get(0).click();

        Assert.assertTrue(adminPanelPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatUpdateButtonIsClickableAfterEditingTheFields() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        adminPanelPage.SubAdminEditIcon.get(0).click();

        Thread.sleep(3000);
        adminPanelPage.SubAdminNameInput.clear();
        adminPanelPage.RollNameInput.clear();
        adminPanelPage.NoOfRollsInput.clear();

        adminPanelPage.SubAdminNameInput.sendKeys("Jiha");
        adminPanelPage.RollNameInput.sendKeys("Edit");
        adminPanelPage.NoOfRollsInput.sendKeys("2");
        adminPanelPage.StatusInput.click();
        adminPanelPage.StatusOptions.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.CreateUpdateButton));
    }

    @Test
    public void VerifyThatIfAnySubAdminDetailsAreEditedItShouldBeReflectedOnAccessManagementHomePageAndUpdatedOnSubAdminProfilePage() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Dany" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        adminPanelPage.SubAdminEditIcon.get(0).click();

        Thread.sleep(3000);
        adminPanelPage.SubAdminNameInput.clear();
        adminPanelPage.RollNameInput.clear();
        adminPanelPage.NoOfRollsInput.clear();

        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminList.get(0)), Name);
    }

    @Test
    public void VerifyThatEditSubAdminScreenHasCloseIcon() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.EditIcons.get(0).click();

        Thread.sleep(3000);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.CloseIcon));
    }

    @Test
    public void VerifyThatInEditSubAdminScreenCloseIconIsClickable() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.EditIcons.get(0).click();

        Thread.sleep(3000);

        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.CloseIcon));
    }

    @Test
    public void VerifyIsUserCanSeeThreeTabsInSubAdminProfileScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminProfileTabs.get(0)), "BASIC INFORMATION");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminProfileTabs.get(1)), "EDUCATION & EXPERIENCE");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminProfileTabs.get(2)), "DOCUMENTS");
    }

    @Test
    public void VerifyIsUserCanSeeTwoHeadingsInBasicInfoTabInSubAdminProfileScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();
        adminPanelPage.SubAdminProfileTabs.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.BasicInfoHeadings.get(0)), "About");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.BasicInfoHeadings.get(1)), "Contact");
    }

    @Test
    public void VerifyIfTheUserIsAbleToSeeTheEditIconInAboutHeadingOfBasicInformationTab() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminEditIcon.get(1)));
    }

    @Test
    public void VerifyIfTheAboutHeadingOfBasicInformationTabHasAllTheRequiredFields() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(7)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(8)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.BasicInformationFields.get(9)));
    }

    @Test
    public void VerifyIfTheUserClicksOnTheEditIconInBasicInformationTabEditSubAdminScreenMustAppear() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminTitleText);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminTitleText));
    }

    @Test
    public void VerifyIfTheUserClicksOnTheEditIconInBasicInformationTabEditSubAdminPopUpHasAllTheRequiredFields() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminFirstName);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminFirstName));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminMiddleName));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminLastName));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminDOB));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminEmail));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminMobile));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminBloodGroup));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminGender));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminBiography));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminAddress));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminCity));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminPicCode));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminState));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminCountry));
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingNumbers() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("765765", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("@#%^&*()", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingBothNumbersSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("@#768768%^&*()", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingBothUpperCaseAndLowerCase() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("JiyA", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Ji ya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingNumbers() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "775765", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "@@@@@@@^*&^()_", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsLeftEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingBothNumbersSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminFirstName.click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "*&^&*(7675", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingBothUpperCaseAndLowerCase() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("JiyA", "JedG", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Je ed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingNumbers() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "767576", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "%%%%%%^%**(@#!", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsLeftEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingBothNumbersSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "6575*&^%#@!", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingBothUpperCaseAndLowerCase() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("JiyA", "Jed", "JonG", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "Jo ne", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertTrue(adminPanelPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        adminPanelPage.FillAllTheFieldsInEditSubAdminScreenAndClickUpdate("Jiya", "Jed", "", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpHasCalenderIconAtTheRight() throws InterruptedException {
            String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminDOBPicker));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpHasCalenderIconIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.SubAdminDOBPicker));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpShowsCurrentMonthAndYearCalenderByDefault() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminDOBPicker.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.CalenderMonthYear));
    }

    @Test
    public void VerifyIfCalenderInTheDateOfBirthFieldInEditSubAdminPoUpHasLeftAndRightArrows() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminDOBPicker.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.NextMonthIcon));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.PreviousMonthIcon));
    }

    @Test
    public void VerifyIfCalenderInTheDateOfBirthFieldInEditSubAdminPoUpTheLeftAndRightArrowsAreClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminDOBPicker.click();
        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.NextMonthIcon));
        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.PreviousMonthIcon));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpShowsNextMonthAndYearCalenderWhenClickedNextArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminDOBPicker.click();
        adminPanelPage.NextMonthIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.CalenderMonthYear));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpShowsPreviousMonthAndYearCalenderWhenClickedPreviousArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminDOBPicker.click();
        adminPanelPage.PreviousMonthIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.CalenderMonthYear));
    }

    @Test
    public void VerifyIfInDateOfBirthFieldInEditSubAdminPoUpMothAndYearDropDownArrowIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, adminPanelPage.AddButton);
        adminPanelPage.AddButton.click();
        adminPanelPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        adminPanelPage.AccessManagementTab.click();

        Thread.sleep(3000);
        adminPanelPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, adminPanelPage.SubAdminEditIcon.get(1));
        adminPanelPage.SubAdminEditIcon.get(1).click();

        adminPanelPage.SubAdminDOBPicker.click();
        Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.CalenderMonthYear));
    }
}