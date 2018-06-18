package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;


public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";
	
	
	public ConfigFileReader()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
			throw new RuntimeException("configuration Properties not found at "+propertyFilePath);
			
		}
	}
	
	public String getDriverPath()
	{
		String driverPath = properties.getProperty("driverPath");
		if(driverPath != null) return driverPath;
		else throw new RuntimeException("driverPath Not specified in the Configuration.properties file");
	}
	
	public Long getImplicitWait()
	{
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait !=null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait is not specified in the Configuration.properties file");
	}
	
	public String getApplicationURL()
	{
		String baseURL = properties.getProperty("url");
		if(baseURL != null) return baseURL;
		else throw new RuntimeException("url not specified in the Configuration.properties file");
	}
	
	public DriverType getBrowser()
	{
		String browser = properties.getProperty("browser");
		if(browser == null || browser.equals("chrome")) return DriverType.CHROME;
		else if(browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browser.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name key value in the Configuration.properties file is not matching : "+browser);
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equalsIgnoreCase("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type key value in the Configuration.properties file is not matching : "+environmentName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("whindowMaximize");
		if(windowSize !=null) return Boolean.valueOf(windowSize);
		return true;
		
	}
	
	public String getTestDataResourcePath(){
		
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath != null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path is not defined in Configuration.properties file ");
		
	}
	
	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath != null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path is not defined in Configuration.properties file ");
	}
}
