package Tests;

import Pages.BusinessInfoPage;
import Pages.LandingPage;
import Pages.SignUpPage;
import Pages.SubscriptionPage;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BusinessInfoTests extends BaseTest
{

    @Test
    public void VerifyUserIsAbleToNavigateToBusinessInfoPageIfUserRegistersAsPractitioner()
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

        String ExpectedBusinessInfoText = "Business Information";
        String ActualBusinessInfoText = Utils.GetTextFromAnElement(driver, businessInfoPage.BusinessInfoText);
        Assert.assertEquals(ActualBusinessInfoText, ExpectedBusinessInfoText);
    }

    @Test
    public void VerifyIfBusinessInfoPageHasAllTheRequiredFields()
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
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.ClinicInstituteOrganizationName),"Clinic/Institute/Organization Name (Opt) :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.AustralianBusinessNo),"Australian Business Number(ABN) :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.Address),"Address * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.Country),"Country * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.CitySuburbTown),"City / Suburb / Town * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.AreaCode),"Area Code * :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.StateProvince),"State / Province * :");
    }

    @Test
    public void VerifyUserIsAbleToClickAndEditAllTheFieldsInBusinessInfoPage() {
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdfd", "87523596390", "fgsdsgf", "fggasfdf", "rtwqe", "jhjh", "ytredf");

        String ActualClinicText= businessInfoPage.ClinicInputBox.getAttribute("value");
        Assert.assertEquals(ActualClinicText, "tdfd");
        businessInfoPage.ClinicInputBox.clear();

        String ActualABNText= businessInfoPage.AUSBusinessNoInputBox.getAttribute("value");
        Assert.assertEquals(ActualABNText, "87523596390");
        businessInfoPage.AUSBusinessNoInputBox.clear();

        String ActualAddress1Text= businessInfoPage.AddressInputBox.getAttribute("value");
        Assert.assertEquals(ActualAddress1Text, "fgsdsgf");
        businessInfoPage.AddressInputBox.clear();

        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("jjjjjjjj", "81113561390", "dsgf", "fggasfdf", "rtwqe", "jhjh", "ytredf");

        String ActualClinicText1= businessInfoPage.ClinicInputBox.getAttribute("value");
        Assert.assertEquals(ActualClinicText1, "jjjjjjjj");

        String ActualABNText1= businessInfoPage.AUSBusinessNoInputBox.getAttribute("value");
        Assert.assertEquals(ActualABNText1, "81113561390");

        String ActualAddressText1= businessInfoPage.AddressInputBox.getAttribute("value");
        Assert.assertEquals(ActualAddressText1, "dsgf");
    }

    @Test
    public void VerifyUserCanNotNavigateToNextPageWithoutEnteringDataInBusinessInfoPage()
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
        Utils.WaitForAnElementToExist(driver, businessInfoPage.NextButton);

        businessInfoPage.NextButton.click();

        List<String> ActualText = Utils.GetTextForAListOfElements(driver, businessInfoPage.ErrorMessages);
        //Assert.assertEquals(ActualText.get(0), "Clinic/Institute/Organization is required");
        //Assert.assertEquals(ActualText.get(1), "Australian Business Number(ABN) is required");
        //Assert.assertEquals(ActualText.get(0), "Address is required");
        Assert.assertEquals(ActualText.get(0), "Country is required");
        Assert.assertEquals(ActualText.get(1), "City is required");
        Assert.assertEquals(ActualText.get(2), "Area Code is required");
        Assert.assertEquals(ActualText.get(3), "State is required");
    }

    @Test
    public void VerifyClinicNameFieldIsAcceptingValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("ghfgh gh876863fhf", "75231565390", "fgsdsgf", "fggasfdf", "rtwqe", "jhkj", "ytredf");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, businessInfoPage.ClinicErrorMessage));
    }

    @Test
    public void VerifyClinicNameFieldIsNotAcceptingInValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("ghfgh #@!^&*^  6777(**ghfhf", "87523565390", "fgsdsgf", "fggasfdf", "rtwqe", "jhkj", "ytredf");

        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.ClinicErrorMessage), "Special characters are not acceptable");
    }

    @Test
    public void VerifyAustralianBusinessNoFieldIsAcceptingValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg  6755d", "87523563190", "fgsdsgf", "fggasfdf", "rtwqe", "tyt", "ytredf");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, businessInfoPage.ABNErrorMessage));
    }

    @Test
    public void VerifyAustralianBusinessNoFieldIsNotAcceptingInValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hj 6755d", "7688787", "fgsdsgf", "fggasfdf", "rtwqe", "tyt", "ytredf");

        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.ABNErrorMessage), "Australian Business Number(ABN) should be 11 digits");
    }

    @Test
    public void VerifyAddress1FieldIsAcceptingValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg 6755d", "87527356390", "fgsdsgf", "fggasfdf", "rtwqe", "tyt", "ytredf");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, businessInfoPage.Address1ErrorMessage));
    }

    @Test
    public void VerifyCityFieldIsAcceptingValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg6755d", "87523569390", "fgsdsgf", "fggasfdf", "rtwkjjhke", "", "ytredf");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, businessInfoPage.CityErrorMessage));
    }

    @Test
    public void VerifyCityFieldIsNotAcceptingInValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hj6755d", "65878787786", "fgsdsgf", "fggasfdf", "rt@%#%878768wqe", "tyt", "ytredf");
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, businessInfoPage.ErrorMessages);
        Assert.assertEquals(ActualText.get(0), "Numbers are not acceptable\n" +
                "Special characters are not acceptable");
    }

    @Test
    public void VerifyAreaCodeFieldIsAcceptingValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg6755d", "87523563990", "fgsdsgf", "fggasfdf", "rtwqe", "6465", "ytre@df");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, businessInfoPage.AreaCodeErrorMessage));
    }

    @Test
    public void VerifyAreaCodeFieldIsNotAcceptingInValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg6755d", "76556787656", "fgsdsgf", "fggasfdf", "rtwqe", "rt2@%%355655yrt", "ytredf");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.AreaCodeErrorMessage), "Area Code should be 4 digits");
    }

    @Test
    public void VerifyStateFieldIsAcceptingValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg6755d", "87523563990", "fgsdsgf", "fggasfdf", "rtwqe", "tyry", "ytredf");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, businessInfoPage.StateErrorMessage));
    }

    @Test
    public void VerifyStateFieldIsNotAcceptingInValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg6755d", "65657897086", "fgsdsgf", "fggasfdf", "rtwqe", "7695", "ytr@###465edf");
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, businessInfoPage.ErrorMessages);
        Assert.assertEquals(ActualText.get(0), "Numbers are not acceptable");
        Assert.assertEquals(ActualText.get(1), "Special characters are not acceptable");
    }

    @Test
    public void VerifyCountryFieldIsAcceptingValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg6755d", "87523563990", "fgsdsgf", "fggasf@%%@##df", "rtwqe", "tyry", "ytredf");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, businessInfoPage.CityErrorMessage));
    }

    @Test
    public void VerifyCountryFieldIsNotAcceptingInValidData()
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
        businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("tdf hjg6755d", "65787878786", "fgsdsgf", "fgg@#$5678asfdf", "rtwqe", "7695", "ytredf");
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, businessInfoPage.ErrorMessages);
        Assert.assertEquals(ActualText.get(0), "Numbers are not acceptable\n" +
                "Special characters are not acceptable");
    }
}
