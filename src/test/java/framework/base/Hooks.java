package framework.base;

import framework.utils.DriverFactory;
import framework.utils.GenericLibrary;
import io.cucumber.java.*;
import org.openqa.selenium.*;


public class Hooks {

    private DriverFactory driverFactory = new DriverFactory();
    private WebDriver driver;
    private GenericLibrary genericLibrary = new GenericLibrary();


    @Before
    public void launchBrowser()
    {
        String browserName = genericLibrary.readDataFromPropertyFile("browser");
        driver = driverFactory.init_Driver(browserName);
    }

    @After(order=0)
    public void quitBrowser()
    {
        driver.close();
        driver.quit();

    }

    @After(order=1)
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            String screenshotName = scenario.getName().replaceAll(" ","_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath,"image/png",screenshotName);
        }
    }
}
