package checkinAppointment;

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

public class checkinAppt_007_InvoicesSalesOrders_AddNew extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		correctHour = 16;
		correctMinute = 0;
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "Dorner, Mark (button) (Hearing Fun)";
		patientName = "Dorner, Mark (button)";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Sales Order Delivery")
	public void checkinAppt_157_SalesOrderDelivery()
	{
		log.info("CheckinAppt_157 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_157 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_157 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_157 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_157 - Step 05: Expand 'Invoices/Sales Orders' section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("CheckinAppt_157 - Step 06: Select an order in list");
		salesPage = patientsPage.viewInvoicesSalesOrdersDetail("166057");
		
		log.info("CheckinAppt_157 - Step 07: Click Deliver");
		salesPage.clickOnDeliverButton();
		salesPage.switchToDeliverFrame(driver);
		
		log.info("CheckinAppt_157 - Step 08: Leaving all fields blank");
		salesPage.inputDeliveryDateOnDeliverDialog("");
		salesPage.selectDeliveryMethodOnDeliverDialog("");
		salesPage.inputShippedWithOnDeliverDialog("");
		salesPage.inputTrackingNumberOnDeliverDialog("");
		
		log.info("CheckinAppt_157 - Step 09: Click Save");
		salesPage.clickSaveButtonOnDeliverDialog();
		
		log.info("VP: Message of 'At least one item must be selected for delivery in order to save delivery information.' show");
		verifyTrue(salesPage.isMessageDisplayOnDeliverDialog("At least one item must be selected for delivery in order to save delivery information."));
		
		log.info("CheckinAppt_157 - Step 10: Close deliver dialog");
		salesPage.clickCancelButtonOnDeliverDialog();
		salesPage.switchToTopWindowFrame(driver);
	}
	
	@Test(groups = { "regression" },description = "Add Hearing Aid: Manufactures")
	public void checkinAppt_158_AddHearingAid_Manufactures()
	{
		log.info("CheckinAppt_158 - Step 01: Go to Schedule page and open appointment");		
		schedulePage = salesPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_158 - Step 02: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_158 - Step 03: Expand 'Invoices/Sales Orders' section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("CheckinAppt_158 - Step 04: Click Add new Invoices/Sales Orders");
		salesPage = patientsPage.clickAddNewInvoicesSalesOrders();
		
		log.info("CheckinAppt_158 - Step 05: Click Add Hearing Air");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");
		
		log.info("CheckinAppt_158 - Step 06: Select Manufacturer for left air");
		salesPage.selectManufacturerForLeftAir("ABC Supplies");
		
		log.info("CheckinAppt_158 - Step 07: Select Manufacter for right air");
		salesPage.selectManufacturerForRightAir("ABC Supplies");
		
		log.info("VP: There are two options on Type combobox for left air");
		verifyEquals(salesPage.getAllOptionsInTypeLeftAir(), 2);
		
		log.info("VP: There are two options on Type combobox for right air");
		verifyEquals(salesPage.getAllOptionsInTypeRightAir(), 2);
	}
		
	@Test(groups = { "regression" },description = "Add Hearing Aid: Missing Manufactures Items")
	public void checkinAppt_159_AddHearingAid_MissingManufacturesItems()
	{
		log.info("VP: There are ten options on Manufacturer combobox for left air");
		verifyEquals(salesPage.getAllOptionsInManufacturerLeftAir(), 10);
		
		log.info("VP: There are ten options on Manufacturer combobox for right air");
		verifyEquals(salesPage.getAllOptionsInManufacturerRightAir(), 10);
	}
	
	@Test(groups = { "regression" },description = "Invoices/Sales Orders_Add new _Add Hearing Aid: Pricing")
	public void checkinAppt_160_AddHearingAid_Pricing()
	{
		log.info("CheckinAppt_160 - Step 01: Enter data into all fields of Left Ear");
		salesPage.inputLeftEarInformation("Prairie Labs", "ITC", "NewOne (ITC)");
		
		log.info("CheckinAppt_160 - Step 02: Enter data into all fields of Right Ear");
		salesPage.inputRightEarInformation("Oticon Hearing", "ITE", "Agil- (ITE)");
		
		log.info("CheckinAppt_160 - Step 03: Enter data into basic warranty for left Ear");
		salesPage.inputBasicWarrantyForLeftEar("", "");
		
		log.info("CheckinAppt_160 - Step 04: Enter data into basic warranty for Right Ear");
		salesPage.inputBasicWarrantyForRightEar("24", "12");
		
		log.info("CheckinAppt_160 - Step 05: Enter data into pricing for left Ear");
		salesPage.inputPricingForLeftEar("%", "10");
		
		log.info("CheckinAppt_160 - Step 06: Enter data into pricing for Right Ear");
		salesPage.inputPricingForRightEar("%", "10");
		
		log.info("VP: Total price display correctly for left ear");
		verifyEquals(salesPage.getTotalPriceForLeftEar(), "$1,899.00");
		
		log.info("VP: Total price display correctly for right ear");
		verifyEquals(salesPage.getTotalPriceForRightEar(), "$1,424.25");
	}
	
	@Test(groups = { "regression" },description = "Invoices/Sales Orders_Add new _Add Hearing Aid: Pricing")
	public void checkinAppt_161_AddHearingAid_Pricing()
	{
		log.info("CheckinAppt_161 - Step 01: Save Hearing Aid details");
		salesPage.clickOnSaveButton();
		
		log.info("CheckinAppt_161 - Step 02: Click Create Inventory Order");
		salesPage.createInventoryOrder();
		
		log.info("CheckinAppt_161 - Step 03: Click Back");
		salesPage.clickOnBackButton();
		
		log.info("CheckinAppt_161 - Step 04: Get Sale Order #");
		saleOrderId = salesPage.getSalesOrdersId();
		
		log.info("CheckinAppt_161 - Step 05: Click Checkout");
		salesPage.clickOnCheckoutButton();
		
		log.info("CheckinAppt_161 - Step 06: Click Apply Credits ");
		salesPage.clickOnApplyCreditsButton();
		
		log.info("CheckinAppt_161 - Step 07: Select Invoices/Sales Orders with credit balances");
		salesPage.selectInvoicesSalesOrders("1");
		
		log.info("CheckinAppt_161 - Step 08: Click Save and Appy Credits");
		salesPage.clickSaveAndApplyCreditsButton();
		
		log.info("VP: Save and Appy Credits successfully");
		verifyTrue(salesPage.isApplyCreditsSaveSuccessfully());		
		
		log.info("CheckinAppt_161 - Step 09: Go to Schedule page");
		schedulePage = salesPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_161 - Step 10: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_161 - Step 11: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_161 - Step 12: Expand 'Invoices/Sales Orders' section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("VP: The Sales Orders displays on list");
		verifyTrue(patientsPage.isSalesOrdersDisplayById(saleOrderId));
		
		log.info("CheckinAppt_161 - Step 13: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_161 - Step 14: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_161 - Step 15: Delete appointment");
		schedulePage.deleteAppointment();
		schedulePage.switchToTopWindowFrame(driver);
	}
		
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private SalesPage salesPage;
	private String organization, qaStaffUsername, password;
	private String noteContent, saleOrderId;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
}