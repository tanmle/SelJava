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

public class checkinAppt_002_SearchForReferringProviders extends AbstractTest{

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
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Leaving all fieds blank")
	public void checkinAppt_06_LeavingAllFiedsBlank()
	{
		log.info("CheckinAppt_06 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_06 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_06 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_06 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_06 - Step 05: Click Referring Providers link");
		patientsPage.clickOnReferringProvidersLink();
		
		log.info("CheckinAppt_06 - Step 06: Click on Search button");
		patientsPage.clickOnSearchReferringProvidersButton();
		
		log.info("VP: Website show list of Referring Providers");
		verifyTrue(patientsPage.isListOfReferringProvidersDisplay());
	}
	
	@Test(groups = { "regression" },description = "Incorrect all fields")
	public void checkinAppt_07_IncorrectAllFields()
	{
		log.info("CheckinAppt_07 - Step 01: Input invalid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("IncorrectProviderLastname");
		
		log.info("CheckinAppt_07 - Step 02: Input invalid Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("IncorrectProviderFirstname");
		
		log.info("CheckinAppt_07 - Step 03: Input invalid Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("IncorrectPracticename");
		
		log.info("CheckinAppt_07 - Step 04: Input invalid City");
		patientsPage.inputCitySearchReferringProvider("IncorrectCity");
		
		log.info("CheckinAppt_07 - Step 05: Select invalid State");
		patientsPage.selectStateSearchReferringProvider("WA - Washington");
		
		log.info("CheckinAppt_07 - Step 06: Input invalid Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("12345");
		
		log.info("CheckinAppt_07 - Step 07: Select invalid Status");
		patientsPage.selectStatusSearchReferringProvider("Inactive");
		
		log.info("CheckinAppt_07 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect Provider Last Name")
	public void checkinAppt_08_IncorrectProviderLastName()
	{
		log.info("CheckinAppt_08 - Step 01: Input invalid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("IncorrectProviderLastname");
		
		log.info("CheckinAppt_08 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_08 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_08 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_08 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_08 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_08 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_08 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
		
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Provider Last Name")
	public void checkinAppt_09_CorrectProviderLastName ()
	{
		log.info("CheckinAppt_09 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("Sherrerd");
		
		log.info("CheckinAppt_09 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_09 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_09 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_09 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_09 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_09 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_09 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Show list of Referring Providers that have Provider Last Name is 'Sherrerd'");
		verifyTrue(patientsPage.isListOfReferringProvidersWithName("Sherrerd"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect Provider First Name")
	public void checkinAppt_10_IncorrectProviderFirstName()
	{
		log.info("CheckinAppt_10 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_10 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("IncorrectProviderFirstname");
		
		log.info("CheckinAppt_10 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_10 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_10 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_10 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_10 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_10 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Provider First Name")
	public void checkinAppt_11_CorrectProviderFirstName()
	{
		log.info("CheckinAppt_11 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_11 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("Paul");
		
		log.info("CheckinAppt_11 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_11 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_11 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_11 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_11 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_11 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Show list of Referring Providers that have Provider First Name is 'Paul'");
		verifyTrue(patientsPage.isListOfReferringProvidersWithName("Paul"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect Practice Name")
	public void checkinAppt_14_IncorrectPracticeName()
	{
		log.info("CheckinAppt_14 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_14 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_14 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("IncorrectPracticeName");
		
		log.info("CheckinAppt_14 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_14 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_14 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_14 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_14 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Practice Name")
	public void checkinAppt_15_CorrectPracticeName()
	{
		log.info("CheckinAppt_15 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_15 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_15 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("Family Ear, Nose, & Throat Clinic");
		
		log.info("CheckinAppt_15 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_15 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_15 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_15 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_15 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Show list of Referring Providers that have Provider Practice Name is 'Family Ear, Nose, & Throat Clinic'");
		verifyTrue(patientsPage.isListOfReferringProvidersWithPracticeName("Family Ear, Nose, & Throat Clinic"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect City")
	public void checkinAppt_16_IncorrectCity()
	{
		log.info("CheckinAppt_16 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_16 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_16 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_16 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("incorrectCity");
		
		log.info("CheckinAppt_16 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_16 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_16 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_16 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Correct City")
	public void checkinAppt_17_CorrectCity()
	{
		log.info("CheckinAppt_17 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_17 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_17 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_17 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("Omaha");
		
		log.info("CheckinAppt_17 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_17 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_17 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_17 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Show list of Referring Providers that have City is 'Omaha'");
		verifyTrue(patientsPage.isListOfReferringProvidersWithCity("Omaha"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect State")
	public void checkinAppt_18_IncorrectState()
	{
		log.info("CheckinAppt_18 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_18 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_18 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_18 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_18 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("WA - Washington");
		
		log.info("CheckinAppt_18 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_18 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_18 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Correct State")
	public void checkinAppt_19_CorrectState()
	{
		log.info("CheckinAppt_19 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_19 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_19 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_19 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_19 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("NE - Nebraska");
		
		log.info("CheckinAppt_19 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_19 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_19 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Show list of Referring Providers that have State is 'NE'");
		verifyTrue(patientsPage.isListOfReferringProvidersWithState("NE"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect Zip code")
	public void checkinAppt_20_IncorrectZipCode()
	{
		log.info("CheckinAppt_20 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_20 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_20 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_20 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_20 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_20 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("12345");
		
		log.info("CheckinAppt_20 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_20 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Zip code")
	public void checkinAppt_21_CorrectZipCode()
	{
		log.info("CheckinAppt_21 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_21 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_21 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_21 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_21 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_21 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("68122");
		
		log.info("CheckinAppt_21 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("");
		
		log.info("CheckinAppt_21 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Show list of Referring Providers that have Zipcode is '68122'");
		verifyTrue(patientsPage.isListOfReferringProvidersWithZipCode("68122"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect Status")
	public void checkinAppt_22_IncorrectStatus()
	{
		log.info("CheckinAppt_22 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_22 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_22 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_22 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_22 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_22 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_22 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("Inactive");
		
		log.info("CheckinAppt_22 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Error message display with text 'No Referring Providers found'");
		verifyTrue(patientsPage.isSearchReferringProvidersErrorMessageDisplay("No Referring Providers found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Status")
	public void checkinAppt_23_CorrectStatus()
	{
		log.info("CheckinAppt_23 - Step 01: Input valid Provider Last Name");
		patientsPage.inputProviderLastNameSearchReferringProvider("");
		
		log.info("CheckinAppt_23 - Step 02: Input Provider First Name");
		patientsPage.inputProviderFristNameSearchReferringProvider("");
		
		log.info("CheckinAppt_23 - Step 03: Input Practice Name");
		patientsPage.inputPracticeNameSearchReferringProvider("");
		
		log.info("CheckinAppt_23 - Step 04: Input City");
		patientsPage.inputCitySearchReferringProvider("");
		
		log.info("CheckinAppt_23 - Step 05: Select State");
		patientsPage.selectStateSearchReferringProvider("");
		
		log.info("CheckinAppt_23 - Step 06: Input Zip code");
		patientsPage.inputZipCodeSearchReferringProvider("");
		
		log.info("CheckinAppt_23 - Step 07: Select Status");
		patientsPage.selectStatusSearchReferringProvider("Active");
		
		log.info("CheckinAppt_23 - Step 08: Click search button");
		patientsPage.clickOnSearchReferringProvidersButton();
	
		log.info("VP: Show list of Referring Providers that have Status is 'Active'");
		verifyTrue(patientsPage.isListOfReferringProvidersWithStatus("Active"));
	}
	
	@Test(groups = { "regression" },description = "Open Help page")
	public void checkinAppt_25_OpenHelpPage()
	{
		log.info("CheckinAppt_25 - Step 01: Click on Help link");
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
		
		log.info("CheckinAppt_25 - Step 09: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_25 - Step 10: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_25 - Step 11: Delete appointment");
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
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime, noteContent;
	private final Stack<String> openWindowHandles = new Stack<String>();
}