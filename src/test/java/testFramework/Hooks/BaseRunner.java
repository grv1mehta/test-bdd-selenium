package testFramework.Hooks;


import io.cucumber.testng.*;



@CucumberOptions
(
        plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features="src/test/resources/testFramework/Features",
        glue={"testFramework.steps","testFramework.Hooks"}



//tags="@CartFeature"

        )
public class BaseRunner extends AbstractTestNGCucumberTests {



}
