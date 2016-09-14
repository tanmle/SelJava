package patients;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.SalesPage;
import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Constant;

public class patients_015_PatientDetails_Repairs extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaAdminUsername = Constant.QA_ADMIN_USERNAME;
		password = Constant.PASSWORD;
		
		validPatientLastName="Udi"+getUniqueNumber();
		validHomePhone="310-454-5857";
		validZIP="90024";
		validPatientType="Competitive";
		validPatientFirstName="QATeam";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaAdminUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Create repair item")
	public void patients_PatientDetails_Repairs_001_CreateRepairItem()
	{
		log.info("patients_PatientDetails_Repairs_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_Repairs_001 - Step 15: Expand 'Invoices/Sales Orders' section");
		patientsPage.expandSectionOnCheckin("Invoices/Sales Orders");
		
		log.info("patients_PatientDetails_Repairs_001 - Step 16: Click Add new Invoices/Sales Orders");
		salesPage = patientsPage.clickAddNewInvoicesSalesOrders();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 17: Click Add Repair");
		salesPage.addItemInCreateSalesOrder("Add Repair");
		
		log.info("patients_PatientDetails_Repairs_001 - Step 18: Select Repair Manufacturer");
		salesPage.selectRepairManufacturer("Siemens");
		
		log.info("patients_PatientDetails_Repairs_001 - Step 19: Select Repair Warranty");
		salesPage.selectRepairWarranty("In Warranty");
		
		log.info("patients_PatientDetails_Repairs_001 - Step 20: Select Repair Repair");
		salesPage.selectRepairRepair("1 YEAR Warranty Repair (In Warranty)");
		
		log.info("patients_PatientDetails_Repairs_001 - Step 21: Click Save button");
		salesPage.clickRepairSaveButton();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 22: Click Create Sales Order");
		salesPage.clickRepairCreateRepairOrderButton();
		salesPage.acceptAlert(driver);
		
		log.info("patients_PatientDetails_Repairs_001 - Step 23: Click View Sales Order");
		salesPage.clickRepairCreateRepairOrderButton();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 24: Click Go To Sales Order ");
		salesPage.clickRepairGoToSalesOrderButton();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 25: Click Check Out");
		salesPage.clickSalesOrderCheckOutButton();
		salesPage.acceptAlert(driver);
		
		log.info("VP: Sale Order ID created");
		verifyTrue(salesPage.isSalesOrderIDDisplays());
		String salesOrderID = salesPage.getSalesOrderID();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 26: Click Check-In tab");
		patientsPage = salesPage.selectCheckInTab();
		
		log.info("patients_PatientDetails_Repairs_001 - Step 27: Expland Repair section");
		patientsPage.expandSectionOnCheckin("Repairs");
		
		log.info("VP: Repair item displays at Repair section");
		verifyTrue(patientsPage.getPatientDetailsRepairSalesOrderID("1").equals(salesOrderID));
	}
	@Test(groups = { "regression" },description = "View Repair item")
	public void patients_PatientDetails_Repairs_002_ViewRepairItem()
	{
		log.info("patients_PatientDetails_Repairs_002 - Step 01: Click repair detail link");
		patientsPage.clickPatientDetailsRepairDetailLink("1");
		
		log.info("VP: Repair item details displays");
		verifyTrue(patientsPage.isPatientDetailsPatientEquipmentPageDisplays());
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private SalesPage salesPage;
	private PatientsPage patientsPage;
	private String organization, qaAdminUsername, password;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
}
