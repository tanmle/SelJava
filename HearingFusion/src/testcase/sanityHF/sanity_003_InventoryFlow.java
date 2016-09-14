package sanityHF;

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
import common.Constant;

public class sanity_003_InventoryFlow extends AbstractTest{

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
		
		office="Hearing Fun Report - Tecoma, WA";
		manufacturer = "Oticon Hearing";
		type = "ITE";
		model = "Intiga- (ITE)";
		serial=getUniqueNumber();
		provider ="Needle, Space";
		
		battery = "10";
	}
	@Test(groups = { "regression" },description = "Inventory Flow")
	public void sanity_InventoryFlow_001_InventoryFlow()
	{
		log.info("sanity_InventoryFlow_001 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);

		log.info("sanity_InventoryFlow_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("sanity_InventoryFlow_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("sanity_InventoryFlow_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("sanity_InventoryFlow_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("sanity_InventoryFlow_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("sanity_InventoryFlow_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("sanity_InventoryFlow_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("sanity_InventoryFlow_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("sanity_InventoryFlow_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("sanity_InventoryFlow_001 - Step 10: Open Inventory page");
		inventoryPage = patientsPage.openInventoryPage(driver, ipClient);
		
		log.info("sanity_InventoryFlow_001 - Step 11: Select Serialized Item link");
		inventoryPage.clickDynamicInventoryLink("Serialized Items");
		
		log.info("sanity_InventoryFlow_001 - Step 12: Click New button");
		inventoryPage.clickSerializedItemsNewButton();
		
		log.info("sanity_InventoryFlow_001 - Step 13: Input new serialized item");
		inventoryPage.inputSerializedItem(office, "Hearing Aid", manufacturer, type, model, serial, "");
		
		log.info("sanity_InventoryFlow_001 - Step 14: Click Save button");
		inventoryPage.clickSerializedItemsDetailSaveButton();
		
		log.info("sanity_InventoryFlow_001 - step 15: Open Sales page");
		salesPage = schedulePage.openSalesPage(driver, ipClient);

		log.info("sanity_InventoryFlow_001 - step 16: Open Sales page");
		salesPage.clickOnNewButton();
		
		log.info("sanity_InventoryFlow_001 - step 17: Select Patient name");
		salesPage.selectPatient(validPatientLastName);

		log.info("sanity_InventoryFlow_001 - step 18: Select Provider");
		salesPage.selectProvider(provider);

		log.info("sanity_InventoryFlow_001 - step 19: click on Save");
		salesPage.clickOnSaveButton();

		log.info("sanity_InventoryFlow_001 - step 20: Add item");
		salesPage.addItemInCreateSalesOrder("Add Hearing Aid");

		log.info("sanity_InventoryFlow_001 - step 21: Enter Left Ear");
		salesPage.enterHearingAidDetailsLeftEar(manufacturer, type, model,"",battery);

		log.info("sanity_InventoryFlow_001 - step 22: Enter Left Ear Discount Type");
		salesPage.selectPrincingDiscountType("Monetary");

		log.info("sanity_InventoryFlow_001 - step 23: Enter Left Ear Pricing Discount");
		salesPage.enterPrincingDiscount("750");
		
		log.info("sanity_InventoryFlow_001 - step 24: click Save");
		salesPage.clickOnSaveButton();
		
		log.info("sanity_InventoryFlow_001 - Step 25: Click on Create Inventory Order button");
		salesPage.clickOnCreateInventoryOrderButton();
		salesPage.acceptAlert(driver);

		log.info("sanity_InventoryFlow_001 - Step 26: Click Back button");
		salesPage.clickOnBackButton();
		
		log.info("sanity_InventoryFlow_001 - Step 27: get Sales Order ID");
		salesOrderID = salesPage.getSalesOrdersId();
		
		log.info("sanity_InventoryFlow_001 - Step 28: Open Inventory page");
		inventoryPage = salesPage.openInventoryPage(driver, ipClient);
		
		log.info("sanity_InventoryFlow_001 - Step 29: Select office for search Hearing Aid Orders");
		inventoryPage.selectOfficeSearchOrder(office);
		
		log.info("sanity_InventoryFlow_001 - Step 30: Enter Patient Last Name for search Hearing Aid Orders");
		inventoryPage.enterPatientLastNameSearchOrder(validPatientLastName);
		
		log.info("sanity_InventoryFlow_001 - Step 31: Click on search button for search Hearing Aid Orders item");
		inventoryPage.clickOnSearchButton();
		
		log.info("VP: Verify Hearing Aid Orders item");
		verifyTrue(inventoryPage.isHearingAidOrdersItemDisplays(salesOrderID));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private InventoryPage inventoryPage;
	private SalesPage salesPage;
	private PatientsPage patientsPage;
	private String organization, qaStaffUsername, password;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	private String office;
	private String manufacturer, type, model, serial;
	private String provider, battery, salesOrderID;
}
