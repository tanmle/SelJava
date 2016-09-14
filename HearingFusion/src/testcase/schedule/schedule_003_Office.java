package schedule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;
import page.PageFactory;
import page.SchedulePage;
import common.AbstractTest;
import common.Constant;

public class schedule_003_Office extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
	}
	
	@Test(groups = { "regression" },description = "AAHNW - Detroit")
	public void Schedule_75_AAHNWDetroit()
	{
		log.info("Schedule_75 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_75 - Step 02: At Office dropdown, select AAHNW - Detroit");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectItemInOfficeCombobox("AAHNW - Detroit");
		
		log.info("VP: Show Providers of Office: AAHNW - Detroit: Barker, Bert - Hopkins, John");
		verifyTrue(schedulePage.isProviderItemDisplay("Barker, Bert"));
		verifyTrue(schedulePage.isProviderItemDisplay("Hopkins, John"));
	}
	
	@Test(groups = { "regression" },description = "ABC Accounting")
	public void Schedule_76_ABCAccounting()
	{		
		log.info("Schedule_76 - Step 01: At Office dropdown, select ABC Accounting");
		schedulePage.selectItemInOfficeCombobox("ABC Accounting");
		
		log.info("VP: Show Providers of Office: ABC Accounting: Barker, Bert");
		verifyTrue(schedulePage.isProviderItemDisplay("Barker, Bert"));
	}
	
	@Test(groups = { "regression" },description = "DEF Accounting")
	public void Schedule_77_DEFAccounting()
	{		
		log.info("Schedule_77 - Step 01: At Office dropdown, select DEF Accounting");
		schedulePage.selectItemInOfficeCombobox("DEF Accounting");
		
		log.info("VP: Show Providers of Office: DEF Accounting: Bulgakov, Micky Ph.D. - Zacuto, Tony CCC-A");
		verifyTrue(schedulePage.isProviderItemDisplay("Bulgakov, Micky Ph.D."));
		verifyTrue(schedulePage.isProviderItemDisplay("Zacuto, Tony CCC-A"));
	}
	
	@Test(groups = { "regression" },description = "Ed's Test Office")
	public void Schedule_78_EdTesOffice()
	{		
		log.info("Schedule_78 - Step 01: At Office dropdown, select Ed's Test Office");
		schedulePage.selectItemInOfficeCombobox("Ed's Test Office");
		
		log.info("VP: Show Providers of Office: Ed's Test Office: White, Snow");
		verifyTrue(schedulePage.isProviderItemDisplay("White, Snow"));
	}
	
	@Test(groups = { "regression" },description = "Good Office1")
	public void Schedule_79_GoodOffice1()
	{		
		log.info("Schedule_79 - Step 01: At Office dropdown, select Good Office1");
		schedulePage.selectItemInOfficeCombobox("Good Office1");
		
		log.info("VP: Show Providers of Office: Good Office1: Good Office1");
		verifyTrue(schedulePage.isProviderItemDisplay("Good Office1"));
	}
	
	@Test(groups = { "regression" },description = "Hearing Cent of king")
	public void Schedule_80_HearingCentOfKing()
	{		
		log.info("Schedule_80 - Step 01: At Office dropdown, select Hearing Cent of king");
		schedulePage.selectItemInOfficeCombobox("Hearing Cent of king");
		
		log.info("VP: Show Providers of Office: Hearing Cent of king: Hearing Cent of king");
		verifyTrue(schedulePage.isProviderItemDisplay("Hearing Cent of king"));
	}
	
	@Test(groups = { "regression" },description = "Hearing For All")
	public void Schedule_81_HearingForAll()
	{		
		log.info("Schedule_81 - Step 01: At Office dropdown, select Hearing For All");
		schedulePage.selectItemInOfficeCombobox("Hearing For All");
		
		log.info("VP: Show Providers of Office: Hearing For All: Needle, Space");
		verifyTrue(schedulePage.isProviderItemDisplay("Needle, Space"));
	}
	
	@Test(groups = { "regression" },description = "Hearing Fun Report")
	public void Schedule_82_HearingFunReport()
	{		
		log.info("Schedule_82 - Step 01: At Office dropdown, select Hearing Fun Report");
		schedulePage.selectItemInOfficeCombobox("Hearing Fun Report");
		
		log.info("VP: Show Providers of Office: Hearing Fun Report: Needle, Space - White, Snow");
		verifyTrue(schedulePage.isProviderItemDisplay("Needle, Space"));
		verifyTrue(schedulePage.isProviderItemDisplay("White, Snow"));
	}
	
	@Test(groups = { "regression" },description = "Henderson Ear Aloha")
	public void Schedule_83_HendersonEarAloha()
	{		
		log.info("Schedule_83 - Step 01: At Office dropdown, select Henderson Ear Aloha");
		schedulePage.selectItemInOfficeCombobox("Henderson Ear Aloha");
		
		log.info("VP: Show Providers of Office: Henderson Ear Aloha: Jones, Tom - Zacuto, Tony");
		verifyTrue(schedulePage.isProviderItemDisplay("Jones, Tom"));
		verifyTrue(schedulePage.isProviderItemDisplay("Zacuto, Tony"));
	}
	
	@Test(groups = { "regression" },description = " Ir office.")
	public void Schedule_84_IrOffice()
	{		
		log.info("Schedule_84 - Step 01: At Office dropdown, select  Ir office.");
		schedulePage.selectItemInOfficeCombobox("Ir office.");
		
		log.info("VP: Show Providers of Office: Ir office: Bulgakov, Micky Ph.D.");
		verifyTrue(schedulePage.isProviderItemDisplay("Bulgakov, Micky Ph.D."));
	}
	
	@Test(groups = { "regression" },description = "Las Vegas")
	public void Schedule_85_LasVegas()
	{		
		log.info("Schedule_85 - Step 01: At Office dropdown, select Las Vegas");
		schedulePage.selectItemInOfficeCombobox("Las Vegas");
		
		log.info("VP: Show Providers of Office: Las Vegas: Jones, Tom - Perfect, Hear");
		verifyTrue(schedulePage.isProviderItemDisplay("Jones, Tom"));
		verifyTrue(schedulePage.isProviderItemDisplay("Perfect, Hear"));
	}
	
	@Test(groups = { "regression" },description = "Pittsburgh")
	public void Schedule_86_Pittsburgh()
	{		
		log.info("Schedule_86 - Step 01: At Office dropdown, select Pittsburgh");
		schedulePage.selectItemInOfficeCombobox("Pittsburgh");
		
		log.info("VP: Show Providers of Office: Pittsburgh: Franklin, Ben");
		verifyTrue(schedulePage.isProviderItemDisplay("Franklin, Ben"));
	}
	
	@Test(groups = { "regression" },description = "Seattle")
	public void Schedule_87_Seattle()
	{		
		log.info("Schedule_87 - Step 01: At Office dropdown, select Seattle");
		schedulePage.selectItemInOfficeCombobox("Seattle");
		
		log.info("VP: Show Providers of Office: Seattle: Martin, Harry - Needle, Space");
		verifyTrue(schedulePage.isProviderItemDisplay("Martin, Harry"));
		verifyTrue(schedulePage.isProviderItemDisplay("Needle, Space"));
	}
	
	@Test(groups = { "regression" },description = "Sounds of Life Hearing Aids")
	public void Schedule_88_SoundsOfLifeHearingAids()
	{		
		log.info("Schedule_88 - Step 01: At Office dropdown, select Sounds of Life Hearing Aids");
		schedulePage.selectItemInOfficeCombobox("Sounds of Life Hearing Aids");
		
		log.info("VP: Show Providers of Office: Sounds of Life Hearing Aids: Bulgakov, Micky Ph.D. - Zacuto, Tony CCC-A");
		verifyTrue(schedulePage.isProviderItemDisplay("Bulgakov, Micky Ph.D."));
		verifyTrue(schedulePage.isProviderItemDisplay("Zacuto, Tony CCC-A"));
	}
	
	@Test(groups = { "regression" },description = "St. Louis")
	public void Schedule_89_StLouis()
	{		
		log.info("Schedule_89 - Step 01: At Office dropdown, select St. Louis");
		schedulePage.selectItemInOfficeCombobox("St. Louis");
		
		log.info("VP: Show Providers of Office: St. Louis: Audiologist, Tammy - Foolery, Tom");
		verifyTrue(schedulePage.isProviderItemDisplay("Audiologist, Tammy"));
		verifyTrue(schedulePage.isProviderItemDisplay("Foolery, Tom"));
	}
	
	@Test(groups = { "regression" },description = "Summerland Sound")
	public void Schedule_90_SummerlandSound()
	{		
		log.info("Schedule_90 - Step 01: At Office dropdown, select Summerland Sound");
		schedulePage.selectItemInOfficeCombobox("Summerland Sound");
		
		log.info("VP: Show Providers of Office: Summerland Sound: Zacuto, Tony CCC-A");
		verifyTrue(schedulePage.isProviderItemDisplay("Zacuto, Tony CCC-A"));
	}
	
	@Test(groups = { "regression" },description = "TestWarehouse")
	public void Schedule_91_TestWarehouse()
	{		
		log.info("Schedule_91 - Step 01: At Office dropdown, select TestWarehouse");
		schedulePage.selectItemInOfficeCombobox("TestWarehouse");
		
		log.info("VP: Show Providers of Office: TestWarehouse: TestWarehouse");
		verifyTrue(schedulePage.isProviderItemDisplay("TestWarehouse"));
		
		log.info("Post-Condition: Switch to default frame");
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
	private String organization, qaStaffUsername, password;
}