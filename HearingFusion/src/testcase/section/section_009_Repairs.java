package section;

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

public class section_009_Repairs extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		officeInfo = "Henderson Ear Aloha - Henderson, NV";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		patientLastName = "Russo";
		patientFirstName = "John";
		manufacturerInvoice = "W"+getUniqueNumber();
		day = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		leftHearingID = getUniqueNumber();
		rightHearingID = getUniqueNumber();
		part = "rm520 (remotes)";
		cDiscount = "Monetary";
		eDiscount = "750";
		hearingAidID = getUniqueNumber() +""+ getUniqueNumber();
		remark = "The hearing aid seems to have static and is intermittent";
		manufacturer = "Generic";
		type = "BTE";
		model = "ABC 100 (BTE)";
		battery = "10";
		leftHearingID = getUniqueNumber();
		rightHearingID = getUniqueNumber();
		correctHour = 16;
		correctMinute = 0;
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Create Repairs")
	public void Repairs_01_CreateRepairs()
	{
		log.info("Repairs_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Repairs_01 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(day, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("Repairs_01 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(day, month, year, apptType, patientName);
		
		log.info("Repairs_01 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("Repairs_01 - Step 05: Expand 'Hearing Aids' section");
		patientsPage.expandSectionOnCheckin("Hearing Aids");
		
		log.info("Repairs_01 - Step 06: Add new Insurance record");
		patientsPage.clickNewHearingAidsRecordButton();
		
		log.info("Repairs_01 - Step 07: Input Hearing Aid Left Ear Purchse Date");
		patientsPage.inputHearingAidsLeftEarPurchseDate(month,day,year);
		
		log.info("Repairs_01 - Step 08: Input Hearint Aids Left Ear Status");
		patientsPage.selectHearintAidsLeftEarStatus("Current");
		
		log.info("Repairs_01 - Step 09: Select Hearing Aids Left Ear Manufacturer");
		patientsPage.selectHearingAidsLeftEarManufacturer("New Brand");
		
		log.info("Repairs_01 - Step 10: Select Hearing Aids Left Ear Type");
		patientsPage.selectHearingAidsLeftEarType("CIC");
		
		log.info("Repairs_01 - Step 11: Select Hearing Aids Left Ear Model");
		patientsPage.selectHearingAidsLeftEarModel("DEB1 (CIC)");
		
		log.info("Repairs_01 - Step 12: Input Hearing Aids Left Type Searial");
		patientsPage.inputHearingAidsLeftTypeSearial(leftHearingID);
		
		log.info("Repairs_01 - Step 13: Input Hearing Aid Right Ear Purchse Date");
		patientsPage.inputHearingAidsRightEarPurchseDate(month,day,year);
		
		log.info("Repairs_01 - Step 14: Input Hearint Aids Right Ear Status");
		patientsPage.selectHearintAidsRightEarStatus("Current");
		
		log.info("Repairs_01 - Step 15: Select Hearing Aids Right Ear Manufacturer");
		patientsPage.selectHearingAidsRightEarManufacturer("New Brand");

		log.info("Repairs_01 - Step 16: Select Hearing Aids Right Ear Type");
		patientsPage.selectHearingAidsRightEarType("CIC");
		
		log.info("Repairs_01 - Step 17: Select Hearing Aids Right Ear Model");
		patientsPage.selectHearingAidsRightEarModel("DEB1 (CIC)");
		
		log.info("Repairs_01 - Step 18: Input Hearing Aids Right Type Searial");
		patientsPage.inputHearingAidsRightTypeSearial(rightHearingID);
		
		log.info("Repairs_01 - Step 19: Click Save button");
		patientsPage.clickSaveHearingAid();
		
		log.info("Repairs_01 - Step 20: Click Back button");
		patientsPage.clickOnBackButton();
		
		log.info("Repairs_01 - Step 21: open Encounter tab");
		patientsPage.openAppointmentTab("Encounter");
		
		log.info("Repairs_01 - Step 22: enter Left Ear Hearing Loss");
		patientsPage.enterEarningLoss(true,"3 Moderate","Sensorineural","gradual/flat moderate");
		
		log.info("Repairs_01 - Step 23: enter right Ear Hearing Loss");
		patientsPage.enterEarningLoss(false,"4 Moderately Severe","Sensorineural","gradual/flat moderate");
		
		log.info("Repairs_01 - step 24: Save edit infomation");
		patientsPage.clickSaveButton();
		
		log.info("Repairs_01 - step 25: Open Create sales order page");
		salesPage =  patientsPage.clickOnCreateSalesOrder();
		
		log.info("Repairs_01 - step 26: Save edit infomation");
		salesPage.addItemInCreateSalesOrder("Add Repair");
		
		log.info("Repairs_01 - step 27: Select item sales order");
		salesPage.selectItemSalesOrderRepair("(Right HA) New Brand DEB1 - "+rightHearingID);
		
		log.info("Repairs_01 - step 28: Select Manufacturer");
		salesPage.selectManufacturerSalesOrderRepair(manufacturer);
		
		log.info("Repairs_01 - step 29: Select Warranty");
		salesPage.selectWarrantySalesOrderRepair("In Warranty");
		
		log.info("Repairs_01 - step 30: Select Repair");
		salesPage.selectRepairSalesOrderRepair("intest (In Warranty)");
		
		log.info("Repairs_01 - step 31: enter remark");
		salesPage.enterRemarkSalesOrderRepair(remark);
		
		log.info("Repairs_01 - step 32: Click on Save button");
		salesPage.clickOnSaveButton();
		
		log.info("Repairs_01 - step 33: Click on Repair Orders");
		salesPage.clickOnCreateRepairOrder();
		salesPage.acceptAlert(driver);
		
		log.info("Repairs_01 - step 34: Click on Back button");
		salesPage.clickOnBackButton();
		
		log.info("Repairs_01 - step 35: Get sale order ID");
		salesOrderID = salesPage.getSalesOrdersId();
		
		log.info("Repairs_01 - step 36: Click on Checkout button");
		salesPage.clickOnCheckoutButton();
		
		log.info("Repairs_01 - step 37: Open Check in tab");
		patientsPage = salesPage.selectCheckInTab();
		
		log.info("Repairs_01 - Step 38: Expand 'Repairs' section");
		patientsPage.expandSectionOnCheckin("Repairs");
		
		log.info("VP: Repai item exists");
		verifyTrue(patientsPage.isRepairsItemExists(rightHearingID));
		
	}
	@Test(groups = { "regression" },description = "Inventory Repairs")
	public void Repairs_02_InventoryRepairs()
	{
		log.info("Repairs_02 - Step 01: Open Inventory page");
		inventoryPage = patientsPage.openInventoryPage(driver, ipClient);
		
		log.info("Repairs_02 - Step 02: Open Repairs tab");
		inventoryPage.openInventoryTab("Repair Orders");
		
		log.info("Repairs_02 - Step 03: enter Sale order ID");
		inventoryPage.enterSalesOrderIDSearchOrder(salesOrderID);
		
		log.info("Repairs_02 - Step 04: Click on search button");
		inventoryPage.clickOnSearchButton();
		
		log.info("Repairs_02 - Step 05: Open Sale order Repairs");
		inventoryPage.openRepairsItem(salesOrderID);
		
		log.info("Repairs_02 - Step 06: Select Order Status");
		inventoryPage.selectOrderStatusInventoryRepair("Received");
		
		log.info("Repairs_02 - Step 07: Select Manufacturer Warranty");
		inventoryPage.enterManufacturerWarrantyRepair(month,day,year);
		
		log.info("Repairs_02 - Step 08: click On Save button");
		inventoryPage.clickOnSaveButton();
		
		log.info("Repairs_02 - Step 09: Open Sale Order Repair");
		salesPage = inventoryPage.openSaleOrderRepairs();
		
		log.info("VP: Sales Order repairs item Ready to Deliver");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(rightHearingID, "Ready to Deliver"));
		
	}
	@Test(groups = { "regression" },description = "Deliver Repairs")
	public void Repairs_03_DeliverRepairs()
	{
		log.info("Repairs_03 - Step 01: Click Deliver button");
		salesPage.clickOnDeliverButton();
		
		log.info("Repairs_03 - Step 02: Click on Deliver button");
		salesPage.switchToDeliverFrame(driver);
		
		log.info("Repairs_03 - Step 03: Select Delevery method");
		salesPage.selectDeliveryMethodOnDeliverDialog("Customer Pickup");
		
		log.info("Repairs_03 - Step 04: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
		
		log.info("VP:Hearing Ear Left Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(rightHearingID, "Current"));
		
		log.info("Post-Condition - Step 01: Open ");
		schedulePage = salesPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("Post-Condition - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(day, month, year, apptType, patientName);
		
		log.info("Post-Condition - Step 03: Delete appointment");
		schedulePage.deleteAppointment();
		
		log.info("Post-Condition - Step 04: Switch frame to Top Window");
		schedulePage.switchToTopWindowFrame(driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private int month,day,year;
	private InventoryPage inventoryPage; 
	private SalesPage salesPage;
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private String leftHearingID,rightHearingID, noteContent;
	private String remark;
	public String manufacturer, type, model, battery, cptCode, listPrice, salesOrderID, part,cDiscount,eDiscount;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear, serialGadget;
	public String officeInfo, patientLastName,patientFirstName,manufacturerInvoice;
	public String serial1,serial2,serialInStock,newSerialInStock,hearingAidID,warningMessage;
	private int correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
}
