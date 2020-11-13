package Tests;

import Pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
    public WebDriver driver;

    @BeforeMethod
    public void LaunchWebSite()
    {
       System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
       driver = new ChromeDriver();

       driver.navigate().to("  http://15.206.71.94/Practitioner_website");
       driver.manage().window().maximize();
    }

    @AfterMethod
    public void CloseWebSite()
    {
        driver.quit();
    }
}

