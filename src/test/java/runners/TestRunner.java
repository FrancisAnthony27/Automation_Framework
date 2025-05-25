package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    //features = "features",
	features = "src/test/resources/FeatureFiles",
    glue = "stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
    
)
public class TestRunner extends AbstractTestNGCucumberTests {}

//public class TestRunner {}
