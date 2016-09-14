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

public class checkinAppt_008_InsuranceAddNewRecord extends AbstractTest{

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
		correctStartTime ="03:00 PM";
		correctEndTime = "04:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "piccolo, john   (Hearing Fun)";
		patientName = "piccolo, john";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Add new record: Leaving the require field Position (1,2,3) blank")
	public void checkinAppt_57_AddNewRecordLeavingPositionBlank()
	{
		log.info("CheckinAppt_57 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_57 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_57 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_57 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_57 - Step 05: Expand 'Insurance' section");
		patientsPage.expandSectionOnCheckin("Insurance");
		
		log.info("CheckinAppt_57 - Step 06: Add new Insurance record");
		patientsPage.clickNewInsuranceRecordButton();
		
		log.info("CheckinAppt_57 - Step 07: Click on Search icon for Carrier");
		patientsPage.clickOnSearchIconForCarrier();
		patientsPage.switchToInsuranceFrame(driver);
		
		log.info("CheckinAppt_57 - Step 08: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_57 - Step 09: Click on Search button");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("CheckinAppt_57 - Step 10: Select Carrier");
		patientsPage.selectCarrierByName("Aetna");
		
		log.info("CheckinAppt_57 - Step 11: Click select Plan Type"); 
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.selectPatientInsuracePlanType("PPO");
		
		log.info("CheckinAppt_57 - Step 12: Click Save");
		patientsPage.clickSavePatientInsurace();
		
		log.info("VP - Cannot save and the website shows an error message 'Position (1,2,3) is required.'");
		verifyTrue(patientsPage.isCannotSavePaitentInsurace());
		verifyTrue(patientsPage.isMessageWarningPositionRequiredDisplays());
		
	}

	@Test(groups = { "regression" },description = "Add new record: Input correct data into all fields")
	public void checkinAppt_58_AddNewRecordInputCorrectDataIntoAllFields()
	{
		log.info("CheckinAppt_58 - Step 01: Click on Search icon for Carrier");
		patientsPage.clickOnSearchIconForCarrier();
		patientsPage.switchToInsuranceFrame(driver);
		
		log.info("CheckinAppt_58 - Step 02: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_58 - Step 03: Click on Search button");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("CheckinAppt_58 - Step 04: Select Carrier");
		patientsPage.selectCarrierByName("Aetna");
		
		log.info("CheckinAppt_58 - Step 05: Click select Plan Type"); 
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.selectPatientInsuracePlanType("PPO");
		
		log.info("CheckinAppt_58 - Step 06: Click select Position"); 
		patientsPage.selectPatientInsuracePosition("3");	
		
		log.info("CheckinAppt_58 - Step 07: Click Save");
		patientsPage.clickSavePatientInsurace();
		
		log.info("VP - Save successfully.");
		verifyTrue(patientsPage.isSavePaitentInsuraceSuccess());
		
		//Post-condition
		log.info("Post-condition - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("Post-condition - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Post-condition - Step 03: Delete appointment");
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
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider ;
	private String correctStartTime, correctEndTime, noteContent;
}