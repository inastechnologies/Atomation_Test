package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeServiceDescriptionTests extends BaseTest {
    @Test
    public void VerifyIfFindAskBookHomeAndProfileIconsAreClickableInPracticeServiceInfoPage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Melbourne";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Melbourne", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2019", "01/02/2020");

        Utils.WaitForElementsToExist(driver, practiceServiceDescriptionPage.HeaderIcons);

        Assert.assertTrue(Utils.isClickable(driver, practiceServiceDescriptionPage.HeaderIcons.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, practiceServiceDescriptionPage.HeaderIcons.get(1)));
        Assert.assertTrue(Utils.isClickable(driver, practiceServiceDescriptionPage.HeaderIcons.get(2)));
        Assert.assertTrue(Utils.isClickable(driver, practiceServiceDescriptionPage.HeaderIcons.get(3)));
        Assert.assertTrue(Utils.isClickable(driver, practiceServiceDescriptionPage.HeaderIcons.get(4)));
    }

    @Test
    public void VerifyWhenWeClickOnTheHomeIconItNavigatesToHomePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Melbourne";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Melbourne", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2019", "01/02/2020");

        Utils.WaitForElementsToExist(driver, practiceServiceDescriptionPage.HeaderIcons);

        signUpPage.HeaderIcons.get(3).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.BecomeTheNaturallyYouText), "Become The Naturally you");
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
    public void VerifyIfServiceTypeFieldIsMandatory() {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523569390", "fgsdsgf", "fggasfdf", "rtwqe", "5677", "ytredf");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1995", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2020", "01/02/2021");
        Utils.WaitForAnElementToExist(driver, practiceServiceDescriptionPage.ServiceTypeInput);
        practiceServiceDescriptionPage.CLickEveryFieldInPracticeServiceInfoPage();

       // List<String> ActualText = Utils.GetTextForAListOfElements(driver, practiceServiceDescriptionPage.ErrorMessages);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.ErrorMessages.get(0)), "Service Type is required");
    }

    @Test
    public void VerifyPracticeServiceDescriptionPagePageHasAllTheRequiredFields() {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523569390", "fgsdsgf", "fggasfdf", "rtwqe", "5677", "ytredf");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1995", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2020", "01/02/2021");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribeUrSelfText), "Describe yourself * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribePracticeText), "Describe about practice * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribeSplInterestsText), "Describe areas of special Interests & Services * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribeQualificationsRegistrationsText), "Describe Your Qualifications & Registrations * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.UploadLogoText), "Upload Logo & Images :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.AdditionalInfoText), "Additional Information :");
    }

    @Test
    public void VerifyIfTheServiceTypeHasTheDropDownListOfServices() {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523569390", "fgsdsgf", "fggasfdf", "rtwqe", "5677", "ytredf");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1995", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2020", "01/02/2021");

        Assert.assertTrue(Utils.isClickable(driver, practiceServiceDescriptionPage.ServiceTypeInput));
    }

    @Test
    public void VerifyFieldsOOfPracticeServiceDescriptionPageAreAcceptingAlphabetsNumericalSpacesAndSplChar() {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Adelaide", "5377", "Telangana");
        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1995", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2020", "01/02/2021");
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Naturopathy", "d)(*&gdfgf", "fdgdf)(*&566fgf", "dfhg87686(*&hdh", "dffd)(*&76fd", "frdr)(**65rd");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, verifyYourAccountPage.VerifyYourAccountText), "Verify Your Account");
    }

    @Test
    public void VerifyUserCanAddUptoFiveImagesInUploadImagesField() {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Adelaide", "5377", "Telangana");
        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1995", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2020", "01/02/2021");
        VerifyYourAccountPage verifyYourAccountPage= practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsAndUploadFiveFiles("Naturopathy", "jhgjhghj", "jhgj", "hjghjgj", "jhgjjhg", "jhjhk");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, verifyYourAccountPage.VerifyYourAccountText), "Verify Your Account");

    }

    @Test
    public void VerifyUserCanNotNavigateToNextPageWithoutEnteringDataInPracticeServiceDescriptionInfoPage() {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Melbourne";
        String Password = AlphaNumeric + "@Jk5";
        String ConfirmPassword = AlphaNumeric + "@Jk5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd dhgdh", "87523563290", "fgsd hgfsgf", "fggafggfdf", "rtwqe", "3566", "ytredf");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1992", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2020", "01/02/2021");

        practiceServiceDescriptionPage.CLickEveryFieldInPracticeServiceInfoPage();

        practiceServiceDescriptionPage.SubmitButton.click();

        List<String> ActualText = Utils.GetTextForAListOfElements(driver, practiceServiceDescriptionPage.ErrorMessages);

        Assert.assertEquals(ActualText.get(0), "Service Type is required");
        Assert.assertEquals(ActualText.get(1), "Describe yourself is required");
        Assert.assertEquals(ActualText.get(2), "Describe about practice is required");
        Assert.assertEquals(ActualText.get(3), "Special Interests & Services is required");
        Assert.assertEquals(ActualText.get(4), "Qualifications & Registrations is required");
    }

    @Test
    public void VerifyWhenClickingOnSkipButtonItNavigatesToNextPage() {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Melbourne";
        String Password = AlphaNumeric + "@Jk5";
        String ConfirmPassword = AlphaNumeric + "@Jk5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.ClickSkipAndNavigateToNextPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, verifyYourAccountPage.VerifyYourAccountText), "Verify Your Account");
    }
}
