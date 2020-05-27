package Tests;

import Pages.*;
import Utils.Utils;
import jdk.jshell.execution.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SignUpTests extends  BaseTest
{
    @Test
    public void VerifyIfFindAskBookAndHomeIconsAreClickableInSignUpPage()
    {
        LandingPage landingPage = new LandingPage(driver);
        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();

        Utils.WaitForElementsToExist(driver, signUpPage.HeaderIcons);

        Assert.assertTrue(Utils.isClickable(driver, signUpPage.HeaderIcons.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.HeaderIcons.get(1)));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.HeaderIcons.get(2)));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.HeaderIcons.get(3)));
    }

    @Test
    public void VerifyWhenWeClickOnTheHomeIconItNavigatesToHomePage()
    {
        LandingPage landingPage = new LandingPage(driver);
        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();

        Utils.WaitForElementsToExist(driver, signUpPage.HeaderIcons);

        signUpPage.HeaderIcons.get(3).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.BecomeTheNaturallyYouText), "Become The Naturally you");
    }

    @Test
    public void VerifyIfSignUpPageHasAllTheRequiredFields()
    {
        LandingPage landingPage = new LandingPage(driver);
        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.CLickEveryFieldBeforeEnteringTheData();
        String ExpectedFirstNameFieldText = "First Name *";
        String ActualFirstNameFieldText = Utils.GetTextFromAnElement(driver, signUpPage.FirstNameFieldText);
        Assert.assertEquals(ActualFirstNameFieldText, ExpectedFirstNameFieldText);

        String ExpectedLastNameFieldText = "Last Name *";
        String ActualLastNameFieldText = Utils.GetTextFromAnElement(driver, signUpPage.LastNameFieldText);
        Assert.assertEquals(ActualLastNameFieldText, ExpectedLastNameFieldText);

        String ExpectedEmailFieldText = "Email Id *";
        String ActualEmailFieldText = Utils.GetTextFromAnElement(driver, signUpPage.EmailFieldText);
        Assert.assertEquals(ActualEmailFieldText, ExpectedEmailFieldText);

        String ExpectedMobileNumberText = "Mobile No *";
        String ActualMobileNumberText = Utils.GetTextFromAnElement(driver, signUpPage.MobileNumberFieldText);
        Assert.assertEquals(ActualMobileNumberText, ExpectedMobileNumberText);

        String ExpectedLocationText = "Location *";
        String ActualLocationText = Utils.GetTextFromAnElement(driver, signUpPage.LocationFieldText);
        Assert.assertEquals(ActualLocationText, ExpectedLocationText);

        String ExpectedPasswordText = "Password *";
        String ActualPasswordText = Utils.GetTextFromAnElement(driver, signUpPage.PasswordFieldText);
        Assert.assertEquals(ActualPasswordText, ExpectedPasswordText);

        String ExpectedConfirmPasswordText = "Confirm Password *";
        String ActualConfirmPasswordText = Utils.GetTextFromAnElement(driver, signUpPage.ConfirmPasswordFieldText);
        Assert.assertEquals(ActualConfirmPasswordText, ExpectedConfirmPasswordText);

        String ExpectedPractitionerText = "Practitioner";
        String ActualPractitionerText = Utils.GetTextFromAnElement(driver, signUpPage.PractitionerText);
        Assert.assertEquals(ActualPractitionerText, ExpectedPractitionerText);

        String ExpectedHealthStoreOwnerText = "Health Store Owner";
        String ActualHealthStoreOwnerText = Utils.GetTextFromAnElement(driver, signUpPage.HealthStoreOwnerText);
        Assert.assertEquals(ActualHealthStoreOwnerText, ExpectedHealthStoreOwnerText);

        String ExpectedCustomerText = "Customer";
        String ActualCustomerText = Utils.GetTextFromAnElement(driver, signUpPage.CustomerText);
        Assert.assertEquals(ActualCustomerText, ExpectedCustomerText);

        String ExpectedInstitutionText = "Institution / College";
        String ActualInstitutionText = Utils.GetTextFromAnElement(driver, signUpPage.InstitutionCollageText);
        Assert.assertEquals(ActualInstitutionText, ExpectedInstitutionText);

        String ExpectedEventOrganizerText = "Event Organizer";
        String ActualEventOrganizerText = Utils.GetTextFromAnElement(driver, signUpPage.EventOrganizerText);
        Assert.assertEquals(ActualEventOrganizerText, ExpectedEventOrganizerText);

        String ExpectedClinicText = "Clinic / Organizer / Enterprise";
        String ActualClinicText = Utils.GetTextFromAnElement(driver, signUpPage.ClinicOrganizerEnterpriseText);
        Assert.assertEquals(ActualClinicText, ExpectedClinicText);
    }

    @Test
    public void VerifyIfAllTheFieldsInTheSignUpPageAreClickable()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();

        Assert.assertTrue(Utils.isClickable(driver, signUpPage.FirstNameInputBox));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.LastNameInputBox));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.EmailInputBox));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.MobileNumberInputBox));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.LocationInputBox));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.PasswordInputBox));
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.ConfirmPasswordInputBox));
    }

    @Test
    public void VerifyWhenWeClickOnThePractitionerCategoryItNavigatesToRegistrationScreen()
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.BusinessInfoText), "Business Information");
    }

    @Test
    public void VerifyWhenWeClickOnTheClinicCategoryItNavigatesToRegistrationScreen()
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClinicRadioButton.click();
        signUpPage.AcceptTermsCheckBox.click();
        signUpPage.SignUpButton.click();
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyWhenWeClickOnTheCustomerCategoryItNavigatesToRegistrationScreen()
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.CustomerRadioButton.click();
        signUpPage.AcceptTermsCheckBox.click();
        signUpPage.SignUpButton.click();
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyWhenWeClickOnTheHealthStoreCategoryItNavigatesToRegistrationScreen()
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.HealthStoreOwnerRadioButton.click();
        signUpPage.AcceptTermsCheckBox.click();
        signUpPage.SignUpButton.click();
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyWhenWeClickOnTheEventOrganizerCategoryItNavigatesToRegistrationScreen()
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.EventOrganizerRadioButton.click();
        signUpPage.AcceptTermsCheckBox.click();
        signUpPage.SignUpButton.click();
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyWhenWeClickOnTheInstitutionCategoryItNavigatesToRegistrationScreen()
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.InstitutionRadioButton.click();
        signUpPage.AcceptTermsCheckBox.click();
        signUpPage.SignUpButton.click();
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    @Test
    public void VerifyIfAllTheFieldsInTheSignUpPageIsClickableAndEditable()
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
        LandingPage landingPage = new LandingPage(driver);
        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();

        Assert.assertTrue(Utils.isClickable(driver, signUpPage.SignUpButton));

        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);

        Assert.assertEquals(signUpPage.FirstNameInputBox.getAttribute("value"), FirstName);
        signUpPage.FirstNameInputBox.clear();

        Assert.assertEquals(signUpPage.LastNameInputBox.getAttribute("value"), LastName);
        signUpPage.LastNameInputBox.clear();

        Assert.assertEquals(signUpPage.EmailInputBox.getAttribute("value"), Email);
        signUpPage.EmailInputBox.clear();

        Assert.assertEquals(signUpPage.MobileNumberInputBox.getAttribute("value"), PhoneNo);
        signUpPage.MobileNumberInputBox.clear();

        Assert.assertEquals(signUpPage.LocationInputBox.getAttribute("value"), Location);
        signUpPage.LocationInputBox.clear();

        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);

        Assert.assertEquals(signUpPage.FirstNameInputBox.getAttribute("value"), FirstName);
        Assert.assertEquals(signUpPage.LastNameInputBox.getAttribute("value"), LastName);
        Assert.assertEquals(signUpPage.EmailInputBox.getAttribute("value"), Email);
        Assert.assertEquals(signUpPage.MobileNumberInputBox.getAttribute("value"), PhoneNo);
        Assert.assertEquals(signUpPage.LocationInputBox.getAttribute("value"), Location);
    }

    @Test
    public void VerifyIfPractitionerAndClinicHasRadioButtonsAndSelectedOneAtaTime()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();

        Utils.WaitForAnElementToExist(driver, signUpPage.PractitionerRadioButton);

        signUpPage.PractitionerRadioButton.click();
        Assert.assertTrue(Utils.isElementSelected(driver, signUpPage.PractitionerRadioButton));

        signUpPage.ClinicRadioButton.click();
        Assert.assertFalse(Utils.isElementSelected(driver, signUpPage.PractitionerRadioButton));
    }

    @Test
    public void VerifyIfTermsAndConditionsFieldHasCheckBoxAndCanBeTickedAndUnTicked()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();

        Utils.WaitForAnElementToExist(driver, signUpPage.AcceptTermsCheckBox);
        signUpPage.AcceptTermsCheckBox.click();
        Assert.assertTrue(Utils.isElementSelected(driver, signUpPage.AcceptTermsCheckBox));

        signUpPage.AcceptTermsCheckBox.click();
        Assert.assertFalse(Utils.isElementSelected(driver, signUpPage.AcceptTermsCheckBox));
    }

    @Test
    public void VerifyIfAllMandatoryFieldsHaveStarMark()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.CLickEveryFieldBeforeEnteringTheData();
        String ExpectedFirstNameFieldText = "First Name *";
        String ActualFirstNameFieldText = Utils.GetTextFromAnElement(driver, signUpPage.FirstNameFieldText);
        Assert.assertEquals(ActualFirstNameFieldText, ExpectedFirstNameFieldText);

        String ExpectedLastNameFieldText = "Last Name *";
        String ActualLastNameFieldText = Utils.GetTextFromAnElement(driver, signUpPage.LastNameFieldText);
        Assert.assertEquals(ActualLastNameFieldText, ExpectedLastNameFieldText);

        String ExpectedEmailFieldText = "Email Id *";
        String ActualEmailFieldText = Utils.GetTextFromAnElement(driver, signUpPage.EmailFieldText);
        Assert.assertEquals(ActualEmailFieldText, ExpectedEmailFieldText);

        String ExpectedMobileNumberText = "Mobile No *";
        String ActualMobileNumberText = Utils.GetTextFromAnElement(driver, signUpPage.MobileNumberFieldText);
        Assert.assertEquals(ActualMobileNumberText, ExpectedMobileNumberText);

        String ExpectedPasswordText = "Password *";
        String ActualPasswordText = Utils.GetTextFromAnElement(driver, signUpPage.PasswordFieldText);
        Assert.assertEquals(ActualPasswordText, ExpectedPasswordText);

        String ExpectedConfirmPasswordText = "Confirm Password *";
        String ActualConfirmPasswordText = Utils.GetTextFromAnElement(driver, signUpPage.ConfirmPasswordFieldText);
        Assert.assertEquals(ActualConfirmPasswordText, ExpectedConfirmPasswordText);
    }

    @Test
    public void VerifyUserCanNotRegisterWithoutClickingTermsAndConditionsCheckBox()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.CLickEveryFieldBeforeEnteringTheData();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage("fhdgf", "hffhhf", "@gmail.com", "9000373959", "Hyderabad", "GGGG1234", "GGGG1234");
        signUpPage.PractitionerRadioButton.click();

        signUpPage.SignUpButton.click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.TermsAndConditionsErrorMessage), "Please agree");
    }

    @Test
    public void VerifyFirstNameFieldIsAcceptingValidDataWithCombinationOfUpperCaseAndLowercaseAlphabets()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Saialja" + Characters;
        String LastName = "Mamillaplai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gm";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertFalse(Utils.IsElementDisplayed(driver, signUpPage.ValidNameErrorMessage));
    }

    @Test
    public void VerifyFirstNameFieldIsNotAcceptingInValidDataWithCombinationOfNumbersAndSpecialCharactersAndSpaces()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "hgj765#!@#% ^&*()_+=?><|~{}|'|?" + Characters;
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, signUpPage.FirstNameErrorMessage);
        Assert.assertEquals(ActualText.get(0), "Special characters are not acceptable");
        Assert.assertEquals(ActualText.get(1), "Numbers are not acceptable");
    }
    @Test
    public void VerifyLastNameFieldIsAcceptingValidDataWithCombinationOfUpperCaseAndLowercaseAlphabets()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Saialja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "96886" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";

        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();

        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Assert.assertFalse(Utils.IsElementDisplayed(driver, signUpPage.ValidNameErrorMessage));
    }

    @Test
    public void VerifyLastNameFieldIsNotAcceptingInValidDataWithCombinationOfNumbersAndSpecialCharactersAndSpaces()
    {
        String Characters = Utils.printRandomString(6);
        String Firstname = "Sailaja" + Characters;
        String LastName = "6765 #%^&*()@" + Characters;
        String AlfaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlfaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlfaNumeric + "@J5";
        String ConfirmPassword = AlfaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(Firstname, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.LastNameErrorMessage1), "Special characters are not acceptable");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.LastNameErrorMessage2), "Numbers are not acceptable");
    }

    @Test
    public void VerifyEmailFieldIsAcceptingValidDataWithEmailFormatAlphabetsAndNumaricals()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Saialja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "955533" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertFalse(Utils.IsElementDisplayed(driver, signUpPage.EmailErrorMessage));
    }

    @Test
    public void VerifyEmailFieldIsNotAcceptingInValidDataWithSpecialCharactersAndSpaces()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Saialja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@& ^% %";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.ValidEmailErrorMessage), "Email must be a valid email address");
    }

    @Test
    public void VerifyMobileNumberFieldIsAcceptingValidDataWithNumericalUpto10Digits()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Saialja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@g";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertFalse(Utils.IsElementDisplayed(driver, signUpPage.MobileErrorMessage));
    }

    @Test
    public void VerifyMobileNumberFieldIsNotAcceptingInValidDataWithAlphabetsSpecialCharactersAndSpaces()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Saialja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "956%hh jjgY*" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.validMobileErrorMessage), "Mobile Number should be 10 digits");
    }

    @Test
    public void VerifyLocationFieldIsNotAcceptingInValidData()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillaplla" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "@#%#%";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@J5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.InvalidLocationErrorMessage), "Location must be in Alphabets");
    }

    @Test
    public void VerifyPasswordFieldIsAcceptingValidDataWithAtLeast8CharactersIncludingOneNumberAndOneSplChar()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillaplla" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "93553" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "6@";
        String ConfirmPassword = AlphaNumeric + "6@";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertFalse(Utils.IsElementDisplayed(driver, signUpPage.PasswordErrorMessage));
    }

    @Test
    public void VerifyPasswordFieldIsNotAcceptingInValidDataWithOutAlphabetsNumbersAndTwoSplChar()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillaplla" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(3);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = "@@";
        String ConfirmPassword = AlphaNumeric + "@@67";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);

        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

          Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.InvalidPasswordOneNumberError), "It should contain one Number");
          Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.InvalidPasswordOneSplCharError), "It should contain only one SpecialChar");
          Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.InvalidPasswordLengthError), "Password length must be atleast 8 letters");
          Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.InvalidPasswordUpperCaseError), "It should contain one UpperCase");
          Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.InvalidPasswordLowerCaseError), "It should contain one LowerCase");
    }

    @Test
    public void VerifyPasswordFieldInSignUpPageHasPasswordProtectedEyeAndCanBeTickedAndUnTicked()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();

        Utils.WaitForElementsToExist(driver, signUpPage.PasswordEye);

        Assert.assertTrue(Utils.isClickable(driver, signUpPage.PasswordEye.get(0)));

        Assert.assertTrue(Utils.isClickable(driver, signUpPage.PasswordEye.get(1)));
    }

    @Test
    public void VerifyConfirmPasswordFieldIsAcceptingValidDataWithAtLeast8CharactersIncludingOneNumberAndOneSplChar()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillaplla" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "93553" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "6@";
        String ConfirmPassword = AlphaNumeric + "6@";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertFalse(Utils.IsElementDisplayed(driver, signUpPage.ConfirmPasswordErrorMessage));
    }

    @Test
    public void VerifyConfirmPasswordFieldIsNotAcceptingInValidData()
    {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillaplla" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Hyderabad";
        String Password = AlphaNumeric + "@J5";
        String ConfirmPassword = AlphaNumeric + "@Jkjhjh%5";
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);

        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.ValidConfirmPasswordErrorMessage), "Passwords must match");
    }

    @Test
    public void VerifySignUpButtonIsWorkingAndUserCanSuccessfullyRegisterWithValidData()
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
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo , Location, Password, ConfirmPassword);
        signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
    }

    @Test
    public void VerifyIfUserCanRegisterWithoutEnteringTheDataInSignUpPage()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();

        signUpPage.CLickEveryFieldBeforeEnteringTheData();

        signUpPage.ClickSignUpButtonWithEmptyFields();

        String ExpectedNameErrorText = "Name is required";
        String ActualNameErrorText = Utils.GetTextFromAnElement(driver, signUpPage.FirstNameErrorMessage.get(0));
        Assert.assertEquals(ActualNameErrorText, ExpectedNameErrorText);

        String ExpectedMobileNumberErrorText = "Mobile Number is required";
        String ActualMobileNumberErrorText = Utils.GetTextFromAnElement(driver, signUpPage.MobileErrorMessage);
        Assert.assertEquals(ActualMobileNumberErrorText, ExpectedMobileNumberErrorText);

        String ExpectedEmailErrorText = "Email is required";
        String ActualEmailErrorText = Utils.GetTextFromAnElement(driver, signUpPage.EmailErrorMessage);
        Assert.assertEquals(ActualEmailErrorText, ExpectedEmailErrorText);

        String ExpectedPasswordErrorText = "Password is required";
        String ActualPasswordErrorText = Utils.GetTextFromAnElement(driver, signUpPage.PasswordErrorMessage);
        Assert.assertEquals(ActualPasswordErrorText, ExpectedPasswordErrorText);

        String ExpectedConfirmPasswordErrorText = "Confirm Password is required";
        String ActualConfirmPasswordErrorText = Utils.GetTextFromAnElement(driver, signUpPage.ConfirmPasswordErrorMessage);
        Assert.assertEquals(ActualConfirmPasswordErrorText, ExpectedConfirmPasswordErrorText);

        /*String ExpectedLocationErrorText = "Location is required";
        String ActualLocationErrorText = Utils.GetTextFromAnElement(driver, signUpPage.LocationErrorMessage);
        Assert.assertEquals(ActualLocationErrorText, ExpectedLocationErrorText);*/
    }

    @Test
    public void VerifyLoginInButtonIsClickableAndUserCanNavigateToLoginPage()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        Utils.WaitForAnElementToExist(driver, signUpPage.LoginButton);
        Assert.assertTrue(Utils.isClickable(driver, signUpPage.LoginButton));
        signUpPage.LoginButton.click();
    }
}
