package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditConfirmationsRemaindersTests extends BaseTest {


    @Test
    public void VerifyThatIfUserCanClickOnTabsAndNavigateToEditConfirmationsRemaindersPageAndPageHasAllTheRequiredFields() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("fghfg62@gmail.com");
        setConfirmationsRemindersPage.SaveAndContinue.click();
        Thread.sleep(2000);

        setConfirmationsRemindersPage.OkButton.click();

        Thread.sleep(3000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        setConfirmationsRemindersPage.OkButton.click();
        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();

        Thread.sleep(2000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(0)), "Please enter your email id*                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(1)), "Booking confirmations to customer by*  :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(2)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(3)), "SMS");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(4)), "Reminders to customer by                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(5)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(6)), "SMS");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(7)), "Cancellation & Reschedule\n" +
                "confirmation to customer by *");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(8)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(9)), "SMS");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(10)), "Special customer reminders :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editConfirmationsRemindersPage.RequiredFields.get(11)), "First Reminder");
    }

    @Test
    public void VerifyThatTheDataEnteredInSetConfirmationAndRemindersIsMatchingWithTheDataAutoFilledAndDisabledInEditConfirmationRemindersPage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(2000);
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
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "3 days");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23 hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "59 minutes");

        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(2000);

        setConfirmationsRemindersPage.OkButton.click();

        Thread.sleep(3000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        setConfirmationsRemindersPage.OkButton.click();
        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();

        editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();
        Assert.assertEquals(editConfirmationsRemindersPage.PractitionerEmail.getAttribute("value"), Email);

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
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(2000);
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
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "3 days");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23 hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "59 minutes");

        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(2000);
        setConfirmationsRemindersPage.OkButton.click();

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        editAppointmentPage.OkButton.click();
        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();

        Thread.sleep(2000);
        editConfirmationsRemindersPage.EditPencil.click();

        editConfirmationsRemindersPage.PractitionerEmail.clear();
        editConfirmationsRemindersPage.PractitionerEmail.sendKeys("hgjhg@gmail.com");

        setConfirmationsRemindersPage.ConfirmationSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver, editConfirmationsRemindersPage.ConfirmationSms));

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ReminderSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver, editConfirmationsRemindersPage.ReminderSms));

        Thread.sleep(5000);
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "10 days");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "12 hours");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "59 minutes");

        Assert.assertEquals(editConfirmationsRemindersPage.FirstReminderDays.getAttribute("value"), "59minutes");
        Assert.assertEquals(editConfirmationsRemindersPage.SecondReminderHours.getAttribute("value"), "12hours");
        Assert.assertEquals(editConfirmationsRemindersPage.ThirdReminderMins.getAttribute("value"), "10days");
    }

    @Test
    public void VerifyThatUserIsAbleToSaveTheUpdatedDataAndSuccessfullyUpdatedMessageIsAppearing() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(2000);
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
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "3 days");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23 hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "59 minutes");

        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(2000);
        setConfirmationsRemindersPage.OkButton.click();

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        Thread.sleep(2000);
        editAppointmentPage.OkButton.click();
        EditConfirmationsRemindersPage editConfirmationsRemindersPage = editAppointmentPage.ClickAndNavigateToEditConfirmationsPage();

        Thread.sleep(2000);
        editConfirmationsRemindersPage.EditPencil.click();

        editConfirmationsRemindersPage.PractitionerEmail.clear();
        editConfirmationsRemindersPage.PractitionerEmail.sendKeys("hgjhg@gmail.com");

        setConfirmationsRemindersPage.ConfirmationSms.click();

        setConfirmationsRemindersPage.ReminderSms.click();

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "10 days");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "12 hours");

        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "30 minutes");

        Assert.assertTrue(Utils.isClickable(driver, editConfirmationsRemindersPage.SaveAndContinue));

        editConfirmationsRemindersPage.SaveAndContinue.click();
        
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Successful')]"))), "Successful");
    }
}

