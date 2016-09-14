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

public class section_012_Returns extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		officeInfo = "Henderson Ear Aloha - Henderson, NV";
		patientLastName = "Russo";
		patientFirstName = "John";
		manufacturerInvoice = "W"+getUniqueNumber();
		day = Common.getCommon().getCurrentDayOfWeek();
		month = Common.getCommon().getCurrentMonthOfWeek();
		year = Common.getCommon().getCurrentYearOfWeek();
		leftHearingID = "s12_HA_L"+getUniqueNumber();
		rightHearingID ="s13_HA_R"+ getUniqueNumber();
		gadgetID = "s12_Gadget"+ getUniqueNumber();
		part = "rm520 (remotes)";
		cDiscount = "Monetary";
		eDiscount = "750";
		hearingAidID = getUniqueNumber() +""+ getUniqueNumber();
		remark = "The hearing aid seems to have static and is intermittent"+getUniqueNumber();
		manufacturer = "Generic";
		gadgetType = "remotes";
		type = "BTE";
		model = "ABC 100 (BTE)";
		battery = "10";
		secordOrderID = "S"+getUniqueNumber();
		numberCheck = getUniqueNumber();
		provider = "Needle, Space";
		address = "5203 SE Tanner Ct.";
		city = "Portland";
		state = "OR - Oregon";
		zipCode = "42397";
		totalAmount = "5067.00";
		creditCardType = "Visa";
		creditCardNumber = "4012888888881881";
		creditCardName = "Udi Team "+getUniqueNumber();
		creditMonth = "Dec";
		creditYear = Common.getCommon().getCurrentYear()+"";
		refNumber = "";
	}
	
	@Test(groups = { "regression" },description = "Return a Sale Order")
	public void Return_01_SaleOrder()
	{
		log.info("Pre-Condition - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Pre-Condition - Step 02: Open Sales page");
		salesPage = schedulePage.openSalesPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 03: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Pre-Condition - Step 04: Select Patient name");
		salesPage.selectPatient("Russo, John");
		
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
		
		log.info("Pre-Condition - Step 50: Open Sale Order item");
		salesPage = inventoryPage.openInventorySaleOrder();
		
		log.info("Pre-Condition - Step 51: Click on Deliver button");
		salesPage.clickOnDeliverButton();
		
		log.info("Pre-Condition - Step 52: Click on Deliver button");
		salesPage.switchToDeliverFrame(driver);
		
		log.info("Pre-Condition - Step 53: Select Delevery method");
		salesPage.selectDeliveryMethodOnDeliverDialog("Customer Pickup");
		
		log.info("Pre-Condition - Step 54: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
		
		log.info("Pre-Condition - Step 55: Click Collect Check/Cash Payment button");
		billingPage = salesPage.clickOnCheckCashPaymentButton();
		
		log.info("Pre-Condition - Step 56: Select Payment method");
		billingPage.selectPaymentsMethod("Check");
		
		log.info("Pre-Condition - Step 57: Enter check number");
		billingPage.enterCheckNumber(numberCheck);
		
		log.info("Pre-Condition - Step 58: get Patient balance");
		patientBlance = billingPage.getPatientBlance();
		
		log.info("Pre-Condition - Step 59: Enter amount");
		billingPage.enterPaymentAmount(patientBlance);
		
		log.info("Pre-Condition - Step 60: Enter remark");
		billingPage.enterPaymentRemark(remark);
		
		log.info("Pre-Condition - Step 61: click on Save button");
		billingPage.clickOnSave();
		
		log.info("Pre-Condition - Step 62: click on back button");
		salesPage = billingPage.clickOnBackSalesOrder();
		
		log.info("Return_01 - Step 01: Click Return button");
		salesPage.clickOnReturnButton();
		
		log.info("Return_01 - Step 02: Select Return to Left Hearing Aid");
		salesPage.selectSaleOrderReturnTo(leftHearingID,"Manufacturer");
		
		log.info("Return_01 - Step 03: Select Return to Right Hearing Aid");
		salesPage.selectSaleOrderReturnTo(rightHearingID,"Manufacturer");
		
		log.info("Return_01 - Step 04: Select Return to Gadget");
		salesPage.selectSaleOrderReturnTo(gadgetID,"Manufacturer");
		
		log.info("Return_01 - Step 05: Click on Save and return button");
		salesPage.clickOnSaveReturnButton();
		
		log.info("VP: Balance displays correctly");
		verifyTrue(salesPage.isBalanceDisplaysCorrect(patientBlance));
	}
	@Test(groups = { "regression" },description = "Refund")
	public void Return_02_Refund()
	{
		log.info("Return_02 - Step 01: Return Sale page");
		salesPage.openSalesPage(driver, ipClient);
		
		log.info("Return_02 - Step 02: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Return_02 - Step 03: Select Patient name");
		salesPage.selectPatient("Russo, John");
		
		log.info("Return_02 - Step 04: Select Provider");
		salesPage.selectProvider(provider);
		
		log.info("Return_02 - Step 05: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Return_02 - Step 06: Add item Patient service");
		salesPage.addItemInCreateSalesOrder("Add Patient Service");
		
		log.info("Return_02 - Step 07: Add item Patient service");
		salesPage.selectServiceInPatientService("service free (Service)");
		
		log.info("Return_02 - Step 08: Enter list Price");
		salesPage.enterListPriceInPatientService("500");
		
		log.info("Return_02 - Step 09: Click on Save and return Sale Order");
		salesPage.clickOnSaveReturnSaleOrder();
		
		log.info("Return_02 - Step 10: get Sales Order ID");
		salesOrderPatientServiceID = salesPage.getSalesOrdersId();
		
		log.info("Return_02 - Step 11: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);
		
		log.info("Return_02 - Step 12: Return Sale page");
		salesPage.openSalesPage(driver, ipClient);
		
		log.info("Return_02 - step 13: Search Orders created");
		salesPage.searchOrderItem(salesOrderID);
		
		log.info("Return_02 - step 14: Open order item");
		salesPage.openListOrderItem(salesOrderID);
		
		log.info("Return_02 - step 15: get Total price ");
		salesPage.getTotalPrice();
		
		log.info("Return_02 - step 16: click on 'Collect CC Payments' ");
		billingPage = salesPage.clickOnCollectCCPayments();
		
		log.info("Return_02 - step 17: enter credit card details");
		billingPage.enterCreditCardDetails(creditCardType, creditCardNumber, creditCardName, creditMonth, creditYear);
		
		log.info("Return_02 - step 18: enter billing address ");
		billingPage.enterCreditBillingAddress(address, city, state, zipCode);
		
		log.info("Return_02 - step 19: enter Transaction details ");
		billingPage.enterTransactionDetails(totalAmount, refNumber, remark);
		
		log.info("Return_02 - step 20: click on Apply Change");
		billingPage.clickOnApplyChange();
		
		log.info("Return_02 - step 21: Open billing page");
		billingPage.openBillingPage(driver, ipClient);
		
		log.info("Return_02 - step 22: Select credit card tab");
		billingPage.selectBillingTab("Credit Card");
		
		log.info("Return_02 - step 23: Enter change date");
		billingPage.enterChangeDate(month+"/"+day+"/"+year);
		
		log.info("Return_02 - step 23: Enter change date");
		billingPage.enterNameCard(creditCardName);
		
		log.info("Return_02 - step 24: Enter Amount ");
		billingPage.enterAmount(totalAmount);
		
		log.info("Return_02 - step 25: Click on search button");
		billingPage.clickOnSearchButton();
		
		log.info("Return_02 - step 26: Select Transactions by credit card name ");
		billingPage.selectTransactionByCreditCardName(creditCardName);
		
		log.info("Return_02 - step 27: Click on refund link");
		billingPage.clickOnRefurdButton();
		
		log.info("Return_02 - step 28: Click on refund link");
		paymentAmount = billingPage.getTotalAmount();
		
		log.info("Return_02 - step 29: Enter total amount");
		billingPage.enterChangeTotalAmount(paymentAmount);
		
		log.info("Return_02 - step 30: Click on  Apply refund");
		billingPage.clickOnApplyChange();
		
		log.info("Return_02 - step 31: Back to sale order");
		salesPage = billingPage.clickOnBackSalesOrder();
		
		log.info("Return_02 - step 32: Click on refund link");
		billingPage = salesPage.clickOnRefundButton();
		
		log.info("Return_02 - step 33: Back to sale order");
		billingPage.selectRefundMethod("Visa");

		log.info("Return_02 - step 34: Get refund payment");
		paymentRefund = billingPage.getRefundPayment();
		
		log.info("Return_02 - step 35: Enter Amount");
		billingPage.enterRefundAmount(paymentRefund);

		log.info("Return_02 - step 36: Enter remark");
		billingPage.enterRemarkSalesOrderRefund(remark);
		
		log.info("Return_02 - step 37: Save Refund");
		billingPage.clickOnSaveButton();
		
		log.info("Return_02 - step 38: Back to Sales Order");
		salesPage = billingPage.clickOnBackSaleOrder();
		
		log.info("VP: Refund displays Payments And Adjustments");
		verifyTrue(salesPage.isPaymentItemDisplays(remark));
	}
	@Test(groups = { "regression" },description = "Apply change")
	public void Return_03_ApplyChange()
	{
		log.info("Return_03 - Step 01: Open patient page");
		patientsPage = salesPage.openPatientsPage(driver, ipClient);
		
		log.info("Return_03 - Step 02: Search for a patient");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		patientsPage.clickOKButton();
		
		log.info("Return_03 - Step 03: expand Invoices/Sales Orders Section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("Return_03 - Step 04: open Invoice Sales order item");
		salesPage = patientsPage.viewInvoicesSalesOrdersDetail(salesOrderPatientServiceID);
		
		log.info("Return_03 - Step 05 click on Apply Credit button");
		salesPage.clickOnApplyCreditsButton();
		
		log.info("Return_03 - Step 06 Get credit amount");
		salesPage.getCreditAmount();
		
		log.info("Return_03 - Step 07: Select Order");
		salesPage.selectExchangeOrder(salesOrderID);
		
		log.info("Return_03 - Step 08: click on Save and Apply button");
		salesPage.clickSaveAndApplyCreditsButton();
		
		log.info("Return_03 - Step 09: Click on Back button");
		salesPage.clickOnBackSaleOrder();
		
		log.info("Return_03 - Step 10: Open patient page");
		patientsPage = salesPage.openPatientsPage(driver, ipClient);
		
		log.info("Return_03 - Step 11: Search for a patient");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		patientsPage.clickOKButton();
		
		log.info("Return_03 - Step 12: expand Invoices/Sales Orders Section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("VP: Invoide's Balace display correct");
		verifyTrue(patientsPage.isInvoiceSaleOrderBalanceCorrectly(salesOrderID,"$792.00"));
	}
	@Test(groups = { "regression" },description = "Cancelled Orders & Inventory")
	public void Return_04_CancelOrderInventory()
	{
		log.info("Pre-Condition - Step 01: Open Sales page");
		salesPage = schedulePage.openSalesPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 02: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Pre-Condition - Step 03: Select Patient name");
		salesPage.selectPatient("Russo, John");
		
		log.info("Pre-Condition - Step 04: Select Provider");
		salesPage.selectProvider(provider);
		
		log.info("Pre-Condition - Step 05: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 06: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");
		
		log.info("Pre-Condition - Step 07: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar(manufacturer, type, model, battery);
		
		log.info("Pre-Condition - Step 08: Enter Left Ear");
		salesPage.selectPrincingDiscountType("Monetary");
		
		log.info("Pre-Condition - Step 09: Enter Left Ear");
		salesPage.enterPrincingDiscount("750");
		
		log.info("Pre-Condition - Step 10: Enter Left Ear");
		salesPage.clickOnBinauralButton();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - Step 11: click Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 12: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - Step 13: back create sales order page");
		salesPage.clickOnBackButton();
		
		log.info("Pre-Condition - Step 14: Add item");
		salesPage.addItemInCreateSalesOrder("Add Gadget");
		
		log.info("Pre-Condition - Step 15: Enter Gadget info");
		salesPage.enterGadgetItemsInfo(manufacturer,gadgetType,part,cDiscount,eDiscount);
		
		log.info("Pre-Condition - Step 16: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 17: click on Create Gadget Order");
		salesPage.clickCreateGadgetOrder();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - Step 18: click on Save and return Sale Order");
		salesPage.clickOnSaveReturnSaleOrder();
		
		log.info("Pre-Condition - Step 19: get Sales Order ID");
		salesOrderID = salesPage.getSalesOrdersId();
		
		log.info("Pre-Condition - Step 20: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);

		log.info("Pre-Condition - Step 21: Open Inventory page");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 22: Enter Patient Sales Order for search Hearing Aid Orders");
		inventoryPage.enterSalesOrderIDSearchOrder(salesOrderID);
		
		log.info("Pre-Condition - Step 23: Click on search button for search Hearing Aid Orders item");
		inventoryPage.clickOnSearchButton();
		
		log.info("Pre-Condition - Step 24: Select first Hearing Aid Orders item");
		inventoryPage.selectHearingAidOrderItem(salesOrderID);
		
		log.info("Pre-Condition - Step 25: Enter Invoice Date of Inventory Order of Hearing Aid");
		inventoryPage.enterInvoiceDateInventoryOrder(month,day,year);
		
		log.info("Pre-Condition - Step 26: Enter Manufacturer Invoice of Inventory Order of Hearing Aid");
		inventoryPage.enterManufacturerInvoiceInventoryOrder(manufacturerInvoice);
		
		log.info("Pre-Condition - Step 27: Enter Serial Order Item Ear Left");
		inventoryPage.enterSerialHearingOrderItemEarLeft(leftHearingID);
		
		log.info("Pre-Condition - Step 28: Enter Manufacturer Warranty Time Hearing Ear left ");
		inventoryPage.enterManufacturerWarrantyEarLeft(month,day,year);
		
		log.info("Pre-Condition - Step 29: Enter Loss and Damage Time Hearing Ear Left ");
		inventoryPage.enterLossDamageEarLeft(month,day,year);
		
		log.info("Pre-Condition - Step 30: Enter Serial Order Item Ear Right");
		inventoryPage.enterSerialHearingOrderItemEarRight(rightHearingID);
		
		log.info("Pre-Condition - Step 31: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarRight(month,day,year);
		
		log.info("Pre-Condition - Step 32: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarRight(month,day,year);
		
		log.info("Pre-Condition - Step 33: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Ordered");
		
		log.info("Pre-Condition - Step 34: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 35: Click on Yes accpect warning messages");
		inventoryPage.selectYesProceedOrderReceivedButton();
		
		log.info("Pre-Condition - Step 36: Open inventory Page");
		inventoryPage.openInventoryPage(driver, ipClient);
		
		log.info("Pre-Condition - Step 37: Enter Patient Sales Order for search Hearing Aid Orders");
		inventoryPage.enterSalesOrderIDSearchOrder(salesOrderID);
		
		log.info("Pre-Condition - Step 38: Click on search button for search Hearing Aid Orders item");
		inventoryPage.clickOnSearchButton();
		
		log.info("Pre-Condition - Step 39: Select first Hearing Aid Orders item");
		inventoryPage.selectHearingAidOrderItem(salesOrderID);
		
		log.info("Return_04 - Step 01: Select Canceled status");
		inventoryPage.selectOrderStatusInventoryOrder("Canceled");
		
		log.info("Return_04 - Step 02: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("VP: Inventory canceled");
		verifyTrue(inventoryPage.isRecordSavedSuccessfully());
		
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
	private String leftHearingID,rightHearingID, numberCheck;
	private String remark, patientBlance, gadgetType;
	public String manufacturer, type, model, battery, cptCode, listPrice, salesOrderID, part,cDiscount,eDiscount;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear, serialGadget, secordOrderID, gadgetID;
	public String officeInfo, patientLastName,patientFirstName,manufacturerInvoice;
	public String serial1,serial2,serialInStock,newSerialInStock,hearingAidID,warningMessage;
	private String provider, salesOrderPatientServiceID, paymentAmount, paymentRefund;
	private String address, city, state, zipCode, refNumber;
}