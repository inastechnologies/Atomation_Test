package Tests;

import Pages.AdminPanelPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AdminPanelTests

{
    public WebDriver driver;

    @BeforeTest
    public void OpenAdMinPanelURL()
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
        adminPanelPage.EnterUserNamePassword();
    }
}
