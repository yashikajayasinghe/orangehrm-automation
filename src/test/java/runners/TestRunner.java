package runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

//Cucumber.Options(features={"automatedTestingServices.feature", "smoketest.feature"})
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		glue = {"stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)



public class TestRunner {
	
	@AfterClass
	public static void writeExpentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath()));
	}

}

