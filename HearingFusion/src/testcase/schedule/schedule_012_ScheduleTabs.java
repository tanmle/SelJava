package schedule;

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

public class schedule_012_ScheduleTabs extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
	}
	
	@Test(groups = { "regression" },description = "Schedule Day")
	public void Schedule_94_ScheduleDay()
	{
		log.info("Schedule_94 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_94 - Step 02: Click on Day tab");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.clickOnDayTab();
		
		log.info("VP: Day tab is openned");
		verifyTrue(schedulePage.isTabsOpened("Day"));
	}
	
	@Test(groups = { "regression" },description = "Schedule Week")
	public void Schedule_95_ScheduleWeek()
	{
		log.info("Schedule_95 - Step 01: Click on Week tab");
		schedulePage.clickOnWeekTab();
		
		log.info("VP: Week tab is openned");
		verifyTrue(schedulePage.isTabsOpened("Week"));
		schedulePage.switchToTopWindowFrame(driver);
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
}