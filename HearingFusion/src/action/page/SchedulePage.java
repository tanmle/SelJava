package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.Common;
import HearingFusion.Interfaces;

public class SchedulePage extends AbstractPage {

	public SchedulePage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	
	/**
	 * Check the page is opened on top navigate bar
	 */
	public boolean isPageOnTopNavigateBarOpened(String page) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_PAGE_ON_TOP_NAVBAR_OPENED, page, timeWait);
		sleep(1);
		String classValue = getAttributeValue(driver, 
				Interfaces.SchedulePage.DYNAMIC_PAGE_ON_TOP_NAVBAR_OPENED, page, "class");
		return classValue.equals("on");
	}
	
	/**
	 * Check user name display after log in
	 */
	public boolean isUsernameDisplayAfterLogin(String username) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_USERNAME_LABEL, username, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_USERNAME_LABEL, username);
	}
	
	/**
	 * Check Hearing Fusion Icon Display
	 */
	public boolean isHearingFusionIconDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.HEARING_FUSION_LOGO, 5);
		return isControlDisplayed(driver, Interfaces.SchedulePage.HEARING_FUSION_LOGO);
	}
	
	/**
	 * click Save And Exit Button on New Calendar Event dialog
	 */
	public void clickSaveAndExitButton() {
		waitForControl(driver, Interfaces.SchedulePage.SAVE_AND_EXIT_BUTTON, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.SAVE_AND_EXIT_BUTTON);
		waitForControlNotDisplayed(driver, Interfaces.SchedulePage.SAVE_AND_EXIT_BUTTON, timeWait);
		sleep();
	}
	
	/**
	 * click Cancel Button on New Calendar Event dialog
	 */
	public void clickCancelButton() {
		waitForControl(driver, Interfaces.SchedulePage.CANCEL_BUTTON, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.CANCEL_BUTTON);
	}
	
	/**
	 * Check Error Message Display On New Calendar Event Popup
	 */
	public boolean isErrorMessageDisplayOnNewCalendarEventPopup(String content) {
		waitForControl(driver, Interfaces.SchedulePage.ERROR_MESSAGE_ON_NEW_CALENDAR_EVENT, content, 5);
		return isControlDisplayed(driver, Interfaces.SchedulePage.ERROR_MESSAGE_ON_NEW_CALENDAR_EVENT, content);
	}
	
	/**
	 * select ApptType On Calendar Event Popup
	 */
	public void selectApptTypeOnCalendarEventPopup(String value) {
		waitForControl(driver, Interfaces.SchedulePage.APPT_TYPE_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SchedulePage.APPT_TYPE_COMBOBOX, value);
	}
	
	/**
	 * select ApptStatus On Calendar Event Popup
	 */
	public void selectApptStatusOnCalendarEventPopup(String value) {
		waitForControl(driver, Interfaces.SchedulePage.APPT_STATUS_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SchedulePage.APPT_STATUS_COMBOBOX, value);
	}
	
	/**
	 * select Ref Resource On Calendar Event Popup
	 */
	public void selectRefResourceOnCalendarEventPopup(String value) {
		waitForControl(driver, Interfaces.SchedulePage.REF_RESOURCE_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SchedulePage.REF_RESOURCE_COMBOBOX, value);
	}
	
	/**
	 * select Provider On Calendar Event Popup
	 */
	public void selectProviderOnCalendarEventPopup(String value) {
		waitForControl(driver, Interfaces.SchedulePage.PROVIDER_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SchedulePage.PROVIDER_COMBOBOX, value);
	}
	
	/**
	 * select Patient On Calendar Event Popup
	 */
	public void selectPatientOnCalendarEventPopup(String value) {
		String[] nameArray = value.split(" ");
		String lastName = nameArray[1];
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_TEXTBOX, timeWait);
		sleep(1);
		type(driver, Interfaces.SchedulePage.PATIENT_TEXTBOX, lastName);
		sleep();
		if(isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_PATIENT_ITEM, lastName)){
			click(driver, Interfaces.SchedulePage.DYNAMIC_PATIENT_ITEM, lastName);
		}
		sleep(1);
	}
	
	/**
	 * select Unavailable Checkbox with value true/false
	 */
	public void selectUnavailableCheckbox(boolean value) {
		waitForControl(driver, Interfaces.SchedulePage.UNAVAILABLE_CHECKBOX, timeWait);
		sleep(1);
		String checkedValue = getAttributeValue(driver, 
				Interfaces.SchedulePage.UNAVAILABLE_CHECKBOX, "checked");
		if(value){
			if(checkedValue==null){
				click(driver, Interfaces.SchedulePage.UNAVAILABLE_CHECKBOX);
				sleep(1);
			}
		}else{
			if(checkedValue!=null){
				click(driver, Interfaces.SchedulePage.UNAVAILABLE_CHECKBOX);
				sleep(1);
			}
		}
	}
	
	/**
	 * select Schedule Block Checkbox with value true/false
	 */
	public void selectScheduleBlockCheckbox(boolean value) {
		waitForControl(driver, Interfaces.SchedulePage.SCHEDULE_BLOCK_CHECKBOX, timeWait);
		sleep(1);
		String checkedValue = getAttributeValue(driver, 
				Interfaces.SchedulePage.SCHEDULE_BLOCK_CHECKBOX, "checked");
		if(value){
			if(checkedValue==null){
				click(driver, Interfaces.SchedulePage.SCHEDULE_BLOCK_CHECKBOX);
				sleep(1);
			}
		}else{
			if(checkedValue!=null){
				click(driver, Interfaces.SchedulePage.SCHEDULE_BLOCK_CHECKBOX);
				sleep(1);
			}
		}
	}
	
	/**
	 * Check ApptType Disable On Calendar Event Popup
	 */
	public boolean isApptTypeDisableOnCalendarEventPopup() {
		String apptTypeStyle = getAttributeValue(driver, 
				Interfaces.SchedulePage.PARENT_OF_APPT_TYPE_COMBOBOX, "style");
		return apptTypeStyle.contains("none");
	}
	
	/**
	 * Check ApptStatus Disable On Calendar Event Popup
	 */
	public boolean isApptStatusDisableOnCalendarEventPopup() {
		String apptStatusStyle = getAttributeValue(driver, 
				Interfaces.SchedulePage.PARENT_OF_APPT_STATUS_COMBOBOX, "style");
		if(apptStatusStyle.contains("display: none;")){
			return apptStatusStyle.contains("none");
		}else{
			apptStatusStyle = getAttributeValue(driver, 
					Interfaces.SchedulePage.APPT_STATUS_COMBOBOX, "style");
			return apptStatusStyle.contains("none");
		}
		
	}
	
	/**
	 * Check Patient Disable On Calendar Event Popup
	 */
	public boolean isPatientDisableOnCalendarEventPopup() {
		String patientStyle = getAttributeValue(driver, 
				Interfaces.SchedulePage.PARENT_OF_PATIENT_TEXTBOX, "style");
		return patientStyle.contains("none");
	}
	
	/**
	 * Check RefResource Disable On Calendar Event Popup
	 */
	public boolean isRefResourceDisableOnCalendarEventPopup() {
		String refResourceStyle = getAttributeValue(driver, 
				Interfaces.SchedulePage.PARENT_OF_REF_RESOURCE_COMBOBOX, "style");
		return refResourceStyle.contains("none");
	}
	
	/**
	 * select Time To Schedule New Calendar Event
	 */
	public void selectTimeToScheduleNewCalendarEvent(int date, int month, int year,
			int hour, int minute) {
		String currentDayInWeek, timeIndexString;
		int timeIndex, minuteIndex;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
			int newdate = Common.getCommon().getDateAfterPlusOneDay(date, month, year);
			int newmonth = Common.getCommon().getMonthAfterPlusOneDay(date, month, year);
			int newyear = Common.getCommon().getYearAfterPlusOneDay(date, month, year);
			date = newdate;
			month = newmonth;
			year = newyear;
		}
		sleep();
		selectWeek(date, month, year, currentDayInWeek);
		sleep();
		if(minute < 15){
			minuteIndex = 1;
		}else if(minute < 30){
			minuteIndex = 2;
		}else if(minute < 45){
			minuteIndex = 3;
		}else{
			minuteIndex = 4;
		}
		
		timeIndex = hour*4+minuteIndex+1;
		timeIndexString = Integer.toString(timeIndex);
		
		waitForControl(driver, Interfaces.SchedulePage.SELECT_TIME_IN_SCHEDULE_DASHBOARD,
				timeIndexString, currentDayInWeek, timeWait);
		click(driver, Interfaces.SchedulePage.SELECT_TIME_IN_SCHEDULE_DASHBOARD, 
				timeIndexString, currentDayInWeek);
