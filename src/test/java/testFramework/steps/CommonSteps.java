package testFramework.steps;


import io.cucumber.java.en.*;
import testFramework.Utils.*;
import testFramework.Utils.Libraries.*;


public class CommonSteps {
    private final GenericLibrary genericLibrary = new GenericLibrary();


    @Given("Iam on the homepage")
    public void iam_on_the_homepage() {

       DriverFactory.openBrowser(genericLibrary.readDataFromPropertyFile("homePageURL"));
    }
}
