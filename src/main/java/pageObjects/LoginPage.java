package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.loginData;

import dataProviders.ConfigFileReader;
import selenium.Wait;

public class LoginPage {
	
	WebDriver browser;
	ConfigFileReader configFileReader;

	public LoginPage(WebDriver browser) {
	
		this.browser = browser;
		configFileReader = new ConfigFileReader();
		PageFactory.initElements(browser, this);
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"txtUsername\"]") 
	private WebElement txt_username;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txtPassword\"]")
	private WebElement txt_password;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btnLogin\"]")
	private WebElement btn_login;
	
	
	public void navigate_to_loginPage() {
		browser.get("http://localhost/orangehrm41/orangehrm-4.1/symfony/web/index.php/auth/login");
	}
	
	public void enter_credentials(loginData user) {
		txt_username.sendKeys(user.username);
		txt_password.sendKeys(user.password);
	}
	
	public void click_login() {
		btn_login.click();
		Wait.untilJqueryIsDone(browser);
	}
	
	public void verify_loginInfo() {
		//check if login username is correctly displayed
	}

}
