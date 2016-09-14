package section;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.BillingPage;
import page.InventoryPage;
import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SalesPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Common;
import common.Constant;

public class section_010_Exchanging extends AbstractTest{

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
		otherManufacturerInvoice = "W"+getUniqueNumber();
		day = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		leftHearingID = getUniqueNumber();
		rightHearingID = getUniqueNumber();
		otherLeftHearingID = "OL"+getUniqueNumber();
		otherRightHearingID = "OR"+getUniqueNumber();
		part = "rm520 (remotes)";
		cDiscount = "Monetary";
		eDiscount = "750";
		hearingAidID = getUniqueNumber() +""+ getUniqueNumber();
		remark = "The hearing aid seems to have static and is intermittent";
		manufacturer = "Generic";
		type = "BTE";
		gadgetType = "remotes";
		model = "ABC 100 (BTE)";
		battery = "10";
		secordOrderID = "S"+getUniqueNumber();
		gadgetID = "G"+getUniqueNumber();
		numberCheck = getUniqueNumber();
		correctHour = 16;
		correctMinute = 0;
		correctStartTime = "04:00 PM";
		startTime = "4:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Create Repairs")
	public void Exchanging_01_Exchanging()
	{
		log.info("Pre-Condition - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Repairs_01 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(day, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		schedulePage.switchToTopWindowFrame(driver);
		
		log.info("Pre-Condition - Step 02: Open Sales page");
		salesPage = schedulePage.openSalesPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 03: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Pre-Condition - Step 04: Select Patient name");
		salesPage.selectPatient(patientName);
		
		log.info("Pre-Condition - Step 05: Select Provider");
		salesPage.selectProvider(provider);
		
		log.info("Pre-Condition - Step 06: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 07: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");
		
		log.info("Pre-Condition - Step 08: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar(manufacturer, type, model, battery);
		
		log.info("Pre-Condition - Step 09: Enter Left Ear");
		salesPage.selectPrincingDiscountType("Monetary");
		
		log.info("Pre-Condition - Step 10: Enter Left Ear");
		salesPage.enterPrincingDiscount("750");
		
		log.info("Pre-Condition - Step 11: Enter Left Ear");
		salesPage.clickOnBinauralButton();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - Step 12: click Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 13: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - Step 14: back create sales order page");
		salesPage.clickOnBackButton();
		
		log.info("Pre-Condition - Step 15: Add item");
		salesPage.addItemInCreateSalesOrder("Add Gadget");
		
		log.info("Pre-Condition - Step 16: Enter Gadget info");
		salesPage.enterGadgetItemsInfo(manufacturer,gadgetType,part,cDiscount,eDiscount);
		
		log.info("Pre-Condition - Step 17: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 18: click on Create Gadget Order");
		salesPage.clickCreateGadgetOrder();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - Step 19: click on Save and return Sale Order");
		salesPage.clickOnSaveReturnSaleOrder();
		
		log.info("Pre-Condition - Step 20: get Sales Order ID");
		salesOrderID = salesPage.getSalesOrdersId();
		
		log.info("Pre-Condition - Step 21: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);

		log.info("Pre-Condition - Step 22: Open Inventory page");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 23: Enter Patient Sales Order for search Hearing Aid Orders");
		inventoryPage.enterSalesOrderIDSearchOrder(salesOrderID);
		
		log.info("Pre-Condition - Step 24: Click on search button for search Hearing Aid Orders item");
		inventoryPage.clickOnSearchButton();
		
		log.info("Pre-Condition - Step 25: Select first Hearing Aid Orders item");
		inventoryPage.selectHearingAidOrderItem(salesOrderID);
		
		log.info("Pre-Condition - Step 26: Enter Invoice Date of Inventory Order of Hearing Aid");
		inventoryPage.enterInvoiceDateInventoryOrder(month,day,year);
		
		log.info("Pre-Condition - Step 27: Enter Manufacturer Invoice of Inventory Order of Hearing Aid");
		inventoryPage.enterManufacturerInvoiceInventoryOrder(manufacturerInvoice);
		
		log.info("Pre-Condition - Step 28: Enter Serial Order Item Ear Left");
		inventoryPage.enterSerialHearingOrderItemEarLeft(leftHearingID);
		
		log.info("Pre-Condition - Step 29: Enter Manufacturer Warranty Time Hearing Ear left ");
		inventoryPage.enterManufacturerWarrantyEarLeft(month,day,year);
		
		log.info("Pre-Condition - Step 30: Enter Loss and Damage Time Hearing Ear Left ");
		inventoryPage.enterLossDamageEarLeft(month,day,year);
		
		log.info("Pre-Condition - Step 31: Enter Serial Order Item Ear Right");
		inventoryPage.enterSerialHearingOrderItemEarRight(rightHearingID);
		
		log.info("Pre-Condition - Step 32: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarRight(month,day,year);
		
		log.info("Pre-Condition - Step 33: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarRight(month,day,year);
		
		log.info("Pre-Condition - Step 34: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Ordered");
		
		log.info("Pre-Condition - Step 35: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 36: Click on Yes accpect warning messages");
		inventoryPage.selectYesProceedOrderReceivedButton();
		
		log.info("Pre-Condition - Step 37: Open inventory Page");
		inventoryPage.openInventoryPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 38: Select  Gadget Order tab");
		inventoryPage.openInventoryTab("Gadget Orders");
		
		log.info("Pre-Condition - Step 39: Enter Patient Sale Order for search Gadget Orders");
		inventoryPage.enterSalesOrderIDSearchOrder(salesOrderID);
		
		log.info("Pre-Condition - Step 40: click on search Gadget Orders");
		inventoryPage.clickOnSearchButton();
		
		log.info("Pre-Condition - Step 41: Select first Gadget Orders item");
		inventoryPage.selectGadgetOrderItem(salesOrderID);
		
		log.info("Pre-Condition - Step 42: Enter Invoice Date of Inventory Order of Gadget");
		inventoryPage.enterInvoiceDateInventoryOrder(month,day,year);
		
		log.info("Pre-Condition - Step 43: Enter Manufacturer Invoice of Inventory Order of Gadget");
		inventoryPage.enterManufacturerInvoiceInventoryOrder(manufacturerInvoice);
		
		log.info("Pre-Condition - Step 44: Enter Serial Order Item Gadget");
		inventoryPage.enterSerialOrderItemGadget(gadgetID);
		
		log.info("Pre-Condition - Step 45: Enter Manufacturer Warranty Time Gadget ");
		inventoryPage.enterManufacturerWarrantyGadget(month,day,year);
		
		log.info("Pre-Condition - Step 46: Enter Loss and Damage Time Gadget ");
		inventoryPage.enterLossDamageGadget(month,day,year);
		
		log.info("Pre-Condition - Step 47: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Ordered");
		
		log.info("Pre-Condition - Step 48: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 49: Click on Yes accpect warning messages");
		inventoryPage.selectYesProceedOrderReceivedButton();
		
		log.info("Pre-Condition - Step 50: Open Patient page");
		patientsPage = inventoryPage.openPatientsPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 51: Open patients details");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		patientsPage.clickOKButton();
		
		log.info("Pre-Condition - Step 52: expand Invoices/Sales Orders Section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("Pre-Condition - Step 53: open Invoice Sales order item");
		salesPage = patientsPage.viewInvoicesSalesOrdersDetail(salesOrderID);
		
		log.info("Pre-Condition - Step 54: Click on Deliver button");
		salesPage.clickOnDeliverButton();
		
		log.info("Pre-Condition - Step 55: switch To Deliver Frame");
		salesPage.switchToDeliverFrame(driver);
		
		log.info("Pre-Condition - Step 56: Select Delevery method");
		salesPage.selectDeliveryMethodOnDeliverDialog("Customer Pickup");
		
		log.info("Pre-Condition - Step 57: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
		
		log.info("Pre-Condition - Step 58: Click Create invoice button");
		salesPage.clickOnCreateInvoiceButton();
		
		log.info("Pre-Condition - Step 59: Click Accept alert popup");
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - Step 60: Click Collect Check/Cash Payment button");
		billingPage = salesPage.clickOnCheckCashPaymentButton();
		
		log.info("Pre-Condition - Step 61: Select Payment method");
		billingPage.selectPaymentsMethod("Check");
		
		log.info("Pre-Condition - Step 62: Enter check number");
		billingPage.enterCheckNumber(numberCheck);
		
		log.info("Pre-Condition - Step 63: get Patient balance");
		patientBlance = billingPage.getPatientBlance();
		
		log.info("Pre-Condition - Step 64: Enter amount");
		billingPage.enterPaymentAmount(patientBlance);
		
		log.info("Pre-Condition - Step 65: Enter remark");
		billingPage.enterPaymentRemark(remark);
		
		log.info("Pre-Condition - Step 66: click on Save button");
		billingPage.clickOnSave();
		
		log.info("Pre-Condition - Step 67: click on Back button");
		salesPage = billingPage.clickOnBackSalesOrder();
		////////////////////////////////
		
		log.info("Exchanging_01 - step 01: Click on 'Exchange' button");
		salesPage.clickOnExchangeButton();
		
		log.info("VP: Sales Order Left Hearing Aid displays");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(leftHearingID));
		
		log.info("VP: Sales Order Right Hearing Aid displays");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(rightHearingID));
		
		log.info("VP: Sales Order Gadget displays");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(gadgetID));
		
		log.info("Exchanging_01 - step 02: Select Sale order item return to ");
		salesPage.selectSaleOrderReturnTo(leftHearingID,"Manufacturer");
		salesPage.selectSaleOrderReturnTo(rightHearingID,"Manufacturer");	
		
		log.info("Exchanging_01 - step 03: Select Save and Select new Hearing Aid");
		salesPage.clickOnSaveSelectNewHearingAidButton();

		log.info("Exchanging_01 - step 03: Click on Save button");
		salesPage.clickOnSaveButton();
		
		log.info("Exchanging_01 - Step 04: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");
		
		log.info("Exchanging_01 - Step 05: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar(manufacturer, type, model, battery);
		
		log.info("Exchanging_01 - Step 06: Enter Left Ear");
		salesPage.selectPrincingDiscountType("Monetary");
		
		log.info("Exchanging_01 - Step 07: Enter Princing discount");
		salesPage.enterPrincingDiscount("750");
		
		log.info("Exchanging_01 - Step 08: click On Binaural Button");
		salesPage.clickOnBinauralButton();
		salesPage.acceptAlert(driver);
		
		log.info("Exchanging_01 - Step 09: click Save");
		salesPage.clickOnSaveButton();
		
		log.info("Exchanging_01 - Step 10: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);
		
		log.info("Exchanging_01 - Step 11: click Back");
		salesPage.clickOnBackButton();
		
		log.info("Exchanging_01 - Step 12: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);
		
		log.info("Exchanging_01 - Step 14: Get total price");
		totalPrice = salesPage.getTotalPrice();
		
		log.info("VP: Balance displays correctly");
		verifyTrue(salesPage.isBalanceDisplaysCorrect(totalPrice));
		
	}	
	@Test(groups = { "regression" },description = "Apply Credits")
	public void Exchanging_02_ApplyCredits()
	{
		log.info("Exchanging_02 - Step 01: Click on Apply Credits button");
		salesPage.clickOnApplyCreditsButton();
		
		log.info("Exchanging_02 - Step 02: Select Order");
		salesPage.selectExchangeOrder(salesOrderID);
		
		log.info("Exchanging_02 - Step 03: Select Order");
		salesPage.getExchangeItemPrice(salesOrderID);
		
		log.info("Exchanging_02 - Step 04: click on Save and Apply button");
		salesPage.clickSaveAndApplyCreditsButton();
		
		log.info("VP: Verify Patient Balance Displays Correctly");
		verifyTrue(salesPage.isPatientBalanceDisplaysCorrectly("0.00"));

	}
	@Test(groups = { "regression" },description = "Deliver")
	public void Exchanging_03_Deliver()
	{
		log.info("Exchanging_03 - Step 01: Click on Back button");
		salesPage.clickOnBackSaleOrder();
		
		log.info("Exchanging_03 - Step 02: Get secord sale order");
		secordOrderID = salesPage.getCheckOutSalesOrdersId();
		
		log.info("Exchanging_03 - Step 03");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("Exchanging_03 - Step 04: Enter Patient Sales Order for search Hearing Aid Orders");
		inventoryPage.enterSalesOrderIDSearchOrder(secordOrderID);
		
		log.info("Exchanging_03 - Step 05: Click on search button for search Hearing Aid Orders item");
		inventoryPage.clickOnSearchButton();
		
		log.info("Exchanging_03 - Step 06: Select first Hearing Aid Orders item");
		inventoryPage.selectHearingAidOrderItem(secordOrderID);
		
		log.info("Exchanging_03 - Step 07: Enter Invoice Date of Inventory Order of Hearing Aid");
		inventoryPage.enterInvoiceDateInventoryOrder(month,day,year);
		
		log.info("Exchanging_03 - Step 08: Enter Manufacturer Invoice of Inventory Order of Hearing Aid");
		inventoryPage.enterManufacturerInvoiceInventoryOrder(otherManufacturerInvoice);
		
		log.info("Exchanging_03 - Step 09: Enter Serial Order Item Ear Left");
		inventoryPage.enterSerialHearingOrderItemEarLeft(otherLeftHearingID);
		
		log.info("Exchanging_03 - Step 10: Enter Manufacturer Warranty Time Hearing Ear left ");
		inventoryPage.enterManufacturerWarrantyEarLeft(month,day,year);
		
		log.info("Exchanging_03 - Step 11: Enter Loss and Damage Time Hearing Ear Left ");
		inventoryPage.enterLossDamageEarLeft(month,day,year);
		
		log.info("Exchanging_03 - Step 12: Enter Serial Order Item Ear Right");
		inventoryPage.enterSerialHearingOrderItemEarRight(otherRightHearingID);
		
		log.info("Exchanging_03 - Step 13: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarRight(month,day,year);
		
		log.info("Exchanging_03 - Step 14: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarRight(month,day,year);
		
		log.info("Exchanging_03 - Step 15: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Received");
		
		log.info("Exchanging_03 - Step 16: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("Exchanging_03 - Step 18: Open Sale Order item");
		salesPage = inventoryPage.openInventorySaleOrder();
		
		log.info("Exchanging_03 - Step 19: Click on Deliver button");
		salesPage.clickOnDeliverButton();
		
		log.info("Exchanging_03 - Step 20: Click on Deliver button");
		salesPage.switchToDeliverFrame(driver);
		
		log.info("Exchanging_03 - Step 21: Select Delevery method");
		salesPage.selectDeliveryMethodOnDeliverDialog("Customer Pickup");
		
		log.info("Exchanging_03 - Step 22: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
		
		log.info("Exchanging_03 - Step 22: Select appointment");
		salesPage.selectApointment(month+"/"+day+"/"+year+" "+startTime+" ("+apptType+")");
		
		log.info("VP: Appointment displays correctly");
		verifyTrue(salesPage.isAppointmentDisplaysCorrectly(month+"/"+day+"/"+year+" "+startTime+" ("+apptType+")"));
		
		log.info("VP:Hearing Ear Left Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(otherLeftHearingID, "Current"));
		
		log.info("VP:Hearing Ear Left Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(otherRightHearingID, "Current"));
		
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
	private BillingPage billingPage;
	private int month,day,year;
	private InventoryPage inventoryPage; 
	private SalesPage salesPage;
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private String leftHearingID,rightHearingID, noteContent, numberCheck, otherManufacturerInvoice;
	private String remark, totalPrice, patientBlance, otherLeftHearingID;
	public String manufacturer, type, model, battery, cptCode, listPrice, salesOrderID, part,cDiscount,eDiscount;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear, serialGadget, secordOrderID, gadgetID, otherRightHearingID;
	public String officeInfo, patientLastName,patientFirstName,manufacturerInvoice;
	public String serial1,serial2,serialInStock,newSerialInStock,hearingAidID,warningMessage;
	private int correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider, gadgetType;
	private String correctStartTime, correctEndTime, startTime;
}