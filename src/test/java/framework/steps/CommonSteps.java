package framework.steps;


import framework.utils.DriverFactory;
import framework.utils.GenericLibrary;
import io.cucumber.java.en.*;


public class CommonSteps {
    private final GenericLibrary genericLibrary = new GenericLibrary();


    @Given("Iam on the homepage")
    public void iam_on_the_homepage() {

       DriverFactory.openBrowser(genericLibrary.readDataFromPropertyFile("homePageURL"));
    }
}
