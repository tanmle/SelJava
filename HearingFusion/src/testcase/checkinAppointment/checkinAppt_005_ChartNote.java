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

public class checkinAppt_005_ChartNote extends AbstractTest{

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
		apptType = "Cerumen management";
		apptStatus = "Scheduled";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		chartNote = "chart note "+getUniqueNumber();
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Add  new Chart Note")
	public void checkinAppt_032_AddNewChartNote()
	{
		log.info("CheckinAppt_032 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_032 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_032 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_032 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_032 - Step 05: Expand 'Chart Note' section");
		patientsPage.clickOKButton();
		patientsPage.expandSectionOnCheckin("Chart Note");
		
		log.info("CheckinAppt_032 - Step 06: Add new Chart Note");
		patientsPage.addNewChartNote(chartNote);
		
		log.info("VP: Save new note succesfully");
		verifyTrue(patientsPage.isPatientDetailSaveSuccessfullyMessageDisplay());
	}
	
	@Test(groups = { "regression" },description = "View Clinical Note details")
	public void checkinAppt_033_ViewChartNoteDetails()
	{
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_033 - Step 01: Expand 'Chart Note' section");
		patientsPage.clickOKButton();
		patientsPage.expandSectionOnCheckin("Chart Note");
		
		log.info("VP: New Clinical Note informations show correctly");
		verifyTrue(patientsPage.isChartNoteInfoShowCorrectly(chartNote));
		
		log.info("CheckinAppt_033 - Step 02: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_033 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_033 - Step 04: Delete appointment");
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
	private String noteContent,chartNote;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
}