package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumber",
        glue = "Indigo.StepDefinition",
        monochrome = true,
        tags = "@IndSanity",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}