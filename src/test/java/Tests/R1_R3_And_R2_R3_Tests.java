package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class R1_R3_And_R2_R3_Tests extends BaseTest {

    @Test
    public void VerifyCreating_R2_EventAndAddDateSpecificOnTheSameDayButDifferentTimeSlots_CreateDateSpecific_AnyDay_BeforeAndAfterDateRange() throws InterruptedException {
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

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(2)));
    }

    @Test
    public void VerifyCreating_R3_Event_And_OnTheSameDay_SameTimeSlot_Create_R3_Event_AlsoCreateDifferentTimeSlotsFor_R1_Event() throws InterruptedException {
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

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(2)));
    }

    @Test
    public void VerifyCreating_DateSpecific_ForADayWhichIsNotSelectedInThe_R2_Event() throws InterruptedException {
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

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(2)));
    }


    @Test
    public void VerifyWhenUserIsNotAbleToSelect_R2_WhenUserAlreadySelects_R1() throws InterruptedException {
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

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(2)));
    }

    @Test
    public void VerifyEditing_R2_Events_WithDateSpecific_AndAddingDaysAndDates() throws InterruptedException {
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

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(2)));
    }
}
