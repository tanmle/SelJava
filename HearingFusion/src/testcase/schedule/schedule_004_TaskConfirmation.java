package schedule;

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

public class schedule_004_TaskConfirmation extends AbstractTest{

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
		apptStatus = "Scheduled";
		patientFull = "Baker, Mark   (Henderson Ear)";
		patientName = "Baker, Mark";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		dateString = month+"/"+date+"/"+year;
		noteForConfirmAppointment = "Note for confirm appointment";
		noteForRescheduleAppointment = "Note for reschedule appointment";
		noteForCancelAppointment = "Note for cancel appointment";
	}
	
	@Test(groups = { "regression" },description = "List of Confirmed Appointments is showed")
	public void Schedule_22_ListOfConfirmedAppointmentsIsShowed()
	{
		log.info("Schedule_22 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_22 - Step 02: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_22 - Step 03: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_22 - Step 04: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_22 - Step 05: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_22 - Step 06: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_22 - Step 07: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_22 - Step 08: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_22 - Step 09: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_22 - Step 10: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_22 - Step 11: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_22 - Step 12: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_22 - Step 13: Click on Confirmation link in Task");
		schedulePage.clickOnConfirmationLink();
		
		log.info("VP: List of Confirmed Appointments is showed");
		verifyTrue(schedulePage.isListOfConfirmationAppointmentsDisplay());
		
		log.info("VP: Appointment display on List of Confirmed Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
	}
	
	@Test(groups = { "regression" },description = "Help Page")
	public void Schedule_24_HelpPage()
	{		
		log.info("Schedule_24 - Step 01: Click on Help link");
		schedulePage.clickOnHelpLink();
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Help page is opened");
		verifyTrue(schedulePage.isHelpPageOpened());
		driver.close();
		driver.switchTo().window(currentHandle);
		
		log.info("Schedule_24 - Step 02: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("Schedule_24 - Step 03: Open the Appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("Schedule_24 - Step 04: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Confirm an appointment")
	public void Schedule_27_ConfirmAnAppointment()
	{
		log.info("Schedule_27 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_27 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_27 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_27 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_27 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_27 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_27 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_27 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_27 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_27 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_27 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_27 - Step 12: Click on Confirmation link in Task");
		schedulePage.clickOnConfirmationLink();
		
		log.info("VP: Appointment display on List of Confirmed Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_27 - Step 13: Click on Confirm link for an appointment");
		schedulePage.clickOnConfirmLinkForAnAppointment(dateString, apptType, patientName, provider, apptStatus);
		
		log.info("Schedule_27 - Step 14: Input note for Confirm Appointment");
		schedulePage.addNoteForConfirmAppointment(noteForConfirmAppointment);
		
		log.info("VP: Appointment disappears on List of Confirmed Appointments");
		verifyFalse(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_27 - Step 15: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("Schedule_27 - Step 16: Open the Appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("VP: Appt Status is Confirmed");
		schedulePage.isApptStatusDisplayCorrectly("Confirmed");
		
		log.info("Schedule_27 - Step 17: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Left Message an appointment")
	public void Schedule_28_LeftMessageAnAppointment()
	{
		log.info("Schedule_28 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_28 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_28 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_28 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_28 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_28 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_28 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_28 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_28 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_28 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_28 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_28 - Step 12: Click on Confirmation link in Task");
		schedulePage.clickOnConfirmationLink();
		
		log.info("VP: Appointment display on List of Confirmed Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_28 - Step 13: Click on LeftMessage link for an appointment");
		schedulePage.clickOnLeftMessageLinkForAnAppointment(dateString, apptType, patientName, provider, apptStatus);

		log.info("VP: Appointment disappears on List of Confirmed Appointments");
		verifyFalse(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_28 - Step 14: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("Schedule_28 - Step 15: Open the Appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("VP: Appt Status is Confirmed");
		schedulePage.isApptStatusDisplayCorrectly("Left Message");
		
		log.info("Schedule_28 - Step 16: Delete appointment");
		schedulePage.deleteAppointment();
	}
	
	@Test(groups = { "regression" },description = "Cancel an appointment")
	public void Schedule_29_CancelAnAppointment()
	{
		log.info("Schedule_29 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_29 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_29 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_29 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_29 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_29 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_29 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_29 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_29 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_29 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_29 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_29 - Step 12: Click on Confirmation link in Task");
		schedulePage.clickOnConfirmationLink();
		
		log.info("VP: Appointment display on List of Confirmed Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_29 - Step 13: Click on Cancel link for an appointment");
		schedulePage.clickOnCancelLinkForAnAppointment(dateString, apptType, patientName, provider, apptStatus);
		
		log.info("Schedule_29 - Step 14: Input note for Confirm Appointment");
		schedulePage.addNoteForCancelAppointment(noteForCancelAppointment);
		
		log.info("VP: Appointment disappears on List of Confirmed Appointments");
		verifyFalse(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_29 - Step 15: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("VP: Appointment is removed from calendar event");
		schedulePage.switchToScheduleFrame(driver);
		verifyFalse(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientFull));
	}
	
	@Test(groups = { "regression" },description = "Reschedule an appointment")
	public void Schedule_30_RescheduleAnAppointment()
	{
		log.info("Schedule_30 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_30 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_30 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_30 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_30 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_30 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_30 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_30 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_30 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_30 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_30 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_30 - Step 12: Click on Confirmation link in Task");
		schedulePage.clickOnConfirmationLink();
		
		log.info("VP: Appointment display on List of Confirmed Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfConfirmedAppointment(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_30 - Step 13: Click on Reschedule link for an appointment");
		schedulePage.clickOnRescheduleLinkForAnAppointment(dateString, apptType, patientName, provider, apptStatus);
		
		log.info("Schedule_30 - Step 14: Input note for Confirm Appointment");
		schedulePage.addNoteForRescheduleAppointment(noteForRescheduleAppointment);
		
		log.info("VP: Calendar Event popup display to reschedule");
		schedulePage.switchToScheduleFrame(driver);
		verifyTrue(schedulePage.isCalendarEventPopupDisplay());
		
		log.info("Schedule_30 - Step 15: Delete appointment");
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
	private String organization, qaStaffUsername, password;
	private String noteForRescheduleAppointment, noteContent, noteForConfirmAppointment,noteForCancelAppointment;
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime, dateString;
	private final Stack<String> openWindowHandles = new Stack<String>();
}