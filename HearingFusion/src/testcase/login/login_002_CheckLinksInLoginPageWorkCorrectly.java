package login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.PageFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import page.LoginPage;
import common.AbstractTest;

public class login_002_CheckLinksInLoginPageWorkCorrectly extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
	}
	
	@Test(groups = { "regression" },description = "Check About Hearing Fusion link work correctly")
	public void Login_09_CheckAboutHearingFusionLinkWorkCorrectly()
	{
		log.info("Login_09 - Step 01: Click on About Hearing Fusion link");
		loginPage.clickOnAboutHearingFusionLink();
		
		log.info("VP: About Hearing Fusion page displays");
		verifyTrue(loginPage.isTitleTextOfPageDisplay("About Hearing Fusion"));
	}
	
	@Test(groups = { "regression" },description = "Check Corporate, Privacy and Contact link work correctly")
	public void Login_10_CheckCorporatePrivacyAndContactLinkWorkCorrectly()
	{
		log.info("Login_10 - Step 01: Click on Corporate link");
		loginPage.clickOnCorporateLink();
		
		log.info("VP: Corporate page displays");
		verifyTrue(loginPage.isTitleTextOfPageDisplay("Corporate"));
		
		log.info("Login_10 - Step 02: Click on Privacy link");
		loginPage.clickOnPrivacyLink();
		
		log.info("VP: Privacy page displays");
		verifyTrue(loginPage.isTitleTextOfPageDisplay("Privacy"));
		
		log.info("Login_10 - Step 03: Click on Contact link");
		loginPage.clickOnContactLink();
		
		log.info("VP: Contact page displays");
		verifyTrue(loginPage.isTitleTextOfPageDisplay("Contact"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser(driver);
	}
	
	private WebDriver driver;
	private LoginPage loginPage;
}