package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeServiceDescriptionTests extends BaseTest
{
    @Test// working
    public void VerifyIfUserCanNavigateToPracticeServiceDescriptionPageAfterCompletionOfEducationalInfoPage()
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
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523561390", "fgsdsgf", "fggasfdf", "rtwqe", "5677", "ytredf", "tyetdtqyd");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/1990", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2022", "01/02/2011");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribeUrSelfText), "Describe yourself * :");
    }

    @Test // working
    public void VerifyPracticeServiceDescriptionPagePageHasAllTheRequiredFields()
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
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        BusinessInfoPage businessInfoPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523569390", "fgsdsgf", "fggasfdf", "rtwqe", "5677", "ytredf", "tyetdtqyd");

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("03-02-1995 ", personalInfoPage.DOBInputField);

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2010", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2022", "01/02/2011");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribeUrSelfText), "Describe yourself * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribePracticeText), "Describe about practice * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.DescribeSplInterestsText), "Describe areas of special Interests & Services * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practiceServiceDescriptionPage.AdditionalInfoText), "Additional Information * :");
    }

    @Test //working
    public void VerifyUserCanNavigateToNextPageWithoutEnteringDataInPracticeServiceDescriptionInfoPage()
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
        String Password = AlphaNumeric + "@Jk5";
        String ConfirmPassword = AlphaNumeric + "@Jk5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        BusinessInfoPage businessInfoPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd dhgdh", "87523563290", "fgsd hgfsgf", "fggafggf sfdf", "rtwqe", "3566", "ytredf", "tyetdtqyd");

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2010", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("hasg",
                "asfa", "2658787656", "2022", "01/02/2011");

        practiceServiceDescriptionPage.SubmitButton.click();

        List<String> ActualText = Utils.GetTextForAListOfElements(driver, practiceServiceDescriptionPage.ErrorMessages);
        Assert.assertEquals(ActualText.get(0), "Describe yourself is required");
        Assert.assertEquals(ActualText.get(1), "Describe about practice is required");
        Assert.assertEquals(ActualText.get(2), "Describe areas of special Interests & Services is required");
        Assert.assertEquals(ActualText.get(3), "Additional Information is required");
    }
}
