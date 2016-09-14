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

public class checkinAppt_009_HearingAids extends AbstractTest{

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
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		serial = getUniqueNumber();
	}
	
	@Test(groups = { "regression" },description = "Add new record_Incorrect Back & Save buttons")
	public void checkinAppt_60_HearingAidsIncorrectBackSaveButton()
	{
		log.info("CheckinAppt_60 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_60 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_60 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_60 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_60 - Step 05: Expand 'Insurance' section");
		patientsPage.expandSectionOnCheckin("Hearing Aids");
		
		log.info("CheckinAppt_60 - Step 06: Add new Insurance record");
		patientsPage.clickNewHearingAidsRecordButton();
		
		log.info("VP - Cannot save and the website shows an error message 'Position (1,2,3) is required.'");
		verifyTrue(patientsPage.isHearingAidsBackSaveButtonDisplaysCorrect());
		
	}

	@Test(groups = { "regression" },description = "Add new record Input data into all fields ")
	public void checkinAppt_61_HearingAidsAddNewRecordInputAllFields()
	{
		
		log.info("CheckinAppt_061 - Step 01: Input Hearing Aid Left Ear Purchse Date");
		patientsPage.inputHearingAidsLeftEarPurchseDate(month,date,year);
		
		log.info("CheckinAppt_061 - Step 02: Input Hearint Aids Left Ear Status");
		patientsPage.selectHearintAidsLeftEarStatus("Current");
		
		log.info("CheckinAppt_061 - Step 03: Select Hearing Aids Left Ear Manufacturer");
		patientsPage.selectHearingAidsLeftEarManufacturer("New Brand");
		
		log.info("CheckinAppt_061 - Step 4: Select Hearing Aids Left Ear Type");
		patientsPage.selectHearingAidsLeftEarType("CIC");
		
		log.info("CheckinAppt_061 - Step 05: Select Hearing Aids Left Ear Model");
		patientsPage.selectHearingAidsLeftEarModel("DEB1 (CIC)");
		
		log.info("CheckinAppt_061 - Step 06: Input Hearing Aids Left Type Searial");
		patientsPage.inputHearingAidsLeftTypeSearial(serial);
		
		log.info("CheckinAppt_061 - Step 07: Input Hearing Aid Right Ear Purchse Date");
		patientsPage.inputHearingAidsRightEarPurchseDate(month,date,year);
		
		log.info("CheckinAppt_061 - Step 08: Input Hearint Aids Right Ear Status");
		patientsPage.selectHearintAidsRightEarStatus("Current");
		
		log.info("CheckinAppt_061 - Step 09: Select Hearing Aids Right Ear Manufacturer");
		patientsPage.selectHearingAidsRightEarManufacturer("New Brand");

		log.info("CheckinAppt_061 - Step 10: Select Hearing Aids Right Ear Type");
		patientsPage.selectHearingAidsRightEarType("CIC");
		
		log.info("CheckinAppt_061 - Step 11: Select Hearing Aids Right Ear Model");
		patientsPage.selectHearingAidsRightEarModel("DEB1 (CIC)");
		
		log.info("CheckinAppt_061 - Step 12: Input Hearing Aids Right Type Searial");
		patientsPage.inputHearingAidsRightTypeSearial(serial);
		
		log.info("CheckinAppt_061 - Step 13: Click Save button");
		patientsPage.clickSaveHearingAid();
		
		log.info("VP - Save successfully");
		verifyTrue(patientsPage.isHearingAidsSaveSuccessfully());
		
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
	private String correctStartTime, correctEndTime, noteContent, serial;
}