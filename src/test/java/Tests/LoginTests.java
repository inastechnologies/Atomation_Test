package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test // working
    public void VerifyIfAllTheFieldsInTheLoginPageAreClickable()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.MobileEmailInputField));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.PasswordInputField));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.LoginButton));
    }

    @Test// working
    public void VerifyForgotPasswordButtonIsClickableAndUserCanNavigateToForgetPasswordScreen() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, forgotPasswordPage.ForgetPasswordText), "Forgot Password");
    }

    @Test// working
    public void VerifyIfUserCanNavigateToVerificationCodePageAfterEnteringValidPhoneNoEmailInForgotPasswordPage()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        VerifyYourAccountPage verifyYourAccountPage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, verifyYourAccountPage.VerificationCodeText), "Verification Code");
    }

    @Test// working
    public void VerifyIfUserCanNavigateToResetPasswordPageAfterEnteringOTP()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        VerifyYourAccountPage verifyYourAccountPage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode();
        ResetPasswordPage resetPasswordPage = verifyYourAccountPage.EnterOTPAndClickSubmitForResetPassword();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, resetPasswordPage.ResetPasswordMessage), "Reset Password");
    }

    @Test// working
    public void VerifyIfUserCanNavigateToLoginPageAfterResettingPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        VerifyYourAccountPage verifyYourAccountPage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode();
        ResetPasswordPage resetPasswordPage = verifyYourAccountPage.EnterOTPAndClickSubmitForResetPassword();
        resetPasswordPage.EnterPasswordConfirmPasswordAndClickConfirm();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test //working
    public void VerifyPasswordFieldInLoginPageHasPasswordProtectedEyeAndCanBeTickedAndUnTicked()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertFalse(Utils.isElementSelected(driver, loginPage.PasswordEye));
    }

    @Test// working
    public void VerifyGuestButtonIsClickableAndUserCanNavigateToGuestLoginPage()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.GuestButton));

        AdminPanelPage adminPanelPage = loginPage.ClickAndNavigateToGuestLoginPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");
    }

    @Test// working
    public void VerifyFaceBookAndGoogleIconsAreClickableInLoginPage()
    {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.LoginPageIcons.get(4));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.LoginPageIcons.get(5)));
        Assert.assertTrue(Utils.isClickable(driver, loginPage.LoginPageIcons.get(6)));
    }
}