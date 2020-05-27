package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils
{

    public static void WaitForAnElementToExist(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void WaitForAnElementNotToExist(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void WaitForElementsToExist(WebDriver driver, List<WebElement> elements)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static String GetTextFromAnElement(WebDriver driver, WebElement element)
    {
        Utils.WaitForAnElementToExist(driver, element);
        return element.getText();
    }

    /*public static boolean ElementNotDisplayed(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }*/

    public static boolean IsElementDisplayed(WebDriver driver, WebElement element)
    {
       try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    public static boolean ElementsNotDisplayed(WebDriver driver, List<WebElement> element)
    {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            return true;
    }

    public static boolean isElementSelected(WebDriver driver, WebElement element)
    {
        boolean isSelected = false;
        return element.isSelected();
    }

    public static boolean isClickable(WebDriver driver, WebElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void SelectFromDropDownUsingVisibleText(WebElement element, String Text)
    {
        Select select = new Select(element);
        select.selectByValue(Text);
    }

    public static void MouseHoverToAnElement(WebDriver driver, WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static int RandomGenerator()
    {
        //Random randomGenerator = new Random();
        //return randomGenerator.nextInt(1000000000);

        Random r = new Random(System.currentTimeMillis());
        return 100000000 + r.nextInt(200000000);
    }

    public static String getAlphaNumericString(int n)
    {
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // remove all spacial char
        String AlphaNumericString = randomString.replaceAll("[^A-Za-z0-9]", "");

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < AlphaNumericString.length(); k++) {

            if (Character.isLetter(AlphaNumericString.charAt(k))
                    && (n > 0)
                    || Character.isDigit(AlphaNumericString.charAt(k))
                    && (n > 0)) {

                r.append(AlphaNumericString.charAt(k));
                n--;
            }
        }
        // return the resultant string
        return r.toString();
    }

    public static String printRandomString(int n)
    {
        int MAX = 26;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'};
        String res = "";
        for (int i = 0; i < n; i++)
            res = res + alphabet[(int) (Math.random() * 10 % MAX)];

        return res;
    }

    public static List<String> GetTextForAListOfElements(WebDriver driver, List<WebElement> WebElements)
    {
        List<String> elementsText = new ArrayList<>();

        for (WebElement element : WebElements)
        {
            elementsText.add(element.getText());
        }
        return elementsText;
    }
}




