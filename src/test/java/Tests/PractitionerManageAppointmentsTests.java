package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PractitionerManageAppointmentsTests extends BaseTest {
    @Test
    public void VerifyIfTheUseIsAbleToLandOntoPractitionerHomePageAfterSuccessfulVerification() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("test", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.ManageAppointments), "MANAGE APPOINTMENTS");
    }

    @Test
    public void VerifyThatMANAGEAPPOINTMENTSIsClickable() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("test", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        Assert.assertTrue(Utils.isClickable(driver, practitionerManageAppointmentsPage.ManageAppointments));
    }

    @Test
    public void VerifyThatWhenClickedOnManageAppointmentsACalendarWidgetCanBeSeen() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("test", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ManageAppointments.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.CalendarHeading), "June 2020");
    }

    @Test
    public void VerifyThatByDefaultCurrentMonthCalendarShouldDisplay() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("test", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ManageAppointments.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.CalendarHeading), "June 2020");
    }

    @Test
    public void VerifyThatUserCanMoveToPreviousAndNextMonthCalendar() throws InterruptedException {
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

        businessInfoPage.CLickEveryFieldBeforeEnteringTheDataInBusinessInfoPage();
        PersonalInfoPage personalInfoPage = businessInfoPage.EnterDataIntoAllTheFieldsInBusinessInfoPageAndClickNext("Rainbow Children",
                "87523586390", "Nizampet Main Road", "India", "Sydney", "5377", "Telangana");

        EducationalInfoPage educationalInfoPage = personalInfoPage.EnterDateOfBirthUploadPictureAndClickNext("02/02/2000", personalInfoPage.DOBInputField);

        PracticeServiceDescriptionPage practiceServiceDescriptionPage = educationalInfoPage.EnterDataIntoAllTheFieldsInEducationInfoPageAndClickNext("MSC Chemistry",
                "Holistic Hospitals", "6587234996", "2020", "01/02/2021");

        VerifyYourAccountPage verifyYourAccountPage = practiceServiceDescriptionPage.EnterDataIntoAllTheFieldsInPracticeServiceDescriptionPageAndClickNext("test", "Practistioner", "fytftfytjf", "fggfgfgfhfh", "trytrgffhf", "hgjg");

        VerificationCodePage verificationCodePage = verifyYourAccountPage.EnterPhoneOrEmailAndClickGetVerificationCode(PhoneNo);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = verificationCodePage.EnterCodeAndClickSubmit("1", "2", "3", "4");

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ManageAppointments.click();

        practitionerManageAppointmentsPage.ForwardButton.click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.CalendarHeading), "July 2020");

        practitionerManageAppointmentsPage.ReverseButton.click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.CalendarHeading), "June 2020");
    }

    @Test
    public void VerifyThatUserIsCanLandOntoPractitionerHomePageAfterLogin() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        Thread.sleep(3000);
        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Ayati@gmail.com", "Thannidi@270116");

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.ManageAppointments), "MANAGE APPOINTMENTS");
    }

    @Test
    public void VerifyWhenHoveringOnDateAllConfirmedAppointmentsAndRejectedAppointmentsCanBeSeen() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Ayati@gmail.com", "Thannidi@270116");

        Thread.sleep(3000);
        practitionerManageAppointmentsPage.ManageAppointments.click();

        Utils.MouseHoverToAnElement(driver, practitionerManageAppointmentsPage.June10);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.ConfirmedAppointment), "1 appointments Confirmed");
    }

    @Test
    public void VerifyThatWhenClickedOnParticularDateUserCanSeeAllTheAppointmentsOfThatDay() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Ayati@gmail.com", "Thannidi@270116");

        practitionerManageAppointmentsPage.ClickOnDateToCheckTheAppointments("17");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//div[text()='asdf']"))), "asdf");
    }

    @Test
    public void VerifyThatAnAlertBoxShouldPopupWhenClickedOnParticularAppointment() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Ayati@gmail.com", "Thannidi@270116");

        practitionerManageAppointmentsPage.ClickOnDateToCheckTheAppointments("17");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='asdf']")).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.SwalTitle), "Are you sure?");
    }

    @Test
    public void VerifyThatRejectAppointmentAndCancelButtonsArePresentInAlertBoxWhenClickedOnAppointment() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Ayati@gmail.com", "Thannidi@270116");

        practitionerManageAppointmentsPage.ClickOnDateToCheckTheAppointments("17");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='asdf']")).click();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.RejectAppointmentButton), "Reject Appointment");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, practitionerManageAppointmentsPage.CancelButton), "Cancel");
    }

    @Test
    public void VerifyThatRejectAppointmentAndCancelButtonsInAlertBoxAreClickableWhenClickedOnAppointment() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Ayati@gmail.com", "Thannidi@270116");

        practitionerManageAppointmentsPage.ClickOnDateToCheckTheAppointments("17");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='asdf']")).click();

        Assert.assertTrue(Utils.isClickable(driver, practitionerManageAppointmentsPage.RejectAppointmentButton), "Reject Appointment");
        Assert.assertTrue(Utils.isClickable(driver, practitionerManageAppointmentsPage.CancelButton), "Cancel");
    }
}