//		element = getElement(driver, Interfaces.SchedulePage.SELECT_TIME_IN_SCHEDULE_DASHBOARD, 
//				timeIndexString, currentDayInWeek);
//		element. click();
//		String tmp = converAppointmentArrayToNumber(Integer.parseInt(timeIndexString),Integer.parseInt(currentDayInWeek));
//		String javaSript = "$(\".scheduler-iframe\").contents().find(\"#ctl00_WeekTabSection_WeekTabDayPilotCalendar\").find(\".calendar_silver_cellbackground\")["+tmp+"].click(function(){alert('click')})";
//		executeJavaScript(driver, javaSript);
		sleep();
		
	}
	
	/**
	 * Check Appointment Saved Successfully
	 */
	public boolean isAppointmentSavedSuccessfully(int date, int month, int year, 
			String apptType, String patient) {
		boolean returnValue = true;
		String currentDayInWeek;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
			int newdate = Common.getCommon().getDateAfterPlusOneDay(date, month, year);
			int newmonth = Common.getCommon().getMonthAfterPlusOneDay(date, month, year);
			int newyear = Common.getCommon().getYearAfterPlusOneDay(date, month, year);
			date = newdate;
			month = newmonth;
			year = newyear;
		}
		
		selectWeek(date, month, year, currentDayInWeek);
		
		waitForControl(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient, timeWait);
		if(!isControlDisplayed(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient)){
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * Check Appointment Saved Successfully after reschedule
	 * this action handle a bug, we will remove it after the bug is fixed
	 */
	public boolean isAppointmentSavedSuccessfullyAfterReschedule(int date, int month, int year, 
			String apptType, String patient) {
		boolean returnValue = true;
		String currentDayInWeek;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
		}
		
		waitForControl(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient, timeWait);
		if(!isControlDisplayed(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient)){
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * open Appointment On Schedule Dashboard
	 */
	public void openAppointmentOnScheduleDashboard(int date, int month, int year, 
			String apptType, String patient) {
		String currentDayInWeek;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
			int newdate = Common.getCommon().getDateAfterPlusOneDay(date, month, year);
			int newmonth = Common.getCommon().getMonthAfterPlusOneDay(date, month, year);
			int newyear = Common.getCommon().getYearAfterPlusOneDay(date, month, year);
			date = newdate;
			month = newmonth;
			year = newyear;
		}
		
		selectWeek(date, month, year, currentDayInWeek);
		
		waitForControl(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient, timeWait);
		click(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient);
		sleep();
	}
	
	/**
	 * Select week
	 */
	public void selectWeek(int date, int month, int year, String currentDayInWeek){
		waitForControl(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek, timeWait);
		String currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
		String[] currentInfor = currentDateInfor.split("/");
		int currentDate = Integer.parseInt(currentInfor[1]);
		int currentYear = Integer.parseInt(currentInfor[2]);
		int currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
		
		if (currentYear == year) {
			if (month > currentMonth) {
				while (month != currentMonth) {
					click(driver,Interfaces.SchedulePage.NEXT_WEEK_BUTTON);
					sleep();
					currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
					currentInfor = currentDateInfor.split("/");
					currentDate = Integer.parseInt(currentInfor[1]);
					currentYear = Integer.parseInt(currentInfor[2]);
					currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
				}
				while(date != currentDate){
					click(driver,Interfaces.SchedulePage.NEXT_WEEK_BUTTON);
					sleep();
					currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
					currentInfor = currentDateInfor.split("/");
					currentDate = Integer.parseInt(currentInfor[1]);
					currentYear = Integer.parseInt(currentInfor[2]);
					currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
				}
			}
			else if(month < currentMonth) {
				while (month != currentMonth) {
					click(driver,Interfaces.SchedulePage.PREV_WEEK_BUTTON);
					sleep();
					currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
					currentInfor = currentDateInfor.split("/");
					currentDate = Integer.parseInt(currentInfor[1]);
					currentYear = Integer.parseInt(currentInfor[2]);
					currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
				}
				while(date != currentDate){
					click(driver,Interfaces.SchedulePage.PREV_WEEK_BUTTON);
					sleep();
					currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
					currentInfor = currentDateInfor.split("/");
					currentDate = Integer.parseInt(currentInfor[1]);
					currentYear = Integer.parseInt(currentInfor[2]);
					currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
				}
			}
			else {
				if(date < currentDate){
					while(date != currentDate){
						click(driver,Interfaces.SchedulePage.PREV_WEEK_BUTTON);
						sleep();
						currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
						currentInfor = currentDateInfor.split("/");
						currentDate = Integer.parseInt(currentInfor[1]);
						currentYear = Integer.parseInt(currentInfor[2]);
						currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
					}
				}
				else{
					while(date != currentDate){
						click(driver,Interfaces.SchedulePage.NEXT_WEEK_BUTTON);
						sleep();
						currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
						currentInfor = currentDateInfor.split("/");
						currentDate = Integer.parseInt(currentInfor[1]);
						currentYear = Integer.parseInt(currentInfor[2]);
						currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
					}
				}
			}
		}
		else if (currentYear < year){
			while (year != currentYear) {
				click(driver,Interfaces.SchedulePage.NEXT_WEEK_BUTTON);
				sleep();
				currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
				currentInfor = currentDateInfor.split("/");
				currentDate = Integer.parseInt(currentInfor[1]);
				currentYear = Integer.parseInt(currentInfor[2]);
				currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
			}
			while (month != currentMonth) {
				click(driver,Interfaces.SchedulePage.NEXT_WEEK_BUTTON);
				sleep();
				currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
				currentInfor = currentDateInfor.split("/");
				currentDate = Integer.parseInt(currentInfor[1]);
				currentYear = Integer.parseInt(currentInfor[2]);
				currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
			}
			while(date != currentDate){
				click(driver,Interfaces.SchedulePage.NEXT_WEEK_BUTTON);
				sleep();
				currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
				currentInfor = currentDateInfor.split("/");
				currentDate = Integer.parseInt(currentInfor[1]);
				currentYear = Integer.parseInt(currentInfor[2]);
				currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
			}
		}
		else {
			while (year != currentYear) {
				click(driver,Interfaces.SchedulePage.PREV_WEEK_BUTTON);
				sleep();
				currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
				currentInfor = currentDateInfor.split("/");
				currentDate = Integer.parseInt(currentInfor[1]);
				currentYear = Integer.parseInt(currentInfor[2]);
				currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
			}
			while (month != currentMonth) {
				click(driver,Interfaces.SchedulePage.PREV_WEEK_BUTTON);
				sleep();
				currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
				currentInfor = currentDateInfor.split("/");
				currentDate = Integer.parseInt(currentInfor[1]);
				currentYear = Integer.parseInt(currentInfor[2]);
				currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
			}
			while(date != currentDate){
				click(driver,Interfaces.SchedulePage.PREV_WEEK_BUTTON);
				sleep();
				currentDateInfor = getText(driver, Interfaces.SchedulePage.CURRENT_DATE_INFOR_DISPLAY, currentDayInWeek);
				currentInfor = currentDateInfor.split("/");
				currentDate = Integer.parseInt(currentInfor[1]);
				currentYear = Integer.parseInt(currentInfor[2]);
				currentMonth = Integer.parseInt(currentInfor[0].split(" ")[1]);
			}
		}
	}
	
	
	/**
	 * delete Appointment
	 */
	public void deleteAppointment() {
		waitForControl(driver, Interfaces.SchedulePage.DELETE_BUTTON, timeWait);
		click(driver, Interfaces.SchedulePage.DELETE_BUTTON);
		sleep();
	}
	
	/**
	 * Switch driver to iFrame
	 * @return driver
	 */
	public WebDriver switchToScheduleFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.SchedulePage.SCHEDULE_FRAME, timeWait);
		sleep(5);
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.SchedulePage.SCHEDULE_FRAME)));
		return driver;
	}
	
	/**
	 * input Note On Calendar Event Popup
	 */
	public void inputNoteOnCalendarEventPopup(String noteContent) {
		waitForControl(driver, Interfaces.SchedulePage.NOTE_TEXTBOX, timeWait);
		type(driver, Interfaces.SchedulePage.NOTE_TEXTBOX, noteContent);
		sleep();
	}
	
	/**
	 * select date On Calendar Event Popup
	 */
	public void selectDateOnCalendarEventPopup(int date, int month, int year) {
		clickOnDatefieldOnCalendarEventPopup();
		selectDate(date, month, year);
	}
	
	/**
	 * Select date
	 */
	public void selectDate(int date, int month, int year){
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("sunday")){
			date = Common.getCommon().getCurrentDayWithPlusDays(1);
			month = Common.getCommon().getCurrentMonthWithPlusDays(1);
			year = Common.getCommon().getCurrentYearWithPlusDays(1);
		}
		waitForControl(driver, Interfaces.SchedulePage.CURRENT_MONTH_LABEL, timeWait);
		String currentMonth = getText(driver,Interfaces.SchedulePage.CURRENT_MONTH_LABEL).trim().toUpperCase();
		String currentYear = getText(driver,Interfaces.SchedulePage.CURRENT_YEAR_LABEL).trim().toUpperCase();
		int m = Common.getCommon().convertMonth(currentMonth);
		int y = Integer.parseInt(currentYear);
		if (Integer.parseInt(currentYear) == year) {
			if (month > m) {
				while (month != m) {
					click(driver,Interfaces.SchedulePage.NEXT_MONTH_BUTTON);
					sleep();
					currentMonth = getText(driver,Interfaces.SchedulePage.CURRENT_MONTH_LABEL).trim().toUpperCase();
					m = Common.getCommon().convertMonth(currentMonth);
				}
			}
			else {
				while (month != m) {
					click(driver,Interfaces.SchedulePage.PREV_MONTH_BUTTON);
					sleep();
					currentMonth = getText(driver,Interfaces.SchedulePage.CURRENT_MONTH_LABEL).trim().toUpperCase();
					m = Common.getCommon().convertMonth(currentMonth);
				}
			}
		}
		else if (Integer.parseInt(currentYear) < year){
			while (year != y) {
				click(driver,Interfaces.SchedulePage.NEXT_MONTH_BUTTON);
				sleep();
				currentYear = getText(driver,Interfaces.SchedulePage.CURRENT_YEAR_LABEL).trim().toUpperCase();
				y = Integer.parseInt(currentYear);
			}
			
			if (month > m) {
				while (month != m) {
					click(driver,Interfaces.SchedulePage.NEXT_MONTH_BUTTON);
					sleep();
					currentMonth = getText(driver,Interfaces.SchedulePage.CURRENT_MONTH_LABEL).trim().toUpperCase();
					m = Common.getCommon().convertMonth(currentMonth);
				}
			}
		}
		else {
			while (year != y) {
				click(driver,Interfaces.SchedulePage.PREV_MONTH_BUTTON);
				sleep();
				currentYear = getText(driver,Interfaces.SchedulePage.CURRENT_YEAR_LABEL).trim().toUpperCase();
				y = Integer.parseInt(currentYear);
			}
			
			if (month < m) {
				while (month != m) {
					click(driver,Interfaces.SchedulePage.PREV_MONTH_BUTTON);
					sleep();
					currentMonth = getText(driver,Interfaces.SchedulePage.CURRENT_MONTH_LABEL).trim().toUpperCase();
					m = Common.getCommon().convertMonth(currentMonth);
				}
			}
		}
		click(driver,Interfaces.SchedulePage.DAY_DYNAMIC_BUTTON,"" + date);
	}
	
	/**
	 * select start time On Calendar Event Popup
	 */
	public void selectStartTimeOnCalendarEventPopup(String startTime) {
		waitForControl(driver, Interfaces.SchedulePage.START_TIME_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SchedulePage.START_TIME_COMBOBOX, startTime);
		sleep(1);
	}
	
	/**
	 * click On Date field On Calendar Event Popup
	 */
	public void clickOnDatefieldOnCalendarEventPopup() {
		waitForControl(driver, Interfaces.SchedulePage.DATE_FIELD, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DATE_FIELD);
		sleep(1);
	}
	
	/**
	 * select end time On Calendar Event Popup
	 */
	public void selectEndTimeOnCalendarEventPopup(String endTime) {
		waitForControl(driver, Interfaces.SchedulePage.END_TIME_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SchedulePage.END_TIME_COMBOBOX, endTime);
		sleep(1);
	}
	
	/**
	 * open Problem On Calendar Event Popup
	 */
	public void openProblemOnCalendarEventPopup() {
		waitForControl(driver, Interfaces.SchedulePage.POPUP_EXCEPTION_ICON, timeWait);
		click(driver, Interfaces.SchedulePage.POPUP_EXCEPTION_ICON);
		sleep(1);
	}
	
	/**
	 * close Error Popup
	 */
	public void closeErrorPopup() {
		waitForControl(driver, Interfaces.SchedulePage.OK_BUTTON_ON_ERROR_POPUP, timeWait);
		click(driver, Interfaces.SchedulePage.OK_BUTTON_ON_ERROR_POPUP);
		sleep(1);
	}
	
	/**
	 * check Error Popup Display With Content
	 */
	public boolean isErrorPopupDisplayWithContent(String errorContent) {
		waitForControl(driver, Interfaces.SchedulePage.ERROR_CONTENT_ON_POPUP, errorContent, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.ERROR_CONTENT_ON_POPUP, errorContent);
	}
	
	/**
	 * select Recurring Checkbox On Calendar Event Popup
	 */
	public void selectRecurringCheckboxOnCalendarEventPopup(boolean value) {
		waitForControl(driver, Interfaces.SchedulePage.RECURRING_CHECKBOX, timeWait);
		sleep(1);
		String checkedValue = getAttributeValue(driver, 
				Interfaces.SchedulePage.RECURRING_CHECKBOX, "checked");
		if(value){
			if(checkedValue==null){
				click(driver, Interfaces.SchedulePage.RECURRING_CHECKBOX);
				sleep(1);
			}
		}else{
			if(checkedValue!=null){
				click(driver, Interfaces.SchedulePage.RECURRING_CHECKBOX);
				sleep(1);
			}
		}
	}
	
	/**
	 * check Repeat Radio Button Display On New Calendar Event
	 */
	public boolean isRepeatRadioButtonDisplayOnNewCalendarEvent() {
		waitForControl(driver, Interfaces.SchedulePage.REPEAT_RADIO_BUTTON, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.REPEAT_RADIO_BUTTON);
	}
	
	/**
	 * check Repeat Until Radio Button Display On New Calendar Event
	 */
	public boolean isRepeatUntilRadioButtonDisplayOnNewCalendarEvent() {
		waitForControl(driver, Interfaces.SchedulePage.REPEAT_UNTIL_RADIO_BUTTON, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.REPEAT_UNTIL_RADIO_BUTTON);
	}
	
	/**
	 * select Recurring Value On Calendar Event Popup
	 */
	public void selectRecurringValueOnCalendarEventPopup(String item) {
		waitForControl(driver, Interfaces.SchedulePage.RECURRING_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SchedulePage.RECURRING_COMBOBOX, item);
		sleep(1);
	}
	
	/**
	 * select Date For Repeat Until On Calendar Event Popup
	 */
	public void selectDateForRepeatUntilOnCalendarEventPopup(int date, int month, int year) {
		clickOnRepeatUntilTextfieldOnCalendarEventPopup();
		selectDate(date, month, year);
	}
	
	/**
	 * click On Repeat Until Text field On Calendar Event Popup
	 */
	public void clickOnRepeatUntilTextfieldOnCalendarEventPopup() {
		waitForControl(driver, Interfaces.SchedulePage.REPEAT_UNTIL_TEXT_FIELD, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.REPEAT_UNTIL_TEXT_FIELD);
		sleep(1);
	}
	
	/**
	 * click On Email Reminder Button On Calendar Event Popup
	 */
	public void clickOnEmailReminderButtonOnCalendarEventPopup() {
		waitForControl(driver, Interfaces.SchedulePage.EMAIL_REMINDER_BUTTON, timeWait);
		click(driver, Interfaces.SchedulePage.EMAIL_REMINDER_BUTTON);
		sleep(1);
	}
	
	/**
	 * check Email Sent Successfully
	 */
	public boolean isEmailSentSuccessfully() {
		return isErrorMessageDisplayOnNewCalendarEventPopup("Email is sent successfully");
	}
	
	/**
	 * Check Exit And Save Button Disable
	 */
	public boolean isExitAndSaveButtonDisable() {
		waitForControl(driver, Interfaces.SchedulePage.SAVE_AND_EXIT_BUTTON, timeWait);
		return !isControlEnabled(driver, Interfaces.SchedulePage.SAVE_AND_EXIT_BUTTON);
	}
	
	/**
	 * click On History Link On New Calendar Event
	 */
	public void clickOnHistoryLinkOnNewCalendarEvent() {
		waitForControl(driver, Interfaces.SchedulePage.HISTORY_LINK, timeWait);
		click(driver, Interfaces.SchedulePage.HISTORY_LINK);
		sleep(1);
	}
	
	/**
	 * Check History Popup Display
	 */
	public boolean isHistoryPopupDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.HISTORY_POPUP_INFOR, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.HISTORY_POPUP_INFOR);
	}
	
	/**
	 * close history popup
	 */
	public void closeHistoryPopup() {
		waitForControl(driver, Interfaces.SchedulePage.OK_BUTTON_ON_HISTORY_POPUP, timeWait);
		click(driver, Interfaces.SchedulePage.OK_BUTTON_ON_HISTORY_POPUP);
		sleep(1);
	}
	
	/**
	 * move Calendar Event To Another Time
	 */
	public void moveCalendarEventToAnotherTime(int date, int month, int year,
			String apptType, String patientName, int movingHour, int movingMinute) {
		
		String currentDayInWeek, timeIndexString;
		int timeIndex, minuteIndex;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
			int newdate = Common.getCommon().getDateAfterPlusOneDay(date, month, year);
			int newmonth = Common.getCommon().getMonthAfterPlusOneDay(date, month, year);
			int newyear = Common.getCommon().getYearAfterPlusOneDay(date, month, year);
			date = newdate;
			month = newmonth;
			year = newyear;
		}
		
		selectWeek(date, month, year, currentDayInWeek);
		
		if(movingMinute < 15){
			minuteIndex = 1;
		}else if(movingMinute < 30){
			minuteIndex = 2;
		}else if(movingMinute < 45){
			minuteIndex = 3;
		}else{
			minuteIndex = 4;
		}
		
		timeIndex = movingHour*4+minuteIndex+1;
		timeIndexString = Integer.toString(timeIndex);
		
		waitForControl(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patientName, timeWait);
		dragAndDrop(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, currentDayInWeek, apptType, patientName,
				Interfaces.SchedulePage.SELECT_TIME_IN_SCHEDULE_DASHBOARD, timeIndexString, currentDayInWeek);
		sleep();
	}
	
	/**
	 * Check Start Time Display Correctly
	 */
	public boolean isStartTimeDisplayCorrectly(String expectedTime) {
		waitForControl(driver, Interfaces.SchedulePage.START_TIME_COMBOBOX, timeWait);
		String realTime = getItemSelectedCombobox(driver, Interfaces.SchedulePage.START_TIME_COMBOBOX);
		return realTime.contains(expectedTime);
	}
	
	/**
	 * Check End Time Display Correctly
	 */
	public boolean isEndTimeDisplayCorrectly(String expectedTime) {
		waitForControl(driver, Interfaces.SchedulePage.END_TIME_COMBOBOX, timeWait);
		String realTime = getItemSelectedCombobox(driver, Interfaces.SchedulePage.END_TIME_COMBOBOX);
		return realTime.contains(expectedTime);
	}
	
	/**
	 * select Item In Office Combobox
	 */
	public void selectItemInOfficeCombobox(String item) {
		if(item.contains("'")){
			item = item.split("'")[1];
		}
		waitForControl(driver, Interfaces.SchedulePage.OFFICE_COMBOBOX, timeWait);
		click(driver, Interfaces.SchedulePage.OFFICE_COMBOBOX);
		type(driver, Interfaces.SchedulePage.OFFICE_COMBOBOX, item);
		sleep(1);
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_ITEM_FOR_OFFICE_COMBOBOX, item, 3);
		if(!isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_ITEM_FOR_OFFICE_COMBOBOX, item)){
			click(driver, Interfaces.SchedulePage.OFFICE_COMBOBOX);
			type(driver, Interfaces.SchedulePage.OFFICE_COMBOBOX, item);
			sleep();
			waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_ITEM_FOR_OFFICE_COMBOBOX, item, 3);
		}
		if(!isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_ITEM_FOR_OFFICE_COMBOBOX, item)){
			click(driver, Interfaces.SchedulePage.OFFICE_COMBOBOX);
			type(driver, Interfaces.SchedulePage.OFFICE_COMBOBOX, item);
			sleep(3);
			waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_ITEM_FOR_OFFICE_COMBOBOX, item, 3);
		}
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_ITEM_FOR_OFFICE_COMBOBOX, item);
		sleep();
	}
	
	/**
	 * Check Provider Item Display
	 */
	public boolean isProviderItemDisplay(String item) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_PROVIDE_ITEM, item, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_PROVIDE_ITEM, item);
	}
	
	/**
	 * click On Confirmation Link
	 */
	public void clickOnConfirmationLink() {
		waitForControl(driver, Interfaces.SchedulePage.CONFIRMATION_LINK_ON_TASK, timeWait);
		sleep();
		click(driver, Interfaces.SchedulePage.CONFIRMATION_LINK_ON_TASK);
		sleep(3);
	}
	
	/**
	 * check List Of Confirmation Appointments Display
	 */
	public boolean isListOfConfirmationAppointmentsDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.LIST_CONFIRMED_APPOINTMENT_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.LIST_CONFIRMED_APPOINTMENT_TITLE);
	}
	
	/**
	 * check Appointment Display On List Of Confirmed Appointment
	 */
	public boolean isAppointmentDisplayOnListOfConfirmedAppointment(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_CONFIRMED_LIST,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_CONFIRMED_LIST,
				dateString, apptType, patientName, provider, apptStatus);
	}
	
	/**
	 * click On Confirm Link For An Appointment
	 */
	public void clickOnConfirmLinkForAnAppointment(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_CONFIRM_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_CONFIRM_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus);
	}
	
	/**
	 * add Note For Confirm Appointment
	 */
	public void addNoteForConfirmAppointment(String noteForConfirmAppointment) {
		waitForControl(driver, Interfaces.SchedulePage.CONFIRM_NOTE_CONTENT, timeWait);
		click(driver, Interfaces.SchedulePage.CONFIRM_NOTE_CONTENT);
		type(driver, Interfaces.SchedulePage.CONFIRM_NOTE_CONTENT, noteForConfirmAppointment);
		click(driver, Interfaces.SchedulePage.OK_BUTTON_ON_NOTE_CONFIRM_POPUP);
		sleep();
	}
	
	/**
	 * check Appt Status Display Correctly
	 */
	public boolean isApptStatusDisplayCorrectly(String status) {
		waitForControl(driver, Interfaces.SchedulePage.APPT_STATUS_COMBOBOX, timeWait);
		String realStatus = getItemSelectedCombobox(driver, Interfaces.SchedulePage.APPT_STATUS_COMBOBOX);
		return realStatus.contains(status);
	}
	
	/**
	 * click On Left Message Link For An Appointment
	 */
	public void clickOnLeftMessageLinkForAnAppointment(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_LEFT_MESSAGE_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_LEFT_MESSAGE_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus);
		sleep();
	}
	
	/**
	 * click On Reschedule Link For An Appointment
	 */
	public void clickOnRescheduleLinkForAnAppointment(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_RESCHEDULE_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_RESCHEDULE_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus);
	}
	
	/**
	 * add Note For Reschedule Appointment
	 */
	public void addNoteForRescheduleAppointment(String noteForRescheduleAppointment) {
		waitForControl(driver, Interfaces.SchedulePage.RESCHEDULE_NOTE_CONTENT, timeWait);
		click(driver, Interfaces.SchedulePage.RESCHEDULE_NOTE_CONTENT);
		type(driver, Interfaces.SchedulePage.RESCHEDULE_NOTE_CONTENT, noteForRescheduleAppointment);
		click(driver, Interfaces.SchedulePage.OK_BUTTON_ON_NOTE_CONFIRM_POPUP);
		sleep();
	}

	/**
	 * click On Cancel Link For An Appointment
	 */
	public void clickOnCancelLinkForAnAppointment(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_CANCEL_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_CANCEL_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus);
	}
	
	/**
	 * add Note For Cancel Appointment
	 */
	public void addNoteForCancelAppointment(String noteForCancelAppointment) {
		waitForControl(driver, Interfaces.SchedulePage.CANCEL_NOTE_CONTENT, timeWait);
		click(driver, Interfaces.SchedulePage.CANCEL_NOTE_CONTENT);
		type(driver, Interfaces.SchedulePage.CANCEL_NOTE_CONTENT, noteForCancelAppointment);
		click(driver, Interfaces.SchedulePage.OK_BUTTON_ON_NOTE_CONFIRM_POPUP);
		sleep();
	}
	
	/**
	 * check Calendar Event Popup Display
	 */
	public boolean isCalendarEventPopupDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.CALENDAR_EVENT_POPUP, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.CALENDAR_EVENT_POPUP);
	}
	
	/**
	 * get Number Of Confirmed Appointment Item
	 */
	public int getNumberOfConfirmedAppointmentItem() {
		int numberOfItem=0;
		waitForControl(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_CONFIRMED_APPOINTMENT, timeWait);
		sleep();
		numberOfItem = countElement(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_CONFIRMED_APPOINTMENT);
		return numberOfItem;
	}
	
	/**
	 * click On Search Confirmed Appointment Button
	 */
	public void clickOnSearchAppointmentButton() {
		waitForControl(driver, Interfaces.SchedulePage.SEARCH_APPOINTMENT_BUTTON, timeWait);
		click(driver, Interfaces.SchedulePage.SEARCH_APPOINTMENT_BUTTON);
		sleep();
	}
	
	/**
	 * input Patient Last Name Value
	 */
	public void inputPatientLastNameValue(String lastName) {
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_LAST_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.PATIENT_LAST_NAME_TEXTBOX);
		type(driver, Interfaces.SchedulePage.PATIENT_LAST_NAME_TEXTBOX, lastName);
		sleep(1);
	}
	
	/**
	 * input Patient First Name Value
	 */
	public void inputPatientFirstNameValue(String firstName) {
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_FIRST_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.PATIENT_FIRST_NAME_TEXTBOX);
		type(driver, Interfaces.SchedulePage.PATIENT_FIRST_NAME_TEXTBOX, firstName);
		sleep(1);
	}
	
	/**
	 * check Search Appointment Message Display With Content
	 */
	public boolean isSearchAppointmentMessageDisplayWithContent(String content) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_APPOINTMENT_MESSAGE, content, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_APPOINTMENT_MESSAGE, content);
	}
	
	/**
	 * input Patient Preferred Name Value
	 */
	public void inputPatientPreferredNameValue(String preferredname) {
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_PREFERRED_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.PATIENT_PREFERRED_NAME_TEXTBOX);
		type(driver, Interfaces.SchedulePage.PATIENT_PREFERRED_NAME_TEXTBOX, preferredname);
		sleep(1);
	}
	
	/**
	 * input Provider Last Name Value
	 */
	public void inputProviderLastNameValue(String lastName) {
		waitForControl(driver, Interfaces.SchedulePage.PROVIDER_LAST_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.PROVIDER_LAST_NAME_TEXTBOX);
		type(driver, Interfaces.SchedulePage.PROVIDER_LAST_NAME_TEXTBOX, lastName);
		sleep(1);
	}
	
	/**
	 * input Provider First Name Value
	 */
	public void inputProviderFirstNameValue(String firstName) {
		waitForControl(driver, Interfaces.SchedulePage.PROVIDER_FIRST_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.PROVIDER_FIRST_NAME_TEXTBOX);
		type(driver, Interfaces.SchedulePage.PROVIDER_FIRST_NAME_TEXTBOX, firstName);
		sleep(1);
	}
	
	/**
	 * select Appointment Type
	 */
	public void selectAppointmentType(String apptType) {
		waitForControl(driver, Interfaces.SchedulePage.CONFIRMED_APPOINTMENT_TYPE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SchedulePage.CONFIRMED_APPOINTMENT_TYPE_COMBOBOX, apptType);
		sleep(1);
	}
	
	/**
	 * input Scheduled Value
	 */
	public void inputScheduledValue(String scheduleValue) {
		waitForControl(driver, Interfaces.SchedulePage.SCHEDULED_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.SCHEDULED_TEXTBOX);
		type(driver, Interfaces.SchedulePage.SCHEDULED_TEXTBOX, scheduleValue);
		sleep(1);
	}
	
	/**
	 * check List Of Appointment Display With Patient Infor
	 */
	public boolean isListOfAppointmentDisplayWithPatientInfor(String patient) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_CONFIRMED_APPT_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_CONFIRMED_APPT_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_CONFIRMED_APPT_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(patient)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check Appointment Display With Correct Infor
	 */
	public boolean isAppointmentDisplayWithCorrectInfor(
			String apptType, String patientName, String provider) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_SEARCH_CONFIRMED_LIST,
				apptType, patientName, provider, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_SEARCH_CONFIRMED_LIST,
				apptType, patientName, provider);
	}
	
	/**
	 * View appointment details
	 */
	public PatientsPage viewAppointmentDetails(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_VIEW_DETAILS_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_VIEW_DETAILS_LINK_FOR_APPOINTMENT_ITEM,
				dateString, apptType, patientName, provider, apptStatus);
		return PageFactory.getPatientsPage(driver, ipClient);
	}
	
	/**
	 * Click on Rescheduled link
	 */
	public void clickOnRescheduledLink() {
		waitForControl(driver, Interfaces.SchedulePage.RESCHEDULED_LINK_ON_TASK, timeWait);
		sleep();
		click(driver, Interfaces.SchedulePage.RESCHEDULED_LINK_ON_TASK);
		sleep(3);
	}
	
	/**
	 * check List Of Pending Rescheduled Appointments Display
	 */
	public boolean isListOfPendingRescheduledAppointmentsDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.LIST_PEDING_RESCHEDULED_APPOINTMENT_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.LIST_PEDING_RESCHEDULED_APPOINTMENT_TITLE);
	}
	
	/**
	 * check Appointment Display On List Of Pending Rescheduled
	 */
	public boolean isAppointmentDisplayOnListOfPendingRescheduled(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_RESCHEDULED_LIST,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_RESCHEDULED_LIST,
				dateString, apptType, patientName, provider, apptStatus);
	}
	
	/**
	 * click On Cancel Link For Rescheduled Appointment
	 */
	public void clickOnCancelLinkForRescheduledAppointment(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_CANCEL_LINK_FOR_RESHCEDULED_APPOINTMENT,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_CANCEL_LINK_FOR_RESHCEDULED_APPOINTMENT,
				dateString, apptType, patientName, provider, apptStatus);
		sleep(3);
	}
	
	/**
	 * click On Schedule Link For Rescheduled Appointment
	 */
	public void clickOnScheduleLinkForRescheduledAppointment(String dateString,
			String apptType, String patientName, String provider, String apptStatus) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_SCHEDULE_LINK_FOR_RESCHEDULED_APPOINTMENT,
				dateString, apptType, patientName, provider, apptStatus, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_SCHEDULE_LINK_FOR_RESCHEDULED_APPOINTMENT,
				dateString, apptType, patientName, provider, apptStatus);
	}
	
	/**
	 * get Number Of Rescheduled Appointment Item
	 */
	public int getNumberOfRescheduledAppointmentItem() {
		int numberOfItem=0;
		waitForControl(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_RESCHEDULED_APPOINTMENT, timeWait);
		sleep();
		numberOfItem = countElement(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_RESCHEDULED_APPOINTMENT);
		return numberOfItem;
	}
	
	/**
	 * check Search Rescheduled Appointment Message Display With Content
	 */
	public boolean isSearchRescheduledAppointmentMessageDisplayWithContent(String message) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_RESCHEDULED_APPOINTMENT_MESSAGE, message, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_RESCHEDULED_APPOINTMENT_MESSAGE, message);
	}
	
	/**
	 * check List Of Rescheduled Appointment Display With Patient Infor
	 */
	public boolean isListOfRescheduledAppointmentDisplayWithPatientInfor(String patientName) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_RESCHEDULED_APPT_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_RESCHEDULED_APPT_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_RESCHEDULED_APPT_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(patientName)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check Rescheduled Appointment Display With Correct Infor
	 */
	public boolean isRescheduledAppointmentDisplayWithCorrectInfor(
			String apptType, String patientName, String provider) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_SEARCH_RESCHEDULED_LIST,
				apptType, patientName, provider, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_SEARCH_RESCHEDULED_LIST,
				apptType, patientName, provider);		
	}
	
