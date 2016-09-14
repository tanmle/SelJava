package page;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import common.Common;
import common.Constant;
import HearingFusion.Interfaces;

public class PatientsPage extends AbstractPage {

	public PatientsPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	
	/**
	 * check Appointment Details Page Display
	 */
	public boolean isAppointmentDetailsPageDisplay() {
		waitForControl(driver, Interfaces.PatientsPage.APPOINTMENT_DETAILS_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.APPOINTMENT_DETAILS_TITLE);
	}
	
	/**
	 * input Value To Patient Last Name Field
	 */
	public void inputValueToPatientLastNameField(String lastName) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_LAST_NAME_FIELD, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAIL_LAST_NAME_FIELD);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAIL_LAST_NAME_FIELD, lastName);
		sleep(1);
	}
	
	/**
	 * input Value To Patient First Name Field
	 */
	public void inputValueToPatientFirstNameField(String firstName) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_FIRST_NAME_FIELD, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAIL_FIRST_NAME_FIELD);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAIL_FIRST_NAME_FIELD, firstName);
		sleep(1);
	}
	
	/**
	 * input Value To Home Phone Field
	 */
	public void inputValueToHomePhoneField(String homePhone) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_HOME_PHONE_FIELD, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAIL_HOME_PHONE_FIELD);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAIL_HOME_PHONE_FIELD, homePhone);
		sleep(1);
	}
	
	/**
	 * click On Save Patient Detail Button
	 */
	public void clickOnSavePatientDetailButton() {
		waitForControl(driver, Interfaces.PatientsPage.SAVE_PATIENT_DETAIL_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SAVE_PATIENT_DETAIL_BUTTON);
		sleep();
	}
	
	/**
	 * check patient Detail Error Message Display With Content
	 */
	public boolean isPatientDetailErrorMessageDisplayWithContent(String errorContent) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAIL_ERROR_MESSAGE, 
				errorContent, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAIL_ERROR_MESSAGE, 
				errorContent);
	}
	
	/**
	 * check Patient Detail Save Successfully Message Display
	 */
	public boolean isPatientDetailSaveSuccessfullyMessageDisplay() {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_SAVE_SUCCESS_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAIL_SAVE_SUCCESS_MESSAGE);
	}
	
	/**
	 * input Value To Mobile Phone Field
	 */
	public void inputValueToMobilePhoneField(String mobilePhone) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_MOBILE_PHONE_FIELD, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAIL_MOBILE_PHONE_FIELD);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAIL_MOBILE_PHONE_FIELD, mobilePhone);
		sleep(1);
	}
	
	/**
	 * input Value To Work Phone Field
	 */
	public void inputValueToWorkPhoneField(String workPhone) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_WORK_PHONE_FIELD, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAIL_WORK_PHONE_FIELD);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAIL_WORK_PHONE_FIELD, workPhone);
		sleep(1);
	}
	
	/**
	 * input Value To Email1 Field
	 */
	public void inputValueToEmail1Field(String email) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_EMAIL1_FIELD, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAIL_EMAIL1_FIELD);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAIL_EMAIL1_FIELD, email);
		sleep(1);
	}
	
	/**
	 * input Value To Email2 Field
	 */
	public void inputValueToEmail2Field(String email) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAIL_EMAIL2_FIELD, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAIL_EMAIL2_FIELD);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAIL_EMAIL2_FIELD, email);
		sleep(1);
	}
	
	
	
	/**
	 * click On Referring Providers Link
	 */
	public void clickOnReferringProvidersLink() {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_LINK);
		sleep();
	}
	
	/**
	 * click On Search Referring Providers Button
	 */
	public void clickOnSearchReferringProvidersButton() {
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_REFERRING_PROVIDERS_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SEARCH_REFERRING_PROVIDERS_BUTTON);
		sleep(1);
	}
	
	/**
	 * check List Of Referring Providers Display
	 */
	public boolean isListOfReferringProvidersDisplay() {
		waitForControl(driver, Interfaces.PatientsPage.LIST_OF_REFERRING_PROVIDERS_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.LIST_OF_REFERRING_PROVIDERS_TITLE);
	}
	
	/**
	 * input Provider Last Name Search Referring Provider
	 */
	public void inputProviderLastNameSearchReferringProvider(String lastName) {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_LASTNAME_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_LASTNAME_TEXTBOX);
		type(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_LASTNAME_TEXTBOX, lastName);
		sleep(1);
	}
	
	/**
	 * input Provider Frist Name Search Referring Provider
	 */
	public void inputProviderFristNameSearchReferringProvider(String firstName) {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_FIRSTNAME_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_FIRSTNAME_TEXTBOX);
		type(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_FIRSTNAME_TEXTBOX, firstName);
		sleep(1);
	}
	
	/**
	 * input Practice Name Search Referring Provider
	 */
	public void inputPracticeNameSearchReferringProvider(String practiceName) {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_PRACTICE_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_PRACTICE_NAME_TEXTBOX);
		type(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_PRACTICE_NAME_TEXTBOX, practiceName);
		sleep(1);
	}
	
	/**
	 * input City Search Referring Provider
	 */
	public void inputCitySearchReferringProvider(String city) {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_CITY_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_CITY_TEXTBOX);
		type(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_CITY_TEXTBOX, city);
		sleep(1);
	}
	
	/**
	 * select State Search Referring Provider
	 */
	public void selectStateSearchReferringProvider(String state) {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_STATE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_STATE_COMBOBOX, state);
		sleep(1);
	}
	
	/**
	 * input Zip Code Search Referring Provider
	 */
	public void inputZipCodeSearchReferringProvider(String zipCode) {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_ZIP_CODE_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_ZIP_CODE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_ZIP_CODE_TEXTBOX, zipCode);
		sleep(1);
	}
	
	/**
	 * select Status Search Referring Provider
	 */
	public void selectStatusSearchReferringProvider(String status) {
		waitForControl(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_STATUS_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.REFERRING_PROVIDERS_STATUS_COMBOBOX, status);
		sleep(1);
	}
	
	/**
	 * check Search Referring Providers Error Message Display
	 */
	public boolean isSearchReferringProvidersErrorMessageDisplay(String content) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_REFERRING_PROVIDERS_SEARCH_ERROR_MESSAGE, 
				content, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_REFERRING_PROVIDERS_SEARCH_ERROR_MESSAGE,
				content);
	}
	
	/**
	 * check List Of Referring Providers With Name
	 */
	public boolean isListOfReferringProvidersWithName(String name) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.NAME_OF_ALL_REFERRING_PROVIDERS_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.NAME_OF_ALL_REFERRING_PROVIDERS_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.NAME_OF_ALL_REFERRING_PROVIDERS_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(name)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Referring Providers With Pratice Name
	 */
	public boolean isListOfReferringProvidersWithPracticeName(String name) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.PRACTICE_NAME_OF_ALL_REFERRING_PROVIDERS_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PRACTICE_NAME_OF_ALL_REFERRING_PROVIDERS_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PRACTICE_NAME_OF_ALL_REFERRING_PROVIDERS_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(name)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Referring Providers With City
	 */
	public boolean isListOfReferringProvidersWithCity(String city) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CITY_OF_ALL_REFERRING_PROVIDERS_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CITY_OF_ALL_REFERRING_PROVIDERS_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CITY_OF_ALL_REFERRING_PROVIDERS_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(city)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Referring Providers With State
	 */
	public boolean isListOfReferringProvidersWithState(String state) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.STATE_OF_ALL_REFERRING_PROVIDERS_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.STATE_OF_ALL_REFERRING_PROVIDERS_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.STATE_OF_ALL_REFERRING_PROVIDERS_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(state)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Referring Providers With Status
	 */
	public boolean isListOfReferringProvidersWithStatus(String status) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.STATUS_OF_ALL_REFERRING_PROVIDERS_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.STATUS_OF_ALL_REFERRING_PROVIDERS_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.STATUS_OF_ALL_REFERRING_PROVIDERS_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(status)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Referring Providers With ZipCode
	 */
	public boolean isListOfReferringProvidersWithZipCode(String zipcode) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.ZIPCODE_OF_ALL_REFERRING_PROVIDERS_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.ZIPCODE_OF_ALL_REFERRING_PROVIDERS_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.ZIPCODE_OF_ALL_REFERRING_PROVIDERS_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(zipcode)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
		
	/**
	 * expand Section On Checkin
	 */
	public void expandSectionOnCheckin(String section) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_EXPAND_SECTION_ICON, section, timeWait);
		sleep();
		element = getElement(driver, Interfaces.PatientsPage.DYNAMIC_EXPAND_SECTION_ICON, section);
		int x = element.getLocation().x;
		int y = element.getLocation().y;
		scrollPage(driver, x, y);
		sleep(1);
		click(driver, Interfaces.PatientsPage.DYNAMIC_EXPAND_SECTION_ICON, section);
		sleep(1);
	}
	
	/**
	 * add New Patient Recall
	 */
	public void addNewPatientRecall(String dateTime, String patientRecallNote, boolean isComplete) {
		clickNewPatientRecallButton();
		inputInfoPatientRecall(dateTime, patientRecallNote, isComplete);
		clickSaveButton();
	}
	
	/**
	 * click New Patient Recall Button
	 */
	public void clickNewPatientRecallButton() {
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_RECALL_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.NEW_PATIENT_RECALL_BUTTON);
		sleep();
	}
	
	/**
	 * input Info Patient Recall
	 */
	public void inputInfoPatientRecall(String dateTime, String patientRecallNote, boolean isComplete) {
		waitForControl(driver, Interfaces.PatientsPage.RECALL_DATE_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.RECALL_DATE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.RECALL_DATE_TEXTBOX, dateTime);
		click(driver, Interfaces.PatientsPage.RECALL_NOTE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.RECALL_NOTE_TEXTBOX, patientRecallNote);
		selectCompleteCheckbox(isComplete);
	}
	
	/**
	 * select Complete Combobox
	 */
	public void selectCompleteCheckbox(boolean isComplete) {
		waitForControl(driver, Interfaces.PatientsPage.COMPLETE_CHECKBOX, timeWait);
		String checkedValue = getAttributeValue(driver, Interfaces.PatientsPage.COMPLETE_CHECKBOX, "checked");
		if(isComplete){
			if(checkedValue==null){
				click(driver, Interfaces.PatientsPage.COMPLETE_CHECKBOX);
				sleep(1);
			}
		}else{
			if(checkedValue!=null){
				click(driver, Interfaces.PatientsPage.COMPLETE_CHECKBOX);
				sleep(1);
			}
		}
	}
	
	/**
	 * check Complete Checkbox Selected
	 */
	public boolean isCompleteCheckboxSelected(boolean isComplete) {
		waitForControl(driver, Interfaces.PatientsPage.COMPLETE_CHECKBOX, timeWait);
		String checkedValue = getAttributeValue(driver, Interfaces.PatientsPage.COMPLETE_CHECKBOX, "checked");
		if(isComplete){
			if(checkedValue==null){
				return false;
			}
			else return true;
		}else{
			if(checkedValue!=null){
				return false;
			}
			else return true;
		}
	}
	
	/**
	 * click Save Button
	 */
	public void clickSaveButton() {
		waitForControl(driver, Interfaces.PatientsPage.SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SAVE_BUTTON);
		sleep();
	}
	
	/**
	 * check Patient Recall Save Successfully
	 */
	public boolean isPatientRecallSaveSuccessfully() {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECALL_SAVED_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_RECALL_SAVED_MESSAGE);
	}
	
	/**
	 * check Patient Recall Display On Checkin
	 */
	public boolean isPatientRecallDisplayOnCheckin(String patientRecallNote) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_RECALL_ON_CHECKIN, 
				patientRecallNote, timeWait);
		return isControlDisplayed(driver, 
				Interfaces.PatientsPage.DYNAMIC_PATIENT_RECALL_ON_CHECKIN, patientRecallNote);
	}
	
	/**
	 * check Patient Recall Info Show Correctly
	 */
	public boolean isPatientRecallInfoShowCorrectly(String patientRecallNote, boolean isComplete) {
		waitForControl(driver, Interfaces.PatientsPage.RECALL_NOTE_TEXTBOX, timeWait);
		String actualNote = getText(driver, Interfaces.PatientsPage.RECALL_NOTE_TEXTBOX);
		boolean checkedResult = isCompleteCheckboxSelected(isComplete);
		if(actualNote.contains(patientRecallNote) && checkedResult){
			return true;
		}
		else return false;
	}
	
	/**
	 * view Patient Recall Detail
	 */
	public void viewPatientRecallDetail(String patientRecallNote) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_VIEW_DETAIL_PATIENT_RECALL, 
				patientRecallNote, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_VIEW_DETAIL_PATIENT_RECALL, patientRecallNote);
		sleep();
	}
	
	/**
	 * add New Clinical Note
	 */
	public void addNewClinicalNote(String clinicalNote) {
		clickNewClinicalNoteButton();
		inputInfoClinicalNote(clinicalNote);
		clickSaveButton();
	}
	
	/**
	 * click New Clinical Note Button
	 */
	public void clickNewClinicalNoteButton() {
		waitForControl(driver, Interfaces.PatientsPage.NEW_CLINICAL_NOTE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.NEW_CLINICAL_NOTE_BUTTON);
		sleep();
	}
	
	/**
	 * input Info Clinical Note
	 */
	public void inputInfoClinicalNote(String clinicalNote) {
		waitForControl(driver, Interfaces.PatientsPage.CLINICAL_NOTE_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CLINICAL_NOTE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CLINICAL_NOTE_TEXTBOX, clinicalNote);
	}

	/**
	 * check Clinical Note Display On Checkin
	 */
	public boolean isClinicalNoteDisplayOnCheckin(String clinicalNote) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_CLINICAL_NOTE_ON_CHECKIN, 
				clinicalNote, timeWait);
		return isControlDisplayed(driver, 
				Interfaces.PatientsPage.DYNAMIC_CLINICAL_NOTE_ON_CHECKIN, clinicalNote);
	}
	
	/**
	 * check Clinical Note Info Show Correctly
	 */
	public boolean isClinicalNoteInfoShowCorrectly(String clinicalNote, String enteredBy) {
		waitForControl(driver, Interfaces.PatientsPage.CLINICAL_NOTE_TEXTBOX, timeWait);
		String actualNote = getText(driver, Interfaces.PatientsPage.CLINICAL_NOTE_TEXTBOX);
		String actualEntered = getText(driver, Interfaces.PatientsPage.ENTERED_BY_LABEL);
		if(actualNote.contains(clinicalNote) && actualEntered.contains(enteredBy)){
			return true;
		}
		else return false;
	}
	
	/**
	 * view Clinical Note Detail
	 */
	public void viewClinicalNoteDetail(String clinicalNote) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_VIEW_DETAIL_CLINICAL_NOTE, 
				clinicalNote, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_VIEW_DETAIL_CLINICAL_NOTE, clinicalNote);
		sleep();
	}
	
	/**
	 * Click on Help link
	 */
	public void clickOnHelpLink() {
		waitForControl(driver, Interfaces.PatientsPage.HELP_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.HELP_LINK);
		sleep(5);
	}
	
	/**
	 * check Help Page Is Opened
	 */
	public boolean isHelpPageOpened() {
		waitForControl(driver, Interfaces.PatientsPage.HELP_PAGE_TITLE, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.HELP_PAGE_TITLE);
	}
	
	/**
	 * add New Chart Note
	 */
	public void addNewChartNote(String chartNote) {
		waitForControl(driver, Interfaces.PatientsPage.CHART_NOTE_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CHART_NOTE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CHART_NOTE_TEXTBOX, chartNote);
		sleep(1);
		clickOnSavePatientDetailButton();
	}
	
	/**
	 * check Chart Note Info Show Correctly
	 */
	public boolean isChartNoteInfoShowCorrectly(String chartNote) {
		waitForControl(driver, Interfaces.PatientsPage.CHART_NOTE_TEXTBOX, timeWait);
		String actualNote = getText(driver, Interfaces.PatientsPage.CHART_NOTE_TEXTBOX);
		if(actualNote.contains(chartNote)){
			return true;
		}
		else return false;
	}
	
	/**
	 * input Name Search Carrier
	 */
	public void inputNameSearchCarrier(String name) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CARRIER_SEARCH_NAME_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_NAME_TEXTBOX, name);
		sleep(1);
	}
	
	/**
	 * input Contract Date Search Carrier
	 */
	public void inputContractDateSearchCarrier(String contractDate) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CONTRACT_DATE_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CONTRACT_DATE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CONTRACT_DATE_TEXTBOX, contractDate);
		sleep(1);
	}
	
	/**
	 * input City Search Carrier
	 */
	public void inputCitySearchCarrier(String city) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CITY_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CITY_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CITY_TEXTBOX, city);
		sleep(1);
	}
	
	/**
	 * select State Search Carrier
	 */
	public void selectStateSearchCarrier(String state) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_STATE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.CARRIER_SEARCH_STATE_COMBOBOX, state);
		sleep(1);
	}
	
	/**
	 * input Zip Code Search Carrier
	 */
	public void inputZipCodeSearchCarrier(String zipCode) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_ZIP_CODE_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CARRIER_SEARCH_ZIP_CODE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_ZIP_CODE_TEXTBOX, zipCode);
		sleep(1);
	}
	
	/**
	 * input Phone Search Carrier
	 */
	public void inputPhoneSearchCarrier(String phone) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_PHONE_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CARRIER_SEARCH_PHONE_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_PHONE_TEXTBOX, phone);
		sleep(1);
	}
	
	/**
	 * input Fax Search Carrier
	 */
	public void inputFaxSearchCarrier(String fax) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_FAX_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.CARRIER_SEARCH_FAX_TEXTBOX);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_FAX_TEXTBOX, fax);
		sleep(1);
	}
	
	/**
	 * select In Network Search Carrier
	 */
	public void selectInNetworkSearchCarrier(String option) {
		if(!option.equals("")){
			if(option.equals("Yes")){
				click(driver, Interfaces.PatientsPage.IN_NETWORK_OPTION_RADIO_BUTTON, "1");
			} else if(option.equals("No")){
				click(driver, Interfaces.PatientsPage.IN_NETWORK_OPTION_RADIO_BUTTON, "2");
			} else click(driver, Interfaces.PatientsPage.IN_NETWORK_OPTION_RADIO_BUTTON, "3");
			sleep(1);
		}
	}
	
	/**
	 * click On Search Button
	 */
	public void clickOnSearchButton(WebDriver driver) {

		waitForControl(driver, Interfaces.PatientsPage.SEARCH_BUTTON, timeWait);
		if (Common.getCommon().getCurrentBrowser().contains("InternetExplorerDriver")) {
			switchToTopWindowFrame(driver);
			scrollPage(driver, 100, 100);
			switchToInsuranceFrame(driver);
			click(driver, Interfaces.PatientsPage.SEARCH_BUTTON);
			sleep();
			switchToTopWindowFrame(driver);
			scrollPage(driver,0,0);
			switchToInsuranceFrame(driver);
		}
		else
		{
			click(driver, Interfaces.PatientsPage.SEARCH_BUTTON);
			sleep();
		}

	}
	
	/**
	 * check List Of Carriers With Name
	 */
	public boolean isListOfCarriersWithName(String name) {
		boolean returnValue = false;
		waitForControl(driver, Interfaces.PatientsPage.NAME_OF_ALL_CARRIER_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.NAME_OF_ALL_CARRIER_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.NAME_OF_ALL_CARRIER_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(text.contains(name)){
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Carriers With Contract Date
	 */
	public boolean isListOfCarriersWithContractDate(String contractDate) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CONTRACT_DATE_OF_ALL_CARRIER_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CONTRACT_DATE_OF_ALL_CARRIER_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CONTRACT_DATE_OF_ALL_CARRIER_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(contractDate)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Carriers With city
	 */
	public boolean isListOfCarriersWithCity(String city) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CITY_OF_ALL_CARRIER_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CITY_OF_ALL_CARRIER_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CITY_OF_ALL_CARRIER_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(city)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check List Of Carriers With state
	 */
	public boolean isListOfCarriersWithState(String state) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.STATE_OF_ALL_CARRIER_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.STATE_OF_ALL_CARRIER_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.STATE_OF_ALL_CARRIER_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(state)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * close Search Carrier Popup
	 */
	public void closeSearchCarrierPopup() {
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_SEARCH_CARRIER_POPUP, timeWait);
		click(driver, Interfaces.PatientsPage.CLOSE_SEARCH_CARRIER_POPUP);
		sleep(1);
	}
	
	/**
	 * check Search Carrier Message Display
	 */
	public boolean isSearchCarrierMessageDisplay(String content) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_CARRIER_SEARCH_MESSAGE, content, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_CARRIER_SEARCH_MESSAGE, content);
	}
	
	/**
	 * click New Insurance Record Button
	 */
	public void clickNewInsuranceRecordButton() {
		waitForControl(driver, Interfaces.PatientsPage.NEW_INSURANCE_RECORD_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.NEW_INSURANCE_RECORD_BUTTON);
		sleep();
	}
	
	/**
	 * click On Search Icon For Carrier
	 */
	public void clickOnSearchIconForCarrier() {
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_FOR_CARRIER_ICON, timeWait);
		click(driver, Interfaces.PatientsPage.SEARCH_FOR_CARRIER_ICON);
		sleep();
	}
	
	/**
	 * check List Of Carriers Display
	 */
	public boolean isListOfCarriersDisplay() {
		waitForControl(driver, Interfaces.PatientsPage.LIST_OF_CARRIERS_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.LIST_OF_CARRIERS_TITLE);
	}
	
	/**
	 * Switch driver to PatientInsuranceDetails frame
	 * @return driver
	 */
	public WebDriver switchToInsuranceFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.PatientsPage.INSURANCE_FRAME, timeWait);
		sleep(5);
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.PatientsPage.INSURANCE_FRAME)));
		return driver;
	}
	
	/**
	 * view Invoices Sales Orders Detail
	 */
	public SalesPage viewInvoicesSalesOrdersDetail(String orderID) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_VIEW_DETAIL_INVOICES_SALES_ORDERS, 
				orderID, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_VIEW_DETAIL_INVOICES_SALES_ORDERS, orderID);
		sleep();
		return PageFactory.getSalesPage(driver, ipClient); 
	}
	
	/**
	 * click New InvoicesSalesOrders Button
	 */
	public SalesPage clickAddNewInvoicesSalesOrders() {
		waitForControl(driver, Interfaces.PatientsPage.NEW_INVOICES_SALES_ORDERS_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.NEW_INVOICES_SALES_ORDERS_BUTTON);
		sleep();
		return PageFactory.getSalesPage(driver, ipClient);
	}
	
	/**
	 * check SalesOrders Display By Id
	 */
	public boolean isSalesOrdersDisplayById(String id) {
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_INVOICE_SALE_ITEM, id, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_INVOICE_SALE_ITEM, id);		
	}
	
	/**
	 * select add new Insurace icon 
	 */
	public SalesPage selectAddNewInsurance()
	{
		waitForControl(driver, Interfaces.PatientsPage.ADD_NEW_INSURACE_ICON, timeWait);
		click(driver, Interfaces.PatientsPage.ADD_NEW_INSURACE_ICON);
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.ADD_NEW_INSURACE_ICON, timeWait);
		return PageFactory.getSalesPage(driver, ipClient); 
	}
	
	/**
	 * Verify Carrier with field's value show in list carrier
	 * @param filed: Name, Contract date, City, State, Zip code, Phone, Fax, In network? 
	 * @param value 
	 */
	public boolean isCarrierShowInlistCarriers(String field, String value)
	{
		int nCarrier = countElement(driver, Interfaces.PatientsPage.RESULT_TABLE_LIST_CARRIER_FOUND);
		String tmp = "";
		for(int i = 1; i<=nCarrier ; i++)
		{
			tmp = getText(driver, Interfaces.PatientsPage.DYNAMIC_CARRIER_ITEM_IN_LIST_CARRIERS_FOUND, i+"",field);
			if(tmp.contains(value))
				return true;
		}
		return false;
	}

	/**
	 * Download file CSV Result Founf Carrier
	 */
	public void downloadFileCSVResultFoundCarrier(String document) {

		Common.getCommon().deleteFile(document);
		waitForControl(driver, Interfaces.PatientsPage.CSV_DOWNLOAD_LINK,
				timeWait);
		click(driver, Interfaces.PatientsPage.CSV_DOWNLOAD_LINK);
		sleep();
		if (Common.getCommon().getCurrentBrowser().contains("FirefoxDriver")) {
			Common.getCommon().saveFileOnFirefox();
		}
		else if (Common.getCommon().getCurrentBrowser().contains("InternetExplorerDriver")) {
			Common.getCommon().saveFileOnIE();
		}
		waitFileDownloaded(document, timeWait);

		sleep();
	}
	/**
	 * wait for complete download file
	 */
	public void waitFileDownloaded(String file, int times) {

		boolean isDownloaded = Common.getCommon().isFileExists(file);
		int i = 0;
		while (isDownloaded == false && i <= times) {
			sleep(2);
			i++;
			isDownloaded = Common.getCommon().isFileExists(file);
		}
	}
	/**
	 * check Email Page Is Opened
	 */
	public boolean isEmailPageOpened() {
		waitForControl(driver, Interfaces.PatientsPage.EMAIL_DETAIL_FORM, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.EMAIL_DETAIL_FORM);
	}
	
	/**
	 * Click on Email link
	 */
	public void clickOnEmailLink() {
		waitForControl(driver, Interfaces.PatientsPage.EMAIL_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.EMAIL_LINK);
		sleep(5);
	}
	
	/**
	 * Click on Print Link
	 */
	public void clickOnPrintLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PRINT_EMAIL, timeWait);
		click(driver, Interfaces.PatientsPage.PRINT_EMAIL);
		sleep(5);
	}
	
	/**
	 * check Print Page Is Opened
	 */
	public boolean isPrintPageOpened()
	{
		sleep();
		Common.getCommon().closePrintPopup(driver);
		waitForControl(driver, Interfaces.PatientsPage.PRINT_TABLE, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PRINT_TABLE);
	}
	

	/**
	 * Select an Carrier by Name
	 * @param Name 
	 */
	public void selectCarrierByName(String name)
	{
		int nCarrier = countElement(driver, Interfaces.PatientsPage.RESULT_TABLE_LIST_CARRIER_FOUND);
		String tmp = "";
		for(int i = 1; i<=nCarrier ; i++)
		{
			tmp = getText(driver, Interfaces.PatientsPage.DYNAMIC_CARRIER_ITEM_IN_LIST_CARRIERS_FOUND, i+"","Name");
			if(tmp.contains(name))
				click(driver, Interfaces.PatientsPage.DYNAMIC_LINK_CARRIER_ITEM_IN_LIST_CARRIERS_FOUND,i+"");
		}
	}
	
	/**
	 * Select Patient Insurace Plan Type
	 * @param value  Plan Type
	 */
	public void selectPatientInsuracePlanType(String value)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_INSURACE_PLAN_TYPE_COMBOBOX, timeWait);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_INSURACE_PLAN_TYPE_COMBOBOX, value);
	}
	
	/**
	 * click Save Patient Insurace
	 */
	public void clickSavePatientInsurace()
	{
		
		waitForControl(driver, Interfaces.PatientsPage.SAVE_PATIENT_INSURACE_BUTTON, timeWait);
		scrollPage(driver,0,0);
		click(driver, Interfaces.PatientsPage.SAVE_PATIENT_INSURACE_BUTTON);
	}
	
	/**
	 * check cannot save patient insurace
	 */
	public boolean isCannotSavePaitentInsurace(){
		waitForControl(driver, Interfaces.PatientsPage.MESSAGE_CANNOT_SAVE_INSURACE, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.MESSAGE_CANNOT_SAVE_INSURACE);
	}
	
	/**
	 * check message warning position required
	 */
	public boolean isMessageWarningPositionRequiredDisplays(){
		waitForControl(driver, Interfaces.PatientsPage.MESSAGE_WARNING_POSITION, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.MESSAGE_WARNING_POSITION);
	}
	/**
	 * select Patient Insurace Position
	 */
	public void selectPatientInsuracePosition(String position){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_INSURACE_POSITION, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_INSURACE_POSITION, position);
		sleep();
	}
	
	/**
	 * check save Patient Insurace success
	 */
	public boolean isSavePaitentInsuraceSuccess()
	{
		waitForControl(driver, Interfaces.PatientsPage.MESSAGE_SAVE_PATIENT_INSURANCE, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.MESSAGE_SAVE_PATIENT_INSURANCE);
	}
	
	/**
	 * Type Patient Insurace Subscriber
	 */
	public void inputPatientInsuraceSubscriber(String subscriber){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_INSURANCE_SUBSCRIBER_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_INSURANCE_SUBSCRIBER_TEXTBOX, subscriber);
		sleep();
	}
	/**
	 * click New Hearing Aids Record Button
	 */
	public void clickNewHearingAidsRecordButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_HEARING_AIDS_RECORD_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.NEW_HEARING_AIDS_RECORD_BUTTON);
		sleep();
	}
	/**
	 * check Hearing Aids Back and Save button displays
	 */
	public boolean isHearingAidsBackSaveButtonDisplaysCorrect(){
		waitForControl(driver, Interfaces.PatientsPage.SAVE_PATIENT_HEARING_AIDS_BUTTON, timeWait);
		element = getElement(driver, Interfaces.PatientsPage.SAVE_PATIENT_HEARING_AIDS_BUTTON);
		int xSave = element.getLocation().x;
		element = getElement(driver, Interfaces.PatientsPage.BACK_PATIENT_HEARING_AIDS_BUTTON);
		int xBack = element.getLocation().x;
		
		if(xSave > xBack)
			return true;
		else
			return false;
		
	}
	/**
	 * input Hearing Aids Left Ear Purchse Date
	 */
	public void inputHearingAidsLeftEarPurchseDate(int month, int day, int year)
	{
		String date = month+"/"+day+"/"+year;
		waitForControl(driver, Interfaces.PatientsPage.LEFT_PURCHASE_DATE_HEARING_AID_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.LEFT_PURCHASE_DATE_HEARING_AID_TEXTBOX, date);
	}
	/**
	 * Select Hearing Aids left status
	 */
	public void selectHearintAidsLeftEarStatus(String status)
	{
		waitForControl(driver, Interfaces.PatientsPage.LEFT_STATUS_HEARING_AID_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_STATUS_HEARING_AID_COMBOBOX, status);
	}
	/**
	 * Select Hearing Aids left Manufacturer
	 */
	public void selectHearingAidsLeftEarManufacturer(String manufacturer)
	{
		waitForControl(driver, Interfaces.PatientsPage.LEFT_MANUFACTURER_HEARING_AID_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_MANUFACTURER_HEARING_AID_COMBOBOX, manufacturer);
	}
	
	/**
	 * Select Hearing Aids left Manufacturer
	 */
	public void selectHearingAidsLeftEarType(String type)
	{
		waitForControl(driver, Interfaces.PatientsPage.LEFT_TYPE_HEARING_AID_COMBOBOX_OPTION,type, timeWait);
		click(driver, Interfaces.PatientsPage.LEFT_TYPE_HEARING_AID_COMBOBOX_OPTION,type);
		sleep();
//		waitForControl(driver, Interfaces.PatientsPage.COMBOBOX_ITEM,type, timeWait);
//		click(driver, Interfaces.PatientsPage.COMBOBOX_ITEM,type);
//		selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_MANUFACTURER_HEARING_AID_TEXTBOX, type);
	}
	/**
	 * Select Hearing Aids left MODEL
	 */
	public void selectHearingAidsLeftEarModel(String model)
	{
		waitForControl(driver, Interfaces.PatientsPage.LEFT_MODEL_HEARING_AID_COMBOBOX_OPTION,model, timeWait);
		click(driver, Interfaces.PatientsPage.LEFT_MODEL_HEARING_AID_COMBOBOX_OPTION,model);
	}
	/**
	 * input Hearing Aids left Type serial
	 */
	public void inputHearingAidsLeftTypeSearial(String serial)
	{
		waitForControl(driver, Interfaces.PatientsPage.LEFT_TYPE_SERIAL_HEARING_AID_TEXTBOX, timeWait);
		sleep();
		type(driver, Interfaces.PatientsPage.LEFT_TYPE_SERIAL_HEARING_AID_TEXTBOX, serial);
	}
	///////////
	/**
	 * input Hearing Aids Right Ear Purchse Date
	 */
	public void inputHearingAidsRightEarPurchseDate(int month, int day, int year)
	{
		String date = month+"/"+day+"/"+year;
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_PURCHASE_DATE_HEARING_AID_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.RIGHT_PURCHASE_DATE_HEARING_AID_TEXTBOX, date);
	}
	/**
	 * Select Hearing Aids Right status
	 */
	public void selectHearintAidsRightEarStatus(String status)
	{
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_STATUS_HEARING_AID_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_STATUS_HEARING_AID_COMBOBOX, status);
	}
	/**
	 * Select Hearing Aids Right Manufacturer
	 */
	public void selectHearingAidsRightEarManufacturer(String manufacturer)
	{
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_MANUFACTURER_HEARING_AID_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_MANUFACTURER_HEARING_AID_COMBOBOX, manufacturer);
	}
	
	/**
	 * Select Hearing Aids Right Manufacturer
	 */
	public void selectHearingAidsRightEarType(String type)
	{
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_TYPE_HEARING_AID_COMBOBOX_OPTION,type, timeWait);
		sleep();
