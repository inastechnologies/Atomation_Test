package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInfoTests extends BaseTest
{
    @Test
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
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        String ExpectedProfilePictureText = "Upload Profile Picture";
        String ActualProfilePictureText = Utils.GetTextFromAnElement(driver, personalInfoPage.UploadPictureText);
        Assert.assertEquals(ActualProfilePictureText, ExpectedProfilePictureText);
    }

    @Test
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
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.UploadPictureText),"Upload Profile Picture");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.DOBFieldText),"Date Of Birth * :");
    }

    @Test //Need to assert
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
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        Utils.WaitForAnElementToExist(driver, personalInfoPage.DOBInputField);

        personalInfoPage.DOBInputField.sendKeys("08/05/1991");

        personalInfoPage.DOBInputField.clear();

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("08/05/1993", personalInfoPage.DOBInputField);
    }

    @Test
    public void VerifyUserCanNotNavigateToNextPageWithoutEnteringDataInPersonalInfoPage()
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
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext(" ", personalInfoPage.DOBInputField);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.DOBFieldError), "Date Of Birth is required");
    }

    @Test
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
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02-03-1995", personalInfoPage.DOBInputField);

        Assert.assertFalse(Utils.IsElementDisplayed(driver, personalInfoPage.DOBFieldError));
    }

    @Test
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
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("06-09-2012", personalInfoPage.DOBInputField);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, personalInfoPage.DOBFieldError), "Date Of Birth is Invalid");
    }

    @Test
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
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children","87523586390", "Nizampet Main Road", "India", "Hyderabad", "5377", "Telangana");

        personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext(" ", personalInfoPage.DOBInputField);

        personalInfoPage.GenderRadioButtons.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, personalInfoPage.GenderRadioButtons.get(0)));

        personalInfoPage.GenderRadioButtons.get(1).click();
        Assert.assertFalse(Utils.isElementSelected(driver, personalInfoPage.GenderRadioButtons.get(0)));
    }
}
