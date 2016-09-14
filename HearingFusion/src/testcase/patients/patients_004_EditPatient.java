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

public class patients_004_EditPatient extends AbstractTest{
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
		patientFirstNameUpdate="FNUpdate"+getUniqueNumber();
		patientLastNameUpdate="LNUpdate"+getUniqueNumber();
		patientTypeUpdate="Prospect";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Edit added patient")
	public void editPatient_001_EditAddedPatient()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("editPatient_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("editPatient_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("editPatient_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("editPatient_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("editPatient_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("editPatient_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("editPatient_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("editPatient_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("editPatient_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("editPatient_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("editPatient_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("editPatient_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("editPatient_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("editPatient_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("editPatient_001 - Step 15: Update patient first name");
		patientsPage.inputPatientDetailFirstName(patientFirstNameUpdate);
		
		log.info("editPatient_001 - Step 16: Update patient last name");
		patientsPage.inputPatientDetailLastName(patientLastNameUpdate);
		
		log.info("editPatient_001 - Step 17: Update patient type");
		patientsPage.selectPatientDetailType(patientTypeUpdate);
		
		log.info("editPatient_001 - Step 18: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Search updated patient with old values")
	public void editPatient_002_SearchUpdatePatientWithOldValue()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		patientFirstNameUpdate="FNUpdate"+getUniqueNumber();
		patientLastNameUpdate="LNUpdate"+getUniqueNumber();
		
		log.info("editPatient_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("editPatient_002 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("editPatient_002 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("editPatient_002 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("editPatient_002 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("editPatient_002 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("editPatient_002 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("editPatient_002 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("editPatient_002 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("editPatient_002 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("editPatient_002 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("editPatient_002 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("editPatient_002 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("editPatient_002 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("editPatient_002 - Step 15: Update patient first name");
		patientsPage.inputPatientDetailFirstName(patientFirstNameUpdate);
		
		log.info("editPatient_002 - Step 16: Update patient last name");
		patientsPage.inputPatientDetailLastName(patientLastNameUpdate);
		
		log.info("editPatient_002 - Step 17: Update patient type");
		patientsPage.selectPatientDetailType(patientTypeUpdate);
		
		log.info("editPatient_002 - Step 18: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("editPatient_002 - Step 19: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("editPatient_002 - Step 20: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("editPatient_002 - Step 21: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("editPatient_002 - Step 22: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Message 'No Patients found' displays");
		verifyTrue(patientsPage.isSearchMessageDisplays("No Patients found"));
	}
	@Test(groups = { "regression" },description = "Search updated patient with new values")
	public void editPatient_003_SearchUpdatePatientWithNewValue()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		patientFirstNameUpdate="FNUpdate"+getUniqueNumber();
		patientLastNameUpdate="LNUpdate"+getUniqueNumber();
		
		log.info("editPatient_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("editPatient_003 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("editPatient_003 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("editPatient_003 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("editPatient_003 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("editPatient_003 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("editPatient_003 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("editPatient_003 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("editPatient_003 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("editPatient_003 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("editPatient_003 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("editPatient_003 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("editPatient_003 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("editPatient_003 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("editPatient_003 - Step 15: Update patient first name");
		patientsPage.inputPatientDetailFirstName(patientFirstNameUpdate);
		
		log.info("editPatient_003 - Step 16: Update patient last name");
		patientsPage.inputPatientDetailLastName(patientLastNameUpdate);
		
		log.info("editPatient_003 - Step 17: Update patient type");
		patientsPage.selectPatientDetailType(patientTypeUpdate);
		
		log.info("editPatient_003 - Step 18: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("editPatient_003 - Step 19: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("editPatient_003 - Step 20: Input patient last name");
		patientsPage.inputPatientRecordLastName(patientLastNameUpdate);
		
		log.info("editPatient_003 - Step 21: Input patient first name");
		patientsPage.inputPatientRecordFirstName(patientFirstNameUpdate);
		
		log.info("editPatient_003 - Step 22: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has Last name");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientName(patientLastNameUpdate));
		
		log.info("VP: Show list of patients has First name");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientName(patientFirstNameUpdate));
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
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,
	validPatientType, patientFirstNameUpdate,patientLastNameUpdate,patientTypeUpdate;
}
