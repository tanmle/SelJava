package checkinAppointment;

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

public class checkinAppt_001_SavePatientDetails extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		errorLastName = "Patient Last Name is required";
		errorFirstName = "Patient First Name is required";
		errorHomePhone = "Home Phone is required";
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		correctHour = 16;
		correctMinute = 0;
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Cerumen management";
		apptStatus = "Scheduled";
		patientFull = "Russo, John   (Hearing Fun)";
		patientName = "Russo, John";
		patientLastName = "Russo";
		patientFirstName = "John";
		patientHomePhone = "310-454-5857";
		patientMobilePhone = "310-454-6789";
		patientWorkPhone = "310-454-5678";
		patientEmail1 = "patientEmail1@gmail.com";
		patientEmail2 = "patientEmail2@gmail.com";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
	}
	
	@Test(groups = { "regression" },description = "Leaving required fields blank")
	public void checkinAppt_01_LeavingRequiredFieldsBlank()
	{
		log.info("CheckinAppt_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_01 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_01 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_01 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_01 - Step 05: Leaving Patient Last Name blank");
		patientsPage.clickOKButton();
		patientsPage.inputValueToPatientLastNameField("");
		
		log.info("CheckinAppt_01 - Step 06: Leaving Patient First Name blank");
		patientsPage.inputValueToPatientFirstNameField("");
		
		log.info("CheckinAppt_01 - Step 07: Leaving Home Phone blank");
		patientsPage.inputValueToHomePhoneField("");
		
		log.info("CheckinAppt_01 - Step 08: Click save Patient Detail button");
		patientsPage.clickOnSavePatientDetailButton();
		
		log.info("VP: Error message display with content: 'Patient Last Name is required'");
		verifyTrue(patientsPage.isPatientDetailErrorMessageDisplayWithContent(errorLastName));
		
		log.info("VP: Error message display with content: 'Patient First Name is required'");
		verifyTrue(patientsPage.isPatientDetailErrorMessageDisplayWithContent(errorFirstName));
		
		log.info("VP: Error message display with content: 'Home Phone is required'");
		verifyTrue(patientsPage.isPatientDetailErrorMessageDisplayWithContent(errorHomePhone));
	}
	
	@Test(groups = { "regression" },description = "Input data into all required fields")
	public void checkinAppt_02_InputDataIntoAllRequiredFields()
	{
		log.info("CheckinAppt_02 - Step 01: Input data into Patient Last Name");
		patientsPage.inputValueToPatientLastNameField(patientLastName);
		
		log.info("CheckinAppt_02 - Step 02: Input data into Patient First Name");
		patientsPage.inputValueToPatientFirstNameField(patientFirstName);
		
		log.info("CheckinAppt_02 - Step 03: Input data into Home Phone");
		patientsPage.inputValueToHomePhoneField(patientHomePhone);
		
		log.info("CheckinAppt_02 - Step 04: Click save Patient Detail button");
		patientsPage.clickOnSavePatientDetailButton();
	
		log.info("VP: Save successfully");
		verifyTrue(patientsPage.isPatientDetailSaveSuccessfullyMessageDisplay());
	}
	
	@Test(groups = { "regression" },description = "Input invalid data into Home Phone, Mobile Phone, Work Phone, Email 1 ,  Email 2")
	public void checkinAppt_03_InputInvalidDataIntoPhoneAndEmailFeild()
	{
		log.info("CheckinAppt_03 - Step 01: Input invalid data into Home Phone");
		patientsPage.inputValueToHomePhoneField("invalidPatientHomePhone");
		
		log.info("CheckinAppt_03 - Step 02: Input invalid data into MobilePhone");
		patientsPage.inputValueToMobilePhoneField("invalidPatientMobilePhone");
		
		log.info("CheckinAppt_03 - Step 03: Input invalid data into Work Phone");
		patientsPage.inputValueToWorkPhoneField("invalidPatientWorkPhone");
		
		log.info("CheckinAppt_03 - Step 04: Input invalid data into Email1");
		patientsPage.inputValueToEmail1Field("invalidPatientEmail1");
		
		log.info("CheckinAppt_03 - Step 05: Input invalid data into Email2");
		patientsPage.inputValueToEmail2Field("invalidPatientEmail2");
		
		log.info("CheckinAppt_03 - Step 06: Click save Patient Detail button");
		patientsPage.clickOnSavePatientDetailButton();
	
		log.info("VP: Error message display with content: 'Not a valid Phone Number.'");
		verifyTrue(patientsPage.isPatientDetailErrorMessageDisplayWithContent("Not a valid Phone Number."));
		
		log.info("VP: Error message display with content: 'Enter a valid email address'");
		verifyTrue(patientsPage.isPatientDetailErrorMessageDisplayWithContent("Enter a valid email address"));
	}
	
	@Test(groups = { "regression" },description = "Input valid data into Home Phone, Mobile Phone, Work Phone, Email 1 ,  Email 2")
	public void checkinAppt_04_InputValidDataIntoPhoneAndEmailFeild()
	{
		log.info("CheckinAppt_04 - Step 01: Input valid data into Home Phone");
		patientsPage.inputValueToHomePhoneField(patientHomePhone);
		
		log.info("CheckinAppt_04 - Step 02: Input valid data into MobilePhone");
		patientsPage.inputValueToMobilePhoneField(patientMobilePhone);
		
		log.info("CheckinAppt_04 - Step 03: Input valid data into Work Phone");
		patientsPage.inputValueToWorkPhoneField(patientWorkPhone);
		
		log.info("CheckinAppt_04 - Step 04: Input valid data into Email1");
		patientsPage.inputValueToEmail1Field(patientEmail1);
		
		log.info("CheckinAppt_04 - Step 05: Input valid data into Email2");
		patientsPage.inputValueToEmail2Field(patientEmail2);
		
		log.info("CheckinAppt_04 - Step 06: Click save Patient Detail button");
		patientsPage.clickOnSavePatientDetailButton();
	
		log.info("VP: Save successfully");
		verifyTrue(patientsPage.isPatientDetailSaveSuccessfullyMessageDisplay());
		
		log.info("CheckinAppt_04 - Step 07: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_04 - Step 08: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_04 - Step 09: Delete appointment");
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
	private String errorLastName, errorFirstName, errorHomePhone, noteContent;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime;
	private String patientLastName, patientFirstName, patientHomePhone, patientMobilePhone;
	private String patientWorkPhone, patientEmail1, patientEmail2;
}