package section;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Common;
import common.Constant;

public class section_004_AppointmentOutcome extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		correctHour = 16;
		correctMinute = 0;
		patientName = "Baker, Mark";

		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Arrived";
		patientFull = "Baker, Mark   (Henderson Ear)";
		patientName = "Baker, Mark";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		clinicalNote = "Clinical Note "+getUniqueName();
		preferName = "NickName "+getUniqueNumber();
	}
	
	@Test(groups = { "regression" },description = "Edit Appoint CheckIn")
	public void AppointmentOutcome_01_EditAppointCheckIn()
	{
		log.info("AppointmentOutcome_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);

		log.info("AppointmentOutcome_01 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("AppointmentOutcome_01 - Step 03: Open event created");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);

		log.info("AppointmentOutcome_01 - Step 04: open Checkin Appointment data");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("VP: Check-in tab selected");
		verifyTrue(patientsPage.isAppointmentTabSelected("Check-In"));
		
		log.info("VP: Encounter and Create Sales Order exists ");
		verifyTrue(patientsPage.isAppointmentTabsExists());
		
		log.info("AppointmentOutcome_01 - step 05: input Value To Patient Preferred Name Field");
		patientsPage.inputValueToPatientPreferredNameField(preferName);
		
		log.info("AppointmentOutcome_01 - step 06: Save edit infomation");
		patientsPage.clickSaveButton();
		
		log.info("AppointmentOutcome_01 - step 07: Open schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		
		log.info("AppointmentOutcome_01 - Step 08: Open event created");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);

		log.info("AppointmentOutcome_01 - Step 09: open Checkin Appointment data");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("VP: Infomation edited is changed");
		verifyTrue(patientsPage.isPatientPreferredNameCorrect(preferName));
		
	}
	@Test(groups = { "regression" },description = "Edit Encounter")
	public void AppointmentOutcome_02_EditEncounter()
	{
		log.info("AppointmentOutcome_02 - Step 01: open Encounter tab");
		patientsPage.openAppointmentTab("Encounter");
		
		log.info("VP: Sales Opportunity checked");
		verifyTrue(patientsPage.isSalesOpportunityCheck());
		
		log.info("AppointmentOutcome_02 - Step 02: enter Left Ear Hearing Loss");
		patientsPage.enterEarningLoss(true,"3 Moderate","Sensorineural","gradual/flat moderate");
		
		log.info("AppointmentOutcome_02 - Step 03: enter right Ear Hearing Loss");
		patientsPage.enterEarningLoss(false,"4 Moderately Severe","Sensorineural","gradual/flat moderate");
		
		log.info("AppointmentOutcome_02 - step 04: Save edit infomation");
		patientsPage.clickSaveButton();
		
		log.info("VP: Sales Opportunity checked");
		verifyTrue(patientsPage.isAppointmentStatusSelected("Completed"));

	}
	@Test(groups = { "regression" },description = "Clinical Notes")
	public void AppointmentOutcome_03_ClinicalNotes()
	{
		log.info("AppointmentOutcome_03 - Step 01: expand Clinical Notes");
		patientsPage.expandSectionOnCheckin("Clinical Notes");

		log.info("AppointmentOutcome_03 - Step 02: add new Clinical Notes");
		patientsPage.addNewClinicalNote(clinicalNote);
		
		log.info("AppointmentOutcome_03 - Step 03: back patient page");
		patientsPage.clickOnBackButton();

		log.info("AppointmentOutcome_03 - Step 04: expand Clinical Notes");
		patientsPage.expandSectionOnCheckin("Clinical Notes");
		
		log.info("VP: Clinical Notes saved");
		verifyTrue(patientsPage.isClinicalNoteDisplayOnCheckin(clinicalNote));
		
		//Post-Condition
		log.info("Post-Condition - step 01: Open schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, apptStatus);
		
		log.info("Post-Condition - Step 02: Open event created");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Post-Condition - Step 03: delete event created");
		schedulePage.deleteAppointment();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private int date, month, year,correctHour, correctMinute;
	private String patientName,  preferName;
	private String correctStartTime, correctEndTime;
	private String clinicalNote;
	private String apptType, apptStatus, patientFull, refResource, provider, noteContent;
}