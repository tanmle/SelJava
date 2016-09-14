package checkinAppointment;

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

public class checkinAppt_012_AssociatedOffices extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		correctHour = 16;
		correctMinute = 0;
		correctStartTime ="03:00 PM";
		correctEndTime = "04:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		section = "Associated Offices";
	}
	
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Leaving all fields blank")
	public void checkinAppt_73_AssociatedOfficesLeavingAllFieldsBlank()
	{
		log.info("CheckinAppt_73 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_73 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_73 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_73 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_73 - Step 05: Expand 'CBO Billing Notes' section");
		patientsPage.expandSectionOnCheckin(section);
		
		log.info("CheckinAppt_73 - Step 06: Add new Associated Office");
		patientsPage.clickCreateNewAssociatedOfficeIcon();
		
		log.info("CheckinAppt_73 - Step 07: Click the search icon at Office field");
		patientsPage.clickSearchLastOfficeItemAssociated();
		driver = patientsPage.switchToSearchAssociatedFrame(driver);
		
		log.info("CheckinAppt_73 - Step 08: Leaving all fields blank then click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show list of Offices");
		verifyTrue(patientsPage.isShowAssociatedOfficeList());

	}

	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect Name")
	public void checkinAppt_74_AssociatedOfficesSearchIncorrectName()
	{
		
		log.info("CheckinAppt_74 - Step 01: Enter incorrect Name");
		patientsPage.enterNameSearchAssociatedOffices("abced");
		
		log.info("CheckinAppt_74 - Step 02: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
	}
	
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct Name")
	public void checkinAppt_75_AssociatedOfficesSearchCorrectName()
	{
		
		log.info("CheckinAppt_75 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_75 - Step 02: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Name: Pittsburgh");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithName("Pittsburgh"));

	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect City")
	public void checkinAppt_76_AssociatedOfficesSearchIncorrectCity()
	{
		
		log.info("CheckinAppt_76 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_76 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("abc");
		
		log.info("CheckinAppt_76 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct City")
	public void checkinAppt_77_AssociatedOfficesSearchCorrectCity()
	{
		
		log.info("CheckinAppt_77 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_77 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_77 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Name: Pittsburgh");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithName("Pittsburgh"));

		log.info("VP: Show office has City: Los Angeles");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCity("Los Angeles"));
	
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect State ")
	public void checkinAppt_78_AssociatedOfficesSearchIncorrectState()
	{
		
		log.info("CheckinAppt_78 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_78 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_78 - Step 03: Click select incorrect State");
		patientsPage.selectStateAssociatedOffices("NV - Nevada");
		
		log.info("CheckinAppt_78 - Step 04: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));

	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct State ")
	public void checkinAppt_79_AssociatedOfficesSearchCorrectState()
	{
		log.info("CheckinAppt_79 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_79 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_79 - Step 03: Click select correct State");
		patientsPage.selectStateAssociatedOffices("CA - California");
		
		log.info("CheckinAppt_79 - Step 04: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Name: Pittsburgh");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithName("Pittsburgh"));

		log.info("VP: Show office has City: Los Angeles");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCity("Los Angeles"));
		
		log.info("VP: Show office has State: CA");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithState("CA"));
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect Zip code")
	public void checkinAppt_80_AssociatedOfficesSearchIncorrectZipCode()
	{
		log.info("CheckinAppt_80 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_80 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_80 - Step 03: Click select incorrect State");
		patientsPage.selectStateAssociatedOffices("CA - California");
		
		log.info("CheckinAppt_80 - Step 04: Input incorrect Zip code");
		patientsPage.enterZipCodeSearchAssociatedOffices("90041");
		
		log.info("CheckinAppt_80 - Step 05: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));

	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct Zip code")
	public void checkinAppt_81_AssociatedOfficesSearchCorrectZipCode()
	{
		log.info("CheckinAppt_81 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_81 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_81 - Step 03: Click select incorrect State");
		patientsPage.selectStateAssociatedOffices("CA - California");
		
		log.info("CheckinAppt_81 - Step 04: Input correct Zip code");
		patientsPage.enterZipCodeSearchAssociatedOffices("90049");
		
		log.info("CheckinAppt_81 - Step 05: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Name: Pittsburgh");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithName("Pittsburgh"));

		log.info("VP: Show office has City: Los Angeles");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCity("Los Angeles"));
		
		log.info("VP: Show office has State: CA");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithState("CA"));
		
		log.info("VP: Show office has Zip Code: 90049");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithZipCode("90049"));

	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct County")
	public void checkinAppt_83_AssociatedOfficesSearchCorrectCounty()
	{
		log.info("CheckinAppt_83 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_83 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_83 - Step 03: Click select incorrect State");
		patientsPage.selectStateAssociatedOffices("CA - California");
		
		log.info("CheckinAppt_83 - Step 04: Input correct Zip code");
		patientsPage.enterZipCodeSearchAssociatedOffices("90049");
		
		log.info("CheckinAppt_83 - Step 05: Select County");
		patientsPage.selectCountyAssociatedOffices("");
		
		log.info("CheckinAppt_83 - Step 06: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Name: Pittsburgh");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithName("Pittsburgh"));

		log.info("VP: Show office has City: Los Angeles");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCity("Los Angeles"));
		
		log.info("VP: Show office has State: CA");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithState("CA"));
		
		log.info("VP: Show office has Zip Code: 90049");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithZipCode("90049"));
		
		log.info("VP: Show office has Coutry Code: ");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCounty(""));
	}
	
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Incorrect Phone")
	public void checkinAppt_84_AssociatedOfficesSearchIncorrectPhone()
	{
		log.info("CheckinAppt_84 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_84 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_84 - Step 03: Click select incorrect State");
		patientsPage.selectStateAssociatedOffices("CA - California");
		
		log.info("CheckinAppt_84 - Step 04: Input correct Zip code");
		patientsPage.enterZipCodeSearchAssociatedOffices("90049");
		
		log.info("CheckinAppt_84 - Step 05: Select County");
		patientsPage.selectCountyAssociatedOffices("");
		
		log.info("CheckinAppt_84 - Step 06: click Search button");
		patientsPage.enterPhoneSearchAssociatedOffices("8774082489");
		
		log.info("CheckinAppt_84 - Step 07: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Offices found");
		verifyTrue(patientsPage.isSearchAssociatedOfficesMessageDisplay("No Offices found"));
	
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for Offices Correct Phone")
	public void checkinAppt_85_AssociatedOfficesSearchCorrectPhone()
	{
		log.info("CheckinAppt_85 - Step 01: Enter Correct Name");
		patientsPage.enterNameSearchAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_85 - Step 02: Enter icorrect City");
		patientsPage.enterCitySearchAssociatedOffices("Los Angeles");
		
		log.info("CheckinAppt_85 - Step 03: Click select incorrect State");
		patientsPage.selectStateAssociatedOffices("CA - California");
		
		log.info("CheckinAppt_85 - Step 04: Input correct Zip code");
		patientsPage.enterZipCodeSearchAssociatedOffices("90049");
		
		log.info("CheckinAppt_85 - Step 05: Select County");
		patientsPage.selectCountyAssociatedOffices("");
		
		log.info("CheckinAppt_85 - Step 06: click Search button");
		patientsPage.enterPhoneSearchAssociatedOffices("8774082488");
		
		log.info("CheckinAppt_85 - Step 07: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show office has Name: Pittsburgh");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithName("Pittsburgh"));

		log.info("VP: Show office has City: Los Angeles");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCity("Los Angeles"));
		
		log.info("VP: Show office has State: CA");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithState("CA"));
		
		log.info("VP: Show office has Zip Code: 90049");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithZipCode("90049"));
		
		log.info("VP: Show office has Coutry Code: ");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithCounty(""));
		
		log.info("VP: Show office has Coutry Code: ");
		verifyTrue(patientsPage.isItemListAssociatedOfficesWithPhone("8774082488"));

	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Leaving all fields blank")
	public void checkinAppt_86_AssociatedOfficesSearchProvidersLeavingAllBlank()
	{
		log.info("CheckinAppt_86 - Step 01: Select an Offices");
		patientsPage.selectOfficesItemAssociatedOffices("Pittsburgh");
		
		log.info("CheckinAppt_86 - Step 02: reOpen Associated Offices");
		patientsPage.switchToTopWindowFrame(driver);

		log.info("CheckinAppt_86 - Step 03: click the search icon at Provider field");
		patientsPage.clickSearchProviderLastItemAssociatedOffice();
		driver = patientsPage.switchToSearchProviderAssociatedFrame(driver);
		
		log.info("CheckinAppt_86 - Step 04: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show list of Offices");
		verifyTrue(patientsPage.isShowProviderAssociatedOfficeList());
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Incorrect Provider Last Name")
	public void checkinAppt_87_AssociatedOfficesSearchProvidersIncorrectLastName()
	{
		log.info("CheckinAppt_87 - Step 01:  Enter incorrect Provider Last Name");
		patientsPage.enterAssociatedOfficesProviderLastName("abcde");
		
		log.info("CheckinAppt_87 - Step 02: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Providers found");
		verifyTrue(patientsPage.isSearchProviderAssociatedOfficesMessageDisplay("Search returned no results."));
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Correct Provider Last Name")
	public void checkinAppt_88_AssociatedOfficesSearchProvidersCorrectLastName()
	{
		log.info("CheckinAppt_88 - Step 01:  Enter Correct Provider Last Name");
		patientsPage.enterAssociatedOfficesProviderLastName("Franklin");
		
		log.info("CheckinAppt_88 - Step 02: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show Provider Last Name: Franklin");
		verifyTrue(patientsPage.isProviderItemListAssociatedOfficesWithLastName("Franklin"));
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Incorrect Provider First Name ")
	public void checkinAppt_89_AssociatedOfficesSearchProvidersIncorrectFirstName()
	{
		log.info("CheckinAppt_89 - Step 01:  Enter Correct Provider Last Name");
		patientsPage.enterAssociatedOfficesProviderLastName("Franklin");
		
		log.info("CheckinAppt_89 - Step 02:  Enter Correct Provider Fist Name");
		patientsPage.enterAssociatedOfficesProviderFirstName("abc");
		
		log.info("CheckinAppt_89 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: No Providers found");
		verifyTrue(patientsPage.isSearchProviderAssociatedOfficesMessageDisplay("Search returned no results."));
	}
	@Test(groups = { "regression" },description = "Associated Offices: Search for providers Correct Provider First Name ")
	public void checkinAppt_90_AssociatedOfficesSearchProvidersCorrectFirstName()
	{
		log.info("CheckinAppt_90 - Step 01:  Enter Correct Provider Last Name");
		patientsPage.enterAssociatedOfficesProviderLastName("Franklin");
		
		log.info("CheckinAppt_90 - Step 02:  Enter Correct Provider Fist Name");
		patientsPage.enterAssociatedOfficesProviderFirstName("Ben");
		
		log.info("CheckinAppt_90 - Step 03: click Search button");
		patientsPage.clickSearchForOffices();
		
		log.info("VP: Show Provider Last Name: Needle");
		verifyTrue(patientsPage.isProviderItemListAssociatedOfficesWithLastName("Franklin"));
		
		// Post-condition
		log.info("Post-condition - Step 01: Close search office popup");
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchProviderAssociatedOfficePopup();

		log.info("Post-condition - Step 02: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);

		log.info("Post-condition - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,
				apptType, patientName);

		log.info("Post-condition - Step 04: Delete appointment");
		schedulePage.deleteAppointment();
		schedulePage.switchToTopWindowFrame(driver);
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
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider ;
	private String correctStartTime, correctEndTime, noteContent;
	private String section;
}