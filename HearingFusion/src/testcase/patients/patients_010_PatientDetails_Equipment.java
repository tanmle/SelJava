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
import common.Common;
import common.Constant;

public class patients_010_PatientDetails_Equipment extends AbstractTest{
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
		
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		description = getUniqueName();
		remark = getUniqueName();
		serial = getUniqueNumber();
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Add New Record_Leave All Fields blank")
	public void patients_PatientDetails_Equipment_001_AddNewRecord_LeaveAllFieldsBlank()
	{
		log.info("patients_PatientDetails_Equipment_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("patients_PatientDetails_Equipment_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patients_PatientDetails_Equipment_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patients_PatientDetails_Equipment_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patients_PatientDetails_Equipment_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Equipment_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Equipment_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Equipment_001 - Step 15: Expand equipment");
		patientsPage.expandPatientDetailsEquipment();
		
		log.info("patients_PatientDetails_Equipment_001 - Step 16: Click equipment New - Add Gadget link");
		patientsPage.selectAddItemEquimentButton("Add Gadget");
		
		log.info("patients_PatientDetails_Equipment_001 - Step 17: Click equipment save button");
		patientsPage.clickPatientDetailsEquipmentSaveButton();
		
		log.info("VP - An error message will be displayed under the require field 'Part': Part is required");
		verifyTrue(patientsPage.isErrorMessageEquipmentGadgetRequireDisplay());
		
	}
	@Test(groups = { "regression" },description = "Add new Gadget: Input data into all fields")
	public void patients_PatientDetails_Equipment_002_EquipmentInputDataIntoAllFields()
	{
		log.info("patients_PatientDetails_Equipment_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Equipment_002 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Equipment_002 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Equipment_002 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Equipment_002 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Equipment_002 - Step 06: Expand equipment");
		patientsPage.expandPatientDetailsEquipment();
		
		log.info("patients_PatientDetails_Equipment_002 - Step 07: Click equipment New - Add Gadget link");
		patientsPage.selectAddItemEquimentButton("Add Gadget");
		
		log.info("patients_PatientDetails_Equipment_002 - Step 08: Select status");
		patientsPage.selectHearingAidAddGadgetStatus("Current");
		
		log.info("patients_PatientDetails_Equipment_002 - Step 09: Input Purcharse Date");
		patientsPage.inputHearingAidsAddGadgetPurcharseDate(month,date,year);
		
		log.info("patients_PatientDetails_Equipment_002 - Step 10: Select Manufacturer");
		patientsPage.selectHearingAidsAddGadgetManufacturer("Oticon Hearing");
		
		log.info("patients_PatientDetails_Equipment_002 - Step 11: Select Type");
		patientsPage.selectHearingAidsAddGadgetType("Streamers");
		
		log.info("patients_PatientDetails_Equipment_002 - Step 12: Select Part");
		patientsPage.selectHearingAidsAddGadgetPart("Wireless Streamer (Streamers)");
		
		log.info("patients_PatientDetails_Equipment_002 - Step 13: Input Description");
		patientsPage.inputHearingAidsAddGadgetDescription(description);
		
		log.info("patients_PatientDetails_Equipment_002 - Step 14: Input Type Serial");
		patientsPage.inputHearingAidsAddGadgetTypeSerial(serial);
		
		log.info("patients_PatientDetails_Equipment_002 - Step 15: Click Save Equipment Gadget");
		patientsPage.clickPatientDetailsEquipmentSaveButton();
		
		log.info("VP - New serial number(s) have been added to patient's profile");
		verifyTrue(patientsPage.isHearingAidsSaveSuccessfully());
	
	}
	@Test(groups = { "regression" },description = "Add new Gadget: Edit Patients Equipment")
	public void patients_PatientDetails_Equipment_003_EquipmentEditPatientsEquipment()
	{
		log.info("patients_PatientDetails_Equipment_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Equipment_003 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Equipment_003 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Equipment_003 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Equipment_003 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Equipment_003 - Step 06: Expand equipment");
		patientsPage.expandPatientDetailsEquipment();
		
		log.info("patients_PatientDetails_Equipment_003 - Step 06: Click on an equipment");
		patientsPage.openDetailAnEquipment(serial);
		
		log.info("patients_PatientDetails_Equipment_003 - Step 07: Edit Remark ");
		patientsPage.inputHearingAidsAddGadgetRemark(remark);
		
		log.info("patients_PatientDetails_Equipment_003 - Step 08: Click Save Edit Equipment Gadget");
		patientsPage.clickSaveEditEquipmentGadget();
		
		log.info("VP - Save successfully.");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
	}
	
	@Test(groups = { "regression" },description = "Add new Ear Mold: Input data into all fieds")
	public void patients_PatientDetails_Equipment_004_EquipmentEarMoldInputDataIntoAllFields()
	{
		log.info("patients_PatientDetails_Equipment_004 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Equipment_004 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Equipment_004 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Equipment_004 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Equipment_004 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Equipment_004 - Step 06: Expand equipment");
		patientsPage.expandPatientDetailsEquipment();
		
		log.info("patients_PatientDetails_Equipment_004 - Step 07: Add new Equipment Ear Mold");
		patientsPage.selectAddItemEquimentButton("Add Ear Mold");
		
		log.info("patients_PatientDetails_Equipment_004 - Step 08: Input left purchase date");
		patientsPage.inputEarmoldLeftPurchaseDate(month,date,year);
		
		log.info("patients_PatientDetails_Equipment_004 - Step 09: Select left Manufacturer");
		patientsPage.selectEarmoldLeftManufacturer("Oticon Hearing");
		
		log.info("patients_PatientDetails_Equipment_004 - Step 10: Select left Model");
		patientsPage.selectEarmoldLeftModel("New Custom Mold (Hearing Aid Mold)");
		
		log.info("patients_PatientDetails_Equipment_004 - Step 11: Input letf Description");
		patientsPage.inputEarmoldLeftDescription(description);
		
		log.info("patients_PatientDetails_Equipment_004 - Step 12: Select right Manufacturer");
		patientsPage.selectEarmoldRightManufacturer("Oticon Hearing");
		
		log.info("patients_PatientDetails_Equipment_004 - Step 13: Select right Model");
		patientsPage.selectEarmoldRightModel("Hearing Aid Earmold (Hearing Aid Mold)");
		
		log.info("patients_PatientDetails_Equipment_004 - Step 14: Input right Description");
		patientsPage.inputEarmoldRightDescription(remark);
		
		log.info("patients_PatientDetails_Equipment_004 - Step 15: Click Save button");
		patientsPage.clickSaveEquipmentEarmold();
		
		log.info("VP: Save successfully.");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
	}
	
	@Test(groups = { "regression" },description = "Add new Ear Mold: Input data into all fieds - Save & Return ")
	public void patients_PatientDetails_Equipment_005_EquipmentEarMoldInputDataIntoAllFieldsSaveReturn()
	{
		log.info("patients_PatientDetails_Equipment_005 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Equipment_005 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Equipment_005 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Equipment_005 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Equipment_005 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Equipment_005 - Step 06: Expand equipment");
		patientsPage.expandPatientDetailsEquipment();
		
		log.info("patients_PatientDetails_Equipment_005 - Step 07: Add new Equipment Ear Mold");
		patientsPage.selectAddItemEquimentButton("Add Ear Mold");
		
		log.info("patients_PatientDetails_Equipment_005 - Step 08: Input left purchase date");
		patientsPage.inputEarmoldLeftPurchaseDate(month,date,year);
		
		log.info("patients_PatientDetails_Equipment_005 - Step 09: Select left Manufacturer");
		patientsPage.selectEarmoldLeftManufacturer("Oticon Hearing");
		
		log.info("patients_PatientDetails_Equipment_005 - Step 10: Select left Model");
		patientsPage.selectEarmoldLeftModel("New Custom Mold (Hearing Aid Mold)");
		
		log.info("patients_PatientDetails_Equipment_005 - Step 11: Input letf Description");
		patientsPage.inputEarmoldLeftDescription(description);
		
		log.info("patients_PatientDetails_Equipment_005 - Step 12: Select right Manufacturer");
		patientsPage.selectEarmoldRightManufacturer("Oticon Hearing");
		
		log.info("patients_PatientDetails_Equipment_005 - Step 13: Select right Model");
		patientsPage.selectEarmoldRightModel("Hearing Aid Earmold (Hearing Aid Mold)");
		
		log.info("patients_PatientDetails_Equipment_005 - Step 14: Input right Description");
		patientsPage.inputEarmoldRightDescription(remark);
		
		log.info("patients_PatientDetails_Equipment_005 - Step 15: Click Save & Return to Patient");
		patientsPage.clickSaveReturnEquipmentEarmold();
		
		log.info("VP:  Save & Return to Patient screen successfully.");
		verifyTrue(patientsPage.isPatientDetailsPageDisplays());
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
	private int date, month, year;
	private String serial,description;
	private String remark;
}
