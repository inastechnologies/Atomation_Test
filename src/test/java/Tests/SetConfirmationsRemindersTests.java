package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetConfirmationsRemindersTests extends BaseTest {

    @Test
    public void VerifyAfterCreatingEventsOrAppointmentTypesUserCanNavigateToSetConfirmationsOrRemindersPage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Naturopathy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.SaveAndContinue.click();

        Thread.sleep(3000);
        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(0)), "Please enter your email id*                       :");
    }

    @Test
    public void VerifySetConfirmationsOrRemindersPageHasAllTheRequiredFields()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(0)), "Please enter your email id*                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(1)), "Booking confirmations to customer by*  :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(2)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(3)), "SMS i");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(4)), "Reminders to customer by                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(5)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(6)), "SMS i");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(7)), "Cancellation & Reschedule\n" +
                "confirmation to customer by *");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(8)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(9)), "SMS i");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(10)), "Special customer reminders :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(11)), "First Reminder");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(12)), "Second Reminder");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(13)), "Third Reminder");
    }

    @Test
    public void VerifyIfEmailIdFieldIsAcceptingAlphabetsNumericalAndSpecialCharacters()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghgj6762@gmail.com");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.EmailError));
    }

    @Test
    public void VerifyIfEmailIdFieldIsMandatoryAndErrorIsShownWhenLeftEmpty()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.EmailError), "Email is required");
    }

    @Test
    public void VerifyIfEmailIdFieldShowingErrorWithoutAtSymbolAndDot_NotAllowingSpaces()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg j6762gmailcom");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.ValidEmailError), "Email must be a valid email address");
    }

    @Test
    public void VerifyIfAllTheThreeSMSCheckBoxesCanBeCheckedAndUnchecked()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.ConfirmationSms.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ConfirmationSms));

        setConfirmationsRemindersPage.ConfirmationSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ConfirmationSms));

        setConfirmationsRemindersPage.ReminderSms.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ReminderSms));

        setConfirmationsRemindersPage.ReminderSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ReminderSms));

        setConfirmationsRemindersPage.CancellationSms.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CancellationSms));

        setConfirmationsRemindersPage.CancellationSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CancellationSms));
    }

    @Test
    public void VerifyIfByDefaultAllThreeEmailCheckBoxesAreChecked()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CheckBoxes.get(0)));
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CheckBoxes.get(2)));
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CheckBoxes.get(4)));
    }

    @Test
    public void VerifyThatToolTipsArePresentForAllThreeSMSCheckBoxesAndMessageIsDisplayed() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.ToolTipIcons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.ToolTipIcons.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.ToolTipIcons.get(2)));

        Utils.MouseHoverToAnElement(driver, setConfirmationsRemindersPage.ToolTipIcons.get(0));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.ToolTipInfo.get(0)));

        Utils.MouseHoverToAnElement(driver, setConfirmationsRemindersPage.ToolTipIcons.get(1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.ToolTipInfo.get(1)));

        Utils.MouseHoverToAnElement(driver, setConfirmationsRemindersPage.ToolTipIcons.get(2));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.ToolTipInfo.get(2)));
    }

    @Test
    public void VerifyIfAllThreeSMSCheckBoxesAreNotMandatoryAndUserCanSaveTheConfirmationsAndReminders() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Success')]"))), "Success");
    }

    @Test
    public void VerifyIfAllTheThreeSpecialCustomerReminderCheckBoxesCanBeCheckedAndUnchecked()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.FirstReminder.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.FirstReminder));

        setConfirmationsRemindersPage.FirstReminder.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.FirstReminder));

        setConfirmationsRemindersPage.SecondReminder.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.SecondReminder));

        setConfirmationsRemindersPage.SecondReminder.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.SecondReminder));

        setConfirmationsRemindersPage.ThirdReminder.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ThirdReminder));

        setConfirmationsRemindersPage.ThirdReminder.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ThirdReminder));
    }

    @Test
    public void VerifyIfUserCanSelectSpecialCustomerFirstReminderUpTo365DaysAndSelectedDaysReflectedInTheField()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "365Day");
        Assert.assertEquals(setConfirmationsRemindersPage.FirstReminder.getAttribute("value"), "on");
    }

    @Test
    public void VerifyIfUserCanSelectSpecialCustomerSecondReminderUpTo23HoursAndSelectedHoursAreReflectedInTheField()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "365Day");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23Hours");

        Assert.assertEquals(setConfirmationsRemindersPage.SecondReminderHours.getAttribute("value"), "23");
    }

    @Test
    public void VerifyIfUserCanSelectSpecialCustomerThirdReminderUpTo59MinutesAndSelectedMinsAreReflectedInTheField()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "365Day");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23Hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "59Minutes");

        Assert.assertEquals(setConfirmationsRemindersPage.ThirdReminderMins.getAttribute("value"), "59");
    }

    @Test
    public void VerifyIfAllThreeSpecialCustomerRemindersAreNotMandatoryAndUserCanSaveTheConfirmationsAndReminders() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Success')]"))), "Success");
    }

    @Test
    public void VerifyIfSuccessMessageIsDisplayedWhenMandatoryFieldsAreSetAndSaveButtonClicked() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Success')]"))), "Success");
    }
}