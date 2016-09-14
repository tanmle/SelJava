package schedule;

import java.util.Set;
import java.util.Stack;

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

public class schedule_010_TaskExceptions extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
	}
	
	@Test(groups = { "regression" },description = "show list of Appointments with Exceptions")
	public void Schedule_62_ListOfAppointmentsWithExceptionsIsShowed()
	{
		log.info("Schedule_62 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_62 - Step 02: Click on Exceptions link in Task");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.clickOnExceptionsLink();
		
		log.info("VP: List of Appointments with Exceptions is showed");
		verifyTrue(schedulePage.isListOfExceptionAppointmentDisplay());
	}
	
	@Test(groups = { "regression" },description = "Help Page")
	public void Schedule_64_HelpPage()
	{
		log.info("Schedule_64 - Step 01: Click on Help link");
		schedulePage.clickOnHelpLink();
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Help page is opened");
		verifyTrue(schedulePage.isHelpPageOpened());
		driver.close();
		driver.switchTo().window(currentHandle);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private String organization, qaStaffUsername, password;
	private final Stack<String> openWindowHandles = new Stack<String>();
}