//		selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_MANUFACTURER_HEARING_AID_TEXTBOX, type);
		click(driver, Interfaces.PatientsPage.RIGHT_TYPE_HEARING_AID_COMBOBOX_OPTION, type);
//		sleep();
//		waitForControl(driver, Interfaces.PatientsPage.COMBOBOX_ITEM,type, timeWait);
//		click(driver, Interfaces.PatientsPage.COMBOBOX_ITEM,type);
	}
	/**
	 * Select Hearing Aids Right MODEL
	 */
	public void selectHearingAidsRightEarModel(String model)
	{
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_MODEL_HEARING_AID_COMBOBOX_OPTION,model, timeWait);
//		selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_MODEL_HEARING_AID_TEXTBOX, model);
		click(driver, Interfaces.PatientsPage.RIGHT_MODEL_HEARING_AID_COMBOBOX_OPTION, model);
//		sleep();
//		waitForControl(driver, Interfaces.PatientsPage.COMBOBOX_ITEM,model, timeWait);
//		click(driver, Interfaces.PatientsPage.COMBOBOX_ITEM,model);
	}
	/**
	 * input Hearing Aids Right Type serial
	 */
	public void inputHearingAidsRightTypeSearial(String serial)
	{
		sleep(5);
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_TYPE_SERIAL_HEARING_AID_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.RIGHT_TYPE_SERIAL_HEARING_AID_TEXTBOX, serial);
	}
	/**
	 * Select save hearing Aid button
	 */
	public void clickSaveHearingAid(){
		waitForControl(driver, Interfaces.PatientsPage.SAVE_PATIENT_HEARING_AIDS_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SAVE_PATIENT_HEARING_AIDS_BUTTON);
	}
	/**
	 * Check message save hearing Aid displays
	 */
	public boolean isHearingAidsSaveSuccessfully(){
		waitForControl(driver, Interfaces.PatientsPage.MESSAGE_SAVE_HEARING_AID, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.MESSAGE_SAVE_HEARING_AID);
	}
	/**
	 * Select add item Equiment
	 * @param option = "Add Gadget/Add Ear Mold"
	 */
	public void selectAddItemEquimentButton(String option)
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_EQUIMENT_ITEM_BUTTON, timeWait);
		sleep();
