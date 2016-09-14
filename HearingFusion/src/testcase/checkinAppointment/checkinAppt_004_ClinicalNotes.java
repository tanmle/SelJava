package checkinAppointment;

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

public class checkinAppt_004_ClinicalNotes extends AbstractTest{

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
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		clinicalNote = "clinical note "+getUniqueNumber();
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Add  new Clinical Note")
	public void checkinAppt_030_AddNewClinicalNote()
	{
		log.info("CheckinAppt_030 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_030 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_030 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_030 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_030 - Step 05: Expand 'Clinical Notes' section");
		patientsPage.expandSectionOnCheckin("Clinical Notes");
		
		log.info("CheckinAppt_030 - Step 06: Add new Clinical Note");
		patientsPage.addNewClinicalNote(clinicalNote);
		
		log.info("VP: Save new record succesfully");
		verifyTrue(patientsPage.isClinicalNoteInfoShowCorrectly(clinicalNote, qaStaffUsername));
	}
	
	@Test(groups = { "regression" },description = "View Clinical Note details")
	public void checkinAppt_031_ViewClinicalNoteDetails()
	{
		log.info("CheckinAppt_031 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_031 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_031 - Step 03: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_031 - Step 04: Expand 'Clinical Notes' section");
		patientsPage.expandSectionOnCheckin("Clinical Notes");
		
		log.info("VP: New Clinical Note displays");
		verifyTrue(patientsPage.isClinicalNoteDisplayOnCheckin(clinicalNote));
		
		log.info("CheckinAppt_031 - Step 05: View detail Clinical Note");
		patientsPage.viewClinicalNoteDetail(clinicalNote);
		
		log.info("VP: New Clinical Note informations show correctly");
		verifyTrue(patientsPage.isClinicalNoteInfoShowCorrectly(clinicalNote, qaStaffUsername));
		
		log.info("CheckinAppt_031 - Step 06: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_031 - Step 07: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_031 - Step 08: Delete appointment");
		schedulePage.deleteAppointment();
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
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private String noteContent,clinicalNote;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
}