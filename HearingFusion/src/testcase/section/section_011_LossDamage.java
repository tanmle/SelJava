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

public class section_011_LossDamage extends AbstractTest{

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
		day = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		leftHearingID = "s11_HA_L"+getUniqueNumber();
		rightHearingID ="s11_HA_R"+ getUniqueNumber();
		releftHearingID = "s11_HA_rL"+ getUniqueNumber();
		part = "rm520 (remotes)";
		cDiscount = "Monetary";
		eDiscount = "750";
		hearingAidID = getUniqueNumber() +""+ getUniqueNumber();
		remark = "The hearing aid seems to have static and is intermittent";
		manufacturer = "Generic";
		type = "BTE";
		model = "ABC 100 (BTE)";
		battery = "10";
		secordOrderID = "S"+getUniqueNumber();
		numberCheck = getUniqueNumber();
		provider = "Needle, Space";
	}
	
	@Test(groups = { "regression" },description = "Loss Damage a Sale Order")
	public void LossDamage_01_LossDamage()
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
		
		log.info("Pre-Condition - Step 29: Enter Serial Order Item Ear Right");
		inventoryPage.enterSerialHearingOrderItemEarRight(rightHearingID);
		
		log.info("Pre-Condition - Step 30: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarRight(month,day,year);
		
		log.info("Pre-Condition - Step 31: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarLeft(month,day,year);
		
		log.info("Pre-Condition - Step 32: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarRight(month,day,year);
		
		log.info("Pre-Condition - Step 33: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarLeft(month,day,year);
		
		log.info("Pre-Condition - Step 34: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Ordered");
		
		log.info("Pre-Condition - Step 35: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("Pre-Condition - Step 36: Click on Yes accpect warning messages");
		inventoryPage.selectYesProceedOrderReceivedButton();
		
		log.info("Pre-Condition - Step 37: Open Sale Order item");
		salesPage = inventoryPage.openInventorySaleOrder();
		
		log.info("Pre-Condition - Step 38: Click on Deliver button");
		salesPage.clickOnDeliverButton();
		
		log.info("Pre-Condition - Step 39: Click on Deliver button");
		salesPage.switchToDeliverFrame(driver);
		
		log.info("Pre-Condition - Step 40: Select Delevery method");
		salesPage.selectDeliveryMethodOnDeliverDialog("Customer Pickup");
		
		log.info("Pre-Condition - Step 41: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
		
		log.info("LossDamage_01 - Step 01: Open patient page");
		patientsPage = salesPage.openPatientsPage(driver, ipClient);
		
		log.info("LossDamage_01 - Step 02: Search for a patient");
		patientsPage.openPatientByName(patientLastName,patientFirstName);
		patientsPage.clickOKButton();
		
		log.info("LossDamage_01 - Step 03: Click on Loss and Damage button");
		salesPage = patientsPage.clickOnLossDamageButton();
		
		log.info("LossDamage_01 - Step 04: select an Hearing Aid item");
		salesPage.selectHearingAidLossDamage(leftHearingID);
		
		log.info("LossDamage_01 - Step 05: Click on Next button");
		salesPage.clickOnNextButton();
		
		log.info("LossDamage_01 - Step 06: Click OK on Alert message");
		salesPage.acceptAlert(driver);
		
		log.info("VP: Hearing Aid displays with No Serial");
		verifyTrue(salesPage.isOrderItemsDisplays("Hearing Aid","ABC 100 - No Serial#", "", "$0.00"));

	}
	
	@Test(groups = { "regression" },description = "Loss Damage Add a Patient Service")
	public void LossDamage_02_AddPatientService()
	{
		log.info("LossDamage_02 - Step 01: Add item Patient service");
		salesPage.addItemInCreateSalesOrder("Add Patient Service");
		
		log.info("LossDamage_02 - Step 02: Add item Patient service");
		salesPage.selectServiceInPatientService("L&D Deductible (Service)");
		
		log.info("LossDamage_02 - Step 03: Enter list Price");
		salesPage.enterListPriceInPatientService("250");
		
		log.info("LossDamage_02 - Step 04: Click on Save and return Sale Order");
		salesPage.clickOnSaveReturnSaleOrder();
		
		log.info("LossDamage_02 - Step 05: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		
		log.info("LossDamage_02 - Step 06: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);

		log.info("LossDamage_02 - Step 07: Select Hearing Aid status");
		inventoryPage = salesPage.selectStatusOrderItem("ABC 100 - No Serial#");
		
		log.info("LossDamage_02 - Step 08: Enter Serial Order Item Ear Left");
		inventoryPage.enterSerialHearingOrderItemEarLeft(releftHearingID);
		
		log.info("LossDamage_02 - Step 09: Enter Manufacturer Warranty Time Hearing Ear Right ");
		inventoryPage.enterManufacturerWarrantyEarLeft(month,day,year);
		
		log.info("LossDamage_02 - Step 10: Enter Loss and Damage Time Hearing Ear Right ");
		inventoryPage.enterLossDamageEarLeft(month,day,year);
		
		log.info("LossDamage_02 - Step 11: Select Order Status Ordered");
		inventoryPage.selectOrderStatusInventoryOrder("Received");
		
		log.info("LossDamage_02 - Step 12: Save changed");
		inventoryPage.clickOnSaveButton();
		
		log.info("LossDamage_02 - Step 13: Open Sale Order item");
		salesPage = inventoryPage.openInventorySaleOrder();
		
		log.info("LossDamage_02 - Step 14: Click on Deliver button");
		salesPage.clickOnDeliverButton();
		
		log.info("LossDamage_02 - Step 15: Click on Deliver button");
		salesPage.switchToDeliverFrame(driver);
		
		log.info("LossDamage_02 - Step 15: Select Delevery method");
		salesPage.selectDeliveryMethodOnDeliverDialog("Customer Pickup");
		
		log.info("LossDamage_02 - Step 16: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
		
		log.info("VP: Hearing Ear Right Order Items status");
		verifyTrue(salesPage.isSalesOrderItemsDisplays(releftHearingID, "Current"));
		
		log.info("LossDamage_02 - Step 17: Click Collect Check/Cash Payment button");
		billingPage = salesPage.clickOnCheckCashPaymentButton();
		
		log.info("LossDamage_02 - Step 18: Select Payment method");
		billingPage.selectPaymentsMethod("Check");
		
		log.info("LossDamage_02 - Step 19: Enter check number");
		billingPage.enterCheckNumber(numberCheck);
		
		log.info("LossDamage_02 - Step 20: get Patient balance");
		patientBlance = billingPage.getPatientBlance();
		
		log.info("LossDamage_02 - Step 21: Enter amount");
		billingPage.enterPaymentAmount(patientBlance);
		
		log.info("LossDamage_02 - Step 22: Enter remark");
		billingPage.enterPaymentRemark(remark);
		
		log.info("LossDamage_02 - Step 23: click on Save button");
		billingPage.clickOnSave();
		
		log.info("LossDamage_02 - Step 24: click on back button");
		salesPage = billingPage.clickOnBackSalesOrder();
	}
	
	@Test(groups = { "regression" },description = "Loss Damage Return feature")
	public void LossDamage_03_Return()
	{
		log.info("LossDamage_03 - Step 01: click on Return button");
		salesPage.clickOnReturnButton();
		
		log.info("LossDamage_03 - Step 02: Select sale order item return");
		salesPage.selectSaleOrderReturnTo(releftHearingID,"Manufacturer");
		salesPage.selectSaleOrderReturnTo("L&D Deductible","Manufacturer");
		
		log.info("LossDamage_03 - Step 03: Click on Save and return button");
		salesPage.clickOnSaveReturnButton();
		
		log.info("LossDamage_03 - Step 04: Click on Patient Name");
		patientsPage = salesPage.clickOnPatientName();
		patientsPage.clickOKButton();
		
		log.info("LossDamage_03 - Step 05: Expand 'Hearing Aids' section");
		patientsPage.expandSectionOnCheckin("Hearing Aids");
		
		log.info("VP: Hearing Aid return displays correct status");
		verifyTrue(patientsPage.isHearingAidItemStatusCorrectly(releftHearingID,"Returned"));
		
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
	private String remark, patientBlance;
	public String manufacturer, type, model, battery, cptCode, listPrice, salesOrderID, part,cDiscount,eDiscount;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear, serialGadget, secordOrderID, gadgetID;
	public String officeInfo, patientLastName,patientFirstName,manufacturerInvoice;
	public String serial1,serial2,serialInStock,newSerialInStock,hearingAidID,warningMessage;
	private String releftHearingID, provider;
}