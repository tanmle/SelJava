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

public class patients_012_PatientDetails_CBOBilling_Validation extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaAdminUsername = Constant.QA_ADMIN_USERNAME;
		password = Constant.PASSWORD;
		
		validPatientLastName="Udi"+getUniqueNumber();
		validHomePhone="310-454-5857";
		validZIP="90024";
		validPatientType="Competitive";
		validPatientFirstName="QATeam";
		
		invalidMobilePhone="abc@acb";
		invalidWorkPhone="abc@acb";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaAdminUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with invalid Mobile phone")
	public void patients_PatientDetails_CBOBilling_Validation_001_SaveWithInvalidMobilePhone()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 15: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 16: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 17: Input invalid Mobile Phone");
		patientsPage.inputPatientDetailsCBOMobilePhone(invalidMobilePhone);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_001 - Step 18: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Mobile Phone displays");
		verifyTrue(patientsPage.isPatientDetailsCBOMobilePhoneErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with invalid Work phone")
	public void patients_PatientDetails_CBOBilling_Validation_002_SaveWithInvalidWorkPhone()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 08: Input invalid Work Phone");
		patientsPage.inputPatientDetailsCBOWorkPhone(invalidWorkPhone);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_002 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Work Phone displays");
		verifyTrue(patientsPage.isPatientDetailsCBOWorkPhoneErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 1 missing local path")
	public void patients_PatientDetails_CBOBilling_Validation_003_SaveWithEmail1MissingLocalPath()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 08: Input Email 1 missing local path");
		patientsPage.inputPatientDetailsCBOEmail1("@Testing.com");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_003 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 1 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 1 missing domain email")
	public void patients_PatientDetails_CBOBilling_Validation_004_SaveWithEmail1MissingDomainEmail()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 08: Input Email 1 misisng domain email");
		patientsPage.inputPatientDetailsCBOEmail1("UdiQATeam@.com");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_004 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 1 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 1 missing extend domain email")
	public void patients_PatientDetails_CBOBilling_Validation_005_SaveWithEmail1MissingExtendDomainEmail()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 08: Input Email 1 misising extend domain email");
		patientsPage.inputPatientDetailsCBOEmail1("UdiQATeam@Testing");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_005 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 1 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 1 missing @")
	public void patients_PatientDetails_CBOBilling_Validation_006_SaveWithEmail1MissingAt()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 08: Input Email 1 misising @");
		patientsPage.inputPatientDetailsCBOEmail1("UdiQATeamTesting.com");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_006 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 1 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 2 missing local path")
	public void patients_PatientDetails_CBOBilling_Validation_007_SaveWithEmail2MissingLocalPath()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 08: Input Email 2 missing local path");
		patientsPage.inputPatientDetailsCBOEmail2("@Testing.com");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_007 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 2 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail2ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 2 missing domain email")
	public void patients_PatientDetails_CBOBilling_Validation_008_SaveWithEmail2MissingDomainEmail()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 08: Input Email 2 misisng domain email");
		patientsPage.inputPatientDetailsCBOEmail2("UdiQATeam@.com");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_008 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 2 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail2ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 2 missing extend domain email")
	public void patients_PatientDetails_CBOBilling_Validation_009_SaveWithEmail2MissingExtendDomainEmail()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 08: Input Email 2 misising extend domain email");
		patientsPage.inputPatientDetailsCBOEmail2("UdiQATeam@Testing");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_009 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 2 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail2ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save with email 2 missing @")
	public void patients_PatientDetails_CBOBilling_Validation_010_SaveWithEmail2MissingAt()
	{
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 02: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 03: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 04: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 05: Open a patient");
		patientsPage.clickPatientRecordLink("1");
	
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 06: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 07: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 08: Input Email 2 misising @");
		patientsPage.inputPatientDetailsCBOEmail2("UdiQATeamTesting.com");
		
		log.info("patients_PatientDetails_CBOBilling_Validation_010 - Step 09: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Error message for Email 2 displays");
		verifyTrue(patientsPage.isPatientDetailsCBOEmail2ErrorDisplays());
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
	private String organization, qaAdminUsername, password;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	private String invalidMobilePhone, invalidWorkPhone;
}