//	/**
//	 * Down load CSV file on schedule page
//	 */
//	public void downloadConfirmedAppointmentList(String document) {
//		if (Common.getCommon().isFileExists(document)) {
//			Common.getCommon().deleteFile(document);
//		}
//		sleep();
//		clickOnCSVDownloadFileButton();
//		sleep();
//		
//		if (Common.getCommon().getCurrentBrowser()
//				.contains("FirefoxDriver")) {
//			Common.getCommon().saveFileOnFirefox();
//		}
//
//		Common.getCommon().waitForFileExist(document, 20);
//
//		sleep();
//	}
	
	/**
	 * click On Recalls Link
	 */
	public void clickOnRecallsLink() {
		waitForControl(driver, Interfaces.SchedulePage.RECALL_LINK_ON_TASK, timeWait);
		sleep();
		click(driver, Interfaces.SchedulePage.RECALL_LINK_ON_TASK);
		sleep(3);
	}
	
	/**
	 * check List Of Patients For Recall Display
	 */
	public boolean isListOfPatientsForRecallDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.LIST_RECALL_PATIENT_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.LIST_RECALL_PATIENT_TITLE);
	}
	
	/**
	 * viewRecallDetail
	 */
	public void viewRecallDetail(String patientName) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_VIEW_DETAILS_LINK_FOR_RECALL_ITEM,
				patientName, timeWait);
		sleep(1);
		click(driver, Interfaces.SchedulePage.DYNAMIC_VIEW_DETAILS_LINK_FOR_RECALL_ITEM,patientName);
		sleep(3);
	}
	
	/**
	 * check Recall Details Page Display
	 */
	public boolean isRecallDetailsPageDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_RECALL_DETAILS_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.PATIENT_RECALL_DETAILS_TITLE);
	}
	
	/**
	 * edit Recall Detail
	 */
	public void editRecallDetail(String date, String comment) {
		waitForControl(driver, Interfaces.SchedulePage.RECALL_DATE_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.RECALL_DATE_TEXTBOX);
		type(driver, Interfaces.SchedulePage.RECALL_DATE_TEXTBOX, date);
		click(driver, Interfaces.SchedulePage.RECALL_NOTE_TEXTBOX);
		type(driver, Interfaces.SchedulePage.RECALL_NOTE_TEXTBOX, comment);
		clickOnSaveButton();
		sleep();
	}
	
	/**
	 * Click on Save button
	 */
	public void clickOnSaveButton(){
		waitForControl(driver, Interfaces.SchedulePage.SAVE_RECALL_BUTTON, timeWait);
		click(driver, Interfaces.SchedulePage.SAVE_RECALL_BUTTON);
	}
	
	/**
	 * check Message Edit Successfully Display
	 */
	public boolean isMessageEditSuccessfullyDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.MESSAGE_EDIT_RECALL_SUCCESSFULLY, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.MESSAGE_EDIT_RECALL_SUCCESSFULLY);
	}
	
	/**
	 * get Number Of Recall Patient Item
	 */
	public int getNumberOfRecallPatientItem() {
		int numberOfItem=0;
		waitForControl(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_RECALL_PATIENT, timeWait);
		sleep();
		numberOfItem = countElement(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_RECALL_PATIENT);
		return numberOfItem;
	}
	
	/**
	 * check Search Patient Recall Message Display With Content
	 */
	public boolean isSearchPatientRecallMessageDisplayWithContent(String content) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_RECALL_PATIENT_MESSAGE, content, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_RECALL_PATIENT_MESSAGE, content);
	}
	
	/**
	 * check List Of Patient Recall Display With Patient Infor
	 */
	public boolean isListOfPatientRecallDisplayWithPatientInfor(String patientName) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_RECALL_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_RECALL_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_RECALL_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(patientName)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check Patient Recall Display With Correct Infor
	 */
	public boolean isPatientRecallDisplayWithCorrectInfor(String patientName, String provider) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_PATIENT_ITEM_IN_SEARCH_RECALL_LIST,
				patientName, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_PATIENT_ITEM_IN_SEARCH_RECALL_LIST,
				patientName);
	}
	
	/**
	 * click On Exception Link
	 */
	public void clickOnExceptionsLink() {
		waitForControl(driver, Interfaces.SchedulePage.EXCEPTIONS_LINK_ON_TASK, timeWait);
		sleep();
		click(driver, Interfaces.SchedulePage.EXCEPTIONS_LINK_ON_TASK);
		sleep(3);
	}
	
	/**
	 * check List Of Exception Appointment Display
	 */
	public boolean isListOfExceptionAppointmentDisplay() {
		waitForControl(driver, Interfaces.SchedulePage.LIST_EXCEPTION_APPOINTMENT_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.LIST_EXCEPTION_APPOINTMENT_TITLE);
	}
	
	/**
	 * get Number Of Exception Appointment Item
	 */
	public int getNumberOfExceptionAppointmentItem() {
		int numberOfItem=0;
		waitForControl(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_EXCEPTION_APPOINTMENT, timeWait);
		sleep();
		numberOfItem = countElement(driver, Interfaces.SchedulePage.ALL_ITEMS_OF_EXCEPTION_APPOINTMENT);
		return numberOfItem;
	}
	
	/**
	 * check Search Exception Appt Message Display With Content
	 */
	public boolean isSearchExceptionApptMessageDisplayWithContent(String content) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_EXCEPTION_APPOINTMENT_MESSAGE, content, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_SEARCH_EXCEPTION_APPOINTMENT_MESSAGE, content);
	}
	
	/**
	 * input Note Value
	 */
	public void inputNoteValue(String noteContent) {
		waitForControl(driver, Interfaces.SchedulePage.EXCEPTION_NOTE_TEXTBOX, timeWait);
		click(driver, Interfaces.SchedulePage.EXCEPTION_NOTE_TEXTBOX);
		type(driver, Interfaces.SchedulePage.EXCEPTION_NOTE_TEXTBOX, noteContent);
		sleep(1);
	}
	
	/**
	 * check List Of Exception Appt Display With Patient Infor
	 */
	public boolean isListOfExceptionApptDisplayWithPatientInfor(String patientName) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_EXCEPTION_APPT_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_EXCEPTION_APPT_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.SchedulePage.PATIENT_OF_ALL_EXCEPTION_APPT_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(patientName)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * Check Exception Appointment Display With Correct Infor
	 */
	public boolean isExceptionAppointmentDisplayWithCorrectInfor(
			String apptType, String patientName, String provider) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_SEARCH_EXCEPTION_LIST,
				apptType, patientName, provider, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.DYNAMIC_APPOINTMENT_ITEM_IN_SEARCH_EXCEPTION_LIST,
				apptType, patientName, provider);		
	}
	
	/**
	 * Click on Day tab
	 */
	public void clickOnDayTab() {
		waitForControl(driver, Interfaces.SchedulePage.DAY_TAB, timeWait);
		click(driver, Interfaces.SchedulePage.DAY_TAB);
		sleep();
	}
	
	/**
	 * Click on Week tab
	 */
	public void clickOnWeekTab() {
		waitForControl(driver, Interfaces.SchedulePage.WEEK_TAB, timeWait);
		click(driver, Interfaces.SchedulePage.WEEK_TAB);
		sleep();
	}
	
	/**
	 * check Tabs Opened
	 */
	public boolean isTabsOpened(String tabName) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_TAB_STYLE, tabName, timeWait);
		String tabStyle = getAttributeValue(driver, Interfaces.SchedulePage.DYNAMIC_TAB_STYLE, tabName, "class");
		if(tabStyle.contains("ui-tabs-selected ui-state-active")){
			return true;
		}
		else return false;
	}
	
	/**
	 * Click on Help link
	 */
	public void clickOnHelpLink() {
		waitForControl(driver, Interfaces.SchedulePage.HELP_LINK, timeWait);
		click(driver, Interfaces.SchedulePage.HELP_LINK);
		sleep(5);
	}
	
	/**
	 * check Help Page Is Opened
	 */
	public boolean isHelpPageOpened() {
		waitForControl(driver, Interfaces.SchedulePage.HELP_PAGE_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.HELP_PAGE_TITLE);
	}
	
	/**
	 * create New Appointment
	 */
	public void createNewAppointment(int date, int month, int year, int correctHour, int correctMinute,
			String apptType, String apptStatus, String patientFull, String refResource, 
			String noteContent, String correctStartTime, String correctEndTime, String provider) 
	{
		unCheckAllProvider();
		selectProviderCheckbox(true, provider);
		String newPatientName = patientFull.split(" ")[0];
		
		if(isAppointmentSavedSuccessfully(date, month, year, apptType, newPatientName))
		{
			openAppointmentOnScheduleDashboard(date, month, year, apptType, newPatientName);
			deleteAppointment();
		}
		selectTimeToScheduleNewCalendarEvent(date, month, year, correctHour, correctMinute);
		selectApptTypeOnCalendarEventPopup(apptType);
		selectApptStatusOnCalendarEventPopup(apptStatus);
		selectPatientOnCalendarEventPopup(patientFull);
		selectRefResourceOnCalendarEventPopup(refResource);
		inputNoteOnCalendarEventPopup(noteContent);
		selectDateOnCalendarEventPopup(date, month, year);
		selectStartTimeOnCalendarEventPopup(correctStartTime);
		selectEndTimeOnCalendarEventPopup(correctEndTime);
		selectProviderOnCalendarEventPopup(provider);
		clickSaveAndExitButton();
	}
	
	/**
	 * click On Checkin Appointment Data Button
	 */
	public PatientsPage clickOnCheckinAppointmentDataButton() {
		waitForControl(driver, Interfaces.SchedulePage.CHECKIN_APPOINTMENT_DATA_BUTTON, timeWait);
		click(driver, Interfaces.SchedulePage.CHECKIN_APPOINTMENT_DATA_BUTTON);
		sleep();
		return PageFactory.getPatientsPage(driver, ipClient); 
	}
	/**
	 * open Patients Tab
	 * @return
	 */
	public PatientsPage openPatientsTab(){
		waitForControl(driver, Interfaces.SchedulePage.UPLOAD_PATIENT_FILE_BUTTON, timeWait);
		click(driver, Interfaces.SchedulePage.UPLOAD_PATIENT_FILE_BUTTON);
		sleep();
		return PageFactory.getPatientsPage(driver, ipClient); 
	}
	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public String converAppointmentArrayToNumber(int a,int b){
		
		return (a-2)*6+(b-1) + "";
	}
	/**
	 * get ID Appointment On Schedule Dashboard
	 * @param date
	 * @param month
	 * @param year
	 * @param apptType
	 * @param patient
	 * @return Appointment ID
	 */
	public String getIDAppointmentOnScheduleDashboard(int date, int month, int year, 
			String apptType, String patient) {
		String currentDayInWeek;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
			int newdate = Common.getCommon().getDateAfterPlusOneDay(date, month, year);
			int newmonth = Common.getCommon().getMonthAfterPlusOneDay(date, month, year);
			int newyear = Common.getCommon().getYearAfterPlusOneDay(date, month, year);
			date = newdate;
			month = newmonth;
			year = newyear;
		}
		
		selectWeek(date, month, year, currentDayInWeek);
		
		waitForControl(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient, timeWait);
		String tmp = getAttributeValue(driver, Interfaces.SchedulePage.APPOITMENT_ITEM, 
				currentDayInWeek, apptType, patient, "class");
		String arr[] = tmp.split("-");
		return arr[6];
		
	}
	/**
	 * check Appointment Event Note Displays Correct
	 * @param date
	 * @param month
	 * @param year
	 * @param apptType
	 * @param patient
	 * @return
	 */
	public boolean isAppointmentEventNoteDisplaysCorrect(int date, int month, int year, String apptType, String patient,  String apptStatus, String patientName,String provider ){
		String currentDayInWeek;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
			int newdate = Common.getCommon().getDateAfterPlusOneDay(date, month, year);
			int newmonth = Common.getCommon().getMonthAfterPlusOneDay(date, month, year);
			int newyear = Common.getCommon().getYearAfterPlusOneDay(date, month, year);
			date = newdate;
			month = newmonth;
			year = newyear;
		}
		
		selectWeek(date, month, year, currentDayInWeek);
		
		waitForControl(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, 
				currentDayInWeek, apptType, patient, timeWait);
		
		element = getElement(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_TITLE, currentDayInWeek, apptType, patient);
		Actions action = new Actions(driver);
		Actions hoverOverRegistrar = action.moveToElement(element);
		hoverOverRegistrar.perform();
