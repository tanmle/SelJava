package patients;
import java.io.IOException;
import java.util.Set;
import java.util.Stack;

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

public class patients_011_PatientDetails_CBOBilling_AddNew extends AbstractTest{
	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port) throws IOException{
	
		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaAdminUsername = Constant.QA_ADMIN_USERNAME;
		password = Constant.PASSWORD;
		
		validPatientLastName="Udi"+getUniqueNumber();
		validHomePhone="310-454-5857";
		validZIP="90024";
		validPatientType="Competitive";
		validPatientFirstName="QATeam";
		date = Common.getCommon().getCurrentDay();
		month = Common.getCommon().getCurrentMonth();
		year = Common.getCommon().getCurrentYear();
		message = getUniqueName();
		newMessage = getUniqueName();
		patientDOB="11/11/1991";
		
		log.info("Pre-condition: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaAdminUsername, password, false);
	}
	@Test(groups = { "regression" },description = "Add New Record_Input values to all fields")
	public void patients_PatientDetails_CBOBilling_AddNew_001_InputValuesToAllFields()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 01: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		validPatientLastName="Udi"+getUniqueNumber();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 02: Click New button");
		patientsPage.clickNewPatientButton();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 03: Input valid last name");
		patientsPage.inputNewPatientLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 04: Input valid home phone");
		patientsPage.inputNewPatientHomePhone(validHomePhone);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 05: Input valid ZIP");
		patientsPage.inputNewPatientZIP(validZIP);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 06: Click Next button");
		patientsPage.clickNewPatientNextToStep2Button();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 07: Input valid first name");
		patientsPage.inputPatientDetailFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 08: Input valid patient type");
		patientsPage.selectPatientDetailType(validPatientType);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 09: Click Save button");
		patientsPage.clickPatientDetailSaveButton();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 10: Go to Patients tab");
		patientsPage = schedulePage.openPatientsPage(driver, ipClient);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 11: Input patient last name");
		patientsPage.inputPatientRecordLastName(validPatientLastName);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 12: Input patient first name");
		patientsPage.inputPatientRecordFirstName(validPatientFirstName);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 13: Click Search button");
		patientsPage.clickPatientRecordSearchButton();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 14: Open a patient");
		patientsPage.clickPatientRecordLink("1");
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 15: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 16: Click Add new CBO Billing");
		patientsPage.selectAddNewCBO();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 17: Input follow ");
		patientsPage.inputCBOFollow(month,date,year);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 18: Input new message ");
		patientsPage.inputCBONewMessage(message);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 19: Upload CBO file ");
		patientsPage.uploadCBOFile(driver);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 20: Input patient DOB");
		patientsPage.inputPatientDetailCBOPatientDOB(patientDOB);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_001 - Step 21: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP:  Save & Return to Patient screen successfully");
		verifyTrue(patientsPage.isRecordSavedSuccessfully());
		
	}
	@Test(groups = { "regression" },description = "Add New Record_AddTwoNotes")
	public void patients_PatientDetails_CBOBilling_AddNew_002_AddTwoNote()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_002 - Step 01: Input new message ");
		patientsPage.inputCBONewMessage(newMessage);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_002 - Step 02: click Save button ");
		patientsPage.clickSaveCBOBilling();
		
		log.info("VP: Note Thread displays with first note entered");
		verifyTrue(patientsPage.isListOfNoteThreadNoteWithMessage(message));
	}
	@Test(groups = { "regression" },description = "Add New Record_Message expanded view")
	public void patients_PatientDetails_CBOBilling_AddNew_003_MessageExpandedView()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_003 - Step 01: Select message in note thread");
		patientsPage.openCBOBillingNoteMessageDetails(message);		
		
		log.info("VP: Open details page successfully");
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);

		verifyTrue(patientsPage.isCBOBillingMessageDetailDisplays(message));
		driver.switchTo().window(currentHandle);
		patientsPage.closeAllNewWindows();
	}
	@Test(groups = { "regression" },description = "Add New Record_Message expanded view help")
	public void patients_PatientDetails_CBOBilling_AddNew_004_MessageExpandedViewHelp()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_004 - Step 01: Select message in note thread");
		patientsPage.openCBOBillingNoteMessageDetails(message);		
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_004 - Step 02: Click Help link");
		String currentHandle = driver.getWindowHandle();
		patientsPage.switchToNewWindows();
		patientsPage.clickOnHelpLink();
		
		log.info("VP: Help windows displays");
		verifyTrue(driver.getTitle().contains("Help Page"));
		driver.switchTo().window(currentHandle);
		patientsPage.closeAllNewWindows();
	}
	@Test(groups = { "regression" },description = "Add New Record_Message expanded view print")
	public void patients_PatientDetails_CBOBilling_AddNew_005_MessageExpandedViewPrint()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_005 - Step 01: Select message in note thread");
		patientsPage.openCBOBillingNoteMessageDetails(message);		
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_005 - Step 02: Click Print link");
		String currentHandle = driver.getWindowHandle();
		patientsPage.switchToNewWindows();
		patientsPage.clickOnPrintLink();
		
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Print page is opened");
		verifyTrue(patientsPage.isPrintPageOpened());
		driver.switchTo().window(currentHandle);
		patientsPage.closeAllNewWindows();
	}
	@Test(groups = { "regression" },description = "Add New Record_Message expanded view email")
	public void patients_PatientDetails_CBOBilling_AddNew_006_MessageExpandedViewEmail()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_006 - Step 01: Select message in note thread");
		patientsPage.openCBOBillingNoteMessageDetails(message);		
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_006 - Step 02: Click Email link");
		String currentHandle = driver.getWindowHandle();
		patientsPage.switchToNewWindows();
		patientsPage.clickOnEmailLink();
		
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: Email page is opened");
		verifyTrue(patientsPage.isEmailPageOpened());
		driver.switchTo().window(currentHandle);
		patientsPage.closeAllNewWindows();
	}
	@Test(groups = { "regression" },description = "Add New Record_Hold CBO Note")
	public void patients_PatientDetails_CBOBilling_AddNew_007_HoldCBONote()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_007 - Step 01: Click Hold button");
		patientsPage.clickPatientDetailsCBOHoldButton();
		
		log.info("VP: Hold successfully");
		verifyTrue(patientsPage.isPatientDetailsCBOReleaseHoldButtonExist());
	}
	@Test(groups = { "regression" },description = "Add New Record_Close Note View")
	public void patients_PatientDetails_CBOBilling_AddNew_008_CloseNoteView()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_008 - Step 01: Click Close Note View button");
		patientsPage.clickPatientDetailsCBOCloseNoteViewButton();
		
		log.info("VP: Patient details page displays");
		verifyTrue(patientsPage.isPatientDetailsPageDisplays());
	}
	@Test(groups = { "regression" },description = "Add New Record_Save and Route to CBO")
	public void patients_PatientDetails_CBOBilling_AddNew_009_SaveAndRouteToCBO()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_009 - Step 01: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_009 - Step 02: Click CBO Billing details link");
		patientsPage.clickPatientDetailsCBOListDetailsLink("1");
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_009 - Step 03: Click Save and Route to CBO button");
		patientsPage.clickPatientDetailsCBOSaveRouteToCBOButton();
		patientsPage.acceptAlert(driver);
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_009 - Step 04: Expand CBO Billing");
		patientsPage.expandPatientDetailsCBOBilling();
		
		log.info("VP: Patient details page displays and CBO Billing item change Assign to 'CBOAdmin'");
		verifyTrue(patientsPage.getPatientDetailsCBOListAssignedTo("1").contains("CBOAdmin"));
	}
	@Test(groups = { "regression" },description = "Add New Record_List Of Patients")
	public void patients_PatientDetails_CBOBilling_AddNew_010_ListOfPatients()
	{
		log.info("patients_PatientDetails_CBOBilling_AddNew_010 - Step 01: Click CBO Billing details link");
		patientsPage.clickPatientDetailsCBOListDetailsLink("1");
		
		log.info("patients_PatientDetails_CBOBilling_AddNew_010 - Step 02: Click List of Patient button");
		patientsPage.clickPatientDetailsCBOListOfPatientButton();
		patientsPage.acceptAlert(driver);
		
		log.info("VP: List of Patient displays");
		verifyTrue(patientsPage.getNumberOfItemInListOfPatients()>=1);
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
	private String organization, qaAdminUsername, password;
	private String validPatientLastName,validHomePhone,validZIP,validPatientFirstName,validPatientType;
	private int date, month, year;
	private String message;
	private String newMessage;
	private String patientDOB;
	private final Stack<String> openWindowHandles = new Stack<String>();
}
