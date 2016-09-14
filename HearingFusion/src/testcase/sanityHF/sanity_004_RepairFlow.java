package sanityHF;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.SalesPage;
import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Common;
import common.Constant;

public class sanity_004_RepairFlow extends AbstractTest{
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
		
		manufacturer = "Generic";
		type = "BTE";
		model = "ABC 100 (BTE)";
		battery = "10";
		
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
		creditCardType = "Visa";
		creditCardNumber = "4012888888881881";
		creditCardName = "Udi Team";
		creditMonth = "Dec";
		creditYear = Common.getCommon().getCurrentYear()+"";
		
		remark = "HA Pay-Deposit, remainder on delivery-JS";
		totalAmount = "1,112.00";
	}
	
	@Test(groups = { "regression" },description = "Repair Flow")
	public void sanity_001_RepairFlow_RepairFlow()
	{
		log.info("sanity_001_RepairFlow - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);

		log.info("sanity_001_RepairFlow - Step 02: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("sanity_001_RepairFlow - Step 03: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("sanity_001_RepairFlow - Step 04: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("sanity_001_RepairFlow - Step 05: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("sanity_001_RepairFlow - Step 06: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("sanity_001_RepairFlow - Step 07: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("sanity_001_RepairFlow - Step 08: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("sanity_001_RepairFlow - Step 09: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("sanity_001_RepairFlow - Step 10: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("sanity_001_RepairFlow - Step 11: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		
		log.info("sanity_001_RepairFlow - Step 12: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, validPatientFirstName+" "+validPatientLastName, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("sanity_001_RepairFlow - Step 13: Open event created");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, validPatientLastName+", "+validPatientFirstName);

		log.info("sanity_001_RepairFlow - Step 14: open Checkin Appointment data");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("sanity_001_RepairFlow - step 15: Open Create sales order page");
		salesPage =  patientsPage.clickOnCreateSalesOrder();
		
		log.info("sanity_001_RepairFlow - step 16: Add new Repair");
		salesPage.addItemInCreateSalesOrder("Add Repair");
		
		log.info("sanity_001_RepairFlow - step 17: Select Manufacturer");
		salesPage.selectManufacturerSalesOrderRepair(manufacturer);
		
		log.info("sanity_001_RepairFlow - step 18: Select Warranty");
		salesPage.selectWarrantySalesOrderRepair("In Warranty");
		
		log.info("sanity_001_RepairFlow - step 19: Select Repair");
		salesPage.selectRepairSalesOrderRepair("intest (In Warranty)");
		
		log.info("sanity_001_RepairFlow - step 20: enter remark");
		salesPage.enterRemarkSalesOrderRepair(remark);
		
		log.info("sanity_001_RepairFlow - step 21: Click on Save button");
		salesPage.clickOnSaveButton();
		
		log.info("sanity_001_RepairFlow - step 22: Click on Repair Orders");
		salesPage.clickOnCreateRepairOrder();
		salesPage.acceptAlert(driver);
		
		log.info("sanity_001_RepairFlow - step 23: Click on Back button");
		salesPage.clickOnBackButton();
		
		log.info("sanity_001_RepairFlow - step 24: Get sale order ID");
		salesOrderID = salesPage.getSalesOrdersId();
		
		log.info("sanity_001_RepairFlow - step 25: Click on Checkout button");
		salesPage.clickOnCheckoutButton();
		
		log.info("sanity_001_RepairFlow - step 26: Open Check in tab");
		patientsPage = salesPage.selectCheckInTab();
		
		log.info("sanity_001_RepairFlow - Step 27: Expand 'Repairs' section");
		patientsPage.expandSectionOnCheckin("Repairs");
		
		log.info("VP: Repair item exists");
		verifyTrue(patientsPage.isRepairsIDExists(salesOrderID));
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
	private PatientsPage patientsPage;
	private SalesPage salesPage;
	private String organization, qaStaffUsername, password;
	private int date, month, year,correctHour, correctMinute;
	private String correctStartTime, correctEndTime;
	private String apptType, apptStatus, refResource, provider, noteContent;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	public String manufacturer, type, model, battery, cptCode, listPrice, serial;
	private String remark;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear;
	private String salesOrderID;
}
