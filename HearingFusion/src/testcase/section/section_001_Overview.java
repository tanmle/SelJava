package section;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AdministrationPage;
import page.BillingPage;
import page.InboxPage;
import page.InventoryPage;
import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.ReportsPage;
import page.SalesPage;
import page.SchedulePage;
import page.SettingPage;
import common.AbstractTest;
import common.Constant;

public class section_001_Overview extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		walterProvider = "Walters, Barbara Au.D.";
	}
	
	@Test(groups = { "regression" },description = "Overview Schedule")
	public void Overview_01_OverviewSchedule()
	{
		log.info("Overview_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Overview_01 - Step 02: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		
		//Provider checkbox
		log.info("Overview_01 - Step 03: Select provider column for displays");
		schedulePage.selectProviderColumnDisplays(walterProvider,true);
		
		log.info("VP: Provider column selected displays");
		verifyTrue(schedulePage.isProviderColumnDisplays("Walters, Barbara Au.D."));
		
		//office combobox
		log.info("VP: Office combobox displays");
		verifyTrue(schedulePage.isOfficeComboboxDisplays());
		
		//Schedule tab
		log.info("Overview_01 - Step 04: Select Day tab");
		schedulePage.selectScheduleTab("Day");
		
		log.info("VP: Tab Day displays");
		verifyTrue(schedulePage.isScheduleTabDisplays("Day"));
		
		//Check Celander displays
		
		log.info("VP: Calendar displays");
		verifyTrue(schedulePage.isScheduleCalendarDisplays());
		
		// check search text box
		log.info("VP: Verify Search calender");
		verifyTrue(schedulePage.isSeachCalenderDisplays());
		
		log.info("VP: Verify Search calender");
		verifyTrue(schedulePage.isSearchLocateDisplays());
		
		log.info("VP: Verify Confirm task link displays");
		verifyTrue(schedulePage.isTaskLinkDisplays("Confirmation"));
		
		log.info("VP: Verify Reschedule task link displays");
		verifyTrue(schedulePage.isTaskLinkDisplays("Reschedule"));
		
		log.info("VP: Verify Recalls task link displays");
		verifyTrue(schedulePage.isTaskLinkDisplays("Recalls"));

		log.info("VP: Verify Recalls task link displays");
		verifyTrue(schedulePage.isTaskLinkDisplays("Exception"));
		
		log.info("VP: Verify List icon status displays");
		verifyTrue(schedulePage.isListIconStatusDisplays());
		
	}
		
	@Test(groups = { "regression" },description = "Overview Inbox")
	public void Overview_02_OverviewInbox()
	{
		log.info("Overview_02 - Step 01: Open inbox page");
		schedulePage.switchToTopWindowFrame(driver);
		inboxPage = schedulePage.openInbox(driver,ipClient);
		
		log.info("VP: Inbox page displays");
		verifyTrue(inboxPage.isInboxDisplays());
		
	}
	
	@Test(groups = { "regression" },description = "Overview Setting")
	public void Overview_03_OverviewSetting()
	{
		log.info("Overview_03 - Step 01: Open Setting page");
		settingPage = inboxPage.openSettingPage(driver,ipClient);
		
		log.info("VP: Default Office displays correct");
		verifyTrue(settingPage.isSettingDefaultDisplaysCorrect("Default Office","Hearing Fun Report - Los Angeles, CA"));
		
		log.info("VP: Default Provider displays correct");
		verifyTrue(settingPage.isSettingDefaultDisplaysCorrect("Default Provider","Needle, Space"));

	}
	@Test(groups = { "regression" },description = "Overview Patient page")
	public void Overview_04_OverviewPatient()
	{
		log.info("Overview_04 - Step 01: Open Setting page");
		patientPage =  settingPage.openPatientsPage(driver,ipClient);
		
		log.info("VP:Current setion has underline");
		verifyTrue(patientPage.isSectionLinkHasUnderline("Patient Records"));

		log.info("VP:Current setion has underline");
		verifyTrue(patientPage.isAddNewPatientLinkDisplays());
	}
	@Test(groups = { "regression" },description = "Overview Sales page")
	public void Overview_05_OverviewSales()
	{
		log.info("Overview_05 - Step 01: Open Setting page");
		salesPage =  patientPage.openSalesPage(driver,ipClient);

		log.info("VP:Current setion has underline");
		verifyTrue(salesPage.isAddNewSalesLinkDisplays());
	}
	@Test(groups = { "regression" },description = "Overview Billing page")
	public void Overview_06_OverviewBilling()
	{
		log.info("Overview_06 - Step 01: Open Setting page");
		billingPage =  salesPage.openBillingPage(driver,ipClient);

		log.info("Overview_06 - Step 02: Select credit card link");
		billingPage.clickCreditCard();
		
		log.info("Overview_06 - Step 03: Select new link");
		billingPage.clickAddNewCreditCard();
		
		log.info("VP:Add new credit card form displays");
		verifyTrue(billingPage.isAddNewCreditCardFormDisplays());
	}
	
	@Test(groups = { "regression" },description = "Overview Inventory page")
	public void Overview_07_OverviewInventory()
	{
		log.info("Overview_07 - Step 01: Open Setting page");
		inventoryPage =  billingPage.openInventoryPage(driver,ipClient);

		log.info("Overview_07- Step 02: Select credit card link");
		verifyTrue(inventoryPage.isListInventoryTabDisplasCorrect());
	}
	
	@Test(groups = { "regression" },description = "Overview Reports page")
	public void Overview_08_OverviewReports()
	{
		log.info("Overview_08 - Step 01: Open Setting page");
		reportsPage =  inventoryPage.openReportsPage(driver,ipClient);

		log.info("Overview_08- Step 02: Select credit card link");
		verifyTrue(reportsPage.isReportPageDisplays());
	}
	@Test(groups = { "regression" },description = "Overview Administrator page")
	public void Overview_09_OverviewAdministration()
	{
		log.info("Overview_09 - Step 01: Open Setting page");
		administrationPage =  reportsPage.openAdministrationPage(driver,ipClient);

		log.info("Overview_09- Step 02: Select credit card link");
		verifyTrue(administrationPage.isAdministrationPagePageDisplays());
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private WebDriver driver;
	private LoginPage loginPage;
	private BillingPage billingPage;
	private AdministrationPage administrationPage;
	private ReportsPage reportsPage;
	private SalesPage salesPage;
	private InventoryPage inventoryPage;
	private SettingPage settingPage;
	private InboxPage inboxPage;
	private SchedulePage schedulePage;
	private PatientsPage patientPage;
	private String organization, qaStaffUsername, password;
	private String walterProvider;
}