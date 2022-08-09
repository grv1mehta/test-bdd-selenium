package framework.utils;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;


public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_Driver(String browser) {
        System.out.println("Browser value is:" + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
        WebDriverManager.safaridriver().setup();
        tlDriver.set(new SafariDriver());
    }
        else {
            System.out.println("Incorrect browser value, please pass the correct one");
        }

        getDriver().manage().window().maximize();
        return getDriver();

    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void openBrowser(String url) {
        getDriver().get(url);

    }

}
