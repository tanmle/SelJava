package patients;
import java.io.IOException;
import java.util.Set;
import java.util.Stack;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Common;
import common.Constant;

public class patients_007_PatientDetails_Insurance_SearchNavigation extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
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
		listCarrierFile = "Search_FKCarrierSearch.xls";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Find Carrier_Download CSV search results")
	public void patientDetails_Insurance_SearchNavigation_001_FindCarrier_DownloadCSV()
	{
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();
	
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 15: Expand patient insurance");
		patientsPage.expandPatientDetailsInsurance();
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 16: Click New link");
		patientsPage.clickPatientDetailsInsuranceNewLink();
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 17: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_SearchNavigation_001 - Step 18: Click CSV to download results");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.downloadFileCSVResultFoundCarrier(listCarrierFile);
		
		log.info("VP: Download CSV file successfully");
		verifyTrue(Common.getCommon().isFileExists(listCarrierFile));
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
		
	}
	@Test(groups = { "regression" },description = "Find Carrier_Open Help page")
	public void patientDetails_Insurance_SearchNavigation_002_FindCarrier_OpenHelpPage()
	{
		log.info("patientDetails_Insurance_SearchNavigation_002 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_SearchNavigation_002 - Step 02: Click on Help link");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.clickOnHelpLink();
		
		log.info("VP: Help page is opened");
		verifyTrue(patientsPage.getNewWindowTitle().contains("Help Page"));
		
		patientsPage.switchToTopWindowFrame(driver);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Open Print page")
	public void patientDetails_Insurance_SearchNavigation_003_FindCarrier_OpenPrintPage()
	{
		log.info("patientDetails_Insurance_SearchNavigation_003 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_SearchNavigation_003 - Step 02: Click on Print link");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.clickOnPrintLink();
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Print page is opened");
		verifyTrue(patientsPage.isPrintPageOpened());
		
		driver.close();
		driver.switchTo().window(currentHandle);
		patientsPage.closeSearchCarrierPopup();
	}
	@Test(groups = { "regression" },description = "Find Carrier_Open Email page")
	public void patientDetails_Insurance_SearchNavigation_004_FindCarrier_OpenEmailPage()
	{
		log.info("patientDetails_Insurance_SearchNavigation_004 - Step 01: Click Carrier Search link");
		patientsPage.clickInsuranceCarrierSearchLink();
		
		log.info("patientDetails_Insurance_SearchNavigation_004 - Step 02: Click on Email link");
		patientsPage.switchToCarrierFrame(driver);
		patientsPage.clickOnEmailLink();
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Help page is opened");
		verifyTrue(patientsPage.isEmailPageOpened());
		
		driver.close();
		driver.switchTo().window(currentHandle);
		patientsPage.closeSearchCarrierPopup();
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
	private String organization, qaStaffUsername, password;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	private String listCarrierFile;
	private final Stack<String> openWindowHandles = new Stack<String>();
}
