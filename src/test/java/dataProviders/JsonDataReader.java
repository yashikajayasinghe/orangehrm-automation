package dataProviders;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.List;
import java.util.Arrays;

import com.google.gson.Gson;

import managers.FileReaderManager;
import testDataTypes.*;

public class JsonDataReader {
	
	private final String loginInfoFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"login.json";
	private final String empInfoFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"newEmp.json";
	private final String searchEmpFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"searchEmp.json";
	private List<loginData> userList;
	private List<empData> employeeList;
	private List<searchEmpData> searchDataList;
	
	
	public JsonDataReader()
	{
		userList = getUserData();
		employeeList = getEmpData();
		searchDataList = getSearchEmpData();
	}
	
	private List<loginData> getUserData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(loginInfoFilePath));
			loginData[] users = gson.fromJson(bufferReader, loginData[].class);
			return Arrays.asList(users);
		}
		catch(FileNotFoundException e) {
		throw new RuntimeException("Json file was not found in the path " +loginInfoFilePath );
		}finally {
			try {
				if(bufferReader != null)bufferReader.close();}
			catch(IOException ignore) {}
		}
	}
	
	private List<empData> getEmpData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(empInfoFilePath));
			empData[] employees = gson.fromJson(bufferReader, empData[].class);
			return Arrays.asList(employees);
		}
		catch(FileNotFoundException e) {
		throw new RuntimeException("Json file was not found in the path " +empInfoFilePath );
		}finally {
			try {
				if(bufferReader != null)bufferReader.close();}
			catch(IOException ignore) {}
		}
	}
	
	private List<searchEmpData> getSearchEmpData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(searchEmpFilePath));
			searchEmpData[] search = gson.fromJson(bufferReader, searchEmpData[].class);
			return Arrays.asList(search);
		}
		catch(FileNotFoundException e) {
		throw new RuntimeException("Json file was not found in the path " +searchEmpFilePath );
		}finally {
			try {
				if(bufferReader != null)bufferReader.close();}
			catch(IOException ignore) {}
		}
	}
	
	public final loginData getUserByName(String userName ) {
		return userList.stream().filter(x -> x.username.equalsIgnoreCase(userName)).findAny().get();		
		
	}
	
	public final empData getEmployeeByName(String empName)
	{
		return employeeList.stream().filter(x -> x.name.fname.equalsIgnoreCase(empName)).findAny().get();
	}
	
	public final searchEmpData getSearchById(Integer id)
	{
	
		
		return searchDataList.stream().filter(x -> x.empSearch.equals(id)).findAny().get();
		
	}
	
	
	
	
}
