package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTests extends BaseTest
{
    @Test
    public void VerifyIfPractitionerCanSetAvailabilityAndEdit_ViewAvailabilityAfterRegistration() throws InterruptedException
    {
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

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.SelectDayInput, "Tuesday");
        createAppointmentPage.TimeInput.get(0).sendKeys("11:00AM");
        createAppointmentPage.TimeInput.get(1).sendKeys("01:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "35", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "55", "00", "00", "hjghgjh");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "20", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "03", "35", "00", "00", "hjghgjh");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.CreateEventForRecurringWithInDateRangeSessionType(Location,"Naturopathy", "10/10/2020", "11/11/2020", "Tuesday", "8:00AM", "11:00AM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.SelectDayInput, "Thursday");
        createAppointmentPage.TimeInput.get(0).sendKeys("09:00AM");
        createAppointmentPage.TimeInput.get(1).sendKeys("03:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "35", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "55", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short", "01", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "15", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "10/10/2020", "2:00PM", "5:00PM");

        createAppointmentPage.DateInput.sendKeys("11/12/2020");
        createAppointmentPage.TimeInput.get(0).sendKeys("11:00AM");
        createAppointmentPage.TimeInput.get(1).sendKeys("01:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "35", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "55", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "20", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "03", "25", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(0).click();

        Thread.sleep(2000);
        createAppointmentPage.SaveAndContinue.click();

        Thread.sleep(2000);
        createAppointmentPage.OkButton.click();

        Thread.sleep(3000);
        createAppointmentPage.SetConfirmationRemindersHeading.click();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = new SetConfirmationsRemindersPage(driver);

        Thread.sleep(3000);
        CancelletionAndReschedulePage cancelletionAndReschedulePage = setConfirmationsRemindersPage.EnterEmail_SelectCheckBoxesAndNavigateToCancellationAndReschedulingPage("");

        Thread.sleep(3000);
        createAppointmentPage.CancellationRescheduleHeading.click();

        Thread.sleep(3000);
        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();

        Thread.sleep(3000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        editAppointmentPage.SelectLocationAndModalityInEditAppointmentPage(Location, "Naturopathy");

        Thread.sleep(3000);
        editAppointmentPage.Slots.get(0).click();

        editAppointmentPage.SelectDayAndOpeningHours("Wednesday", "5:00PM", "7:00PM");
        editAppointmentPage.AddButton.click();
        editAppointmentPage.NameInput.clear();
        editAppointmentPage.NameInput.sendKeys("Short");
        editAppointmentPage.FeesInput.clear();
        editAppointmentPage.FeesInput.sendKeys("55");
        Utils.SelectFromDropDownUsingVisibleText(editAppointmentPage.ConsultationTypeInput, "Face to Face");
        editAppointmentPage.SaveAndContinue.click();

        Thread.sleep(2000);
        editAppointmentPage.Slots.get(2).click();

        editAppointmentPage.Slots.get(6).click();
        editAppointmentPage.TimeInput.get(0).sendKeys("5:00PM");
        editAppointmentPage.TimeInput.get(1).sendKeys("6:00PM");
        editAppointmentPage.AddButton.click();

       Utils.SelectFromDropDownUsingVisibleText(editAppointmentPage.NOOfBookingDaysInput, "20");
        Utils.SelectFromDropDownUsingVisibleText(editAppointmentPage.ConsultationTypeInput, "Face to Face");
        editAppointmentPage.Description.clear();
        editAppointmentPage.Description.sendKeys("gjhghdgfj");
        editAppointmentPage.SaveAndContinue.click();

        Thread.sleep(3000);

        editAppointmentPage.EditConfirmationRemindersHeading.click();
        EditConfirmationsRemindersPage editConfirmationsRemindersPage = new EditConfirmationsRemindersPage(driver);

        Thread.sleep(3000);
        editConfirmationsRemindersPage.EditPencil.click();
        editConfirmationsRemindersPage.PractitionerEmail.clear();
        editConfirmationsRemindersPage.PractitionerEmail.sendKeys("Sai@gmail.com");
        editAppointmentPage.SaveAndContinue.click();

        Thread.sleep(3000);
        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = new EditCancelletionAndReschedulePage(driver);
        editCancelletionAndReschedulePage.EditCancellationRescheduleHeading.click();

        Thread.sleep(3000);
        editCancelletionAndReschedulePage.EditTheFieldsInCancellationAndReschedulingPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.SaveAndContinue.click();

        Thread.sleep(5000);
        /*LoginPage loginPage =  practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");

        Thread.sleep(3000);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin(Email, Password);

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        editAppointmentPage.SelectLocationAndModalityInEditAppointmentPage(Location, "Naturopathy");*/

    }

    @Test
    public void VerifyIfUserCanBuyEssentialSubscription() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Sydney";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);

        EssentialSubscriptionPage essentialSubscriptionPage = subscriptionPage.ClickOnBuyButtonAndNavigateToEssentialSubscriptionPage();

        essentialSubscriptionPage.EnterPaymentDetailsAndConfirm("Sailaja", "Mamillapalli", "657565757", "21/09/2022");

        essentialSubscriptionPage.CheckBox.get(1).click();
        essentialSubscriptionPage.CheckBox.get(2).click();
    }

    @Test
    public void VerifyIfUserCanLoginWithRegisteredEmailAndPasswordAndSetAvailability() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Thread.sleep(3000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Ayati@gmail.com", "Thannidi@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.CreateEventForRecurringSessionType("Sydney", "Physiotherapy", "Monday", "10:00AM", "12:00PM");

        Thread.sleep(3000);
        createAppointmentPage.SetConfirmationRemindersHeading.click();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = new SetConfirmationsRemindersPage(driver);


        Thread.sleep(3000);
        CancelletionAndReschedulePage cancelletionAndReschedulePage = setConfirmationsRemindersPage.EnterEmail_SelectCheckBoxesAndNavigateToCancellationAndReschedulingPage("fdgdf@gmail.com");

        Thread.sleep(3000);
        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyThatIfThePractitionerIsAbleToSetHisAvailabilityAndViewAppointments() throws InterruptedException {

        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Sydney";
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
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Acupuncture", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);

        practitionerManageAppointmentsPage.ClickAppointmentsAndEnterDataInSetAvailabilityPage(Location, "Acupuncture", "Online", "365", "1", "10:00AM", "12:00PM", "Initial Appointment", "60", "500", "1");

        LoginPage loginPage = practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();

        Thread.sleep(3000);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin(Email, Password);

        practitionerManageAppointmentsPage.ClickOnDateToCheckTheAppointments("25");
        Thread.sleep(3000);

        practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();


        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyGuestButtonIsClickableAndUserCanNavigateToGuestLoginPageAndLogOut() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.GuestButton));

        WelcomeToQNaturePage welcomeToQNaturePage = loginPage.ClickAndNavigateToGuestLoginPage();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, welcomeToQNaturePage.WelcomeToQNature), "Welcome to QNature");

        Thread.sleep(3000);
        welcomeToQNaturePage.AfterSubmittingFormClickLogout();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyIfUserCanNavigateBackPagesToEditTheData() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Sydney";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-03-1990", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "09/08/2021");

        Thread.sleep(3000);

        practiceServiceDescriptionPage.DescribeYourselfInputField.sendKeys( "fggfgfgfhfh");

        practiceServiceDescriptionPage.Breadcrumbs.get(2).click();

        educationalInfoPage.EducationDetailsInputField.clear();
        educationalInfoPage.EducationDetailsInputField.sendKeys("MSC Physics");

        practiceServiceDescriptionPage.Breadcrumbs.get(1).click();

        personalInfoPage.DOBInputField.clear();
        personalInfoPage.DOBInputField.sendKeys("08/01/2000");

        practiceServiceDescriptionPage.Breadcrumbs.get(0).click();

        businessInfoPage.AddressInputBox.clear();
        businessInfoPage.AddressInputBox.sendKeys("Miyapur");

        practiceServiceDescriptionPage.Breadcrumbs.get(1).click();
        practiceServiceDescriptionPage.Breadcrumbs.get(2).click();
        practiceServiceDescriptionPage.Breadcrumbs.get(3).click();

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("test","Practisioner", "yttuytuuh", "uhyugu", "fyugyugsa", "ikikiki");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode("9090909090");

        verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);

        //LoginPage loginPage =  adminPanelPage.AfterSubmittingFormClickLogout();

        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyUserCanSearchModalitiesNameUsingSearchInput() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.SearchForTheModalities("Allergy");

        Thread.sleep(7000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AllergyTreatments), "Allergy Treatments");
    }

   // @Test
    public void VerifyThatModalitiesAreScrollingRightAndLeftHorizontally() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.RightScroll.click();

        Thread.sleep(3000);
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.BowenTherapy), "Bowen Therapy");

        landingPage.LeftScroll.click();

        Thread.sleep(3000);
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.Acupuncture), "Acupuncture");
    }

    @Test
    public void VerifyWhenClickedOnOfferNameDisplaysDetailedDescriptionOfThatParticularOfferAlongWithAvailNowButton() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        Thread.sleep(3000);
        landingPage.OfferNameButton.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.OfferDescription),
                "Offer details and description will be displayed along with button to avail the offer and automatically user will be directed to the signup page and by signing up they can avail the offers");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AvailNowButton), "Avail Now");

        landingPage.OfferNameButton.get(1).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.OfferDescription),
                "Offer details and description will be displayed along with button to avail the offer and automatically user will be directed to the signup page and by signing up they can avail the offers");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AvailNowButton), "Avail Now");

        landingPage.OfferNameButton.get(2).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.OfferDescription),
                "Offer details and description will be displayed along with button to avail the offer and automatically user will be directed to the signup page and by signing up they can avail the offers");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AvailNowButton), "Avail Now");
    }

    @Test
    public void VerifyIfUserCanSubmitRegistration() throws InterruptedException
    {

        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage("Luckky", "Thannidi", "Luckky@gmail.com", "9866000000", "Sydney", "Luckky@270116", "Luckky@270116");
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode("9866000000");

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(5000);
        LoginPage loginPage =  practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyIfUserCanSubmitRegistrationForm() throws InterruptedException
    {

        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage("Harsh", "Thannidi", "Harsh@gmail.com", "9999113939", "Sydney", "Harsh@270116", "Harsh@270116");
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Brouk street", "Australia", "Sydney", "5377", "NSW");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode("9999113939");

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(5000);
        LoginPage loginPage =  practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }
}








