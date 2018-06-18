package stepDefinitions;

import java.io.File;
import java.io.IOException;
import cucumber.TestContext;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.Scenario;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

public class Hooks {
	
	TestContext testContext;
	
	
	public Hooks(TestContext context) {
		
		testContext = context;
			
	}
	
	@Before	
	public void beforeSteps() {
		
		 Reporter.assignAuthor("Selenium Cucumber - Yashika Jayasinghe");
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		
		if(scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll("", "_");
			try {
				
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
				
				File destinationPath = new File(System.getProperty("user.dir")+"/target/cucumber-reports/screenshots/"+screenshotName+".png");
				
				Files.copy(sourcePath, destinationPath);
				
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				
			}catch(IOException e) {
				
			}
		}
	}
	
	@After(order = 0)
	public void afterSteps() {
		 System.out.println("AfterScenario");
		//testContext.getWebDriverManager().closeBrowser();
	}

}