//		click(driver, Interfaces.PatientsPage.NEW_EQUIMENT_ITEM_BUTTON);
		executeJavaScript(driver, "document.getElementById('btnSddm').click()");
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_EQUIMENT_ITEM_BUTTON,option, timeWait);
		sleep();
		click(driver, Interfaces.PatientsPage.DYNAMIC_EQUIMENT_ITEM_BUTTON,option);
	}
	/**
	 * click Save Equipment Gadget
	 */
	public void clickSaveEquipmentGadget()
	{
		waitForControl(driver, Interfaces.PatientsPage.SAVE_EQUIMENT_GADGET_BUTTON, timeWait);
		scrollPage(driver, 0, 0);
		click(driver, Interfaces.PatientsPage.SAVE_EQUIMENT_GADGET_BUTTON);
	}
	/**
	 * check error message Equipmen Gadget Require Displaysx
	 * @return
	 */
	public boolean isErrorMessageEquipmentGadgetRequireDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.ERROR_MESSAGE_EQUIMENT_GADGET_REQUIRE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.ERROR_MESSAGE_EQUIMENT_GADGET_REQUIRE);
	}
	
	/**
	 * select Hearing Aid Add new Gadget Status
	 * @param Status
	 */
	public void selectHearingAidAddGadgetStatus(String Status){
		waitForControl(driver, Interfaces.PatientsPage.STATUS_HEARING_AID_ADD_GADGET_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.STATUS_HEARING_AID_ADD_GADGET_COMBOBOX, Status);
	}
	/**
	 * input Hearing Aids Add Gadget Purcharse Date
	 * @param month
	 * @param day
	 * @param year
	 */
	public void inputHearingAidsAddGadgetPurcharseDate(int month, int day, int year){
		String date = month+"/"+day+"/"+year;
		waitForControl(driver, Interfaces.PatientsPage.PURCHASE_DATE_HEARING_AID_ADD_GADGET_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.PURCHASE_DATE_HEARING_AID_ADD_GADGET_TEXTBOX, date);
	}
	
	/**
	 * select Hearing Aids Add Gadget Manufacturer
	 * @param manu
	 */
	public void selectHearingAidsAddGadgetManufacturer(String manu){
		waitForControl(driver, Interfaces.PatientsPage.MANUFACTURER_HEARING_AID_ADD_GADGET_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.MANUFACTURER_HEARING_AID_ADD_GADGET_COMBOBOX, manu);
	}
	/**
	 * select Hearing Aids Add Gadget Type
	 * @param type
	 */
	public void selectHearingAidsAddGadgetType(String type){
		sleep();
		waitForControl(driver, Interfaces.PatientsPage.TYPE_HEARING_AID_ADD_GADGET_COMBOBOX_DYNAMIC,type, timeWait);
		click(driver, Interfaces.PatientsPage.TYPE_HEARING_AID_ADD_GADGET_COMBOBOX_DYNAMIC, type);
	}
	/**
	 * select Hearing Aids Add Gadget Part
	 * @param part
	 */
	public void selectHearingAidsAddGadgetPart(String part){
		sleep();
		waitForControl(driver, Interfaces.PatientsPage.PART_HEARING_AID_ADD_GADGET_COMBOBOX_DYNAMIC,part, timeWait);
		click(driver, Interfaces.PatientsPage.PART_HEARING_AID_ADD_GADGET_COMBOBOX_DYNAMIC, part);
	}
	/**
	 * input Hearing Aids Add Gadget Description
	 * @param description
	 */
	public void inputHearingAidsAddGadgetDescription(String des){
		waitForControl(driver, Interfaces.PatientsPage.DESCRIPTION_HEARING_AID_ADD_GADGET_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.DESCRIPTION_HEARING_AID_ADD_GADGET_TEXTBOX, des);
	}
	/**
	 * input Hearing Aids Add Gadget Description
	 * @param Type Serial
	 */
	public void inputHearingAidsAddGadgetTypeSerial(String serial){
		waitForControl(driver, Interfaces.PatientsPage.TYPE_SERIAL_HEARING_AID_ADD_GADGET_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.TYPE_SERIAL_HEARING_AID_ADD_GADGET_TEXTBOX, serial);
	}
	/**
	 * open Detail An Equipment 
	 * @param serial
	 */
	public void openDetailAnEquipment(String serial){
		waitForControl(driver, Interfaces.PatientsPage.EDIT_HEARING_AID_GADGET_LINK_DYNAMIC,serial, timeWait);
		click(driver, Interfaces.PatientsPage.EDIT_HEARING_AID_GADGET_LINK_DYNAMIC,serial);
	}
	/**
	 * Check Record Saved Successfully
	 * @return
	 */
	public boolean isRecordSavedSuccessfully(){
		waitForControl(driver, Interfaces.PatientsPage.RECORD_SAVED_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.RECORD_SAVED_MESSAGE);
	}
	/**
	 * input Hearing Aids Add Gadget Remark
	 * @param remark
	 */
	public void inputHearingAidsAddGadgetRemark(String remark){
		waitForControl(driver, Interfaces.PatientsPage.REMARK_HEARING_AID_ADD_GADGET_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.REMARK_HEARING_AID_ADD_GADGET_TEXTBOX, remark);
	}
	/**
	 * click Save Edit Equipment Gadget
	 */
	public void clickSaveEditEquipmentGadget(){
		waitForControl(driver, Interfaces.PatientsPage.SAVE_EDIT_EQUIMENT_GADGET_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SAVE_EDIT_EQUIMENT_GADGET_BUTTON);
	}
	/**
	 * input Earmold Left Purchase Date
	 * @param month
	 * @param day
	 * @param year
	 */
	public void inputEarmoldLeftPurchaseDate(int month, int day, int year){
		String date = month+"/"+day+"/"+year;
		waitForControl(driver, Interfaces.PatientsPage.LEFT_PURCHASE_DATE_EQUIMENT_EARMOLD_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.LEFT_PURCHASE_DATE_EQUIMENT_EARMOLD_TEXTBOX, date);
	}
	/**
	 * select Earmold Left Manufacturer
	 * @param menu
	 */
	public void selectEarmoldLeftManufacturer(String manu)
	{
		waitForControl(driver, Interfaces.PatientsPage.LEFT_MANUFACTURER_EQUIMENT_EARMOLD_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_MANUFACTURER_EQUIMENT_EARMOLD_COMBOBOX, manu);
	}
	/**
	 * select Earmold Left Model
	 * @param model
	 */
	public void selectEarmoldLeftModel(String model){
		sleep();
		waitForControl(driver, Interfaces.PatientsPage.LEFT_MODEL_EQUIMENT_EARMOLD_COMBOBOX,model, timeWait);
		click(driver, Interfaces.PatientsPage.LEFT_MODEL_EQUIMENT_EARMOLD_COMBOBOX, model);
	}
	/**
	 * input Earmold Left Description
	 * @param Description
	 */
	public void inputEarmoldLeftDescription(String des){
		waitForControl(driver, Interfaces.PatientsPage.LEFT_DESCRIPTION_EARMOLD_COMBOBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.LEFT_DESCRIPTION_EARMOLD_COMBOBOX, des);
	}
	/**
	 * select Earmold Right Manufacturer
	 * @param manu
	 */
	public void selectEarmoldRightManufacturer(String manu){
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_MANUFACTURER_EQUIMENT_EARMOLD_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_MANUFACTURER_EQUIMENT_EARMOLD_COMBOBOX, manu);
	}
	/**
	 * select Earmold Right Model
	 * @param model
	 */
	public void selectEarmoldRightModel(String model){
		sleep();
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_MODEL_EQUIMENT_EARMOLD_COMBOBOX,model, timeWait);
		click(driver, Interfaces.PatientsPage.RIGHT_MODEL_EQUIMENT_EARMOLD_COMBOBOX, model);
	}
	/**
	 * input Earmold Right Description
	 * @param Description
	 */
	public void inputEarmoldRightDescription(String des)
	{
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_DESCRIPTION_EARMOLD_COMBOBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.RIGHT_DESCRIPTION_EARMOLD_COMBOBOX, des);
	}
	
	/**
	 * click Save Equipment Earmold
	 */
	public void clickSaveEquipmentEarmold(){
		waitForControl(driver, Interfaces.PatientsPage.SAVE_EQUIMENT_EARMOLD_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SAVE_EQUIMENT_EARMOLD_BUTTON);
	}
	/**
	 * click Save Return Equipment Earmold
	 */
	public void clickSaveReturnEquipmentEarmold(){
		waitForControl(driver, Interfaces.PatientsPage.SAVE_RETURN_EQUIMENT_EARMOLD_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SAVE_RETURN_EQUIMENT_EARMOLD_BUTTON);
	}
	/**
	 * check Patient Main Page Displays
	 */
	public boolean isPatientMainPageDisplays(){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CHECKIN_DETAIL_FORM, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_CHECKIN_DETAIL_FORM);
		
	}
	/**
	 * select Add New CBO link
	 */
	public void selectAddNewCBO(){
		waitForControl(driver, Interfaces.PatientsPage.ADD_NEW_CBO_BILLING_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.ADD_NEW_CBO_BILLING_LINK);
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.ADD_NEW_CBO_BILLING_LINK, timeWait);
	}
	/**
	 * select an user for CBO
	 * @param user
	 */
	public void selectCBOAssign(String user)
	{
		waitForControl(driver, Interfaces.PatientsPage.ASSIGNED_CBO_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.ASSIGNED_CBO_COMBOBOX, user);
	}
	/**
	 * input CBO Follow date
	 * @param month
	 * @param day
	 * @param year
	 */
	public void inputCBOFollow(int month, int day, int year)
	{
		String date = month+"/"+day+"/"+year;
		waitForControl(driver, Interfaces.PatientsPage.FOLLOW_UP_CBO_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.FOLLOW_UP_CBO_TEXTBOX, date);
	}
	/**
	 * input CBO New Message
	 * @param msg
	 */
	public void inputCBONewMessage(String msg){
		waitForControl(driver, Interfaces.PatientsPage.NEW_MESSAGE_CBO_TEXTBOX, timeWait);
		type(driver,  Interfaces.PatientsPage.NEW_MESSAGE_CBO_TEXTBOX, msg);
	}
	/**
	 * Upload a file for CBO
	 */
	public void uploadCBOFile(WebDriver driver){
		waitForControl(driver, Interfaces.PatientsPage.ATTACH_FILE_CBO_BUTTON, timeWait);
		click(driver,  Interfaces.PatientsPage.ATTACH_FILE_CBO_BUTTON);
		if(driver.toString().contains("InternetExplorer"))
		{
			Common.getCommon().sendkey(KeyEvent.VK_SPACE);
		}
		Common.getCommon().openFileForUpload(driver, Constant.TXT_FILE);
	}
	/**
	 * click Save CBO Billing
	 */
	public void clickSaveCBOBilling(){
		waitForControl(driver, Interfaces.PatientsPage.SAVE_CBO_BUTTON, timeWait);
		click(driver,  Interfaces.PatientsPage.SAVE_CBO_BUTTON);
	}
	/**
	 * select CBO Status
	 * @param status
	 */
	public void selectCBOStatus(String status){
		waitForControl(driver, Interfaces.PatientsPage.STATUS_CBO_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.STATUS_CBO_COMBOBOX, status);
	}
	/**
	 * open CBO Billing Note Detail Page
	 */
	public void openCBOBillingNoteDetailPage(String msg){
		waitForControl(driver, Interfaces.PatientsPage.CBO_BILLING_DETAIL_PAGE_LINK_DYNAMIC,msg, timeWait);
		click(driver, Interfaces.PatientsPage.CBO_BILLING_DETAIL_PAGE_LINK_DYNAMIC,msg);
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.CBO_BILLING_DETAIL_PAGE_LINK_DYNAMIC, msg, timeWait);
	}
	/**
	 * open CBO Billing Note Message Details
	 * @param msg
	 */
	public void openCBOBillingNoteMessageDetails(String msg){
		waitForControl(driver, Interfaces.PatientsPage.CBO_BILLING_DETAIL_MESSAGE_LINK_DYNAMIC,msg, timeWait);
		click(driver, Interfaces.PatientsPage.CBO_BILLING_DETAIL_MESSAGE_LINK_DYNAMIC,msg);
		sleep(5);
	}
	/**
	 * 
	 * @param msg
	 * @return
	 */
	public boolean isCBOBillingMessageDetailDisplays(String msg)
	{
		waitForControl(driver, Interfaces.PatientsPage.CBO_BILLNG_MESSAGE_DETAIL_DYNAMIC,msg, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.CBO_BILLNG_MESSAGE_DETAIL_DYNAMIC, msg);
	}
	/**
	 * check CBO Billing Message Detail Print Displays
	 * @param driver
	 * @return
	 */
	public boolean isCBOBillingMessageDetailPrintDisplays(WebDriver driver){
		boolean isShow = false;
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		waitForControl(driver, Interfaces.PatientsPage.CBO_BILLNG_MESSAGE_DETAIL_PRINT_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.CBO_BILLNG_MESSAGE_DETAIL_PRINT_BUTTON);
		sleep();
		
		String currentHandlefunction = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandlesfuntion = driver.getWindowHandles();
		newHandlesfuntion.removeAll(openWindowHandles);
		String handlefuntion = newHandlesfuntion.iterator().next();
		driver.switchTo().window(handlefuntion);
		
		Common.getCommon().closePrintPopup(driver);
		waitForControl(driver, Interfaces.PatientsPage.PRINT_TABLE, 5);
		isShow = isControlDisplayed(driver, Interfaces.PatientsPage.PRINT_TABLE);
		
		driver.close();
		driver.switchTo().window(currentHandlefunction);
		

		driver.close();
		driver.switchTo().window(currentHandle);
		return isShow;
	}
	/**
	 * click Create New Associated Offices Icon
	 */
	public void clickCreateNewAssociatedOfficeIcon(){
		waitForControl(driver, Interfaces.PatientsPage.CREATE_NEW_ASSOCIATED_OFFICES_ICON, timeWait);
		click(driver, Interfaces.PatientsPage.CREATE_NEW_ASSOCIATED_OFFICES_ICON);
		sleep(5);
	}
	/**
	 * click Search Last Office Item Associated
	 */
	public void clickSearchLastOfficeItemAssociated(){
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		click(driver, Interfaces.PatientsPage.SEARCH_OFFICE_ASSOCIATED_OFFICES_ICON_DYNAMIC, count+"");
		sleep();
	}
	/**
	 * switch To Search hAssociated Frame
	 */
	public WebDriver switchToSearchAssociatedFrame(WebDriver driver){
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_OFFICE_ASSOCIATED_FRAME,count+"", timeWait);
		sleep();
		String xpath = String.format(Interfaces.PatientsPage.SEARCH_OFFICE_ASSOCIATED_FRAME, count+"");
		driver = driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
		return driver;
	}
	/**
	 * click Search For Offices button
	 */
	public void clickSearchForOffices(){
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_OFFICE_ASSOCIATED_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SEARCH_OFFICE_ASSOCIATED_BUTTON);
	}
	/**
	 * check Show Associated Office List
	 * @return
	 */
	public boolean isShowAssociatedOfficeList(){
		waitForControl(driver, Interfaces.PatientsPage.LIST_OFFICES_ASSOCIATED_OFFICES, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.LIST_OFFICES_ASSOCIATED_OFFICES);
	}
	
	/**
	 * enter Name Search Associated Offices
	 * @param name
	 */
	public void enterNameSearchAssociatedOffices(String name){
		waitForControl(driver, Interfaces.PatientsPage.NAME_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.NAME_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, name);
	}
	
	/**
	 * check Search Associated Offices Message Display
	 */
	public boolean isSearchAssociatedOfficesMessageDisplay(String content) {
		waitForControl(driver, Interfaces.PatientsPage.ASSOCIATED_OFFICE_SEARCH_MESSAGE_DYNAMIC, content, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.ASSOCIATED_OFFICE_SEARCH_MESSAGE_DYNAMIC, content);
	}
	
	/**
	 * check List Of Associated Offices have item With Name
	 */
	public boolean isItemListAssociatedOfficesWithName(String name) {
		boolean returnValue = false;
		waitForControl(driver, Interfaces.PatientsPage.NAME_OF_ALL_ASSOCIATED_OFFICE_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.NAME_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.NAME_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(text.contains(name)){
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * enter City Search Associated Offices
	 * @param city
	 */
	public void enterCitySearchAssociatedOffices(String city){
		waitForControl(driver, Interfaces.PatientsPage.CITY_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CITY_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, city);
	}
	
	/**
	 * close Search Associated Office Popup
	 */
	public void closeSearchAssociatedOfficePopup()
	{
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_SEARCH_ASSOCIATED_OFFICE_BUTTON_DYNAMIC,count+"", timeWait);
		click(driver,Interfaces.PatientsPage.CLOSE_SEARCH_ASSOCIATED_OFFICE_BUTTON_DYNAMIC,count+"");
		
	}
	/**
	 * check Item List Associated Offices displays With City
	 * @param city
	 */
	public boolean isItemListAssociatedOfficesWithCity(String city){
		boolean returnValue = false;
		waitForControl(driver, Interfaces.PatientsPage.CITY_OF_ALL_ASSOCIATED_OFFICE_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CITY_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CITY_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(text.contains(city)){
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * select State Associated Offices
	 * @param state
	 */
	public void selectStateAssociatedOffices(String state){
		waitForControl(driver, Interfaces.PatientsPage.STATE_ASSOCIATED_OFFICE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.STATE_ASSOCIATED_OFFICE_COMBOBOX, state);
	}
	/**
	 * check Item List Associated Offices With State
	 * @param state
	 * @return
	 */
	public boolean isItemListAssociatedOfficesWithState(String state){
		boolean returnValue = false;
		waitForControl(driver, Interfaces.PatientsPage.STATE_OF_ALL_ASSOCIATED_OFFICE_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.STATE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.STATE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(text.contains(state)){
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * enter Zip Code Search Associated Offices
	 * @param zipcode
	 */
	public void enterZipCodeSearchAssociatedOffices(String zipcode){
		waitForControl(driver, Interfaces.PatientsPage.ZIP_CODE_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.ZIP_CODE_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, zipcode);
	}
	/**
	 * check Item List Associated Offices With Zip Code
	 * @param zipcode
	 * @return
	 */
	public boolean isItemListAssociatedOfficesWithZipCode(String zipcode){
		boolean returnValue = false;
		waitForControl(driver, Interfaces.PatientsPage.ZIP_CODE_OF_ALL_ASSOCIATED_OFFICE_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.ZIP_CODE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.ZIP_CODE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(text.contains(zipcode)){
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * select county Associated Offices
	 * @param county
	 */
	public void selectCountyAssociatedOffices(String county){
		waitForControl(driver, Interfaces.PatientsPage.COUNTY_ASSOCIATED_OFFICE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.COUNTY_ASSOCIATED_OFFICE_COMBOBOX, county);
	}
	/**
	 * 
	 * @param county
	 * @return
	 */
	public boolean isItemListAssociatedOfficesWithCounty(String county){
		boolean returnValue = false;
		waitForControl(driver, Interfaces.PatientsPage.COUNTRY_CODE_OF_ALL_ASSOCIATED_OFFICE_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.COUNTRY_CODE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.COUNTRY_CODE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(text.contains(county)){
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * enter Phone Search Associated Offices
	 * @param phone
	 */
	public void enterPhoneSearchAssociatedOffices(String phone){
		waitForControl(driver, Interfaces.PatientsPage.PHONE_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PHONE_SEARCH_ASSOCIATED_OFFICE_TEXTBOX, phone);
	}
	/**
	 * check Item List Associated Offices Phone
	 * @param phone
	 * @return
	 */
	public boolean isItemListAssociatedOfficesWithPhone(String phone){
		boolean returnValue = false;
		waitForControl(driver, Interfaces.PatientsPage.PHONE_OF_ALL_ASSOCIATED_OFFICE_ITEMS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PHONE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PHONE_OF_ALL_ASSOCIATED_OFFICE_ITEMS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(text.contains(phone)){
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * click Search Provider Last Item Associated Office
	 */
	public void clickSearchProviderLastItemAssociatedOffice(){
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		click(driver, Interfaces.PatientsPage.SEARCH_PROVIDER_ASSOCIATED_OFFICES_ICON_DYNAMIC, count+"");
		sleep();
	}
	
	/**
	 * switch To Search Provider Associated Frame
	 */
	public WebDriver switchToSearchProviderAssociatedFrame(WebDriver driver){
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_PROVIDER_ASSOCIATED_FRAME_DYNAMIC,count+"", timeWait);
		sleep();
		String xpath = String.format(Interfaces.PatientsPage.SEARCH_PROVIDER_ASSOCIATED_FRAME_DYNAMIC, count+"");
		driver = driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
		return driver;
	}
	/**
	 * check Show Provider Associated Office List
	 * @return
	 */
	public boolean isShowProviderAssociatedOfficeList(){
		waitForControl(driver, Interfaces.PatientsPage.LIST_PROVIDER_ASSOCIATED_OFFICES, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.LIST_PROVIDER_ASSOCIATED_OFFICES);
	}
	/**
	 * close Search Provider Associated Office Popup
	 */
	public void closeSearchProviderAssociatedOfficePopup(){
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_SEARCH_PROVIDER_ASSOCITED_OFFICES_LINK_DYNAMIC,count+"", timeWait);
		click(driver, Interfaces.PatientsPage.CLOSE_SEARCH_PROVIDER_ASSOCITED_OFFICES_LINK_DYNAMIC,count+"");
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.CLOSE_SEARCH_PROVIDER_ASSOCITED_OFFICES_LINK_DYNAMIC,count+"", timeWait);
	}
	/**
	 * close Search Office Associated Office Popup
	 */
	public void closeSearchOfficeAssociatedOfficePopup(){
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_SEARCH_OFFICE_ASSOCITED_OFFICES_LINK_DYNAMIC,count+"", timeWait);
		click(driver, Interfaces.PatientsPage.CLOSE_SEARCH_OFFICE_ASSOCITED_OFFICES_LINK_DYNAMIC,count+"");
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.CLOSE_SEARCH_OFFICE_ASSOCITED_OFFICES_LINK_DYNAMIC,count+"", timeWait);
	}
	/**
	 * select Offices Item Associated Offices
	 * @param officeName (ex: Pittsburgh)
	 */
	public void selectOfficesItemAssociatedOffices(String officeName){
		waitForControl(driver, Interfaces.PatientsPage.OFFICE_ITEM_ASSOCITED_OFFICES_LINK_DYNAMIC,officeName, timeWait);
		click(driver, Interfaces.PatientsPage.OFFICE_ITEM_ASSOCITED_OFFICES_LINK_DYNAMIC,officeName);
	}
	/**
	 * enter Associated Offices Provider Last Name
	 * @param provider Last Name
	 */
	public void enterAssociatedOfficesProviderLastName(String providerLastName){
		waitForControl(driver, Interfaces.PatientsPage.PROVIDER_LAST_NAME_ASSOCIATED_OFFICES_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PROVIDER_LAST_NAME_ASSOCIATED_OFFICES_TEXTBOX, providerLastName);
	}
	
	/**
	 * enter Associated Offices Provider First Name
	 * @param provider First Name
	 */
	public void enterAssociatedOfficesProviderFirstName(String providerFirstName){
		waitForControl(driver, Interfaces.PatientsPage.PROVIDER_FIRST_NAME_ASSOCIATED_OFFICES_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PROVIDER_FIRST_NAME_ASSOCIATED_OFFICES_TEXTBOX, providerFirstName);
	}
	/**
	 * check Search Provider Associated Offices Message Display
	 * @param message
	 * @return
	 */
	public boolean isSearchProviderAssociatedOfficesMessageDisplay(String message){
		waitForControl(driver, Interfaces.PatientsPage.ASSOCIATED_OFFICE_SEARCH_PROVIDER_MESSAGE_DYNAMIC, message, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.ASSOCIATED_OFFICE_SEARCH_PROVIDER_MESSAGE_DYNAMIC, message);
	}
	/**
	 * check Provider Item List Associated Offices With Last Name
	 * @return
	 */
	public boolean isProviderItemListAssociatedOfficesWithLastName(String lastName){
		waitForControl(driver, Interfaces.PatientsPage.PROVIDER_ASSOCIATED_OFFICE_PROVIDER_ITEMS_LINK_DYNAMIC,lastName, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PROVIDER_ASSOCIATED_OFFICE_PROVIDER_ITEMS_LINK_DYNAMIC,lastName);
	}
	/**
	 * clicks Provider Item List Associated Offices
	 * @param Name
	 */
	public void clicksProviderItemListAssociatedOffices(String Name){
		waitForControl(driver, Interfaces.PatientsPage.PROVIDER_ASSOCIATED_OFFICE_PROVIDER_ITEMS_LINK_DYNAMIC,Name, timeWait);
		click(driver, Interfaces.PatientsPage.PROVIDER_ASSOCIATED_OFFICE_PROVIDER_ITEMS_LINK_DYNAMIC,Name);

	}
	/**
	 * select Associated Offices Default Current
	 * @param option
	 */
	public void selectAssociatedOfficesDefaultCurrent(String option){
		int count = countElement(driver, Interfaces.PatientsPage.COUNT_OFFICE_ASSOCIATED_OFFICES_ITEMS);
		if(option.toLowerCase().equals("yes")){
			click(driver, Interfaces.PatientsPage.YES_DEFAULT_CURRENT_ASSOCIATED_OFFICE, count+"");
		}
		else
			click(driver, Interfaces.PatientsPage.NO_DEFAULT_CURRENT_ASSOCIATED_OFFICE, count+"");
	}
	/**
	 * open Patient By Name
	 * @param lastName
	 * @param firstName
	 */
	public void openPatientByName(String lastName, String firstName){
		String name = lastName+", "+firstName;
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_PATIENT_LAST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.SEARCH_PATIENT_LAST_NAME_TEXTBOX, lastName);
		
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_PATIENT_FIRST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.SEARCH_PATIENT_FIRST_NAME_TEXTBOX, firstName);
		sleep();
		click(driver, Interfaces.PatientsPage.SEARCH_PATIENT_BUTTON);
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_SEARCH_RESULT_LINK_DYNAMIC,name, timeWait);
		sleep();
		click(driver, Interfaces.PatientsPage.PATIENT_SEARCH_RESULT_LINK_DYNAMIC, name);
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.SEARCH_PATIENT_LAST_NAME_TEXTBOX, timeWait);
		
	}
	/**
	 * click Cloud Docs Button
	 */
	public void clickCloudDocsButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.CLOUD_DOCS_BUTTON);
		sleep();
//		executeJavaScript(driver, "ShowCloudDocs();");
	}
	/**
	 * switch To Cloud Docs Frame
	 * @return
	 */
	public WebDriver switchToCloudDocsFrame(WebDriver driver){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FRAME, timeWait);
		sleep();
		String xpath = String.format(Interfaces.PatientsPage.CLOUD_DOCS_FRAME);
		driver = driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
		return driver;
	}
	/**
	 * addCloudDocsFile
	 */
	public void addCloudDocsFile(){
		waitForControl(driver, Interfaces.PatientsPage.UPLOAD_CLOUD_DOCS_FILE_BUTTON, timeWait);
		click(driver,  Interfaces.PatientsPage.UPLOAD_CLOUD_DOCS_FILE_BUTTON);
//		executeJavaScript(driver, "$(\"#cloudFrame\").contents().find(\"[type='file']\")[0].click(function(){alert('click')})");
		Common.getCommon().openFileForUpload(driver, Constant.CLOUD_DOCS_FILE);
		waitForControl(driver,  Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "cloudDocsTest.txt",timeWait );
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON))
			click(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON);

	}
	/**
	 * open Cloud Docs File
	 * @param fileName
	 */
	public void openCloudDocsFile(String fileName){
		waitForControl(driver,
				Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,
				fileName, timeWait);
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName)){
			click(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,
					fileName);
			sleep();
			click(driver, Interfaces.PatientsPage.OPEN_CLOUD_DOCS_FILE_LINK);
			sleep(4);
		}
	}
	/**
	 * 
	 * @param content
	 * @return
	 */
	public boolean isCloudDocsFileOpen(String content){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_CONTENTS, timeWait);
		String tmp = getText(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_CONTENTS);
		if (tmp.contains(content)) {
			return true;
		}
		else
			return false;
	}
	/**
	 * remove Cloud Docs File
	 * @param fileName
	 */
	public void removeCloudDocsFile(String fileName)
	{
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName, timeWait);
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName)){
			click(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName);
			//right click
			element = getElement(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName);
			Actions actions = new Actions(driver);    
			Action action=actions.contextClick(element).build(); //pass WebElement as an argument
			action.perform();
			//
			sleep();
			click(driver, Interfaces.PatientsPage.DELETE_CLOUD_DOCS_FILE_LINK);
			waitForControlNotDisplayed(driver, Interfaces.PatientsPage.APPROVE_REMOVE_CLOUD_DOCS_FILE, timeWait);
			click(driver, Interfaces.PatientsPage.APPROVE_REMOVE_CLOUD_DOCS_FILE);
			waitForControlNotDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName, timeWait);
			sleep();
		}
	}
	/**
	 * Cloud Docs File Exists
	 * @param fileName
	 * @return
	 */
	public boolean isCloudDocsFileExists(String fileName){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName);
	}
	/**
	 * edit Cloud Docs File Content
	 * @param newName
	 * @param oldName
	 */
	public void editCloudDocsFileName(String newName, String oldName){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,newName, timeWait);
		// right click
		element = getElement(driver,Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, newName);
		Actions actions = new Actions(driver);
		Action action = actions.contextClick(element).build();
		action.perform();
		sleep();
		//
		click(driver, Interfaces.PatientsPage.RENAME_CLOUD_DOCS_FILE_LINK);
		sleep();
		type(driver, Interfaces.PatientsPage.NAME_CLOUD_DOCS_FILE_TEXTBOX_DYNAMIC,newName , oldName);
		Common.getCommon().sendkey(KeyEvent.VK_ENTER);
	}
	/**
	 * edit Cloud Docs File Content
	 * @param file Name
	 * @param editcontent
	 */
	public void editCloudDocsFileContent(String file, String editcontent){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,file, timeWait);
		// right click
		element = getElement(driver,Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, file);
		Actions actions = new Actions(driver);
		Action action = actions.contextClick(element).build();
		action.perform();
		sleep();
		//
		click(driver, Interfaces.PatientsPage.EDIT_CLOUD_DOCS_FILE_LINK);
		waitForControl(driver, Interfaces.PatientsPage.EDIT_CLOUD_DOCS_FILE_CONTENT_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.EDIT_CLOUD_DOCS_FILE_CONTENT_TEXTBOX , editcontent);
		click(driver, Interfaces.PatientsPage.SAVE_EDIT_CLOUD_DOCS_FILE_BUTTON);
	}
	/**
	 * select Cloud Docs File
	 * @param cloudDocsFile
	 */
	public void selectCloudDocsFile(String cloudDocsFile){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,cloudDocsFile, timeWait);
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,cloudDocsFile))
			click(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,cloudDocsFile);
	}
	/**
	 * open Cloud Docs File Info
	 */
	public void openCloudDocsFileInfo(String cloudDocsFile){
		selectCloudDocsFile(cloudDocsFile);
		click(driver, Interfaces.PatientsPage.GET_INFO_CLOUD_DOCS_LINK);
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_INFO_CLOUD_DOCS_LINK, timeWait);		
	}
	/**
	 * check Cloud Docs Info 
	 * @param info
	 * @return
	 */
	public boolean isCloudDocsInfoDisplays(String info){
		waitForControl(driver, Interfaces.PatientsPage.INFO_CLOUD_DOCS_LABEL_DYNAMIC, info, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.INFO_CLOUD_DOCS_LABEL_DYNAMIC, info);
	}
	/**
	 * close Cloud Docs File Info
	 */
	public void closeCloudDocInfo(){
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_INFO_CLOUD_DOCS_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.CLOSE_INFO_CLOUD_DOCS_LINK);
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.CLOSE_INFO_CLOUD_DOCS_LINK, timeWait);
	}
	/**
	 * add New Cloud Docs Forder
	 * @param folderName
	 */
	public void addNewCloudDocsForder(String folderName){
		waitForControl(driver, Interfaces.PatientsPage.ADD_NEW_FOLDER_CLOUD_DOCS_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.ADD_NEW_FOLDER_CLOUD_DOCS_LINK);
		waitForControl(driver, Interfaces.PatientsPage.CHANGE_NAME_CLOUD_DOCS_FOLDER_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CHANGE_NAME_CLOUD_DOCS_FOLDER_TEXTBOX, folderName);
		Common.getCommon().sendkey(KeyEvent.VK_ENTER);
	}
	/**
	 * check Selectv Cloud Docs File Success
	 * @param fileName
	 * @return
	 */
	public boolean isSelectCloudDocsFileSuccess(String fileName){
		waitForControl(driver, Interfaces.PatientsPage.FILE_CLOUD_DOCS_SELECTED_LABEL_DYNAMIC, fileName, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.FILE_CLOUD_DOCS_SELECTED_LABEL_DYNAMIC, fileName);
	}
	/**
	 * duplicate Cloud Docs File
	 * @param fileName
	 */
	public void duplicateCloudDocsFile(String fileName){
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,fileName)){

		selectCloudDocsFile(fileName);
		rightClick(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, fileName);
		sleep();
		click(driver, Interfaces.PatientsPage.DUPLICATE_CLOUD_DOCS_FILE_LINK);
		sleep();			
		}
	}
