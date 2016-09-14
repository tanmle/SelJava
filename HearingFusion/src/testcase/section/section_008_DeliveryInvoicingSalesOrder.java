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

public class section_008_DeliveryInvoicingSalesOrder extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		officeInfo = "Henderson Ear Aloha - Henderson, NV";
		patientLastName = "Baker";
		patientFirstName = "Mark";
		patientName = "Baker, Mark";
		manufacturerInvoice = "W"+getUniqueNumber();
		patient = "Baker, Mark (NickName 5908)";
		day = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		leftHearingID = getUniqueNumber();
		rightHearingID = getUniqueNumber();
		gadgetID = getUniqueNumber();
		numberCheck = getUniqueNumber();
		gadgetType = "remotes";
		part = "rm520 (remotes)";
		cDiscount = "Monetary";
		eDiscount = "750";
		hearingAidID = getUniqueNumber() +""+ getUniqueNumber();
		remark = "HA Pay -Remaining payments recived -JS";
		manufacturer = "Generic";
		type = "BTE";
		model = "ABC 100 (BTE)";
		battery = "10";
	}
	
	@Test(groups = { "regression" },description = "Ready Deliver Notice popup")
	public void Delivery_01_ReadyDeliverNotice()
	{
		log.info("Pre-Condition - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Pre-Condition - Step 02: Open Sales page");
		salesPage = schedulePage.openSalesPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 03: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Pre-Condition - Step 04: Select Patient name");
		salesPage.selectPatient(patient);
		
		log.info("Pre-Condition - Step 05: Select Provider");
		salesPage.selectProvider("Jones, Tom");
		
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
		
		log.info("Delivery_01 - Step 01: Open Patient page");
		patientsPage = inventoryPage.openPatientsPage(driver, ipClient);
		
		log.info("Delivery_01 - Step 02: Open patients details");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		
		log.info("VP: Ready Delivery notice Sale order item displays");
		verifyTrue(patientsPage.isReadyDeliveryNoticeSaleOrderItemDisplays(salesOrderID));
		patientsPage.clickOKButton();
	}
	@Test(groups = { "regression" },description = "Ready Deliver Notice popup")
	public void Delivery_02_DeliverSaleOrder()
	{
		log.info("Delivery_02 - Step 01: expand Invoices/Sales Orders Section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("Delivery_02 - Step 02: open Invoice Sales order item");
		salesPage = patientsPage.viewInvoicesSalesOrdersDetail(salesOrderID);
		
		log.info("Delivery_02 - Step 03: Click on Deliver button");
		salesPage.clickOnDeliverButton();
		
		log.info("Delivery_02 - Step 04: Click on Deliver button");
		salesPage.switchToDeliverFrame(driver);
		
		log.info("VP: Ready Delivery notice Sale order item displays");
		verifyTrue(salesPage.isDeliveryDateCorrect(month,day,year));
		
		log.info("Delivery_02 - Step 05: Select Delevery method");
		salesPage.selectDeliveryMethodOnDeliverDialog("Customer Pickup");
		
		log.info("Delivery_02 - Step 06: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
		
		log.info("VP:Hearing Ear Left Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(leftHearingID, "Current"));
		
		log.info("VP: Hearing Ear Right Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(rightHearingID, "Current"));
		
		log.info("VP: Gadget Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(gadgetID, "Current"));
	}
	@Test(groups = { "regression" },description = "Create invoice")
	public void Delivery_03_CreateInvoice()
	{
		log.info("Delivery_03 - Step 01: Click Create invoice button");
		salesPage.clickOnCreateInvoiceButton();
		
		log.info("Delivery_03 - Step 02: Click Accept alert popup");
		salesPage.acceptAlert(driver);
		
		log.info("VP: Create invoice success");
		verifyTrue(salesPage.isCreateInvoiceSuccess());
	}
	@Test(groups = { "regression" },description = "Collect Check Cash Payment")
	public void Delivery_04_CollectCheckCashPayment()
	{
		log.info("Delivery_04 - Step 01: Click Collect Check/Cash Payment button");
		billingPage = salesPage.clickOnCheckCashPaymentButton();
		
		log.info("Delivery_04 - Step 02: Select Payment method");
		billingPage.selectPaymentsMethod("Check");
		
		log.info("Delivery_04 - Step 03: Enter check number");
		billingPage.enterCheckNumber(numberCheck);
		
		log.info("Delivery_04 - Step 04: get Patient balance");
		patientBlance = billingPage.getPatientBlance();
		
		log.info("Delivery_04 - Step 05: Enter amount");
		billingPage.enterPaymentAmount(patientBlance);
		
		log.info("Delivery_04 - Step 06: Enter remark");
		billingPage.enterPaymentRemark(remark);
		
		log.info("Delivery_04 - Step 07: click on Save button");
		billingPage.clickOnSave();
		
		log.info("Delivery_04 - Step 08: click on back button");
		salesPage = billingPage.clickOnBackSalesOrder();
		
		log.info("VP: Paid label displays correctly");
		verifyTrue(salesPage.isPaidDisplaysCorrect(patientBlance));
		
		log.info("VP: Balance label displays correctly");
		verifyTrue(salesPage.isBalanceDisplaysCorrect("0.00"));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private int month,day,year;
	private InventoryPage inventoryPage; 
	private SalesPage salesPage;
	private BillingPage billingPage;
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private String leftHearingID,rightHearingID,gadgetID;
	private String patient, gadgetType, numberCheck, patientBlance,remark;
	public String manufacturer, type, model, battery, cptCode, listPrice, salesOrderID, part,cDiscount,eDiscount;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear, serialGadget;
	public String officeInfo, patientLastName,patientFirstName,patientName,	manufacturerInvoice;
	public String serial1,serial2,serialInStock,newSerialInStock,hearingAidID,warningMessage;
}