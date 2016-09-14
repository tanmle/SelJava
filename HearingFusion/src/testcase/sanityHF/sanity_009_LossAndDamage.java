package sanityHF;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.InventoryPage;
import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SalesPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Common;
import common.Constant;

public class sanity_009_LossAndDamage extends AbstractTest{
	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

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
		
		office="Hearing Fun Report - Tecoma, WA";
		manufacturer = "Oticon Hearing";
		type = "ITE";
		model = "Intiga- (ITE)";
		serial=getUniqueNumber();
		provider ="Needle, Space";
		
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		correctHour = 16;
		correctMinute = 0;
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		provider = "Needle, Space";
		apptType = "Follow Up";
		apptStatus = "Arrived";
		refResource = "Campaign";
		noteContent = "Note Content";
		
		battery = "10";
	}
	@Test(groups = { "regression" },description = "Loss and Damage Flow")
	public void sanity_LossAndDamage_001_LossAndDamage()
	{
		log.info("sanity_LossAndDamage_001 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);

		log.info("sanity_LossAndDamage_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("sanity_LossAndDamage_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("sanity_LossAndDamage_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("sanity_LossAndDamage_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("sanity_LossAndDamage_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("sanity_LossAndDamage_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("sanity_LossAndDamage_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("sanity_LossAndDamage_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("sanity_LossAndDamage_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("sanity_LossAndDamage_001 - Step 10: Open Inventory page");
		inventoryPage = patientsPage.openInventoryPage(driver, ipClient);
		
		log.info("sanity_LossAndDamage_001 - Step 11: Select Serialized Item link");
		inventoryPage.clickDynamicInventoryLink("Serialized Items");
		
		log.info("sanity_LossAndDamage_001 - Step 12: Click New button");
		inventoryPage.clickSerializedItemsNewButton();
		
		log.info("sanity_LossAndDamage_001 - Step 13: Input new serialized item");
		inventoryPage.inputSerializedItem(office, "Hearing Aid", manufacturer, type, model, serial, "");
		
		log.info("sanity_LossAndDamage_001 - Step 14: Click Save button");
		inventoryPage.clickSerializedItemsDetailSaveButton();
		
		log.info("sanity_LossAndDamage_001 - Step 15: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		
		log.info("sanity_LossAndDamage_001 - Step 16: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, validPatientFirstName+" "+validPatientLastName, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("sanity_LossAndDamage_001 - Step 17: Open event created");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, validPatientLastName+", "+validPatientFirstName);

		log.info("sanity_LossAndDamage_001 - Step 18: open Checkin Appointment data");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("sanity_LossAndDamage_001 - step 19: Open Create sales order page");
		salesPage =  patientsPage.clickOnCreateSalesOrder();
		
		log.info("sanity_LossAndDamage_001 - step 20: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");

		log.info("sanity_LossAndDamage_001 - step 21: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar(manufacturer, type, model,serial,battery);

		log.info("sanity_LossAndDamage_001 - step 22: Enter Left Ear Discount Type");
		salesPage.selectPrincingDiscountType("Monetary");

		log.info("sanity_LossAndDamage_001 - step 23: Enter Left Ear Pricing Discount");
		salesPage.enterPrincingDiscount("750");
		
		log.info("sanity_LossAndDamage_001 - step 24: click Save");
		salesPage.clickOnSaveButton();

		log.info("sanity_LossAndDamage_001 - Step 25: Click Back button");
		salesPage.clickOnBackButton();
		
		log.info("sanity_LossAndDamage_001 - Step 26: Click Checkout button");
		salesPage.clickOnCheckoutButton();
		
		log.info("VP: Verify that user is taken back to Create Sales Order page");
		verifyTrue(salesPage.isCraeteSalesOrderPageDisplays());
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		//Post-Condition
		log.info("Post-Condition - step 01: Open schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, apptStatus);
										
		log.info("Post-Condition - Step 02: Open event created");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, validPatientLastName+", "+validPatientFirstName);
										
		log.info("Post-Condition - Step 03: delete event created");
	    schedulePage.deleteAppointment();
				
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private InventoryPage inventoryPage;
	private SalesPage salesPage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	private String office;
	private String manufacturer, type, model, serial;
	private String provider, battery;
	private int date, month, year,correctHour, correctMinute;
	private String correctStartTime, correctEndTime;
	private String apptType, apptStatus, refResource, noteContent;
}
