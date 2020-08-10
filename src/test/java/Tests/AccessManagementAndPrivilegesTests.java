package Tests;

import Pages.AccessManagementAndPrivilegesPage;
import Utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


public class AccessManagementAndPrivilegesTests {
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
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.AdminPanelText), "Welcome To Admin");
    }

    @Test
    public void VerifyThatUserCanLoginWithValidUserNamePassword() {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.AccessManagementAndPrivilegesText), "Access Management & Privileges");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithInvalidUsernameAndValidPassword() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("98661761", "Thannidi@270116");

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@");

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithInvalidUsernameAndInvalidPassword() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("98661761", "Thannidi@");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithEmptyFieldsOfUsernameAndPasswordFields() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("", "");

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatQNatureLogoAskBookFindIconsAccessManagementTabArePresent() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.QNatureLogo));
        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.HeaderIcons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.HeaderIcons.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.HeaderIcons.get(2)));
    }

    @Test
    public void VerifyThatAllTheRequiredFieldsArePresentInAccessManagementAndPrivilegesScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.TotalRows));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SearchInput));

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ColumnHeader.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ColumnHeader.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ColumnHeader.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ColumnHeader.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ColumnHeader.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ColumnHeader.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ColumnHeader.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.AddButton));
    }

    @Test
    public void VerifyThatWhenClickedOnAddButtonItDisplaysAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.AddSubAdminText), "ADD SUB-ADMIN");
    }

    @Test
    public void VerifyThatAddSubAdminScreenHasAllTheRequiredFieldsAndCreateButtonIsClickable() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.RollNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.NoOfRollsInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.StatusInput));
        Assert.assertFalse(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CreateUpdateButton));
    }

    @Test
    public void VerifyThatIfSubAdminNameFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.RollNameInput.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminNameError), "Person Name Required field.");
    }

    @Test
    public void VerifyThatIfSubAdminNameFieldIsAcceptingAlphabetsAndSpacesInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ASD asd");
        Assert.assertFalse(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminNameError));
    }

    @Test
    public void VerifyThatIfSubAdminNameFieldIsNotAcceptingNumbersInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("76766 #@#@");
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminNameError), "Person Name Required field.");
    }

    @Test
    public void VerifyThatIfRollNameFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.click();
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("8");
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.RollNameError), "Required RollName.");
    }

    @Test
    public void VerifyThatIfRollNameFieldIsAcceptingAlphabetsAndSpacesInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("AAqw ds");
        Assert.assertFalse(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.RollNameError));
    }

    @Test
    public void VerifyThatIfRollNameFieldIsNotAcceptingNumbersInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("76766 #@#@");
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.RollNameError), "Required RollName.");
    }

    @Test
    public void VerifyThatIfNoOfRollsFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("");
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.NoOfRollError), "No_Of_Rolls Required");
    }

    @Test
    public void VerifyThatIfNoOfRollsFieldIsAcceptingNumbersInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("67587");
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertFalse(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.NoOfRollError));
    }

    @Test
    public void VerifyThatIfNoOfRollsFieldIsNotAcceptingAlphabetsAndSpecialCharactersInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("hghfh@@");
        accessManagementAndPrivilegesPage.StatusInput.click();
        accessManagementAndPrivilegesPage.StatusOptions.get(0).click();
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.NoOfRollError), "No_Of_Rolls Required");
    }

    @Test
    public void VerifyThatIfStatusFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("Expo");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("abc");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("1");
        //adminPanelPage.StatusInput.click();

        Assert.assertFalse(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatIfStatusDropDownIsClickableInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.StatusInput.click();
        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.StatusInput));
    }

    @Test
    public void VerifyThatIfStatusDropDownHasActiveAndInActiveOptionsInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");
        accessManagementAndPrivilegesPage.StatusInput.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.StatusOptions.get(0)), "Active");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.StatusOptions.get(1)), "InActive");
    }

    @Test
    public void VerifyThatIfSelectedStatusOptionIsAppearingInTheFieldInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");
        accessManagementAndPrivilegesPage.StatusInput.click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.StatusOptions.get(0)));
    }

    @Test
    public void VerifyThatIfUserIsAbleToChangeTheOptionsInStatusFieldInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");
        accessManagementAndPrivilegesPage.StatusInput.click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.StatusOptions.get(1)));
    }

    @Test
    public void VerifyThatCreateButtonIsDisabledIfTheFieldsAreNotFilledInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        Assert.assertFalse(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatCreateButtonIsEnabledIfAllTheFieldsAreFilledInAddSubAdminScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("ghfhgfh");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("yugj");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");
        accessManagementAndPrivilegesPage.StatusInput.click();
        accessManagementAndPrivilegesPage.StatusOptions.get(0).click();

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatIfUserClicksCreateButtonAfterFillingAllTheFieldsItShouldNavigateToSubAdminProfilePage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Lisa", "Test", "1");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminProfileText), "Dashboard / Sub admin profile");
    }

    @Test
    public void VerifyThatIfUserIsAbleToAddNewSubAdminInSubAdminProfilePage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Jenn", "Test", "1");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminProfileText), "Dashboard / Sub admin profile");
    }

    @Test
    public void VerifyThatCreatedSubAdminDetailsArePresentInAccessManagementPage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Sanvi", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Sanvi']"))), "Sanvi");
    }

    @Test
    public void VerifyThatCreatedSubAdminListIsInChronologicalOrderAccessManagementPage() throws InterruptedException {
        String Characters = Utils.printRandomString(5);
        String Name = "Jenn" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']"))), Name);
    }

    @Test
    public void VerifyThatViewIconEditIconAndDeleteIconArePresentAccessManagementPage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(8)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EditIcons.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EditIcons.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EditIcons.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DeleteIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DeleteIcon.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DeleteIcon.get(2)));
    }

    @Test
    public void VerifyThatViewIconForParticularRowIsClickableInAccessManagementPage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ViewIcon.get(8)));
    }

    @Test
    public void VerifyThatEditIconForParticularRowIsClickableInAccessManagementPage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EditIcons.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EditIcons.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EditIcons.get(6)));
    }

    @Test
    public void VerifyThatAfterClickingEditIconOfARowTheDetailsShownInEditSubAdminScreenAreMatchingWithTheSelectedRow() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Jenn", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.EditIcons.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(accessManagementAndPrivilegesPage.SubAdminNameInput.getAttribute("value"), "Jenn");
    }

    @Test
    public void VerifyThatAfterEditingTheDetailsChangesAreReflectedInTheParticularRowFromTheList() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Jenn", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.EditIcons.get(0).click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Vibha", "Test", "1");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Vibha']"))), "Vibha");
    }

    @Test
    public void VerifyThatDeleteIconForParticularRowIsClickableInAccessManagementPage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DeleteIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DeleteIcon.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DeleteIcon.get(6)));
    }

    @Test
    public void VerifyThatAfterClickingDeleteIconPoupScreenWithDeleteAndCancelButtonAppears() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        accessManagementAndPrivilegesPage.DeleteIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.DeletePopup), "Are you sure?");
    }

    @Test
    public void VerifyThatWhenClickedOnCancelInTheDeletePopupTheRowShouldNotGetDelete() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate("Ridhi", "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.DeleteIcon.get(0).click();
        accessManagementAndPrivilegesPage.DeletePopupButtons.get(1).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Ridhi']"))), "Ridhi");
    }

    @Test
    public void VerifyThatWhenClickedOnDeleteInTheDeletePopupTheRowShouldGetDelete() throws InterruptedException {
        String Characters = Utils.printRandomString(5);
        String Name = "Kate" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminList.get(0)), Name);

        accessManagementAndPrivilegesPage.DeleteIcon.get(0).click();
        accessManagementAndPrivilegesPage.DeletePopupButtons.get(0).click();

        Utils.WaitForAnElementToExist(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']")));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']"))));
    }

    @Test
    public void VerifyThatUserIsAbleToCheckTheCheckBoxForAParticularRowInAccessManagementScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CheckBoxes.get(1).click();

        Thread.sleep(3000);
        Assert.assertNull(accessManagementAndPrivilegesPage.CheckBoxes.get(1).getAttribute("checked"));
    }

    @Test
    public void VerifyThatTheCountOfTheSelectedRowsMustDisplayOnTopOfTheListInAccessManagementScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CheckBoxes.get(1).click();
        accessManagementAndPrivilegesPage.CheckBoxes.get(2).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.RowSelected));
    }

    @Test
    public void VerifyThatIfUserClicksOnDeleteAfterSelectingMultipleRowsADeletePopupShouldAppear() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CheckBoxes.get(1).click();
        accessManagementAndPrivilegesPage.CheckBoxes.get(2).click();
        accessManagementAndPrivilegesPage.RowSelectedDelete.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.DeletePopup), "Are you sure?");
    }

    @Test
    public void VerifyThatWhenClickedOnDeleteInTheDeletePopupTheRowsShouldGetDelete() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Jenn" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CheckBoxes.get(1).click();
        accessManagementAndPrivilegesPage.CheckBoxes.get(2).click();
        accessManagementAndPrivilegesPage.RowSelectedDelete.click();
        accessManagementAndPrivilegesPage.DeletePopupButtons.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()='" + Name + "']"))));
    }

    @Test
    public void VerifyThatIfUserIsAbleToViewNextAvailableRowsByClickingLeftArrowInAccessManagementPage() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        accessManagementAndPrivilegesPage.NextPageIcon.click();

        Thread.sleep(3000);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));
    }

    @Test
    public void VerifyThatIfUserIsAbleToClickLeftAndRightArrowsToNavigateBetweenPreviousAndNextListOfRows() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        accessManagementAndPrivilegesPage.NextPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));

        accessManagementAndPrivilegesPage.PreviousPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 1 ']"))));
    }

    @Test
    public void VerifyThatWhenClickedOnLeftArrowColumnNoShouldContinueTheOrderInAccessManagementScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        accessManagementAndPrivilegesPage.NextPageIcon.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//td[text()=' 11 ']"))));
    }

    @Test
    public void VerifyThatNumberOfRowsPresentInTheListIsMatchingWithTotalRows() throws InterruptedException {

        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        int Total = Utils.extractMaximum(accessManagementAndPrivilegesPage.TotalRows.getText());

        String TotalRows = Integer.toString(Total);

        int Count = Utils.extractMaximum(accessManagementAndPrivilegesPage.RowsRange.getText());

        String RowCount = Integer.toString(Count);
        Thread.sleep(3000);

        Assert.assertEquals((TotalRows), RowCount);
    }

    @Test
    public void VerifyThatAllCheckboxesOfTheRowsAreCheckedUponClickingOnNoCheckBox() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CheckBoxes.get(0).click();

        Assert.assertNull(accessManagementAndPrivilegesPage.CheckBoxes.get(2).getAttribute("checked"));
        Assert.assertNull(accessManagementAndPrivilegesPage.CheckBoxes.get(3).getAttribute("checked"));
        Assert.assertNull(accessManagementAndPrivilegesPage.CheckBoxes.get(5).getAttribute("checked"));
    }

    @Test
    public void VerifyThatIfTheSearchBarFieldIsClickableAndEditable() throws InterruptedException {

        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SearchInput.sendKeys("Cind");

        Assert.assertEquals(accessManagementAndPrivilegesPage.SearchInput.getAttribute("value"), "Cind");
    }

    @Test
    public void VerifyThatIfSearchBarFieldIsAcceptingAlphabetsAndListingOutRowsWhichMatchesWithName() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Jenn" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SearchInput.sendKeys(Name);

        Assert.assertEquals(accessManagementAndPrivilegesPage.SearchInput.getAttribute("value"), Name);
    }

    @Test
    public void VerifyThatWhenTheUserClicksOnViewIconItNavigatesToSubAdminProfileScreen() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Tarley" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Test", "1");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminProfileText), "Dashboard / Sub admin profile");
    }

    @Test
    public void VerifyThatSubAdminProfileScreenHasProfilePictureNameAndRollNameEditOptionAndStatusOfActiveInactive() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminProfilePic));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTitleText));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminSubTitleText));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminActiveInactiveText));
    }

    @Test
    public void VerifyThatThereIsChooseFileOptionToUploadAProfilePic() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ChooseFile.get(0)));
    }

    @Test
    public void VerifyThatSelectedFileIsUploadedOnTheProfileScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.ChooseFile.get(0).sendKeys("D:\\admin1.jpeg");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ChooseFile.get(0)));
    }

    @Test
    public void VerifyThatEditIconIsClickable() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0)));
    }

    @Test
    public void VerifyThatEditSubAdminScreenHasAllTheRequiredFields() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.RollNameInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.NoOfRollsInput));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.StatusInput));
    }

    @Test
    public void VerifyThatEditSubAdminScreenCanBeEdited() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();
        accessManagementAndPrivilegesPage.RollNameInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminList.get(0)), Name);
    }

    @Test
    public void VerifyThatSubAdminNameFieldEditSubAdminScreenIsAcceptingAlphabetsAndSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");


        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("Jiha");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("Edit");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");
        accessManagementAndPrivilegesPage.StatusInput.click();
        accessManagementAndPrivilegesPage.StatusOptions.get(0).click();

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatSubAdminNameFieldEditSubAdminScreenIsNotAcceptingNumbersAndSplChars() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");


        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("*&(76868^)");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminList.get(0)), "SubAmnin Name reqired");
    }

    @Test
    public void VerifyThatSubAdminNameFieldEditSubAdminScreenIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();

        accessManagementAndPrivilegesPage.RollNameInput.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminNameError), "Person Name Required field.");
    }

    @Test
    public void VerifyThatRollNameFieldEditSubAdminScreenIsAcceptingAlphabetsAndSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");


        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("Edit");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatRollNameFieldEditSubAdminScreenIsNotAcceptingNumbersAndSplChars() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.RollNameInput.clear();

        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("*&(76868^)");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminList.get(0)), "Roll Name reqired");
    }

    @Test
    public void VerifyThatRollNameFieldEditSubAdminScreenIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.RollNameInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminNameError), "Roll Name Required field.");
    }

    @Test
    public void VerifyThatNoOfRollsFieldEditSubAdminScreenIsAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("3");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatNoOfRollsFieldEditSubAdminScreenIsNotAcceptingAlphabetsAndSpecialChars() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("yutyu&*&*");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("cfgc");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminNameError), "No of roll Required.");
    }

    @Test
    public void VerifyThatNoOfRollsFieldEditSubAdminScreenIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminNameError), "No of roll Required.");
    }


    @Test
    public void VerifyThatIfAllFieldsAreEmptyUpdateButtonIsDisabled() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();
        accessManagementAndPrivilegesPage.RollNameInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();

        Assert.assertFalse(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatUpdateButtonIsEnabledAfterEditingTheFields() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();
        accessManagementAndPrivilegesPage.RollNameInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("Jiha");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("Edit");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");
        accessManagementAndPrivilegesPage.StatusInput.click();
        accessManagementAndPrivilegesPage.StatusOptions.get(0).click();

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyThatUpdateButtonIsClickableAfterEditingTheFields() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();
        accessManagementAndPrivilegesPage.RollNameInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();

        accessManagementAndPrivilegesPage.SubAdminNameInput.sendKeys("Jiha");
        accessManagementAndPrivilegesPage.RollNameInput.sendKeys("Edit");
        accessManagementAndPrivilegesPage.NoOfRollsInput.sendKeys("2");
        accessManagementAndPrivilegesPage.StatusInput.click();
        accessManagementAndPrivilegesPage.StatusOptions.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CreateUpdateButton));
    }

    @Test
    public void VerifyThatIfAnySubAdminDetailsAreEditedItShouldBeReflectedOnAccessManagementHomePageAndUpdatedOnSubAdminProfilePage() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Dany" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(0).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminNameInput.clear();
        accessManagementAndPrivilegesPage.RollNameInput.clear();
        accessManagementAndPrivilegesPage.NoOfRollsInput.clear();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.AccessManagementTab.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminList.get(0)), Name);
    }

    @Test
    public void VerifyThatEditSubAdminScreenHasCloseIcon() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.EditIcons.get(0).click();

        Thread.sleep(3000);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CloseIcon));
    }

    @Test
    public void VerifyThatInEditSubAdminScreenCloseIconIsClickable() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.EditIcons.get(0).click();

        Thread.sleep(3000);

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CloseIcon));
    }

    @Test
    public void VerifyIsUserCanSeeThreeTabsInSubAdminProfileScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(0)), "BASIC INFORMATION");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1)), "EDUCATION & EXPERIENCE");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2)), "DOCUMENTS");
    }

    @Test
    public void VerifyIsUserCanSeeTwoHeadingsInBasicInfoTabInSubAdminProfileScreen() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(0)), "About");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(1)), "Contact");
    }

    @Test
    public void VerifyIfTheUserIsAbleToSeeTheEditIconInAboutHeadingOfBasicInformationTab() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1)));
    }

    @Test
    public void VerifyIfTheAboutHeadingOfBasicInformationTabHasAllTheRequiredFields() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(6)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(7)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(8)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.BasicInformationFields.get(9)));
    }

    @Test
    public void VerifyIfTheUserClicksOnTheEditIconInBasicInformationTabEditSubAdminScreenMustAppear() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1));
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.SubAdminTitleText);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTitleText));
    }

    @Test
    public void VerifyIfTheUserClicksOnTheEditIconInBasicInformationTabEditSubAdminPopUpHasAllTheRequiredFields() throws InterruptedException {
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.ViewIcon.get(0).click();

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1));
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.SubAdminFirstName);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminFirstName));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminMiddleName));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminLastName));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminDOB));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminEmail));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminMobile));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminBloodGroup));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminGender));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminBiography));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminAddress));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminCity));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminPicCode));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminState));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminCountry));
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingNumbers() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminFirstName.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("765765", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminFirstName.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("@#%^&*()", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminFirstName.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingBothNumbersSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminFirstName.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("@#768768%^&*()", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingBothUpperCaseAndLowerCase() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("JiyA", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Ji ya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheFirstNameFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "First_Name Required");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingNumbers() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "775765", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "@@@@@@@^*&^()_", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsLeftEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingBothNumbersSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "*&^&*(7675", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingBothUpperCaseAndLowerCase() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("JiyA", "JedG", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Je ed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheMiddleNameFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Middle_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "Jon", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingNumbers() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "767576", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "%%%%%%^%**(@#!", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsLeftEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingBothNumbersSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "6575*&^%#@!", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingBothUpperCaseAndLowerCase() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("JiyA", "Jed", "JonG", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "Jo ne", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheLastNameFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Last_Name Required .");
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpHasCalenderIconAtTheRight() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminDOBPicker));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpHasCalenderIconIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.SubAdminDOBPicker);
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.SubAdminDOBPicker));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpShowsCurrentMonthAndYearCalenderByDefault() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
    }

    @Test
    public void VerifyIfCalenderInTheDateOfBirthFieldInEditSubAdminPoUpHasLeftAndRightArrows() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.SubAdminDOBPicker);
        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderRightArrow));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderLeftArrow));
    }

    @Test
    public void VerifyIfCalenderInTheDateOfBirthFieldInEditSubAdminPoUpTheLeftAndRightArrowsAreClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.SubAdminDOBPicker);
        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CalenderRightArrow));
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CalenderLeftArrow));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpShowsNextMonthAndYearCalenderWhenClickedNextArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderRightArrow.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
    }

    @Test
    public void VerifyIfTheDateOfBirthFieldInEditSubAdminPoUpShowsPreviousMonthAndYearCalenderWhenClickedPreviousArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderLeftArrow.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
    }

    @Test
    public void VerifyIfInDateOfBirthFieldInEditSubAdminPoUpMothAndYearDropDownArrowIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CalenderHeading));
    }

    @Test
    public void VerifyWhenClickedOnDropDownArrowInDateOfBirthFieldInEditSubAdminPoUpTheListOfYearsAreShown() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderHeading.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderRightArrow));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderLeftArrow));
    }

    @Test
    public void VerifyWhenClickedOnLeftArrowInDateOfBirthFieldInEditSubAdminPoUpTheListOfPreviousYearsAreShown() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderRightArrow.click();
        accessManagementAndPrivilegesPage.CalenderLeftArrow.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
    }

    @Test
    public void VerifyWhenClickedOnRightArrowInDateOfBirthFieldInEditSubAdminPoUpTheListOfNextYearsAreShown() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderRightArrow.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
    }

    @Test
    public void VerifyIfUserCanSelectParticularYearFromCalenderInDateOfBirthFieldInEditSubAdminPoUp() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
    }

    @Test
    public void VerifyInDateOfBirthFieldWhenUserSelectsParticularYearItDisplaysTheYearScreenWithListOfMonthsAndLeftAndRightArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();

        Assert.assertTrue(Utils.ElementsDisplayed(driver, accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderLeftArrow));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderRightArrow));
    }

    @Test
    public void VerifyInDateOfBirthFieldWhenTheUserClicksOnLeftArrowPreviousYearScreenWithMonthsShouldBeVisible() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderLeftArrow.click();

        Assert.assertTrue(Utils.ElementsDisplayed(driver, accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths));
    }

    @Test
    public void VerifyInDateOfBirthFieldWhenTheUserClicksOnRightArrowNextYearScreenWithMonthsShouldBeVisible() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderRightArrow.click();

        Assert.assertTrue(Utils.ElementsDisplayed(driver, accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths));
    }

    @Test
    public void VerifyInDateOfBirthFieldWhenTheMonthIsSelectedInCalenderItShowsTheSelectedYearAndMonthWithLeftAndRightArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderHeading));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderRightArrow));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CalenderLeftArrow));
    }

    @Test
    public void VerifyInDateOfBirthFieldWhenTheMonthIsSelectedAndTheUserClicksOnLeftAndRightArrowsItShouldDisplayMonthsCalender() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderRightArrow.click();

        Assert.assertTrue(Utils.ElementsDisplayed(driver, accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths));
    }

    @Test
    public void VerifyInDateOfBirthFieldIfUserCanSelectsParticularDateFromTheCalender() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();

        Assert.assertEquals(accessManagementAndPrivilegesPage.SubAdminDOB.getAttribute("value"), "6/6/2002");
    }

    @Test
    public void VerifyIfInDateOfBirthFieldInEditSubAdminPoUpSelectedDateMothAndYearIsDisplaying() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();


        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();

        Thread.sleep(3000);
        Assert.assertEquals(accessManagementAndPrivilegesPage.SubAdminDOB.getAttribute("value"), "6/6/2002");
    }

    @Test
    public void VerifyIfUserIdAbleToEnterDateManuallyInDateOfBirthFieldInEditSubAdminPoUp() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("", "Jed", "", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(accessManagementAndPrivilegesPage.SubAdminDOB.getAttribute("value"), "2/2/2001");
    }

    @Test
    public void VerifyIfDateOfBirthFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jiya", "Jed", "Jam", "", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Date_Of_Birth Required");
    }

    @Test
    public void VerifyIfEmailIdFieldInEditSubAdminPoUpIsAcceptingCorrectFormat() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "jiya@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfEmailIdFieldInEditSubAdminPoUpIsAcceptingBothNumericalAndAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "jiya123@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfEmailIdFieldInEditSubAdminPoUpIsAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "Jelly)   (*&^%123@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Email_Id Required");
    }

    @Test
    public void VerifyIfEmailIdFieldInEditSubAdminPoUpIsAcceptingWithoutAtSymbolAndDot() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "gmail", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Email_Id Required");
    }

    @Test
    public void VerifyIfEmailIdFieldInEditSubAdminPoUpIsMandatoryLeavingEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Email_Id Required");
    }

    @Test
    public void VerifyIfMobileNumberFieldInEditSubAdminPoUpIsAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9878767876", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfMobileNumberFieldInEditSubAdminPoUpIsAcceptingValidLengthOfTenDigits() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9878767897", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfMobileNumberFieldInEditSubAdminPoUpIsAcceptingMoreThanValidLengthOfTenDigits() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "98787678976", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfMobileNumberFieldInEditSubAdminPoUpIsAcceptingLessThanValidLengthOfTenDigits() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "987876789", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Mobile_Number Required.");
    }

    @Test
    public void VerifyIfMobileNumberFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Mobile_Number Required.");
    }

    @Test
    public void VerifyIfMobileNumberFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "#@#^9898", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Mobile_Number Required.");
    }

    @Test
    public void VerifyIfMobileNumberFieldInEditSubAdminPoUpIsLeftEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Mobile_Number Required.");
    }

    @Test
    public void VerifyIfBloodGroupFieldInEditSubAdminPoUpIsAcceptingValidData() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfBloodGroupFieldInEditSubAdminPoUpIsNotAcceptingOnlyAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "BPositive", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Blood_Group Required.");
    }

    @Test
    public void VerifyIfBloodGroupFieldInEditSubAdminPoUpIsNotAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "78898", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Blood_Group Required.");
    }

    @Test
    public void VerifyIfBloodGroupFieldInEditSubAdminPoUpIsNotAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "*&^@!", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Blood_Group Required.");
    }

    @Test
    public void VerifyIfBloodGroupFieldInEditSubAdminPoUpIsNotAcceptingInvalidData() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "a+", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Blood_Group Required.");
    }

    @Test
    public void VerifyIfBloodGroupFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "", "Tester", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Blood_Group Required.");
    }

    @Test
    public void VerifyIfGenderFieldInEditSubAdminPoUpHasDropDownArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.GenderDropDown));
    }

    @Test
    public void VerifyDropDownArrowInGenderFieldInEditSubAdminPoUpIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.GenderDropDown));
    }

    @Test
    public void VerifyInGenderFieldInEditSubAdminPoUpIfMaleAndFemaleOptionsAreThereInDropDownArrow() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        accessManagementAndPrivilegesPage.SubAdminGender.click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminGenderOptions.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminGenderOptions.get(1)));
    }

    @Test
    public void VerifyInGenderFieldInEditSubAdminPoUpIfUserCanSelectOptionsFromDropDown() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminGender.click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.SubAdminGenderOptions.get(0)));
    }

    @Test
    public void VerifyIfGenderFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminFirstName.sendKeys("Sibble");
        accessManagementAndPrivilegesPage.SubAdminMiddleName.sendKeys("Marry");
        accessManagementAndPrivilegesPage.SubAdminLastName.sendKeys("Gorge");
        accessManagementAndPrivilegesPage.SubAdminDOB.sendKeys("02/02/2001");
        accessManagementAndPrivilegesPage.SubAdminEmail.sendKeys("m05@gmail.com");
        accessManagementAndPrivilegesPage.SubAdminMobile.sendKeys("7878787878");
        accessManagementAndPrivilegesPage.SubAdminBloodGroup.sendKeys("B+");
        accessManagementAndPrivilegesPage.SubAdminBiography.sendKeys("Tester");
        accessManagementAndPrivilegesPage.SubAdminAddress.sendKeys("OakPark");
        accessManagementAndPrivilegesPage.SubAdminCity.sendKeys("Melbourne");
        accessManagementAndPrivilegesPage.SubAdminPicCode.sendKeys("5656");
        accessManagementAndPrivilegesPage.SubAdminState.sendKeys("Victoria");
        accessManagementAndPrivilegesPage.SubAdminCountry.sendKeys("Australia");

        Thread.sleep(3000);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Required status.");
    }

    @Test
    public void VerifyIfShortBiographyFieldInEditSubAdminPoUpIsAcceptingBothAlphabetsAndNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester123", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfShortBiographyFieldInEditSubAdminPoUpIsAcceptingSpecialCharactersAndSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester @ 123", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfShortBiographyFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "", "Creek Street", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Short_Biography Required.");
    }

    @Test
    public void VerifyIfAddressFieldInEditSubAdminPoUpIsAcceptingBothAlphabetsAndNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Test", "Creek Street 123", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfAddressFieldInEditSubAdminPoUpIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "@Creek Street *123", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfAddressFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "", "Melbourne", "5656", "Vic", "Australia");

        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Address Line Required .");
    }

    @Test
    public void VerifyIfCityFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "5656", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfCityFieldInEditSubAdminPoUpIsNotAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "1235", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "City Required .");
    }

    @Test
    public void VerifyIfCityFieldInEditSubAdminPoUpIsNotAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "!@#%^", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "City Required .");
    }

    @Test
    public void VerifyIfCityFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "", "5656", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "City Required .");
    }

    @Test
    public void VerifyIfPinCodeFieldInEditSubAdminPoUpIsNotAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "fdgdgfd", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Pincode Required.");
    }

    @Test
    public void VerifyIfPinCodeFieldInEditSubAdminPoUpIsAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "5678", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfPinCodeFieldInEditSubAdminPoUpIsNotAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "*&^()!@#", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Pincode Required.");
    }

    @Test
    public void VerifyIfPinCodeFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "", "Vic", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Pincode Required.");
    }

    @Test
    public void VerifyIfStateFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "Vic", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfStateFieldInEditSubAdminPoUpIsNotAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "999", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "State Required.");
    }

    @Test
    public void VerifyIfStateFieldInEditSubAdminPoUpIsNotAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "@#%^&", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "State Required.");
    }

    @Test
    public void VerifyIfStateFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "", "Australia");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "State Required.");
    }

    @Test
    public void VerifyIfCountryFieldInEditSubAdminPoUpIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "Victoria", "Australia");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfCountryFieldInEditSubAdminPoUpIsNotAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "Victoria", "67575");

        accessManagementAndPrivilegesPage.UpdateButton.click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Country Required.");
    }

    @Test
    public void VerifyIfCountryFieldInEditSubAdminPoUpIsNotAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "Victoria", "@#%^&");

        accessManagementAndPrivilegesPage.UpdateButton.click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Country Required.");
    }

    @Test
    public void VerifyIfCountryFieldInEditSubAdminPoUpIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "Victoria", "@#%^&");

        accessManagementAndPrivilegesPage.UpdateButton.click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Country Required.");
    }

    @Test
    public void VerifyIfValidDataIsEnteredInAllTheFieldsInEditSubAdminPoUpUpdateButtonShouldBeEnabled() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "Victoria", "@#%^&");

        Assert.assertTrue(accessManagementAndPrivilegesPage.UpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfValidDataIsEnteredInAllTheFieldsInEditSubAdminPoUpUpdateButtonShouldBeClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsBasicInformationHeadingInADDSubAdminDetailsScreen("Jelly", "Jed", "Jam", "02/02/2001", "m05@gmail.com", "9898989898", "B+", "Tester", "Rose creek 123", "Melbourne", "6789", "Victoria", "@#%^&");

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.UpdateButton));
    }

    @Test
    public void VerifyUserMustBeAbleToSwipeAmongTheBasicInformationEducationAndExperienceAndDocumentsInSubAdminProfilePage() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(2)));

        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(1)));
    }

    @Test
    public void VerifyUserCanSeeThreeDivisionsInEducationAndExperienceInSubAdminProfilePage() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminTabsHeadings.get(2)));
    }

    @Test
    public void VerifyIfUserCanSeeEditIconInEducationAndExperienceToAddDetails() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1)));
    }

    @Test
    public void VerifyIfUserCanSeeFieldsInAdminInfoHeadingInEducationAndExperience() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CompanyEmailField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DOJField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DepartmentField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.RollField));
    }

    @Test
    public void VerifyIfUserCanClickEditIconAdminInfoInEducationAndExperience() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1)));
    }

    @Test
    public void VerifyAddSubAdminInfoScreenAppearsIfUserCanClicksOnEditIconInAdminInfoInEducationAndExperience() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.AddSubAdminText), "ADD SUB-ADMIN INFORMATION");
    }

    @Test
    public void VerifyAddSubAdminInfoScreenHasAllTheRequiredFieldsInAdminInfoHeadingInEducationAndExperience() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CompanyEmailField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DOJField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DepartmentField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.RollField));
    }

    @Test
    public void VerifyIfAllTheFieldsInAddSubAdminInfoScreenAreClickableInAdminInfoHeading() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CompanyEmailField));
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.DOJField));
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.DepartmentField));
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.RollField));
    }

    @Test
    public void VerifyIfCreateButtonInAddSubAdminInfoScreenIsDisabledByDefaultInAdminInfoHeading() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        Assert.assertFalse(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfThereIsACloseIconInAddSubAdminInfoScreenInAdminInfoHeading() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CloseIcon));
    }

    @Test
    public void VerifyIfCloseIconIsClickableInAddSubAdminInfoScreenInAdminInfoHeading() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CloseIcon));
    }

    @Test
    public void VerifyIfCompanyEmailFieldInAdminInformationHeadingIsAcceptingCorrectFormatOfEmailId() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "Admin", "test");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfCompanyEmailFieldInAdminInformationHeadingIsAcceptingBothAlphabetsAndNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc123@gmail.com", "2/2/2020", "Admin", "test");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfCompanyEmailFieldInAdminInformationHeadingIsAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc123@gmail.com", "2/2/2020", "Admin", "test");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfCompanyEmailFieldInAdminInformationHeadingIsNotAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc123 @gmail.com", "2/2/2020", "Admin", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Company_Email Required");
    }

    @Test
    public void VerifyIfCompanyEmailFieldInAdminInformationHeadingIsNotAcceptingWithoutAtSignAndDot() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc123gmailcom", "2/2/2020", "Admin", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Company_Email Required");
    }

    @Test
    public void VerifyIfCompanyEmailFieldInAdminInformationHeadingIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("", "2/2/2020", "Admin", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Company_Email Required");
    }

    @Test
    public void VerifyIfCompanyEmailFieldInAdminInformationHeadingIsAcceptingIfItIsLeftEmpty() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("", "2/2/2020", "Admin", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Company_Email Required");
    }

    @Test
    public void VerifyIfDateOfJoiningFieldInAdminInformationHeadingIsNotAcceptingFutureYears() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2025", "Admin", "test");

        // Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Date_Of_Joining Required.");
    }

    @Test
    public void VerifyIfDateOfJoiningFieldInAdminInformationHeadingDateCanBeEnteredManually() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "Admin", "test");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfUserCanSetDateThroughCalendarInDateOfJoiningFieldInAdminInformationHeading() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.CompanyEmailField.sendKeys("abc@gmail.com");
        accessManagementAndPrivilegesPage.SubAdminDOBPicker.click();
        accessManagementAndPrivilegesPage.CalenderHeading.click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.CalenderListOfYearsAndMonths.get(5).click();
        accessManagementAndPrivilegesPage.DepartmentField.sendKeys("QA");
        accessManagementAndPrivilegesPage.RollField.sendKeys("Tester");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfDateOfJoiningFieldInAdminInformationHeadingIsNotAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "yfhgv", "Admin", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Date_Of_Joining Required.");
    }

    @Test
    public void VerifyIfDateOfJoiningFieldInAdminInformationHeadingIsNotAcceptingRandomNumbers() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "36363", "Admin", "test");

        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.SubAdminErrorMessages.get(0)), "Date_Of_Joining Required.");
    }

    @Test
    public void VerifyIfDepartmentFieldInAdminInformationHeadingIsAcceptingOnlyAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "Admin", "test");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfDepartmentFieldInAdminInformationHeadingIsNotAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "75765", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Department Required.");
    }

    @Test
    public void VerifyIfDepartmentFieldInAdminInformationHeadingIsAcceptingCombinationOfAlphabetsAndNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "abc765", "test");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfDepartmentFieldInAdminInformationHeadingIsNotAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "abc 76 5", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Department Required.");
    }

    @Test
    public void VerifyIfDepartmentFieldInAdminInformationHeadingIsNotAcceptingSpecialCharacters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "abc @#%^6 5", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Department Required.");
    }


    @Test
    public void VerifyIfDepartmentFieldInAdminInformationHeadingIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "", "test");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Department Required.");
    }

    @Test
    public void VerifyIfRollFieldInAdminInformationHeadingIsAcceptingAlphabets() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "tests", "test");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfRollFieldInAdminInformationHeadingIsNotAcceptingNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "tests", "78686");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Roll RollName Required.");
    }

    @Test
    public void VerifyIfRollFieldInAdminInformationHeadingIsAcceptingBothAlphabetsAndNumerical() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "tests", "78686");

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfRollFieldInAdminInformationHeadingIsNotAcceptingSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "tests", "tyfhg  hjgj hg");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Roll RollName Required.");
    }

    @Test
    public void VerifyIfRollFieldInAdminInformationHeadingIsNotSpecialCharters() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "tests", "@#%^");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Roll RollName Required.");
    }

    @Test
    public void VerifyIfRollFieldInAdminInformationHeadingIsMandatory() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "tests", "");
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, accessManagementAndPrivilegesPage.SubAdminErrorMessages.get(0)), "Roll RollName Required.");
    }

    @Test
    public void VerifyIfAfterFillingAllTheFieldsCreateButtonInAdminInformationHeadingIsEnabled() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.SubAdminEditIcon.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.FillAllTheFieldsOfEducationAndExperienceHeadingInADDSubAdminInformationScreen("abc@gmail.com", "2/2/2020", "Admin", "Test");
        accessManagementAndPrivilegesPage.CreateUpdateButton.click();

        Assert.assertTrue(accessManagementAndPrivilegesPage.CreateUpdateButton.isEnabled());
    }

    @Test
    public void VerifyIfTheUserIsAbleToSeeTheAddEducationDetailsButtonInTheEducationDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EduAndExpAdd.get(0)));
    }

    @Test
    public void VerifyIfAddEducationDetailsButtonIsClickableInTheEducationDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.EduAndExpAdd.get(0)));
    }

    @Test
    public void VerifyIfUsrClicksOnAddEducationDetailsButtonAPopUpAppears() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.EduAndExpAdd.get(0).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.PopUpHeadingText));
    }

    @Test
    public void VerifyIfUsrClicksOnAddEducationDetailsButtonAPopUpHasCloseIcon() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.EduAndExpAdd.get(0).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CloseIcon));
    }

    @Test
    public void VerifyIfTheUserIsAbleToSeeTheAddExperienceDetailsButtonInTheEducationDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EduAndExpAdd.get(1)));
    }

    @Test
    public void VerifyIfAddExperienceDetailsButtonIsClickableInTheEducationDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.EduAndExpAdd.get(1)));
    }

    @Test
    public void VerifyIfUsrClicksOnAddExperienceDetailsButtonAPopUpAppears() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.EduAndExpAdd.get(1).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.PopUpHeadingText));
    }

    @Test
    public void VerifyIfUserClicksOnAddExperienceDetailsButtonAPopUpHasCloseIconAndItIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.EduAndExpAdd.get(0).click();

        Thread.sleep(3000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.CloseIcon));
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.CloseIcon));
    }

    @Test
    public void VerifyIfUserCanSwipeFromEducationAndExperienceToDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();


        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DocumentsText));
    }

    @Test
    public void VerifyIfUserCanSAddButtonInDocumentsDivisionAndItIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.AddDocumentsButton));
        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.AddDocumentsButton));
    }

    @Test
    public void VerifyIfUserClickOnAddButtonInDocumentsDivisionAPopUpAppears() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.PopUpHeadingText));
    }

    @Test
    public void VerifyIfChooseFileInDocumentsDivisionIsClickable() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.ChooseFile.get(1)));
    }

    @Test
    public void VerifyIfUserCanSeeSelectedFileAfterSelectingFileInDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.ChooseFile.get(1)));
    }

    @Test
    public void VerifyIfUserCanUploadAndCancelButtonsInThePopUpInDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(1)));

    }

    @Test
    public void VerifyIfTheUserClicksOnTheUploadOptionTheSelectedFileIsUploadedInTheDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");

        accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DocumentFileName));
    }

    @Test
    public void VerifyIfCancelButtonTInThePopUpIsClickableInTheDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");

        Assert.assertTrue(Utils.isClickable(driver, accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(1)));
    }

    @Test
    public void VerifyAfterUploadingTheDocumentItHadEditAndDeleteOptionInTheDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");
        accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");
        accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.EditIcons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.DeleteIcon.get(0)));
    }

    @Test
    public void VerifyTheFileIsDeletedWhenClickedOnDeleteOptionInTheDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");
        accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Flower.jpg");
        accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.DeleteIcon.get(1).click();

        //Thread.sleep(3000);
        //Assert.assertFalse(Utils.IsElementDisplayed(driver, driver.findElement(By.xpath("//span[text()='/sub_admin_docs/Flower.jpg']"))));
    }

    @Test
    public void VerifyThePopUpAppearsWhenClickedOnEditOptionInTheDocumentsDivision() throws InterruptedException {
        String Characters = Utils.printRandomString(3);
        String Name = "Moli" + Characters;
        AccessManagementAndPrivilegesPage accessManagementAndPrivilegesPage = new AccessManagementAndPrivilegesPage(driver);
        accessManagementAndPrivilegesPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Utils.WaitForAnElementToExist(driver, accessManagementAndPrivilegesPage.AddButton);
        accessManagementAndPrivilegesPage.AddButton.click();
        accessManagementAndPrivilegesPage.FillAllTheFieldsInAddSubAdminScreenAndClickCreate(Name, "Edit", "2");

        Thread.sleep(3000);
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(1).click();
        accessManagementAndPrivilegesPage.SubAdminProfileTabs.get(2).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Sample document.jpg");
        accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.AddDocumentsButton.click();
        accessManagementAndPrivilegesPage.ChooseFile.get(1).sendKeys("D:\\Flower.jpg");
        accessManagementAndPrivilegesPage.DocumentsUploadAndCancel.get(0).click();

        Thread.sleep(2000);
        accessManagementAndPrivilegesPage.EditIcons.get(1).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, accessManagementAndPrivilegesPage.PopUpHeadingText));
    }
}