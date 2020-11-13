package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.annotations.Test;

public class Set_EditAvailabilityRegressionTests extends BaseTest {

    @Test
    public void VerifyIfPractitionerCanCreateRecurringEventsAndSave() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Royal Children",
                "87523586390", "Bourke street", "Australia", "Brisbane", "5377", "Victoria");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "10:00AM", "12:00PM");

        createAppointmentPage.SelectDayAndEnterOpeningHours("Tuesday", "9:00AM", "6:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "9:00AM", "12:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Thursday", "3:30Pm", "9:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "8:00AM", "12:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "3:00PM", "06:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.Save.click();
        createAppointmentPage.OkButton.click();
    }

    @Test
    public void VerifyIfUserCanCreateRecurringEventAndAddDateSpecificEventForEvery1stAnd3rdSaturday() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Royal Children",
                "87523586390", "Bourke street", "Australia", "Brisbane", "5377", "Victoria");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "08:00AM", "12:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "08:00AM", "12:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "03:00PM", "06:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "03:00PM", "06:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "07:00PM", "09:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "10:00AM", "12:00PM");

        createAppointmentPage.SelectDayAndEnterOpeningHours("Tuesday", "9:00AM", "6:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "9:00AM", "12:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Thursday", "3:30Pm", "9:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "8:00AM", "10:00AM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "12:00PM", "04:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "12:00PM", "04:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "05:00PM", "07:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "05:00PM", "08:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "07:00PM", "09:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "03/10/2020", "08:00PM", "12:00PM");
    }

    @Test
    public void VerifyAfterCreatingAboveScenario_GotoEdit_DeleteThirdSaturdayAsDateSpecific() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Royal Children",
                "87523586390", "Bourke street", "Australia", "Brisbane", "5377", "Victoria");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "08:00AM", "12:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "08:00AM", "12:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "03:00PM", "06:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "03:00PM", "06:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "07:00PM", "09:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "10:00AM", "12:00PM");

        createAppointmentPage.SelectDayAndEnterOpeningHours("Tuesday", "9:00AM", "6:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "9:00AM", "12:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Thursday", "3:30Pm", "9:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "8:00AM", "10:00AM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "12:00PM", "04:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "12:00PM", "04:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "05:00PM", "07:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "05:00PM", "08:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "07:00PM", "09:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.Save.click();

        Thread.sleep(2000);
        createAppointmentPage.OkButton.click();

        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        editAppointmentPage.SelectLocationAndModalityInEditAppointmentPage(Location, "Naturopathy");

        Thread.sleep(5000);
        editAppointmentPage.Slots.get(0).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();

        editAppointmentPage.SaveAndContinue.click();

        editAppointmentPage.Slots.get(1).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();
        editAppointmentPage.SaveAndContinue.click();


        editAppointmentPage.Slots.get(2).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();

        editAppointmentPage.SaveAndContinue.click();


        editAppointmentPage.Slots.get(3).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();

        editAppointmentPage.SaveAndContinue.click();


        editAppointmentPage.Slots.get(4).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();

        editAppointmentPage.SaveAndContinue.click();


        editAppointmentPage.Slots.get(5).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();

        editAppointmentPage.SaveAndContinue.click();


        editAppointmentPage.Slots.get(6).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();

        editAppointmentPage.SaveAndContinue.click();


        editAppointmentPage.Slots.get(7).click();
        editAppointmentPage.CancelSlot.get(21).click();
        editAppointmentPage.CancelSlot.get(23).click();
        editAppointmentPage.CancelSlot.get(25).click();

        editAppointmentPage.SaveAndContinue.click();
    }

    @Test
    public void VerifyAfterCreatingAboveScenario_GotoEdit_EditMondaySlotWithNewTimings_DeleteSlot3ForRecurring() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Royal Children",
                "87523586390", "Bourke street", "Australia", "Brisbane", "5377", "Victoria");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "08:00AM", "12:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "08:00AM", "12:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "03:00PM", "06:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "03:00PM", "06:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "07:00PM", "09:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "10:00AM", "12:00PM");

        createAppointmentPage.SelectDayAndEnterOpeningHours("Tuesday", "9:00AM", "6:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "9:00AM", "12:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Thursday", "3:30Pm", "9:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "8:00AM", "10:00AM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "12:00PM", "04:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "12:00PM", "04:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "05:00PM", "07:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "05:00PM", "08:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.Save.click();

        Thread.sleep(2000);
        createAppointmentPage.OkButton.click();

        Thread.sleep(3000);

        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        editAppointmentPage.SelectLocationAndModalityInEditAppointmentPage(Location, "Naturopathy");

        Thread.sleep(5000);
        editAppointmentPage.Slots.get(11).click();
        editAppointmentPage.Slots.get(20).click();
        editAppointmentPage.TimeInput.get(0).sendKeys("01:00PM");
        editAppointmentPage.TimeInput.get(1).sendKeys("03:00PM");
        editAppointmentPage.AddButton.click();
        editAppointmentPage.SaveAndContinue.click();

        editAppointmentPage.Slots.get(13).click();
        editAppointmentPage.Slots.get(20).click();
        editAppointmentPage.TimeInput.get(0).sendKeys("01:00PM");
        editAppointmentPage.TimeInput.get(1).sendKeys("03:00PM");
        editAppointmentPage.AddButton.click();
        editAppointmentPage.SaveAndContinue.click();

        editAppointmentPage.Slots.get(14).click();
        editAppointmentPage.Slots.get(20).click();
        editAppointmentPage.TimeInput.get(0).sendKeys("01:00PM");
        editAppointmentPage.TimeInput.get(1).sendKeys("03:00PM");
        editAppointmentPage.AddButton.click();
        editAppointmentPage.SaveAndContinue.click();

        editAppointmentPage.CancelSlot.get(15).click();
        editAppointmentPage.CancelSlot.get(16).click();
        editAppointmentPage.CancelSlot.get(17).click();
    }

    @Test
    public void VerifyAfterCreatingAboveScenario_GotoEdit_DeleteDateSpecificFor1SaturdayAndChangeItAsRecurring_Change2MondayAsDateSpecific() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Royal Children",
                "87523586390", "Bourke street", "Australia", "Brisbane", "5377", "Victoria");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "08:00AM", "12:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "08:00AM", "12:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "08:00AM", "12:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "03:00PM", "06:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "03:00PM", "06:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "03:00PM", "06:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/07/2020", "07:00PM", "09:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/21/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/05/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/19/2020", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/02/2021", "07:00PM", "09:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/16/2021", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "10:00AM", "12:00PM");

        createAppointmentPage.SelectDayAndEnterOpeningHours("Tuesday", "9:00AM", "6:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "9:00AM", "12:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Thursday", "3:30Pm", "9:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "8:00AM", "10:00AM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "12:00PM", "04:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "12:00PM", "04:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "05:00PM", "07:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "05:00PM", "08:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.Save.click();

        Thread.sleep(2000);
        createAppointmentPage.OkButton.click();

        Thread.sleep(3000);

        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        editAppointmentPage.SelectLocationAndModalityInEditAppointmentPage(Location, "Naturopathy");

        Thread.sleep(5000);
        editAppointmentPage.Slots.get(11).click();
        editAppointmentPage.Slots.get(20).click();
        editAppointmentPage.TimeInput.get(0).sendKeys("01:00PM");
        editAppointmentPage.TimeInput.get(1).sendKeys("03:00PM");
        editAppointmentPage.AddButton.click();
        editAppointmentPage.SaveAndContinue.click();
    }

    @Test
    public void VerifyUserIsAbleToCreate_DateSpecificEventFor_Mon_Wed_Fri_AndRecurringEventFor_Tues_Thur_Sat() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Royal Children",
                "87523586390", "Bourke street", "Australia", "Brisbane", "5377", "Victoria");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/02/2020", "07:00AM", "10:00AM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/04/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/06/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/09/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/11/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/16/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/18/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/20/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/23/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/25/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/27/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/30/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/02/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/04/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/07/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/09/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/11/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/14/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/18/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/21/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/23/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/25/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/28/2020", "07:00AM", "10:00AM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/30/2020", "07:00AM", "10:00AM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/02/2020", "10:30AM", "01:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/04/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/06/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/09/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/11/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/16/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/18/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/20/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/23/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/25/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/27/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/30/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/02/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/04/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/07/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/09/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/11/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/14/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/18/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/21/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/23/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/25/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/28/2020", "10:30AM", "01:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/30/2020", "10:30AM", "01:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/02/2020", "02:00PM", "04:00PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/04/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/06/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/09/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/11/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/16/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/18/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/20/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/23/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/25/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/27/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("11/30/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/02/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/04/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/07/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/09/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/11/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/14/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/18/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/21/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/23/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/25/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/28/2020", "02:00PM", "04:00PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/30/2020", "02:00PM", "04:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Tuesday", "9:00AM", "6:00PM");

        createAppointmentPage.SelectDayAndEnterOpeningHours("Thursday", "9:00AM", "6:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "9:00AM", "6:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.Save.click();

        Thread.sleep(2000);
        createAppointmentPage.OkButton.click();
    }

    @Test
    public void VerifyUserIsAbleToCreate_RecurringEvent_And_DateSpecificEvent_15ThOfEveryMonth() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Royal Children",
                "87523586390", "Bourke street", "Australia", "Brisbane", "5377", "Victoria");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "09:10AM", "12:00PM");

        createAppointmentPage.SelectDayAndEnterOpeningHours("Tuesday", "9:00AM", "6:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "9:00AM", "12:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Thursday", "3:30Pm", "7:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "8:00AM", "10:00AM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "12:00PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Sunday", "10:30AM", "07:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "12:00PM", "04:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "04:00PM", "06:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "05:00PM", "08:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "06:30PM", "08:30PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "07:00PM", "09:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "11/15/2020", "08:30PM", "10:30PM");

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/15/2020", "08:30PM", "10:30PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("01/15/2021", "08:30PM", "10:30PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("04/15/2021", "10:30AM", "12:30PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("05/15/2021", "08:50PM", "10:30PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("06/15/2021", "08:30PM", "10:30PM");
        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("07/15/2021", "08:30PM", "10:30PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "50", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "1 hour", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.Save.click();

        Thread.sleep(2000);
        createAppointmentPage.OkButton.click();
    }
}
