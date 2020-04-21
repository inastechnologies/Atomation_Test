package Tests;

import Pages.BusinessInfoPage;
import Pages.LandingPage;
import Pages.PersonalInfoPage;
import Pages.SignUpPage;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInfoTests extends BaseTest
{
    @Test// working
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
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@Jj5";
        String ConfirmPassword = AlphaNumeric + "@Jj5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        BusinessInfoPage businessInfoPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523856390", "fgsdsgf", "fggasfdf", "rtwqe", "5377", "ytredf", "tyetdtqyd");

        String ExpectedProfilePictureText = "Upload Profile Picture";
        String ActualProfilePictureText = Utils.GetTextFromAnElement(driver, personalInfoPage.UploadPictureText);
        Assert.assertEquals(ActualProfilePictureText, ExpectedProfilePictureText);
    }

    @Test // working
    public void VerifyIfPersonalInfoPageHasAllTheRequiredFields()
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

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.UploadPictureText),"Upload Profile Picture");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.DOBFieldText),"Date Of Birth * :");
    }

    @Test//  not working DOb entering wrong value
    public void VerifyUserIsAbleToClickAndEditAllTheFieldsInPersonalInfoPage() {
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

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("31-31-2020", personalInfoPage.DOBInputField);

        String ActualClinicText= personalInfoPage.DOBInputField.getAttribute("value");
        Assert.assertEquals(ActualClinicText, "31-31-2020");
        personalInfoPage.DOBInputField.clear();

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("8/5/2001", personalInfoPage.DOBInputField);

        String ActualClinicText1= personalInfoPage.DOBInputField.getAttribute("value");
        Assert.assertEquals(ActualClinicText1, "8/5/2001");
    }

    @Test //working
    public void VerifyUserCanNavigateToNextPageWithoutEnteringDataInPersonalInfoPage()
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

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext(" ", personalInfoPage.DOBInputField);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.DOBFieldError), "Date Of Birth is required");
    }

    @Test//Not working
    public void VerifyDOBFieldIsAcceptingValidData()
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

        //personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-03-1995", personalInfoPage.DOBInputField);

        personalInfoPage.DOBInputField.click();

        //personalInfoPage.EnterDOB();

        Assert.assertFalse(Utils.IsElementDisplayed(driver, personalInfoPage.DOBFieldError));
    }

    @Test// not working
    public void VerifyDOBFieldIsNotAcceptingInValidData()
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

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("06-09-1990", personalInfoPage.DOBInputField);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.DOBFieldError), "Date Of Birth is required");
    }

    @Test//working
    public void VerifyIfPersonalInfoPageHasGenderRadioButtonsAndSelectedOneAtaTime()
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

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext(" ", personalInfoPage.DOBInputField);

        personalInfoPage.GenderRadioButtons.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, personalInfoPage.GenderRadioButtons.get(0)));

        personalInfoPage.GenderRadioButtons.get(1).click();
        Assert.assertFalse(Utils.isElementSelected(driver, personalInfoPage.GenderRadioButtons.get(0)));
    }
}
