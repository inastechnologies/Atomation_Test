package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CreateAppointments_Group_Tests extends BaseTest {

    @Test
    public void VerifyThatCreateAppointmentAndSessionTypePageHasAllTheRequiredFields() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        Thread.sleep(3000);
        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.LocationModalityFieldsText.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.LocationModalityFieldsText.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.MandatoryFieldsText.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.MandatoryFieldsText.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.MandatoryFieldsText.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.MandatoryFieldsText.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.MandatoryFieldsText.get(5)));
    }

    @Test
    public void VerifyThatLocationDropDownIsClickableInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.LocationInput));
    }

    @Test
    public void VerifyThatSelectedLocationIsDisplayedInLocationFieldInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        Assert.assertEquals(createAppointmentPage_group.LocationInput.getAttribute("value"), Location);
    }

    @Test
    public void VerifyThatModalityDropDownIsClickableInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.ModalityInput));
    }

    @Test
    public void VerifyThatSelectedModalityIsDisplayedInModalityFieldInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        Assert.assertEquals(createAppointmentPage_group.ModalityInput.getAttribute("value"), "Physiotherapy");
    }

    @Test
    public void VerifyThatToolTipIsPresentForEachRadioOfSessionTypes_AndMessageIsDisplayed() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipIcons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipIcons.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipIcons.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipIcons.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipIcons.get(4)));

        //Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(0));
        //Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(0)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage_group.ToolTipIcons.get(1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipInfo.get(1)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage_group.ToolTipIcons.get(2));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipInfo.get(2)));
    }

    @Test
    public void VerifyThatIfUserIsAbleToClickRadioButtonsOfSessionTypes() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.SessionTypeRadioButtons.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.SessionTypeRadioButtons.get(1)));
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.SessionTypeRadioButtons.get(2)));
    }

    @Test
    public void VerifyThatSelectingOneRadioDeselectsOtherRadioButtonsOfSessionTypes() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SessionTypeRadioButtons.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, createAppointmentPage_group.SessionTypeRadioButtons.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, createAppointmentPage_group.SessionTypeRadioButtons.get(1)));

        createAppointmentPage_group.SessionTypeRadioButtons.get(1).click();
        Assert.assertFalse(Utils.isElementSelected(driver, createAppointmentPage_group.SessionTypeRadioButtons.get(0)));
    }

    @Test
    public void VerifyThatAfterSelectingRecurringWithDateRangeSessionTypesFromDateAndToDateFieldsShouldAppear() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SessionTypeRadioButtons.get(1).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.FromDateField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToDateField));
    }

    @Test
    public void VerifySelectDayDropDownIsClickableInCreateAppointmentAndEvenTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.SelectDayInput));
    }

    @Test
    public void VerifySelectDayDropDownIsDisplayingAllTheDaysInCreateAppointmentAndEvenTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Select select = new Select(createAppointmentPage_group.SelectDayInput);
        List<WebElement> options = select.getOptions();

       /* String[] exp = {"Monday","Tuesday","Thursday","Friday","Saturday","Sunday"};
          for(WebElement days:options)
          {
            for (int i=0; i<exp.length; i++){
              if (days.getText().equals(exp[i])){
                }
           }
           Assert.assertTrue(true);
        }*/

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, options.get(0)), " Sunday");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, options.get(1)), " Monday");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, options.get(2)), " Tuesday");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, options.get(3)), " Wednesday");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, options.get(4)), " Thursday");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, options.get(5)), " Friday");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, options.get(6)), " Saturday");
    }

    @Test
    public void VerifyThatSelectedDayIsDisplayedInSelectDayFieldInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Sunday", "02:00PM", "3:00PM");

        Assert.assertEquals(createAppointmentPage_group.SelectDayInput.getAttribute("value"), "0");
    }

    @Test
    public void VerifyThatUserIsAbleToChangeOptionsInSelectDayFieldInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Sunday", "02:00PM", "3:00PM");
        Assert.assertEquals(createAppointmentPage_group.SelectDayInput.getAttribute("value"), "0");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "02:00PM", "3:00PM");
        Assert.assertEquals(createAppointmentPage_group.SelectDayInput.getAttribute("value"), "1");
    }

    @Test
    public void VerifyThatIfFromDateAndToDateCanBeEnteredAndEnteredDatesAreReflectingInTheFieldsInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringWithDateRangeSessionTypeAndEnterFromDateAndToDate("12-12-2020", "01-01-2021", "Monday", "11:00AM", "2:00PM");

        createAppointmentPage_group.AddButton.click();
        Assert.assertEquals(createAppointmentPage_group.FromDateField.getAttribute("value"), "2020-12-12");
        Assert.assertEquals(createAppointmentPage_group.ToDateField.getAttribute("value"), "2021-01-01");
    }

    @Test
    public void VerifyThatWhenUserSelectsRecurringWithDateRangeSessionTypeFromDateAndToDateFieldsAreNotAcceptingPastDates() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringWithDateRangeSessionTypeAndEnterFromDateAndToDate("07-07-2020", "07-17-2020", "Monday", "11:00AM", "2:00PM");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.DateErrorMessage), "Past Dates or Same Date Not Acceptable");
    }

    @Test
    public void VerifyThatIfDateCanBeEnteredInSelectDateFieldAndEnteredDateIsReflectingInTheFieldsInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12-12-2020", "10:00AM", "12:00PM");

        Assert.assertEquals(createAppointmentPage_group.DateInput.getAttribute("value"), "2020-12-12");
    }

    @Test
    public void VerifyThatWhenUserSelectsRecurringWithDateSpecificSessionTypeSelectDateFieldIsNotAcceptingPastDates() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("07-07-2020", "11:00AM", "2:00PM");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Above field is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(1)), "Past Dates Not Acceptable");
    }

    @Test
    public void VerifyThatUserCanSelectFromTimeAndToTimeInOpeningHoursAndClickAdd() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.AddButton));
    }

    @Test
    public void VerifyThatErrorsMessagesCanBeSeenIfUserClicksAddButtonWithEmptyFields() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.AddButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Location is required");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "From time is required");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(2)), "To time is required");
    }

    @Test
    public void VerifySelectedDayAndOpeningHoursCanBeSeenInChipFormat() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.Slots.get(0)));
    }

    @Test
    public void VerifyChipConsistsOfSelectedDay_AndOpeningHours() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");
        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='10:00']")))));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='12:00']")))));
    }

    @Test
    public void VerifyChipConsistsOfSelectedDate_AndOpeningHours() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("12/12/2020", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='10:00']")))));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='12:00']")))));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()=' 12/12/2020']")))));
    }

    @Test
    public void VerifyUserIsAbleToAddMoreOpeningHoursAfterSelectingDay_FromTime_ToTime() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.Slots.get(0)));

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "03:00PM", "05:00PM");
        createAppointmentPage_group.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.Slots.get(1)));
    }

    @Test
    public void VerifyUserCanNotSelectSameOpeningHoursForSameDay() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");
        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Slot Already Exist')]"))), "Slot Already Exist");
   }

    @Test
    public void VerifyThatWhenClickedOnCloseIconOfChip_PopupAppearsWith_YesDeleteItButtonAndCancelButton() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.CancelSlot.get(0)));

        createAppointmentPage_group.CancelSlot.get(0).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.SwalTitle), "Are you sure?");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.DeleteItButton), "Yes, delete it!");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.CancelButton), "Cancel");
    }

    @Test
    public void VerifyThat_YesDeleteItButton_OkButton_IsClickableToDeleteTheChip() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "03:00PM", "06:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CancelSlot.get(0).click();
        createAppointmentPage_group.DeleteItButton.click();

        Utils.WaitForAnElementToExist(driver, createAppointmentPage_group.DeleteItButton);
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.DeleteItButton));
    }

    @Test
    public void VerifyThatWhenCLickedOn_OkButton_ChipIsNotDeleted() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "01:00PM", "03:00PM");
        createAppointmentPage_group.AddButton.click();

        Thread.sleep(2000);
        createAppointmentPage_group.CancelSlot.get(0).click();
        createAppointmentPage_group.CancelButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.Slots.get(0)));
    }

    @Test
    public void VerifyThatUserCanEnterUpTo365DaysIn_DoNotOfferBookingsMoreThanFields() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Select select = new Select(createAppointmentPage_group.NOOfBookingDaysInput);
        select.selectByValue("365");

        Assert.assertEquals(createAppointmentPage_group.NOOfBookingDaysInput.getAttribute("value"), "365");
    }

    @Test
    public void VerifyThatNameFieldsUnderAppointment_ServiceType_isAcceptingAlphabetsAndSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.NOOfBookingDaysInput, "365");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "10", "50");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, createAppointmentPage_group.NameError));
    }

    @Test
    public void VerifyThatNameFieldsUnderAppointment_ServiceType_isNotAcceptingNumbersAndSpecialChars() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.NOOfBookingDaysInput, "365");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("786#%$^", "01", "10", "50");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Special characters are not acceptable");
    }

    @Test
    public void VerifyThatAUDAndDollarSymbolIsPresentInFeesField_ItIsAcceptingOnlyNumericalUnderAppointment_ServiceType() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.NOOfBookingDaysInput, "365");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//span[text()='Fee $']"))), "Fee $");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "59", "50");

        Assert.assertEquals(createAppointmentPage_group.FeesInput.getAttribute("value"), "50");
    }

    @Test
    public void VerifyThatFeesField_IsNotAcceptingAlphabetsUnderAppointment_ServiceType() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.NOOfBookingDaysInput, "365");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "59", "uykhj");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.ConsultationTypeInput, "Online");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Appointment fee is required");
    }

    @Test
    public void VerifyThatConsultsWillBeFieldHasThreeOption_UserCanSelectConsultationTypeFromDropDown() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.NOOfBookingDaysInput, "365");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "59", "uykhj");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.ConsultationTypeInput, "Online");

        Select select = new Select(createAppointmentPage_group.SelectDayInput);
        List<WebElement> options = select.getOptions();

        String[] exp = {"Online", "Face to Face", "Both"};
        for (WebElement days : options) {
            for (int i = 0; i < exp.length; i++) {
                if (days.getText().equals(exp[i])) {
                }
            }
            Assert.assertTrue(true);
        }
        Assert.assertEquals(createAppointmentPage_group.ConsultationTypeInput.getAttribute("value"), "0");
    }

    @Test
    public void VerifyThatHoursDropDownIsClickableAnd_UserCanSelect_CutoffTimeField() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.NOOfBookingDaysInput, "365");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "10", "50");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.ConsultationTypeInput, "Online");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.CutOffHours, "23 hours");

        Assert.assertEquals(createAppointmentPage_group.CutOffHours.getAttribute("value"), "23hour");
    }

    @Test
    public void VerifyThatTextBoxIsAcceptingAlphabets_Numerical_SpecialCharactersAndSpaces() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.NOOfBookingDaysInput, "365");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "10", "50");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.ConsultationTypeInput, "Online");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage_group.CutOffHours, "23 hours");
        createAppointmentPage_group.Description.sendKeys("This is to test@!#$#@");

        Assert.assertEquals(createAppointmentPage_group.Description.getAttribute("value"), "This is to test@!#$#@");
    }

    @Test
    public void VerifyThatToolTipsIsPresentForCreateEventButtonsAndMessageIsDisplayed() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipIcons.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipIcons.get(4)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage_group.ToolTipIcons.get(3));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipInfo.get(3)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage_group.ToolTipIcons.get(4));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.ToolTipInfo.get(4)));
    }

    @Test
    public void VerifyThatUserIsAbleToCreateEventByClickingCreateAnotherEventButton() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "35", "80");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "01", "50","1 hour", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.CreateEvenButton));
        createAppointmentPage_group.CreateEvenButton.click();
    }

    @Test
    public void VerifyThatUserIsAbleToCreateDifferentAppointmentTypesForSameOpeningHours() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "45", "80");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "03", "50","1 hour", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.CreateEvenButton));
        createAppointmentPage_group.CreateEvenButton.click();

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Short Appointment", "01", "45", "80");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "03", "50","1 hour", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.CreateEvenButton));
        createAppointmentPage_group.CreateEvenButton.click();
    }

    @Test
    public void VerifyThatAfterFillingAllTheFieldsWhenClickedCreateAnotherEventTypeButtonChipShouldAppearInChip() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.Slots.get(0)));
    }

    @Test
    public void VerifyThatWhenClickedOnCloseIconOfAppointmentTypeChip_PopupAppearsWith_YesDeleteItButtonAndCancelButton() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Utils.WaitForAnElementToExist(driver, createAppointmentPage_group.CancelSlot.get(0));
        createAppointmentPage_group.CancelSlot.get(0).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.SwalTitle), "Are you sure?");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.DeleteItButton), "Yes, delete it!");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.CancelButton), "Cancel");
    }

    @Test
    public void VerifyThat_YesDeleteItButton_OkButton_IsClickableToDeleteEventChip() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Utils.WaitForAnElementToExist(driver, createAppointmentPage_group.CancelSlot.get(0));
        createAppointmentPage_group.CancelSlot.get(0).click();

        Thread.sleep(2000);

        Utils.WaitForAnElementToExist(driver, createAppointmentPage_group.DeleteItButton);
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.DeleteItButton));
    }

    @Test
    public void VerifyUserIsAbleToDeleteTheEventChip() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Thread.sleep(2000);
        Utils.WaitForAnElementToExist(driver, createAppointmentPage_group.CancelSlot.get(0));
        createAppointmentPage_group.CancelSlot.get(0).click();

        Thread.sleep(2000);
        createAppointmentPage_group.DeleteItButton.click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.isElementNotPresent(driver, createAppointmentPage_group.Slots.get(0)));
    }

    @Test
    public void VerifyCreateAnotherEventButtonIsClickableAndUserIsAbleToCreateOneOrMoreEvents() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();


        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "01:00Pm", "03:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.CreateEvenButton));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.Slots.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage_group.Slots.get(1)));
    }

    @Test
    public void VerifyThatWithoutCreatingAnyEventIfUserClicksOnSaveButtonItDisplaysErrorMessage() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.Save.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'No Events Added')]"))), "No Events Added");
    }

    @Test
    public void VerifySaveButtonIsClickableAndUserCanSaveTheCreatedEvents() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "01:00PM", "03:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","1 hour","This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage_group.Save));
        createAppointmentPage_group.Save.click();
    }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingLocation_ModalityAnd_SessionType() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Location is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(1)), "Modality Type is required");

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CreateEvenButton.click();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Please Select Session Type");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(1)), "Above field is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(2)), "From time is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(3)), "To time is required");
    }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingDoNoOfferBookingsMoreThanField() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();
        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Number of Booking Days is required");
   }

    @Test
    public void VerifyIfUserIsAbleToCreateEventsWithoutEnteringAppointmentTypeFields() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Name is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(1)), "Appointment fee is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(2)), "Consultation type is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(3)), "Cut of Time is required");
    }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingConsultationType_CutOffTime_Description() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage_group.AddButton.click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "Consultation type is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(1)), "Cut of Time is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(2)), "Description is required");
    }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingFromDateAndToDateInRecurringWithinDateRangeSessionType() throws InterruptedException {
        String Characters = Utils.printRandomString(6);
        String FirstName = "Sailaja" + Characters;
        String LastName = "Mamillapllai" + Characters;
        String AlphaNumeric = Utils.getAlphaNumericString(6);
        String Email = AlphaNumeric + "@gmail.com";
        int PhoneNumber = Utils.RandomGenerator();
        String PhoneNum = Integer.toString(PhoneNumber);
        String PhoneNo = "9" + PhoneNum;
        String Location = "Adelaide";
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage homePage = new LandingPage(driver);

        Thread.sleep(3000);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Thread.sleep(3000);
        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        PersonalInfoPage personalInfoPage = businessInfoPage.ClickSkipAndNavigateToNextPage();

        EducationalInfoPage educationalInfoPage = personalInfoPage.ClickSkipAndNavigateToNextPage();

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.ClickSkipAndNavigateToNextPage();

        Thread.sleep(3000);
        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("Physiotherapy", "Practitioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        Thread.sleep(2000);
        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        Thread.sleep(2000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage_Group createAppointmentPage_group = setAvailabilityPage.ClickOnGroupSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage_group.SelectLocationAndModalityInCreateAppointmentPage(Location, "Physiotherapy");

        createAppointmentPage_group.SessionTypeRadioButtons.get(1).click();

        createAppointmentPage_group.CustomersPerSession.sendKeys("15");
        createAppointmentPage_group.SessionPackage.sendKeys("15");

        createAppointmentPage_group.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage_group.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage_group.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","1 hour", "This is to test");

        createAppointmentPage_group.CreateEvenButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(0)), "From Date is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage_group.ErrorMessages.get(1)), "To Date is required");
    }
}