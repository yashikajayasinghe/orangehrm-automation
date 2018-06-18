package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.empData;
import selenium.Wait;

public class AddEmployeePage {

	WebDriver browser;
	
	
	public AddEmployeePage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);
	}
	
	
	@FindBy(how = How.XPATH, using="//*[@id=\"menu_pim_addEmployee\"]")
	private WebElement btn_ToAddEmployeePage;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"menu_pim_viewPimModule\"]")
	private WebElement btn_PIM;	
	
	@FindBy(how = How.XPATH, using="//*[@id=\"firstName\"]")
	private WebElement txt_firstName;	
	
	@FindBy(how = How.XPATH, using="//*[@id=\"middleName\"]")
	private WebElement txt_middleName;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"lastName\"]")
	private WebElement txt_lastName;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"employeeId\"]")
	private WebElement txt_employeeId; //already filled generated from a value from the db
	
	@FindBy(how = How.XPATH, using="//*[@id=\"photofile\"]")
	private WebElement file_uploadProfilePhoto;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"chkLogin\"]")
	private WebElement chk_createLoginInfo;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"user_name\"]")
	private WebElement txt_userName;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"user_password\"]")
	private WebElement txt_password;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"re_password\"]")
	private WebElement txt_rePassword;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"status\"]")
	private WebElement sel_status;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"btnSave\"]")
	private WebElement btn_save;
	
	
	public void click_navToAddEmpPage() {
		
		btn_PIM.click();
		Wait.untilJqueryIsDone(browser);
		btn_ToAddEmployeePage.click();
		Wait.untilJqueryIsDone(browser);
		
	}
	
	
	
	public void enter_empDetails(empData emp) {
		txt_firstName.sendKeys(emp.name.fname);
		txt_middleName.sendKeys(emp.name.mName);
		txt_lastName.sendKeys(emp.name.lName);
		if(emp.photo.status) {
			file_uploadProfilePhoto.sendKeys(emp.photo.path);
			Wait.untilJqueryIsDone(browser);
		}
		if(emp.loginStatus)
			{
				chk_createLoginInfo.click();
				Wait.untilJqueryIsDone(browser);
				txt_userName.sendKeys(emp.login.userName);
				txt_password.sendKeys(emp.login.password);
				txt_rePassword.sendKeys(emp.login.password);
			}
		
		
		
	}
	
	public void submit_addEmpForm() {
		btn_save.click();
	}
	
}
