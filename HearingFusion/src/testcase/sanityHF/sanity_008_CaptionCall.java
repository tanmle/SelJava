package sanityHF;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AdministrationPage;
import page.LoginPage;
import page.PageFactory;
import page.PatientsPage;
import page.SchedulePage;
import common.AbstractTest;
import common.Constant;

public class sanity_008_CaptionCall extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_ADMIN_USERNAME;
		password = Constant.PASSWORD;
		
		validPatientLastName="Udi"+getUniqueNumber();
		validHomePhone="310-454-5857";
		validZIP="90024";
		validPatientType="Competitive";
		validPatientFirstName="QATeam";
		
		providerName="Needle, Space";
		office="Hearing Fun Report";
	}
	@Test(groups = { "regression" },description = "Caption Call")
	public void sanity_CaptionCall_001_CaptionCall()
	{
		log.info("sanity_CaptionCall_001 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);

		log.info("sanity_CaptionCall_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();

		log.info("sanity_CaptionCall_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("sanity_CaptionCall_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("sanity_CaptionCall_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("sanity_CaptionCall_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("sanity_CaptionCall_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("sanity_CaptionCall_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("sanity_CaptionCall_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("sanity_CaptionCall_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("sanity_CaptionCall_001 - Step 10: Click Caption Call button");
		patientsPage.clickCaptionCallButton();
		
		log.info("sanity_CaptionCall_001 - Step 11: Click Provider Search icon");
		patientsPage.clickCaptionCallProviderSearchIcon();
		
		log.info("sanity_CaptionCall_001 - Step 12: Switch to Provider");
		patientsPage.switchToCaptionCallProviderFrame(driver);
		
		log.info("sanity_CaptionCall_001 - Step 13: Select a Provider");
		patientsPage.selectCaptionCallProviderName(providerName);
		patientsPage.switchToTopWindowFrame(driver);
		
		log.info("sanity_CaptionCall_001 - Step 14: Click Caption Call Save button");
		patientsPage.clickCaptionCallDetailSaveButton();
		
		log.info("VP: New record should be displayed");
		verifyTrue(patientsPage.getOutBoundFaxValue("1").equals("New"));
		
		log.info("sanity_CaptionCall_001 - Step 15: Click Administrator tab");
		administrationPage = patientsPage.openAdministrationPage(driver, ipClient);
		
		log.info("sanity_CaptionCall_001 - Step 16: Click Office link");
		administrationPage.clickAdministrationChildLink("Offices");
		
		log.info("sanity_CaptionCall_001 - Step 17: Input Office Name");
		administrationPage.inputAdministrationOfficeName(office);
		
		log.info("sanity_CaptionCall_001 - Step 18: Click Search button");
		administrationPage.clickAdministrationOfficeSearchButton();
		
		log.info("sanity_CaptionCall_001 - Step 19: Click office detail link");
		administrationPage.clickAdministrationOfficeDetailLink(office);
		promoCode = administrationPage.getAdministrationOfficePromoCode();
		
		log.info("sanity_CaptionCall_001 - Step 20: Select Patient tab");
		patientsPage = administrationPage.openPatientsPage(driver, ipClient);
		
		log.info("sanity_CaptionCall_001 - Step 21: Click Caption Call link");
		patientsPage.clickOnCaptionCallLink();
		
		log.info("sanity_CaptionCall_001 - Step 22: Input Caption Call Patient name");
		patientsPage.inputCaptionCallPatientName(validPatientLastName);
		
		log.info("sanity_CaptionCall_001 - Step 23: Click Caption Call Search button");
		patientsPage.clickOnCaptionCallSearchButton();
		
		log.info("VP: Caption call for patient should be displayed");
		verifyTrue(patientsPage.doesCaptionCallPatientNameDisplay(validPatientLastName));
		
		log.info("sanity_CaptionCall_001 - Step 24: Select Caption Call with Name");
		patientsPage.selectCaptionCallDetailLink(validPatientLastName);
		
		log.info("VP: Promo Code of caption call should consistent with office");
		verifyTrue(patientsPage.getCaptionCallDetailPromoCode().equals(promoCode));
		
		log.info("sanity_CaptionCall_001 - Step 25: Click Caption Call detail SendForm button");
		patientsPage.clickCaptionCallDetailSendFormButton();
		patientsPage.acceptAlert(driver);
		
		log.info("VP: New record should be changed to Sent");
		verifyTrue(patientsPage.getOutBoundFaxValue("1").equals("Sent"));
		
		log.info("sanity_CaptionCall_001 - Step 26: Click Caption Call detail Refax button");
		patientsPage.clickCaptionCallDetailRefaxButton();
		
		log.info("VP: New record Refax should be displayed");
		verifyTrue(patientsPage.getOutBoundFaxValue("2").equals("Refax"));
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
	private AdministrationPage administrationPage;
	private String organization, qaStaffUsername, password;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	private String providerName;
	private String office, promoCode;
}
