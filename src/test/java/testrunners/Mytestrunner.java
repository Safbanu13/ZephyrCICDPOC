package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty","json:target/JsonReports/report.json",
		"junit:target/Reports/cucumber.xml"},
		monochrome = true

		)

//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"

public class Mytestrunner {




}
