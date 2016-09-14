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

public class checkinAppt_010_Equipment extends AbstractTest{

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
		section = "Equipment";
		description = getUniqueName();
		remark = getUniqueName();
		serial = getUniqueNumber();
	}
	
	@Test(groups = { "regression" },description = "Add new Gadget: Leaving all fields blank")
	public void checkinAppt_62_EquipmentIncorrectBackSaveButton()
	{
		log.info("CheckinAppt_62 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("CheckinAppt_62 - Step 02: Create new appointment");
		schedulePage.switchToScheduleFrame(driver);
		schedulePage.createNewAppointment(date, month, year, correctHour, correctMinute, apptType, 
				apptStatus, patientFull, refResource, noteContent, correctStartTime, correctEndTime, provider);
		
		log.info("CheckinAppt_62 - Step 03: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_62 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_62 - Step 05: Expand 'Equipment' section");
		patientsPage.expandSectionOnCheckin(section);
		
		log.info("CheckinAppt_62 - Step 06: Add new Equipment Gadget");
		patientsPage.selectAddItemEquimentButton("Add Gadget");
		
		log.info("CheckinAppt_62 - Step 07: Click Save Equipment Gadget");
		patientsPage.clickSaveEquipmentGadget();
		
		log.info("VP - An error message will be displayed under the require field 'Part': Part is required");
		verifyTrue(patientsPage.isErrorMessageEquipmentGadgetRequireDisplay());
		
	}
	@Test(groups = { "regression" },description = "Add new Gadget: Input data into all fields")
	public void checkinAppt_63_EquipmentInputDataIntoAllFields()
	{
		log.info("CheckinAppt_63 - Step 01: Select status");
		patientsPage.selectHearingAidAddGadgetStatus("Current");
		
		log.info("CheckinAppt_63 - Step 02: Input Purcharse Date");
		patientsPage.inputHearingAidsAddGadgetPurcharseDate(month,date,year);
		
		log.info("CheckinAppt_63 - Step 03: Select Manufacturer");
		patientsPage.selectHearingAidsAddGadgetManufacturer("Oticon Hearing");
		
		log.info("CheckinAppt_63 - Step 03: Select Type");
		patientsPage.selectHearingAidsAddGadgetType("Streamers");
		
		log.info("CheckinAppt_63 - Step 04: Select Part");
		patientsPage.selectHearingAidsAddGadgetPart("Wireless Streamer (Streamers)");
		
		log.info("CheckinAppt_63 - Step 05: Input Description");
		patientsPage.inputHearingAidsAddGadgetDescription(description);
		
		log.info("CheckinAppt_63 - Step 06: Input Type Serial");
		patientsPage.inputHearingAidsAddGadgetTypeSerial(serial);
		
		log.info("CheckinAppt_63 - Step 07: Click Save Equipment Gadget");
		patientsPage.clickSaveEquipmentGadget();
		
		log.info("VP - New serial number(s) have been added to patient's profile");
		verifyTrue(patientsPage.isHearingAidsSaveSuccessfully());
	
	}
	@Test(groups = { "regression" },description = "Add new Gadget: Edit Patients Equipment")
	public void checkinAppt_64_EquipmentEditPatientsEquipment()
	{
		log.info("CheckinAppt_64 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_64 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_64 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_64 - Step 05: Expand 'Equipment' section");
		patientsPage.expandSectionOnCheckin(section);
		
		log.info("CheckinAppt_64 - Step 06: Click on an equipment");
		patientsPage.openDetailAnEquipment(serial);
		
		log.info("CheckinAppt_64 - Step 07: Edit Remark ");
		patientsPage.inputHearingAidsAddGadgetRemark(remark);
		
		log.info("CheckinAppt_64 - Step 08: Click Save Edit Equipment Gadget");
		patientsPage.clickSaveEditEquipmentGadget();
		
		log.info("VP - Save successfully.");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
	}
	
	@Test(groups = { "regression" },description = "Add new Ear Mold: Input data into all fieds")
	public void checkinAppt_66_EquipmentEarMoldInputDataIntoAllFields()
	{
		log.info("CheckinAppt_66 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_66 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_66 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_66 - Step 05: Expand 'Equipment' section");
		patientsPage.expandSectionOnCheckin(section);
		
		log.info("CheckinAppt_66 - Step 06: Add new Equipment Ear Mold");
		patientsPage.selectAddItemEquimentButton("Add Ear Mold");
		
		log.info("CheckinAppt_66 - Step 07: Input left purchase date");
		patientsPage.inputEarmoldLeftPurchaseDate(month,date,year);
		
		log.info("CheckinAppt_66 - Step 08: Select left Manufacturer");
		patientsPage.selectEarmoldLeftManufacturer("Oticon Hearing");
		
		log.info("CheckinAppt_66 - Step 09: Select left Model");
		patientsPage.selectEarmoldLeftModel("New Custom Mold (Hearing Aid Mold)");
		
		log.info("CheckinAppt_66 - Step 10: Input letf Description");
		patientsPage.inputEarmoldLeftDescription(description);
		
		log.info("CheckinAppt_66 - Step 11: Select right Manufacturer");
		patientsPage.selectEarmoldRightManufacturer("Oticon Hearing");
		
		log.info("CheckinAppt_66 - Step 12: Select right Model");
		patientsPage.selectEarmoldRightModel("Hearing Aid Earmold (Hearing Aid Mold)");
		
		log.info("CheckinAppt_66 - Step 13: Input right Description");
		patientsPage.inputEarmoldRightDescription(remark);
		
		log.info("CheckinAppt_66 - Step 14: Click Save button");
		patientsPage.clickSaveEquipmentEarmold();
		
		log.info("VP: Save successfully.");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
	}
	
	@Test(groups = { "regression" },description = "Add new Ear Mold: Input data into all fieds - Save & Return ")
	public void checkinAppt_67_EquipmentEarMoldInputDataIntoAllFieldsSaveReturn()
	{
		log.info("CheckinAppt_67 - Step 01: Go to Schedule page");
		schedulePage = patientsPage.gotoSchedulePage(driver, ipClient);
		schedulePage.switchToScheduleFrame(driver);
		
		log.info("CheckinAppt_67 - Step 02: Open Appointment detail");
		schedulePage.openAppointmentOnScheduleDashboard(date, month, year, apptType, patientName);
		
		log.info("CheckinAppt_67 - Step 04: Click on Checkin Appointment Data button");
		patientsPage = schedulePage.clickOnCheckinAppointmentDataButton();
		
		log.info("CheckinAppt_67 - Step 05: Expand 'Equipment' section");
		patientsPage.expandSectionOnCheckin(section);
		
		log.info("CheckinAppt_67 - Step 06: Add new Equipment Ear Mold");
		patientsPage.selectAddItemEquimentButton("Add Ear Mold");
		
		log.info("CheckinAppt_67 - Step 07: Input left purchase date");
		patientsPage.inputEarmoldLeftPurchaseDate(month,date,year);
		
		log.info("CheckinAppt_67 - Step 08: Select left Manufacturer");
		patientsPage.selectEarmoldLeftManufacturer("Oticon Hearing");
		
		log.info("CheckinAppt_67 - Step 09: Select left Model");
		patientsPage.selectEarmoldLeftModel("New Custom Mold (Hearing Aid Mold)");
		
		log.info("CheckinAppt_67 - Step 10: Input letf Description");
		patientsPage.inputEarmoldLeftDescription(description);
		
		log.info("CheckinAppt_67 - Step 11: Select right Manufacturer");
		patientsPage.selectEarmoldRightManufacturer("Oticon Hearing");
		
		log.info("CheckinAppt_67 - Step 12: Select right Model");
		patientsPage.selectEarmoldRightModel("Hearing Aid Earmold (Hearing Aid Mold)");
		
		log.info("CheckinAppt_67 - Step 13: Input right Description");
		patientsPage.inputEarmoldRightDescription(remark);
		
		log.info("CheckinAppt_67 - Step 14: Click Save & Return to Patient");
		patientsPage.clickSaveReturnEquipmentEarmold();
		
		log.info("VP:  Save & Return to Patient screen successfully.");
		verifyTrue(patientsPage.isPatientMainPageDisplays());
		
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
	private String correctStartTime, correctEndTime, noteContent, serial,description;
	private String section, remark;
}