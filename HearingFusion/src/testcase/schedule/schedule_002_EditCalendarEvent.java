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

public class schedule_002_EditCalendarEvent extends AbstractTest{

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
		movingHour = correctHour+1;
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		movingStartTime = "05:00 PM";
		movingEndTime = "05:30 PM";
		apptType = "Annual Test";
		editApptType = "Consultation";
		apptStatus = "Scheduled";
		editApptStatus = "Confirmed";
		patientFull = "Baker, Mark   (Henderson Ear)";
		patientName = "Baker, Mark";
		refResource = "Campaign";
		editRefResource = "Facebook";
		provider = "Needle, Space";
		noteContent = "Note Content";
		editNoteContent = "Edit Note Content";
	}
	
	@Test(groups = { "regression" },description = "Delete Calendar event")
	public void Schedule_17_DeleteCalendarEvent()
	{
		log.info("Schedule_17 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_17 - Step 02: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_17 - Step 03: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_17 - Step 04: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_17 - Step 05: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_17 - Step 06: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_17 - Step 07: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_17 - Step 08: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_17 - Step 09: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_17 - Step 10: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_17 - Step 11: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_17 - Step 12: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_17 - Step 13: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_17 - Step 14: Delete appointment");
		schedulePage.deleteAppointment();
		
		log.info("VP: Calendar event will be deleted");
		verifyFalse(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientName));
	}
	
	@Test(groups = { "regression" },description = "View History")
	public void Schedule_19_ViewHistory()
	{		
		log.info("Schedule_19 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_19 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_19 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_19 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_19 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_19 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_19 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_19 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_19 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_19 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_19 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_19 - Step 12: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_19 - Step 13: Click on History link to view History popup");
		schedulePage.clickOnHistoryLinkOnNewCalendarEvent();
		
		log.info("VP: Website will show History popup");
		verifyTrue(schedulePage.isHistoryPopupDisplay());
		
		log.info("Schedule_19 - Step 14: Close History Popup");
		schedulePage.closeHistoryPopup();
		
		log.info("Schedule_19 - Step 15: Click Cancel button");
		schedulePage.clickCancelButton();
	}
	
	@Test(groups = { "regression" },description = "Moving a Calendar event")
	public void Schedule_20_MovingCalendarEvent()
	{		
		log.info("Schedule_20 - Step 01: Moving the Calendar event to another time");
		schedulePage.moveCalendarEventToAnotherTime(date, month, year, apptType, patientName, movingHour, correctMinute);
		
		log.info("VP: Start time and End time will be updated automatically");
		verifyTrue(schedulePage.isStartTimeDisplayCorrectly(movingStartTime));
		verifyTrue(schedulePage.isEndTimeDisplayCorrectly(movingEndTime));
		
		log.info("Schedule_20 - Step 02: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
	}
	
	@Test(groups = { "regression" },description = "Edit Calendar event")
	public void Schedule_21_EditCalendarEvent()
	{		
		log.info("Schedule_21 - Step 01: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_21 - Step 02: Edit data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(editApptType);
		
		log.info("Schedule_21 - Step 03: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(editApptStatus);
		
		log.info("Schedule_21 - Step 04: Edit data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(editRefResource);
		
		log.info("Schedule_21 - Step 05: Edit note");
		schedulePage.inputNoteOnCalendarEventPopup(editNoteContent);
		
		log.info("Schedule_21 - Step 06: Edit data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_21 - Step 07: Edit data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
//		log.info("Schedule_21 - Step 08: Edit data in Provider");
//		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_21 - Step 09: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: Edit Calendar event successfully");
		verifyTrue(schedulePage.isAppointmentSavedSuccessfully(date, month, year, editApptType, patientName));
		
		log.info("Schedule_21 - Step 10: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, editApptType, patientName);
		
		log.info("Schedule_21 - Step 11: Delete appointment");
		schedulePage.deleteAppointment();
		
		log.info("Schedule_21 - Step 12: Switch frame to Top Window");
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
	private String noteContent, editNoteContent;
	private int date, month, year, correctHour, correctMinute, movingHour;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String editApptType, editApptStatus, editRefResource;
	private String correctStartTime, correctEndTime, movingStartTime, movingEndTime;
}