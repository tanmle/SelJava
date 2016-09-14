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

public class checkinAppt_015_Encounter extends AbstractTest{

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
	
	@Test(groups = { "regression" },description = "Appointment Details_Leaving the required fiels blank")
	public void checkinAppt_107_AppointmentDetails_LeavingRequiredFielsBlank()
	{
		log.info("CheckinAppt_107 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_107 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_107 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_107 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_107 - Step 05: Click Encounter");
		patientsPage.clickOKButton();
		patientsPage.clickOnEncounterButton();
		
		log.info("CheckinAppt_107 - Step 06: Leaving the required fiels blank");
		patientsPage.inputEncounterProvider("");
		patientsPage.inputEncounterAppointmentDate("");
		patientsPage.inputEncounterOffice("");
		
		log.info("CheckinAppt_107 - Step 07: Click Save button");
		patientsPage.clickOnSaveButton();
		
		log.info("VP: Website will display error messages");
		verifyTrue(patientsPage.isEncounterErrorMessageDisplay());
		
		log.info("VP: Provider textbox still displays");
		verifyTrue(patientsPage.isEncounterProviderTextboxDisplay());
		
		log.info("VP: Appointment date textbox still displays");
		verifyTrue(patientsPage.isEncounterAppointmentDateTextboxDisplay());
		
		log.info("VP: Office textbox still displays");
		verifyTrue(patientsPage.isEncounterOfficeTextboxDisplay());
	}
	
	@Test(groups = { "regression" },description = "Appointment Details_Input data into all fields")
	public void checkinAppt_108_AppointmentDetails_InputDataIntoAllFields()
	{
		log.info("CheckinAppt_108 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_108 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_108 - Step 03: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_108 - Step 04: Click Encounter");
		patientsPage.clickOKButton();
		patientsPage.clickOnEncounterButton();
		
		log.info("CheckinAppt_108 - Step 05: Input data into all fields");
		patientsPage.selectLeftEarLossLevel("1 Normal");
		patientsPage.selectLRightEarLossLevel("1 Normal");
		
		log.info("CheckinAppt_108 - Step 07: Click Save button");
		patientsPage.clickOnSaveButton();
		
		log.info("VP: Save successfully");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_Leaving all fields blank")
	public void checkinAppt_109_Diagnoses_ICD9Codes_SearchForICD9Codes_LeavingAllFieldsBlank()
	{
		log.info("CheckinAppt_109 - Step 01: Expand 'Diagnoses (ICD9-Codes)' section");
		patientsPage.expandSectionOnCheckin("Diagnoses (ICD9-Codes)");
		
		log.info("CheckinAppt_109 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchDiagnosesIcon();
		patientsPage.switchToICD9CodesSearchFrame(driver);
		
		log.info("CheckinAppt_109 - Step 03: Leaving all fields blank");
		patientsPage.inputICD9CodesSearch("","","","");
		
		log.info("CheckinAppt_109 - Step 04: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: Website will show list of all ICD9 Codes");
		verifyTrue(patientsPage.isNumberOfICD9CodeItemDisplay(5));
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter incorrect Code")
	public void checkinAppt_110_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterIncorrectCode()
	{
		log.info("CheckinAppt_110 - Step 01: Enter incorrect Code");
		patientsPage.inputICD9CodesSearch("123","","","");
		
		log.info("CheckinAppt_110 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: No ICD9 codes found");
		verifyTrue(patientsPage.isNoICD9CodesFoundMessageDisplay());
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter correct Code")
	public void checkinAppt_111_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterCorrectCode()
	{
		log.info("CheckinAppt_111 - Step 01: Enter correct Code");
		patientsPage.inputICD9CodesSearch("380.4","","","");
		
		log.info("CheckinAppt_111 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: ICD9 item displays with correct code");
		verifyTrue(patientsPage.isICD9CodesItemDisplayWithCode("380.4"));
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter incorrect Description")
	public void checkinAppt_112_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterIncorrectDescription()
	{
		log.info("CheckinAppt_112 - Step 01: Enter incorrect Description");
		patientsPage.inputICD9CodesSearch("","incorrect description","","");
		
		log.info("CheckinAppt_112 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: No ICD9 codes found");
		verifyTrue(patientsPage.isNoICD9CodesFoundMessageDisplay());
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter correct Description")
	public void checkinAppt_113_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterCorrectDescription()
	{
		log.info("CheckinAppt_113 - Step 01: Enter correct Description");
		patientsPage.inputICD9CodesSearch("","Impacted Cerumen","","");
		
		log.info("CheckinAppt_113 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: ICD9 item displays with correct description");
		verifyTrue(patientsPage.isICD9CodesItemDisplayWithDescription("Impacted Cerumen"));
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter incorrect Rank")
	public void checkinAppt_114_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterIncorrectRank()
	{
		log.info("CheckinAppt_114 - Step 01: Enter incorrect Rank");
		patientsPage.inputICD9CodesSearch("380.4","Impacted Cerumen","12345","");
		
		log.info("CheckinAppt_114 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: No ICD9 codes found");
		verifyTrue(patientsPage.isNoICD9CodesFoundMessageDisplay());
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter correct Rank")
	public void checkinAppt_115_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterCorrectRank()
	{
		log.info("CheckinAppt_115 - Step 01: Enter correct Rank");
		patientsPage.inputICD9CodesSearch("380.4","Impacted Cerumen","","");
		
		log.info("CheckinAppt_115 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: ICD9 item displays with correct rank");
		verifyTrue(patientsPage.isICD9CodesItemDisplayWithCorrectInformation("380.4","Impacted Cerumen",""));
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter incorrect appointment type")
	public void checkinAppt_116_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterIncorrectAppointmentType()
	{
		log.info("CheckinAppt_116 - Step 01: Enter incorrect appointment type");
		patientsPage.inputICD9CodesSearch("380.4","Impacted Cerumen","","Walk-In");
		
		log.info("CheckinAppt_116 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: No ICD9 codes found");
		verifyTrue(patientsPage.isNoICD9CodesFoundMessageDisplay());
	}
	
	@Test(groups = { "regression" },description = "Diagnoses (ICD9-Codes)_Search for ICD9 codes_ Enter correct appointment type")
	public void checkinAppt_117_Diagnoses_ICD9Codes_SearchForICD9Codes_EnterCorrectAppointmentType()
	{
		log.info("CheckinAppt_117 - Step 01: Enter incorrect appointment type");
		patientsPage.inputICD9CodesSearch("380.4","Impacted Cerumen","","Annual Test");
		
		log.info("CheckinAppt_117 - Step 02: Click on Search icon");
		patientsPage.clickOnSearchICD9Codes();
		
		log.info("VP: ICD9 item displays with correct appointment type");
		verifyTrue(patientsPage.isICD9CodesItemDisplayWithCorrectInformation("380.4","Impacted Cerumen",""));
		
		log.info("CheckinAppt_117 - Step 03: Go to Schedule page");
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeICD9Popup();
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_117 - Step 04: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_117 - Step 05: Delete appointment");
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