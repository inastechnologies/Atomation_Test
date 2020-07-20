package Tests;

import Pages.AdminPanelPage;
import Utils.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AdminPanelTests

{
    public WebDriver driver;

    @BeforeTest
    public void VerifyThatUserIsAbleToLandOntoLoginPageOfTheApplication()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://13.232.236.88/qnatureadmin/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void CloseAdMinPanelURL()
    {
        driver.quit();
    }

    @Test
    public void VerifyThatUserCanLoginWithValidUserNamePassword()
    {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@270116");
        Assert.assertEquals(Utils.GetTextFromAnElement(driver, adminPanelPage.AccessManagementAndPrivilegesText), "Access Management & Privileges");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithInvalidUsernameAndValidPassword() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("98661761", "Thannidi@270116");

        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage= alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("9866176100", "Thannidi@");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage= alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithInvalidUsernameAndInvalidPassword() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("98661761", "Thannidi@");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage= alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithEmptyFieldsOfUsernameAndPasswordFields() throws InterruptedException {
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
        adminPanelPage.EnterUserNamePassword("", "");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String alertMessage= alert.getText();

        Assert.assertEquals(alertMessage, "Please Check UserName and Password");
    }
}
