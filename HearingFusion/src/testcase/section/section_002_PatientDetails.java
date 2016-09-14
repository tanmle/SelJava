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

public class section_002_PatientDetails extends AbstractTest{

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
		patientFirstName = "Mark";
		patientLastName = "Baker";
		firstName = "Udi_"+getUniqueNumber();
		lastName = "Last_Name_"+getUniqueNumber();
		homePhone = "555-555-5555";
	}
	
	@Test(groups = { "regression" },description = "Patient Details Contact Information")
	public void PatientDetails_01_ContactInformation()
	{
		log.info("PatientDetails_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("PatientDetails_01 - Step 02: Open Patients page");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("cloudDocs_01 - Step 03: Search for a patient");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		
		log.info("VP: Patient information details displays");
		verifyTrue(patientsPage.isContactInformationDetailsDisplays(patientName));
	
	}
	@Test(groups = { "regression" },description = "Patient Details Appointmentss")
	public void PatientDetails_02_Appointments()
	{
		log.info("PatientDetails_02 - Step 01: Open Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, apptRescheduleStatus);
	
		log.info("PatientDetails_02 - Step 02: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("VP: Verify Add patient button exists");
		verifyTrue(schedulePage.isAddPatientButtonDisplays());
		
		log.info("PatientDetails_02 - Step 03: Close Schedule event");
		schedulePage.clickCancelButton();
	}

	@Test(groups = { "regression" },description = "Patient Details Sales Invoices")
	public void PatientDetails_03_SalesInvoice()
	{
		log.info("PatientDetails_03 - Step 01: Open Patients page");
		driver = schedulePage.switchToTopWindowFrame(driver);
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
	
		log.info("PatientDetails_03 - Step 02: Close Schedule event");
		patientsPage.addNewPatient(firstName, lastName, homePhone);
		
		log.info("PatientDetails_03 - Step 03: Close Schedule event");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
		log.info("PatientDetails_03 - Step 04: select HIPAA Waiver Signed");
		patientsPage.selectCheckBoxPatientDetails("HIPAA Waiver Signed");
		
		log.info("PatientDetails_03 - Step 05: Close Schedule event");
		patientsPage.clickSaveButton();
		
		log.info("PatientDetails_03 - Step 06: ReOpen Patient page ");
		patientsPage.openPatientsPage(driver, ipClient);
		
		log.info("cloudDocs_01 - Step 03: Search for a patient");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		
		//chart note
		log.info("PatientDetails_03 - Step 07: expand Chart note");
		patientsPage.expandSectionOnCheckin("Chart Note");
		
		log.info("VP: Verify Chart note displays");
		verifyTrue(patientsPage.isChartNoteExpand());
		
		//companion
		log.info("VP: Verify Companion displays");
		verifyTrue(patientsPage.isCompanionDisplays());
		
		//Guardian
		log.info("VP: Verify Guardian/ Responsible Party displays");
		verifyTrue(patientsPage.isGuardianResponsiblePartyDisplays());
		
		//Patient Recalls
		log.info("PatientDetails_03 - Step 08: expand Guardian/ Responsible Party");
		patientsPage.expandSectionOnCheckin("Patient Recalls");
		
		log.info("VP: Verify Patient Recalls displays");
		verifyTrue(patientsPage.isPatientRecallsExpand());
		
		//Clinical Notes
		log.info("PatientDetails_03 - Step 09: expand Clinical Notes");
		patientsPage.expandSectionOnCheckin("Clinical Notes");
		
		log.info("VP: Verify Clinical Notes displays");
		verifyTrue(patientsPage.isClinicalNotesExpand());
		
		//Invoices/Sales
		log.info("PatientDetails_03 - Step 10: expand Invoices/Sales");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("VP: Verify Invoices/Sales displays");
		verifyTrue(patientsPage.isInvoicesSalesExpand());
		
		//Eligibility
		log.info("PatientDetails_03 - Step 11: expand Eligibility");
		patientsPage.expandSectionOnCheckin("Eligibility Verification");
						
		log.info("VP: Verify Eligibility displays");
		verifyTrue(patientsPage.isEligibilityVerificationExpand());
		
		//Equipment
		log.info("PatientDetails_03 - Step 12: expand Equipment");
		patientsPage.expandSectionOnCheckin("Equipment");

		log.info("VP: Verify Equipment displays");
		verifyTrue(patientsPage.isEquipmentExpand());
		
		//Repairs
		log.info("PatientDetails_03 - Step 13: expand Repairs");
		patientsPage.expandSectionOnCheckin("Repairs");

		log.info("VP: Verify Repairs displays");
		verifyTrue(patientsPage.isRepairsExpand());
		
		//CBO Billing Notes
		log.info("PatientDetails_03 - Step 14: expand CBO Billing Notes");
		patientsPage.expandSectionOnCheckin("CBO Billing Notes");

		log.info("VP: Verify CBO Billing Notes displays");
		verifyTrue(patientsPage.isCBOBillingNotesExpand());
		
		//Associated Office
		log.info("PatientDetails_03 - Step 15: expand Associated Offices");
		patientsPage.expandSectionOnCheckin("Associated Offices");

		log.info("VP: Verify Associated Office displays");
		verifyTrue(patientsPage.isAssociatedOfficeExpand());
		
		//Appointments Office
		log.info("PatientDetails_03 - Step 16: expand Chart note");
		patientsPage.expandSectionOnCheckin("Appointments");

		log.info("VP: Verify Appointments Expand");
		verifyTrue(patientsPage.isAppointmentsExpand());
		
		//ListMenu
		log.info("VP: Verify Chart note displays");
		verifyTrue(patientsPage.isPatientDetailsMenuBarCorrect());
	}
	@Test(groups = { "regression" },description = "Patient Details Hearing Aid Equiment")
	public void PatientDetails_04_HearingAidEquiment()
	{
		log.info("PatientDetails_04 - Step 01: expand Hearing Aids");
		patientsPage.expandSectionOnCheckin("Hearing Aids");
		
		log.info("VP: Verify Chart note displays");
		verifyTrue(patientsPage.isHearingAidsExpand());
	
	}
	@Test(groups = { "regression" },description = "Patient Details Insurance")
	public void PatientDetails_05_Insurance()
	{
		//Insurance
		log.info("PatientDetails_05 - Step 01: expand Insurance");
		patientsPage.expandSectionOnCheckin("Insurance");
		
		log.info("VP: Verify Chart note displays");
		verifyTrue(patientsPage.isInsuranceExpand());
	
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
	private String firstName, lastName, homePhone;
	private int date, month, year, correctHour, correctMinute;
	private String patientName, patientFirstName, patientLastName;
	private String apptRescheduleStatus;
}