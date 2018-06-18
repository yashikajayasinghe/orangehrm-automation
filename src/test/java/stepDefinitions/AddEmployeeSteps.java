package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.AddEmployeePage;
//import pageObjects.LoginPage;
import testDataTypes.empData;
//import testDataTypes.loginData;

public class AddEmployeeSteps {
	
	TestContext testContext;
	AddEmployeePage empPage;
	

	public AddEmployeeSteps(TestContext context) {
		
		testContext = context;
		empPage = context.getPageObjectManager().getAddEmployeePage();
		
	}
	
	
	
	
	
	@Given("^the \"([^\"]*)\" is in Add Employee Page$")
	public void the_is_in_Add_Employee_Page(String arg1) throws Throwable {
		
	    empPage.click_navToAddEmpPage();
	}


	@When("^he enters \"([^\"]*)\" information$")
	public void he_enters_information(String arg1) throws Throwable {
		empData employee = FileReaderManager.getInstance().getJsonDataReader().getEmployeeByName(arg1);
	    empPage.enter_empDetails(employee);
	}

	@When("^submits form$")
	public void submits_form() throws Throwable {
		
		empPage.submit_addEmpForm();
	}

	@Then("^that Employee is shown in the list$")
	public void that_Employee_is_shown_in_the_list() throws Throwable {
	    System.out.println("Yes");
	}
	

}
