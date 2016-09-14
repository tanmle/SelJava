package patients;
import java.io.IOException;

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
import common.Constant;
public class patients_005_PatientDetails extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
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
		validPatientRecallDate="11/11/1991";
		validPatientRecallNote="Just for testing";
		updatePatientRecallNote="Updated note";
		updatePatientRecallDate="12/12/2012";
		validClinicalNote="Just for testing";
				
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Add new patient recall")
	public void patientDetails_001_AddNewPatientRecall()
	{
		log.info("patientDetails_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("patientDetails_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patientDetails_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patientDetails_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patientDetails_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patientDetails_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patientDetails_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patientDetails_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patientDetails_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patientDetails_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_001 - Step 15: Expand patient recall section");
		patientsPage.expandPatientDetailPatientRecall();
		
		log.info("patientDetails_001 - Step 16: Click New link");
		patientsPage.clickPatientDetailPatientRecallNewLink();
		
		log.info("patientDetails_001 - Step 17: Input patient recall date");
		patientsPage.inputPatientDetailsPatientRecallDate(validPatientRecallDate);
		
		log.info("patientDetails_001 - Step 18: Input patient recall note");
		patientsPage.inputPatientDetailsPatientRecallNote(validPatientRecallNote);
		
		log.info("patientDetails_001 - Step 19: Check completed checkbox");
		patientsPage.selectPatientDetailPatientRecallCompletedCheckbox(true);
		
		log.info("patientDetails_001 - Step 20: Click patient recall save link");
		patientsPage.clickPatientDetailsPatientRecallSaveLink();
		
		log.info("patientDetails_001 - Step 21: Click patient recall back link");
		patientsPage.clickPatientDetailPatientRecallBackButton();
		
		log.info("patientDetails_001 - Step 22: Expand patient recall section");
		patientsPage.expandPatientDetailPatientRecall();
		
		log.info("VP: Save new Patient Recall succesfully and created Notes displays in Patient Recall section");
		verifyTrue(patientsPage.isPatientDetailsPatientRecallNoteContains("1", validPatientRecallNote));
	}
	@Test(groups = { "regression" },description = "View patient recall details")
	public void patientDetails_002_ViewPatientRecallDetails()
	{
		log.info("patientDetails_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_002 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_002 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_002 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_002 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_002 - Step 06: Expand patient recall section");
		patientsPage.expandPatientDetailPatientRecall();
		
		log.info("patientDetails_002 - Step 07: Click patient recall detail link");
		patientsPage.clickPatientDetailsPatientRecallLink("1");
		
		log.info("VP: Show Patient Recall details");
		verifyTrue(patientsPage.isPatientDetailsPatientRecallTitleDisplays());
	}
	@Test(groups = { "regression" },description = "Edit patient recall details")
	public void patientDetails_003_EditPatientRecallDetails()
	{
		log.info("patientDetails_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_003 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_003 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_003 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_003 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_003 - Step 06: Expand patient recall section");
		patientsPage.expandPatientDetailPatientRecall();
		
		log.info("patientDetails_003 - Step 07: Click patient recall detail link");
		patientsPage.clickPatientDetailsPatientRecallLink("1");
		
		log.info("patientDetails_003 - Step 08: Input patient recall date");
		patientsPage.inputPatientDetailsPatientRecallDate(updatePatientRecallDate);
		
		log.info("patientDetails_003 - Step 09: Input patient recall note");
		patientsPage.inputPatientDetailsPatientRecallNote(updatePatientRecallNote);
		
		log.info("patientDetails_003 - Step 10: Check completed checkbox");
		patientsPage.selectPatientDetailPatientRecallCompletedCheckbox(true);
		
		log.info("patientDetails_003 - Step 11: Click patient recall save link");
		patientsPage.clickPatientDetailsPatientRecallSaveLink();
		
		log.info("VP: Edit Patient Recall succesfully");
		verifyTrue(patientsPage.isPatientDetailsPatientRecallSaved());
	}
	@Test(groups = { "regression" },description = "Add new clinical note")
	public void patientDetails_004_AddNewClinicalNote()
	{
		log.info("patientDetails_004 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_004 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_004 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_004 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_004 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_004 - Step 06: Expand clinical note section");
		patientsPage.expandPatientDetailClinicalNote();
		
		log.info("patientDetails_004 - Step 07: Click New link");
		patientsPage.clickPatientDetailClinicalNoteNewLink();
		
		log.info("patientDetails_004 - Step 08: Input clinical note note");
		patientsPage.inputPatientDetailsClinicalNote(validClinicalNote);;
		
		log.info("patientDetails_004 - Step 09: Click clinical note save link");
		patientsPage.clickPatientDetailsClinicalNoteSaveLink();
		
		log.info("patientDetails_004 - Step 10: Click patient clinical back link");
		patientsPage.clickPatientDetailClinicalNoteBackButton();
		
		log.info("patientDetails_004 - Step 11: Expand clinical note section");
		patientsPage.expandPatientDetailClinicalNote();
		
		log.info("VP: Save new Clinical Notes succesfully and created Clinical Notes displays in Clinical Notes section");
		verifyTrue(patientsPage.isPatientDetailsPatientClinicalNoteContains("1", validClinicalNote));
	}
	@Test(groups = { "regression" },description = "View patient clinical note")
	public void patientDetails_005_ViewPatientClinicalNote()
	{
		log.info("patientDetails_005 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_005 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_005 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_005 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_005 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_005 - Step 06: Expand clinical note section");
		patientsPage.expandPatientDetailClinicalNote();
		
		log.info("patientDetails_005 - Step 07: Click clinical detail link");
		patientsPage.clickPatientDetailsClinicalNotelLink("1");
		
		log.info("VP: Show Clinical Note details");
		verifyTrue(patientsPage.isPatientDetailsClinicalNoteTitleDisplays());
	}
	@Test(groups = { "regression" },description = "Add new sale order item")
	public void patientDetails_006_AddNewSaleOrderItem()
	{
		log.info("patientDetails_006 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_006 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_006 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_006 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_006 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_006 - Step 06: Expand sale and order section");
		patientsPage.expandPatientDetailsInvoices();
		
		log.info("patientDetails_006 - Step 07: Click New link");
		patientsPage.clickPatientDetailsInvoicesNewLink();
		
		log.info("VP: Create Sale Order page displays");
		verifyTrue(patientsPage.isPatientDetailsCreateSalesOrderPageDisplays());

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
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	private String validPatientRecallDate, validPatientRecallNote, updatePatientRecallNote, updatePatientRecallDate;
	private String validClinicalNote;
}
