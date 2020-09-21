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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "3:00PM", "06:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.SaveAndContinue.click();
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing3");
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing3");
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing3");
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "12:00PM", "04:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "05:00PM", "07:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "05:00PM", "08:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "07:00PM", "09:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "03/10/2020", "08:00PM", "12:00PM");
   }

    @Test
    public void VerifyAfterCreatingAboveScenario_GotoEdit_DeleteThirdSaturdayADateSpecific() throws InterruptedException {
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing3");
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing3");
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing3");
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
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "12:30PM", "03:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "12:00PM", "04:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Saturday", "05:00PM", "07:00PM");

        createAppointmentPage.SkipButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "04:30PM", "06:30PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Friday", "05:00PM", "08:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();
        createAppointmentPage.CreateEventForRecurringSessionType(Location, "Naturopathy", "Monday", "07:00PM", "09:00PM");
        createAppointmentPage.SelectDayAndEnterOpeningHours("Wednesday", "07:00PM", "09:00PM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("First consultation", "01", "00", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "testing1");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "80");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing2");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short consultation", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "02", "00", "00", "00", "Testing3");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.SaveAndContinue.click();

        Thread.sleep(2000);
        createAppointmentPage.OkButton.click();

        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        editAppointmentPage.SelectLocationAndModalityInEditAppointmentPage(Location, "Naturopathy");

        Thread.sleep(2000);
        editAppointmentPage.Slots.get(0).click();
    }
}
