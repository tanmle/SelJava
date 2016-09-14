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

public class checkinAppt_014_CheckIn extends AbstractTest{

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
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Check In_Hold")
	public void checkinAppt_096_CheckIn_Hold()
	{
		log.info("CheckinAppt_096 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_096 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_096 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_096 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		patientsPage.clickOKButton();
		
		log.info("CheckinAppt_096 - Step 05: Click hold button");
		patientsPage.clickHoldButton();
		patientsPage.clickOKButton();
		
		log.info("VP: Record saved message displays");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
		log.info("VP: Hold release button displays");
		verifyTrue(patientsPage.isReleaseHoldButtonDisplay());
		
		log.info("VP: Hold button does not display");
		verifyFalse(patientsPage.isHoldButtonDisplay());
	}
	
	@Test(groups = { "regression" },description = "Check In_Release Hold")
	public void checkinAppt_097_CheckIn_ReleaseHold()
	{
		log.info("CheckinAppt_097 - Step 01: Click hold release button");
		patientsPage.clickReleaseHoldButton();
		patientsPage.clickOKButton();
		
		log.info("VP: Record saved message displays");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
		log.info("VP: Hold button displays");
		verifyTrue(patientsPage.isHoldButtonDisplay());
		
		log.info("VP: Hold release button does not display");
		verifyFalse(patientsPage.isReleaseHoldButtonDisplay());
	}
	
//	@Test(groups = { "regression" },description = "Check In_Verify Eligibility")
//	public void checkinAppt_098_CheckIn_VerifyEligibility()
//	{
//		
//	}
	
	@Test(groups = { "regression" },description = "Check In_Order Statement")
	public void checkinAppt_099_CheckIn_OrderStatement()
	{
		log.info("CheckinAppt_099 - Step 01: Click Order Statement button");
		patientsPage.clickOrderStatementButton();
		
		log.info("VP: Open Order Statement successfully");
		verifyTrue(patientsPage.isOrderStatementDisplays());
	}
	
	@Test(groups = { "regression" },description = "Check In_Schedule")
	public void checkinAppt_100_CheckIn_Schedule()
	{
		log.info("CheckinAppt_100 - Step 01: Click Schedule button");
		schedulePage = patientsPage.clickScheduleButton();
		
		log.info("VP: Schedule page displays");
		verifyTrue(schedulePage.isPageOnTopNavigateBarOpened("Schedule"));
	}
	
	@Test(groups = { "regression" },description = "Check In_Print Clinical Notes")
	public void checkinAppt_101_CheckIn_PrintClinicalNotes()
	{
		log.info("CheckinAppt_101 - Step 01: Open Appointment detail");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_101 - Step 02: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		patientsPage.clickOKButton();
		
		log.info("CheckinAppt_101 - Step 03: Click Print Clinical Notes button");
		patientsPage.clickPrintClinicalNotesButton();
		
		log.info("VP: Print Clinical Notes successfully");
		verifyTrue(patientsPage.isPrintClinicalNotesDisplay());
	}
	
	@Test(groups = { "regression" },description = "Check In_Print Chart Notes")
	public void checkinAppt_102_CheckIn_PrintChartNotes()
	{
		log.info("CheckinAppt_102 - Step 01: Click Order Statement button");
		patientsPage.clickPrintChartNotesButton();
		
		log.info("VP: Open Order Statement successfully");
		verifyTrue(patientsPage.isPrintChartNotesDisplay());
	}
	
	@Test(groups = { "regression" },description = "Check In_Cloud Docs")
	public void checkinAppt_103_CheckIn_CloudDocs()
	{
		log.info("CheckinAppt_103 - Step 01: Click Cloud docs button");
		patientsPage.clickCloudDocsButton();
		
		log.info("VP: Open Cloud Docs successfully");
		verifyTrue(patientsPage.isCloudDocsPopupOpen());
		
		log.info("CheckinAppt_103 - Step 02: Close Cloud docs popup");
		patientsPage.closeCloudDocsPopup();
	}
	
	@Test(groups = { "regression" },description = "Check In_Help")
	public void checkinAppt_104_CheckIn_Help()
	{
		log.info("CheckinAppt_104 - Step 01: Click Help button");
		patientsPage.clickHelpButton();
		
		log.info("VP: Open Help successfully");
		verifyTrue(patientsPage.isHelpPageOpenSuccessfully());
	}
	
	@Test(groups = { "regression" },description = "Check In_Print")
	public void checkinAppt_105_CheckIn_Print()
	{
		log.info("CheckinAppt_105 - Step 01: Click Print button");
		patientsPage.clickPrintButton();
		
		log.info("VP: Open Print successfully");
		verifyTrue(patientsPage.isPrintPageOpenSuccessfully());
	}
	
	@Test(groups = { "regression" },description = "Check In_Email")
	public void checkinAppt_106_CheckIn_Email()
	{
		log.info("CheckinAppt_106 - Step 01: Click Email button");
		patientsPage.clickEmailButton();
		
		log.info("VP: Open Email successfully");
		verifyTrue(patientsPage.isEmailPageOpenSuccessfully());
		
		log.info("CheckinAppt_106 - Step 02: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_106 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_106 - Step 04: Delete appointment");
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
	private String noteContent;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
}