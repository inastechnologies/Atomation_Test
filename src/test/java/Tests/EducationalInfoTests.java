package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EducationalInfoTests extends BaseTest
{
    @Test// working
    public void VerifyIfUserCanNavigateToEducationalInfoPageAfterSuccessfulCompletionOfPersonalInfoPage() {
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
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523556390", "fgsdsgf", "fggasfdf", "rtwqe", "5377", "ytredf", "tyetdtqyd");


        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2010", personalInfoPage.DOBInputField);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.EduInfoText), "Educational Information");
    }

    @Test // working
    public void VerifyIfEducationalInfoPageHasAllTheRequiredFields()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("03-02-1995 ", personalInfoPage.DOBInputField);

        educationalInfoPage.CLickEveryFieldInEducationalInfoPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.EduDetailsText), "Education Details * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.AssociationText), "Association * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.RegNoText), "Registration Number * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.RegYearText), "Year Of Registration * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.RegRenewalText), "Registration Renewal Date * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.UploadDocsText), "Upload Registration Documents :");
    }

    @Test //working
    public void VerifyUserCanNavigateToNextPageWithoutEnteringDataInEducationalInfoPage()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.CLickEveryFieldInEducationalInfoPage();
        Utils.WaitForAnElementToExist(driver, educationalInfoPage.EduIfoNextButton);
        educationalInfoPage.EduIfoNextButton.click();

        List<String> ActualText = Utils.GetTextForAListOfElements(driver, educationalInfoPage.ErrorMessages);
        Assert.assertEquals(ActualText.get(0), "Education Details is required");
        Assert.assertEquals(ActualText.get(1), "Association Details is required");
        Assert.assertEquals(ActualText.get(2), "Registration Number is required");
        Assert.assertEquals(ActualText.get(3), "Year Of Registration is required");
        Assert.assertEquals(ActualText.get(4), "Registration Renewal Date is required");
    }

    @Test//working
    public void VerifyEducationalDetailsFieldIsAcceptingValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg", "65757", "7658", "");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, educationalInfoPage.EducationalDetailsError));
    }

    @Test//working
    public void VerifyEducationalDetailsFieldIsNotAcceptingInValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghf#@%*&^&*hfgh", "hjgjhg", "65757", "2017", "09-08-2020");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.EducationalDetailsError), "Special characters are not acceptable");
    }

    @Test// working
    public void VerifyAssociationFieldIsAcceptingValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjg%#^%^&^^%jhg", "65757", "7658", "");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, educationalInfoPage.AssociationError));
    }

    @Test// not working
    public void VerifyRegistrationNumberFieldIsAcceptingValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg hjgj%%", "767677", "7658", "");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, educationalInfoPage.RegistrationNoError));
    }

    @Test//working
    public void VerifyRegistrationNumberFieldIsNotAcceptingInValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg hjgj%%", "", "7658", "");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.ErrorMessages.get(0)), "Registration Number is required");
    }

    @Test//working
    public void VerifyYearOfRegistrationFieldIsAcceptingValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg hjgj%%", "7676", "7655", "");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, educationalInfoPage.YearOfRegError));
    }

    @Test//working
    public void VerifyYearOfRegistrationFieldIsNotAcceptingInValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg hjgj%%", "7676", "7687678655", "18-09-2021");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.YearOfRegError), "Year Of Registration should be 4 digits");
    }

    @Test//working
    public void VerifyRegistrationRenewalDateFieldIsAcceptingValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg hjgj%%", "7676", "", "09-09-2020");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, educationalInfoPage.RegistrationRenewalDateError));
    }

    @Test//working
    public void VerifyRegistrationRenewalDateFieldIsNotAcceptingInValidData()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg hjgj%%", "7676", "7687678655", "");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.RegistrationRenewalDateError), "Registration Renewal Date is required");
    }

    @Test // working
    public void VerifyRegistrationDocumentsFieldIsUploadingMoreThanTwoDocuments()
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

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-01-1997 ", personalInfoPage.DOBInputField);

        educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("ghfhg ghfhfgh", "hjgjhg hjgj%%", "7676", "7687678655", "");

        educationalInfoPage.BrowseField.sendKeys("D:\\dahlia.jpeg");
        educationalInfoPage.BrowseField.sendKeys("D:\\Rose.jpeg");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, educationalInfoPage.DocDownloadFile), "Flower.jpg");
    }
}
