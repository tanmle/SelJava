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

public class checkinAppt_003_PatientRecalls extends AbstractTest{

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
		patientRecallNote = "Patient Recall Note "+getUniqueNumber();
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		dateTimeString = month + "/" + date + "/" + year;
	}
	
	@Test(groups = { "regression" },description = "Add  new patient recall")
	public void checkinAppt_028_AddNewPatientRecall()
	{
		log.info("CheckinAppt_028 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_028 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_028 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_028 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_028 - Step 05: Expand 'Patient Recalls' section");
		patientsPage.expandSectionOnCheckin("Patient Recalls");
		
		log.info("CheckinAppt_028 - Step 06: Add new patient recall");
		patientsPage.addNewPatientRecall(dateTimeString, patientRecallNote, true);
		
		log.info("VP: Save new record succesfully");
		verifyTrue(patientsPage.isPatientRecallSaveSuccessfully());
	}
	
	@Test(groups = { "regression" },description = "View patient recall details")
	public void checkinAppt_029_ViewPatientRecallDetails()
	{
		log.info("CheckinAppt_029 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_029 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_029 - Step 03: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_029 - Step 04: Expand 'Patient Recalls' section");
		patientsPage.expandSectionOnCheckin("Patient Recalls");
		
		log.info("VP: New patient recall displays");
		verifyTrue(patientsPage.isPatientRecallDisplayOnCheckin(patientRecallNote));
		
		log.info("CheckinAppt_029 - Step 05: View detail patient recall");
		patientsPage.viewPatientRecallDetail(patientRecallNote);
		
		log.info("VP: New patient recall informations show correctly");
		verifyTrue(patientsPage.isPatientRecallInfoShowCorrectly(patientRecallNote, true));
		
		log.info("CheckinAppt_029 - Step 06: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_029 - Step 07: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_029 - Step 08: Delete appointment");
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
	private String noteContent,patientRecallNote, dateTimeString;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
}