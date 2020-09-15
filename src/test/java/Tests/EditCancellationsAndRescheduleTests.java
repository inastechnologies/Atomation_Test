package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditCancellationsAndRescheduleTests extends BaseTest {

    @Test
    public void VerifyThatIfUserCanClickOnTabAndNavigateToEditCancellationsAndReschedulePageAndPageHasAllTheRequiredFields() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();

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
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();
        editCancelletionAndReschedulePage.EditPencil.click();
        Assert.assertEquals(editCancelletionAndReschedulePage.CustomerCancelHours1.getAttribute("value"), "24");
        Assert.assertEquals(editCancelletionAndReschedulePage.RefundPrice1.getAttribute("value"), "50");
        Assert.assertEquals(editCancelletionAndReschedulePage.TypeOfPrice1.getAttribute("value"), "% of price");

        Assert.assertEquals(editCancelletionAndReschedulePage.RescheduleHours1.getAttribute("value"), "24");
        Assert.assertEquals(editCancelletionAndReschedulePage.ReschedulePrice1.getAttribute("value"), "50");
        Assert.assertEquals(editCancelletionAndReschedulePage.RescheduleTypeOfPrice1.getAttribute("value"), "%of the price");
    }

    @Test
    public void VerifyUserCanNotClickAndEditCancellationAndReSchedulingPolicyInRed() throws InterruptedException {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Harsh@gmail.com", "Harsh@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        cancelletionAndReschedulePage.FillAlTheFieldsInCancellationAndReschedulingPage();
        Thread.sleep(2000);
        EditAppointmentPage editAppointmentPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToEditAvailabilityPage();

        EditCancelletionAndReschedulePage editCancelletionAndReschedulePage = editAppointmentPage.ClickAndNavigateToEditCancellationPage();
        editCancelletionAndReschedulePage.EditPencil.click();


        Assert.assertNull(cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(0).getAttribute("readonly"));
    }
}