//	/**
//	 * check Cloud Docs Duplicate File
//	 * @param fileName
//	 * @return
//	 */
//	public boolean isCloudDocsDuplicateFile(String fileName){
//		String arrayTmp[] = fileName.split(".");
//		String tmp = arrayTmp[0]+" ."+arrayTmp[1];
//		return isCloudDocsFileExists(tmp);
//	}
	/**
	 * open Main Patient Cloud Docs
	 */
	public void openMainPatientCloudDocs(){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_HOME_PAGE_LINK, timeWait);
		click(driver,  Interfaces.PatientsPage.CLOUD_DOCS_HOME_PAGE_LINK);
		sleep();
	}
	/**
	 * reload Cloud Docs Folder
	 */
	public void reloadCloudDocsFolder(){
		waitForControl(driver, Interfaces.PatientsPage.RELOAD_CLOUD_DOCS_LINK, timeWait);
		click(driver,  Interfaces.PatientsPage.RELOAD_CLOUD_DOCS_LINK);
	}
	/**
	 * folder Reload Success
	 * @param folder
	 * @return
	 */
	public boolean folderReloadSuccess(String folder){
		waitForControl(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE);
	}
	/**
	 * add Cloud Docs File By Right Click
	 */
	public void addCloudDocsFileByRightClick(){
		waitForControl(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE, timeWait);
		rightClick(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE);
		
		waitForControl(driver, Interfaces.PatientsPage.UPLOAD_FILE_RIGHT_CLOUD_DOCS_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.UPLOAD_FILE_RIGHT_CLOUD_DOCS_LINK);
		
		waitForControl(driver, Interfaces.PatientsPage.SELECT_FILE_UPLOAD_CLOUD_DOCS_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.SELECT_FILE_UPLOAD_CLOUD_DOCS_LINK);
		
		Common.getCommon().openFileForUpload(driver, Constant.CLOUD_DOCS_FILE);
		waitForControl(driver,  Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "cloudDocsTest.txt",timeWait );
		
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON))
			click(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON);
	}
	/**
	 * upload 31 Files Cloud Docs
	 */
	public void upload31FilesCloudDocs(){
		waitForControl(driver, Interfaces.PatientsPage.UPLOAD_CLOUD_DOCS_FILE_BUTTON, timeWait);
		click(driver,  Interfaces.PatientsPage.UPLOAD_CLOUD_DOCS_FILE_BUTTON);
		Common.getCommon().open31FileForUpload(driver);
		waitForControl(driver,  Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "file4.txt",timeWait );
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON))
			click(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON);
	}
	/**
	 * is Cloud Docs Upload 31 File Success
	 * @return
	 */
	public boolean isCloudDocsUpload31FileSuccess(){
		String tmp = "";
		for(int i = 1; i<=31;i++){
			tmp = "file"+i+".txt";
			if(!isCloudDocsFileExists(tmp))
				return false;
		}
		return true;
	}
	/**
	 * copy 31 Uploaded File CloudDocs
	 */
	public void copy31UploadedFileCloudDocs(){
		waitForControl(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE, timeWait);
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "file1.txt")){
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightClick(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "file1.txt");
		waitForControl(driver, Interfaces.PatientsPage.COPY_CLOUD_DOCS_FILE_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.COPY_CLOUD_DOCS_FILE_LINK);
		sleep();
		}
	}
	/**
	 * paste Cloud Docs
	 */
	public void paste31FileCloudDocs(){
		waitForControl(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE, timeWait);
		rightClick(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE);
		waitForControl(driver, Interfaces.PatientsPage.PASTE_CLOUD_DOCS_FILE_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PASTE_CLOUD_DOCS_FILE_LINK);
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "file1.txt", timeWait);
		sleep();
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON))
			click(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON);
	}
	/**
	 * delete 31 File Cloud Docs
	 */
	public void delete31FileCloudDocs(){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,"file1.txt", timeWait);
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,"file1.txt")){
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightClick(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "file1.txt");
		waitForControl(driver, Interfaces.PatientsPage.DELETE_CLOUD_DOCS_FILE_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.DELETE_CLOUD_DOCS_FILE_LINK);
		waitForControl(driver, Interfaces.PatientsPage.APPROVE_REMOVE_CLOUD_DOCS_FILE, timeWait);
		click(driver, Interfaces.PatientsPage.APPROVE_REMOVE_CLOUD_DOCS_FILE);
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "file1.txt", timeWait);
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON))
			click(driver, Interfaces.PatientsPage.CLOSE_ERROR_CLOUD_DOCS_BUTTON);
		sleep();
		}
	}
	/**
	 * duplicate 31 Cloud Docs File
	 */
	public void duplicate31CloudDocsFile(){
		waitForControl(driver, Interfaces.PatientsPage.FOLDER_CLOUD_DOCS_CONTENT_SPACE, timeWait);
		if(isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC, "file1.txt")){
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rightClick(driver,
					Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,
					"file1.txt");
			waitForControl(driver,
					Interfaces.PatientsPage.DUPLICATE_CLOUD_DOCS_FILE_LINK,
					timeWait);
			click(driver,
					Interfaces.PatientsPage.DUPLICATE_CLOUD_DOCS_FILE_LINK);
			waitForControl(driver,Interfaces.PatientsPage.CLOUD_DOCS_FILE_LINK_DYNAMIC,"file1 copy.txt", timeWait);
			sleep();
		}
	}
	
	/**
	 * check Cloud Docs duplicate 31 File Success
	 * @return
	 */
	public boolean isCloudDocsUpload31DulicateFileSuccess(){
		String tmp = "";
		for(int i = 1; i<=31;i++){
			tmp = "file"+i+" copy.txt";
			if(!isCloudDocsFileExists(tmp))
				return false;
		}
		return true;
	}
	/**
	 * check Section Link Has Under line
	 * @param section
	 * @return
	 */
	public boolean isSectionLinkHasUnderline(String section){
		String tmp = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_SECTION_LINK, section, "class");
		if(tmp.equals("on"))
			return true;
		else
			return false;
	}
	/**
	 * check Add New Patient Link Displays
	 * @return
	 */
	public boolean isAddNewPatientLinkDisplays(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.ADD_NEW_PATIENT_LINK);
	}
	
	/**
	 * 
	 * @param patient
	 * @return
	 */
	public boolean isContactInformationDetailsDisplays(String patient){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CONTACT_INFORMATION, patient, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_CONTACT_INFORMATION, patient);
	}
	/**
	 * add New Patient
	 */
	public void addNewPatient(String firstName, String lastName, String phone){
		waitForControl(driver, Interfaces.PatientsPage.ADD_NEW_PATIENT_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.ADD_NEW_PATIENT_LINK);
		
		waitForControl(driver,Interfaces.PatientsPage.PATIENT_CREATE_LASTNAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_CREATE_LASTNAME_TEXTBOX, lastName);
		
		type(driver, Interfaces.PatientsPage.PATIENT_CREATE_HOMEPHONE_TEXTBOX, phone);
		
		click(driver, Interfaces.PatientsPage.NEXT_BUTTON);
		
		waitForControlNotDisplayed(driver, Interfaces.PatientsPage.NEXT_BUTTON, timeWait);
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CREATE_FIRSTNAME_TEXTBOX, timeWait);
		
		type(driver, Interfaces.PatientsPage.PATIENT_CREATE_FIRSTNAME_TEXTBOX, firstName);
		
		click(driver, Interfaces.PatientsPage.SAVE_BUTTON);
		
	}
	/**
	 * select Check Box Patient Details
	 * @param info
	 */
	public void selectCheckBoxPatientDetails(String info){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INFO_CHECKBOX,info, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INFO_CHECKBOX,info);
	}
	/**
	 * check Chart Note Expand
	 * @return
	 */
	public boolean isChartNoteExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CHARTNOTE_INFO);
	}
	/**
	 * check Companion Displays
	 * @return
	 */
	public boolean isCompanionDisplays(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_COMPANION_INFO);
	}
	
	/**
	 * check Guardian Responsible Party Displays
	 * @return
	 */
	public boolean isGuardianResponsiblePartyDisplays(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_RESPONSIBLE_INFO);
	}
	/**
	 * check Patient Recalls Expand
	 * @return
	 */
	public boolean isPatientRecallsExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_INFO);
	}
	
	/**
	 * check Clinical Notes Expand
	 * @return
	 */
	public boolean isClinicalNotesExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTES_INFO);
	}
	/**
	 * check Invoices Sales Expand
	 * @return
	 */
	public boolean isInvoicesSalesExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_INVOICES_SALES_ORDER);
	}
	/**
	 * check Eligibility Verification Expand
	 * @return
	 */
	public boolean isEligibilityVerificationExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_ELIGIBILITY_VERIFICATION_EXPAND);
	}
	/**
	 * check Equipment Expand
	 * @return
	 */
	public boolean isEquipmentExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_EQUIMENT_EXPAND);
	}
	/**
	 * check Repairs Expand
	 * @return
	 */
	public boolean isRepairsExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_REPAIR_EXPAND);	
	}
	/**
	 * check CBO Billing Notes Expand
	 * @return
	 */
	public boolean isCBOBillingNotesExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_CBO_BILLING_NOTES_EXPAND);	
	}
	/**
	 * check Associated Office Expand
	 * @return
	 */
	public boolean isAssociatedOfficeExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_ASSOCIATED_OFFICE_EXPAND);	
	}
	
	/**
	 * check Appointments Expand
	 * @return
	 */
	public boolean isAppointmentsExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_APPOINTMENTS_EXPAND);	
	}
	
	/**
	 * check Patient Details Menu Bar Correct
	 * @return
	 */
	public boolean isPatientDetailsMenuBarCorrect(){
		int n = countElement(driver, Interfaces.PatientsPage.LIST_MENU_BAR_ITEMS);
		if(n/2 == 9)
			return true;
		else 
			return false;
	}
	/**
	 * check Hearing Aids Expand
	 * @return
	 */
	public boolean isHearingAidsExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_HEARING_AIDS_EXPAND);	
	}
	/**
	 * check Insurance Expand
	 * @return
	 */
	public boolean isInsuranceExpand(){
		return isControlDisplayed(driver, Interfaces.PatientsPage.TABLE_INSURANCE_EXPAND);	
	}
	/**
	 * check Appointment Tab Selected
	 * @param tab
	 * @return
	 */
	public boolean isAppointmentTabSelected(String tab){
		waitForControl(driver, Interfaces.PatientsPage.APPOINTMENT_CURRENT_TAB, timeWait);
		String tmp = getText(driver, Interfaces.PatientsPage.APPOINTMENT_CURRENT_TAB);
		if(tmp.equals(tab))
			return true;
		else
			return false;
	}
	/**
	 * check Appointment Tabs Exists
	 * @return
	 */
	public boolean isAppointmentTabsExists(){
		int n = countElement(driver, Interfaces.PatientsPage.LIST_TAB_ACTIONS_APPOINTMENT);
		if(n==3)
			return true;
		else
			return false;
	}
	/**
	 * input Value To Patient Preferred Name Field
	 * @param name
	 */
	public void inputValueToPatientPreferredNameField(String name){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_PREFERRED_NAME_TEXTBOX, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_PREFERRED_NAME_TEXTBOX);
		type(driver, Interfaces.PatientsPage.PATIENT_PREFERRED_NAME_TEXTBOX, name);
	}
	/**
	 * check Patient Preferred Name Correct
	 * @param name
	 * @return
	 */
	public boolean isPatientPreferredNameCorrect(String name){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_PREFERRED_NAME_TEXTBOX, timeWait);
		String tmp = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_PREFERRED_NAME_TEXTBOX, "value");
		if(tmp.equals(name))
			return true;
		else
			return false;
	}
	/**
	 * open Appointment Tab
	 */
	public void openAppointmentTab(String tab){
		waitForControl(driver, Interfaces.PatientsPage.TAB_ACTIONS_APPOINTMENT,tab, timeWait);
		click(driver, Interfaces.PatientsPage.TAB_ACTIONS_APPOINTMENT,tab);
		sleep();
	}
	/**
	 * check Sales Opportunity Check
	 * @return
	 */
	public boolean isSalesOpportunityCheck(){
		waitForControl(driver, Interfaces.PatientsPage.SALES_OPPORTUNITY_CHECKBOX, timeWait);
		String tmp = getAttributeValue(driver, Interfaces.PatientsPage.SALES_OPPORTUNITY_CHECKBOX, "checked");
		if(tmp.equals("true"))
			return true;
		else
			return false;
	}
	/**
	 * enter Earning Loss
	 * @param area
	 * @param level
	 * @param type
	 */
	public void enterEarningLoss(boolean leftArea, String level, String type,String shape){
		waitForControl(driver, Interfaces.PatientsPage.LEFT_LOSS_LEVEL_COMBOBOX, timeWait);
		if(leftArea){
			selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_LOSS_LEVEL_COMBOBOX, level);
			selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_LOSS_TYPE_COMBOBOX, type);
			selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_LOSS_SHAPE_COMBOBOX, shape);
		}else
		{
			selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_LOSS_LEVEL_COMBOBOX, level);
			selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_LOSS_TYPE_COMBOBOX, type);
			selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_LOSS_SHAPE_COMBOBOX, shape);
		}
	}
	/**
	 * check Appointment Status Selected
	 * @return
	 */
	public boolean isAppointmentStatusSelected(String status){
		waitForControl(driver, Interfaces.PatientsPage.APPOINTMENT_STATUS_COMBOBOX, timeWait);
		String tmp = getItemSelectedCombobox(driver, Interfaces.PatientsPage.APPOINTMENT_STATUS_COMBOBOX);
		if(tmp.equals(status))
			return true;
		else
			return false;
	}
	/**
	 * click On Back Button
	 * @return
	 */
	public void clickOnBackButton(){
		waitForControl(driver, Interfaces.PatientsPage.BACK_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.BACK_BUTTON);
	}
	
	/**
	 * click New Invoice Sales Orders
	 */
	public SalesPage clickAddNewInvoiceSalesOrders(){
		waitForControl(driver, Interfaces.PatientsPage.ADD_NEW_INVOICE_SALES_ORDER, timeWait);
		click(driver, Interfaces.PatientsPage.ADD_NEW_INVOICE_SALES_ORDER);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * check Current Balance Label Displays Correct
	 * @return
	 */
	public boolean isCurrentBalanceLabelDisplaysCorrect(String balancePrices){
		waitForControl(driver, Interfaces.PatientsPage.CHECK_IN_TAB_TITLE, timeWait);
		String tmp = getText(driver, Interfaces.PatientsPage.CHECK_IN_TAB_TITLE);
		
		String arr[] = tmp.split(": ");
		tmp = arr[1].substring(1, arr[1].length());
		String arr2[] = tmp.split(",");
		tmp = arr2[0]+arr2[1];
		
//		arr2 = balancePrices.split(",");
//		balancePrices = arr2[0]+arr2[1];
		
		double dbtmp = Double.parseDouble(tmp);
		double dbBalance = Double.parseDouble(balancePrices);
		if(dbtmp >=  dbBalance)
			return true;
		return false;
	}
	/**
	 * click On Sales Tab
	 * @return
	 */
	public SalesPage clickOnSalesTab(){
		waitForControl(driver, Interfaces.PatientsPage.SALES_ORDER_TAB_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.SALES_ORDER_TAB_LINK);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * enter Hearing Purchase Date
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterHearingPurchaseDate(int month, int day, int year){
		waitForControl(driver, Interfaces.PatientsPage.PURCHASE_DATE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PURCHASE_DATE_TEXTBOX, month+"/"+day+"/"+year);
	}
	/**
	 * select Status Hearing Aid
	 * @param status
	 */
	public void selectStatusHearingAid(String status){
		waitForControl(driver, Interfaces.PatientsPage.STATUS_HEARING_AID_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.PatientsPage.STATUS_HEARING_AID_COMBOBOX, status);
	}
	/**
	 * select Manufacturer Hearing Aid
	 * @param manu
	 */
	public void selectManufacturerHearingAid(String manu){
		waitForControl(driver, Interfaces.PatientsPage.MANUFACTURER_HEARING_AID_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.PatientsPage.MANUFACTURER_HEARING_AID_COMBOBOX, manu);
	}
	/**
	 * select Type Hearing Aid
	 */
	public void selectTypeHearingAid(String type){
		waitForControl(driver, Interfaces.PatientsPage.TYPE_HEARING_AID_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.PatientsPage.TYPE_HEARING_AID_COMBOBOX, type);
	}
	/**
	 * select Model Hearing Aid
	 * @param model
	 */
	public void selectModelHearingAid(String model){
		waitForControl(driver, Interfaces.PatientsPage.MODEL_HEARING_AID_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.PatientsPage.MODEL_HEARING_AID_COMBOBOX, model);
	}
	/**
	 * enter Type Serial Hearing Aid
	 * @param serial
	 */
	public void enterTypeSerialHearingAid(String serial){
		waitForControl(driver, Interfaces.PatientsPage.SERIAL_HEARING_AID_TEXTBOX, timeWait);
		sleep();
		type(driver, Interfaces.PatientsPage.SERIAL_HEARING_AID_TEXTBOX, serial);
	}
	/**
	 * select Battery Hearing Aid
	 * @param battery
	 */
	public void selectBatteryHearingAid(String battery){
		waitForControl(driver, Interfaces.PatientsPage.BATTERY_HEARING_AID_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.PatientsPage.BATTERY_HEARING_AID_COMBOBOX, battery);
	}
	
	/**
	 * select Technology Hearing Aid
	 * @param tech
	 */
	public void selectTechnologyHearingAid(String tech){
		waitForControl(driver, Interfaces.PatientsPage.TECHNOLOGY_HEARING_AID_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.PatientsPage.TECHNOLOGY_HEARING_AID_COMBOBOX, tech);
	}
	/**
	 * click On Save Button
	 */
	public void clickOnSaveButton(){
		waitForControl(driver, Interfaces.PatientsPage.SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SAVE_BUTTON);
	}
	/**
	 * Verify Hearing Aid Items Exists
	 * @param id
	 * @return
	 */
	public boolean isHearingAidItemsExists(String id){
		waitForControl(driver, Interfaces.PatientsPage.HEARING_AID_ITEM,id, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.HEARING_AID_ITEM,id);
	}
	/**
	 * click OK Button
	 */
	public void clickOKButton(){
		waitForControl(driver, Interfaces.PatientsPage.OK_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.OK_BUTTON);
		sleep(1);
	}
	
	/**
	 * check Ready Delivery Notice Sale Order Item Displays
	 * @param id
	 * @return
	 */
	public boolean isReadyDeliveryNoticeSaleOrderItemDisplays(String id){
		waitForControl(driver, Interfaces.PatientsPage.READY_DELIVERY_NOTICE_SALE_ORDER,id, timeWait);
		return isControlDisplayed(driver,  Interfaces.PatientsPage.READY_DELIVERY_NOTICE_SALE_ORDER, id);
	}
	/**
	 * click On Create Sales Order
	 * @return
	 */
	public SalesPage clickOnCreateSalesOrder(){
		waitForControl(driver, Interfaces.PatientsPage.CREATE_SALES_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.CREATE_SALES_ORDER_BUTTON);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * check Repairs Item Exists
	 * @param id
	 * @return
	 */
	public boolean isRepairsItemExists(String id){
		waitForControl(driver, Interfaces.PatientsPage.REPAIRS_ITEM,id, timeWait);
		return isControlDisplayed(driver,  Interfaces.PatientsPage.REPAIRS_ITEM, id);
	}
	/**
	 * check Repairs ID Item Exists
	 * @param id
	 * @return
	 */
	public boolean isRepairsIDExists(String id){
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_REPAIR_REPAIR_ORDER_ID,id, timeWait);
		return isControlDisplayed(driver,  Interfaces.PatientsPage.DYNAMIC_REPAIR_REPAIR_ORDER_ID, id);
	}
	/**
	 *  click On Loss And Damage Button
	 * @return SalesPage
	 */ 
	public SalesPage clickOnLossDamageButton(){
		waitForControl(driver, Interfaces.PatientsPage.LOSS_AND_DAMAGE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.LOSS_AND_DAMAGE_BUTTON);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * check Hearing Aid Item Status Correctly
	 * @param item
	 * @param status
	 * @return
	 */
	public boolean isHearingAidItemStatusCorrectly(String item, String status){
		waitForControl(driver, Interfaces.PatientsPage.HEARING_AID_ITEM_STATUS_LABEL,item, timeWait);
		String tmp = getText(driver, Interfaces.PatientsPage.HEARING_AID_ITEM_STATUS_LABEL, item);
		if(tmp.equals(status))
			return true;
		return false;
	}
	/**
	 * check Invoice/Sale Order Balance Correctly
	 * @param saleID
	 * @param balance
	 * @return
	 */
	public boolean isInvoiceSaleOrderBalanceCorrectly(String saleID, String balance){
		waitForControl(driver, Interfaces.PatientsPage.INVOICE_SALE_ORDER_BALANCE_LABEL,saleID, timeWait);
		String tmpBlance = getText(driver, Interfaces.PatientsPage.INVOICE_SALE_ORDER_BALANCE_LABEL,saleID);
//		String tmpAmount = getText(driver, Interfaces.PatientsPage.INVOICE_SALE_ORDER_AMOUNT_BILLED_LABEL,saleID);
		
//		double dbBlance = Common.getCommon().formatNumber(tmpBlance);
//		double dbAmount = Common.getCommon().formatNumber(tmpAmount);
		
//		if(dbAmount - dbBlance == Common.getCommon().formatNumber(balance))
		if(tmpBlance.contains(balance))
			return true;
		else
			return false;
	}
	
	/**
	 * open First Appointments Record
	 */
	public void openFirstAppointmentsRecord(){
		waitForControl(driver, Interfaces.PatientsPage.FIRST_APPOIMENTS_RECORD, timeWait);
		click(driver, Interfaces.PatientsPage.FIRST_APPOIMENTS_RECORD);
		sleep();
	}
	
	/**
	 * check Appointment Detail Page Display
	 */
	public boolean isAppointmentDetailPageDisplay(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		waitForControl(driver, Interfaces.PatientsPage.APPOITMENT_DETAIL_TITLE, timeWait);
		boolean exists = isControlDisplayed(driver, Interfaces.PatientsPage.APPOITMENT_DETAIL_TITLE);
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * click Check all Mailing Lists Link
	 */
	public void clickCheckallMailingListsLink(){
		waitForControl(driver, Interfaces.PatientsPage.CHECK_ALL_MAILING_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.CHECK_ALL_MAILING_LINK);
		sleep();
	}
	
	/**
	 * click Uncheck all Mailing Lists Link
	 */
	public void clickUncheckallMailingListsLink(){
		waitForControl(driver, Interfaces.PatientsPage.UNCHECK_ALL_MAILING_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.UNCHECK_ALL_MAILING_LINK);
		sleep();
	}
	
	/**
	 * check Birthday Checkbox Checked
	 */
	public boolean isBirthdayCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.BIRTHDAY_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.BIRTHDAY_CHECKBOX);
	}
	
	/**check Spouse Birthday Checkbox Checked
	 * 
	 */
	public boolean isSpouseBirthdayCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.SPOUSE_BIRTHDAY_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.SPOUSE_BIRTHDAY_CHECKBOX);
	}
	
	/**
	 * check Confirmation Checkbox Checked
	 */
	public boolean isConfirmationCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.CONFIRMATION_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.CONFIRMATION_CHECKBOX);
	}
	
	/**
	 * check Clean And Check Checkbox Checked
	 */
	public boolean isCleanAndCheckCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.CLEAN_AND_CHECK_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.CLEAN_AND_CHECK_CHECKBOX);
	}
	
	/**
	 * check Warranty Reminders Checkbox Checked
	 */
	public boolean isWarrantyRemindersCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.WARRANTY_REMINDERS_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.WARRANTY_REMINDERS_CHECKBOX);
	}
	
	/**
	 * check Repairs Checkbox Checked
	 */
	public boolean isRepairsCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.REPAIRS_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.REPAIRS_CHECKBOX);
	}
	
	/**
	 * check Annual Checkbox Checked
	 */
	public boolean isAnnualCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.ANNUAL_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.ANNUAL_CHECKBOX);
	}
	
	/**
	 * check Quarterly Checkbox Checked
	 */
	public boolean isQuarterlyCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.QUARTERLY_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.QUARTERLY_CHECKBOX);
	}
	
	/**
	 * check News Checkbox Checked
	 */
	public boolean isNewsCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.NEWS_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.NEWS_CHECKBOX);
	}
	
	/**
	 * check Thank You Checkbox Checked
	 */
	public boolean isThankYouCheckboxChecked(){
		waitForControl(driver, Interfaces.PatientsPage.THANK_YOU_CHECKBOX, timeWait);
		return isCheckboxChecked(driver, Interfaces.PatientsPage.THANK_YOU_CHECKBOX);
	}
	
	/**
	 * add New Tag For Appointment
	 */
	public void addNewTagForAppointment(String tagName){
		waitForControl(driver, Interfaces.PatientsPage.TAG1_CONTENT_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.TAG1_CONTENT_COMBOBOX, tagName);
		sleep(1);
		clickOnSavePatientDetailButton();
	}
	
	/**
	 * check Tag Infor Show Correctly
	 */
	public boolean isTagInforShowCorrectly(String tagName){
		waitForControl(driver, Interfaces.PatientsPage.TAG1_CONTENT_COMBOBOX, timeWait);
		String tagContent = getItemSelectedCombobox(driver, Interfaces.PatientsPage.TAG1_CONTENT_COMBOBOX);
		return tagContent.contains(tagName);
	}
	
	/**
	 * click Hold Button
	 */
	public void clickHoldButton(){
		waitForControl(driver, Interfaces.PatientsPage.HOLD_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.HOLD_BUTTON);
		sleep();
	}
	
	/**
	 * check Hold Release Button Display
	 */
	public boolean isReleaseHoldButtonDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.RELEASE_HOLD_BUTTON, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.RELEASE_HOLD_BUTTON);
	}
	
	/**
	 * check Hold Button Display
	 */
	public boolean isHoldButtonDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.HOLD_BUTTON, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.HOLD_BUTTON);
	}
	
	/**
	 * click Hold Release Button
	 */
	public void clickReleaseHoldButton(){
		waitForControl(driver, Interfaces.PatientsPage.RELEASE_HOLD_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.RELEASE_HOLD_BUTTON);
		sleep();
	}
	
	/**
	 * click Order Statement Button
	 */
	public void clickOrderStatementButton(){
		waitForControl(driver, Interfaces.PatientsPage.ORDER_STATEMENT_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.ORDER_STATEMENT_BUTTON);
		sleep();
	}
	
	/**
	 * check Order Statement Displays
	 */
	public boolean isOrderStatementDisplays(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		String url = getCurrentUrl(driver);
		boolean exists = url.contains("PatientStatement");
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * click Schedule Button
	 */
	public SchedulePage clickScheduleButton(){
		waitForControl(driver, Interfaces.PatientsPage.SCHEDULE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SCHEDULE_BUTTON);
		sleep();
		return PageFactory.getSchedulePage(driver, ipClient);
	}
	
	/**
	 * click Print Clinical Notes Button
	 */
	public void clickPrintClinicalNotesButton(){
		waitForControl(driver, Interfaces.PatientsPage.PRINT_CLINICAL_NOTE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PRINT_CLINICAL_NOTE_BUTTON);
		sleep();
	}
	
	/**
	 * check Print Clinical Notes Display
	 */
	public boolean isPrintClinicalNotesDisplay(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		waitForControl(driver, Interfaces.PatientsPage.CLINICAL_NOTE_TITLE, timeWait);
		boolean exists = isControlDisplayed(driver, Interfaces.PatientsPage.CLINICAL_NOTE_TITLE);
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * click Print Chart Notes Button
	 */
	public void clickPrintChartNotesButton(){
		waitForControl(driver, Interfaces.PatientsPage.PRINT_CHART_NOTE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PRINT_CHART_NOTE_BUTTON);
		sleep();
	}
	
	/**
	 * check Print Chart Notes Display
	 */
	public boolean isPrintChartNotesDisplay(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		waitForControl(driver, Interfaces.PatientsPage.CHART_NOTE_TITLE, timeWait);
		boolean exists = isControlDisplayed(driver, Interfaces.PatientsPage.CHART_NOTE_TITLE);
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * click Help Button
	 */
	public void clickHelpButton(){
		waitForControl(driver, Interfaces.PatientsPage.HELP_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.HELP_BUTTON);
		sleep();
	}
	
	/**
	 * check Help Page Open Successfully
	 */
	public boolean isHelpPageOpenSuccessfully(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		waitForControl(driver, Interfaces.PatientsPage.HELP_PAGE_TITLE, timeWait);
		boolean exists = isControlDisplayed(driver, Interfaces.PatientsPage.HELP_PAGE_TITLE);
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * click Print Button
	 */
	public void clickPrintButton(){
		waitForControl(driver, Interfaces.PatientsPage.PRINT_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PRINT_BUTTON);
		sleep();
	}
	
	/**
	 * check Print Page Open Successfully
	 */
	public boolean isPrintPageOpenSuccessfully(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		String url = getCurrentUrl(driver);
		boolean exists = url.contains("PatientDetailsPrint");
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * check Print Page Open Successfully
	 */
	public boolean isICD9CodesSearchPrintPageOpenSuccessfully(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		String url = getCurrentUrl(driver);
		boolean exists = url.contains("PrintSearch") && url.contains("FKICD9ForApptSearch");
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * click Email Button
	 */
	public void clickEmailButton(){
		waitForControl(driver, Interfaces.PatientsPage.EMAIL_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.EMAIL_BUTTON);
		sleep();
	}
	
	/**
	 * check Email Page Open Successfully
	 */
	public boolean isEmailPageOpenSuccessfully(){
		sleep(5);
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		waitForControl(driver, Interfaces.PatientsPage.EMAIL_CONTENT_TABLE, timeWait);
		boolean exists = isControlDisplayed(driver, Interfaces.PatientsPage.EMAIL_CONTENT_TABLE);
		driver.close();
		driver.switchTo().window(currentHandle);
		return exists;
	}
	
	/**
	 * check Cloud Docs Popup Open
	 */
	public boolean isCloudDocsPopupOpen(){
		waitForControl(driver, Interfaces.PatientsPage.CLOUD_DOCS_POPUP_TITLE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.CLOUD_DOCS_POPUP_TITLE);
	}
	
	/**
	 * close Cloud Docs Popup
	 */
	public void closeCloudDocsPopup(){
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_CLOUD_DOCS_POPUP_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.CLOSE_CLOUD_DOCS_POPUP_BUTTON);
		sleep();
	}
	
	/**
	 * click On Encounter Button
	 */
	public void clickOnEncounterButton(){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.ENCOUNTER_BUTTON);
		sleep();
	}
	
	/**
	 * input Encounter Provider
	 */
	public void inputEncounterProvider(String provider){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_PROVIDER_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.ENCOUNTER_PROVIDER_TEXTBOX, provider);
		sleep(1);
	}
	
	/**
	 * input Encounter Appointment Date
	 */
	public void inputEncounterAppointmentDate(String apptDate){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_APPT_DATE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.ENCOUNTER_APPT_DATE_TEXTBOX, apptDate);
		sleep(1);
	}
	
	/**
	 * input Encounter Office
	 */
	public void inputEncounterOffice(String office){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_OFFICE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.ENCOUNTER_OFFICE_TEXTBOX, office);
		sleep(1);
	}
	
	/**
	 * check Encounter Error Message Display
	 */
	public boolean isEncounterErrorMessageDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_ERROR_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.ENCOUNTER_ERROR_MESSAGE);
	}
	
	/**
	 * check Encounter Provider Textbox Display
	 */
	public boolean isEncounterProviderTextboxDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_PROVIDER_TEXTBOX, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.ENCOUNTER_PROVIDER_TEXTBOX);
	}
	
	/**
	 * check Encounter Appointment Date Textbox Display
	 */
	public boolean isEncounterAppointmentDateTextboxDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_APPT_DATE_TEXTBOX, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.ENCOUNTER_APPT_DATE_TEXTBOX);
	}
	
	/**
	 * check Encounter Office Textbox Display
	 */
	public boolean isEncounterOfficeTextboxDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.ENCOUNTER_OFFICE_TEXTBOX, 5);
		return isControlDisplayed(driver, Interfaces.PatientsPage.ENCOUNTER_OFFICE_TEXTBOX);
	}
	
	/**
	 * select Left Ear Loss Level
	 */
	public void selectLeftEarLossLevel(String leftlevel){
		waitForControl(driver, Interfaces.PatientsPage.LEFT_EAR_LOSS_LEVEL_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.LEFT_EAR_LOSS_LEVEL_COMBOBOX, leftlevel);
		sleep(1);
	}
	
	/**
	 * select Right Ear Loss Level
	 */
	public void selectLRightEarLossLevel(String rightlevel){
		waitForControl(driver, Interfaces.PatientsPage.RIGHT_EAR_LOSS_LEVEL_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.RIGHT_EAR_LOSS_LEVEL_COMBOBOX, rightlevel);
		sleep(1);
	}
	
	/**
	 * click On Search Diagnoses Icon
	 */
	public void clickOnSearchDiagnosesIcon(){
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_DIAGNOSES_ICON, timeWait);
		click(driver, Interfaces.PatientsPage.SEARCH_DIAGNOSES_ICON);
		sleep();
	}
	
	/**
	 * input ICD9 Codes Search
	 */
	public void inputICD9CodesSearch(String code, String description, String rank, String apptType){
		waitForControl(driver, Interfaces.PatientsPage.ICD9CODES_SEARCH_CODE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.ICD9CODES_SEARCH_CODE_TEXTBOX, code);
		sleep(1);
		type(driver, Interfaces.PatientsPage.ICD9CODES_SEARCH_DESCRIPTION_TEXTBOX, description);
		sleep(1);
		type(driver, Interfaces.PatientsPage.ICD9CODES_SEARCH_RANK_TEXTBOX, rank);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.PatientsPage.ICD9CODES_SEARCH_APPT_TYPE_COMBOBOX, apptType);
		sleep(1);
	}
	
	/**
	 * click On Search ICD9 Codes
	 */
	public void clickOnSearchICD9Codes(){
		waitForControl(driver, Interfaces.PatientsPage.SEARCH_ICD9CODES_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.SEARCH_ICD9CODES_BUTTON);
		sleep();
	}
	
	/**
	 * close ICD9 Popup
	 */
	public void closeICD9Popup(){
		waitForControl(driver, Interfaces.PatientsPage.CLOSE_ICD9CODES_POPUP_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.CLOSE_ICD9CODES_POPUP_BUTTON);
		sleep();
	}
	
	/**
	 * check Number Of ICD9 Code Item Display
	 */
	public boolean isNumberOfICD9CodeItemDisplay(int number){
		waitForControl(driver, Interfaces.PatientsPage.ICD9CODES_ITEM, timeWait);
		int items = countElement(driver, Interfaces.PatientsPage.ICD9CODES_ITEM);
		return number==items;
	}
	
	/**
	 * check No ICD9 Codes Found Message Display
	 */
	public boolean isNoICD9CodesFoundMessageDisplay(){
		waitForControl(driver, Interfaces.PatientsPage.NO_ICD9CODES_FOUND_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.NO_ICD9CODES_FOUND_MESSAGE);
	}
	
	/**
	 * check ICD9 Codes Item Display With Code
	 */
	public boolean isICD9CodesItemDisplayWithCode(String code){
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CODE_OF_ALL_ICD9CODES_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CODE_OF_ALL_ICD9CODES_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CODE_OF_ALL_ICD9CODES_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(code)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check ICD9 Codes Item Display With Description
	 */
	public boolean isICD9CodesItemDisplayWithDescription(String description){
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.DESCRIPTION_OF_ALL_ICD9CODES_ITEM, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.DESCRIPTION_OF_ALL_ICD9CODES_ITEM);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.DESCRIPTION_OF_ALL_ICD9CODES_ITEM);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(description)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * check ICD9 Codes Item Display With Correct Information
	 */
	public boolean isICD9CodesItemDisplayWithCorrectInformation(String code, String description, String rank){
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_ICD9CODES_ITEM, code, description, rank, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_ICD9CODES_ITEM, code, description, rank);
	}
	
	/**
	 * Switch driver to iFrame
	 * @return driver
	 */
	public WebDriver switchToICD9CodesSearchFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_FRAME, timeWait);
		sleep(3);
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.PatientsPage.ICD9_CODES_SEARCH_FRAME)));
		return driver;
	}
	
	/**
	 * click ICD9 Codes Search CSV Button
	 */
	public void clickICD9CodesSearchCSVButton(){
		waitForControl(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_CSV_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_CSV_BUTTON);
		sleep();
	}
	
	/**
	 * click ICD9 Codes Search Help Button
	 */
	public void clickICD9CodesSearchHelpButton(){
		waitForControl(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_HELP_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_HELP_BUTTON);
		sleep();
	}
	
	/**
	 * click ICD9 Codes Search Print Button
	 */
	public void clickICD9CodesSearchPrintButton(){
		waitForControl(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_PRINT_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_PRINT_BUTTON);
		sleep();
	}
	
	/**
	 * click ICD9 Codes Search Email Button
	 */
	public void clickICD9CodesSearchEmailButton(){
		waitForControl(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_EMAIL_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.ICD9_CODES_SEARCH_EMAIL_BUTTON);
		sleep();
	}
	/**
	 * Click Patient Record Help icon
	 */
	public void clickPatientRecordHelpIcon()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_HELP_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_RECORDS_HELP_BUTTON);
		sleep();
	}
	/**
	 * Click Patient Record Email icon
	 */
	public void clickPatientRecordEmailIcon()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_EMAIL_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_RECORDS_EMAIL_BUTTON);
		sleep();
	}
	/**
	 * Click Patient Record Print icon
	 */
	public void clickPatientRecordPrintIcon()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PRINT_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PRINT_BUTTON);
		sleep();
	}
	/**
	 * Click Patient Record Search button
	 */
	public void clickPatientRecordSearchButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_SEARCH_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_RECORDS_SEARCH_BUTTON);
		sleep();
	}
	/**
	 * Get new window title
	 * @return
	 */
	public String getNewWindowTitle()
	{
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		driver.switchTo().window((String)windows.toArray()[1]);
		String title = driver.getTitle();
		driver.close();
		driver.switchTo().window(parent);
		return title;
	}
	/**
	 * get Number Of Item In List Of Patients
	 */
	public int getNumberOfItemInListOfPatients() {
		int numberOfItem=0;
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_ALL_ITEMS_OF_PATIENTS, timeWait);
		numberOfItem = countElement(driver, Interfaces.PatientsPage.PATIENT_RECORDS_ALL_ITEMS_OF_PATIENTS);
		return numberOfItem;
	}
	/**
	 * check List Of Patients Show With Name
	 */
	public boolean isListOfPatientsShowWithPatientName(String name) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_NAME_OF_LIST_PATIENTS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PATIENT_RECORDS_NAME_OF_LIST_PATIENTS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PATIENT_RECORDS_NAME_OF_LIST_PATIENTS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(name.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Patients Show With Account Number
	 */
	public boolean isListOfPatientsShowWithAccountNumber(String accountNumber) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_ACCOUNT_NUMBER_OF_LIST_PATIENTS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PATIENT_RECORDS_ACCOUNT_NUMBER_OF_LIST_PATIENTS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PATIENT_RECORDS_ACCOUNT_NUMBER_OF_LIST_PATIENTS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(accountNumber)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Patients Show With Office
	 */
	public boolean isListOfPatientsShowWithOffice(String office) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_OFFICE_OF_LIST_PATIENTS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PATIENT_RECORDS_OFFICE_OF_LIST_PATIENTS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PATIENT_RECORDS_OFFICE_OF_LIST_PATIENTS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(office)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Patients Show With Patient Type
	 */
	public boolean isListOfPatientsShowWithPatientType(String patientType) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PATIENT_TYPE_OF_LIST_PATIENTS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PATIENT_TYPE_OF_LIST_PATIENTS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PATIENT_TYPE_OF_LIST_PATIENTS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(patientType)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Patients Show With Phone Number
	 */
	public boolean isListOfPatientsShowWithPhoneNumber(String phoneNumber) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PHONE_NUMBER_OF_LIST_PATIENTS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PHONE_NUMBER_OF_LIST_PATIENTS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PHONE_NUMBER_OF_LIST_PATIENTS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.contains(phoneNumber)){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * Click a patient record link
	 * @param index
	 */
	public void clickPatientRecordLink(String index)
	{
		sleep(5);
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_RECORDS_GO_TO_RECORD_LINK,index,timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_RECORDS_GO_TO_RECORD_LINK,index);
		sleep();
	}
	/**
	 * Input Patient Record Last Name
	 * @param lastName
	 */
	public void inputPatientRecordLastName(String lastName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_LAST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_RECORDS_LAST_NAME_TEXTBOX, lastName);
		sleep();
	}
	/**
	 * Input Patient Record First Name
	 * @param firstName
	 */
	public void inputPatientRecordFirstName(String firstName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_FIRST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_RECORDS_FIRST_NAME_TEXTBOX, firstName);
		sleep();
	}
	/**
	 * Input Patient Record Account Number
	 * @param accountNumber
	 */
	public void inputPatientRecordAccountNumber(String accountNumber)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_ACCOUNT_NUMBER_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_RECORDS_ACCOUNT_NUMBER_TEXTBOX, accountNumber);
		sleep();
	}
	/**
	 * Select Patient Record Office
	 * @param office
	 */
	public void selectPatientRecordDefaultOffice(String office)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_OFFICE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_RECORDS_OFFICE_COMBOBOX, office);
		sleep();
	}
	/**
	 * Select Patient Record Current Provider
	 * @param provider
	 */
	public void selectPatientRecordCurrentProvider(String provider)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_CURRENT_PROVIDER_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_RECORDS_CURRENT_PROVIDER_COMBOBOX, provider);
		sleep();
	}
	/**
	 * Select Patient Record Patient Type
	 * @param patientType
	 */
	public void selectPatientRecordPatientType(String patientType)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PATIENT_TYPE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PATIENT_TYPE_COMBOBOX, patientType);
		sleep();
	}
	/**
	 * Input Patient Record Phone Number
	 * @param phoneNumber
	 */
	public void inputPatientRecordPhoneNumber(String phoneNumber)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PHONE_NUMBER_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_RECORDS_PHONE_NUMBER_TEXTBOX, phoneNumber);
		sleep();
	}
	/**
	 * Select Patient Record Include Archived
	 * @param includeArchive
	 */
	public void selectPatientRecordIncludeArchived(String includeArchive)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_INCLUDE_ARCHIVED_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_RECORDS_INCLUDE_ARCHIVED_COMBOBOX, includeArchive);
		sleep();
	}
	/**
	 * Check search displays with message
	 * @param message
	 * @return
	 */
	public boolean isSearchMessageDisplays(String message)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_RECORDS_SEARCH_MESSAGE, message,timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_RECORDS_SEARCH_MESSAGE, message);
	}
	/**
	 * Check patient detail last name displays with text
	 * @param text
	 * @return
	 */
	public boolean isPatientDetailLastNameDisplaysWithText(String text)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_LAST_NAME_TEXTBOX, timeWait);
		return getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_LAST_NAME_TEXTBOX, "value").contains(text);
	}
	/**
	 * Check patient detail first name displays with text
	 * @param text
	 * @return
	 */
	public boolean isPatientDetailFirstNameDisplaysWithText(String text)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_FIRST_NAME_TEXTBOX, timeWait);
		return getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_FIRST_NAME_TEXTBOX, "value").contains(text);
	}
	/**
	 * Check patient detail account number displays with text
	 * @param text
	 * @return
	 */
	public boolean isPatientDetailAccountNumberDisplaysWithText(String text)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_ACCOUNT_NUMBER_TEXTBOX, timeWait);
		return getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_ACCOUNT_NUMBER_TEXTBOX, "value").contains(text);
	}
	/**
	 * Check patient detail home phone displays with text
	 * @param text
	 * @return
	 */
	public boolean isPatientDetailHomePhoneDisplaysWithText(String text)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_HOME_PHONE_TEXTBOX, timeWait);
		return getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_HOME_PHONE_TEXTBOX, "value").contains(text);
	}
	/**
	 * Check patient detail patient type displays with text
	 * @param text
	 * @return
	 */
	public boolean isPatientDetailPatientTypeDisplaysWithText(String text)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_TYPE_COMBOBOX, timeWait);
		return getItemSelectedCombobox(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_TYPE_COMBOBOX).contains(text);
	}
	/**
	 * Close new windows
	 */
	public void closeNewWindows()
	{
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		driver.close();
		driver.switchTo().window(currentHandle);
	}
	/**
	 * Click new patient button
	 */
	public void clickNewPatientButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_RECORDS_NEW_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_RECORDS_NEW_BUTTON);
	}
	/**
	 * Click new patient next to step 2 button
	 */
	public void clickNewPatientNextToStep2Button()
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_NEXT_TO_STEP2_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.NEW_PATIENT_NEXT_TO_STEP2_BUTTON);
		sleep(5);
	} 
	/**
	 * Input new patient last name
	 * @param lastName
	 */
	public void inputNewPatientLastName(String lastName)
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_LAST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.NEW_PATIENT_LAST_NAME_TEXTBOX,lastName);
	}
	/**
	 * Input new patient home phone
	 * @param homePhone
	 */
	public void inputNewPatientHomePhone(String homePhone)
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_HOME_PHONE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.NEW_PATIENT_HOME_PHONE_TEXTBOX,homePhone);
	}
	/**
	 * Input new patient date of birth
	 * @param dob
	 */
	public void inputNewPatientDOB(String dob)
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_DATE_OF_BIRTH_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.NEW_PATIENT_DATE_OF_BIRTH_TEXTBOX,dob);
	}
	/**
	 * Input new patient zip code
	 * @param zip
	 */
	public void inputNewPatientZIP(String zip)
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_ZIP_CODE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.NEW_PATIENT_ZIP_CODE_TEXTBOX,zip);
	}
	/**
	 * Input new patient SSN
	 * @param SSN
	 */
	public void inputNewPatientSSN(String ssn)
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_SSN_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.NEW_PATIENT_SSN_TEXTBOX,ssn);
	}
	/**
	 * Check new patient error message displays with content
	 * @param content
	 * @return
	 */
	public boolean isNewPatientErrorMessageDisplaysWithCotent(String content)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_NEW_PATIENT_ERROR_DIV,content, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_NEW_PATIENT_ERROR_DIV,content);
	}
	/**
	 * Check new patient home phone error displays
	 * @return
	 */
	public boolean isNewPatientHomePhoneErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_HOME_PHONE_ERROR_DIV,timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.NEW_PATIENT_HOME_PHONE_ERROR_DIV);
	}
	/**
	 * Check new patient ZIP error displays
	 * @return
	 */
	public boolean isNewPatientZIPErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_ZIP_ERROR_DIV,timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.NEW_PATIENT_ZIP_ERROR_DIV);
	}
	/**
	 * Check new patient SSN error displays
	 * @return
	 */
	public boolean isNewPatientSSNErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.NEW_PATIENT_SSN_ERROR_DIV,timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.NEW_PATIENT_SSN_ERROR_DIV);
	}
	/**
	 * Check patient detail page displays
	 * @return
	 */
	public boolean isPatientDetailPageDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_TITLE_DIV,timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_TITLE_DIV);
	}
	/**
	 * Input patient detail first name
	 * @param firstName
	 */
	public void inputPatientDetailFirstName(String firstName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_FIRST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_FIRST_NAME_TEXTBOX, firstName);
	}
	/**
	 * Click patient details save button
	 */
	public void clickPatientDetailSaveButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_SAVE_BUTTON);
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_SAVE_BUTTON, timeWait);
		sleep(5);
	}
	/**
	 * Check patient details first name error displays with text
	 * @param content
	 * @return
	 */
	public boolean isPatientDetailFirstNameErrorDisplaysWithText()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_FIRST_NAME_ERROR_DIV,timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_FIRST_NAME_ERROR_DIV);
	}
	/**
	 * Check patient details record saved
	 * @return
	 */
	public boolean isPatientDetailRecordSaved()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_RECORD_SAVED_SPAN, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_RECORD_SAVED_SPAN);
	}
	/**
	 * Input patient details ssn
	 * @param ssn
	 */
	public void inputPatientDetailSSN(String ssn)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_SSN_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_SSN_TEXTBOX, ssn);
	}
	/**
	 * Input patient details email1
	 * @param email1
	 */
	public void inputPatientDetailEmail1(String email1)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL1_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL1_TEXTBOX, email1);
	}
	/**
	 * Check patient details email1 error displays
	 * @return
	 */
	public boolean isPatientDetailEmail1ErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL1_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL1_ERROR_DIV);
	}
	/**
	 * Input patient details email2
	 * @param email2
	 */
	public void inputPatientDetailEmail2(String email2)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL2_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL2_TEXTBOX, email2);
	}
	/**
	 * Check patient details email2 error displays
	 * @return
	 */
	public boolean isPatientDetailEmail2ErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL2_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EMAIL2_ERROR_DIV);
	}
	/**
	 * Input patient details mobile phone
	 * @param mobilePhone
	 */
	public void inputPatientDetailMobilePhone(String mobilePhone)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_MOBILE_PHONE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_MOBILE_PHONE_TEXTBOX, mobilePhone);
	}
	/**
	 * Check patient details mobile phone error displays
	 * @return
	 */
	public boolean isPatientDetailMobilePhoneErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_MOBILE_PHONE_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_MOBILE_PHONE_ERROR_DIV);
	}
	/**
	 * Input patient details work phone
	 * @param workPhone
	 */
	public void inputPatientDetailWorkPhone(String workPhone)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_WORK_PHONE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_WORK_PHONE_TEXTBOX, workPhone);
	}
	/**
	 * Check patient details work phone error displays
	 * @return
	 */
	public boolean isPatientDetailWorkPhoneErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_WORK_PHONE_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_WORK_PHONE_ERROR_DIV);
	}
	/**
	 * Input patient details guardian phone
	 * @param guardianPhone
	 */
	public void inputPatientDetailGuardianPhone(String guardianPhone)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_PHONE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_PHONE_TEXTBOX, guardianPhone);
	}
	/**
	 * Check patient details guardian phone error displays
	 * @return
	 */
	public boolean isPatientDetailGuardianPhoneErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_PHONE_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_PHONE_ERROR_DIV);
	}
	/**
	 * Input patient details guardian zip
	 * @param guardianZIP
	 */
	public void inputPatientDetailGuardianZIP(String guardianZIP)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_ZIP_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_ZIP_TEXTBOX, guardianZIP);
	}
	/**
	 * Check patient details guardian zip error displays
	 * @return
	 */
	public boolean isPatientDetailGuardianZIPErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_ZIP_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_GUARDIAN_ZIP_ERROR_DIV);
	}
	/**
	 * Select patient type
	 * @param type
	 */
	public void selectPatientDetailType(String type)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_TYPE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_TYPE_COMBOBOX, type);
	}
	/**
	 * Input patient detail last name
	 * @param lastName
	 */
	public void inputPatientDetailLastName(String lastName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_LAST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_LAST_NAME_TEXTBOX, lastName);
	}
	/**
	 * Expand patient detail patient recall section
	 */
	public void expandPatientDetailPatientRecall()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_EXCOL_LINK);
		}
	}
	/**
	 * Click patient detail patient recall new link
	 */
	public void clickPatientDetailPatientRecallNewLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_NEW_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_NEW_LINK);
	}
	/**
	 * Click a patient detail patient recall detail link
	 * @param index
	 */
	public void clickPatientDetailsPatientRecallLink(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_PATIENT_RECALL_DETAIL_LINK,index,timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_PATIENT_RECALL_DETAIL_LINK,index);
		sleep();
	}
	/**
	 * Input patient details patient recall date
	 * @param date
	 */
	public void inputPatientDetailsPatientRecallDate(String date)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_DATE_TEXTBOX, timeWait);
		sleep();
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_DATE_TEXTBOX, date);
	}
	/**
	 * Input patient details patient recall note
	 * @param note
	 */
	public void inputPatientDetailsPatientRecallNote(String note)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_NOTE_TEXTBOX, timeWait);
		sleep();
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_NOTE_TEXTBOX, note);
	}
	/*
	 * Click patient details patient recall save link
	 */
	public void clickPatientDetailsPatientRecallSaveLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_SAVE_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_SAVE_BUTTON);
	}
	/**
	 * Check patient detail patient recall saved
	 * @return
	 */
	public boolean isPatientDetailsPatientRecallSaved()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_SAVED_MESSAGE_SPAN, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_SAVED_MESSAGE_SPAN);
	}
	/**
	 * Check patient detail patient recall title displays
	 * @return
	 */
	public boolean isPatientDetailsPatientRecallTitleDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_TITLE_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_TITLE_DIV);
	}
	/**
	 * Click patient detail patient recall back button
	 */
	public void clickPatientDetailPatientRecallBackButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_BACK_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_BACK_BUTTON);
	}
	/**
	 * Return patient recall note contains value based on index
	 * @param index
	 * @param value
	 * @return
	 */
	public boolean isPatientDetailsPatientRecallNoteContains(String index, String value)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_PATIENT_RECALL_NOTE_SPAN,index,value, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_PATIENT_RECALL_NOTE_SPAN,index,value);
	}
	/**
	 * select patient details patient recall completed check box
	 */
	public void selectPatientDetailPatientRecallCompletedCheckbox(boolean checked) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_COMPLETED_CHECKBOX, timeWait);
		String checkedValue = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_COMPLETED_CHECKBOX, "checked");
		if(checked){
			if(checkedValue==null){
				click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_COMPLETED_CHECKBOX);
				sleep(1);
			}
		}else{
			if(checkedValue!=null){
				click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_RECALL_COMPLETED_CHECKBOX);
				sleep(1);
			}
		}
	}
	/**
	 * Expand patient detail clinical note section
	 */
	public void expandPatientDetailClinicalNote()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_EXCOL_LINK);
		}
	}
	/**
	 * Click patient detail clinical note new link
	 */
	public void clickPatientDetailClinicalNoteNewLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_NEW_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_NEW_LINK);
	}
	/**
	 * Click a patient detail clinical note detail link
	 * @param index
	 */
	public void clickPatientDetailsClinicalNotelLink(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CLINICAL_NOTE_DETAIL_LINK,index,timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CLINICAL_NOTE_DETAIL_LINK,index);
		sleep();
	}
	/**
	 * Return clinical note note contains value based on index
	 * @param index
	 * @param value
	 * @return
	 */
	public boolean isPatientDetailsPatientClinicalNoteContains(String index, String value)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CLINICAL_NOTE_NOTE_SPAN,index,value, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CLINICAL_NOTE_NOTE_SPAN,index,value);
	}
	/**
	 * Click clinical note back button
	 */
	public void clickPatientDetailClinicalNoteBackButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_BACK_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_BACK_BUTTON);
	}
	/**
	 * Input patient details clinical note note
	 * @param note
	 */
	public void inputPatientDetailsClinicalNote(String note)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_NOTE_TEXTBOX, timeWait);
		sleep();
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_NOTE_TEXTBOX, note);
	}
	/**
	 * Click patient details clinical note save link
	 */
	public void clickPatientDetailsClinicalNoteSaveLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_SAVE_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_SAVE_BUTTON);
	}
	/**
	 * Check patient detail patient recall title displays
	 * @return
	 */
	public boolean isPatientDetailsClinicalNoteTitleDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_TITLE_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CLINICAL_NOTE_TITLE_DIV);
	}
	/**
	 * Expand patient detail invoices section
	 */
	public void expandPatientDetailsInvoices()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INVOICES_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INVOICES_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INVOICES_EXCOL_LINK);
		}
	}
	/**
	 * Click patient detail invoices new link
	 */
	public void clickPatientDetailsInvoicesNewLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INVOICES_NEW_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INVOICES_NEW_LINK);
	}
	/**
	 * Check Create Sales Order page displays
	 * @return
	 */
	public boolean isPatientDetailsCreateSalesOrderPageDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CREATE_SALES_ORDER_SELECTED_LINK, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CREATE_SALES_ORDER_SELECTED_LINK);
	}
	
	/**
	 * Expand patient detail insurance section
	 */
	public void expandPatientDetailsInsurance()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INSURANCE_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INSURANCE_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INSURANCE_EXCOL_LINK);
		}
	}
	/**
	 * Click patient detail invoices new link
	 */
	public void clickPatientDetailsInsuranceNewLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INSURANCE_NEW_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INSURANCE_NEW_LINK);
	}
	/**
	 * Switch driver to iFrame
	 * @return driver
	 */
	public WebDriver switchToCarrierFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_FRAME, timeWait);
		sleep();
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.PatientsPage.CARRIERS_FRAME)));
		return driver;
	}
	/**
	 * get Number Of Item In List Of Carriers
	 */
	public int getNumberOfItemInListOfCarriers() {
		int numberOfItem=0;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ALL_ITEMS_OF_CARRIERS, timeWait);
		numberOfItem = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ALL_ITEMS_OF_CARRIERS);
		return numberOfItem;
	}
	/**
	 * check List Of Carriers Show With Name
	 */
	public boolean isListOfCarriersShowWithName(String name) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_NAME_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_NAME_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_NAME_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(name.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With Contract Date
	 */
	public boolean isListOfCarriersShowWithContractDate(String contractDate) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_CONTRACT_DATE_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_CONTRACT_DATE_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_CONTRACT_DATE_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(contractDate.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With Address
	 */
	public boolean isListOfCarriersShowWithAddress(String address) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ADDRESS_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ADDRESS_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ADDRESS_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(address.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With City
	 */
	public boolean isListOfCarriersShowWithCity(String city) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_CITY_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_CITY_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_CITY_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(city.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With State
	 */
	public boolean isListOfCarriersShowWithState(String state) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_STATE_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_STATE_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_STATE_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!state.toUpperCase().contains(text.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With Zip
	 */
	public boolean isListOfCarriersShowWithZip(String zip) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ZIP_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ZIP_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ZIP_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(zip.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With Phone
	 */
	public boolean isListOfCarriersShowWithPhone(String phone) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_PHONE_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_PHONE_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_PHONE_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(phone.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With Fax
	 */
	public boolean isListOfCarriersShowWithFax(String fax) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_FAX_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_FAX_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_FAX_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(fax.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * check List Of Carriers Show With In Network
	 */
	public boolean isListOfCarriersShowWithInNetwork(String inNetWork) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_IN_NETWORK_OF_LIST_CARRIERS, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_IN_NETWORK_OF_LIST_CARRIERS);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_IN_NETWORK_OF_LIST_CARRIERS);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(inNetWork.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * Input Carrier Search Name
	 * @param name
	 */
	public void inputCarrierSearchName(String name)
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_NAME_TEXTBOX, name);
	}
	/**
	 * Input Carrier Search Contract Date
	 * @param contractDate
	 */
	public void inputCarrierSearchContractDate(String contractDate)
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CONTRACT_DATE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CONTRACT_DATE_TEXTBOX, contractDate);
	}
	/**
	 * Input Carrier Search City
	 * @param city
	 */
	public void inputCarrierSearchCity(String city)
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CITY_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_CITY_TEXTBOX, city);
	}
	/**
	 * Input Carrier Search Phone
	 * @param phone
	 */
	public void inputCarrierSearchPhone(String phone)
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_PHONE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_PHONE_TEXTBOX, phone);
	}
	/**
	 * Input Carrier Search Zip
	 * @param zip
	 */
	public void inputCarrierSearchZip(String zip)
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_ZIP_CODE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_ZIP_CODE_TEXTBOX, zip);
	}
	/**
	 * Input Carrier Search Fax
	 * @param fax
	 */
	public void inputCarrierSearchFax(String fax)
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_FAX_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.CARRIER_SEARCH_FAX_TEXTBOX, fax);
	}
	/**
	 * Select Carrier Search State
	 * @param state
	 */
	public void selectCarrierSearchState(String state)
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIER_SEARCH_STATE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.CARRIER_SEARCH_STATE_COMBOBOX, state);
	}
	/**
	 * Select Carrier Search In Network radio button
	 * @param label
	 */
	public void selectCarrierSearchInNetwork(String label)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_CARRIERS_SEARCH_IN_NETWORK_RADIO_BUTTON,label,timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_CARRIERS_SEARCH_IN_NETWORK_RADIO_BUTTON,label);
	}
	/**
	 * Click Carrier Search Button
	 */
	public void clickCarrierSearchButton(WebDriver driver) {

		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_SEARCH_BUTTON, timeWait);
		if (Common.getCommon().getCurrentBrowser().contains("InternetExplorerDriver")) {
			switchToTopWindowFrame(driver);
			scrollPage(driver, 100, 100);
			switchToCarrierFrame(driver);
			click(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_SEARCH_BUTTON);
			sleep();
			switchToCarrierFrame(driver);
			scrollPage(driver,0,0);
			switchToCarrierFrame(driver);
		}
		else
		{
			click(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_SEARCH_BUTTON);
			sleep();
		}

	}
	/**
	 * Click Insurance Carrier Search link
	 */
	public void clickInsuranceCarrierSearchLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INSURANCE_CARRIER_SEARCH_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_INSURANCE_CARRIER_SEARCH_LINK);
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_FRAME, timeWait);
	}
	/**
	 * Check Carrier Search No Found message displays
	 * @return
	 */
	public boolean isCarrierSearchNoFoundDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_NO_FOUND_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_NO_FOUND_DIV);
	}
	/**
	 * Check Carrier Search Zip Error displays
	 * @return
	 */
	public boolean isCarrierSearchZipErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ZIP_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.CARRIERS_SEARCH_ZIP_ERROR_DIV);
	}
	/**
	 * Expand patient detail hearing aid section
	 */
	public void expandPatientDetailsHearingAid()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_EXCOL_LINK);
		}
	}
	/**
	 * Click patient detail hearing aid new link
	 */
	public void clickPatientDetailsHearingAidNewLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_NEW_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_NEW_LINK);
	}
	/**
	 * Click patient detail hearing aid save button
	 */
	public void clickPatientDetailsHearingAidSaveButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_SAVE_BUTTON);
	}
	/**
	 * Click patient detail edit hearing aid save button
	 */
	public void clickPatientDetailsEditHearingAidSaveButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EDIT_HEARING_AID_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EDIT_HEARING_AID_SAVE_BUTTON);
	}
	/**
	 * Click patient detail hearing aid back button
	 */
	public void clickPatientDetailsHearingAidBackButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_BACK_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_BACK_BUTTON);
	}
	/**
	 * Input patient details hearing aid purchase date
	 * @param date
	 */
	public void inputPatientDetailsHearingAidPurchaseDate(String date)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_PURCHASE_DATE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_PURCHASE_DATE_TEXTBOX, date);
	}
	/**
	 * Update patient details hearing aid purchase date
	 * @param date
	 */
	public void updatePatientDetailsHearingAidPurchaseDate(String date)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_EDIT_PURCHASE_DATE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_EDIT_PURCHASE_DATE_TEXTBOX, date);
	}
	/**
	 * Select patient details hearing aid manufacturer
	 * @param manufacturer
	 */
	public void selectPatientDetailsHearingAidManufacturer(String manufacturer)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_MANUFACTURER_LEFT_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_MANUFACTURER_LEFT_COMBOBOX, manufacturer);
	}
	/**
	 * Select patient details hearing aid type
	 * @param type
	 */
	public void selectPatientDetailsHearingAidType(String type)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_TYPE_LEFT_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_TYPE_LEFT_COMBOBOX, type);
	}
	/**
	 * Select patient details hearing aid model
	 * @param model
	 */
	public void selectPatientDetailsHearingAidModel(String model)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_MODEL_LEFT_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_MODEL_LEFT_COMBOBOX, model);
	}
	/**
	 * Click patient detail hearing aid detail link
	 */
	public void clickPatientDetailsHearingAidDetaiLink(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_HEARING_AID_LINK,index, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_HEARING_AID_LINK,index);
	}
	/**
	 * Check patient detail hearing aid saved
	 * @return
	 */
	public boolean isPatientDetailsHearingAidSaved()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_SAVED_MESSAGE_SPAN, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_SAVED_MESSAGE_SPAN);
	}
	/**
	 * Check patient detail hearing aid detail page displays
	 * @return
	 */
	public boolean isPatientDetailsHearingAidDetailDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_DETAIL_TITLE_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_HEARING_AID_DETAIL_TITLE_DIV);
	}
	/**
	 * Expand patient detail equipment section
	 */
	public void expandPatientDetailsEquipment()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EQUIPMENT_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EQUIPMENT_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EQUIPMENT_EXCOL_LINK);
		}
	}
	/**
	 * Click patient detail equipment save button
	 */
	public void clickPatientDetailsEquipmentSaveButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EQUIPMENT_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_EQUIPMENT_SAVE_BUTTON);
	}
	/**
	 * check Patient Details Page Displays
	 */
	public boolean isPatientDetailsPageDisplays(){
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_TITLE_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_TITLE_DIV);
		
	}
	/**
	 * Expand patient detail CBO Billing section
	 */
	public void expandPatientDetailsCBOBilling()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EXCOL_LINK);
		}
	}
	/**
	 * check List of Note Thread show with message
	 */
	public boolean isListOfNoteThreadNoteWithMessage(String message) {
		boolean returnValue = true;
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_NOTE_THREAD_MESSAGE, timeWait);
		sleep();
		int numberofElement = countElement(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_NOTE_THREAD_MESSAGE);
		if(numberofElement==0){
			return false;
		}
		List<WebElement> elements = getElements(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_NOTE_THREAD_MESSAGE);
		for (WebElement element : elements) {
			String text = element.getText();
			if(!text.toUpperCase().contains(message.toUpperCase())){
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	/**
	 * Click patient details cbo note thread details
	 * @param index
	 */
	public void clickPatientDetailsCBONoteThreadDetail(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CBO_NOTE_THREAD_DETAIL,index, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CBO_NOTE_THREAD_DETAIL,index);
	}
	/**
	 * Swith to new windows
	 */
	public void switchToNewWindows()
	{
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
	}
	/**
	 * Input patient details CBO patient DOB
	 * @param dob
	 */
	public void inputPatientDetailCBOPatientDOB(String dob)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_PATIENT_DOB_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_PATIENT_DOB_TEXTBOX, dob);
	}
	/**
	 * Close all new windows
	 */
	public void closeAllNewWindows()
	{
		String originalHandle = driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }
		driver.switchTo().window(originalHandle);
	}
	/**
	 * Click patient details CBO Hold button
	 */
	public void clickPatientDetailsCBOHoldButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_HOLD_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_HOLD_BUTTON);
	}
	/**
	 * Click patient details CBO Save Route to CBO button
	 */
	public void clickPatientDetailsCBOSaveRouteToCBOButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_SAVE_ROUTE_TO_CBO_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_SAVE_ROUTE_TO_CBO_BUTTON);
	}
	/**
	 * Click patient details CBO List of Patient button
	 */
	public void clickPatientDetailsCBOListOfPatientButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_LIST_PATIENT_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_LIST_PATIENT_BUTTON);
	}
	/**
	 * Click patient details CBO Close Note View button
	 */
	public void clickPatientDetailsCBOCloseNoteViewButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_CLOSE_NOTE_VIEW_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_CLOSE_NOTE_VIEW_BUTTON);
	}
	/**
	 * Check patient detail CBO Release Hold button exists
	 * @return
	 */
	public boolean isPatientDetailsCBOReleaseHoldButtonExist()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_RELEASE_HOLD_BUTTON, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_RELEASE_HOLD_BUTTON);
	}
	/**
	 * Get patient detail CBO List Assigned To
	 * @param index
	 */
	public String getPatientDetailsCBOListAssignedTo(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CBO_LIST_ASSIGNED_TO_SPAN,index, timeWait);
		return getText(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CBO_LIST_ASSIGNED_TO_SPAN,index);
	}
	/**
	 * Click patient detail CBO List details link
	 * @param index
	 */
	public void clickPatientDetailsCBOListDetailsLink(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CBO_LIST_DETAILS_LINK,index, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_CBO_LIST_DETAILS_LINK,index);
	}
	/**
	 * Input patient detail CBO mobile phone
	 * @param mobilePhone
	 */
	public void inputPatientDetailsCBOMobilePhone(String mobilePhone)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_MOBILE_PHONE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_MOBILE_PHONE_TEXTBOX, mobilePhone);
	}
	/**
	 * Input patient detail CBO work phone
	 * @param workPhone
	 */
	public void inputPatientDetailsCBOWorkPhone(String workPhone)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_WORK_PHONE_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_WORK_PHONE_TEXTBOX, workPhone);
	}
	/**
	 * Input patient detail CBO email 1
	 * @param email1
	 */
	public void inputPatientDetailsCBOEmail1(String email1)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL1_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL1_TEXTBOX, email1);
	}
	/**
	 * Input patient detail CBO email 2
	 * @param email2
	 */
	public void inputPatientDetailsCBOEmail2(String email2)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL2_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL2_TEXTBOX, email2);
	}
	
	/**
	 * Check patient detail CBO mobile phone error displays
	 */
	public boolean isPatientDetailsCBOMobilePhoneErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_MOBILE_PHONE_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_MOBILE_PHONE_ERROR_DIV);
	}
	/**
	 * Check patient detail CBO work phone error displays
	 */
	public boolean isPatientDetailsCBOWorkPhoneErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_WORK_PHONE_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_WORK_PHONE_ERROR_DIV);
	}
	/**
	 * Check patient detail CBO email 1 error displays
	 */
	public boolean isPatientDetailsCBOEmail1ErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL1_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL1_ERROR_DIV);
	}
	/**
	 * Check patient detail CBO email 2 error displays
	 */
	public boolean isPatientDetailsCBOEmail2ErrorDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL2_ERROR_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CBO_EMAIL2_ERROR_DIV);
	}
	/**
	 * Expand patient detail Associated Offices section
	 */
	public void expandPatientDetailsAssociatedOffices()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_ASSOCIATED_OFFICES_EXCOL_STATUS_INPUT, timeWait);
		String status = getAttributeValue(driver, Interfaces.PatientsPage.PATIENT_DETAILS_ASSOCIATED_OFFICES_EXCOL_STATUS_INPUT, "value");
		if(status.equals("1"))
		{
			click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_ASSOCIATED_OFFICES_EXCOL_LINK);
		}
	}
	/**
	 * Get patient details repair Sales Order ID
	 * @param index
	 * @return
	 */
	public String getPatientDetailsRepairSalesOrderID(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_REPAIRS_ORDER_ID_SPAN,index, timeWait);
		return getText(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_REPAIRS_ORDER_ID_SPAN,index);
	}
	/**
	 * Click Patient Detail Repair Detail link
	 * @param index
	 */
	public void clickPatientDetailsRepairDetailLink(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_REPAIRS_REPAIR_DETAIL_LINK,index, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_DETAILS_REPAIRS_REPAIR_DETAIL_LINK,index);
	}
	/**
	 * Check patient equipment page display
	 * @return
	 */
	public boolean isPatientDetailsPatientEquipmentPageDisplays()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_EQUIPMENT_TILTE_DIV, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.PATIENT_DETAILS_PATIENT_EQUIPMENT_TILTE_DIV);
	}
	/**
	 * Click tab in Patient page
	 * @param tab
	 */
	public void clickTabInPatient(String tab)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_TAB_LINK,tab, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_TAB_LINK,tab);
	}
	
	//Appointment tab
	/**
	 * Input patient appointment patient last name
	 * @param lastName
	 */
	public void inputPatientAppointmentPatientLastName(String lastName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_APPOINTMENTS_PATIENT_LAST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_APPOINTMENTS_PATIENT_LAST_NAME_TEXTBOX, lastName);
	}
	/**
	 * Input patient appointment patient first name
	 * @param firstName
	 */
	public void inputPatientAppointmentPatientFirstName(String firstName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_APPOINTMENTS_PATIENT_FIRST_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_APPOINTMENTS_PATIENT_FIRST_NAME_TEXTBOX, firstName);
	}
	/**
	 * Input patient appointment patient preferred name
	 * @param preferredName
	 */
	public void inputPatientAppointmentPatientPreferredName(String preferredName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_APPOINTMENTS_PATIENT_PREFERRED_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_APPOINTMENTS_PATIENT_PREFERRED_NAME_TEXTBOX, preferredName);
	}
	//CaptionCall section
	
	/**
	 * Click Caption Call button
	 */
	public void clickCaptionCallButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CAPTION_CALL_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_DETAILS_CAPTION_CALL_BUTTON);
		sleep(5);
	}
	/**
	 * Click Caption Call Provider search icon
	 */
	public void clickCaptionCallProviderSearchIcon()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_PROVIDER_SEARCH_ICON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_PROVIDER_SEARCH_ICON);
		sleep(5);
	}
	/**
	 * Switch driver to Caption Provider Frame
	 * @return driver
	 */
	public WebDriver switchToCaptionCallProviderFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_PROVIDER_IFRAME, timeWait);
		sleep();
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.PatientsPage.PATIENT_CAPTION_CALL_PROVIDER_IFRAME)));
		return driver;
	}
	/**
	 * Click Caption Call Provider name link
	 * @param name
	 */
	public void selectCaptionCallProviderName(String name)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_PROVIDER_NAME_LINK, name,timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_PROVIDER_NAME_LINK, name);
		sleep(5);
	}
	/**
	 * Get text of a row in OutBound Fax table
	 * @param index
	 * @return
	 */
	public String getOutBoundFaxValue(String index)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_OUTBOUND_FAX_VALUE, index,timeWait);
		return getText(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_OUTBOUND_FAX_VALUE, index);
	}
	/**
	 * Click on Caption Call link
	 */
	public void clickOnCaptionCallLink()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_LINK, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_LINK);
	}
	/**
	 * Click on Caption Call Search button
	 */
	public void clickOnCaptionCallSearchButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_SEARCH_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_SEARCH_BUTTON);
		sleep(5);
	}
	/**
	 * Input Caption Call Patient Name
	 * @param patientName
	 */
	public void inputCaptionCallPatientName(String patientName)
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_SEARCH_PATIENT_TEXTBOX, timeWait);
		type(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_SEARCH_PATIENT_TEXTBOX, patientName);
	}
	/**
	 * 
	 * @param patientName
	 * @return
	 */
	public boolean doesCaptionCallPatientNameDisplay(String patientName)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_DETAIL_LINK,patientName, timeWait);
		return isControlDisplayed(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_DETAIL_LINK,patientName);
		
	}
	/**
	 * Click Caption Call Detail link
	 * @param patientName
	 */
	public void selectCaptionCallDetailLink(String patientName)
	{
		waitForControl(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_DETAIL_LINK,patientName, timeWait);
		click(driver, Interfaces.PatientsPage.DYNAMIC_PATIENT_CAPTION_CALL_DETAIL_LINK,patientName);
		sleep(5);
	}
	/**
	 * Get Caption Call detail Promo Code
	 * @return
	 */
	public String getCaptionCallDetailPromoCode()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_PROMO_CODE_LABEL, timeWait);
		return getText(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_PROMO_CODE_LABEL);
	}
	/**
	 * Click Caption Call detail SendForm button
	 */
	public void clickCaptionCallDetailSendFormButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_SEND_FORM_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_SEND_FORM_BUTTON);
		sleep(5);
	}
	/**
	 * Click Caption Call detail Refax button
	 */
	public void clickCaptionCallDetailRefaxButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_REFAX_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_REFAX_BUTTON);
		sleep(5);
	}
	/**
	 * Click Caption Call detail Save button
	 */
	public void clickCaptionCallDetailSaveButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_SAVE_BUTTON);
		sleep(5);
	}
	/**
	 * Click Loss And Damage button
	 */
	public void clickPatientDetailsLossAndDamageButton()
	{
		waitForControl(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.PatientsPage.PATIENT_CAPTION_CALL_DETAIL_SAVE_BUTTON);
		sleep(5);
	}
	private WebDriver driver;
	private String ipClient;
	private final Stack<String> openWindowHandles = new Stack<String>();
}