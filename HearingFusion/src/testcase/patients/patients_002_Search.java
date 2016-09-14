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

public class patients_002_Search extends AbstractTest{
	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		
		invalidLastName="@ll3n";
		correctLastName="Baker";
		invalidFirstName="M@rk";
		correctFirstName="Mark";
		invalidAccount="5119888990";
		correctAccount="8889888994";
		correctOffice="Henderson Ear Aloha";
		correctPatientType="Prospect";
		invalidPhoneNumber="904-222-1001";
		correctPhoneNumber="310-454-5857";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Leave all fields blank")
	public void search_001_Help()
	{
		log.info("Search_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_001 - Step 02: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: All patient records are display");
		verifyTrue(patientsPage.getNumberOfItemInListOfPatients()>1);
	}
	@Test(groups = { "regression" },description = "Invalid patient last name")
	public void search_002_InvalidPatientLastName()
	{
		log.info("Search_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_002 - Step 02: Enter invalid patient last name");
		patientsPage.inputPatientRecordLastName(invalidLastName);
		
		log.info("Search_002 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Message 'No Patients found' displays");
		verifyTrue(patientsPage.isSearchMessageDisplays("No Patients found"));
	}
	@Test(groups = { "regression" },description = "Valid patient last name")
	public void search_003_ValidPatientLastName()
	{
		log.info("Search_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_003 - Step 02: Enter valid patient last name");
		patientsPage.inputPatientRecordLastName(correctLastName);
		
		log.info("Search_003 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has Last name");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientName(correctLastName));
	}
	@Test(groups = { "regression" },description = "Invalid patient first name")
	public void search_004_InvalidPatientFirstName()
	{
		log.info("Search_004 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_004 - Step 02: Enter invalid patient first name");
		patientsPage.inputPatientRecordFirstName(invalidFirstName);
		
		log.info("Search_004 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Message 'No Patients found' displays");
		verifyTrue(patientsPage.isSearchMessageDisplays("No Patients found"));
	}
	@Test(groups = { "regression" },description = "Valid patient first name")
	public void search_005_ValidPatientFirstName()
	{
		log.info("Search_005 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_005 - Step 02: Enter valid patient first name");
		patientsPage.inputPatientRecordFirstName(correctFirstName);
		
		log.info("Search_005 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has first name");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientName(correctFirstName));
	}
	@Test(groups = { "regression" },description = "Invalid patient account number")
	public void search_006_InvalidPatientAccountNumber()
	{
		log.info("Search_006 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_006 - Step 02: Enter invalid patient account number");
		patientsPage.inputPatientRecordAccountNumber(invalidAccount);
		
		log.info("Search_006 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Message 'No Patients found' displays");
		verifyTrue(patientsPage.isSearchMessageDisplays("No Patients found"));
	}
	@Test(groups = { "regression" },description = "Valid patient account number")
	public void search_007_ValidPatientAccountNumber()
	{
		log.info("Search_007 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_007 - Step 02: Enter valid patient account number");
		patientsPage.inputPatientRecordAccountNumber(correctAccount);
		
		log.info("Search_007 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has account number");
		verifyTrue(patientsPage.isListOfPatientsShowWithAccountNumber(correctAccount));
	}
	@Test(groups = { "regression" },description = "Valid patient default office")
	public void search_008_ValidPatientDefaultOffice()
	{
		log.info("Search_008 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_008 - Step 02: Select valid patient Office");
		patientsPage.selectPatientRecordDefaultOffice(correctOffice);
		
		log.info("Search_008 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has Default Office");
		verifyTrue(patientsPage.isListOfPatientsShowWithOffice(correctOffice));
	}
