package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetConfirmationsRemindersTests extends BaseTest {


    @Test
    public void VerifySetConfirmationsOrRemindersPageHasAllTheRequiredFields() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(0)), "Please enter your email id*                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(1)), "Booking confirmations to customer by*  :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(2)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(3)), "SMS");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(4)), "Reminders to customer by                       :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(5)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(6)), "SMS");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(7)), "Cancellation & Reschedule\n" +
                "confirmation to customer by *");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(8)), "Email");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(9)), "SMS");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(10)), "Special customer reminders :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(11)), "First Reminder");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(12)), "Second Reminder");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.RequiredFields.get(13)), "Third Reminder");
    }

    @Test
    public void VerifyIfEmailIdFieldIsAcceptingAlphabetsNumericalAndSpecialCharacters() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghgj6762@gmail.com");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, setConfirmationsRemindersPage.EmailError));
    }

    @Test
    public void VerifyIfEmailIdFieldShowsEmailIdEnteredAtTheTimeOfRegistration() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        Assert.assertEquals(setConfirmationsRemindersPage.PractitionerEmail.getAttribute("value"), Email);
    }

    @Test
    public void VerifyIfEmailIdFieldShowingErrorWithoutAtSymbolAndDot_NotAllowingSpaces() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg j6762gmailcom");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, setConfirmationsRemindersPage.ValidEmailError), "Email must be a valid email address");
    }

    @Test
    public void VerifyIfAllTheThreeSMSCheckBoxesCanBeCheckedAndUnchecked() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.ConfirmationSms.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ConfirmationSms));

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ConfirmationSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ConfirmationSms));

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ReminderSms.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ReminderSms));

        Thread.sleep(5000);
        setConfirmationsRemindersPage.ReminderSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ReminderSms));

        Thread.sleep(5000);
        setConfirmationsRemindersPage.CancellationSms.click();
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CancellationSms));

        Thread.sleep(5000);
        setConfirmationsRemindersPage.CancellationSms.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CancellationSms));
    }

    @Test
    public void VerifyIfByDefaultAllThreeEmailCheckBoxesAreChecked() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CheckBoxes.get(0)));
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CheckBoxes.get(2)));
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.CheckBoxes.get(4)));
    }

    @Test
    public void VerifyThatToolTipsArePresentForAllThreeSMSCheckBoxesAndMessageIsDisplayed() throws InterruptedException {
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

        Thread.sleep(3000);
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Success')]"))), "Success");
    }

    @Test
    public void VerifyIfAllTheThreeSpecialCustomerReminderCheckBoxesCanBeCheckedOneAfterTheOther() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();

        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "365 days");
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.FirstReminder));

        setConfirmationsRemindersPage.FirstReminder.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.FirstReminder));

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "1 day");
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.SecondReminder));

        setConfirmationsRemindersPage.SecondReminder.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.SecondReminder));

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "2 hours");
        Assert.assertTrue(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ThirdReminder));

        setConfirmationsRemindersPage.ThirdReminder.click();
        Assert.assertFalse(Utils.isElementSelected(driver,setConfirmationsRemindersPage.ThirdReminder));
    }

    @Test
    public void VerifyIfUserCanSelectSpecialCustomerFirstReminderUpTo365DaysAndSelectedDaysReflectedInTheField() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "365 days");
        Assert.assertEquals(setConfirmationsRemindersPage.FirstReminder.getAttribute("value"), "on");
    }

    @Test
    public void VerifyIfUserCanSelectSpecialCustomerSecondReminderOnlyAfterSelectingFirstReminderAndSelectedDataIsReflectedInTheField() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "3 days");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23 hours");

        Assert.assertEquals(setConfirmationsRemindersPage.SecondReminderHours.getAttribute("value"), "23hours");
    }

    @Test
    public void VerifyIfUserCanSelectSpecialCustomerThirdReminderOnlyAfterSelectingFirstAndSecondReminderAndSelectedDataIsReflectedInTheField() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");

        setConfirmationsRemindersPage.FirstReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.FirstReminderDays, "3 days");

        setConfirmationsRemindersPage.SecondReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.SecondReminderHours, "23 hours");

        setConfirmationsRemindersPage.ThirdReminder.click();
        Utils.SelectFromDropDownUsingVisibleText(setConfirmationsRemindersPage.ThirdReminderMins, "2 hours");

        Assert.assertEquals(setConfirmationsRemindersPage.ThirdReminderMins.getAttribute("value"), "2hours");
    }

    @Test
    public void VerifyIfAllThreeSpecialCustomerRemindersAreNotMandatoryAndUserCanSaveTheConfirmationsAndReminders() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Success')]"))), "Success");
    }

    @Test
    public void VerifyIfSuccessMessageIsDisplayedWhenMandatoryFieldsAreSetAndSaveButtonClicked() throws InterruptedException {
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

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = createAppointmentPage.ClickAndNavigateToSetConfirmationsAndRemindersPage();
        setConfirmationsRemindersPage.PractitionerEmail.clear();
        setConfirmationsRemindersPage.PractitionerEmail.sendKeys("ghg6762@gmail.com");
        setConfirmationsRemindersPage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Success')]"))), "Success");
    }
}