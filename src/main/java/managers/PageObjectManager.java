package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;


public class PageObjectManager {
	
	private WebDriver browser;
	private LoginPage loginPage;
	private AddEmployeePage empPage;
	private EmployeeListPage empListPage;
	
	
	
	public PageObjectManager(WebDriver browser) {
		
		this.browser = browser;
		
	}

	public LoginPage getLoginPage()
	{
		return (loginPage == null)? loginPage = new LoginPage(browser):loginPage;
	}
	
	public AddEmployeePage getAddEmployeePage() {
		return (empPage == null)? empPage = new AddEmployeePage(browser): empPage;
	}
	
	public EmployeeListPage getEmployeeListPage() {
		return (empListPage == null)? empListPage = new EmployeeListPage(browser): empListPage;
	}
	

	
}
