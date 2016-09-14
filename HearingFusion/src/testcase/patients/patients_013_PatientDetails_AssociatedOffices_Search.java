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
public class patients_013_PatientDetails_AssociatedOffices_Search extends AbstractTest{

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
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaAdminUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Add New Record_Search with all blank fields")
	public void patients_PatientDetails_AssociatedOffices_Search_001_SearchWithAllBlankFields()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 15: Expand Associated Offices");
		patientsPage.expandPatientDetailsAssociatedOffices();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 16: Add new Associated Office");
		patientsPage.clickCreateNewAssociatedOfficeIcon();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 17: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_001 - Step 18: Leaving all fields blank then click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show list of Offices");
		verifyTrue(patientsPage.isShowAssociatedOfficeList());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect Name")
	public void patients_PatientDetails_AssociatedOffices_Search_002_SearchIncorrectName()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_002 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_002 - Step 02: Leaving all fields blank then click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_002 - Step 03: Enter incorrect Name");
		patientsPage.enterNameSearchAssociatedOffices("abced");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_002 - Step 04: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct Name")
	public void patients_PatientDetails_AssociatedOffices_Search_003_SearchCorrectName()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_003 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_003 - Step 02: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_003 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Name: Pittsburgh");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithName("Pittsburgh"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect City")
	public void patients_PatientDetails_AssociatedOffices_Search_004_SearchIncorrectCity()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_004 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_004 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("abc");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_004 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct City")
	public void patients_PatientDetails_AssociatedOffices_Search_005_SearchCorrectCity()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_005 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_005 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_005 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();

		log.info("VP: Show office has City: Los Angeles");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCity("Los Angeles"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect State ")
	public void patients_PatientDetails_AssociatedOffices_Search_006_SearchIncorrectState()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_006 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_006 - Step 02: Select incorrect State");
		patientsPage.selectStateAssociatedOffices("WY - Wyoming");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_006 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct State ")
	public void patients_PatientDetails_AssociatedOffices_Search_007_SearchCorrectState()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_007 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_007 - Step 02: Click select correct State");
		patientsPage.selectStateAssociatedOffices("CA - California");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_007 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has State: CA");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithState("CA"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect Zip code")
	public void patients_PatientDetails_AssociatedOffices_Search_008_SearchIncorrectZipCode()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_008 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_008 - Step 02: Input incorrect Zip code");
		patientsPage.enterZipCodeSearchAssociatedOffices("90041");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_008 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct Zip code")
	public void patients_PatientDetails_AssociatedOffices_Search_009_SearchCorrectZipCode()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_009 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_009 - Step 02: Input correct Zip code");
		patientsPage.enterZipCodeSearchAssociatedOffices("90049");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_009 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Zip Code: 90049");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithZipCode("90049"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct Country")
	public void patients_PatientDetails_AssociatedOffices_Search_010_SearchCorrectCounty()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_010 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_010 - Step 02: Select County");
		patientsPage.selectCountyAssociatedOffices("");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_010 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Coutry Code: ");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCounty(""));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect Phone")
	public void patients_PatientDetails_AssociatedOffices_Search_011_SearchIncorrectPhone()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_011 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_011 - Step 02: Input incorrect phone");
		patientsPage.enterPhoneSearchAssociatedOffices("8774082489");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_011 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchOfficeAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct Phone")
	public void patients_PatientDetails_AssociatedOffices_Search_012_SearchCorrectPhone()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_012 - Step 01: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_012 - Step 02: Input correct phone");
		patientsPage.enterPhoneSearchAssociatedOffices("8774082488");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_012 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Phone");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithPhone("8774082488"));
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Leaving all fields blank")
	public void patients_PatientDetails_AssociatedOffices_Search_013_SearchProvidersLeavingAllBlank()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_013 - Step 01: Select an Offices");
		patientsPage.selectOfficesItemAssociatedOffices("Pittsburgh");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_013 - Step 02: reOpen Associated Offices");
		patientsPage.switchToTopWindowFrame(driver);

		log.info("patients_PatientDetails_AssociatedOffices_Search_013 - Step 03: click the search icon at Provider field");
		patientsPage.clickSearchProviderLastItemAssociatedOffice();
		driver = patientsPage.switchToSearchProviderAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_013 - Step 04: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show list of Offices");
		verifyTrue(patientsPage.isShowProviderAssociatedOfficeList());
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchProviderAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Incorrect Provider Last Name")
	public void patients_PatientDetails_AssociatedOffices_Search_014_SearchProvidersIncorrectLastName()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_014 - Step 01: click the search icon at Provider field");
		patientsPage.clickSearchProviderLastItemAssociatedOffice();
		driver = patientsPage.switchToSearchProviderAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_014 - Step 02:  Enter incorrect Provider Last Name");
		patientsPage.enterAssociatedOfficesProviderLastName("abcde");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_014 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Providers found");
		verifyTrue(patientsPage.isSearchProviderAssociatedOfficesMessageDisplay("Search returned no results."));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchProviderAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Correct Provider Last Name")
	public void patients_PatientDetails_AssociatedOffices_Search_015_SearchProvidersCorrectLastName()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_015 - Step 01: click the search icon at Provider field");
		patientsPage.clickSearchProviderLastItemAssociatedOffice();
		driver = patientsPage.switchToSearchProviderAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_015 - Step 02:  Enter Correct Provider Last Name");
		patientsPage.enterAssociatedOfficesProviderLastName("Franklin");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_015 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show Provider Last Name: Franklin");
		verifyTrue(patientsPage.isProviderItemListAssociatedOfficesWithLastName("Franklin"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchProviderAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Incorrect Provider First Name ")
	public void patients_PatientDetails_AssociatedOffices_Search_016_SearchProvidersIncorrectFirstName()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_016 - Step 01: click the search icon at Provider field");
		patientsPage.clickSearchProviderLastItemAssociatedOffice();
		driver = patientsPage.switchToSearchProviderAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_016 - Step 02:  Enter Correct Provider Fist Name");
		patientsPage.enterAssociatedOfficesProviderFirstName("abc");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_016 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Providers found");
		verifyTrue(patientsPage.isSearchProviderAssociatedOfficesMessageDisplay("Search returned no results."));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchProviderAssociatedOfficePopup();
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Correct Provider First Name ")
	public void patients_PatientDetails_AssociatedOffices_Search_017_SearchProvidersCorrectFirstName()
	{
		log.info("patients_PatientDetails_AssociatedOffices_Search_017 - Step 01: click the search icon at Provider field");
		patientsPage.clickSearchProviderLastItemAssociatedOffice();
		driver = patientsPage.switchToSearchProviderAssociatedFrame(driver);
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_017 - Step 02:  Enter Correct Provider Fist Name");
		patientsPage.enterAssociatedOfficesProviderFirstName("Ben");
		
		log.info("patients_PatientDetails_AssociatedOffices_Search_017 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show Provider Last Name: Needle");
		verifyTrue(patientsPage.isProviderItemListAssociatedOfficesWithLastName("Franklin"));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchProviderAssociatedOfficePopup();
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
}
