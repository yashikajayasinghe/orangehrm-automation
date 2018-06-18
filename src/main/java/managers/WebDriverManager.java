package managers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	
	private static WebDriver browser;
	private static DriverType browserName;
	private static EnvironmentType environmentName;
	private static final String CHROME_DRIVER_PROPERTY ="webdriver.chrome.driver";
	

	public WebDriverManager() {
		environmentName = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
		browserName = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
	}
	
	public WebDriver getDriver(){
		if(browser == null) browser = createDriver();
		return browser;
	}
	
	private WebDriver createDriver() {
		
		switch(environmentName) { 
		case LOCAL: 
			browser = createLocalDriver();
			break;
		case REMOTE:
			browser = createRemoteDriver();
			break;	
		
			}
		return browser;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("Creating Remote driver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		
		switch(browserName) {
		case FIREFOX : 
			browser = new FirefoxDriver(); 
			break;
		case CHROME : 
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
			browser = new ChromeDriver(); 
			break;
		case INTERNETEXPLORER:
			browser = new InternetExplorerDriver();
			break;
			
		
		}
		
		if(FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitWait(), TimeUnit.SECONDS);
		return browser;
	}
	
	public void closeBrowser() {
		browser.close();
		browser.quit();
	}
}
