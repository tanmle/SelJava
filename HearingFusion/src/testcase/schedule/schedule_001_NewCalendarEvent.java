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

public class schedule_001_NewCalendarEvent extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		errorTextAppt = "Appt. Type should be selected";
		errorTextPatient = "Patient should be selected";
		errorTextRef = "Ref. Source should be selected";
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		hour = Common.getCommon().getCurrentHours();
		minute = Common.getCommon().getCurrentMinutes();
		dateMinus = handleDateMinus(-1);
		monthMinus = handleMonthMinus(-1);
		yearMinus = handleYearMinus(-1);
		correctHour = 16;
		correctMinute = 0;
		incorrectHour = 4;
		correctStartTime = "04:00 PM";
		correctEndTime = "05:00 PM";
		incorrectStartTime = "04:00 AM";
		incorrectEndTime = "04:30 AM";
		apptType = "Annual Test";
		apptStatus = "Scheduled";
		patientFull = "Baker, Mark   (Henderson Ear)";
		patientName = "Baker, Mark";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		longNote = getRandomStringWithLength(101);
	}
	
	@Test(groups = { "regression" },description = "Check Hearing Fusion Icon Display")
	public void Schedule_01_CheckHearingFusionIconDisplay()
	{
		log.info("Schedule_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("VP: HF icon will be shown at the top-left corner");
		verifyTrue(schedulePage.isHearingFusionIconDisplay());
	}
	
	@Test(groups = { "regression" },description = "Leaving all required fields blank")
	public void Schedule_02_LeavingAllRequiredFieldsBlank()
	{
		log.info("Schedule_02 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, hour, minute);
		
		log.info("Schedule_02 - Step 02: Leaving all required fields in the form blank");
		log.info("Schedule_02 - Step 03: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: An error message displays with contents: '"+ errorTextAppt +"'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup(errorTextAppt));
		
		log.info("VP: An error message displays with contents: '"+ errorTextPatient +"'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup(errorTextPatient));
		
		log.info("VP: An error message displays with contents: '"+ errorTextRef +"'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup(errorTextRef));
		
		log.info("Schedule_02 - Step 04: Click Cancel button");
		schedulePage.clickCancelButton();
	}
	
	@Test(groups = { "regression" },description = " All required fields are filled out.")
	public void Schedule_03_AllRequiredFieldsAreFilledOut()
	{
		log.info("Schedule_03 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_03 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_03 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_03 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_03 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_03 - Step 06: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_03 - Step 07: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: Save appointment successfully");
		verifyTrue(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientName));
		
		log.info("Schedule_03 - Step 08: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_03 - Step 09: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Unavailable checkbox is checked")
	public void Schedule_04_UnavailableCheckboxIsChecked()
	{
		log.info("Schedule_04 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, hour, minute);
		
		log.info("Schedule_04 - Step 02: Tick on the Unavailable checkbox");
		schedulePage.selectUnavailableCheckbox(true);
		
		log.info("VP: Appt. type will be disabled");
		verifyTrue(schedulePage.isApptTypeDisableOnCalendarEventPopup());
		
		log.info("VP: Appt. status will be disable");
		verifyTrue(schedulePage.isApptStatusDisableOnCalendarEventPopup());
		
		log.info("VP: Patient will be disable");
		verifyTrue(schedulePage.isPatientDisableOnCalendarEventPopup());
		
		log.info("VP: Ref. Source will be disable");
		verifyTrue(schedulePage.isRefResourceDisableOnCalendarEventPopup());
		
		log.info("Schedule_04 - Step 3: Click Cancel button");
		schedulePage.clickCancelButton();
	}
	
	@Test(groups = { "regression" },description = "Schedule Block checkbox is checked")
	public void Schedule_05_ScheduleBlockCheckboxIsChecked()
	{
		log.info("Schedule_05 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, hour, minute);
		
		log.info("Schedule_05 - Step 02: Tick on the Schedule Block checkbox");
		schedulePage.selectScheduleBlockCheckbox(true);
		
		log.info("VP: Appt. status will be disable");
		verifyTrue(schedulePage.isApptStatusDisableOnCalendarEventPopup());
		
		log.info("VP: Patient will be disable");
		verifyTrue(schedulePage.isPatientDisableOnCalendarEventPopup());
		
		log.info("VP: Ref. Source will be disable");
		verifyTrue(schedulePage.isRefResourceDisableOnCalendarEventPopup());
		
		log.info("Schedule_05 - Step 03: Click Cancel button");
		schedulePage.clickCancelButton();
	}
	
	@Test(groups = { "regression" },description = "Start date is less than the current date")
	public void Schedule_06_StartDateIsLessThanTheCurrentDate()
	{
		log.info("Schedule_06 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(dateMinus, monthMinus, yearMinus, correctHour, correctMinute);
		
		log.info("Schedule_06 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_06 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_06 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_06 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_06 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_06 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(dateMinus, monthMinus, yearMinus);
		
		log.info("Schedule_06 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_06 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_06 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_06 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: An error message displays with contents: 'Start date cannot be a past date'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup("Start date cannot be a past date"));
		
		//will be removed after the bug is fixed
		//log.info("Schedule_06 - Step 12: Click Cancel button");
		//schedulePage.clickCancelButton();
		log.info("Schedule_06 - Step 12: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(dateMinus, monthMinus, yearMinus, apptType, patientName);
		
		log.info("Schedule_06 - Step 13: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Start date is equal to current date or greater than current date")
	public void Schedule_07_StartDateIsEqualToCurrentDateOrGreaterThanCurrentDate()
	{
		log.info("Schedule_07 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_07 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_07 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_07 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_07 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_07 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_07 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_07 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_07 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_07 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_07 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: Save appointment successfully");
		verifyTrue(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientName));
		
		log.info("Schedule_07 - Step 12: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_07 - Step 13: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Start time is out of office available hours")
	public void Schedule_08_StartTimeIsOutOfOfficeAvailableHours()
	{
		log.info("Schedule_08 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, incorrectHour, correctMinute);
		
		log.info("Schedule_08 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup("Delivery");
		
		log.info("Schedule_08 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_08 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup("Wayne, Bruce   (Hearing Fun)");
		
		log.info("Schedule_08 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_08 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_08 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_08 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(incorrectStartTime);
		
		log.info("Schedule_08 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(incorrectEndTime);
		
		log.info("Schedule_08 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_08 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: Save appointment successfully");
		verifyTrue(schedulePage.isAppointmentSavedSuccessfully(date, month, year, "Delivery", "Wayne, Bruce"));
		
		log.info("Schedule_08 - Step 12: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, "Delivery", "Wayne, Bruce");
		
		log.info("Schedule_08 - Step 13: Open Problem popup on Calendar Event Popup");
		schedulePage.openProblemOnCalendarEventPopup();
		
		log.info("VP: An error popup displays with contents: 'Scheduled event is out of office available hours'");
		verifyTrue(schedulePage.isErrorPopupDisplayWithContent("Scheduled event is out of office available hours"));
		
		log.info("Schedule_08 - Step 14: Close error popup");
		schedulePage.closeErrorPopup();
		
		log.info("Schedule_08 - Step 15: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "End time is earlier  than Start time")
	public void Schedule_09_EndTimeIsEarlierThanStartTime()
	{
		log.info("Schedule_09 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_09 - Step 02: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_09 - Step 03: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_09 - Step 04: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: An error message displays with contents: 'End time should be later than Start time'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup("End time should be later than Start time"));
		
		log.info("Schedule_09 - Step 05: Click Cancel button");
		schedulePage.clickCancelButton();		
	}
	
	@Test(groups = { "regression" },description = "Note field is broken")
	public void Schedule_11_NoteFieldIsBroken()
	{
		log.info("Schedule_11 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_11 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_11 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_11 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_11 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_11 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(longNote);
		
		log.info("Schedule_11 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_11 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_11 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_11 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_11 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: An error message displays with contents: 'Note content has to less than 100 characters'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup("Note content has to less than 100 characters"));
		
		//will be removed after the bug is fixed
		//log.info("Schedule_11 - Step 12: Click Cancel button");
		//schedulePage.clickCancelButton();
		log.info("Schedule_11 - Step 12: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_11 - Step 13: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Recurring checkbox is checked")
	public void Schedule_12_RecurringCheckboxIsChecked()
	{
		log.info("Schedule_12 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_12 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_12 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_12 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_12 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_12 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_12 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_12 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_12 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_12 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_12 - Step 11: Tick on Recurring checkbox");
		schedulePage.selectRecurringCheckboxOnCalendarEventPopup(true);
		
		log.info("VP: Repeat radio button displays");
		verifyTrue(schedulePage.isRepeatRadioButtonDisplayOnNewCalendarEvent());
		
		log.info("VP: Repeat until radio button displays");
		verifyTrue(schedulePage.isRepeatUntilRadioButtonDisplayOnNewCalendarEvent());
		
		log.info("Schedule_12 - Step 12: Click Cancel button");
		schedulePage.clickCancelButton();
	}
	
	@Test(groups = { "regression" },description = "Repeat Until date is less than Start date")
	public void Schedule_13_RepeatUntilDateIsLessThanStartDate()
	{
		log.info("Schedule_13 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_13 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_13 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_13 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_13 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_13 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_13 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_13 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_13 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_13 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_13 - Step 11: Tick on Recurring checkbox");
		schedulePage.selectRecurringCheckboxOnCalendarEventPopup(true);
		
		log.info("Schedule_13 - Step 12: Click select Recurring (Every Day)");
		schedulePage.selectRecurringValueOnCalendarEventPopup("Every Day");
		
		log.info("Schedule_13 - Step 13: Click select Repeat Until date less than Start Date");
		schedulePage.selectDateForRepeatUntilOnCalendarEventPopup(dateMinus, monthMinus, yearMinus);
		
		log.info("Schedule_13 - Step 14: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: An error message displays with contents: 'Repeat Until date cannot be less than Start date'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup("Repeat Until date cannot be less than Start date"));
		
		//will be removed after the bug is fixed
		//log.info("Schedule_13 - Step 12: Click Cancel button");
		//schedulePage.clickCancelButton();
		log.info("Schedule_13 - Step 12: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_13 - Step 13: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Email Reminder is not working")
	public void Schedule_14_EmailReminderIsNotWorking()
	{
		log.info("Schedule_14 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_14 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_14 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_14 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_14 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_14 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_14 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_14 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_14 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_14 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_14 - Step 11: Click on Email Reminder");
		schedulePage.clickOnEmailReminderButtonOnCalendarEventPopup();
		
		log.info("VP: An error message displays with contents: 'Email is sent successfully'");
		verifyTrue(schedulePage.isEmailSentSuccessfully());
		
		log.info("Schedule_14 - Step 12: Click Cancel button");
		schedulePage.clickCancelButton();
	}
	
	@Test(groups = { "regression" },description = "Create the same two calendar events")
	public void Schedule_15_CreateTheSameTwoCalendarEvents()
	{
		log.info("Schedule_15 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_15 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_15 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_15 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_15 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_15 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_15 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_15 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_15 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_15 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_15 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_15 - Step 12: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_15 - Step 13: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_15 - Step 14: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_15 - Step 15: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_15 - Step 16: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_15 - Step 17: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_15 - Step 18: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_15 - Step 19: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_15 - Step 20: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_15 - Step 21: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("VP: Exit and Save button disable on New Calendar Event");
		verifyTrue(schedulePage.isExitAndSaveButtonDisable());
		
		log.info("VP: An error message displays with contents: 'Calendar event overlaps with another calendar event'");
		verifyTrue(schedulePage.isErrorMessageDisplayOnNewCalendarEventPopup("Calendar event overlaps with another calendar event"));
		
		log.info("Schedule_15 - Step 22: Click Cancel button");
		schedulePage.clickCancelButton();
		
		log.info("Schedule_15 - Step 23: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_15 - Step 24: Delete appointment");
		schedulePage.deleteAppointment();
		
		log.info("Schedule_15 - Step 25: Switch frame to Top Window");
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
	private String errorTextAppt, errorTextPatient, errorTextRef, noteContent, longNote;
	private int date, month, year, hour, minute, correctHour, correctMinute;
	private int dateMinus, monthMinus, yearMinus, incorrectHour;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime, incorrectStartTime, incorrectEndTime;
}