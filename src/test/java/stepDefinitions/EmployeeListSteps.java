package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.EmployeeListPage;
import testDataTypes.searchEmpData;
import cucumber.TestContext;


public class EmployeeListSteps {
	
	EmployeeListPage EmpListPg;
	TestContext testContext;
	
	public EmployeeListSteps(TestContext context) {
		// TODO Auto-generated constructor stub
		testContext = context;
		EmpListPg = testContext.getPageObjectManager().getEmployeeListPage();
	}
	
	
	@Given("^the \"([^\"]*)\" is in Employee List page$")
	public void the_is_in_Employee_List_page(String userType) throws Throwable {
	    
	    EmpListPg.navigateToEmpList();
	}

	@When("^he enters \"([^\"]*)\"$")
	public void he_searchFor(String searchId) throws Throwable {
	    
	    searchEmpData search = FileReaderManager.getInstance().getJsonDataReader().getSearchById(Integer.parseInt(searchId));
	    EmpListPg.enterSearchCriteria(search);
	}

	
	@When("^hit Search button$")
	public void hit_Search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmpListPg.hit_searchBtn();
	}

	@Then("^relevant employees are listed in the results$")
	public void relevant_employees_are_listed_in_the_results() throws Throwable {
	    System.out.println("Verification to be dev");
	}
	
	@When("^he selects an \"([^\"]*)\"$")
	public void he_selects_an(String id) throws Throwable {
		EmpListPg.resetSearchTable();
		EmpListPg.selectEmployeeFromTheTable(id);
		System.out.println("INTO SELECT");
	}

	@When("^hit delete button$")
	public void hit_delete_button() throws Throwable {
		EmpListPg.clickDelete();
	}

	@Then("^the choosen employee is deleted from the system$")
	public void the_choosen_employee_is_deleted_from_the_system() throws Throwable {
		System.out.println("Verification to be dev2");
	}
}
