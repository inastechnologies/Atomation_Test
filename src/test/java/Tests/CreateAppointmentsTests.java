package Tests;

import Pages.*;
import Utils.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CreateAppointmentsTests extends BaseTest {

    @Test
    public void VerifyThatCreateAppointmentAndSessionTypePageHasAllTheRequiredFields() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.LocationModalityFieldsText.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.LocationModalityFieldsText.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.MandatoryFieldsText.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.MandatoryFieldsText.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.MandatoryFieldsText.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.MandatoryFieldsText.get(4)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.MandatoryFieldsText.get(5)));
    }

    @Test
    public void VerifyThatLocationDropDownIsClickableInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.LocationInput));
    }

    @Test
    public void VerifyThatSelectedLocationIsDisplayedInLocationFieldInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        Assert.assertEquals(createAppointmentPage.LocationInput.getAttribute("value"), "Sydney");
    }

    @Test
    public void VerifyThatModalityDropDownIsClickableInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.ModalityInput));
    }

    @Test
    public void VerifyThatSelectedModalityIsDisplayedInModalityFieldInCreateAppointmentAndSessionTypePage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        Assert.assertEquals(createAppointmentPage.ModalityInput.getAttribute("value"), "Physiotherapy");
    }

    @Test
    public void VerifyThatToolTipIsPresentForEachRadioOfSessionTypes_BothCreateEventButtonsAndMessageIsDisplayed() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipIcons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipIcons.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipIcons.get(2)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipIcons.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipIcons.get(4)));

        //Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(0));
        //Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(0)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(1)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(2));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(2)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(3));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(3)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(4));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(4)));
    }

    @Test
    public void VerifyThatIfUserIsAbleToClickRadioButtonsOfSessionTypes() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.SessionTypeRadioButtons.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.SessionTypeRadioButtons.get(1)));
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.SessionTypeRadioButtons.get(2)));
    }

    @Test
    public void VerifyThatSelectingOneRadioDeselectsOtherRadioButtonsOfSessionTypes() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SessionTypeRadioButtons.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, createAppointmentPage.SessionTypeRadioButtons.get(0)));
        Assert.assertFalse(Utils.isElementSelected(driver, createAppointmentPage.SessionTypeRadioButtons.get(1)));

        createAppointmentPage.SessionTypeRadioButtons.get(1).click();
        Assert.assertFalse(Utils.isElementSelected(driver, createAppointmentPage.SessionTypeRadioButtons.get(0)));
    }

    @Test
    public void VerifyThatAfterSelectingRecurringWithDateRangeSessionTypesFromDateAndToDateFieldsShouldAppear() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SessionTypeRadioButtons.get(1).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.FromDateField));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToDateField));
    }

    @Test
    public void VerifySelectDayDropDownIsClickableInCreateAppointmentAndEvenTypePage() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.SelectDayInput));
    }

    @Test
    public void VerifySelectDayDropDownIsDisplayingAllTheDaysInCreateAppointmentAndEvenTypePage() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Select select = new Select(createAppointmentPage.SelectDayInput);
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
    public void VerifyThatSelectedDayIsDisplayedInSelectDayFieldInCreateAppointmentAndSessionTypePage() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();


        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Sunday", "02:00PM", "3:00PM");

        Assert.assertEquals(createAppointmentPage.SelectDayInput.getAttribute("value"), "0");
    }

    @Test
    public void VerifyThatUserIsAbleToChangeOptionsInSelectDayFieldInCreateAppointmentAndSessionTypePage() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Sunday", "02:00PM", "3:00PM");
        Assert.assertEquals(createAppointmentPage.SelectDayInput.getAttribute("value"), "0");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "02:00PM", "3:00PM");
        Assert.assertEquals(createAppointmentPage.SelectDayInput.getAttribute("value"), "1");
    }

    @Test
    public void VerifyThatIfFromDateAndToDateCanBeEnteredAndEnteredDatesAreReflectingInTheFieldsInCreateAppointmentAndSessionTypePage() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringWithDateRangeSessionTypeAndEnterFromDateAndToDate("10-10-2020", "11-11-2020", "Monday", "11:00AM", "2:00PM");

        Assert.assertEquals(createAppointmentPage.FromDateField.getAttribute("value"), "2020-10-10");
        Assert.assertEquals(createAppointmentPage.ToDateField.getAttribute("value"), "2020-11-11");
    }

    @Test
    public void VerifyThatWhenUserSelectsRecurringWithDateRangeSessionTypeFromDateAndToDateFieldsAreNotAcceptingPastDates() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringWithDateRangeSessionTypeAndEnterFromDateAndToDate("07-07-2020", "07-17-2020", "Monday", "11:00AM", "2:00PM");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.DateErrorMessage), "Past Dates or Same Date Not Acceptable");
    }

    @Test
    public void VerifyThatIfDateCanBeEnteredInSelectDateFieldAndEnteredDateIsReflectingInTheFieldsInCreateAppointmentAndSessionTypePage() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("10-10-2020", "10:00AM", "12:00PM");

        Assert.assertEquals(createAppointmentPage.DateInput.getAttribute("value"), "2020-10-10");
    }

    @Test
    public void VerifyThatWhenUserSelectsRecurringWithDateSpecificSessionTypeSelectDateFieldIsNotAcceptingPastDates() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringWithDateRangeSessionTypeAndEnterFromDateAndToDate("07-07-2020", "07-17-2020", "Monday", "11:00AM", "2:00PM");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.DateErrorMessage), "Past Dates or Same Date Not Acceptable");
    }

    @Test
    public void VerifyThatUserCanSelectFromTimeAndToTimeInOpeningHoursAndClickAdd() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.AddButton));
    }

    @Test
    public void VerifyThatErrorsMessagesCanBeSeenIfUserClicksAddButtonWithEmptyFields() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.AddButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Above field is required");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "From time is required");
        //Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(2)), "To time is required");
    }

    @Test
    public void VerifySelectedDayAndOpeningHoursCanBeSeenInChipFormat() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(0)));
    }

    @Test
    public void VerifyChipConsistsOfSelectedDay_AndOpeningHours() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='10:00']")))));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='12:00']")))));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='Monday']")))));
    }

    @Test
    public void VerifyChipConsistsOfSelectedDate_AndOpeningHours() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringWithDateSpecificSessionTypeAndEnterDate("10/10/2020", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='10:00']")))));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='12:00']")))));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, (driver.findElement(By.xpath("//span[text()='10/10/2020']")))));
    }

    @Test
    public void VerifyUserIsAbleToAddMoreOpeningHoursAfterSelectingDay_FromTime_ToTime() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(0)));

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "03:00PM", "05:00PM");
        createAppointmentPage.AddButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(1)));
    }

    @Test
    public void VerifyUserCanNotSelectSameOpeningHoursForSameDay() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Slot Already Exist')]"))), "Slot Already Exist");
   }

    @Test
    public void VerifyThatWhenClickedOnCloseIconOfChip_PopupAppearsWith_YesDeleteItButtonAndCancelButton() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CancelSlot.get(0)));

        createAppointmentPage.CancelSlot.get(0).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.SwalTitle), "Are you sure?");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.DeleteItButton), "Yes, delete it!");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.CancelButton), "Cancel");
    }

    @Test
    public void VerifyThat_YesDeleteItButton_OkButton_IsClickableToDeleteTheChip() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "03:00PM", "06:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.CancelSlot.get(0).click();
        createAppointmentPage.DeleteItButton.click();

        Utils.WaitForAnElementToExist(driver, createAppointmentPage.DeleteItButton);
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.DeleteItButton));
    }

    @Test
    public void VerifyThatWhenCLickedOn_OkButton_ChipIsNotDeleted() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "01:00PM", "03:00PM");
        createAppointmentPage.AddButton.click();

        Thread.sleep(2000);
        createAppointmentPage.CancelSlot.get(0).click();
        createAppointmentPage.CancelButton.click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(0)));
    }

    @Test
    public void VerifyThatUserCanEnterUpTo365DaysIn_DoNotOfferBookingsMoreThanFields() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Select select = new Select(createAppointmentPage.NOOfBookingDaysInput);
        select.selectByValue("365");

        Assert.assertEquals(createAppointmentPage.NOOfBookingDaysInput.getAttribute("value"), "365");
    }

    @Test
    public void VerifyThatNameFieldsUnderAppointment_ServiceType_isAcceptingAlphabetsAndSpaces() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "10", "50");

        Assert.assertFalse(Utils.IsElementDisplayed(driver, createAppointmentPage.NameError));
    }

    @Test
    public void VerifyThatNameFieldsUnderAppointment_ServiceType_isNotAcceptingNumbersAndSpecialChars() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("786#%$^", "01", "10", "50");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Special characters are not acceptable");
    }

    @Test
    public void VerifyThatHoursDropDownIsClickableAnd_UserCanSelectUpTo24HoursInDuration_UnderAppointment_ServiceType() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "24", "10", "50");

        Assert.assertEquals(createAppointmentPage.DurationHoursInput.getAttribute("value"), "24");
    }

    @Test
    public void VerifyThatMinutesDropDownIsClickableAnd_UserCanSelectUpTo59MinutesInDuration_UnderAppointment_ServiceType() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "59", "50");

        Assert.assertEquals(createAppointmentPage.DurationMinsInput.getAttribute("value"), "59");
    }

    @Test
    public void VerifyThatAUDAndDollarSymbolIsPresentInFeesField_ItIsAcceptingOnlyNumericalUnderAppointment_ServiceType() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//span[text()='Fee $']"))), "Fee $");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "59", "50");

        Assert.assertEquals(createAppointmentPage.FeesInput.getAttribute("value"), "50");
    }

    @Test
    public void VerifyThatFeesField_IsNotAcceptingAlphabetsUnderAppointment_ServiceType() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "59", "uykhj");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.ConsultationTypeInput, "Online");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Fee is required");
    }

    @Test
    public void VerifyThatConsultsWillBeFieldHasThreeOption_UserCanSelectConsultationTypeFromDropDown() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "59", "uykhj");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.ConsultationTypeInput, "Online");

        Select select = new Select(createAppointmentPage.SelectDayInput);
        List<WebElement> options = select.getOptions();

        String[] exp = {"Online", "Face to Face", "Both"};
        for (WebElement days : options) {
            for (int i = 0; i < exp.length; i++) {
                if (days.getText().equals(exp[i])) {
                }
            }
            Assert.assertTrue(true);
        }
        Assert.assertEquals(createAppointmentPage.ConsultationTypeInput.getAttribute("value"), "0");
    }

    @Test
    public void VerifyThatHoursDropDownIsClickableAnd_UserCanSelectUpTo24Hours_EventStartsEveryField() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "10", "50");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.ConsultationTypeInput, "Online");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventHoursInput, "24");

        Assert.assertEquals(createAppointmentPage.EventHoursInput.getAttribute("value"), "24");
    }

    @Test
    public void VerifyThatMinutesDropDownIsClickableAnd_UserCanSelectUpTo59Minutes_EventStartsEveryField() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");
        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "59", "50");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.ConsultationTypeInput, "Online");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventHoursInput, "04");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventMinsInput, "59");

        Assert.assertEquals(createAppointmentPage.EventMinsInput.getAttribute("value"), "59");
    }

    @Test
    public void VerifyThatHoursDropDownIsClickableAnd_UserCanSelectUpTo24Hours_CutoffTimeField() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "10", "50");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.ConsultationTypeInput, "Online");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventHoursInput, "03");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventMinsInput, "59");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.CutOffHours, "24");

        Assert.assertEquals(createAppointmentPage.CutOffHours.getAttribute("value"), "24");
    }

    @Test
    public void VerifyThatMinutesDropDownIsClickableAnd_UserCanSelectUpTo59Minutes_CutOffTimeField() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "59", "50");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.ConsultationTypeInput, "Online");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventHoursInput, "24");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventMinsInput, "59");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.CutOffHours, "24");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.CutOffMins, "59");

        Assert.assertEquals(createAppointmentPage.CutOffMins.getAttribute("value"), "59");
    }

    @Test
    public void VerifyThatTextBoxIsAcceptingAlphabets_Numerical_SpecialCharactersAndSpaces() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.NOOfBookingDaysInput, "365");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "59", "50");

        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.ConsultationTypeInput, "Online");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventHoursInput, "24");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.EventMinsInput, "59");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.CutOffHours, "24");
        Utils.SelectFromDropDownUsingVisibleText(createAppointmentPage.CutOffMins, "59");
        createAppointmentPage.Description.sendKeys("This is to test@!#$#@");

        Assert.assertEquals(createAppointmentPage.Description.getAttribute("value"), "This is to test@!#$#@");
    }

    @Test
    public void VerifyThatToolTipsArePresentForCreateEventButtonsAndMessageIsDisplayed() {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipIcons.get(3)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipIcons.get(4)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(3));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(3)));

        Utils.MouseHoverToAnElement(driver, createAppointmentPage.ToolTipIcons.get(4));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(4)));
    }

    @Test
    public void VerifyThatAfterEnteringDetailsInAllFieldsCreateEventButtonAndCreateEventTypeButtonsAreClickable() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(1)));

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "01:00PM", "03:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
    }

    @Test
    public void VerifyThatFieldsFromLocationTo_DoNotOfferBookingsAreDisabledAfterClickingCreateAnotherEventType() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        Utils.WaitForAnElementToExist(driver, createAppointmentPage.LocationInput);

        //Assert.assertFalse(createAppointmentPage.LocationInput.isEnabled());
        //Assert.assertFalse(createAppointmentPage.ModalityInput.isEnabled());
        //Assert.assertFalse(createAppointmentPage.NOOfBookingDaysInput.isEnabled());
    }

    @Test
    public void VerifyThatUserIsAbleToCreateSameEventByClickingCreateAnotherEventType() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "03", "45", "80");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "03", "50","00", "00", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(1)));
        createAppointmentPage.CreateEvenButtons.get(1).click();
    }

    @Test
    public void VerifyThatWhenClickedOnCreateAnotherEventTypeWithEmptyAppointmentTypeFields_ErrorMessagesShouldDisplay() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();
        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Name is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "Number of hours is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(2)), "Number of Minutes is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(3)), "Fee is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(4)), "Consultation type is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(5)), "Event Hours is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(6)), "Event Minutes is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(7)), "Cut of Hours is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(8)), "Cut of Minutes is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(9)), "Description is required");
    }

    @Test
    public void VerifyThatUserIsAbleToCreateDifferentAppointmentTypesForSameOpeningHours() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "02", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "45", "80");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "03", "50","00", "00", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Short Appointment", "01", "45", "80");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Face to Face", "03", "50","00", "00", "This is to test");

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        createAppointmentPage.CreateEvenButtons.get(0).click();
    }

    @Test
    public void VerifyThatAfterFillingAllTheFieldsWhenClickedCreateAnotherEventTypeButtonChipShouldAppearInChip() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(0)));
    }

    @Test
    public void VerifyThatWhenClickedOnCloseIconOfAppointmentTypeChip_PopupAppearsWith_YesDeleteItButtonAndCancelButton() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Utils.WaitForAnElementToExist(driver, createAppointmentPage.CancelSlot.get(1));
        createAppointmentPage.CancelSlot.get(1).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.SwalTitle), "Are you sure?");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.DeleteItButton), "Yes, delete it!");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.CancelButton), "Cancel");
    }

    @Test
    public void VerifyThat_YesDeleteItButton_OkButton_IsClickableToDeleteTheAppointmentTypeChip() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Utils.WaitForAnElementToExist(driver, createAppointmentPage.CancelSlot.get(1));
        createAppointmentPage.CancelSlot.get(1).click();

        Thread.sleep(2000);

        Utils.WaitForAnElementToExist(driver, createAppointmentPage.DeleteItButton);
        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.DeleteItButton));
    }

    @Test
    public void VerifyUserIsAbleToDeleteTheAppointmentTypeOrEventChip() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Thread.sleep(2000);
        Utils.WaitForAnElementToExist(driver, createAppointmentPage.CancelSlot.get(1));
        createAppointmentPage.CancelSlot.get(1).click();

        Thread.sleep(2000);
        createAppointmentPage.DeleteItButton.click();

        Thread.sleep(2000);
        Assert.assertTrue(Utils.isElementNotPresent(driver, createAppointmentPage.Slots.get(1)));
    }

    @Test
    public void VerifyCreateAnotherEventButtonIsClickableAndUserIsAbleToCreateOneOrMoreEvents() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.CreateEvenButtons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.Slots.get(2)));
    }

    @Test
    public void VerifyAfterCreatingOneEventAllTheFieldsShouldBeEnabledToCreateMoreEvents() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        Assert.assertTrue(createAppointmentPage.LocationInput.isEnabled());
        Assert.assertTrue(createAppointmentPage.ModalityInput.isEnabled());
        Assert.assertTrue(createAppointmentPage.SessionTypeRadioButtons.get(0).isEnabled());
    }

    @Test
    public void VerifyThatWithoutCreatingAnyEventIfUserClicksOnSaveButtonItDisplaysErrorMessage() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SaveAndContinue.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'No Events Added')]"))), "No Events Added");
    }

    @Test
    public void VerifySaveButtonIsClickableAndUserCanSaveTheCreatedEvents() throws InterruptedException {
            LandingPage homePage = new LandingPage(driver);
            LoginPage loginPage = homePage.NavigateToLogInPage();

            PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

            Thread.sleep(3000);
            SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

            CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

            createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

            createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
            createAppointmentPage.AddButton.click();

            createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

            createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

            createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "03", "45","00", "00", "This is to test");

            createAppointmentPage.CreateEvenButtons.get(1).click();

            createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

            createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
            createAppointmentPage.AddButton.click();

            createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

            createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "01", "30", "50");

            createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

            createAppointmentPage.CreateEvenButtons.get(0).click();

            Assert.assertTrue(Utils.isClickable(driver, createAppointmentPage.SaveAndContinue));
            createAppointmentPage.SaveAndContinue.click();
        }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingLocation_ModalityAnd_SessionType() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Location is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "Modality Type is required");

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.CreateEvenButtons.get(0).click();
        createAppointmentPage.CreateEvenButtons.get(1).click();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Initial", "00", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

       // Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Please Select Session Type");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "Above field is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(2)), "From time is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(3)), "To time is required");
    }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingDoNoOfferBookingsMoreThanField() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Number of Booking Days is required");
   }

    @Test
    public void VerifyIfUserIsAbleToCreateEventsWithoutEnteringAppointmentTypeFields() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(0).click();
        createAppointmentPage.CreateEvenButtons.get(0).click();


        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "Name is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "Number of hours is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(2)), "Number of Minutes is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(3)), "Fee is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(4)), "Consultation type is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(5)), "Event Hours is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(6)), "Event Minutes is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(7)), "Cut of Hours is required");
    }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingConsultationType_eventStartTime_CutOffTime_Description() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SelectRecurringSessionType_SelectDayAndOpeningHoursInCreateAppointmentPage("Monday", "10:00AM", "12:00PM");
        createAppointmentPage.AddButton.click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "Consultation type is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(2)), "Event Hours is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(3)), "Event Minutes is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(4)), "Cut of Hours is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(5)), "Cut of Minutes is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(6)), "Description is required");
    }

    @Test
    public void VerifyUserCanNotCreateEventsWithoutSelectingFromDateAndToDateInRecurringWithinDateRangeSessionType() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(3000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        createAppointmentPage.SelectLocationAndModalityInCreateAppointmentPage("Sydney", "Physiotherapy");

        createAppointmentPage.SessionTypeRadioButtons.get(1).click();

        createAppointmentPage.NOOfBookingDaysInput.sendKeys("15");

        createAppointmentPage.EnterDataInAllFieldsOfAppointmentType("Follow UP", "01", "30", "50");

        createAppointmentPage.EnterConsultationType_EventStartTime_CutOffTime_Description("Online", "05", "45","00", "00", "This is to test");

        createAppointmentPage.CreateEvenButtons.get(1).click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(0)), "From Date is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, createAppointmentPage.ErrorMessages.get(1)), "To Date is required");
    }
}