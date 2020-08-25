package Tests;

import Pages.*;
import Utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTests extends BaseTest
{
    @Test
    public void VerifyLandingPageAppearsAfterEnteringURL()
    {
        LandingPage landingPage = new LandingPage(driver);
        String ExpectedLandingPageText = "Become The Naturally you";
        String ActualLandingPageText = Utils.GetTextFromAnElement(driver, landingPage.BecomeTheNaturallyYouText);
        Assert.assertEquals(ActualLandingPageText, ExpectedLandingPageText);
    }

    @Test
    public void VerifyQNatureLogoIsPresentInLandingPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, landingPage.QNatureLogo));
    }

    @Test
    public void VerifyHeaderSectionHasAllTheSixTabsAInLandingPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.HeaderTabs.get(0)), "Q and A");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.HeaderTabs.get(1)), "Products");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.HeaderTabs.get(2)), "Services");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.HeaderTabs.get(3)), "Training");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.HeaderTabs.get(4)), "Stores");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.HeaderTabs.get(5)), "Pricing");
    }

    @Test
    public void VerifyFindAskAndBookIconsArePresentInHeaderSectionOfLandingPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(Utils.IsElementDisplayed(driver, landingPage.HeaderIcons.get(0)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, landingPage.HeaderIcons.get(1)));
        Assert.assertTrue(Utils.IsElementDisplayed(driver, landingPage.HeaderIcons.get(2)));
    }

    //@Test // working need to assert
    public void VerifyIfUserCanClickOnFindAndSearchForServicesHeNeeds()
    {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.ClickOnFindIconAndEnterDataForSearch("General Physician");
    }

    @Test // working need to assert
    public void VerifyIfUserCanClickOnAskIconAndNavigateToTheListOfPractitionersPage()
    {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.ClickOnAskIconAndNavigateToPractitionerPage();
    }

    //@Test // working need to assert
    public void VerifyIfUserCanClickOnBookIconAndNavigateToTheListOfPractitionersPage()
    {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.ClickOnBookIconAndNavigateToPractitionerPage();
    }

    @Test
    public void VerifyLoginSignUpAndListYourBusinessButtonArePresentInLandingPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.LoginTab), "Login");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.SignUpTab), "Signup");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.ListYourBusinessTab), "List Your Business");
    }

    @Test
    public void VerifyIfAllTheTabsInTheHeaderSectionAreClickable()
    {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeaderTabs.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeaderTabs.get(1)));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeaderTabs.get(2)));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeaderTabs.get(3)));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeaderTabs.get(4)));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeaderTabs.get(5)));
    }

    @Test
    public void VerifyIfUserClicksOnPricingTabItNavigatesToSubscriptionPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.HeaderTabs.get(5).click();

        SubscriptionPage subscriptionPage = new SubscriptionPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.EssentialSubscription), "ESSENTIAL");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.DynamicSubscription), "DYNAMIC");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, subscriptionPage.EnterpriseSubscription), "ENTERPRISE");
    }

    @Test
    public void VerifyIfLoginSignUpAndListYourBusinessAreClickable()
    {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(Utils.isClickable(driver, landingPage.SignUpTab));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.LoginTab));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.ListYourBusinessTab));
    }

    @Test
    public void VerifyWhenClickedOnSignUpTabItNavigatesToSignUpPage()
    {
        LandingPage landingPage = new LandingPage(driver);
        SignUpPage signUpPage = landingPage.NavigateToSignUpPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.SignUpText),"SIGN UP");
    }

    @Test
    public void VerifyWhenClickedOnLoginTabItNavigatesToLoginPage()
    {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.NavigateToLogInPage();

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, loginPage.LoginText), "LOGIN");
    }

    //@Test
    public void VerifyWhenClickedOnListYourBusinessButtonItNavigatesToSignUpPage() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        SignUpPage signUpPage = landingPage.ClickListYourBusinessAndNavigateToLogInPage();

        Thread.sleep(3000);

        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.SignUpText), "SIGN UP");
    }

    @Test
    public void VerifyThatModalitiesAreScrollingRightAndLeftHorizontally() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.RightScroll.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.Nutrition), "Nutrition");

        landingPage.LeftScroll.click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.Homeopathy), "Homeopathy");
    }

    @Test
    public void VerifyUserCanSearchModalitiesNameUsingSearchInput() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.SearchForTheModalities("Allergy");

        Thread.sleep(5000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AllergyTreatments), "Allergy Treatments");
   }

    @Test
    public void VerifyWhenClickedOnOfferNameDisplaysDetailedDescriptionOfThatParticularOfferAlongWithAvailNowButton() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        Thread.sleep(3000);
        landingPage.OfferNameButton.get(0).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.OfferDescription),
                "Offer details and description will be displayed along with button to avail the offer and automatically user will be directed to the signup page and by signing up they can avail the offers");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AvailNowButton), "Avail Now");

        landingPage.OfferNameButton.get(1).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.OfferDescription),
                "Offer details and description will be displayed along with button to avail the offer and automatically user will be directed to the signup page and by signing up they can avail the offers");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AvailNowButton), "Avail Now");

        landingPage.OfferNameButton.get(2).click();

        Thread.sleep(3000);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.OfferDescription),
                "Offer details and description will be displayed along with button to avail the offer and automatically user will be directed to the signup page and by signing up they can avail the offers");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, landingPage.AvailNowButton), "Avail Now");
    }

    //@Test
    public void VerifyWhenClickedOnAvailNowButtonInSpecificOfferItNavigatesToSignUpPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.OfferNameButton.get(0).click();
        landingPage.AvailNowButton.click();

        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.SignUpText),"SIGN UP");
    }

    @Test
    public void VerifyThaHeartSymbolAndMessageSymbolInQuestionAndAnswersTabAreClickable()
    {
        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeartAndMessageSymbol.get(0)));
        Assert.assertTrue(Utils.isClickable(driver, landingPage.HeartAndMessageSymbol.get(1)));
    }

    //@Test
    public void VerifyThatClickingOnAskButtonFromQuestionAnswersTabNavigatesToSignUpPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.AskButton.click();

        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.SignUpText),"SIGN UP");
    }

    //@Test
    public void VerifyThatClickingOnListYourBusinessInYQNATURESectionItNavigatesToSignUpPage()
    {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.ListYourBusinessButton.click();

        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, signUpPage.SignUpText),"SIGN UP");
    }
}