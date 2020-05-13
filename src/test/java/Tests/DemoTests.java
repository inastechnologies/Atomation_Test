package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTests extends BaseTest

{
    @Test
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

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2020");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode("9090909090");

        Thread.sleep(2000);
        AdminPanelPage adminPanelPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(5000);
        LoginPage loginPage =  adminPanelPage.AfterSubmittingFormClickLogout();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyWhenClickedOnListYourBusinessButtonItNavigatesToSignUpPage()
    {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.NavigateToSignUpPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.SignUpTab), "Signup");
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
        String Location = "Hyderabad";
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

        Thread.sleep(3000);
    }

    @Test
    public void VerifyUserCanLoginSuccessfullyWithRegisteredMobileNoAndPasswordAndLogout() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        AdminPanelPage adminPanelPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("9090909090", "Test@123");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");

        Thread.sleep(3000);
        adminPanelPage.AfterSubmittingFormClickLogout();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyUserCanLoginSuccessfullyWithRegisteredEmailAndPasswordAndLogOut() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        AdminPanelPage adminPanelPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("lolo@gmail.com", "Test@123");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");

        Thread.sleep(3000);
        adminPanelPage.AfterSubmittingFormClickLogout();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyIfUserCanNavigateToLoginPageAfterResettingPassword() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();
        Utils.WaitForAnElementToExist(driver, loginPage.ForGotPassword);
        Assert.assertTrue(Utils.isClickable(driver, loginPage.ForGotPassword));
        ForgotPasswordPage forgotPasswordPage = loginPage.ClickAndNavigateToForgetPasswordPage();
        VerificationCodePage verificationCodePage = forgotPasswordPage.EnterPhoneEmailAndClickGetVerificationCode();
        ResetPasswordPage resetPasswordPage = verificationCodePage.EnterOTPAndClickSubmitForResetPassword("1", "2", "3", "4");

        Thread.sleep(3000);
        resetPasswordPage.EnterPasswordConfirmPasswordAndClickConfirm();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyGuestButtonIsClickableAndUserCanNavigateToGuestLoginPageAndLogOut() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        Assert.assertTrue(Utils.isClickable(driver, loginPage.GuestButton));

        AdminPanelPage adminPanelPage = loginPage.ClickAndNavigateToGuestLoginPage();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");

        Thread.sleep(3000);
        adminPanelPage.AfterSubmittingFormClickLogout();

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
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");


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

        businessInfoPage.AddressInputBox.clear();
        businessInfoPage.AddressInputBox.sendKeys("Miyapur");

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

    @Test
    public void VerifyUserCanSearchModalitiesNameUsingSearchInput() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.SearchForTheModalities("Allergy");

        Thread.sleep(7000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AllergyTreatments), "Allergy Treatments");
    }

    @Test
    public void VerifyThatModalitiesAreScrollingRightAndLeftHorizontally() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.RightScroll.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.BowenTherapy), "Bowen Therapy");

        landingPage.LeftScroll.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.Acupuncture), "Acupuncture");
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
}








