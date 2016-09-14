package section;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.BillingPage;
import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SalesPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Common;
import common.Constant;

public class section_006_PostingPayments extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		patient = "Patient, John";
		manufacturer = "Generic";
		type = "BTE";
		cDiscount = "Monetary";
		eDiscount = "750";
		gadgetType = "remotes";
		part = "rm520 (remotes)";
		model = "ABC 100 (BTE)";
		battery = "10";
		cptCode  = "1108M-Independent Medical Exam";
		creditCardType = "Visa";
		creditCardNumber = "4012888888881881";
		creditCardName = "Udi Team";
		creditMonth = "Dec";
		creditYear = Common.getCommon().getCurrentYear()+"";
		refNumber = "";
		remark = "HA Pay-Deposit, remainder on delivery-JS";
		address = "5203 SE Tanner Ct.";
		city = "Portland";
		state = "OR - Oregon";
		zipCode = "42397";
		totalAmount = "1,112.00";
	}
	
	@Test(groups = { "regression" },description = "Payment Sales Order")
	public void PostingPayments_01_Payment()
	{
		log.info("Pre-Condition - 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);

		log.info("Pre-Condition - 02: Open Sales page");
		salesPage = schedulePage.openSalesPage(driver, ipClient);
		
		log.info("Pre-Condition - 03: add new a Sale order");
		salesPage.clickOnNewButton();
		
		log.info("Pre-Condition - 04: Select Patient name");
		salesPage.selectPatient(patient);
		
		log.info("Pre-Condition - 05: Select Provider");
		salesPage.selectProvider("Needle, Space");
		
		log.info("Pre-Condition - 06: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - 07: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");
		
		log.info("Pre-Condition - 08: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar(manufacturer, type, model, battery);
		
		log.info("Pre-Condition - 09: Enter Left Ear");
		salesPage.selectPrincingDiscountType("Monetary");
		
		log.info("Pre-Condition - 10: Enter Left Ear");
		salesPage.enterPrincingDiscount("750");
		
		log.info("Pre-Condition - 11: Enter Left Ear");
		salesPage.clickOnBinauralButton();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - 12: click Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - 13: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - 14: back create sales order page");
		salesPage.clickOnBackButton();
		
		log.info("Pre-Condition - 15: Add item");
		salesPage.addItemInCreateSalesOrder("Add Gadget");
		
		log.info("Pre-Condition - 16: Enter Gadget info");
		salesPage.enterGadgetItemsInfo(manufacturer,gadgetType,part,cDiscount,eDiscount);
		
		log.info("Pre-Condition - 17: click on Save");
		salesPage.clickOnSaveButton();
		
		log.info("Pre-Condition - 18: click on Create Gadget Order");
		salesPage.clickCreateGadgetOrder();
		salesPage.acceptAlert(driver);
		
		log.info("Pre-Condition - 19: click on Save and return Sale Order");
		salesPage.clickOnSaveReturnSaleOrder();
		
		log.info("Pre-Condition - 20: get Sales Order ID");
		salesOrderID = salesPage.getSalesOrdersId();
		
		log.info("Pre-Condition - 21: Select order item for remove");
		salesPage.clickOnCheckOutButton();
		salesPage.acceptAlert(driver);
		
		log.info("PostingPayments - 01: get Total price ");
		totalPrice = salesPage.getTotalPrice();
		
		log.info("PostingPayments - 02: click on 'Collect CC Payments' ");
		billingPage = salesPage.clickOnCollectCCPayments();
		
		log.info("VP: Verify Patient balance for this sale correctly");
		verifyTrue(billingPage.isPatientBalanceSaleCorrectly(totalPrice));
		
		log.info("PostingPayments - 03: enter credit card details");
		billingPage.enterCreditCardDetails(creditCardType, creditCardNumber, creditCardName, creditMonth, creditYear);
		
		log.info("PostingPayments - 04: enter billing address ");
		billingPage.enterCreditBillingAddress(address, city, state, zipCode);
		
		log.info("PostingPayments - 05: enter Transaction details ");
		billingPage.enterTransactionDetails(totalAmount, refNumber, remark);
		
		log.info("PostingPayments - 06: click on Apply Change");
		billingPage.clickOnApplyChange();
		
		log.info("PostingPayments - 07: Back Sale order");
		salesPage = billingPage.backSalesOrder();
		balancePrice = salesPage.getBalancePrice(totalPrice,totalAmount);
		
		log.info("VP: Payments and Adjustments exists");
		verifyTrue(salesPage.isPaymentsAdjustmenExists(remark));
		
		log.info("VP: Paid displays correct");
		verifyTrue(salesPage.isPaidDisplaysCorrect(totalAmount));
		
		log.info("VP: Blance displays correct");
		verifyTrue(salesPage.isBalanceDisplaysCorrect(balancePrice));
	
		log.info("PostingPayments - 08: Open Check in Patient");
		patientsPage = salesPage.selectCheckInTab();
		
		log.info("VP: Current Blance label displays correct");
		verifyTrue(patientsPage.isCurrentBalanceLabelDisplaysCorrect(balancePrice));
		
		log.info("PostingPayments - 09: Open Sales Order tab");
		salesPage = patientsPage.clickOnSalesTab();
		
		log.info("PostingPayments - 10: click on check cash payment button");
		billingPage = salesPage.clickOnCheckCashPaymentButton();
		
		log.info("VP: Patient balance for this sale displays correctly");
		verifyTrue(billingPage.isPatientBalanceDisplaysCorrect(balancePrice));
		
		log.info("PostingPayments - 11: select payments method");
		billingPage.selectPaymentsMethod("Check");
		
		log.info("PostingPayments - 12: enter check number");
		billingPage.enterCheckNumber("1234");
		
		log.info("PostingPayments - 13: enter amount");
		billingPage.enterPaymentAmount(balancePrice);
		
		log.info("PostingPayments - 14: enter remark");
		billingPage.enterPaymentRemark(remark);
		
		log.info("PostingPayments - 15: Save payments");
		billingPage.clickOnSave();
		
		log.info("PostingPayments - 16: Back to sales order");
		salesPage = billingPage.clickOnBackSalesOrder();
		
		log.info("VP: Paid displays correct");
		verifyTrue(salesPage.isPaidDisplaysCorrect(totalPrice));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	
	private SalesPage salesPage;
	private BillingPage billingPage;
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private String refNumber, remark;
	private String patient, gadgetType, totalPrice, address, city, state, zipCode;
	public String manufacturer, type, model, battery, cptCode, listPrice, salesOrderID, part,cDiscount,eDiscount;
	public String balancePrice, totalAmount, creditCardType, creditCardNumber, creditCardName;
	public String creditMonth, creditYear;
}