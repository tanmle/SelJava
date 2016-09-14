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

public class schedule_009_TaskRecall_SearchPaitent extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
	}
	
	@Test(groups = { "regression" },description = "Leaving all fields blank")
	public void Schedule_58_LeavingAllFieldsBlank()
	{
		log.info("Schedule_58 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_58 - Step 02: Click on Recalls link in Task");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.clickOnRecallsLink();

		log.info("Schedule_58 - Step 03: Click on Search button");
		numberOfpatientItem = schedulePage.getNumberOfRecallPatientItem();
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Recall Patient");
		verifyEquals(numberOfpatientItem, schedulePage.getNumberOfRecallPatientItem());
	}
	
	@Test(groups = { "regression" },description = "Incorrect all fields")
	public void Schedule_59_IncorrectAllFields()
	{
		log.info("Schedule_59 - Step 01: Input incorrect Patient Last name");
		schedulePage.inputPatientLastNameValue("incorrectPatientLastName");
		
		log.info("Schedule_59 - Step 02: Input incorrect Patient First name");
		schedulePage.inputPatientFirstNameValue("incorrectPatientFirstName");
		
		log.info("Schedule_59 - Step 03: Input incorrect Provider Last Name");
		schedulePage.inputProviderLastNameValue("incorrectProviderLastName");
		
		log.info("Schedule_59 - Step 04: Input incorrect Provider First Name");
		schedulePage.inputProviderFirstNameValue("incorrectProviderFirstName");
		
		log.info("Schedule_59 - Step 05: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Message display with content 'No Patients found'");
		verifyTrue(schedulePage.isSearchPatientRecallMessageDisplayWithContent("No Patients found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Patient Last Name,Patient First Name")
	public void Schedule_60_CorrectPatientName()
	{
		log.info("Schedule_60 - Step 01: Input correct Patient Last name");
		schedulePage.inputPatientLastNameValue("Mills");
		
		log.info("Schedule_60 - Step 02: Input correct Patient First name");
		schedulePage.inputPatientFirstNameValue("Abbie");
		
		log.info("Schedule_60 - Step 03: Input incorrect Provider Last Name");
		schedulePage.inputProviderLastNameValue("");
		
		log.info("Schedule_60 - Step 04: Input incorrect Provider First Name");
		schedulePage.inputProviderFirstNameValue("");
		
		log.info("Schedule_60 - Step 08: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Recall patient of Patient: Wayne, Bruce");
		verifyTrue(schedulePage.isListOfPatientRecallDisplayWithPatientInfor("Mills, Abbie"));
	}
	
	@Test(groups = { "regression" },description = "Correct all field")
	public void Schedule_61_CorrectAllField()
	{
		log.info("Schedule_61 - Step 01: Input correct Patient Last name");
		schedulePage.inputPatientLastNameValue("Mills");
		
		log.info("Schedule_61 - Step 02: Input correct Patient First name");
		schedulePage.inputPatientFirstNameValue("Abbie");
		
		log.info("Schedule_61 - Step 03: Input incorrect Provider Last Name");
		schedulePage.inputProviderLastNameValue("");
		
		log.info("Schedule_61 - Step 04: Input incorrect Provider First Name");
		schedulePage.inputProviderFirstNameValue("");
		
		log.info("Schedule_61 - Step 08: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Rescheduled Appointments with all correct infor");
		verifyTrue(schedulePage.isPatientRecallDisplayWithCorrectInfor("Mills, Abbie", ""));
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
	private int numberOfpatientItem;
}