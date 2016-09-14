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

public class schedule_011_TaskException_SearchExceptionAppointment extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		apptType = "Cerumen management";
		provider = "Needle, Space";
	}
	
	@Test(groups = { "regression" },description = "Leaving all fields blank")
	public void Schedule_69_LeavingAllFieldsBlank()
	{
		log.info("Schedule_69 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_69 - Step 02: Click on Recalls link in Task");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.clickOnExceptionsLink();

		log.info("Schedule_69 - Step 03: Click on Search button");
		numberOfExceptionApptItem = schedulePage.getNumberOfExceptionAppointmentItem();
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Recall Patient");
		verifyEquals(numberOfExceptionApptItem, schedulePage.getNumberOfExceptionAppointmentItem());
	}
	
	@Test(groups = { "regression" },description = "Incorrect Patient Last Name,  First Name")
	public void Schedule_70_IncorrectPatientName()
	{
		log.info("Schedule_70 - Step 01: Input incorrect Patient Last name");
		schedulePage.inputPatientLastNameValue("incorrectPatientLastName");
		
		log.info("Schedule_70 - Step 02: Input incorrect Patient First name");
		schedulePage.inputPatientFirstNameValue("incorrectPatientFirstName");
		
		log.info("Schedule_70 - Step 03: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Message display with content 'No Appointments with Exceptions found'");
		verifyTrue(schedulePage.isSearchExceptionApptMessageDisplayWithContent("No Appointments with Exceptions found"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect all fields")
	public void Schedule_71_IncorrectAllFields()
	{
		log.info("Schedule_71 - Step 01: Input incorrect Patient Last name");
		schedulePage.inputPatientLastNameValue("incorrectPatientLastName");
		
		log.info("Schedule_71 - Step 02: Input incorrect Patient First name");
		schedulePage.inputPatientFirstNameValue("incorrectPatientFirstName");
		
		log.info("Schedule_71 - Step 03: Input incorrect Patient Preferred Name");
		schedulePage.inputPatientPreferredNameValue("incorrectPatientPreferredName");
		
		log.info("Schedule_71 - Step 04: Input incorrect Provider Last Name");
		schedulePage.inputProviderLastNameValue("incorrectProviderLastName");
		
		log.info("Schedule_71 - Step 05: Input incorrect Provider First Name");
		schedulePage.inputProviderFirstNameValue("incorrectProviderFirstName");
		
		log.info("Schedule_71 - Step 06: Select Appointment Type");
		schedulePage.selectAppointmentType("Delivery");
		
		log.info("Schedule_71 - Step 07: Input incorrect Note");
		schedulePage.inputNoteValue("incorrectNote");
		
		log.info("Schedule_71 - Step 05: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Message display with content 'No Appointments with Exceptions found'");
		verifyTrue(schedulePage.isSearchExceptionApptMessageDisplayWithContent("No Appointments with Exceptions found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Patient Last Name,Patient First Name")
	public void Schedule_72_CorrectPatientName()
	{
		log.info("Schedule_72 - Step 01: Input correct Patient Last name");
		schedulePage.inputPatientLastNameValue("Piccolo");
		
		log.info("Schedule_72 - Step 02: Input correct Patient First name");
		schedulePage.inputPatientFirstNameValue("James");
		
		log.info("Schedule_72 - Step 03: Input correct Patient Preferred Name");
		schedulePage.inputPatientPreferredNameValue("");
		
		log.info("Schedule_72 - Step 04: Input incorrect Provider Last Name");
		schedulePage.inputProviderLastNameValue("");
		
		log.info("Schedule_72 - Step 05: Input incorrect Provider First Name");
		schedulePage.inputProviderFirstNameValue("");
		
		log.info("Schedule_72 - Step 06: Select Appointment Type");
		schedulePage.selectAppointmentType("");
		
		log.info("Schedule_72 - Step 07: Input incorrect Note");
		schedulePage.inputNoteValue("");
		
		log.info("Schedule_72 - Step 08: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Exception Appt of Patient: Panther, Pink");
		verifyTrue(schedulePage.isListOfExceptionApptDisplayWithPatientInfor("Piccolo, James"));
	}
	
	@Test(groups = { "regression" },description = "Correct all field")
	public void Schedule_73_CorrectAllField()
	{
		log.info("Schedule_73 - Step 01: Input correct Patient Last name");
		schedulePage.inputPatientLastNameValue("Piccolo");
		
		log.info("Schedule_73 - Step 02: Input correct Patient First name");
		schedulePage.inputPatientFirstNameValue("James");
		
		log.info("Schedule_73 - Step 03: Input correct Patient Preferred Name");
		schedulePage.inputPatientPreferredNameValue("");
		
		log.info("Schedule_73 - Step 04: Input correct Provider Last Name");
		schedulePage.inputProviderLastNameValue("Needle");
		
		log.info("Schedule_73 - Step 05: Input correct Provider First Name");
		schedulePage.inputProviderFirstNameValue("Space");
		
		log.info("Schedule_73 - Step 06: Select Appointment Type");
		schedulePage.selectAppointmentType(apptType);
		
		log.info("Schedule_73 - Step 07: Input correct Note");
		schedulePage.inputNoteValue("");
		
		log.info("Schedule_73 - Step 08: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Exception Appt with all correct infor");
		verifyTrue(schedulePage.isExceptionAppointmentDisplayWithCorrectInfor(apptType, "Piccolo, James", provider));
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
	private int numberOfExceptionApptItem;
	private String apptType, provider;
}