//	@Test(groups = { "regression" },description = "Valid patient current provider")
//	public void search_009_ValidPatientCurrentProvider()
//	{
//		log.info("Search_009 - Step 01: Go to Patients tab");
//		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
//		
//		log.info("Search_009 - Step 02: Select valid patient current provider");
//		patientsPage.selectPatientRecordCurrentProvider(correctProvider);
//		
//		log.info("Search_009 - Step 03: Click Search button");
//		patientsPage.clickPatientRecordSearchButton();
//		
//		log.info("Search_009 - Step 04: Click a patient detail link");
//		patientsPage.clickPatientRecordLink("1");
//		
//		log.info("VP: Show list of patients has Current Provider");
//		verifyTrue(patientsPage.isListOfPatientsShowWithOffice(correctOffice));
//	}
	@Test(groups = { "regression" },description = "Valid patient type")
	public void search_010_ValidPatientType()
	{
		log.info("Search_010 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_010 - Step 02: Select valid patient type");
		patientsPage.selectPatientRecordPatientType(correctPatientType);
		
		log.info("Search_010 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has Patient Type");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientType(correctPatientType));
	}
	@Test(groups = { "regression" },description = "Invalid patient phone number")
	public void search_011_InvalidPatientPhoneNumber()
	{
		log.info("Search_011 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_011 - Step 02: Enter invalid patient phone number");
		patientsPage.inputPatientRecordPhoneNumber(invalidPhoneNumber);
		
		log.info("Search_011 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Message 'No Patients found' displays");
		verifyTrue(patientsPage.isSearchMessageDisplays("No Patients found"));
	}
	@Test(groups = { "regression" },description = "Valid patient phone number")
	public void search_012_ValidPatientFirstName()
	{
		log.info("Search_012 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_012 - Step 02: Enter valid patient phone number");
		patientsPage.inputPatientRecordPhoneNumber(correctPhoneNumber);
		
		log.info("Search_012 - Step 03: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has phone number");
		verifyTrue(patientsPage.isListOfPatientsShowWithPhoneNumber(correctPhoneNumber));
	}
	@Test(groups = { "regression" },description = "Invalid all values")
	public void search_013_InvalidAllValues()
	{
		log.info("Search_013 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_013 - Step 02: Enter invalid patient Last Name");
		patientsPage.inputPatientRecordLastName(invalidLastName);
		
		log.info("Search_013 - Step 03: Enter invalid patient First Name");
		patientsPage.inputPatientRecordFirstName(invalidFirstName);
		
		log.info("Search_013 - Step 04: Enter invalid patient Account Number");
		patientsPage.inputPatientRecordAccountNumber(invalidAccount);
		
		log.info("Search_013 - Step 05: Enter invalid patient Phone Number");
		patientsPage.inputPatientRecordPhoneNumber(invalidPhoneNumber);
		
		log.info("Search_013 - Step 06: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Message 'No Patients found' displays");
		verifyTrue(patientsPage.isSearchMessageDisplays("No Patients found"));
	}
	@Test(groups = { "regression" },description = "Valid all values")
	public void search_014_ValidAllValues()
	{
		log.info("Search_014 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_014 - Step 02: Enter valid patient Last Name");
		patientsPage.inputPatientRecordLastName(correctLastName);
		
		log.info("Search_014 - Step 03: Enter valid patient First Name");
		patientsPage.inputPatientRecordFirstName(correctFirstName);
		
		log.info("Search_014 - Step 04: Enter valid patient Account Number");
		patientsPage.inputPatientRecordAccountNumber(correctAccount);
		
		log.info("Search_014 - Step 05: Enter valid patient Phone Number");
		patientsPage.inputPatientRecordPhoneNumber(correctPhoneNumber);
		
		log.info("Search_014 - Step 06: Select valid Patient Type");
		patientsPage.selectPatientRecordPatientType(correctPatientType);
		
		log.info("Search_014 - Step 07: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("VP: Show list of patients has Last Name");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientName(correctLastName));
		
		log.info("VP: Show list of patients has First Name");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientName(correctFirstName));
		
		log.info("VP: Show list of patients has Account Number");
		verifyTrue(patientsPage.isListOfPatientsShowWithAccountNumber(correctAccount));
		
		log.info("VP: Show list of patients has Phone Number");
		verifyTrue(patientsPage.isListOfPatientsShowWithPhoneNumber(correctPhoneNumber));
		
		log.info("VP: Show list of patients has Patient Type");
		verifyTrue(patientsPage.isListOfPatientsShowWithPatientType(correctPatientType));
	}
	@Test(groups = { "regression" },description = "Open Patient record")
	public void search_015_OpenPatientRecord()
	{
		log.info("Search_015 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Search_015 - Step 02: Enter valid patient Last Name");
		patientsPage.inputPatientRecordLastName(correctLastName);
		
		log.info("Search_015 - Step 03: Enter valid patient First Name");
		patientsPage.inputPatientRecordFirstName(correctFirstName);
		
		log.info("Search_015 - Step 04: Enter valid patient Account Number");
		patientsPage.inputPatientRecordAccountNumber(correctAccount);
		
		log.info("Search_015 - Step 05: Enter valid patient Phone Number");
		patientsPage.inputPatientRecordPhoneNumber(correctPhoneNumber);
		
		log.info("Search_015 - Step 06: Select valid Patient Type");
		patientsPage.selectPatientRecordPatientType(correctPatientType);
		
		log.info("Search_015 - Step 07: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("Search_015 - Step 08: Click a patient detail link");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("VP: Patient displays correctly");
		verifyTrue(patientsPage.isPatientDetailLastNameDisplaysWithText(correctLastName));
		verifyTrue(patientsPage.isPatientDetailFirstNameDisplaysWithText(correctFirstName));
		verifyTrue(patientsPage.isPatientDetailAccountNumberDisplaysWithText(correctAccount));
		verifyTrue(patientsPage.isPatientDetailHomePhoneDisplaysWithText(correctPhoneNumber));
		verifyTrue(patientsPage.isPatientDetailPatientTypeDisplaysWithText(correctPatientType));
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
	private String invalidLastName, invalidFirstName, invalidAccount, invalidPhoneNumber;
	private String correctLastName, correctFirstName, correctAccount, correctPhoneNumber,correctOffice,correctPatientType;
}
