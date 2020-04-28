package Tests;

import Pages.AdminPanelPage;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class IntegrationTests extends BaseTest
{
    @Test //working
    public void VerifyUserCanLoginSuccessfullyWithRegisteredMobileNoAndPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        AdminPanelPage adminPanelPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin(" 9090909090", "Test@123");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");
    }

    @Test //working
    public void VerifyUserCanLoginSuccessfullyWithRegisteredEmailAndPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        AdminPanelPage adminPanelPage = loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("lolo@gmail.com", "Test@123");

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AdminPanelMessage), "Welcome to QNature");

    }

    @Test// working
    public void VerifyUserCanLoginWithInvalidMobileNumberAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("6566%%%", "Test_123");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);

        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test// working
    public void VerifyUserCanNotLoginWithInvalidEmailIdAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("6566%%%", "Test_123");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test// working
    public void VerifyUserCanLoginWithValidMobileNoAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("9000000009", "hjgjggjgg");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test//  working
    public void VerifyUserCanLoginWithValidEmailAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("ghanwar@gmail.com", "hj3gjgg");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test//  working
    public void VerifyUserCanLoginWithInvalidMobileNoAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("65676%%*55", "hj3gjg*g");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test//  working
    public void VerifyUserCanLoginWithInvalidEmailAndInvalidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("6566%%%", "hj3gjgg");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test//  working
    public void VerifyUserCanLoginWithEmptyMobileNoOrEmailFieldAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("", "Test_123");

        Utils.WaitForAnElementToExist(driver, loginPage.ValidMobileEmailErrMessage);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.ValidMobileEmailErrMessage), "Phone Number or Email is required");
    }

    @Test//  working
    public void VerifyUserCanLoginWithValidMobileNoAndEmptyPasswordField()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("9000000009", "");

        Utils.WaitForAnElementToExist(driver, loginPage.ValidPasswordMessage);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.ValidPasswordMessage), "Password is required");
    }

    @Test//  working
    public void VerifyUserCanLoginWithValidEmailAndEmptyPasswordField()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("ghanwar@gmail.com", "");

        Utils.WaitForAnElementToExist(driver, loginPage.ValidPasswordMessage);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.ValidPasswordMessage), "Password is required");
    }

    @Test//  working
    public void VerifyUserCanLoginWithEmptyMobileNoOrEmailFieldAndEmptyPasswordField()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("", "");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Phone Number or Email is required");
        Assert.assertEquals(ActualText.get(1), "Password is required");
    }

    @Test//  working
    public void VerifyUserCanLoginWithCaseChangeEmailIdAndValidPassword()
    {
        LandingPage homePage = new LandingPage(driver);
        homePage.LoginTab.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterMobileNumberOrEmailEnterPasswordAndClickLogin("RTRYUURY", "Test_123");

        Utils.WaitForElementsToExist(driver, loginPage.ValidMobileOrEmailMessage);
        List<String> ActualText = Utils.GetTextForAListOfElements(driver, loginPage.ValidMobileOrEmailMessage);
        Assert.assertEquals(ActualText.get(0), "Please enter the valid Credentials");
        Assert.assertEquals(ActualText.get(1), "Please enter the valid Credentials");
    }

    @Test//working
    public void VerifyIfPractitionerAndClinicHasRadioButtonsAndSelectedOneAtaTime()
    {
        LandingPage homePage = new LandingPage(driver);
        SignUpPage signUpPage = homePage.NavigateToSignUpPage();

        signUpPage.PractitionerRadioButton.click();
        Assert.assertTrue(Utils.isElementSelected(driver, signUpPage.PractitionerRadioButton));

        signUpPage.ClinicRadioButton.click();
        Assert.assertFalse(Utils.isElementSelected(driver, signUpPage.PractitionerRadioButton));
    }
}

