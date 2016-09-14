package checkinAppointment;

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

public class checkinAppt_011_CBOBilling extends AbstractTest{

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
		correctStartTime ="03:00 PM";
		correctEndTime = "04:00 PM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		section = "CBO Billing Notes";
		message = getUniqueName();
		newMessage = getUniqueName();
	}
	
	@Test(groups = { "regression" },description = "CBO Billing Notes: Input data into all fieds")
	public void checkinAppt_68_CBOBillingInputDataIntoAllFields()
	{
		log.info("CheckinAppt_68 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_68 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_68 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_68 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_68 - Step 05: Expand 'CBO Billing Notes' section");
		patientsPage.expandSectionOnCheckin(section);
		
		log.info("CheckinAppt_68 - Step 06: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("CheckinAppt_68 - Step 07: Select Assigned ");
		patientsPage.selectCBOAssign("Staff,QA");
		
		log.info("CheckinAppt_68 - Step 08: Input follow ");
		patientsPage.inputCBOFollow(month,date,year);
		
		log.info("CheckinAppt_68 - Step 09: Input new message ");
		patientsPage.inputCBONewMessage(message);
		
		log.info("CheckinAppt_68 - Step 10: Upload CBO file ");
		patientsPage.uploadCBOFile(driver);
		
		log.info("CheckinAppt_68 - Step 11: select CBO status");
		patientsPage.selectCBOStatus("New");
		
		log.info("CheckinAppt_68 - Step 12: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Save & Return to Patient screen successfully");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());

	}
	@Test(groups = { "regression" },description = "CBO Billing Notes: Message_expanded view")
	public void checkinAppt_69_CBOBillingMessageExpandedView()
	{
		log.info("CheckinAppt_69 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_69 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_69 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_69 - Step 05: Expand 'CBO Billing Notes' section");
		patientsPage.expandSectionOnCheckin(section);

		log.info("CheckinAppt_69 - Step 06: click the yellow icon to open Note Details page");
		patientsPage.openCBOBillingNoteDetailPage(message);
		
		log.info("CheckinAppt_68 - Step 07: Input new message ");
		patientsPage.inputCBONewMessage(newMessage);
		
		log.info("CheckinAppt_68 - Step 08: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("CheckinAppt_69 - Step 09: Click on a message to view details");
		patientsPage.openCBOBillingNoteMessageDetails(message);
		
		log.info("VP: Open details page successfully");
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);

		verifyTrue(patientsPage.isCBOBillingMessageDetailDisplays(message));
		
		driver.close();
		driver.switchTo().window(currentHandle);
		
	}
	@Test(groups = { "regression" },description = "CBO Billing Notes: Message expanded view print")
	public void checkinAppt_71_CBOBillingMessageExpandedView()
	{
		log.info("CheckinAppt_71 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_71 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_71 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_71 - Step 05: Expand 'CBO Billing Notes' section");
		patientsPage.expandSectionOnCheckin(section);

		log.info("CheckinAppt_71 - Step 06: click the yellow icon to open Note Details page");
		patientsPage.openCBOBillingNoteDetailPage(newMessage);
		
		log.info("CheckinAppt_71 - Step 07: Click on a message to view details");
		patientsPage.openCBOBillingNoteMessageDetails(message);
		
		log.info("VP: Print message successfully");
		verifyTrue(patientsPage.isCBOBillingMessageDetailPrintDisplays(driver));

		//Post-condition
		log.info("Post-condition - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("Post-condition - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Post-condition - Step 03: Delete appointment");
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
	private String organization, qaStaffUsername, password;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider ;
	private String correctStartTime, correctEndTime, noteContent, message;
	private String section, newMessage;
	private final Stack<String> openWindowHandles = new Stack<String>();
}