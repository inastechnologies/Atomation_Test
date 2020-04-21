package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomeScreenTests extends BaseTest {

    @Test // working
    public void VerifyWelcomeScreenAppearsAfterEnteringURL() {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        String ExpectedLoginMessageText = "Welcome !";
        String ActualLoginMessageText = Utils.GetTextFromAnElement(driver, homePage.LoginInWelcomeText);
        Assert.assertEquals(ActualLoginMessageText, ExpectedLoginMessageText);
    }

    @Test // working
    public void VerifyLoginAndSignUpTabsArePresentInWelcomeScreen() {
        LandingPage homePage = new LandingPage(driver);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, homePage.LoginTab), "LOGIN");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, homePage.SignUpTab), "SIGN UP");
    }

    @Test // working
    public void VerifyIfLoginAndSignUpAreClickable() {
        LandingPage homePage = new LandingPage(driver);

        Assert.assertTrue(Utils.isClickable(driver, homePage.SignUpTab));
        Assert.assertTrue(Utils.isClickable(driver, homePage.LoginTab));
    }

    @Test // working
    public void VerifyWhenClickedOnSignUpTabItNavigatesToSignUpPage()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.NavigateToSignUpPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, homePage.SignUpTab), "SIGN UP");
    }

    @Test // working
    public void VerifyWhenClickedOnLoginTabItNavigatesToLoginPage()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.NavigateToLogInPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, homePage.LoginTab), "LOGIN");
    }

    @Test // working
    public void VerifyWhenClickedOnSignUpLinkAtTheBottomOfThePageItNavigatesToSignUpPage()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.NavigateToLogInPage();
        homePage.SignUpLink.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, homePage.SignUpTab), "SIGN UP");
    }

    @Test// working
    public void VerifyIfUserCanSubmitRegistrationFormSuccessfully()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5lP";
        String ConfirmPassword = AlphaNumeric + "@J5lP";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        BusinessInfoPage businessInfoPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523563990", "fgsdsgf", "fggasfdf", "rtwqe", "5367", "ytredf", "tyetdtqyd");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2010", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "6587999976", "2025", "01/02/2011");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf");

        verifyYourAccountPage.EnterPhoneEmailAndClickGetVerificationCode();
        AdminPanelPage adminPanelPage = verifyYourAccountPage.EnterOTPAndClickSubmit();

        String ActualText = (Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage));

        Assert.assertEquals(ActualText, "Welcome to QNature");
    }
}