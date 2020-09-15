package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class IntegrationTests extends BaseTest
{
    @Test
    public void VerifyUserCanLoginAsPractitionerWithRegisteredMobileNoAndPassword() throws InterruptedException {

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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin(PhoneNo, Password);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.ManageAppointments), "MANAGE APPOINTMENTS");
    }

    @Test
    public void VerifyUserCanLoginAsPractitionerWithRegisteredEmailAndPassword() throws InterruptedException {
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin(Email, Password);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.ManageAppointments), "MANAGE APPOINTMENTS");
    }

    @Test
    public void VerifyUserCanLoginWithInvalidMobileNumberAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("6566%%%", "Test_123");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);

        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test
    public void VerifyUserCanNotLoginWithInvalidEmailIdAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("6566%%%", "Test_123");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test
    public void VerifyUserCanLoginWithValidMobileNoAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("9000000009", "hjgjggjgg");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test
    public void VerifyUserCanLoginWithValidEmailAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("ghanwar@gmail.com", "hj3gjgg");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test
    public void VerifyUserCanLoginWithInvalidMobileNoAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("65676%%*55", "hj3gjg*g");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test
    public void VerifyUserCanLoginWithInvalidEmailAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("6566%%%", "hj3gjgg");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test
    public void VerifyUserCanLoginWithEmptyMobileNoOrEmailFieldAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("", "Test_123");

        Utils.WaitForAnElementToExist(driver, loginPage.ValidMobileEmailErrMessage);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.ValidMobileEmailErrMessage), "Phone Number or Email is required");
    }

    @Test
    public void VerifyUserCanLoginWithValidMobileNoAndEmptyPasswordField()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("9000000009", "");

        Utils.WaitForAnElementToExist(driver, loginPage.ValidPasswordMessage);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.ValidPasswordMessage), "Password is required");
    }

    @Test
    public void VerifyUserCanLoginWithValidEmailAndEmptyPasswordField()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("ghanwar@gmail.com", "");

        Utils.WaitForAnElementToExist(driver, loginPage.ValidPasswordMessage);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.ValidPasswordMessage), "Password is required");
    }

    @Test
    public void VerifyUserCanLoginWithEmptyMobileNoOrEmailFieldAndEmptyPasswordField()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("", "");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Phone Number or Email is required");
        Assert.assertEquals(ActualText.get(1), "Password is required");
    }

    @Test
    public void VerifyUserCanLoginWithCaseChangeEmailIdAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("RTRYUURY", "Test_123");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test
    public void VerifyIfUserIsLandingOntoTheSubscriptionPageAfterSigningUpAsAPractitioner()
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
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.EssentialSubscription), "ESSENTIAL");
    }

    @Test
    public void VerifyUserIsAbleToNavigateToBusinessInfoPageIfUserRegistersAsPractitioner()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Melbourne";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        String ExpectedBusinessInfoText = "Business Information";
        String ActualBusinessInfoText = Utils.GetTextFromAnElement(driver, businessInfoPage.BusinessInfoText);
        Assert.assertEquals(ActualBusinessInfoText, ExpectedBusinessInfoText);
    }

    @Test
    public void VerifyIfUserCanNavigateToPersonalInfoPageAfterSuccessfulCompletionOfBusinessInfoPage()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Brisbane";
        String Password = AlphaNumeric + "@Jj5";
        String ConfirmPassword = AlphaNumeric + "@Jj5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Brisbane", "5377", "Telangana");

        String ExpectedProfilePictureText = "Upload Profile Picture";
        String ActualProfilePictureText = Utils.GetTextFromAnElement(driver, personalInfoPage.UploadPictureText);
        Assert.assertEquals(ActualProfilePictureText, ExpectedProfilePictureText);
    }

    @Test
    public void VerifyIfUserCanNavigateToEducationalInfoPageAfterSuccessfulCompletionOfPersonalInfoPage()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Melbourne";
        String Password = AlphaNumeric + "@J5lP";
        String ConfirmPassword = AlphaNumeric + "@J5lP";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Melbourne", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2010", personalInfoPage.DOBInputField);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.EduInfoText), "Educational Information");
    }

    @Test
    public void VerifyIfUserCanNavigateToPracticeServiceDescriptionPageAfterCompletionOfEducationalInfoPage() {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Melbourne";
        String Password = AlphaNumeric + "@J5lP";
        String ConfirmPassword = AlphaNumeric + "@J5lP";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523561390", "fgsdsgf", "fggasfdf", "rtwqe", "5677", "ytredf");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1990", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2020", "01/02/2021");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribeUrSelfText), "Describe yourself * :");
    }

    @Test
    public void VerifyIfTheUseIsAbleToLandOntoPractitionerHomePageAfterSuccessfulVerification() {
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.ManageAppointments), "MANAGE APPOINTMENTS");
    }

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
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "35", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "55", "00", "00", "hjghgjh");
        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "00", "20", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "03", "35", "00", "00", "hjghgjh");
        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEventForRecurringWithInDateRangeSessionType(Location,"Naturopathy", "09/09/2020", "10/10/2020", "Tuesday", "8:00AM", "11:00AM");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.SelectDayInput, "Thursday");
        createAppointmentPage.TimeInput.get(0).sendKeys("09:00AM");
        createAppointmentPage.TimeInput.get(1).sendKeys("03:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "35", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "55", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short", "00", "10", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "15", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.CreateEventForDateSpecificSessionType(Location, "Naturopathy", "10/10/2020", "2:00PM", "5:00PM");

        createAppointmentPage.DateInput.sendKeys("11/12/2020");
        createAppointmentPage.TimeInput.get(0).sendKeys("11:00AM");
        createAppointmentPage.TimeInput.get(1).sendKeys("01:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "15");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "35", "100");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "55", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "00", "20", "50");
        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Both", "03", "25", "00", "00", "This is to test");
        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SaveAndContinue.click();

        Thread.sleep(3000);
        createAppointmentPage.SetConfirmationRemindersHeading.click();

        SetConfirmationsRemindersPage setConfirmationsRemindersPage = new SetConfirmationsRemindersPage(driver);

        Thread.sleep(3000);
        CancelletionAndReschedulePage cancelletionAndReschedulePage = setConfirmationsRemindersPage.EnterEmail_SelectCheckBoxesAndNavigateToCancellationAndReschedulingPage("fdgdf@gmail.com");

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
}

