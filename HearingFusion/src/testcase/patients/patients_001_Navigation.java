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

public class patients_001_Navigation extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Open Help")
	public void navigation_001_Help()
	{
		log.info("Navigation_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Navigation_001 - Step 02: Click Help icon");
		patientsPage.clickPatientRecordHelpIcon();
		
		log.info("VP: Help popup displays");
		verifyTrue(patientsPage.getNewWindowTitle().contains("Help Page"));
	}
	@Test(groups = { "regression" },description = "Open Email")
	public void navigation_002_Email()
	{
		log.info("Navigation_002 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Navigation_002 - Step 02: Click Email icon");
		patientsPage.clickPatientRecordEmailIcon();
		
		log.info("VP: Email popup displays");
		verifyTrue(patientsPage.getNewWindowTitle().contains("List of Patients"));
	}
	@Test(groups = { "regression" },description = "Open Print")
	public void navigation_003_Print()
	{
		log.info("Navigation_003 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("Navigation_003 - Step 02: Click Print icon");
		patientsPage.clickPatientRecordPrintIcon();
		
		log.info("VP: Print popup displays");
		verifyTrue(patientsPage.isPrintPageOpened());
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
}
