package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditConfirmationsRemaindersTests extends BaseTest {


    @Test
    public void VerifyThatIfUserCanClickOnTabsAndNavigateToEditConfirmationsRemaindersPageAndPageHasAllTheRequiredFields() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(0)), "Please enter your email id*                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(1)), "Booking confirmations to customer by*  :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(2)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(3)), "SMS i");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(4)), "Reminders to customer by                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(5)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(6)), "SMS i");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(7)), "Cancellation & Reschedule\n" +
                "confirmation to customer by *");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(8)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(9)), "SMS i");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(10)), "Special customer reminders :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(11)), "First Reminder");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(12)), "Second Reminder");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(13)), "Third Reminder");
    }

    @Test
    public void VerifyThatTheDataEnteredInSetConfirmationAndRemindersIsMatchingWithTheDataAutoFilledAndDisabledInEditConfirmationRemindersPage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.ConfirmationSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ReminderSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.CancellationSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "59Minutes");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23Hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "365Day");

        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();
        Assert.assertEquals(editConfirmationsRemindersPage.PractitionerEmail.getAttribute("value"), "Harsh@gmail.com");

        Assert.assertTrue(Utils.isElementSelected(driver, editConfirmationsRemindersPage.ConfirmationSms));
        Assert.assertTrue(Utils.isElementSelected(driver, editConfirmationsRemindersPage.ReminderSms));
        Assert.assertTrue(Utils.isElementSelected(driver, editConfirmationsRemindersPage.CancellationSms));

        Assert.assertTrue(Utils.IsElementDisplayed(driver, editConfirmationsRemindersPage.DisabledFields.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, editConfirmationsRemindersPage.DisabledFields.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, editConfirmationsRemindersPage.DisabledFields.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, editConfirmationsRemindersPage.DisabledFields.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, editConfirmationsRemindersPage.DisabledFields.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, editConfirmationsRemindersPage.DisabledFields.get(5)));
    }

    @Test
    public void VerifyThatPencilIconIsClickableAndFieldsAreClickableAndEditableInEditConfirmationRemindersPage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.ConfirmationSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ReminderSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.CancellationSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "59Minutes");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23Hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "365Day");

        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();

        editConfirmationsRemindersPage.EditPencil.click();

        editConfirmationsRemindersPage.PractitionerEmail.clear();
        editConfirmationsRemindersPage.PractitionerEmail.sendKeys("hgjhg@gmail.com");

        setConfirmationsRemindersPage.ConfirmationSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver, editConfirmationsRemindersPage.ConfirmationSms));

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ReminderSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver, editConfirmationsRemindersPage.ReminderSms));

        Thread.sleep(5000);
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "30Minutes");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "12Hours");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "10Day");

        Assert.assertEquals(editConfirmationsRemindersPage.FirstReminderDays.getAttribute("value"), "30");
        Assert.assertEquals(editConfirmationsRemindersPage.SecondReminderHours.getAttribute("value"), "12");
        Assert.assertEquals(editConfirmationsRemindersPage.ThirdReminderMins.getAttribute("value"), "10");
    }

    @Test
    public void VerifyThatUserIsAbleToSaveTheUpdatedDataAndSuccessfullyUpdatedMessageIsAppearing() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.ConfirmationSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ReminderSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.CancellationSms.click();

        Thread.sleep(5000);
        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "59Minutes");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23Hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "365Day");

        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();

        editConfirmationsRemindersPage.EditPencil.click();

        editConfirmationsRemindersPage.PractitionerEmail.clear();
        editConfirmationsRemindersPage.PractitionerEmail.sendKeys("hgjhg@gmail.com");

        setConfirmationsRemindersPage.ConfirmationSms.click();

        setConfirmationsRemindersPage.ReminderSms.click();

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "30Minutes");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "12Hours");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "10Day");

        Assert.assertTrue(Utils.isClickable(driver, editConfirmationsRemindersPage.SaveAndContinue));

        editConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Successful')]"))), "Successful");
    }
}

