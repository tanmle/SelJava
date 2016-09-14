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
import common.Common;
import common.Constant;

public class schedule_008_TaskRecalls extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		editDateString = Common.getCommon().getCurrentMonthWithPlusDays(-1)+"/"+Common.getCommon().getCurrentDayWithPlusDays(-1)+"/"+Common.getCommon().getCurrentYearWithPlusDays(-1);
		editNote = "Note Content"+getUniqueNumber();
	}
	
	@Test(groups = { "regression" },description = "list of Patients for Recall is showed")
	public void Schedule_50_ListOfPatientsForRecallIsShowed()
	{
		log.info("Schedule_50 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_50 - Step 02: Click on Recalls link in Task");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.clickOnRecallsLink();
		
		log.info("VP: List of Patients for Recall is showed");
		verifyTrue(schedulePage.isListOfPatientsForRecallDisplay());
	}
	
	@Test(groups = { "regression" },description = "Help Page")
	public void Schedule_52_HelpPage()
	{
		log.info("Schedule_52 - Step 01: Click on Help link");
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
	
	@Test(groups = { "regression" },description = "View Recall Details")
	public void Schedule_56_ViewRecallDetails()
	{
		log.info("Schedule_56 - Step 01: View Recall detail");
		schedulePage.viewRecallDetail("Mills, Abbie");
		
		log.info("VP: View Detail Page display");
		verifyTrue(schedulePage.isRecallDetailsPageDisplay());
	}
	
	@Test(groups = { "regression" },description = "Recalls_Edit  Recall Details")
	public void Schedule_57_EditRecallDetails()
	{
		log.info("Schedule_57 - Step 01: View Recall detail");
		schedulePage.editRecallDetail(editDateString, editNote);
		
		log.info("VP: Edit successfully display");
		verifyTrue(schedulePage.isMessageEditSuccessfullyDisplay());
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
	private String editNote, editDateString;
	private final Stack<String> openWindowHandles = new Stack<String>();
}