//		action.moveToElement(element);
//	    action.perform();
	    
	    sleep();
	    
	    if(!isControlDisplayed(driver, Interfaces.SchedulePage.APPOINTMENT_INFO_ON_DASHBOARD_LABEL_DYNAMIC,"status",apptStatus))
	    	return false;

	    if(!isControlDisplayed(driver, Interfaces.SchedulePage.APPOINTMENT_INFO_ON_DASHBOARD_LABEL_DYNAMIC,"provider",provider))
	    	return false;

	    if(!isControlDisplayed(driver, Interfaces.SchedulePage.APPOINTMENT_INFO_ON_DASHBOARD_LABEL_DYNAMIC,"patient",patientName))
	    	return false;
	    
		return true;
	}
	/**
	 * check Appointment Status Display Correctly On Schedule Dashboard
	 * @param date
	 * @param month
	 * @param year
	 * @param apptType
	 * @param patient
	 * @param status
	 * @return
	 */
	public boolean isApptStatusDisplayCorrectlyOnScheduleDashboard(int date, int month, int year, String apptType, String patient, String status){
String currentDayInWeek;
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("monday")){
			currentDayInWeek = "1";
		}else if(dateOfWeek.toLowerCase().equals("tuesday")){
			currentDayInWeek = "2";
		}else if(dateOfWeek.toLowerCase().equals("wednesday")){
			currentDayInWeek = "3";
		}else if(dateOfWeek.toLowerCase().equals("thursday")){
			currentDayInWeek = "4";
		}else if(dateOfWeek.toLowerCase().equals("friday")){
			currentDayInWeek = "5";
		}else if(dateOfWeek.toLowerCase().equals("saturday")){
			currentDayInWeek = "6";
		}else{
			currentDayInWeek = "1";
			int newdate = Common.getCommon().getDateAfterPlusOneDay(date, month, year);
			int newmonth = Common.getCommon().getMonthAfterPlusOneDay(date, month, year);
			int newyear = Common.getCommon().getYearAfterPlusOneDay(date, month, year);
			date = newdate;
			month = newmonth;
			year = newyear;
		}
		
		selectWeek(date, month, year, currentDayInWeek);
		
		waitForControl(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_STATUS_ICON_DYNAMIC,currentDayInWeek, apptType, patient,status.replace(" ", "_"), timeWait);
		
		if(!isControlDisplayed(driver, Interfaces.SchedulePage.APPOITMENT_ITEM_STATUS_ICON_DYNAMIC,currentDayInWeek, apptType, patient,status.replace(" ", "_")))
			return false;
		return true;
	}
	/**
	 * search Appointment By Name
	 * @param name
	 */
	public void searchAppointmentByName(String name){
		waitForControl(driver, Interfaces.SchedulePage.SEARCH_APPOINTMENT_BY_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.SchedulePage.SEARCH_APPOINTMENT_BY_NAME_TEXTBOX, name);
		click(driver, Interfaces.SchedulePage.SEARCH_APPOINTMENT_ON_DASHBOARD_BUTTON);
		sleep();
	}
	/**
	 * seach Locate Slot
	 * @param length
	 * @param period
	 */
	public void seachLocateSlot(String length, String period){
		waitForControl(driver, Interfaces.SchedulePage.CALENDAR_SEARCH_LENGTH_DROPBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SchedulePage.CALENDAR_SEARCH_LENGTH_DROPBOX, length);
		selectItemComboxbox(driver, Interfaces.SchedulePage.CALENDAR_SEARCH_LENGTH_PERIOD, period);
		click(driver, Interfaces.SchedulePage.FIND_NEXT_BUTTON);
		sleep();
	}
	/**
	 * check Appointment Locate Displays
	 * @return
	 */
	public boolean isAppointmentLocateDisplays(){
		waitForControl(driver, Interfaces.SchedulePage.APPOINTMENT_LOCATE_ITEM, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.APPOINTMENT_LOCATE_ITEM);
	}
	/**
	 * open Add Patient Popup
	 */
	public void oppenAddPatientPopup(){
		waitForControl(driver, Interfaces.SchedulePage.ADD_PATIENT_BUTTON, timeWait);
		click(driver, Interfaces.SchedulePage.ADD_PATIENT_BUTTON);
		sleep();
	}
	/**
	 * check Add Patient Popup Displays
	 */
	public boolean isAddPatientPopupDisplays(){
		waitForControl(driver, Interfaces.SchedulePage.ADD_PATIENT_POPUP, timeWait);
		return isControlDisplayed(driver, Interfaces.SchedulePage.ADD_PATIENT_POPUP);
	}
	/**
	 * select Provider Column Displays
	 */
	public void selectProviderColumnDisplays(String provider, boolean check){
		waitForControl(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS_CHECKBOX, provider, timeWait);
		
		if(check = true)
		{
			if(!isControlDisplayed(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS_CHECKBOX_CHECKED,provider))
				click(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS_CHECKBOX, provider);
		}
		else
		{
			if(isControlDisplayed(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS_CHECKBOX_CHECKED,provider))
				click(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS_CHECKBOX, provider);
		}
		sleep(5);
	}
	/**
	 * check Provider Column Displays
	 * @param provider
	 * @return
	 */
	public boolean isProviderColumnDisplays(String provider){
		waitForControl(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS,provider, timeWait);
//		int n = countElement(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS,provider);
		return isControlDisplayed(driver, Interfaces.SchedulePage.PROVIDER_COLUMN_DISPLAYS,provider);
	}
	/**
	 * check Office Combobox Displays
	 * @return
	 */
	public boolean isOfficeComboboxDisplays(){
		return isControlDisplayed(driver, Interfaces.SchedulePage.OFFICE_MAIN_SELECTOR_COMBOBOX);
	}
	/**
	 * select Schedule Tab
	 * @param tab
	 */
	public void selectScheduleTab(String tab){
		waitForControl(driver, Interfaces.SchedulePage.SCHEDULER_TAB_LINK, tab, timeWait);
		click(driver, Interfaces.SchedulePage.SCHEDULER_TAB_LINK, tab);
		sleep();
	}
	/**
	 * check Schedule Tab Day Displays
	 * @return
	 */
	public boolean isScheduleTabDisplays(String tab){
		waitForControl(driver, Interfaces.SchedulePage.SCHEDULER_TAB_LINK, tab, timeWait);
		String tmp = getAttributeValue(driver, Interfaces.SchedulePage.SCHEDULER_TAB_LINK, tab, "class");
		if(tmp.contains("active"))
			return true;
		else
			return false;
	}
	/**
	 * check Schedule Calendar Displays
	 * @return
	 */
	public boolean isScheduleCalendarDisplays(){
		return isControlDisplayed(driver, Interfaces.SchedulePage.SCHEDULE_CALENDER);
	}
	/**
	 * check Seach Calender Displays
	 * @return
	 */
	public boolean isSeachCalenderDisplays(){
		return isControlDisplayed(driver, Interfaces.SchedulePage.SEARCH_APPOINTMENT_BY_NAME_TEXTBOX);
	}
	/**
	 * check Search Locate Displays
	 * @return
	 */
	public boolean isSearchLocateDisplays(){
		return isControlDisplayed(driver, Interfaces.SchedulePage.CALENDAR_SEARCH_LENGTH_DROPBOX);
	}
	/**
	 * check Task Link Displays
	 * @param task
	 * @return
	 */
	public boolean isTaskLinkDisplays(String task){
		return isControlDisplayed(driver, Interfaces.SchedulePage.SCHEDULE_TASKS_LINK, task);
	}
	/**
	 * check List Icon Status Displays
	 * @return
	 */
	public boolean isListIconStatusDisplays(){
		return isControlDisplayed(driver, Interfaces.SchedulePage.LISTS_ICON_STATUS);
	}
	public boolean isAddPatientButtonDisplays(){
		return isControlDisplayed(driver, Interfaces.SchedulePage.ADD_PATIENT_BUTTON);
	}
	/**
	 * select Provider Checkbox with value true/false and Provider name
	 */
	public void selectProviderCheckbox(boolean value, String provider) {
		waitForControl(driver, Interfaces.SchedulePage.DYNAMIC_PROVIDER_CHECKBOX,provider, timeWait);
		sleep(1);
		String checkedValue = getAttributeValue(driver, 
				Interfaces.SchedulePage.DYNAMIC_PROVIDER_CHECKBOX,provider, "checked");
		if(value){
			if(checkedValue==null){
				click(driver, Interfaces.SchedulePage.DYNAMIC_PROVIDER_CHECKBOX,provider);
				sleep(1);
			}
		}else{
			if(checkedValue!=null){
				click(driver, Interfaces.SchedulePage.DYNAMIC_PROVIDER_CHECKBOX,provider);
				sleep(1);
			}
		}
	}

	/***
	 * Uncheck all Provider checkbox 
	 */
	public void unCheckAllProvider()
	{
		int numberofElement = countElement(driver, Interfaces.SchedulePage.SCHEDULE_LIST_PROVIDER_CHECKBOX);
		if(numberofElement!=0){
			List<WebElement> elements = getElements(driver, Interfaces.SchedulePage.SCHEDULE_LIST_PROVIDER_CHECKBOX);
			for (WebElement element : elements) {
				if(element.getAttribute("checked")!=null)
				{
					element.click();
				}
			}
		}
		
	}
	private WebDriver driver;
	private String ipClient;
}
