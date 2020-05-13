package Tests;

import Pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
       //System.setProperty("webdriver.gecko.driver", "C:/Selenium/geckodriver.exe");
       //driver = new FirefoxDriver();
       driver.navigate().to("http://13.232.236.88/Practitioner_website");
       driver.manage().window().maximize();
    }

    @AfterMethod
    public void CloseWebSite()
    {
        driver.quit();
    }
}

