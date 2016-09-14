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

public class checkinAppt_016_SearchICD9Codes_MainMenuButton extends AbstractTest{

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
		csvICD9File = "Search_FKICD9ForApptSearch.xls";
	}
	
	@Test(groups = { "regression" },description = "Download CSV")
	public void checkinAppt_118_SearchForICD9Codes_DownloadCSV()
	{
		log.info("CheckinAppt_118 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_118 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_118 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_118 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_118 - Step 05: Click Encounter");
		patientsPage.clickOKButton();
		patientsPage.clickOnEncounterButton();
		
		log.info("CheckinAppt_118 - Step 06: Expand 'Diagnoses (ICD9-Codes)' section");
		patientsPage.expandSectionOnCheckin("Diagnoses (ICD9-Codes)");
		
		log.info("CheckinAppt_118 - Step 07: Click on Search icon");
		patientsPage.clickOnSearchDiagnosesIcon();
		patientsPage.switchToICD9CodesSearchFrame(driver);
		
		log.info("CheckinAppt_118 - Step 08: Enter correct information");
		patientsPage.inputICD9CodesSearch("380.4","Impacted Cerumen","","Annual Test");
		
		log.info("CheckinAppt_118 - Step 09: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("CheckinAppt_118 - Step 10: Click Download CSV");
		patientsPage.clickICD9CodesSearchCSVButton();
		patientsPage.waitForDownloadCompleted(csvICD9File);
		
		log.info("VP: Download CSV file successfully");
		verifyTrue(patientsPage.isFileExist(csvICD9File));
		
		log.info("CheckinAppt_118 - Step 03. Delete the down loaded file");
		patientsPage.deleteFile(csvICD9File);
	}
	
	@Test(groups = { "regression" },description = "Search for ICD9 codes_ Help")
	public void checkinAppt_119_SearchForICD9Codes_Help()
	{
		log.info("CheckinAppt_119 - Step 01: Click Help button");
		patientsPage.clickICD9CodesSearchHelpButton();
		
		log.info("VP: Open Help successfully");
		verifyTrue(patientsPage.isHelpPageOpenSuccessfully());
	}
	
	@Test(groups = { "regression" },description = "Search for ICD9 codes_ Print")
	public void checkinAppt_120_SearchForICD9Codes_Print()
	{
		log.info("CheckinAppt_120 - Step 01: Click Print button");
		patientsPage.switchToICD9CodesSearchFrame(driver);
		patientsPage.clickICD9CodesSearchPrintButton();
		
		log.info("VP: Open Print successfully");
		verifyTrue(patientsPage.isICD9CodesSearchPrintPageOpenSuccessfully());
	}
	
	@Test(groups = { "regression" },description = "Search for ICD9 codes_ Email")
	public void checkinAppt_121_SearchForICD9Codes_Email()
	{
		log.info("CheckinAppt_121 - Step 01: Click Email button");
		patientsPage.switchToICD9CodesSearchFrame(driver);
		patientsPage.clickICD9CodesSearchEmailButton();
		
		log.info("VP: Open Email successfully");
		verifyTrue(patientsPage.isEmailPageOpenSuccessfully());
	
		log.info("CheckinAppt_121 - Step 02: Go to Schedule page");
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeICD9Popup();
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_121 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_121 - Step 04: Delete appointment");
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
	private String noteContent, csvICD9File;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
}