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

}

