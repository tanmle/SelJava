package section;

import java.util.Set;
import java.util.Stack;

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

public class section_003_AppointmentScheduling extends AbstractTest{

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
		hour = Common.getCommon().getCurrentHours();
		minute = Common.getCommon().getCurrentMinutes();
		correctHour = 16;
		correctMinute = 0;
		dateString = month+"/"+date+"/"+year;
		noteForConfirmAppointment = "Note for confirm appointment";
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		apptType = "Annual Test";
		patientFull = "Baker, Mark   (Henderson Ear)";
		patientName = "Baker, Mark";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		movingHour = correctHour+1;
		movingStartTime = "05:00 PM";
		movingEndTime = "05:30 PM";
		editRefResource = "Facebook";
		editNoteContent = "Edit Note Content";
		apptStatus = "Scheduled";
		leftMsgStatus = "Left Message";
		confirmStatus = "Confirmed";
		arriedStatus = "Arrived";
		departedStatus = "Departed";
		completeStatus = "Completed";
		noShowStatus = "No-show";
		otherStatus = "Hold";
		locateHour = "0 hours 30 minutes";
		locateWeek = "At Least 1 Week From Now";
		editApptType = "Consultation";
		editApptStatus = "Confirmed";
		editNoteContent = "Edit Note Content";
		editRefResource = "Facebook";
		apptRescheduleStatus = "Rescheduled";
	}
	
	@Test(groups = { "regression" },description = " Create new Appointment ")
	public void AppointmentScheduling_01_CreateNewAppointment()
	{
		log.info("AppointmentScheduling_01 : Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("AppointmentScheduling_01 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("AppointmentScheduling_01 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("AppointmentScheduling_01 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("AppointmentScheduling_01 - Step 04: Open Add Patient popup");
		schedulePage.oppenAddPatientPopup();
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Help page is opened");
		verifyTrue(schedulePage.isAddPatientPopupDisplays());
		
		driver.close();
		driver.switchTo().window(currentHandle);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("AppointmentScheduling_01 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("AppointmentScheduling_01 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("AppointmentScheduling_01 - Step 06: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("AppointmentScheduling_01 - Step 07: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: Save appointment successfully");
		verifyTrue(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientName));
		
		log.info("VP: Save appointment successfully");
		verifyTrue(schedulePage.isAppointmentEventNoteDisplaysCorrect(date, month, year, apptType, patientName, apptStatus, patientName, provider ));
		
	}
	
	@Test(groups = { "regression" },description = "Moving a Calendar event")
	public void AppointmentScheduling_02_MovingCalendarEvent()
	{		
		log.info("AppointmentScheduling_02 - Step 01: Moving the Calendar event to another time");
		schedulePage.moveCalendarEventToAnotherTime(date, month, year, apptType, patientName, movingHour, correctMinute);
		
		log.info("VP: Start time and End time will be updated automatically");
		verifyTrue(schedulePage.isStartTimeDisplayCorrectly(movingStartTime));
		verifyTrue(schedulePage.isEndTimeDisplayCorrectly(movingEndTime));
		
		log.info("AppointmentScheduling_02 - Step 02: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();

	}
	@Test(groups = { "regression" },description = "Edit Calendar event")
	public void AppointmentScheduling_03_EditCalendarEvent()
	{		
		log.info("AppointmentScheduling_03 - Step 01: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("AppointmentScheduling_03 - Step 02: Edit data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(editApptType);
		
		log.info("AppointmentScheduling_03 - Step 03: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(editApptStatus);
		
		log.info("AppointmentScheduling_03 - Step 04: Edit data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(editRefResource);
		
		log.info("AppointmentScheduling_03 - Step 05: Edit note");
		schedulePage.inputNoteOnCalendarEventPopup(editNoteContent);
		
		log.info("AppointmentScheduling_03 - Step 06: Edit data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("AppointmentScheduling_03 - Step 07: Edit data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("AppointmentScheduling_03 - Step 08: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: Edit Calendar event successfully");
		verifyTrue(schedulePage.isAppointmentSavedSuccessfully(date, month, year, editApptType, patientName));
		
		log.info("AppointmentScheduling_03 - Step 09: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, editApptType, patientName);
		
		log.info("AppointmentScheduling_03 - Step 10: Delete appointment");
		schedulePage.deleteAppointment();
		
	}
	@Test(groups = { "regression" },description = "Unavailable checkbox is checked")
	public void AppointmentScheduling_04_UnavailableCheckbox()
	{
		log.info("AppointmentScheduling_04 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, hour, minute);
		
		log.info("AppointmentScheduling_04 - Step 02: Tick on the Unavailable checkbox");
		schedulePage.selectUnavailableCheckbox(true);
		
		log.info("VP: Appt. type will be disabled");
		verifyTrue(schedulePage.isApptTypeDisableOnCalendarEventPopup());
		
		log.info("VP: Appt. status will be disable");
		verifyTrue(schedulePage.isApptStatusDisableOnCalendarEventPopup());
		
		log.info("VP: Patient will be disable");
		verifyTrue(schedulePage.isPatientDisableOnCalendarEventPopup());
		
		log.info("VP: Ref. Source will be disable");
		verifyTrue(schedulePage.isRefResourceDisableOnCalendarEventPopup());
		
		log.info("AppointmentScheduling_04 - Step 3: Click Cancel button");
		schedulePage.clickCancelButton();
	}
	
	@Test(groups = { "regression" },description = "Schedule Block checkbox is checked")
	public void AppointmentScheduling_05_ScheduleBlockCheckboxIsChecked()
	{
		log.info("AppointmentScheduling_05 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, hour, minute);
		
		log.info("AppointmentScheduling_05 - Step 02: Tick on the Schedule Block checkbox");
		schedulePage.selectScheduleBlockCheckbox(true);
		
		log.info("VP: Appt. status will be disable");
		verifyTrue(schedulePage.isApptStatusDisableOnCalendarEventPopup());
		
		log.info("VP: Patient will be disable");
		verifyTrue(schedulePage.isPatientDisableOnCalendarEventPopup());
		
		log.info("VP: Ref. Source will be disable");
		verifyTrue(schedulePage.isRefResourceDisableOnCalendarEventPopup());
		
		log.info("AppointmentScheduling_05 - Step 03: Click Cancel button");
		schedulePage.clickCancelButton();
	}

	@Test(groups = { "regression" },description = "Calendar Event Status")
	public void AppointmentScheduling_06_CalendarEventStatus()
	{
		//Scheduler status
		log.info("AppointmentScheduling_06 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, hour, minute);
		
		log.info("AppointmentScheduling_06 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("AppointmentScheduling_06 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("AppointmentScheduling_06 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("AppointmentScheduling_06 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("AppointmentScheduling_06 - Step 06: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("AppointmentScheduling_06 - Step 07: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();

		log.info("VP: scheduler event icon Scheduled displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,apptStatus));
		
		//left message
		log.info("AppointmentScheduling_06 - Step 08: Open Appointment details");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("AppointmentScheduling_06 - Step 09: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(leftMsgStatus);
		
		log.info("AppointmentScheduling_06 - Step 10: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: scheduler event icon left message displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,leftMsgStatus));
		
		//Confirmed
		log.info("AppointmentScheduling_06 - Step 11: Open Appointment details");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("AppointmentScheduling_06 - Step 12: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(confirmStatus);
		
		log.info("AppointmentScheduling_06 - Step 13: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: scheduler event icon Confirmed displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,confirmStatus));

		//Arrived
		log.info("AppointmentScheduling_06 - Step 14: Open Appointment details");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,apptType, patientName);

		log.info("AppointmentScheduling_06 - Step 15: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(arriedStatus);

		log.info("AppointmentScheduling_06 - Step 16: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();

		log.info("VP: scheduler event icon Arrived displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,arriedStatus));

		//Departed
		log.info("AppointmentScheduling_06 - Step 17: Open Appointment details");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,apptType, patientName);

		log.info("AppointmentScheduling_06 - Step 18: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(departedStatus);

		log.info("AppointmentScheduling_06 - Step 19: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();

		log.info("VP: scheduler event icon Departed displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,departedStatus));

		//Completed
		log.info("AppointmentScheduling_06 - Step 20: Open Appointment details");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,apptType, patientName);

		log.info("AppointmentScheduling_06 - Step 21: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(completeStatus);

		log.info("AppointmentScheduling_06 - Step 22: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();

		log.info("VP: scheduler event icon Completed displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,completeStatus));
		
		//No Show
		log.info("AppointmentScheduling_06 - Step 23: Open Appointment details");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,apptType, patientName);

		log.info("AppointmentScheduling_06 - Step 24: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(noShowStatus);

		log.info("AppointmentScheduling_06 - Step 25: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();

		log.info("VP: scheduler event icon No Show displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,noShowStatus));
		
		//Other
		log.info("AppointmentScheduling_06 - Step 26: Open Appointment details");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year,apptType, patientName);

		log.info("AppointmentScheduling_06 - Step 27: Edit data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(otherStatus);

		log.info("AppointmentScheduling_06 - Step 28: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();

		log.info("VP: scheduler event icon Other displays");
		verifyTrue(schedulePage.isApptStatusDisplayCorrectlyOnScheduleDashboard(date, month, year, apptType, patientName,otherStatus));
		
		log.info("AppointmentScheduling_06 - Step 29: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("AppointmentScheduling_06 - Step 30: Delete appointment");
		schedulePage.deleteAppointment();
	}

	@Test(groups = { "regression" },description = "Confirm an appointment")
	public void AppointmentScheduling_07_ConfirmAnAppointment()
	{
		log.info("AppointmentScheduling_07 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("AppointmentScheduling_07 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("AppointmentScheduling_07 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("AppointmentScheduling_07 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("AppointmentScheduling_07 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("AppointmentScheduling_07 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("AppointmentScheduling_07 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("AppointmentScheduling_07 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("AppointmentScheduling_07 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("AppointmentScheduling_07 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("AppointmentScheduling_07 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("AppointmentScheduling_07 - Step 12: Click on Confirmation link in Task");
		schedulePage.clickOnConfirmationLink();
		
		log.info("VP: Appointment display on List of Confirmed Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("AppointmentScheduling_07 - Step 13: Click on Confirm link for an appointment");
		schedulePage.clickOnConfirmLinkForAnAppointment(dateString, apptType, patientName, provider, apptStatus);
		
		log.info("AppointmentScheduling_07 - Step 14: Input note for Confirm Appointment");
		schedulePage.addNoteForConfirmAppointment(noteForConfirmAppointment);
		
		log.info("VP: Appointment disappears on List of Confirmed Appointments");
		verifyFalse(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("AppointmentScheduling_07 - Step 15: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("AppointmentScheduling_07 - Step 16: Open the Appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("VP: Appt Status is Confirmed");
		schedulePage.isApptStatusDisplayCorrectly("Confirmed");
		
		log.info("AppointmentScheduling_07 - Step 17: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "List of Pending/Rescheduled Appointments is showed")
	public void AppointmentScheduling_08_ListOfPendingRescheduledAppointmentsIsShowed()
	{
		log.info("AppointmentScheduling_08 - Step 02: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("AppointmentScheduling_08 - Step 03: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("AppointmentScheduling_08 - Step 04: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptRescheduleStatus);
		
		log.info("AppointmentScheduling_08 - Step 05: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("AppointmentScheduling_08 - Step 06: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("AppointmentScheduling_08 - Step 07: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("AppointmentScheduling_08 - Step 08: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("AppointmentScheduling_08 - Step 09: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("AppointmentScheduling_08 - Step 10: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("AppointmentScheduling_08 - Step 11: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("AppointmentScheduling_08 - Step 12: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_37 - Step 13: Click on Rescheduled link in Task");
		schedulePage.clickOnRescheduledLink();
		
		log.info("VP: List of Confirmed Pending/Reshceduled is showed");
		verifyTrue(schedulePage.isListOfPendingRescheduledAppointmentsDisplay());
		
		log.info("VP: Appointment display on List of Pending/Reshceduled Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfPendingRescheduled(dateString, apptType, patientName, provider, apptRescheduleStatus));
	}
	@Test(groups = { "regression" },description = "View History")
	public void AppointmentScheduling_09_ViewHistory()
	{		
		log.info("AppointmentScheduling_09 - Pre Condition: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("AppointmentScheduling_09 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("AppointmentScheduling_09 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("AppointmentScheduling_09 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("AppointmentScheduling_09 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("AppointmentScheduling_09 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("AppointmentScheduling_09 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("AppointmentScheduling_09 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("AppointmentScheduling_09 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("AppointmentScheduling_09 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("AppointmentScheduling_09 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("AppointmentScheduling_09 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("AppointmentScheduling_09 - Step 12: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("AppointmentScheduling_09 - Step 13: Click on History link to view History popup");
		schedulePage.clickOnHistoryLinkOnNewCalendarEvent();
		
		log.info("VP: Website will show History popup");
		verifyTrue(schedulePage.isHistoryPopupDisplay());
		
		log.info("AppointmentScheduling_09 - Step 14: Close History Popup");
		schedulePage.closeHistoryPopup();
		
		log.info("AppointmentScheduling_09 - Step 15: Click Cancel button");
		schedulePage.deleteAppointment();
	}
	@Test(groups = { "regression" },description = "Search Appointment")
	public void AppointmentScheduling_10_SearchAppointment()
	{	
		log.info("AppointmentScheduling_10 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("AppointmentScheduling_10 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("AppointmentScheduling_10 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("AppointmentScheduling_10 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("AppointmentScheduling_10 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("AppointmentScheduling_10 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("AppointmentScheduling_10 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("AppointmentScheduling_10 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("AppointmentScheduling_10 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("AppointmentScheduling_10 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("AppointmentScheduling_10 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("AppointmentScheduling_10 - Step 11: Click Save and Exit button");
		schedulePage.searchAppointmentByName(patientName);

		log.info("VP: Search appointment successfully");
		verifyTrue(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientName));
		
		log.info("AppointmentScheduling_10 - Step 12: Delete appointment");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		schedulePage.deleteAppointment();
		
		log.info("AppointmentScheduling_10 - Step 13: Click Save and Exit button");
		schedulePage.seachLocateSlot(locateHour,locateWeek);

		log.info("VP: Search appointment successfully");
		verifyTrue(schedulePage.isAppointmentLocateDisplays());
		
		log.info("AppointmentScheduling_10 - Step 14: Switch frame to Top Window");
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
	private String  noteContent;
	private int date, month, year, hour, minute, correctHour, correctMinute, movingHour;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime, dateString, noteForConfirmAppointment;
	private String editNoteContent, locateHour, locateWeek;
	private String editApptType, editApptStatus, editRefResource, apptRescheduleStatus;
	private final Stack<String> openWindowHandles = new Stack<String>();
	private String  movingStartTime, movingEndTime;
	private String leftMsgStatus, confirmStatus, arriedStatus, departedStatus, completeStatus, noShowStatus, otherStatus;
}