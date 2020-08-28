package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetCancellationsAndRescheduleTests extends BaseTest {

    @Test
    public void VerifyIfUserCanClickAndNavigateToSetCancellationAndReSchedulingPage()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, cancelletionAndReschedulePage.MandatoryFields.get(0)), "Cancellation Policy :");
    }

    @Test
    public void VerifyIfUserCanSeeAllTheSubSectionsInSetCancellationAndReSchedulingPage()  {
        LandingPage homePage = new LandingPage(driver);
        LoginPage loginPage = homePage.NavigateToLogInPage();

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

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

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

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

        PractitionerManageAppointmentsPage practitionerManageAppointmentsPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("Luckky@gmail.com", "Luckky@270116");

        SetAvailabilityPage setAvailabilityPage = practitionerManageAppointmentsPage.ClickManageAppointmentsTabAndNavigateToSetAvailabilityPage();

        CreateAppointmentPage createAppointmentPage = setAvailabilityPage.ClickOnOneOnOneSessionTypeAndNavigateToCreateAppointmentAndEventTypePage();

        CancelletionAndReschedulePage cancelletionAndReschedulePage = createAppointmentPage.ClickAndNavigateToSetCancellationAndReschedulingPage();

        //WebElement some_element = driver.findElement(By.id("some_id"));
        //String readonly = some_element.getAttribute("readonly");
        //Assert.assertNull(readonly);

        Assert.assertNull(cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(0).getAttribute("readonly"));
        Assert.assertNull(cancelletionAndReschedulePage.CancellationReschedulingPolicyInRed.get(0).getAttribute("readonly"));
    }
}
