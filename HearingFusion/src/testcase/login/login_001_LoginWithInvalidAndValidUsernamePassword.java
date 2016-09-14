package login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;
import page.PageFactory;
import page.SchedulePage;
import common.AbstractTest;
import common.Constant;

public class login_001_LoginWithInvalidAndValidUsernamePassword extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaAdminUsername = Constant.QA_ADMIN_USERNAME;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		invalidOrganization = "invalidhf";
		invalidUsername = "staff";
		invalidPassword = "admin";
		errorText = "We do not recognize your Organization and/or UserName and/or Password. Remember, passwords are case-sensitive. Please try again.";
	}
	
	@Test(groups = { "regression" },description = "Login with Organization, Username and Password are empty")
	public void Login_01_LoginWithOrganizationUsernamePasswordAreEmpty()
	{
		log.info("Login_01 - Step 01: Login with Organization, Username and Password are empty");
		loginPage.typeOrganization("");
		loginPage.typeUsername("");
		loginPage.typePassword("");
		loginPage.clickLoginButton();
		
		log.info("VP: An error message displays with content: '"+errorText+"'");
		verifyTrue(loginPage.isInvalidUsernamePasswordMessageDisplayWithText(errorText));
	}
	
	@Test(groups = { "regression" },description = "Login with blank Organization")
	public void Login_02_LoginWithBlankOrganization()
	{
		log.info("Login_02 - Step 01: Login with blank Organization");
		loginPage.typeOrganization("");
		loginPage.typeUsername(qaAdminUsername);
		loginPage.typePassword(password);
		loginPage.clickLoginButton();
		
		log.info("VP: An error message displays with content: '"+errorText+"'");
		verifyTrue(loginPage.isInvalidUsernamePasswordMessageDisplayWithText(errorText));
	}
	
	@Test(groups = { "regression" },description = "Login with blank username")
	public void Login_03_LoginWithBlankUsername()
	{
		log.info("Login_03 - Step 01: Login with blank username");
		loginPage.typeOrganization(organization);
		loginPage.typeUsername("");
		loginPage.typePassword(password);
		loginPage.clickLoginButton();
		
		log.info("VP: An error message displays with content: '"+errorText+"'");
		verifyTrue(loginPage.isInvalidUsernamePasswordMessageDisplayWithText(errorText));
	}
	
	@Test(groups = { "regression" },description = "Login with blank password")
	public void Login_04_LoginWithBlankPassword()
	{
		log.info("Login_04 - Step 01: Login with blank password");
		loginPage.typeOrganization(organization);
		loginPage.typeUsername(qaStaffUsername);
		loginPage.typePassword("");
		loginPage.clickLoginButton();
		
		log.info("VP: An error message displays with content: '"+errorText+"'");
		verifyTrue(loginPage.isInvalidUsernamePasswordMessageDisplayWithText(errorText));
	}
	
	@Test(groups = { "regression" },description = "Login with Incorrect Organization, Username and Password")
	public void Login_05_LoginWithIncorrectOrganizationUsernameAndPassword()
	{
		log.info("Login_05 - Step 01: Login with Incorrect Organization, Username and Password");
		loginPage.typeOrganization(invalidOrganization);
		loginPage.typeUsername(invalidUsername);
		loginPage.typePassword(invalidPassword);
		loginPage.clickLoginButton();
		
		log.info("VP: An error message displays with content: '"+errorText+"'");
		verifyTrue(loginPage.isInvalidUsernamePasswordMessageDisplayWithText(errorText));
	}
	
	@Test(groups = { "regression" },description = "Login with Correct Organization, Username and Password")
	public void Login_06_LoginWithCorrectOrganizationUsernameAndPassword()
	{
		log.info("Login_06 - Step 01: Login with Correct Organization, Admin Username and Password");
		schedulePage = loginPage.login(organization, qaAdminUsername, password, false);
		
		log.info("VP: Schedule page display after loging in with valid username and password");
		verifyTrue(schedulePage.isPageOnTopNavigateBarOpened("Schedule"));
		
		log.info("VP: The website will show 'Admin username' in the top");
		verifyTrue(schedulePage.isUsernameDisplayAfterLogin("QA Admin"));
		
		log.info("Login_06 - Step 02: Logout the site");
		loginPage = logout(driver, ipClient);
		
		log.info("Login_06 - Step 03: Login with Correct Organization, Staff Username and Password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("VP: Schedule page display after loging in with valid username and password");
		verifyTrue(schedulePage.isPageOnTopNavigateBarOpened("Schedule"));
		
		log.info("VP: The website will show 'Staff username' in the top");
		verifyTrue(schedulePage.isUsernameDisplayAfterLogin("QA Staff"));
	}
	
	@Test(groups = { "regression" },description = "Untick 'Remember my Organization and UserName on this computer'")
	public void Login_07_LoginWithUntickRememberAccountCheckbox()
	{
		log.info("Login_07 - Step 01: Logout the site");
		loginPage = logout(driver, ipClient);
		
		log.info("Login_07 - Step 02: Login with untick remember account checkbox");
		schedulePage = loginPage.login(organization, qaAdminUsername, password, false);
		
		log.info("VP: Schedule page display after loging in with valid username and password");
		verifyTrue(schedulePage.isPageOnTopNavigateBarOpened("Schedule"));
		
		log.info("VP: The website will show 'Admin username' in the top");
		verifyTrue(schedulePage.isUsernameDisplayAfterLogin("QA Admin"));
		
		log.info("Login_07 - Step 03: Logout the site");
		loginPage = logout(driver, ipClient);
		
		log.info("VP: Organization is not saved");
		verifyFalse(loginPage.isOrganizationFieldSaved(organization));
		
		log.info("VP: Username is not saved");
		verifyFalse(loginPage.isUsernameFieldSaved(qaAdminUsername));
	}
	
	@Test(groups = { "regression" },description = "Tick 'Remember my Organization and UserName on this computer'")
	public void Login_08_LoginWithTickRememberAccountCheckbox()
	{
		log.info("Login_08 - Step 01: Login with tick remember account checkbox");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, true);
		
		log.info("VP: Schedule page display after loging in with valid username and password");
		verifyTrue(schedulePage.isPageOnTopNavigateBarOpened("Schedule"));
		
		log.info("VP: The website will show 'Staff username' in the top");
		verifyTrue(schedulePage.isUsernameDisplayAfterLogin("QA Staff"));
		
		log.info("Login_08 - Step 02: Logout the site");
		loginPage = logout(driver, ipClient);
		
		log.info("VP: Organization is saved");
		verifyTrue(loginPage.isOrganizationFieldSaved(organization));
		
		log.info("VP: Username is saved");
		verifyTrue(loginPage.isUsernameFieldSaved(qaStaffUsername));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser(driver);
	}
	
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private String organization, qaStaffUsername, qaAdminUsername, password;
	private String invalidOrganization, invalidUsername, invalidPassword;
	private String errorText;
}
