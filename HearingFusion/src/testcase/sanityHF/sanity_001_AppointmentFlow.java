package sanityHF;

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

public class sanity_001_AppointmentFlow extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		
		validPatientLastName="Udi"+getUniqueNumber();
		validHomePhone="310-454-5857";
		validZIP="90024";
		validPatientType="Competitive";
		validPatientFirstName="QATeam";
		
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		correctHour = 16;
		correctMinute = 0;
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		provider = "Needle, Space";
		apptType = "Follow Up";
		apptStatus = "Arrived";
		refResource = "Campaign";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Encounter Appointment")
	public void sanity_AppointmentFlow_001_EncounterAppointment()
	{
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);

		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 10: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, validPatientFirstName+" "+validPatientLastName, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 11: Open event created");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, validPatientLastName+", "+validPatientFirstName);

		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 12: open Checkin Appointment data");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 13: open Encounter tab");
		patientsPage.openAppointmentTab("Encounter");
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 14: enter Left Ear Hearing Loss");
		patientsPage.enterEarningLoss(true,"3 Moderate","Sensorineural","gradual/flat moderate");
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - Step 15: enter right Ear Hearing Loss");
		patientsPage.enterEarningLoss(false,"4 Moderately Severe","Sensorineural","gradual/flat moderate");
		
		log.info("sanity_AppointmentFlow_001_EncounterAppointment - step 16: Save edit infomation");
		patientsPage.clickSaveButton();
		
		log.info("VP: Appointment status is changed to Completed");
		verifyTrue(patientsPage.isAppointmentStatusSelected("Completed"));
		
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		//Post-Condition
		log.info("Post-Condition - step 01: Open schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, apptStatus);
												
		log.info("Post-Condition - Step 02: Open event created");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, validPatientLastName+", "+validPatientFirstName);
												
		log.info("Post-Condition - Step 03: delete event created");
		schedulePage.deleteAppointment();
		
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private int date, month, year,correctHour, correctMinute;
	private String correctStartTime, correctEndTime;
	private String apptType, apptStatus, refResource, provider, noteContent;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
}