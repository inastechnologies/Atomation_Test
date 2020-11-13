package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditCancellationsAndRescheduleTests extends BaseTest {

    @Test
    public void VerifyThatIfUserCanClickOnTabAndNavigateToEditCancellationsAndReschedulePageAndPageHasAllTheRequiredFields() throws InterruptedException {
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

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(0)), "Cancellation Policy :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(1)), "Customers can cancel online:");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(2)), "Policy description ( visible to the customer ) :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(3)), "Customer cancellation reason :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(4)), "Reschedule Policy :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(5)), "Customers can Reschedule online:");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(6)), "Policy description ( visible to the customer ) :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.MandatoryFields.get(7)), "Customer Reschedule Reason:");
    }

    @Test
    public void VerifyThatTheDataEnteredInCancellationsAndReschedulePageIsMatchingWithTheDataAutoFilledInEditCancellationPage() throws InterruptedException {
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

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.EditPencil.click();
        Assert.assertEquals(editCancelletionAndReschedulePage.CustomerCancelHours1.getAttribute("value"), "24");
        Assert.assertEquals(editCancelletionAndReschedulePage.RefundPrice1.getAttribute("value"), "50");
        Assert.assertEquals(editCancelletionAndReschedulePage.TypeOfPrice1.getAttribute("value"), "% of price");

        Assert.assertEquals(editCancelletionAndReschedulePage.RescheduleHours1.getAttribute("value"), "24");
        Assert.assertEquals(editCancelletionAndReschedulePage.ReschedulePrice1.getAttribute("value"), "50");
        Assert.assertEquals(editCancelletionAndReschedulePage.RescheduleTypeOfPrice1.getAttribute("value"), "% of price");
    }

    @Test
    public void VerifyUserCanNotClickAndEditCancellationAndReSchedulingPolicyInRed() throws InterruptedException {
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

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.EditPencil.click();

        Assert.assertNull(cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(0).getAttribute("readonly"));
    }

    @Test
    public void VerifyPencilIconIsClickableAndAllTheFieldsAreEnabledAndCanBeEdited_EditDataIsReflected() throws InterruptedException {
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

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.EditTheFieldsInCancellationAndReschedulingPage();


        Assert.assertEquals(editCancelletionAndReschedulePage.CustomerCancelHours1.getAttribute("value"), "23");
        Assert.assertEquals(editCancelletionAndReschedulePage.RefundPrice1.getAttribute("value"), "30");
        Assert.assertEquals(editCancelletionAndReschedulePage.TypeOfPrice1.getAttribute("value"), "AUD $ value");

        Assert.assertEquals(editCancelletionAndReschedulePage.RescheduleHours1.getAttribute("value"), "20");
        Assert.assertEquals(editCancelletionAndReschedulePage.ReschedulePrice1.getAttribute("value"), "60");
        Assert.assertEquals(editCancelletionAndReschedulePage.RescheduleTypeOfPrice1.getAttribute("value"), "AUD $ value");
    }

    @Test
    public void VerifyIfUserCanChangeTheSelectionOfRadioButtons() throws InterruptedException {
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

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.EditPencil.click();
        editCancelletionAndReschedulePage.PolicyDescription1.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription1.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription1.get(1)));


        editCancelletionAndReschedulePage.PolicyDescription1.get(1).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription1.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription1.get(0)));


        editCancelletionAndReschedulePage.CustomerCancellationReason1.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(2)));


        editCancelletionAndReschedulePage.CustomerCancellationReason1.get(1).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(2)));

        editCancelletionAndReschedulePage.CustomerCancellationReason1.get(2).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(2)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerCancellationReason1.get(1)));

        editCancelletionAndReschedulePage.PolicyDescription2.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription2.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription2.get(1)));


        editCancelletionAndReschedulePage.PolicyDescription2.get(1).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription2.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.PolicyDescription2.get(0)));


        editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(2)));


        editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(1).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(2)));

        editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(2).click();
        Assert.assertTrue(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(2)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(1)));
    }


    @Test
    public void VerifyIfUserCanEditTheTextInThePolicyDescriptionIfUserSelectsCustomText() throws InterruptedException {
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

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.EditPencil.click();
        editCancelletionAndReschedulePage.PolicyDescription1.get(1).click();
        editCancelletionAndReschedulePage.PolicyDescriptionTextArea1.clear();
        editCancelletionAndReschedulePage.PolicyDescriptionTextArea1.sendKeys("hghsgjaghggah");
        Assert.assertEquals(editCancelletionAndReschedulePage.PolicyDescriptionTextArea1.getAttribute("value"), "hghsgjaghggah");

        editCancelletionAndReschedulePage.PolicyDescription2.get(1).click();
        editCancelletionAndReschedulePage.PolicyDescriptionTextArea2.clear();
        editCancelletionAndReschedulePage.PolicyDescriptionTextArea2.sendKeys("hghsgjaghggah");
        Assert.assertEquals(editCancelletionAndReschedulePage.PolicyDescriptionTextArea1.getAttribute("value"), "hghsgjaghggah");
    }

    @Test
    public void VerifyIfUserSelectsCustomTextTextAreaShouldNotBeEmptyBeforeUpdating() throws InterruptedException {
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

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.EditPencil.click();
        editCancelletionAndReschedulePage.PolicyDescription1.get(1).click();
        editCancelletionAndReschedulePage.PolicyDescriptionTextArea1.clear();

        editCancelletionAndReschedulePage.PolicyDescription2.get(1).click();
        editCancelletionAndReschedulePage.PolicyDescriptionTextArea2.clear();

        editCancelletionAndReschedulePage.CustomerRescheduleReason2.get(0).click();
        editCancelletionAndReschedulePage.SaveAndContinue.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.ErrorMessages.get(0)), "description is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, editCancelletionAndReschedulePage.ErrorMessages.get(1)), "Description is required");
    }

    @Test
    public void VerifySaveButtonIsClickableAfterUpdatingThePageAndSuccessfulMessageIsAppearing() throws InterruptedException {
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

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

        Thread.sleep(2000);
        editCancelletionAndReschedulePage.EditTheFieldsInCancellationAndReschedulingPage();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Successful')]"))), "Successful");
    }
}
