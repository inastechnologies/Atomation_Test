package Tests;

import Pages.*;
import Utils.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CancellationsAndRescheduleTests extends BaseTest {

    @Test
    public void VerifyIfUserCanClickAndNavigateToCancellationAndReSchedulingPage()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(0)), "Cancellation Policy :");
    }

    @Test
    public void VerifyIfUserCanSeeAllTheSubSectionsInCancellationAndReSchedulingPage()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(0)), "Cancellation Policy :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(1)), "Customers can cancel online:");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(2)), "Policy description ( visible to the customer ) :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(3)), "Customer cancellation reason :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(4)), "Reschedule Policy :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(5)), "Customers can Reschedule online:");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(6)), "Policy description ( visible to the customer ) :");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(7)), "Customer Reschedule Reason :");
    }

    @Test
    public void VerifyIfUserCanSeeCancellationAndReSchedulingPolicyInRed()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(0)), "(i) Refunds are not processed automatically via Q nature, It happens via Latpay");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(1)), "(i) Refunds are not processed automatically via Q nature, It happens via Latpay");
    }

    @Test
    public void VerifyUserCanNotClickAndEditCancellationAndReSchedulingPolicyInRed()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        //WebElement some_element = driver.findElement(By.id("some_id"));
        //String readonly = some_element.getAttribute("readonly");
        //Assert.assertNull(readonly);


        Assert.assertNull(cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(0).getAttribute("readonly"));
        Assert.assertNull(cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(0).getAttribute("readonly"));
    }

    @Test
    public void VerifyIfTheUserCanSeeTheRefundPoliciesUnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.CustomerCancelHours1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.RefundPrice1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.CustomerCancelHours2));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.RefundPrice2));

        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.RescheduleHours1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.ReschedulePrice1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.RescheduleHours2));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.ReschedulePrice2));
    }

    @Test
    public void VerifyIfTheUserCanSelectHoursFromDropDownAndSelectedHoursReflectInTheField_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        Assert.assertEquals(cancelletionAndReschedulePage.CustomerCancelHours1.getAttribute("value"), "22");
        Assert.assertEquals(cancelletionAndReschedulePage.CustomerCancelHours2.getAttribute("value"), "2");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        Assert.assertEquals(cancelletionAndReschedulePage.RescheduleHours1.getAttribute("value"), "20");
        Assert.assertEquals(cancelletionAndReschedulePage.RescheduleHours2.getAttribute("value"), "2");
    }

    @Test
    public void VerifyIfHoursDropDownHas1To24Hours_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Select select = new Select(cancelletionAndReschedulePage.CustomerCancelHours1);
        List<WebElement> options = select.getOptions();

         String[] exp = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
          for(WebElement days:options)
          {
            for (int i=0; i<exp.length; i++){
              if (days.getText().equals(exp[i])){
                }
           }
           Assert.assertTrue(true);
        }

         select = new Select(cancelletionAndReschedulePage.CustomerCancelHours2);
        List<WebElement> options1 = select.getOptions();

        String[] exp1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
        for(WebElement days:options1)
        {
            for (int i=0; i<exp1.length; i++){
                if (days.getText().equals(exp1[i])){
                }
            }
            Assert.assertTrue(true);
        }

        select = new Select(cancelletionAndReschedulePage.RescheduleHours1);
        List<WebElement> options2 = select.getOptions();

        String[] exp2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
        for(WebElement days:options2)
        {
            for (int i=0; i<exp2.length; i++){
                if (days.getText().equals(exp2[i])){
                }
            }
            Assert.assertTrue(true);
        }

        select = new Select(cancelletionAndReschedulePage.RescheduleHours2);
        List<WebElement> options3 = select.getOptions();

        String[] exp3 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
        for(WebElement days:options3)
        {
            for (int i=0; i<exp3.length; i++){
                if (days.getText().equals(exp3[i])){
                }
            }
            Assert.assertTrue(true);
        }
    }

    @Test
    public void VerifyIfTheUserCanEnterTextInThePriceFieldAndEnteredPriceReflectInTheField_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        Assert.assertEquals(cancelletionAndReschedulePage.RefundPrice1.getAttribute("value"), "50");
        Assert.assertEquals(cancelletionAndReschedulePage.RefundPrice2.getAttribute("value"), "10");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        Assert.assertEquals(cancelletionAndReschedulePage.ReschedulePrice1.getAttribute("value"), "50");
        Assert.assertEquals(cancelletionAndReschedulePage.ReschedulePrice2.getAttribute("value"), "10");
    }

    @Test
    public void VerifyIfPriceFieldIsNotAcceptingAlphabetsSpecialCharactersAnd_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "jh%#@ &^&^ghj", "%of the price", "2", "j^%^%^ &^%hg", "%of the price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "jh^%^ gj", "%of the price", "2", "^%&^%^%hjgj ^&%", "%of the price");

        cancelletionAndReschedulePage.SaveAndContinue.click();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.ErrorMessages.get(0)), "Price is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.ErrorMessages.get(1)), "Price is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.ErrorMessages.get(4)), "Price is required");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.ErrorMessages.get(5)), "Price is required");
    }

    @Test
    public void VerifyIfPriceFieldHasInformationIconAndWhenHoveredOnItMessageIsDisplayed_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Utils.MouseHoverToAnElement(driver, cancelletionAndReschedulePage.ToolTipIcons.get(0));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(0)));

        Utils.MouseHoverToAnElement(driver, cancelletionAndReschedulePage.ToolTipIcons.get(1));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, createAppointmentPage.ToolTipInfo.get(1)));
    }

    @Test
    public void VerifyIfUserCanSelectTypeOfPriceFromDropDownAndSelectedTypeIsReflectingInTheField_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        Assert.assertEquals(cancelletionAndReschedulePage.TypeOfPrice1.getAttribute("value"), "% of price");
        Assert.assertEquals(cancelletionAndReschedulePage.TypeOfPrice2.getAttribute("value"), "% of price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        Assert.assertEquals(cancelletionAndReschedulePage.RescheduleTypeOfPrice1.getAttribute("value"), "%of the price");
        Assert.assertEquals(cancelletionAndReschedulePage.RescheduleTypeOfPrice2.getAttribute("value"), "%of the price");
    }

    @Test
    public void VerifyIfTypeOfPriceDropDownHasTwoOptions_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Select select = new Select(cancelletionAndReschedulePage.CustomerCancelHours1);
        List<WebElement> options = select.getOptions();

        String[] exp = {"%of the price","AUD $ value"};
        for(WebElement days:options)
        {
            for (int i=0; i<exp.length; i++){
                if (days.getText().equals(exp[i])){
                }
            }
            Assert.assertTrue(true);
        }

        select = new Select(cancelletionAndReschedulePage.CustomerCancelHours2);
        List<WebElement> options1 = select.getOptions();

        String[] exp1 = {"%of the price","AUD $ value"};
        for(WebElement days:options1)
        {
            for (int i=0; i<exp1.length; i++){
                if (days.getText().equals(exp1[i])){
                }
            }
            Assert.assertTrue(true);
        }

        select = new Select(cancelletionAndReschedulePage.RescheduleHours1);
        List<WebElement> options2 = select.getOptions();

        String[] exp2 = {"%of the price","AUD $ value"};
        for(WebElement days:options2)
        {
            for (int i=0; i<exp2.length; i++){
                if (days.getText().equals(exp2[i])){
                }
            }
            Assert.assertTrue(true);
        }

        select = new Select(cancelletionAndReschedulePage.RescheduleHours2);
        List<WebElement> options3 = select.getOptions();

        String[] exp3 = {"%of the price","AUD $ value"};
        for(WebElement days:options3)
        {
            for (int i=0; i<exp3.length; i++){
                if (days.getText().equals(exp3[i])){
                }
            }
            Assert.assertTrue(true);
        }
    }

    @Test
    public void VerifyIfUserCanSeeSystemTextOptionAndCustomTextOptionInPolicyDescription_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "jh%#@ &^&^ghj", "%of the price", "2", "j^%^%^ &^%hg", "%of the price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "jh^%^ gj", "%of the price", "2", "^%&^%^%hjgj ^&%", "%of the price");

        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescription1.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescription1.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescription2.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescription2.get(1)));
    }

    @Test
    public void VerifyIfBothSystemTextAndCustomTextCanBeSelectedAtOnce_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        Utils.WaitForAnElementToExist(driver, cancelletionAndReschedulePage.PolicyDescription1.get(0));
        cancelletionAndReschedulePage.PolicyDescription1.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, cancelletionAndReschedulePage.PolicyDescription1.get(0)));

        Assert.assertFalse(Utils.isElementSelected(driver, cancelletionAndReschedulePage.PolicyDescription1.get(1)));

        cancelletionAndReschedulePage.PolicyDescription2.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, cancelletionAndReschedulePage.PolicyDescription2.get(0)));

        Assert.assertFalse(Utils.isElementSelected(driver, cancelletionAndReschedulePage.PolicyDescription2.get(1)));
    }

    @Test
    public void VerifyIfUserSelectsCustomTextATextBoxAppearsAndTextCanBeEntered_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.PolicyDescription1.get(1).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescriptionTextArea1));
        cancelletionAndReschedulePage.PolicyDescriptionTextArea1.sendKeys("jhkhiufhghg jghg");

        cancelletionAndReschedulePage.PolicyDescription2.get(1).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescriptionTextArea2));
        cancelletionAndReschedulePage.PolicyDescriptionTextArea2.sendKeys("jhkhiufhghg jghg");
    }

    @Test
    public void VerifyIfUserSelectsCustomText_TextBoxAcceptsAlphabetsNumericalSpecialCharAndSpaces_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.PolicyDescription1.get(1).click();
        cancelletionAndReschedulePage.PolicyDescriptionTextArea1.sendKeys("jhkhiufhg@^76675hg jghg");

        cancelletionAndReschedulePage.PolicyDescription2.get(1).click();
        cancelletionAndReschedulePage.PolicyDescriptionTextArea2.sendKeys("jhkh6565 #@%iufhghg jghg");

        cancelletionAndReschedulePage.SaveAndContinue.click();

        Assert.assertFalse(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescriptionError1));
        Assert.assertFalse(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescriptionError2));
    }

    @Test
    public void VerifyIfUserSelectsSystemTextATextBoxAppears_UnderThe_CustomersCanCancelOnline_And_CustomersCanRescheduleOnline() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.PolicyDescription1.get(0).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescriptionTextArea1));

        cancelletionAndReschedulePage.PolicyDescription2.get(0).click();
        Assert.assertTrue(Utils.IsElementDisplayed(driver, cancelletionAndReschedulePage.PolicyDescriptionTextArea2));
    }

    @Test
    public void VerifyIfUserCanSeeThreeOptionsAndOneOptionCanBeSelectedAtOnce_UnderThe_CustomersCancellationReason_And_CustomersRescheduleReason() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");

        cancelletionAndReschedulePage.PolicyDescription1.get(1).click();
        cancelletionAndReschedulePage.PolicyDescriptionTextArea1.sendKeys("jhkhiufhg@^76675hg jghg");

        cancelletionAndReschedulePage.CustomerCancellationReason1.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, cancelletionAndReschedulePage.CustomerCancellationReason1.get(0)));

        Assert.assertFalse(Utils.isElementSelected(driver, cancelletionAndReschedulePage.CustomerCancellationReason1.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, cancelletionAndReschedulePage.CustomerCancellationReason1.get(2)));

        cancelletionAndReschedulePage.CustomerCancellationReason2.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, cancelletionAndReschedulePage.CustomerCancellationReason1.get(0)));

        Assert.assertFalse(Utils.isElementSelected(driver, cancelletionAndReschedulePage.CustomerCancellationReason1.get(1)));
        Assert.assertFalse(Utils.isElementSelected(driver, cancelletionAndReschedulePage.CustomerCancellationReason1.get(2)));
    }

    @Test
    public void VerifyIfWhenAllTheFieldsAreEnteredSaveButtonIsClickableAndSuccessMessageIsDisplayed() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanCancelOnline("22", "50", "%of the price", "2", "10", "%of the price");
        cancelletionAndReschedulePage.PolicyDescription1.get(1).click();
        cancelletionAndReschedulePage.PolicyDescriptionTextArea1.sendKeys("jhkhiufhg@^76675hg jghg");
        cancelletionAndReschedulePage.CustomerCancellationReason1.get(2).click();


        cancelletionAndReschedulePage.SelectHoursAndEnterTextUnder_CustomersCanRescheduleOnline("20", "50", "%of the price", "2", "10", "%of the price");
        cancelletionAndReschedulePage.PolicyDescription2.get(1).click();
        cancelletionAndReschedulePage.PolicyDescriptionTextArea2.sendKeys("jhkhiufhg@^76675hg jghg");
        cancelletionAndReschedulePage.CustomerCancellationReason2.get(2).click();

        Assert.assertTrue(Utils.isClickable(driver, cancelletionAndReschedulePage.SaveAndContinue));
        cancelletionAndReschedulePage.SaveAndContinue.click();

        Thread.sleep(1000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, driver.findElement(By.xpath("//*[contains(text(),'Success')]"))), "Success");
    }
}
