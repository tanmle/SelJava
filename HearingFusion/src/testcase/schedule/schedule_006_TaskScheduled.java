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

public class schedule_006_TaskScheduled extends AbstractTest{

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
		patientFull = "Baker, Mark   (Henderson Ear)";
		patientName = "Baker, Mark";
		refResource = "Campaign";
		provider = "Needle, Space";
		noteContent = "Note Content";
		dateString = month+"/"+date+"/"+year;
	}
	
	@Test(groups = { "regression" },description = "List of Pending/Rescheduled Appointments is showed")
	public void Schedule_37_ListOfPendingRescheduledAppointmentsIsShowed()
	{
		log.info("Schedule_37 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("Schedule_37 - Step 02: Select time reasonably to add new calendar event");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_37 - Step 03: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_37 - Step 04: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_37 - Step 05: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_37 - Step 06: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_37 - Step 07: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_37 - Step 08: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_37 - Step 09: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_37 - Step 10: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_37 - Step 11: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_37 - Step 12: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_37 - Step 13: Click on Rescheduled link in Task");
		schedulePage.clickOnRescheduledLink();
		
		log.info("VP: List of Confirmed Pending/Reshceduled is showed");
		verifyTrue(schedulePage.isListOfPendingRescheduledAppointmentsDisplay());
		
		log.info("VP: Appointment display on List of Pending/Reshceduled Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfPendingRescheduled(dateString, apptType, patientName, provider, apptStatus));
	}
	
	@Test(groups = { "regression" },description = "Help Page")
	public void Schedule_39_HelpPage()
	{
		log.info("Schedule_39 - Step 01: Click on Help link");
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
	}
	
	@Test(groups = { "regression" },description = "Cancel a Rescheduled Pending appointment")
	public void Schedule_42_CancelRescheduledPendingAppointment()
	{
		log.info("Schedule_42 - Step 01: Click on Cancel link for an appointment");
		schedulePage.clickOnCancelLinkForRescheduledAppointment(dateString, apptType, patientName, provider, apptStatus);
		
		log.info("VP: Appointment disappears on List of Pending/Reshceduled Appointments");
		verifyFalse(schedulePage.isAppointmentDisplayOnListOfPendingRescheduled(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_42 - Step 02: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("VP: Appointment is removed from calendar event");
		schedulePage.switchToScheduleFrame(driver);
		verifyFalse(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientFull));
	}
	
	@Test(groups = { "regression" },description = "Schedule pending rescheduled appointment")
	public void Schedule_43_SchedulePendingRescheduledAppointment()
	{
		log.info("Schedule_43 - Step 01: Select time reasonably to add new calendar event");
		schedulePage.selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		
		log.info("Schedule_43 - Step 02: Click to select data in Appt. type");
		schedulePage.selectApptTypeOnCalendarEventPopup(apptType);
		
		log.info("Schedule_43 - Step 03: Click to select data in Appt. status");
		schedulePage.selectApptStatusOnCalendarEventPopup(apptStatus);
		
		log.info("Schedule_43 - Step 04: Click to select data in Patient");
		schedulePage.selectPatientOnCalendarEventPopup(patientFull);
		
		log.info("Schedule_43 - Step 05: Click to select data in Ref. Source");
		schedulePage.selectRefResourceOnCalendarEventPopup(refResource);
		
		log.info("Schedule_43 - Step 06: Input note");
		schedulePage.inputNoteOnCalendarEventPopup(noteContent);
		
		log.info("Schedule_43 - Step 07: Click to select data in Date");
		schedulePage.selectDateOnCalendarEventPopup(date, month, year);
		
		log.info("Schedule_43 - Step 08: Click to select data in Start time");
		schedulePage.selectStartTimeOnCalendarEventPopup(correctStartTime);
		
		log.info("Schedule_43 - Step 09: Click to select data in End time");
		schedulePage.selectEndTimeOnCalendarEventPopup(correctEndTime);
		
		log.info("Schedule_43 - Step 10: Click to select data in Provider");
		schedulePage.selectProviderOnCalendarEventPopup(provider);
		
		log.info("Schedule_43 - Step 11: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("Schedule_43 - Step 12: Click on Rescheduled link in Task");
		schedulePage.clickOnRescheduledLink();
		
		log.info("VP: Appointment display on List of Pending/Reshceduled Appointments");
		verifyTrue(schedulePage.isAppointmentDisplayOnListOfPendingRescheduled(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_43 - Step 13: Click on Schedule link for an appointment");
		schedulePage.clickOnScheduleLinkForRescheduledAppointment(dateString, apptType, patientName, provider, apptStatus);
		
		log.info("VP: Appt. status will be 'Scheduled'");
		schedulePage.switchToScheduleFrame(driver);
		verifyTrue(schedulePage.isApptStatusDisplayCorrectly("Scheduled"));
		
		log.info("Schedule_43 - Step 14: Click Save and Exit button");
		schedulePage.clickSaveAndExitButton();
		
		log.info("VP: Appointment display on dashboard");
		verifyFalse(schedulePage.isAppointmentSavedSuccessfully(date, month, year, apptType, patientFull));
		
		log.info("Schedule_43 - Step 15: Click on Rescheduled link in Task");
		schedulePage.clickOnRescheduledLink();
		
		log.info("VP: Appointment not display on List of Pending/Reshceduled Appointments");
		verifyFalse(schedulePage.isAppointmentDisplayOnListOfPendingRescheduled(dateString, apptType, patientName, provider, apptStatus));
		
		log.info("Schedule_43 - Step 16: Click on Schedule on main menu");
		schedulePage.switchToTopWindowFrame(driver);
		schedulePage = schedulePage.gotoSchedulePage(driver, ipClient);
		
		log.info("Schedule_43 - Step 17: Delete appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		schedulePage.deleteAppointment();
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
	private int date, month, year, correctHour, correctMinute;
	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
	private String correctStartTime, correctEndTime, dateString, noteContent;
	private final Stack<String> openWindowHandles = new Stack<String>();
}