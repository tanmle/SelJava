package patients;
import java.io.IOException;
import java.util.Random;

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

public class patients_003_NewPatient extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		int random = new Random().nextInt(1000)+1;
		
		invalidHomePhone="111-111-1111";
		invalidSSN="A@b&3";
		invalidZIP="A@b&3";
		missingLocalPartEmail1="@Testing.com";
		missingDomainNameEmail1="UdiQATeam@.com";
		missingExtendDomainEmail1="UdiQATeam@Testing";
		missingAtInEmail1="UdiQATeamTesting.com";
		missingLocalPartEmail2="@Testing1.com";
		missingDomainNameEmail2="UdiQATeam1@.com";
		missingExtendDomainEmail2="UdiQATeam1@Testing";
		missingAtInEmail2="UdiQATeamTesting1.com";
		invalidMobilePhone="A@b&3";
		invalidWorkPhone="A@b&3";
		invalidGuardianPhone="A@b&3";
		invalidGuardianZIP="A@b&3";
		validPatientLastName="Udi"+getUniqueNumber();
		validSSN="409-52-"+random;
		validHomePhone="310-454-5857";
		validZIP="90024";
		validPatientFirstName="QATeam";
		validEmail1="UdiQATeam@testing.com";
		validEmail2="UdiQATeam1@testing.com";
		validMobilePhone="518-777-7777";
		validWorkPhone="518-777-7777";
		validGuardianPhone="518-777-7777";
		validGuardianZIP="90024";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Leave all fields blank")
	public void newPatient_001_LeaveAllFieldsBlank()
	{
		log.info("newPatient_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("newPatient_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_001 - Step 03: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("VP: Message 'Please correct the errors and try again.' displays");
		verifyTrue(patientsPage.isNewPatientErrorMessageDisplaysWithCotent("Please correct the errors and try again."));
	}
	@Test(groups = { "regression" },description = "Input invalid Home Phone")
	public void newPatient_002_InputInvalidHomePage()
	{
		log.info("newPatient_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("newPatient_002 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_002 - Step 03: Input invalid Home Phone");
		patientsPage.inputNewPatientHomePhone(invalidHomePhone);
		
		log.info("newPatient_002 - Step 04: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("VP: Home Phone error message displays");
		verifyTrue(patientsPage.isNewPatientHomePhoneErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Input invalid ZIP")
	public void newPatient_003_InputInvalidZIP()
	{
		log.info("newPatient_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_003 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_003 - Step 03: Input invalid ZIP");
		patientsPage.inputNewPatientZIP(invalidZIP);
		
		log.info("newPatient_003 - Step 04: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("VP: ZIP error message displays");
		verifyTrue(patientsPage.isNewPatientZIPErrorDisplays());
	}
//	@Test(groups = { "regression" },description = "Input invalid SSN")
//	public void newPatient_004_InputInvalidSSN()
//	{
//		log.info("newPatient_004 - Step 01: Go to Patients tab");
//		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
//
//		log.info("newPatient_004 - Step 02: Click New button");
//		patientsPage.clickNewPatientButton();
//		
//		log.info("newPatient_004 - Step 03: Input invalid SSN");
//		patientsPage.inputNewPatientSSN(invalidSSN);
//		
//		log.info("newPatient_004 - Step 04: Click Next button");
//		patientsPage.clickNewPatientNextToStep2Button();
//		
//		log.info("VP: SSN error message displays");
//		log.error("Bug: HF25");
//		verifyTrue(patientsPage.isNewPatientSSNErrorDisplays());
//	}
	@Test(groups = { "regression" },description = "Input all valid data")
	public void newPatient_005_InputAllValidData()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		log.info("newPatient_005 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_005 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_005 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_005 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_005 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("newPatient_005 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("VP: Patient detals page displays");
		verifyTrue(patientsPage.isPatientDetailPageDisplays());
	}
	@Test(groups = { "regression" },description = "Leave first name blank")
	public void newPatient_006_LeaveFirstNameBlank()
	{
		log.info("newPatient_006 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_006 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_006 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_006 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_006 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("newPatient_006 - Step 06: Input valid SSN");
		patientsPage.inputNewPatientSSN(validSSN);
		
		log.info("newPatient_006 - Step 07: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_006 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Patient First Name is required' displays");
		verifyTrue(patientsPage.isPatientDetailFirstNameErrorDisplaysWithText());
	}
	@Test(groups = { "regression" },description = "Save with valid first name")
	public void newPatient_007_SaveWithValidFirstName()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_007 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_007 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_007 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_007 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_007 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("newPatient_007 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_007 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_007 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Save with valid SSN")
	public void newPatient_008_SaveWithValidSSN()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_008 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_008 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_008 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_008 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_008 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_008 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_008 - Step 07: Input valid SSN");
		patientsPage.inputPatientDetailSSN(validSSN);
		
		log.info("newPatient_008 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Missing localpart Email 1")
	public void newPatient_009_MissingLocalPartEmail1()
	{
		validPatientLastName="Udi"+getUniqueNumber();
	
		log.info("newPatient_009 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_009 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_009 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_009 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_009 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_009 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_009 - Step 07: Input missing local part email1");
		patientsPage.inputPatientDetailEmail1(missingLocalPartEmail1);
		
		log.info("newPatient_009 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Missing domain name Email 1")
	public void newPatient_010_MissingDomainNameEmail1()
	{
		validPatientLastName="Udi"+getUniqueNumber();
	
		log.info("newPatient_010 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_010 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_010 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_010 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_010 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_010 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_010 - Step 07: Input missing domain main email1");
		patientsPage.inputPatientDetailEmail1(missingDomainNameEmail1);
		
		log.info("newPatient_010 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Missing extend domain Email 1")
	public void newPatient_011_MissingExtendEmail1()
	{
		validPatientLastName="Udi"+getUniqueNumber();
	
		log.info("newPatient_011 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_011 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_011 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_011 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_011 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_011 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_011 - Step 07: Input missing extend domain email1");
		patientsPage.inputPatientDetailEmail1(missingExtendDomainEmail1);
		
		log.info("newPatient_011 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Misisng @ in Email 1")
	public void newPatient_012_MissingAtInEmail1()
	{
		validPatientLastName="Udi"+getUniqueNumber();
	
		log.info("newPatient_012 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_012 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_012 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_012 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_012 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_012 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_012 - Step 07: Input missing @ in email1");
		patientsPage.inputPatientDetailEmail1(missingAtInEmail1);
		
		log.info("newPatient_012 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail1ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Save with valid Email1")
	public void newPatient_013_SaveWithValidEmail1()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_013 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_013 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_013 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_013 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_013 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_013 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_013 - Step 07: Input valid Email1");
		patientsPage.inputPatientDetailEmail1(validEmail1);
		
		log.info("newPatient_013 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Missing localpart Email 2")
	public void newPatient_014_MissingLocalPartEmail2()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_014 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_014 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_014 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_014 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_014 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_014 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_014 - Step 07: Input missing local part email2");
		patientsPage.inputPatientDetailEmail2(missingLocalPartEmail2);
		
		log.info("newPatient_014 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail2ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Missing domain name Email 2")
	public void newPatient_015_MissingDomainNameEmail2()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_015 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_015 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_015 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_015 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_015 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_015 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_015 - Step 07: Input missing domain main email2");
		patientsPage.inputPatientDetailEmail2(missingDomainNameEmail2);
		
		log.info("newPatient_015 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail2ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Missing extend domain Email 2")
	public void newPatient_016_MissingExtendEmail2()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_016 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_016 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_016 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_016 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_016 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_016 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_016 - Step 07: Input missing extend domain email2");
		patientsPage.inputPatientDetailEmail2(missingExtendDomainEmail2);
		
		log.info("newPatient_016 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail2ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Misisng @ in Email 2")
	public void newPatient_017_MissingAtInEmail2()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_017 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_017 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_017 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_017 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_017 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_017 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_017 - Step 07: Input missing @ in email2");
		patientsPage.inputPatientDetailEmail2(missingAtInEmail2);
		
		log.info("newPatient_017 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailEmail2ErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Save with valid Email2")
	public void newPatient_018_SaveWithValidEmail2()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_018 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_018 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_018 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_018 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_018 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_018 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_018 - Step 07: Input valid Email2");
		patientsPage.inputPatientDetailEmail2(validEmail2);
		
		log.info("newPatient_018 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Input invalid mobile phone")
	public void newPatient_019_InputInvalidMobilePhone()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_019 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_019 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_019 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_019 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_019 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_019 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_019 - Step 07: Input invalid mobile phone");
		patientsPage.inputPatientDetailMobilePhone(invalidMobilePhone);
		
		log.info("newPatient_019 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailMobilePhoneErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Save with valid Mobile Phone")
	public void newPatient_020_SaveWithValidMobilePhone()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_020 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_020 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_020 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_020 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_020 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_020 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_020 - Step 07: Input valid mobile phone");
		patientsPage.inputPatientDetailMobilePhone(validMobilePhone);
		
		log.info("newPatient_020 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Input invalid work phone")
	public void newPatient_021_InputInvalidWorkPhone()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_021 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_021 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_021 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_021 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_021 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_021 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_021 - Step 07: Input invalid work phone");
		patientsPage.inputPatientDetailWorkPhone(invalidWorkPhone);
		
		log.info("newPatient_021 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailWorkPhoneErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Save with valid Work Phone")
	public void newPatient_022_SaveWithValidWorkPhone()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_022 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_022 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_022 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_022 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_022 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_022 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_022 - Step 07: Input valid work phone");
		patientsPage.inputPatientDetailWorkPhone(validWorkPhone);
		
		log.info("newPatient_022 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Input invalid guardian phone")
	public void newPatient_023_InputInvalidGuardianPhone()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_023 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_023 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_023 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_023 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_023 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_023 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_023 - Step 07: Input invalid guardian phone");
		patientsPage.inputPatientDetailGuardianPhone(invalidGuardianPhone);
		
		log.info("newPatient_023 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailGuardianPhoneErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Save with valid Guardian Phone")
	public void newPatient_024_SaveWithValidGuardianPhone()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_024 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_024 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_024 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_024 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_024 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_024 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_024 - Step 07: Input valid guardian phone");
		patientsPage.inputPatientDetailGuardianPhone(validGuardianPhone);
		
		log.info("newPatient_024 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Input invalid guardian zip")
	public void newPatient_025_InputInvalidGuardianZIP()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_025 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_025 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_025 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_025 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_025 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_025 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_025 - Step 07: Input invalid guardian zip");
		patientsPage.inputPatientDetailGuardianZIP(invalidGuardianZIP);
		
		log.info("newPatient_025 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Warning message displays and cannot save patient");
		verifyTrue(patientsPage.isPatientDetailGuardianZIPErrorDisplays());
	}
	@Test(groups = { "regression" },description = "Save with valid Guardian ZIP")
	public void newPatient_026_SaveWithValidGuardianZIP()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_026 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_026 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_026 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_026 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_026 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_026 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_026 - Step 07: Input valid guardian zip");
		patientsPage.inputPatientDetailGuardianZIP(validGuardianZIP);
		
		log.info("newPatient_026 - Step 08: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("VP: Message 'Record saved' displays and save new patient successfully");
		verifyTrue(patientsPage.isPatientDetailRecordSaved());
	}
	@Test(groups = { "regression" },description = "Search Added Patient")
	public void newPatient_027_SearchAddedPatient()
	{
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("newPatient_027 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);

		log.info("newPatient_027 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("newPatient_027 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("newPatient_027 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("newPatient_027 - Step 05: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("newPatient_027 - Step 06: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("newPatient_027 - Step 07: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("newPatient_027 - Step 08: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("newPatient_027 - Step 09: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("newPatient_027 - Step 10: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("newPatient_027 - Step 11: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("newPatient_027 - Step 12: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("VP: Patient displays with valid last name");
		verifyTrue(patientsPage.isPatientDetailLastNameDisplaysWithText(validPatientLastName));
		
		log.info("VP: Patient displays with valid first name");
		verifyTrue(patientsPage.isPatientDetailFirstNameDisplaysWithText(validPatientFirstName));
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
	private String invalidHomePhone, invalidSSN, invalidZIP, missingLocalPartEmail1,missingDomainNameEmail1,missingExtendDomainEmail1,
	missingAtInEmail1,missingLocalPartEmail2,missingDomainNameEmail2,missingExtendDomainEmail2,
	missingAtInEmail2,invalidMobilePhone,invalidWorkPhone,invalidGuardianPhone,invalidGuardianZIP;
	private String validPatientLastName,validHomePhone,validZIP,validSSN,validPatientFirstName,
	validEmail1,validEmail2,validMobilePhone,validWorkPhone,validGuardianPhone,validGuardianZIP;
}
