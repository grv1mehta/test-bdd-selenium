package framework.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.time.*;
import java.util.*;

public class GenericLibrary {

    private  File file;
    private  Properties prop;

    public String readDataFromPropertyFile(String key) {

        try {
            file = new File("src/test/resources/properties/config.properties");
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
}
