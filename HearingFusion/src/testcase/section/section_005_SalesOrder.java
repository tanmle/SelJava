package section;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SalesPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Common;
import common.Constant;

public class section_005_SalesOrder extends AbstractTest {

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) {

		driver = openBrowser(browser, port, ipClient);
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		correctHour = 16;
		correctMinute = 0;
		patientName = "Baker, Mark";
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Arrived";
		patientFull = "Baker, Mark (NickName 5908) (Henderson Ear)";
		patient = "Baker, Mark (NickName 5908)";
		patientName = "Baker, Mark";
		manufacturer = "Generic";
		type = "BTE";
		cDiscount = "Monetary";
		eDiscount = "750";
		gadgetType = "remotes";
		part = "rm520 (remotes)";
		model = "ABC 100 (BTE)";
		battery = "10";
		cptCode = "1108M-Independent Medical Exam";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		warningMsg = "This order contain one or more items that requires either choosing a serial number or creating an order for this item";
	}

	@Test(groups = { "regression" }, description = "Open Sales Order")
	public void SalesOrder_01_OpenSalesOrder() {
		log.info("SalesOrder_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password,
				false);

		log.info("SalesOrder_01 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour,
				correctMinute, apptType, apptStatus, patientFull, refResource,
				noteContent, correctStartTime, correctEndTime, provider);

		log.info("SalesOrder_01 - Step 03: Open event created");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,
				apptType, patientName);

		log.info("SalesOrder_01 - Step 04: open Checkin Appointment data");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();

		log.info("SalesOrder_01 - Step 05: open Create Sales Order");
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.openAppointmentTab("Create Sales Order");
		salesPage = PageFactory.getSalesPage(driver, ipClient);

		log.info("VP: Sales Orders page displays");
		verifyTrue(salesPage.isCreateSalesOrderDisplays());

		log.info("SalesOrder_01 - step 06: Open schedule page");
		schedulePage = salesPage.gotoSchedulePage(driver, ipClient);

		log.info("SalesOrder_01 - Step 07: Open event created");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,
				apptType, patientName);

		log.info("SalesOrder_01 - Step 08: open Checkin Appointment data");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();

		log.info("SalesOrder_01 - Step 09: Open event created");
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");

		log.info("SalesOrder_01 - Step 10: open Create Sales Order");
		salesPage = patientsPage.clickAddNewInvoiceSalesOrders();

		log.info("VP: Sales Orders page displays");
		verifyTrue(salesPage.isCreateSalesOrderDisplays());

		log.info("SalesOrder_01 - step 11: Open schedule page");
		schedulePage = salesPage.gotoSchedulePage(driver, ipClient);

		log.info("SalesOrder_01 - step 12: Open Sales page");
		salesPage = schedulePage.openSalesPage(driver, ipClient);

		log.info("SalesOrder_01 - step 13: Open Sales page");
		salesPage.clickOnNewButton();

		log.info("VP: Sales Orders page displays");
		verifyTrue(salesPage.isCreateSalesOrderDisplays());
	}

	@Test(groups = { "regression" }, description = "Add New Sales Order")
	public void SalesOrder_02_AddNewSalesOrder() {
		log.info("SalesOrder_02 - step 01: Select Patient name");
		salesPage.selectPatient(patient);

		log.info("SalesOrder_02 - step 02: Select Provider");
		salesPage.selectProvider("Jones, Tom");

		log.info("SalesOrder_02 - step 03: click on Save");
		salesPage.clickOnSaveButton();

		log.info("SalesOrder_02 - Step 04: Close Schedule event");
		verifyTrue(salesPage.isRecordSavedSuccessfully());

	}

	@Test(groups = { "regression" }, description = "Add New Hearing Aid Item")
	public void SalesOrder_03_AddNewHearingAidItem() {
		log.info("SalesOrder_03 - step 01: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");

		log.info("SalesOrder_03 - step 02: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar(manufacturer, type, model,
				battery);

		log.info("SalesOrder_03 - step 03: Enter Left Ear");
		salesPage.selectPrincingDiscountType("Monetary");

		log.info("SalesOrder_03 - step 03: Enter Left Ear");
		salesPage.enterPrincingDiscount("750");

		log.info("SalesOrder_03 - step 04: Enter Left Ear");
		salesPage.clickOnBinauralButton();
		salesPage.acceptAlert(driver);

		log.info("VP: Right Ear overwrite left ear");
		verifyTrue(salesPage.isRightEarOverwriteLeftEar(manufacturer, type,
				model, battery, "Monetary"));

		log.info("SalesOrder_03 - step 06: click Save");
		salesPage.clickOnSaveButton();

		log.info("SalesOrder_03 - Step 07: Close Schedule event");
		verifyTrue(salesPage.isRecordSavedSuccessfully());

		log.info("VP: Create Inventory Order button displays");
		verifyTrue(salesPage.isCreateInventoryOrderButtonDisplays());

		log.info("SalesOrder_03 - step 08: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);

		log.info("SalesOrder_03 - Step 09: Close Schedule event");
		verifyTrue(salesPage.isRecordSavedSuccessfully());

		log.info("VP: Inventory Order saved");
		salesPage.isInventoryOrderSaved(manufacturer, type, model, battery,
				"Monetary", "750");

		log.info("SalesOrder_03 - Step 10: get list price");
		listPrice = salesPage.getListPrice();

		log.info("SalesOrder_03 - Step 11: back create sales order page");
		salesPage.clickOnBackButton();

		log.info("VP: Order items displays");
		verifyTrue(salesPage.isOrderItemsDisplays("Hearing Aid",
				"L - ABC 100 - No Serial #", "Ordered", listPrice));
		verifyTrue(salesPage.isOrderItemsDisplays("Hearing Aid",
				"R - ABC 100 - No Serial #", "Ordered", listPrice));
	}

	@Test(groups = { "regression" }, description = "Add New Gadget Item")
	public void SalesOrder_04_AddNewGadgetItem() {
		log.info("SalesOrder_04 - step 01: Add item");
		salesPage.addItemInCreateSalesOrder("Add Gadget");

		log.info("SalesOrder_04 - step 02: Enter Gadget info");
		salesPage.enterGadgetItemsInfo(manufacturer, gadgetType, part,
				cDiscount, eDiscount);

		log.info("SalesOrder_04 - step 03: click on Save");
		salesPage.clickOnSaveButton();

		log.info("SalesOrder_04 - Step 04: back create sales order page");
		salesPage.clickOnBackButton();

		log.info("VP: Gadget Order created displays in list order");
		verifyTrue(salesPage.isOrderItemsDisplays("Gadget",
				"rm520 - No Serial #", "", "$0.00"));

	}

	@Test(groups = { "regression" }, description = "Remove Order Items")
	public void SalesOrder_05_RemoveOrderItems() {
		log.info("SalesOrder_05 - step 01: Select order item for remove");
		salesPage.selectOrderItemForRemove("R - ABC 100 - No Serial #");

		log.info("SalesOrder_05 - step 02: Save for remove item");
		salesPage.clickOnSaveButton();

		log.info("VP: Gadget Order created displays in list order");
		verifyFalse(salesPage.isOrderItemsDisplays("Hearing Aid",
				"R - ABC 100 - No Serial #", "Ordered", listPrice));
	}

	@Test(groups = { "regression" }, description = "Remove Order Items")
	public void SalesOrder_06_CheckOutOrderItems() {
		log.info("SalesOrder_06 - step 01: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);

		log.info("VP: Warning message displays");
		verifyTrue(salesPage.isWarningMessageDisplays(warningMsg));

		log.info("SalesOrder_06 - step 02: Open order item");
		salesPage.openOrderItem("rm520 - No Serial #");

		log.info("SalesOrder_06 - step 03: click on Create Gadget Order");
		salesPage.clickCreateGadgetOrder();
		salesPage.acceptAlert(driver);

		log.info("SalesOrder_06 - step 04: click on Save and return Sale Order");
		salesPage.clickOnSaveReturnSaleOrder();

		log.info("SalesOrder_06 - step 05:get Sales Order ID");
		salesOrderID = salesPage.getSalesOrdersId();

		log.info("SalesOrder_06 - step 06: Open Sales page");
		salesPage.openSalesPage(driver, ipClient);

		log.info("SalesOrder_06 - step 07: Search Orders created");
		salesPage.searchOrderItem(salesOrderID);

		log.info("VP: Sales order display in Order list");
		verifyTrue(salesPage.isOrderExistsInList(salesOrderID));

		log.info("VP: Status Sales order ");
		verifyTrue(salesPage.isSalesOrderTypeCorrectly(salesOrderID,
				"In Process"));

		log.info("SalesOrder_06 - step 08: Open order item");
		salesPage.openListOrderItem(salesOrderID);

		log.info("SalesOrder_06 - step 09: Open order item");
		verifyTrue(salesPage.isCraeteSalesOrderPageDisplays());

		log.info("SalesOrder_06 - step 10: Select order item for remove");
		salesPage.clickListOrderButton();

		log.info("VP: Status order item");
		verifyTrue(salesPage
				.isStatusOrderCorrectly(salesOrderID, "In Progress"));

		log.info("Post-condition - step 01: Open Scheduler page");
		schedulePage = salesPage.gotoSchedulePage(driver, ipClient);

		log.info("Post-condition - step 02: Open event created");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,
				apptType, patientName);

		log.info("Post-condition - step 03: Delete event created");
		schedulePage.deleteAppointment();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}

	private SalesPage salesPage;
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private int date, month, year, correctHour, correctMinute;
	private String patientName, correctStartTime, correctEndTime, patient;
	private String gadgetType, noteContent, warningMsg, salesOrderID, part;
	private String cDiscount, eDiscount;
	public String manufacturer, type, model, battery, cptCode, listPrice;
	private String apptType, apptStatus, patientFull, refResource, provider;

}