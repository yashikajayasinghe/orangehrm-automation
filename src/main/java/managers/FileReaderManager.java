package managers;
import dataProviders.ConfigFileReader;
import dataProviders.JsonDataReader;

public class FileReaderManager {
	
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static FileReaderManager fileReaderManager  = new FileReaderManager();
	
	private FileReaderManager() {
		
	}
	 public static FileReaderManager getInstance()
	 {
		 return fileReaderManager;
	 }
	
	 public ConfigFileReader getConfigFileReader()
	 {
		 
		 return (configFileReader == null) ? new ConfigFileReader():configFileReader;
		 
	 }
	 
	 public JsonDataReader getJsonDataReader() {
		 
		 return (jsonDataReader == null)?new JsonDataReader():jsonDataReader;
	 }

}
