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
import common.Common;
import common.Constant;

public class schedule_007_TaskSchedule_SearchAppointment extends AbstractTest{

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
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		correctHour = 16;
		correctMinute = 0;
		apptType = "Annual Test";
		apptStatus = "Rescheduled";
		patientFull = "Wayne, Bruce   (Hearing Fun)";
		patientName = "Wayne, Bruce";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		dateString = month+"/"+date+"/"+year;
	}
	
	@Test(groups = { "regression" },description = "Leaving all fields blank")
	public void Schedule_44_LeavingAllFieldsBlank()
	{
		log.info("Schedule_44 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_44 - Step 02: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_44 - Step 03: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_44 - Step 04: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_44 - Step 05: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_44 - Step 06: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_44 - Step 07: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_44 - Step 08: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_44 - Step 09: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_44 - Step 10: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_44 - Step 11: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_44 - Step 12: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_44 - Step 13: Click on Reschedule link in Task");
		schedulePage.clickOnRescheduledLink();

		log.info("Schedule_44 - Step 14: Click on Search button");
		numberOfAppointmentItem = schedulePage.getNumberOfRescheduledAppointmentItem();
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Rescheduled Appointments");
		verifyEquals(numberOfAppointmentItem, schedulePage.getNumberOfRescheduledAppointmentItem());
	}
	
	@Test(groups = { "regression" },description = "Incorrect Patient Last Name, First Name")
	public void Schedule_45_IncorrectPatientLastNameFirstName()
	{
		log.info("Schedule_45 - Step 01: Input incorrect Patient Last name");
		schedulePage.inputPatientLastNameValue("incorrectPatientLastName");
		
		log.info("Schedule_45 - Step 02: Input incorrect Patient First name");
		schedulePage.inputPatientFirstNameValue("incorrectPatientFirstName");
		
		log.info("Schedule_45 - Step 03: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Message display with content 'No Rescheduled/Pending Appointments found'");
		verifyTrue(schedulePage.isSearchRescheduledAppointmentMessageDisplayWithContent("No Rescheduled/Pending Appointments found"));
	}
	
	@Test(groups = { "regression" },description = "Incorrect all fields")
	public void Schedule_46_IncorrectAllFields()
	{
		log.info("Schedule_46 - Step 01: Input incorrect Patient Last name");
		schedulePage.inputPatientLastNameValue("incorrectPatientLastName");
		
		log.info("Schedule_46 - Step 02: Input incorrect Patient First name");
		schedulePage.inputPatientFirstNameValue("incorrectPatientFirstName");
		
		log.info("Schedule_46 - Step 03: Input incorrect Patient Preferred Name");
		schedulePage.inputPatientPreferredNameValue("incorrectPatientPreferredName");
		
		log.info("Schedule_46 - Step 04: Input incorrect Provider Last Name");
		schedulePage.inputProviderLastNameValue("incorrectProviderLastName");
		
		log.info("Schedule_46 - Step 05: Input incorrect Provider First Name");
		schedulePage.inputProviderFirstNameValue("incorrectProviderFirstName");
		
		log.info("Schedule_46 - Step 06: Select Appointment Type");
		schedulePage.selectAppointmentType("Delivery");
		
		log.info("Schedule_46 - Step 07: Input incorrect Scheduled");
		schedulePage.inputScheduledValue("incorrectScheduled");
		
		log.info("Schedule_46 - Step 08: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Message display with content 'No Rescheduled/Pending Appointments found'");
		verifyTrue(schedulePage.isSearchRescheduledAppointmentMessageDisplayWithContent("No Rescheduled/Pending Appointments found"));
	}
	
	@Test(groups = { "regression" },description = "Correct Patient Last Name, Patient First Name , Patient Preferred Name")
	public void Schedule_47_CorrectPatientName()
	{
		log.info("Schedule_47 - Step 01: Input correct Patient Last name");
		schedulePage.inputPatientLastNameValue("Wayne");
		
		log.info("Schedule_47 - Step 02: Input correct Patient First name");
		schedulePage.inputPatientFirstNameValue("Bruce");
		
		log.info("Schedule_47 - Step 03: Input correct Patient Preferred Name");
		schedulePage.inputPatientPreferredNameValue("");
		
		log.info("Schedule_47 - Step 04: Input incorrect Provider Last Name");
		schedulePage.inputProviderLastNameValue("");
		
		log.info("Schedule_47 - Step 05: Input incorrect Provider First Name");
		schedulePage.inputProviderFirstNameValue("");
		
		log.info("Schedule_47 - Step 06: Select Appointment Type");
		schedulePage.selectAppointmentType("");
		
		log.info("Schedule_47 - Step 07: Input incorrect Scheduled");
		schedulePage.inputScheduledValue("");
		
		log.info("Schedule_47 - Step 08: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Rescheduled Appointments of Patient: Wayne, Bruce");
		verifyTrue(schedulePage.isListOfRescheduledAppointmentDisplayWithPatientInfor(patientName));
	}
	
	@Test(groups = { "regression" },description = "Correct all field")
	public void Schedule_48_CorrectAllField()
	{
		log.info("Schedule_48 - Step 01: Input correct Patient Last name");
		schedulePage.inputPatientLastNameValue("Wayne");
		
		log.info("Schedule_48 - Step 02: Input correct Patient First name");
		schedulePage.inputPatientFirstNameValue("Bruce");
		
		log.info("Schedule_48 - Step 03: Input correct Patient Preferred Name");
		schedulePage.inputPatientPreferredNameValue("");
		
		log.info("Schedule_48 - Step 04: Input correct Provider Last Name");
		schedulePage.inputProviderLastNameValue("Needle");
		
		log.info("Schedule_48 - Step 05: Input correct Provider First Name");
		schedulePage.inputProviderFirstNameValue("Space");
		
		log.info("Schedule_48 - Step 06: Select Appointment Type");
		schedulePage.selectAppointmentType(apptType);
		
		log.info("Schedule_48 - Step 07: Input correct Scheduled");
		schedulePage.inputScheduledValue("");
		
		log.info("Schedule_48 - Step 08: Click on Search button");
		schedulePage.clickOnSearchAppointmentButton();
		
		log.info("VP: Show list of Rescheduled Appointments with all correct infor");
		verifyTrue(schedulePage.isRescheduledAppointmentDisplayWithCorrectInfor(apptType, patientName, provider));
		
		log.info("Schedule_48 - Step 09: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("Schedule_48 - Step 10: Click on Reschedule link");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.clickOnRescheduledLink();
		
		log.info("Schedule_48 - Step 11: Cancel the appointment");
		schedulePage.clickOnCancelLinkForRescheduledAppointment(dateString, apptType, patientName, provider, apptStatus);
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
	private int date, month, year, correctHour, correctMinute, numberOfAppointmentItem;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime, noteContent, dateString;
}