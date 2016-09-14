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

public class patients_006_PatientDetails_Insurance_Search extends AbstractTest{
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
		
		incorrectName="abced";
		incorrectContractDate="11/11/2111";
		incorrectCity="abcd@@";
		incorrectState="GU - Guam";
		incorrectZip="99999";
		incorrectPhone="723-234-1234";
		incorrectFax="723-234-1235";
		invalidZip="abcd";
		correctName="Aetna";
		correctContractDate="1/1/2012";
		correctCity="Los Angeles";
		correctState="CA - California";
		correctZip="90024";
		correctPhone="800-989-5600";
		correctFax="800-100-1001";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Find Carrier_Leave all fields blank")
	public void patientDetails_Insurance_Search_001_FindCarrier_LeaveAllFieldsBlank()
	{
		log.info("patientDetails_Insurance_Search_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("patientDetails_Insurance_Search_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patientDetails_Insurance_Search_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patientDetails_Insurance_Search_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patientDetails_Insurance_Search_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patientDetails_Insurance_Search_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patientDetails_Insurance_Search_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patientDetails_Insurance_Search_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patientDetails_Insurance_Search_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patientDetails_Insurance_Search_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_Insurance_Search_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_Insurance_Search_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_Insurance_Search_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_Insurance_Search_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_Insurance_Search_001 - Step 15: Expand patient insurance");
		patientsPage.expandPatientDetailsInsurance();
		
		log.info("patientDetails_Insurance_Search_001 - Step 16: Click New link");
		patientsPage.clickPatientDetailsInsuranceNewLink();
		
		log.info("patientDetails_Insurance_Search_001 - Step 17: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_001 - Step 18: Click Carrier Search button");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers");
		verifyTrue(patientsPage.getNumberOfItemInListOfCarriers()>1);
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
		
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect Name")
	public void patientDetails_Insurance_Search_002_FindCarrier_IncorrectName()
	{
		log.info("patientDetails_Insurance_Search_002 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_002 - Step 02: Input incorrect Name");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchName(incorrectName);
		
		log.info("patientDetails_Insurance_Search_002 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with correct Name")
	public void patientDetails_Insurance_Search_003_FindCarrier_CorrectName()
	{
		log.info("patientDetails_Insurance_Search_003 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_003 - Step 02: Input correct Name");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchName(correctName);
		
		log.info("patientDetails_Insurance_Search_003 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Name");
		verifyTrue(patientsPage.isListOfCarriersShowWithName(correctName));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect Contract Date")
	public void patientDetails_Insurance_Search_004_FindCarrier_IncorrectContractDate()
	{
		log.info("patientDetails_Insurance_Search_004 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_004 - Step 02: Input incorrect Contract Date");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchContractDate(incorrectContractDate);
		
		log.info("patientDetails_Insurance_Search_004 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with correct Contract Date")
	public void patientDetails_Insurance_Search_005_FindCarrier_CorrectContractDate()
	{
		log.info("patientDetails_Insurance_Search_005 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_005 - Step 02: Input correct Contract Date");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchContractDate(correctContractDate);
		
		log.info("patientDetails_Insurance_Search_005 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Contract Date");
		verifyTrue(patientsPage.isListOfCarriersShowWithContractDate(correctContractDate));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect City")
	public void patientDetails_Insurance_Search_006_FindCarrier_IncorrectCity()
	{
		log.info("patientDetails_Insurance_Search_006 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_006 - Step 02: Input incorrect City");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchCity(incorrectCity);
		
		log.info("patientDetails_Insurance_Search_006 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with correct City")
	public void patientDetails_Insurance_Search_007_FindCarrier_CorrectCity()
	{
		log.info("patientDetails_Insurance_Search_007 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_007 - Step 02: Input correct City");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchCity(correctCity);
		
		log.info("patientDetails_Insurance_Search_007 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have City");
		verifyTrue(patientsPage.isListOfCarriersShowWithCity(correctCity));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect State")
	public void patientDetails_Insurance_Search_008_FindCarrier_IncorrectState()
	{
		log.info("patientDetails_Insurance_Search_008 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_008 - Step 02: Input incorrect State");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.selectCarrierSearchState(incorrectState);
		
		log.info("patientDetails_Insurance_Search_008 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with correct State")
	public void patientDetails_Insurance_Search_009_FindCarrier_CorrectState()
	{
		log.info("patientDetails_Insurance_Search_009 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_009 - Step 02: Input correct State");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.selectCarrierSearchState(correctState);
		
		log.info("patientDetails_Insurance_Search_009 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have State");
		verifyTrue(patientsPage.isListOfCarriersShowWithState(correctState));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect Zip")
	public void patientDetails_Insurance_Search_010_FindCarrier_IncorrectZip()
	{
		log.info("patientDetails_Insurance_Search_010 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_010 - Step 02: Input incorrect Zip");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchZip(incorrectZip);
		
		log.info("patientDetails_Insurance_Search_010 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with correct Zip")
	public void patientDetails_Insurance_Search_011_FindCarrier_CorrectZip()
	{
		log.info("patientDetails_Insurance_Search_011 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_011 - Step 02: Input correct Zip");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchZip(correctZip);
		
		log.info("patientDetails_Insurance_Search_011 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Zip");
		verifyTrue(patientsPage.isListOfCarriersShowWithZip(correctZip));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with invalid Zip")
	public void patientDetails_Insurance_Search_012_FindCarrier_InvalidZip()
	{
		log.info("patientDetails_Insurance_Search_012 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_012 - Step 02: Input invalid Zip");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchZip(invalidZip);
		
		log.info("patientDetails_Insurance_Search_012 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Message 'Enter a valid ZIP or ZIP+4 code' displays");
		verifyTrue(patientsPage.isCarrierSearchZipErrorDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect Phone")
	public void patientDetails_Insurance_Search_013_FindCarrier_IncorrectPhone()
	{
		log.info("patientDetails_Insurance_Search_013 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_013 - Step 02: Input incorrect Phone");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchPhone(incorrectPhone);
		
		log.info("patientDetails_Insurance_Search_013 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with correct Phone")
	public void patientDetails_Insurance_Search_014_FindCarrier_CorrectPhone()
	{
		log.info("patientDetails_Insurance_Search_014 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_014 - Step 02: Input correct Zip");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchPhone(correctPhone);
		
		log.info("patientDetails_Insurance_Search_014 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Phone");
		verifyTrue(patientsPage.isListOfCarriersShowWithPhone(correctPhone));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect Fax")
	public void patientDetails_Insurance_Search_015_FindCarrier_IncorrectFax()
	{
		log.info("patientDetails_Insurance_Search_015 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_015 - Step 02: Input incorrect Fax");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchFax(incorrectFax);
		
		log.info("patientDetails_Insurance_Search_015 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with correct Fax")
	public void patientDetails_Insurance_Search_016_FindCarrier_CorrectFax()
	{
		log.info("patientDetails_Insurance_Search_016 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_016 - Step 02: Input correct Fax");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchFax(correctFax);
		
		log.info("patientDetails_Insurance_Search_016 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Fax");
		verifyTrue(patientsPage.isListOfCarriersShowWithFax(correctFax));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with no In Network?")
	public void patientDetails_Insurance_Search_017_FindCarrier_NoInNetwork()
	{
		log.info("patientDetails_Insurance_Search_017 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_017 - Step 02: Select no In Network");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.selectCarrierSearchInNetwork("No");
		
		log.info("patientDetails_Insurance_Search_017 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have no In Network");
		verifyTrue(patientsPage.isListOfCarriersShowWithInNetwork("No"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with Yes In Network?")
	public void patientDetails_Insurance_Search_018_FindCarrier_YesInNetwork()
	{
		log.info("patientDetails_Insurance_Search_018 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_Search_018 - Step 02: Select Yes In Network");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.selectCarrierSearchInNetwork("Yes");
		
		log.info("patientDetails_Insurance_Search_018 - Step 03: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: Show list of Carriers have yes In Network");
		verifyTrue(patientsPage.isListOfCarriersShowWithInNetwork("Yes"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Search with incorrect all fields")
	public void patientDetails_Insurance_Search_019_FindCarrier_IncorrectAllFields()
	{
		log.info("patientDetails_Insurance_Search_019 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
	
		log.info("patientDetails_Insurance_Search_019 - Step 02: Input incorrect Name");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.inputCarrierSearchName(incorrectName);
		
		log.info("patientDetails_Insurance_Search_019 - Step 03: Input incorrect Contract Date");
		patientsPage.inputCarrierSearchContractDate(incorrectContractDate);
		
		log.info("patientDetails_Insurance_Search_019 - Step 04: Input incorrect City");
		patientsPage.inputCarrierSearchCity(incorrectCity);
		
		log.info("patientDetails_Insurance_Search_019 - Step 05: Input incorrect Zip");
		patientsPage.inputCarrierSearchZip(incorrectZip);
		
		log.info("patientDetails_Insurance_Search_019 - Step 06: Input incorrect Phone");
		patientsPage.inputCarrierSearchPhone(incorrectPhone);
		
		log.info("patientDetails_Insurance_Search_019 - Step 07: Input incorrect Fax");
		patientsPage.inputCarrierSearchFax(incorrectFax);
		
		log.info("patientDetails_Insurance_Search_019 - Step 08: Click Carrier Search button");
		patientsPage.clickCarrierSearchButton(driver);
		
		log.info("VP: No Carriers found displays");
		verifyTrue(patientsPage.isCarrierSearchNoFoundDisplays());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
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
	private String incorrectName, incorrectContractDate, incorrectCity, incorrectState, incorrectZip, incorrectPhone,
	incorrectFax;
	private String invalidZip;
	private String correctName, correctContractDate, correctCity, correctState,correctZip,correctPhone, correctFax;
}
