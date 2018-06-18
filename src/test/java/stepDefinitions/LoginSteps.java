package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.FileReaderManager;


import pageObjects.LoginPage;
import testDataTypes.loginData;

public class LoginSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	
	
	public LoginSteps(TestContext Context) {
		
		testContext = Context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("^the Admin user is in login Page$")
	public void the_Admin_user_is_in_login_Page() throws Throwable {
	    
		loginPage.navigate_to_loginPage();
	}
	
	@Given("^he enters \"([^\"]*)\" credentials$")
	public void he_enters_credentials(String arg1) throws Throwable {
		loginData users = FileReaderManager.getInstance().getJsonDataReader().getUserByName(arg1);
		loginPage.enter_credentials(users);
	}


	@Given("^click the login button$")
	public void click_the_login_button() throws Throwable {
		 loginPage.click_login();
	}
	
	@Then("^the \"([^\"]*)\" is logged into the system$")
	public void the_is_logged_into_the_system(String arg1) throws Throwable {
	   System.out.println(arg1);
	}

	
	


}
