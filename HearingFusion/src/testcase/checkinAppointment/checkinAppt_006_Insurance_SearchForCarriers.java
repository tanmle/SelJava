package checkinAppointment;

import java.util.Set;
import java.util.Stack;

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

public class checkinAppt_006_Insurance_SearchForCarriers extends AbstractTest{

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
		correctStartTime ="04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		listCarrierFile = "Search_FKCarrierSearch.xls";
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Leaving all fields blank")
	public void checkinAppt_35_FindCarrierLeavingAllFieldsBlank()
	{
		log.info("CheckinAppt_035 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_035 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_035 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_035 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_035 - Step 05: Expand 'Insurance' section");
		patientsPage.expandSectionOnCheckin("Insurance");
		
		log.info("CheckinAppt_035 - Step 06: Add new Insurance record");
		patientsPage.clickNewInsuranceRecordButton();
		
		log.info("CheckinAppt_035 - Step 07: Click on Search icon for Carrier");
		patientsPage.clickOnSearchIconForCarrier();
		patientsPage.switchToInsuranceFrame(driver);
		
		log.info("CheckinAppt_035 - Step 08: Click on Search button");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Website show list of Carriers");
		verifyTrue(patientsPage.isListOfCarriersDisplay());
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Incorrect all fields")
	public void checkinAppt_36_FindCarrierIncorrectAllFields()
	{
		log.info("CheckinAppt_036 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("IncorrectName");
		
		log.info("CheckinAppt_036 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2010");
		
		log.info("CheckinAppt_036 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("IncorrectCity");
		
		log.info("CheckinAppt_036 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("WA - Washington");
		
		log.info("CheckinAppt_036 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("12345");
		
		log.info("CheckinAppt_036 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("888-525-6789");
		
		log.info("CheckinAppt_036 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("888-525-6789");
		
		log.info("CheckinAppt_036 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_036 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Incorrect name field")
	public void checkinAppt_37_FindCarrierIncorrectNameField()
	{
		log.info("CheckinAppt_037 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("IncorrectName");
		
		log.info("CheckinAppt_037 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_037 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_037 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("");
		
		log.info("CheckinAppt_037 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_037 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_037 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_037 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_037 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Correct name field")
	public void checkinAppt_38_FindCarrierCorrectNameField()
	{
		log.info("CheckinAppt_038 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_038 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_038 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_038 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("");
		
		log.info("CheckinAppt_038 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_038 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_038 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_038 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_038 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Show list of Carriers have Name: Aetna");
		verifyTrue(patientsPage.isListOfCarriersWithName("Aetna"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Incorrect Contract date")
	public void checkinAppt_39_FindCarrierIncorrectContractDateField()
	{
		log.info("CheckinAppt_039 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_039 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2010");
		
		log.info("CheckinAppt_039 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_039 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("");
		
		log.info("CheckinAppt_039 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_039 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_039 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_039 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_039 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Correct Contract date field")
	public void checkinAppt_40_FindCarrierCorrectContractDateField()
	{
		log.info("CheckinAppt_040 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_040 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_040 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_040 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("");
		
		log.info("CheckinAppt_040 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_040 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_040 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_040 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_040 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Show list of Carriers have Name: Aetna");
		verifyTrue(patientsPage.isListOfCarriersWithContractDate("1/1/2012"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Incorrect city")
	public void checkinAppt_41_FindCarrierIncorrectCityField()
	{
		log.info("CheckinAppt_041 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_041 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_041 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("IncorrectCity");
		
		log.info("CheckinAppt_041 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("");
		
		log.info("CheckinAppt_041 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_041 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_041 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_041 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_041 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Correct City field")
	public void checkinAppt_42_FindCarrierCorrectCityField()
	{
		log.info("CheckinAppt_042 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_042 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_042 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_042 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("");
		
		log.info("CheckinAppt_042 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_042 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_042 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_042 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_042 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Show list of Carriers have Name: Aetna");
		verifyTrue(patientsPage.isListOfCarriersWithCity("Los Angeles"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Incorrect state")
	public void checkinAppt_43_FindCarrierIncorrectStateField()
	{
		log.info("CheckinAppt_043 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_043 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_043 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_043 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("WA - Washington");
		
		log.info("CheckinAppt_043 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_043 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_043 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_043 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_043 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Correct State field")
	public void checkinAppt_44_FindCarrierCorrectStateField()
	{
		log.info("CheckinAppt_044 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_044 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_044 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_044 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_044 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("");
		
		log.info("CheckinAppt_044 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_044 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_044 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_044 - Step 09: Click search button");
		patientsPage.clickOnSearchButton(driver);
	
		log.info("VP: Show list of Carriers have Name: Aetna");
		verifyTrue(patientsPage.isListOfCarriersWithState("CA"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier:Incorrect Zip code")
	public void checkinAppt_45_FindCarrierIncorrectZipCode()
	{
		log.info("CheckinAppt_045 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_045 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_045 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_045 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_045 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90012");
		
		log.info("CheckinAppt_045 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_045 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_045 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_45 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier:Correct Zip code")
	public void checkinAppt_46_FindCarrierCorrectZipCode()
	{
		log.info("CheckinAppt_046 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("");
		
		log.info("CheckinAppt_046 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("");
		
		log.info("CheckinAppt_046 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("");
		
		log.info("CheckinAppt_046 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_046 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_046 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("");
		
		log.info("CheckinAppt_046 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_046 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_046 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Name : Aetna, Contract date: 1/1/2012, City: Los Angeles, State: CA-California, Zip code: 90024");
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Name","Aetna"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("ContractDate","1/1/2012"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("City","Los Angeles"));	
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("State","CA"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Zip","90024"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier:Incorrect Phone")
	public void checkinAppt_47_FindCarrierIncorrectPhone()
	{
		log.info("CheckinAppt_047 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_047 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_047 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_047 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_047 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_047 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("800-989-5211");
		
		log.info("CheckinAppt_047 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_047 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_047 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}

	@Test(groups = { "regression" },description = "Find Carrier:Correct Zip code")
	public void checkinAppt_48_FindCarrierCorrectPhone()
	{
		log.info("CheckinAppt_048 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_048 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_048 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_048 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_048 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_048 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("800-989-5600");
		
		log.info("CheckinAppt_048 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_048 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_048 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Name : Aetna, Contract date: 1/1/2012, City: Los Angeles, State: CA-California, Zip code: 90024, Phone: 800-989-5600");
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Name","Aetna"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("ContractDate","1/1/2012"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("City","Los Angeles"));	
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("State","CA"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Zip","90024"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Phone","800-989-5600"));
	}

	@Test(groups = { "regression" },description = "Find Carrier:Incorrect Zip code")
	public void checkinAppt_49_FindCarrierIncorrectFax()
	{
		log.info("CheckinAppt_049 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_049 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_049 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_049 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_049 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_049 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("800-989-5600");
		
		log.info("CheckinAppt_049 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("800-989-5600");
		
		log.info("CheckinAppt_049 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_049 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	@Test(groups = { "regression" },description = "Find Carrier:Correct Fax")
	public void checkinAppt_50_FindCarrierCorrectFax()
	{
		log.info("CheckinAppt_050 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_050 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_050 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_050 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_050 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_050 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("800-989-5600");
		
		log.info("CheckinAppt_050 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_050 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Either");
		
		log.info("CheckinAppt_050 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Show list of Carriers have Name : Aetna, Contract date: 1/1/2012, City: Los Angeles, State: CA-California, Zip code: 90024, Phone: 800-989-5600");
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Name","Aetna"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("ContractDate","1/1/2012"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("City","Los Angeles"));	
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("State","CA"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Zip","90024"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Phone","800-989-5600"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier:Incorrect In network")
	public void checkinAppt_51_FindCarrierIncorrectInNetwork()
	{
		log.info("CheckinAppt_051 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_051 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_051 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_051 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_051 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_051 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("800-989-5600");
		
		log.info("CheckinAppt_051 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_051 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("No");
		
		log.info("CheckinAppt_051 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: Message display with text 'No Carriers found'");
		verifyTrue(patientsPage.isSearchCarrierMessageDisplay("No Carriers found"));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier:correct In network? ")
	public void checkinAppt_52_FindCarrierCorrectInNetwork()
	{
		log.info("CheckinAppt_052 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_052 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_052 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_052 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_052 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_052 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("800-989-5600");
		
		log.info("CheckinAppt_052 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_052 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Yes");
		
		log.info("CheckinAppt_052 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("VP: No Carriers found");
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Name","Aetna"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("ContractDate","1/1/2012"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("City","Los Angeles"));	
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("State","CA"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Zip","90024"));
		verifyTrue(patientsPage.isCarrierShowInlistCarriers("Phone","800-989-5600"));
	}
	@Test(groups = { "regression" },description = "Find Carrier:Download CSV search results")
	public void checkinAppt_53_FindCarrierDownloadCSVSearchResults()
	{
		log.info("CheckinAppt_053 - Step 01: Input Name");
		patientsPage.inputNameSearchCarrier("Aetna");
		
		log.info("CheckinAppt_053 - Step 02: Input contract date");
		patientsPage.inputContractDateSearchCarrier("1/1/2012");
		
		log.info("CheckinAppt_053 - Step 03: Input City");
		patientsPage.inputCitySearchCarrier("Los Angeles");
		
		log.info("CheckinAppt_053 - Step 04: Select State");
		patientsPage.selectStateSearchCarrier("CA - California");
		
		log.info("CheckinAppt_053 - Step 05: Input Zip code");
		patientsPage.inputZipCodeSearchCarrier("90024");
		
		log.info("CheckinAppt_053 - Step 06: Input phone");
		patientsPage.inputPhoneSearchCarrier("800-989-5600");
		
		log.info("CheckinAppt_053 - Step 07: Input fax");
		patientsPage.inputFaxSearchCarrier("");
		
		log.info("CheckinAppt_053 - Step 08: Select 'In Network' option");
		patientsPage.selectInNetworkSearchCarrier("Yes");
		
		log.info("CheckinAppt_053 - Step 09: Click Search");
		patientsPage.clickOnSearchButton(driver);
		
		log.info("CheckinAppt_053 - Step 10: Click CSV to download results");
		patientsPage.downloadFileCSVResultFoundCarrier(listCarrierFile);
		
		log.info("VP: Download CSV file successfully");
		verifyTrue(Common.getCommon().isFileExists(listCarrierFile));
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Open Help page")
	public void checkinAppt_54_FindCarrierFindCarrierOpenHelpPage()
	{
		log.info("CheckinAppt_054 - Step 01: Click on Help link");
		patientsPage.clickOnHelpLink();
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Help page is opened");
		verifyTrue(patientsPage.isHelpPageOpened());
		
		driver.close();
		driver.switchTo().window(currentHandle);
	}
	
	@Test(groups = { "regression" },description = "Print")
	public void checkinAppt_55_FindCarrierPrint()
	{
		log.info("CheckinAppt_055 - Step 01: Click on Help link");
		patientsPage.switchToInsuranceFrame(driver);
		patientsPage.clickOnPrintLink();
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Print page is opened");
		verifyTrue(patientsPage.isPrintPageOpened());
		
		driver.close();
		driver.switchTo().window(currentHandle);
	}
	
	@Test(groups = { "regression" },description = "Find Carrier: Email")
	public void checkinAppt_56_FindCarrierEmail()
	{
		log.info("CheckinAppt_056 - Step 01: Click on Email link");
		patientsPage.switchToInsuranceFrame(driver);
		patientsPage.clickOnEmailLink();
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Help page is opened");
		verifyTrue(patientsPage.isEmailPageOpened());
		
		driver.close();
		driver.switchTo().window(currentHandle);
		
		log.info("CheckinAppt_056 - Step 02: Go to Schedule page");
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
		
		log.info("CheckinAppt_056 - Step 03: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_056 - Step 04: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_056 - Step 05: Delete appointment");
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
	private String apptType, apptStatus, patientFull, patientName, refResource, provider, listCarrierFile;
	private String correctStartTime, correctEndTime, noteContent;
	private final Stack<String> openWindowHandles = new Stack<String>();
}