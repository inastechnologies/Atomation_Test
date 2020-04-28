package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTests extends BaseTest

{
    @Test// working
    public void VerifyIfUserCanSubmitRegistrationFormSuccessfullyAndLogout() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        BusinessInfoPage businessInfoPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "Opposite Metro", "Hyderabad", "5377", "Telangana", "India");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2020");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode("9090909090");

        AdminPanelPage adminPanelPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);

        LoginPage loginPage =  adminPanelPage.AfterSubmittingFormClickLogout();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test //working
    public void VerifyUserCanLoginSuccessfullyWithRegisteredMobileNoAndPasswordAndLogout()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        AdminPanelPage adminPanelPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("9090909090", "Test@123");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");

        adminPanelPage.AfterSubmittingFormClickLogout();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test //working
    public void VerifyUserCanLoginSuccessfullyWithRegisteredEmailAndPasswordAndLogOut()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        AdminPanelPage adminPanelPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("lolo@gmail.com", "Test@123");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");

        adminPanelPage.AfterSubmittingFormClickLogout();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test// working
    public void VerifyIfUserCanNavigateToLoginPageAfterResettingPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        VerificationCodePage verificationCodePage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode();
        ResetPasswordPage resetPasswordPage = verificationCodePage.EnterOTPAndClickSubmitForResetPassword("1", "2", "3", "4");
        resetPasswordPage.EnterPasswordConfirmPasswordAndClickConfirm();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test// working
    public void VerifyGuestButtonIsClickableAndUserCanNavigateToGuestLoginPageAndLogOut()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.GuestButton));

        AdminPanelPage adminPanelPage = loginPage.ClickAndNavigateToGuestLoginPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");

        adminPanelPage.AfterSubmittingFormClickLogout();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test// working
    public void VerifyIfUserCanNavigateBackPagesToEditTheData() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        BusinessInfoPage businessInfoPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Health", "87532356390", "Nizampet Main Road", "Opposite Metro", "Hyderabad", "5677", "Telangana", "India");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-03-1990", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "09/08/2020");

        practiceServiceDescriptionPage.DescribeYourselfInputField.sendKeys( "fggfgfgfhfh");

        practiceServiceDescriptionPage.Breadcrumbs.get(2).click();

        educationalInfoPage.EducationDetailsInputField.clear();
        educationalInfoPage.EducationDetailsInputField.sendKeys("MSC Physics");

        practiceServiceDescriptionPage.Breadcrumbs.get(1).click();

        personalInfoPage.DOBInputField.clear();
        personalInfoPage.DOBInputField.sendKeys("08/01/2000");

        practiceServiceDescriptionPage.Breadcrumbs.get(0).click();

        businessInfoPage.Address1InputBox.clear();
        businessInfoPage.Address1InputBox.sendKeys("Miyapur");

        practiceServiceDescriptionPage.Breadcrumbs.get(1).click();
        practiceServiceDescriptionPage.Breadcrumbs.get(2).click();
        practiceServiceDescriptionPage.Breadcrumbs.get(3).click();

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Practisioner", "yttuytuuh", "uhyugu", "fyugyugsa");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode("9090909090");

        AdminPanelPage adminPanelPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);

        LoginPage loginPage =  adminPanelPage.AfterSubmittingFormClickLogout();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }
}








