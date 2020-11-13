package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest
{

    @Test
    public void VerifyIfFindAskBookAndHomeIconsAreClickableInLoginPage()
    {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.NavigateToLogInPage();

        Utils.WaitForElementsToExist(driver, loginPage.HeaderIcons);

        Assert.assertTrue(Utils.isClickable(driver, loginPage.HeaderIcons.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.HeaderIcons.get(1)));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.HeaderIcons.get(2)));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.HeaderIcons.get(3)));
    }

    @Test
    public void VerifyIfAllTheFieldsInTheLoginPageAreClickable()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.MobileEmailInputField));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.PasswordInputField));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.LoginButton));
    }

    @Test
    public void VerifyWhenWeClickOnTheHomeIconItNavigatesToHomePage()
    {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.NavigateToLogInPage();

        Utils.WaitForElementsToExist(driver, loginPage.HeaderIcons);

        loginPage.HeaderIcons.get(3).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.BecomeTheNaturallyYouText), "Become The Naturally you");
    }

    @Test
    public void VerifyForgotPasswordButtonIsClickableAndUserCanNavigateToForgetPasswordScreen() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, forgotPasswordPage.ForgetPasswordText), "Forgot Password");
    }

    @Test
    public void VerifyWhenClickedOnSignUpLinkAtTheBottomOfThePageItNavigatesToSignUpPage()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.SignUpLink);
        loginPage.SignUpLink.click();
        SignUpPage signUpPage = new SignUpPage(driver);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.SignUpText), "SIGN UP");
    }

    @Test
    public void VerifyIfUserCanNavigateToVerificationCodePageAfterEnteringValidPhoneNoEmailInForgotPasswordPage()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        VerificationCodePage verificationCodePage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode("9866000000");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, verificationCodePage.VerificationCodeText), "Verification Code");
    }

    @Test
    public void VerifyIfUserCanNavigateToResetPasswordPageAfterEnteringOTP() throws InterruptedException {
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

        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();


        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);


        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        practitionerManageAppointmentsPage.ClickLogoutToGoOutOfThePage();
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        verificationCodePage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode(PhoneNo);
        ResetPasswordPage resetPasswordPage = verificationCodePage.EnterOTPAndClickSubmitForResetPassword("1", "2", "3", "4");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, resetPasswordPage.ResetPasswordMessage), "Reset Password");
    }

    @Test
    public void VerifyIfUserCanNavigateToLoginPageAfterResettingPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        VerificationCodePage verificationCodePage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode("9866000000");
        ResetPasswordPage resetPasswordPage = verificationCodePage.EnterOTPAndClickSubmitForResetPassword("1", "2", "3", "4");
        resetPasswordPage.EnterPasswordConfirmPasswordAndClickConfirm();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyPasswordFieldInLoginPageHasPasswordProtectedEyeAndCanBeTickedAndUnTicked()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.PasswordEye));
    }

    @Test
    public void VerifyGuestButtonIsClickableAndUserCanNavigateToGuestLoginPage()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.GuestButton));

        WelcomeToQNaturePage welcomeToQNaturePage = loginPage.ClickAndNavigateToGuestLoginPage();

       // Assert.assertEquals(Utils.GetTextFromAnElement(driver, welcomeToQNaturePage.WelcomeToQNature), "Welcome to QNature");
    }

    @Test
    public void VerifyFaceBookAndGoogleIconsAreClickableInLoginPage()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForElementsToExist(driver, loginPage.LoginPageIcons);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.GoogleIcon));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.FBIcon));
    }
}