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

public class patients_009_PatientDetails_Hearing_Aid extends AbstractTest{
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
		
		validPurchaseDate="11/11/2014";
		updatePurchaseDate="12/12/2014";
		validManufacturer="Generic";
		validType="BTE";
		validModel="ABC 100 (BTE)";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Add New Record_Input valid values")
	public void patients_PatientDetails_Hearing_Aid_001_AddNewRecord_InputValidValues()
	{
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 15: Expand hearing aid");
		patientsPage.expandPatientDetailsHearingAid();
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 16: Click hearing aid new link");
		patientsPage.clickPatientDetailsHearingAidNewLink();
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 17: Input hearing aid purchase date");
		patientsPage.inputPatientDetailsHearingAidPurchaseDate(validPurchaseDate);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 18: Select hearing aid manufacturer");
		patientsPage.selectPatientDetailsHearingAidManufacturer(validManufacturer);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 19: Select hearing aid type");
		patientsPage.selectHearingAidsLeftEarType(validType);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 20: Select hearing aid model");
		patientsPage.selectHearingAidsLeftEarModel(validModel);
		
		log.info("patients_PatientDetails_Hearing_Aid_001 - Step 21: Click hearing aid save button");
		patientsPage.clickPatientDetailsHearingAidSaveButton();
		
		log.info("VP - Save successfully.");
		verifyTrue(patientsPage.isPatientDetailsHearingAidSaved());
		
	}
	@Test(groups = { "regression" },description = "View hearing aid details")
	public void patients_PatientDetails_Hearing_Aid_002_ViewHearingAidDetail()
	{
		log.info("patients_PatientDetails_Hearing_Aid_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Hearing_Aid_002 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Hearing_Aid_002 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Hearing_Aid_002 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Hearing_Aid_002 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Hearing_Aid_002 - Step 06: Expand patient hearing aid section");
		patientsPage.expandPatientDetailsHearingAid();
		
		log.info("patients_PatientDetails_Hearing_Aid_002 - Step 07: Click patient recall detail link");
		patientsPage.clickPatientDetailsHearingAidDetaiLink("1");
		
		log.info("VP: Show Patient Hearing Aid details");
		verifyTrue(patientsPage.isPatientDetailsHearingAidDetailDisplays());
	}
	@Test(groups = { "regression" },description = "Edit hearing aid detail")
	public void patients_PatientDetails_Hearing_Aid_003_ViewHearingAidDetail()
	{
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 06: Expand patient hearing aid section");
		patientsPage.expandPatientDetailsHearingAid();
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 07: Click patient hearing aid detail link");
		patientsPage.clickPatientDetailsHearingAidDetaiLink("1");
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 08: Update patient hearing aid");
		patientsPage.updatePatientDetailsHearingAidPurchaseDate(updatePurchaseDate);
		
		log.info("patients_PatientDetails_Hearing_Aid_003 - Step 09: Click hearing aid save button");
		patientsPage.clickPatientDetailsEditHearingAidSaveButton();
		
		log.info("VP - Save successfully.");
		verifyTrue(patientsPage.isPatientDetailsHearingAidSaved());
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
	private String validPurchaseDate, updatePurchaseDate;
	private String validManufacturer;
	private String validType;
	private String validModel;
}
