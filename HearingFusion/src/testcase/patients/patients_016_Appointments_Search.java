package patients;
import java.io.IOException;

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
import common.Constant;

public class patients_016_Appointments_Search extends AbstractTest{
	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaAdminUsername = Constant.QA_ADMIN_USERNAME;
		password = Constant.PASSWORD;
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaAdminUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Open Help")
	
	public void patients_PatientDetails_Navigation_001_OpenHelp()
	{
		log.info("patients_Appointments_Search_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_Appointments_Search_001 - Step 02: Click Appointments help link");
		patientsPage.clickPatientRecordHelpIcon();
		
		log.info("VP: Help page is opened");
		verifyTrue(patientsPage.getNewWindowTitle().contains("Help Page"));
	}
	@Test(groups = { "regression" },description = "Open Print")
	public void patients_PatientDetails_Navigation_002_OpenPrint()
	{
		log.info("patients_PatientDetails_Navigation_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Navigation_002 - Step 02: Click Print link");
		patientsPage.clickPatientRecordPrintIcon();
		
		log.info("VP: Print popup displays");
		verifyTrue(patientsPage.isPrintPageOpened());
	}
	@Test(groups = { "regression" },description = "Open Email")
	public void patients_PatientDetails_Navigation_003_OpenEmail()
	{
		log.info("patients_PatientDetails_Navigation_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_Navigation_003 - Step 02: Click Email link");
		patientsPage.clickPatientRecordEmailIcon();
		
		log.info("VP: Email popup displays");
		verifyTrue(patientsPage.getNewWindowTitle().contains("List of Patients"));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException {
		logout(driver, ipClient);
		closeBrowser(driver);
	}
	private WebDriver driver;
	private LoginPage loginPage;
	private SchedulePage schedulePage;
	private PatientsPage patientsPage;
	private String organization, qaAdminUsername, password;
}
