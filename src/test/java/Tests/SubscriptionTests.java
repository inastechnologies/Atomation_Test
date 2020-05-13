package Tests;


import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionTests extends  BaseTest
{
    @Test
    public void VerifyIfUserIsLandingOntoTheSubscriptionPageAfterSigningUpAsAPractitioner()
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
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.EssentialSubscription), "ESSENTIAL");
    }

    @Test
    public void VerifyIfThePageHasEssentialDynamicAndEnterpriseSubscriptionModels()
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
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();

        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);

        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.EssentialSubscription), "ESSENTIAL");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.DynamicSubscription), "DYNAMIC");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.EnterpriseSubscription), "ENTERPRISE");
    }

    @Test
    public void VerifyEachSubscriptionModelHasTryAndBuyButtonsAndTheyAreClickable()
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
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.TryButton), "Try");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.BuyButton), "Buy");
        Assert.assertTrue(Utils.isClickable(driver, subscriptionPage.TryButton));
        Assert.assertTrue(Utils.isClickable(driver, subscriptionPage.BuyButton));
    }

    @Test
    public void VerifyUserClicksOnTryButtonOfEssentialSubscriptionAndNavigatesToBusinessInfoPage()
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
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        BusinessInfoPage businessInfoPage = subscriptionPage.ClickOnTryButtonAndNavigateToBusinessInfoPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, businessInfoPage.BusinessInfoText), "Business Information");
    }

    @Test
    public void VerifyIfTheUserCanClickOnBuyAndNavigateToAddonsAndPaymentPage()
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
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        EssentialSubscriptionPage essentialSubscriptionPage = subscriptionPage.ClickOnBuyButtonAndNavigateToEssentialSubscriptionPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, essentialSubscriptionPage.PaymentHeading), "Choose your payment method");
    }

    @Test
    public void verifyIfUserCanSeeTheAvailableAddonsAlongWithTheCheckBoxToSelect()
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
        String Password = AlphaNumeric + "@Sai4";
        String ConfirmPassword = AlphaNumeric + "@Sai4";
        LandingPage landingPage = new LandingPage(driver);

        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();
        signUpPage.EnterDataIntoAllTheFieldsInSignUpPage(FirstName, LastName, Email, PhoneNo, Location, Password, ConfirmPassword);
        SubscriptionPage subscriptionPage = signUpPage.ClickPractitionerCategoryClickTermsAndConditionsAndSignUp();

        EssentialSubscriptionPage essentialSubscriptionPage = subscriptionPage.ClickOnBuyButtonAndNavigateToEssentialSubscriptionPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, essentialSubscriptionPage.AvailableAddOnsText), "Availabel Add Ons");

        essentialSubscriptionPage.CheckBox.get(0).click();
        Assert.assertTrue(Utils.isElementSelected(driver, essentialSubscriptionPage.CheckBox.get(0)));

        essentialSubscriptionPage.CheckBox.get(0).click();
        Assert.assertFalse(Utils.isElementSelected(driver, essentialSubscriptionPage.CheckBox.get(0)));
    }
}
