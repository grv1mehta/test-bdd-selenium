package testFramework.Utils.Libraries;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.time.*;
import java.util.*;

public class GenericLibrary {

    private  File file;
    private  Properties prop;

    WebDriver driver;

    public String readDataFromPropertyFile(String key) {

        try {
            file = new File("src/test/resources/testFramework/Properties/config.properties");
            FileInputStream fileInput;
            prop = new Properties();
            fileInput = new FileInputStream(file);
            prop.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }


    public void explicitWaitforanElement(WebDriver driver, WebElement ele)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(ele));


//            Wait wait1 = new FluentWait(driver)
//                    .withTimeout(Duration.ofSeconds(10))
//                    .pollingEvery(Duration.ofSeconds(10))
//                    .ignoring(Exception.class);
//
//            WebElement foo = (WebElement) wait1.until(ExpectedConditions.alertIsPresent());

        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal Argument Exception:: Input must be set");
        }
    }

    public void highLightElement(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='5px solid red'", element);
    }

    public void highLightElements(WebDriver driver,List<WebElement> elements){
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].style.border='5px solid red'", elements);
//        js.executeScript("arguments[0].setAttribute('style','background: ; border: 5px solid red;');", elements);


//        js.executeScript("arguments[0].setAttribute('style',arguments[1])", elements, "color: Red; border: 5px solid red;");
    }
}
