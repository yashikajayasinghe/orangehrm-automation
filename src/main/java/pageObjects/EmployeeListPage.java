package pageObjects;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Wait;

import testDataTypes.searchEmpData;

public class EmployeeListPage {
	
	WebDriver browser;
	ArrayList<HashMap<String, WebElement>> empTable; //employee search data in a table object
	
	public EmployeeListPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);
		empTable = new ArrayList<HashMap<String, WebElement>>();
		
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"menu_pim_viewPimModule\"]")
	private WebElement tab_PIM;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"empsearch_employee_name_empName\"]")
	private WebElement txt_empName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"empsearch_id\"]")
	private WebElement txt_empId;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"empsearch_employee_status\"]")
	private WebElement select_empStatus;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"empsearch_termination\"]")
	private WebElement select_empInclude;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"empsearch_supervisor_name\"]")
	private WebElement txt_supName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"empsearch_job_title\"]")
	private WebElement select_empJobTitle;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"empsearch_sub_unit\"]")
	private WebElement select_subUnit;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"searchBtn\"]")
	private WebElement btn_search;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"resetBtn\"]")
	private WebElement btn_reset;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btnAdd\"]")
	private WebElement btn_addEmp;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btnDelete\"]")
	private WebElement btn_deleteEmp;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"resultTable\"]")
	private WebElement tbl_emp;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"search_form\"]/fieldset/p")
	private WebElement link;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"resultTable\"]")
	private WebElement resultTable;
	
	
	
	
	public void navigateToEmpList() {
		tab_PIM.click();
		Wait.untilJqueryIsDone(browser);
	}
	
	
	public void enterSearchCriteria(searchEmpData search) {
		//if(!search.__.isEmpty()) {}
		
		//reset the search form
		btn_reset.click();
		Wait.untilJqueryIsDone(browser);
		
		if(!search.empName.isEmpty()) {txt_empName.sendKeys(search.empName);
		browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		txt_empId.click();
		
		Wait.untilJqueryIsDone(browser);
		}
		
		
		
		if(!search.empId.isEmpty()) {txt_empId.sendKeys(search.empId);}
		
		if(!search.empStatus.isEmpty()) {
			Select empStatusDropDown = new Select(select_empStatus);
			empStatusDropDown.selectByValue("1");//To be updated after first successful search
		}
		
		if(!search.empInclude.isEmpty()) {
			Select empIncludeDropDown  = new Select(select_empInclude);
			empIncludeDropDown.selectByVisibleText(search.empInclude); //To be updated after first successful search
		}
			
		
		
	}
	
	public void hit_searchBtn() {
		
		WebDriverWait wait = new WebDriverWait(browser, 20);
		 
		WebElement btn_search = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
		
		btn_search.click();
		
		Wait.untilJqueryIsDone(browser);
	}

	public void getTableToArrayList() {
		
		Wait.untilPageLoadComplete(browser);
		//resultTable = browser.findElement(By.xpath("//*[@id=\\\"resultTable\\\"]"));
		
		ArrayList<WebElement> rowElements = (ArrayList<WebElement>) resultTable.findElements(By.xpath(".//tr"));

		// get column names of table from table headers
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<WebElement> headerElements = (ArrayList<WebElement>) rowElements.get(0).findElements(By.xpath(".//th"));
		for (WebElement headerElement: headerElements) {
		  columnNames.add(headerElement.getText());
		}

		// iterate through all rows and add their content to table array
		for (WebElement rowElement: rowElements) {
		  HashMap<String, WebElement> row = new HashMap<String, WebElement>();
		  
		  // add table cells to current row
		  int columnIndex = 0;
		  ArrayList<WebElement> cellElements = (ArrayList<WebElement>) rowElement.findElements(By.xpath(".//td"));
		  for (WebElement cellElement: cellElements) {
		    row.put(columnNames.get(columnIndex), cellElement);
		    columnIndex++;
		  }
		  
		  empTable.add(row);
		}

		
		
	}

	public void selectEmployeeFromTheTable(String id) {
		
		getTableToArrayList();
		
		for (int row = 1; row < empTable.size(); row++) {
			
			if(id.equals(empTable.get(row).get("Id").getText())) {					
					
					browser.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_"+ removeZero(id) +"\"]")).click();
				
			}
		}
	}
	public String removeZero(String value) {
		
		     while (value.indexOf("0")==0)
		         value = value.substring(1);
		          return value;
		
	}
	public void clickDelete() {
		btn_deleteEmp.click();
		confirmDelete();
	}
	
	public void confirmDelete() {
		WebDriverWait wait = new WebDriverWait(browser, 10);
		 
		WebElement btn_ok_delete = wait.until(ExpectedConditions.elementToBeClickable(By.id("dialogDeleteBtn")));
		
		btn_ok_delete.click();
		
	}
	
	public void resetSearchTable() {
		WebDriverWait wait = new WebDriverWait(browser, 10);
		 
		WebElement btn_reset = wait.until(ExpectedConditions.elementToBeClickable(By.id("resetBtn")));
		
		btn_reset.click();
		
		Wait.untilJqueryIsDone(browser);
	}
	
	public void editEmployee(String id) {
		
	}

}
