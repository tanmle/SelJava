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

public class section_007_Inventory extends AbstractTest{

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
		serial1 = getUniqueNumber();
		serial2 = getUniqueNumber();
		serialInStock = getUniqueNumber();
		serialGadget = getUniqueNumber();
		newSerialInStock = getUniqueNumber();
		gadgetType = "remotes";
		part = "rm520 (remotes)";
		cDiscount = "Monetary";
		eDiscount = "750";
		hearingAidID = getUniqueNumber() +""+ getUniqueNumber();
		warningMessage = "Would you like to proceed this order to received stage?";
		manufacturer = "Generic";
		type = "BTE";
		model = "ABC 100 (BTE)";
		battery = "10";
		
	}
	
	@Test(groups = { "regression" },description = "Revice Order")
	public void Inventory_01_ReviceOrder()
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
		
		log.info("Inventory_01 - Step 01: Open Inventory page");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("VP: Inventory link tab 'Hearing Aid Orders' displays ");
		verifyTrue(inventoryPage.isInventoryTabLinkDisplays("Hearing Aid Orders"));
		
		log.info("VP: Inventory link tab 'Ear Mold Orders' displays ");
		verifyTrue(inventoryPage.isInventoryTabLinkDisplays("Ear Mold Orders"));
		
		log.info("VP: Inventory link tab 'Repair Orders' displays ");
		verifyTrue(inventoryPage.isInventoryTabLinkDisplays("Repair Orders"));
		
		log.info("VP: Inventory link tab 'Gadget Orders' displays ");
		verifyTrue(inventoryPage.isInventoryTabLinkDisplays("Gadget Orders"));
		
		log.info("VP: Inventory link tab 'Serialized Items' displays ");
		verifyTrue(inventoryPage.isInventoryTabLinkDisplays("Serialized Items"));
		
		log.info("Inventory_01 - Step 02: Select office for search Hearing Aid Orders");
		inventoryPage.selectOfficeSearchOrder(officeInfo);
		
		log.info("Inventory_01 - Step 03: Enter Patient Last Name for search Hearing Aid Orders");
		inventoryPage.enterPatientLastNameSearchOrder(patientLastName);
		
		log.info("Inventory_01 - Step 04: Enter Patient Sales Order for search Hearing Aid Orders");
		inventoryPage.enterSalesOrderIDSearchOrder(salesOrderID);
		
		log.info("Inventory_01 - Step 05: Click on search button for search Hearing Aid Orders item");
		inventoryPage.clickOnSearchButton();
		
		log.info("VP: Verify Hearing Aid Orders item");
		verifyTrue(inventoryPage.isHearingAidOrdersItemDisplays(salesOrderID));
		
		log.info("Inventory_01 - Step 06: Select first Hearing Aid Orders item");
		inventoryPage.selectHearingAidOrderItem(salesOrderID);
		
		log.info("Inventory_01 - Step 07: Enter Invoice Date of Inventory Order of Hearing Aid");
		inventoryPage.enterInvoiceDateInventoryOrder(month,day,year);
		
		log.info("Inventory_01 - Step 08: Enter Manufacturer Invoice of Inventory Order of Hearing Aid");
		inventoryPage.enterManufacturerInvoiceInventoryOrder(manufacturerInvoice);
		
		log.info("Inventory_01 - Step 09: Enter Serial Order Item Ear Left");
		inventoryPage.enterSerialHearingOrderItemEarLeft(serial1);
		
		log.info("Inventory_01 - Step 10: Enter Serial Order Item Ear Right");
		inventoryPage.enterSerialHearingOrderItemEarRight(serial2);
		
		log.info("Inventory_01 - Step 11: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarRight(month,day,year);
		
		log.info("Inventory_01 - Step 12: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarLeft(month,day,year);
		
		log.info("Inventory_01 - Step 13: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarRight(month,day,year);
		
		log.info("Inventory_01 - Step 14: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarLeft(month,day,year);
		
		log.info("Inventory_01 - Step 15: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Ordered");
		
		log.info("Inventory_01 - Step 16: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("VP: Warnint message show");
		verifyTrue(inventoryPage.isWarningProceedOrderToReceivedDisplays());
		
		log.info("Inventory_01 - Step 17: Click on Yes accpect warning messages");
		inventoryPage.selectYesProceedOrderReceivedButton();
		
		log.info("VP: Order Status change to Recived");
		verifyTrue(inventoryPage.isOrderStatusLabelCorrectly("Received"));
		
		log.info("Inventory_01 - Step 18: Open Sale Order item");
		salesPage = inventoryPage.openInventorySaleOrder();
		
		log.info("VP: Left Serial displays correctly");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(serial1));
		
		log.info("VP: Right Serial displays correctly");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(serial2));
		
		log.info("Inventory_01 - Step 19: Open inventory Page");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("Inventory_01 - Step 20: Select  Gadget Order tab");
		inventoryPage.openInventoryTab("Gadget Orders");
		
		log.info("Inventory_01 - Step 21: Select office for search Gadget Orders");
		inventoryPage.selectOfficeSearchOrder(officeInfo);
		
		log.info("Inventory_01 - Step 22: Enter Patient Last Name for search Gadget Orders");
		inventoryPage.enterPatientLastNameSearchOrder(patientLastName);
		
		log.info("Inventory_01 - Step 23: Enter Patient Sale Order for search Gadget Orders");
		inventoryPage.enterSalesOrderIDSearchOrder(salesOrderID);
		
		log.info("Inventory_01 - Step 24: click on search Gadget Orders");
		inventoryPage.clickOnSearchButton();
		
		log.info("Inventory_01 - Step 25: Select first Gadget Orders item");
		inventoryPage.selectGadgetOrderItem(salesOrderID);
		
		log.info("Inventory_01 - Step 22: Enter Invoice Date of Inventory Order of Gadget");
		inventoryPage.enterInvoiceDateInventoryOrder(month,day,year);
		
		log.info("Inventory_01 - Step 23: Enter Manufacturer Invoice of Inventory Order of Gadget");
		inventoryPage.enterManufacturerInvoiceInventoryOrder(manufacturerInvoice);
		
		log.info("Inventory_01 - Step 24: Enter Serial Order Item Gadget");
		inventoryPage.enterSerialOrderItemGadget(serialGadget);
		
		log.info("Inventory_01 - Step 25: Enter Manufacturer Warranty Time Gadget ");
		inventoryPage.enterManufacturerWarrantyGadget(month,day,year);
		
		log.info("Inventory_01 - Step 26: Enter Loss and Damage Time Gadget ");
		inventoryPage.enterLossDamageGadget(month,day,year);
		
		log.info("Inventory_01 - Step 27: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Ordered");
		
		log.info("Inventory_01 - Step 28: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("Inventory_01 - Step 29: Click on Yes accpect warning messages");
		inventoryPage.selectYesProceedOrderReceivedButton();
		
		log.info("Inventory_01 - Step 30: Open Sale Order item");
		salesPage = inventoryPage.openInventorySaleOrder();
		
		log.info("VP: Left Serial displays correctly");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(serialGadget));
		
		log.info("VP:Hearing Ear Left Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(serial1, "Ready to Deliver"));
		
		log.info("VP: Hearing Ear Right Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(serial2, "Ready to Deliver"));
		
		log.info("VP: Gadget Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(serialGadget, "Ready to Deliver"));
	}
	
	@Test(groups = { "regression" },description = "Add Stock Inventory")
	public void Inventory_02_AddStockInventory()
	{
		log.info("Inventory_02 - Step 01: Open Inventory page");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("Inventory_02 - Step 02: Select Serialized Items tab");
		inventoryPage.openInventoryTab("Serialized Items");
		
		log.info("Inventory_02 - Step 03: Click on new button");
		inventoryPage.clickOnNewButton();
		
		log.info("Inventory_02 - Step 04: select Office item");
		inventoryPage.selectOfficeSerializedDetails("Henderson Ear Aloha - Henderson, NV");
		
		log.info("Inventory_02 - Step 05: select Office item");
		inventoryPage.selectProductCategorySerialDetails("Hearing Aid");
		
		log.info("Inventory_02 - Step 06: select Office item");
		inventoryPage.selectManufacturerCategorySerialDetails("Generic");
		
		log.info("Inventory_02 - Step 07: select Product type");
		inventoryPage.selectProductTypeDetails("BTE");
		
		log.info("Inventory_02 - Step 08: select Office item");
		inventoryPage.selectProductSerialDetails("ABC 100 (BTE)");
		
		log.info("Inventory_02 - Step 09: select Office item");
		inventoryPage.selectInventoryTypeSerialDetails("In Stock");
		
		log.info("Inventory_02 - Step 10: select Office item");
		inventoryPage.enterSerialDetails(serialInStock);
		
		log.info("Inventory_02 - Step 11: click On Save And Add New button");
		inventoryPage.clickOnSaveAndAddNewButton();
		
		log.info("Inventory_02 - Step 12: select Office item");
		inventoryPage.enterSerialDetails(newSerialInStock);
		
		log.info("Inventory_02 - Step 13: click On Save button");
		inventoryPage.clickOnSaveButton();
		
		log.info("Inventory_02 - Step 14: Open Inventory page");
		inventoryPage.openInventoryPage(driver, ipClient);
		
		log.info("Inventory_02 - Step 15: Select Serialized Items tab");
		inventoryPage.openInventoryTab("Serialized Items");
		
		log.info("Inventory_02 - Step 16: Select Serialized Office Items");
		inventoryPage.selectOfficeSerializedItem("Henderson Ear Aloha - Henderson, NV");
		
		log.info("Inventory_02 - Step 17: Select Inventory Type");
		inventoryPage.selectInventoryTypeSerializedItem("In Stock");
		
		log.info("Inventory_02 - Step 18: Click on search button");
		inventoryPage.clickOnSearchSerializedButton();
		
		log.info("VP: Search result list displays");
		verifyTrue(inventoryPage.isSearchSerializedItemDisplays());
		
		log.info("Inventory_02 - Step 19: Open Inventory page");
		inventoryPage.openInventoryPage(driver, ipClient);
		
		log.info("Inventory_02 - Step 20: Select Serialized Items tab");
		inventoryPage.openInventoryTab("Serialized Items");
		
		log.info("Inventory_02 - Step 21: Select Office Serialized Items tab");
		inventoryPage.selectOfficeSerializedItem("Henderson Ear Aloha - Henderson, NV");
		
		log.info("Inventory_02 - Step 22: Select Inventory Type Serialized Items tab");
		inventoryPage.selectInventoryTypeSerializedItem("In Stock");
		
		log.info("Inventory_02 - Step 23: Select  Product Category Serialized Items tab");
		inventoryPage.selectProductCategorySerializedItem("Hearing Aid");
		
		log.info("Inventory_02 - Step 24: Select Manufacturer Serialized Items tab");
		inventoryPage.selectManufacturerSerializedItem("Generic");
		
		log.info("Inventory_02 - Step 25: Select Manufacturer Serialized Items tab");
		inventoryPage.enterSerialSerializedItem(newSerialInStock);
		
		log.info("Inventory_02 - Step 26: Click on search button");

		inventoryPage.clickOnSearchSerializedButton();
		
		log.info("Inventory_02 - Step 27: Open Stock Inventory item");
		inventoryPage.openStockInventoryItem(newSerialInStock);
		
		log.info("VP: Return for Credit button displays");
		verifyTrue(inventoryPage.isStockInventoryItemDisplays(newSerialInStock));
		
		log.info("Inventory_02 - Step 28: Open Sale page");
		salesPage = inventoryPage.openSalesPage(driver, ipClient);
		
		log.info("Inventory_02 - Step 29: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Inventory_02 - Step 30: Select Patient name");
		salesPage.selectPatient(patient);
		
		log.info("Inventory_02 - Step 31: Select Provider");
		salesPage.selectProvider("Jones, Tom");
		
		log.info("Inventory_02 - Step 32: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Inventory_02 - Step 33: Get Sale order id");
		inventorySalesOrderID = salesPage.getSalesOrdersId();
		
		log.info("Inventory_02 - Step 34: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");
		
		log.info("Inventory_02 - Step 35: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar("Generic", "BTE", "ABC 100 (BTE)", "10");
		
		log.info("VP: Return for Credit button displays");
		verifyTrue(salesPage.isLeftInventoryNumberDisplays());
		
		log.info("Inventory_02 - Step 36: Enter Left Ear");
		salesPage.clickOnBinauralButton();
		salesPage.acceptAlert(driver);
		
		log.info("Inventory_02 - Step 37: click Save");
		salesPage.clickOnSaveButton();
		
		log.info("Inventory_02 - Step 38: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);
		
		log.info("Inventory_02 - Step 39: Open Inventory page");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("Inventory_02 - Step 40: Select Manufacturer Serialized Items tab");
		inventoryPage.enterSalesOrderIDSearchOrder(inventorySalesOrderID);
		
		log.info("Inventory_02 - Step 41: Click on search button");
		inventoryPage.clickOnSearchButton();
		
		log.info("Inventory_02 - Step 42: Select first Hearing Aid Orders item");
		inventoryPage.selectHearingAidOrderItem(inventorySalesOrderID);
		
		log.info("Inventory_02 - Step 43: Enter Serial Order Item Ear Left");
		inventoryPage.enterSerialHearingOrderItemEarLeft(serialInStock);
		
		log.info("Inventory_02 - Step 44: Enter Serial Order Item Ear Right");
		inventoryPage.enterSerialHearingOrderItemEarRight(serialInStock);
		
		log.info("Inventory_02 - Step 45: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Received");
		
		log.info("Inventory_02 - Step 46: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("VP: Warning message duplicate serial numbers");
		verifyTrue(inventoryPage.isWaningMessageDuplicateSerialDisplays());
	
		log.info("Inventory_02 - Step 47: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Canceled");
		
		log.info("Inventory_02 - Step 48: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("Inventory_02 - Step 49: Open Sale order page");
		salesPage = inventoryPage.openSalesPage(driver, ipClient);
		
		log.info("Inventory_02 - Step 50: Search Sale order item");
		salesPage.searchOrderItem(inventorySalesOrderID);
		
		log.info("Inventory_02 - Step 51: Open Sale order item");
		salesPage.openListOrderItem(inventorySalesOrderID);
		
		log.info("Inventory_02 - Step 52: Check out Sale order");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);
		
		log.info("Inventory_02 - Step 53: Click on return button");
		salesPage.clickOnReturnButton();
		
		log.info("Inventory_02 - Step 54: Select sale order item return");
		salesPage.selectSaleOrderReturnTo("L - ABC 100","Manufacturer");
		salesPage.selectSaleOrderReturnTo("R - ABC 100","Manufacturer");
		
		log.info("Inventory_02 - Step 55: Click on Save and return button");
		salesPage.clickOnSaveReturnButton();
		
		log.info("Inventory_02 - Step 56: Click on Create Invoice button");
		salesPage.clickOnCreateInvoiceButton();
		salesPage.acceptAlert(driver);
		
		log.info("VP: Create invoice success");
		verifyTrue(salesPage.isCreateInvoiceSuccess());
		
		log.info("Inventory_02 - Step 57: Open Sale order");
		salesPage.openSalesPage(driver, address);
		
		log.info("Inventory_02 - Step 58: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Inventory_02 - Step 59: Select Patient name");
		salesPage.selectPatient(patient);
		
		log.info("Inventory_02 - Step 60: Select Provider");
		salesPage.selectProvider("Jones, Tom");
		
		log.info("Inventory_02 - Step 61: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Inventory_02 - Step 62: Get Sale order id");
		salesPage.getSalesOrdersId();
		
		log.info("Inventory_02 - Step 63: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");
		
		log.info("Inventory_02 - Step 64: click on from stock button");
		salesPage.clickOnFromStockButton();
		driver = salesPage.switchToLeftFromStockFrame(driver);
		
		log.info("Inventory_02 - Step 65: select serial stock");
		salesPage.selectSerialStock(newSerialInStock);
		
		log.info("Inventory_02 - Step 66: Click on Select button");
		salesPage.clickOnSelectButton();
		driver = salesPage.switchToTopWindowFrame(driver);

		log.info("VP: Right Ear overwrite left ear");
		verifyTrue(salesPage.isStockEnterLeftEar(manufacturer, type, model, newSerialInStock));
		
		log.info("Inventory_02 - Step 67: click Save");
		salesPage.clickOnSaveButton();
		
		log.info("Inventory_02 - Step 68: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);
		
		log.info("Inventory_02 - Step 69: back create sales order page");	
		salesPage.clickOnBackButton();
		
		log.info("Inventory_02 - Step 70: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);
		
		log.info("VP: Verify Check out success");
		verifyTrue(salesPage.isCheckOutSaleOrderSuccess());
	}
	
	@Test(groups = { "regression" },description = "Direct Enter Products")
	public void Inventory_03_DirectEnterProducts()
	{
		log.info("Inventory_03 - Step 01: Open patient page");
		patientsPage = salesPage.openPatientsPage(driver, ipClient);
		
		log.info("Inventory_03 - Step 02: Open patients details");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		patientsPage.clickOKButton();
		
		log.info("Inventory_03 - Step 03: expand Hearing Aids Section");
		patientsPage.expandSectionOnCheckin("Hearing Aids");
		
		log.info("Inventory_03 - Step 04: select add new Hearing aid");
		patientsPage.clickNewHearingAidsRecordButton();
		
		log.info("Inventory_03 - Step 05: enter Hearing Purchase Date");
		patientsPage.enterHearingPurchaseDate(month,day,year);
		
		log.info("Inventory_03 - Step 06: select status Hearing aid");
		patientsPage.selectStatusHearingAid("Current");
		
		log.info("Inventory_03 - Step 07: select Manufacturer Hearing aid");
		patientsPage.selectManufacturerHearingAid("Generic");
		
		log.info("Inventory_03 - Step 08: select Type Hearing aid");
		patientsPage.selectTypeHearingAid("BTE");
		
		log.info("Inventory_03 - Step 09: select Model Hearing aid");
		patientsPage.selectModelHearingAid("ABC 100 (BTE)");
		
		log.info("Inventory_03 - Step 10: select Type Serial Hearing aid");
		patientsPage.enterTypeSerialHearingAid(hearingAidID);
		
		log.info("Inventory_03 - Step 11: select Battery Hearing aid");
		patientsPage.selectBatteryHearingAid("10");
		
		log.info("Inventory_03 - Step 12: select Technology Hearing aid");
		patientsPage.selectTechnologyHearingAid("Digital");
		
		log.info("Inventory_03 - Step 13: Save Hearing aid");
		patientsPage.clickOnSaveButton();
		
		log.info("Inventory_03 - Step 14: Back patient");
		patientsPage.clickOnBackButton();
		
		log.info("Inventory_03 - Step 15: expand Hearing Aids Section");
		patientsPage.clickOKButton();
		patientsPage.expandSectionOnCheckin("Hearing Aids");
		
		log.info("VP: Hearing Aid add success");
		verifyTrue(patientsPage.isHearingAidItemsExists(hearingAidID));
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
	private String inventorySalesOrderID, salesOrderID, part,cDiscount,eDiscount;
	private String patient, gadgetType, address;
	public String manufacturer, type, model, battery, cptCode, listPrice ;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear, serialGadget;
	public String officeInfo, patientLastName,patientFirstName,patientName,	manufacturerInvoice;
	public String serial1,serial2,serialInStock,newSerialInStock,hearingAidID,warningMessage;
}