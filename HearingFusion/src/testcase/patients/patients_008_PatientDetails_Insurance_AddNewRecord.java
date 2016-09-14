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

public class patients_008_PatientDetails_Insurance_AddNewRecord extends AbstractTest{

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
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Add New Record_Leaving the require field Position (1,2,3)")
	public void patients_PatientDetails_Insurance_AddNewRecord_001_AddNewRecord_LeavingPositionBlank()
	{
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 15: Expand patient insurance");
		patientsPage.expandPatientDetailsInsurance();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 16: Click New link");
		patientsPage.clickPatientDetailsInsuranceNewLink();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 17: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 18: Input Name");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchName("Aetna");
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 19: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 20: Select Carrier");
		patientsPage.selectCarrierByName("Aetna");
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 21: Click select Plan Type"); 
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.selectPatientInsuracePlanType("PPO");
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_001 - Step 22: Click Save");
		patientsPage.clickSavePatientInsurace();
		
		log.info("VP - Cannot save and the website shows an error message 'Position (1,2,3) is required.'");
		verifyTrue(patientsPage.isCannotSavePaitentInsurace());
		verifyTrue(patientsPage.isMessageWarningPositionRequiredDisplays());
		
	}
	@Test(groups = { "regression" },description = "Add New Record_Input Correct Values To All Fields")
	public void patients_PatientDetails_Insurance_AddNewRecord_002_AddNewRecord_InputCorrectValuesToAllFields()
	{
		log.info("patients_PatientDetails_Insurance_AddNewRecord_002 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_002 - Step 02: Input correct Name");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchName("Aetna");
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_002 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_002 - Step 04: Select Carrier");
		patientsPage.selectCarrierByName("Aetna");
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_002 - Step 05: Click select Plan Type"); 
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.selectPatientInsuracePlanType("PPO");
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_002 - Step 06: Click select Position"); 
		patientsPage.selectPatientInsuracePosition("3");	
		
		log.info("patients_PatientDetails_Insurance_AddNewRecord_002 - Step 07: Click Save");
		patientsPage.clickSavePatientInsurace();
		
		log.info("VP - Save successfully.");
		verifyTrue(patientsPage.isSavePaitentInsuraceSuccess());
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
}
