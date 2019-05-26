package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "resources/features",
		glue = "steps",
		monochrome = true,
		tags = {"@smokeTest"})
public class CucumberTestRunner {

}
