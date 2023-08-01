package TestRunner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Steps.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "OrangeHRMFeatureFiles" }, glue = { "Steps" }, dryRun = false, plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)
public class RunnerTest extends AbstractTestNGCucumberTests {


}
