package framework.base;


import io.cucumber.testng.*;

@CucumberOptions
(
        plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features="src/test/resources/features",
        glue={"framework.steps","framework.base"}


//tags="@CartFeature"

        )
public class TestRunner extends AbstractTestNGCucumberTests {



}
