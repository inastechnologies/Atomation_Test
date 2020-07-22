package Tests;

import Pages.AdminPanelPage;
import Utils.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
    public void VerifyThatQnatureLogoAskBookFindIconsAccessManagementTabArePresent() throws InterruptedException {
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

        adminPanelPage.ClickEveryFieldInSubAdminScreenBeforeEnteringDetails();

       // Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.SubAdminNameInput));
       // Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.RollNameInput));
       // Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.NoOfRollsInput));
        //Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.StatusInput));
       // Assert.assertTrue(Utils.isClickable(driver, adminPanelPage.SubAdminCreateButton));
    }

    @Test
    public void VerifyThatIfSubAdminNameFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);

        adminPanelPage.AddButton.click();
        adminPanelPage.SubAdminCreateButton.click();

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
        adminPanelPage.SubAdminCreateButton.click();

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
        adminPanelPage.SubAdminCreateButton.click();

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
        adminPanelPage.SubAdminCreateButton.click();

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
        adminPanelPage.SubAdminCreateButton.click();

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
        adminPanelPage.SubAdminCreateButton.click();
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
        adminPanelPage.SubAdminCreateButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.NoOfRollError), "No_Of_Rolls Required");
    }

    @Test
    public void VerifyThatIfStatusFieldIsMandatoryInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        adminPanelPage.StatusInput.click();
        adminPanelPage.SubAdminNameInput.sendKeys("ghfhgfh");
        adminPanelPage.RollNameInput.sendKeys("yugj");
        adminPanelPage.NoOfRollsInput.sendKeys("2");
       // adminPanelPage.StatusInput.click();
        //adminPanelPage.SubAdminCreateButton.click();

        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.StatusError), "Required status.");
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

        Assert.assertFalse(adminPanelPage.SubAdminCreateButton.isEnabled());
    }

    @Test
    public void VerifyThatCreateButtonIsEnabledIfallTheFieldsAreFilledInAddSubAdminScreen() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");

        Thread.sleep(3000);
        adminPanelPage.AddButton.click();

        Assert.assertFalse(adminPanelPage.SubAdminCreateButton.isEnabled());
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
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Sanvi']"))), "Sanvi");
    }

    @Test
    public void VerifyThatCreatedSubAdminListIsInChronologicalOrderAccessManagementPage() throws InterruptedException {
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
       // Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//td[text()='Sanvi']"))), "Sanvi");
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
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcon.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcon.get(6)));
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
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcon.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcon.get(5)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, adminPanelPage.EditIcon.get(6)));
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
        adminPanelPage.EditIcon.get(0).click();

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
        adminPanelPage.EditIcon.get(0).click();

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
}