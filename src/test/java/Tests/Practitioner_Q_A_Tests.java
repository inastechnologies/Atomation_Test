package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practitioner_Q_A_Tests extends BaseTest {

    @Test
    public void VerifyIfTheUseIsAbleToNavigateToQuestionAndAnswerPageOnClickingQuestionAndAnswerInTheSideBar() {
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

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");
        Practitioner_Q_A_Page practitioner_q_a_page = practitionerManageAppointmentsPage.ClickQuestionAndAnswersAndNavigateToQuestionAndAnswerPage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, practitioner_q_a_page.Q_A_Text));
    }

    @Test
    public void VerifyIfTheUserIsAbleToSeeAllQuestionsWhenRedirectedTo_Q_A_Page() {
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


        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");
        Practitioner_Q_A_Page practitioner_q_a_page = practitionerManageAppointmentsPage.ClickQuestionAndAnswersAndNavigateToQuestionAndAnswerPage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, practitioner_q_a_page.AllQuestions));
    }

    @Test
    public void VerifyIfTheUserIsAbleToSeeRefreshButtonAndModalityDropDownTo_Q_A_Page() throws InterruptedException {
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

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");
        Practitioner_Q_A_Page practitioner_q_a_page = practitionerManageAppointmentsPage.ClickQuestionAndAnswersAndNavigateToQuestionAndAnswerPage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, practitioner_q_a_page.RefreshButton));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, practitioner_q_a_page.ModalityDropDown));
    }
}
