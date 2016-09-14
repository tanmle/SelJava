package cloudDocs;

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
import common.Constant;

public class cloudDocs_001 extends AbstractTest{

	@Parameters({ "browser", "ipClient", "port" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String ipClient, String port){

		driver  = openBrowser(browser, port, ipClient);		
		loginPage = PageFactory.getLoginPage(driver, ipClient);
		organization = Constant.ORGANIZATION;
		qaStaffUsername = Constant.QA_STAFF_USERNAME;
		password = Constant.PASSWORD;
		patientsLastName = "Russo";
		patientsFirstName = "John";
		cloudDocsFile = "cloudDocsTest.txt";
		contentCloudDocsFile = "Cloud_Docs_file";
		editContents = "Cloud_Docs_folder"
				+ "_"+getUniqueName();
		cloudDocsNewFileName = "Edit_File_Name.txt";
		folderClouDocsName = "Cloud_Docs_Folder_"+getUniqueNumber();
		folderOtherClouDocsName = "Cloud_Docs_Copy_Folder_"+getUniqueNumber();
		editFolderCloudDocsName = "EDIT_Cloud_Docs_Folder_"+getUniqueNumber();
		duplicateFile = "cloudDocsTest copy.txt";
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Sever error and cannot delete file")
	public void cloudDocs_01_OpenAndDeleteFile()
	{
		log.info("cloudDocs_01 - Step 01: Login with correct username & password");
		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
		
		log.info("cloudDocs_01 - Step 02 Click Patients");
		patientsPage = schedulePage.openPatientsTab();
				
		log.info("cloudDocs_01 - Step 03: Search for a patient");
		patientsPage.openPatientByName(patientsLastName,patientsFirstName);
		
		log.info("cloudDocs_01 - Step 04: Click Cloud Docs");
		patientsPage.clickCloudDocsButton();
		patientsPage.switchToCloudDocsFrame(driver);
		
		log.info("cloudDocs_01 - Step 05: Add files");
		patientsPage.addCloudDocsFile();
		
		log.info("cloudDocs_01 - Step 06: Click to open file just created");
		patientsPage.openCloudDocsFile(cloudDocsFile);
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: File will be opened");
		verifyTrue(patientsPage.isCloudDocsFileOpen(contentCloudDocsFile));
		
		driver.close();
		driver.switchTo().window(currentHandle);
		
		log.info("cloudDocs_01 - Step 07: Remove file");
		patientsPage.switchToCloudDocsFrame(driver);
		patientsPage.removeCloudDocsFile(cloudDocsFile);
		
		log.info("VP: File removed successfully");
		verifyFalse(patientsPage.isCloudDocsFileExists(cloudDocsFile));
	}
	@Test(groups = { "regression" },description = "Cloud Docs: Cannot edit txt file")
	public void cloudDocs_02_OpenAndDeleteFile()
	{
		log.info("cloudDocs_02 - Step 01: Add file");
		patientsPage.addCloudDocsFile();
		
		log.info("cloudDocs_02 - Step 02: Click edit file");
		patientsPage.editCloudDocsFileContent(cloudDocsFile,editContents);
		
		log.info("cloudDocs_02 - Step 03: Open file just edited");
		patientsPage.openCloudDocsFile(cloudDocsFile);
		
		String currentHandle = driver.getWindowHandle();
		openWindowHandles.push(driver.getWindowHandle());
		Set<String> newHandles = driver.getWindowHandles();
		newHandles.removeAll(openWindowHandles);
		String handle = newHandles.iterator().next();
		driver.switchTo().window(handle);
		
		log.info("VP: File will be opened");
		verifyTrue(patientsPage.isCloudDocsFileOpen(editContents));
		
		driver.close();
		driver.switchTo().window(currentHandle);
		
		log.info("cloudDocs_02 - post condition");
		patientsPage.switchToCloudDocsFrame(driver);
		
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: File info displays incorrectly")
	public void cloudDocs_03_OpenAndDeleteFile()
	{
		log.info("cloudDocs_03 - Step 01: Edit file name");
		patientsPage.editCloudDocsFileName(cloudDocsFile,cloudDocsNewFileName);
		
		log.info("cloudDocs_03 - Step 02: Open Cloud Docs file info");
		patientsPage.openCloudDocsFileInfo(cloudDocsNewFileName);
		
		log.info("VP: File info will be displayed correctly");
		verifyTrue(patientsPage.isCloudDocsInfoDisplays(cloudDocsNewFileName));
	
		log.info("cloudDocs_03 - Step 03: Open Cloud Docs file info");
		patientsPage.closeCloudDocInfo();
		
		log.info("cloudDocs_03 - Step 04: Remove file");
		patientsPage.removeCloudDocsFile(cloudDocsNewFileName);
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Folder display Incorrect Name, Cannot Delete Folder")
	public void cloudDocs_04_DeleteFolder()
	{
		log.info("cloudDocs_04 - Step 01: Create folder");
		patientsPage.addNewCloudDocsForder(folderClouDocsName);
		
		log.info("cloudDocs_04 - Step 02: Edit folder");
		patientsPage.editCloudDocsFileName(folderClouDocsName, editFolderCloudDocsName);
		
		log.info("cloudDocs_04 - Step 03: Open Cloud Docs file info");
		patientsPage.openCloudDocsFileInfo(editFolderCloudDocsName);
	
		log.info("VP: Folder info will be displayed ");
		verifyTrue(patientsPage.isCloudDocsInfoDisplays(editFolderCloudDocsName));
		
		log.info("cloudDocs_04 - Step 04: Open Cloud Docs file info");
		patientsPage.closeCloudDocInfo();
		
		log.info("cloudDocs_04 - Step 05: Delete folder");
		patientsPage.removeCloudDocsFile(editFolderCloudDocsName);
	
		log.info("VP: delete folder successfully");
		verifyFalse(patientsPage.isCloudDocsFileExists(editFolderCloudDocsName));
		
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Select")
	public void cloudDocs_06_Select()
	{
		log.info("cloudDocs_06 - Step 01: Add files");
		patientsPage.addCloudDocsFile();
		
		log.info("cloudDocs_06 - Step 02: Select file");
		patientsPage.selectCloudDocsFile(cloudDocsFile);

		log.info("VP: Selected succesffully");
		verifyTrue(patientsPage.isSelectCloudDocsFileSuccess(cloudDocsFile));
		
		log.info("cloudDocs_06 - Step 03: Delete file");
		patientsPage.removeCloudDocsFile(cloudDocsFile);
		
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Duplicate file")
	public void cloudDocs_07_DuplicateFile()
	{
		log.info("cloudDocs_07 - Step 01: Create folder");
		patientsPage.addNewCloudDocsForder(folderClouDocsName);
		
		log.info("cloudDocs_07 - Step 02: Edit folder");
		patientsPage.openCloudDocsFile(folderClouDocsName);

		log.info("cloudDocs_07 - Step 03: Add files");
		patientsPage.addCloudDocsFile();
		
		log.info("cloudDocs_07 - Step 04: Duplicate the file");
		patientsPage.duplicateCloudDocsFile(cloudDocsFile);
		
		log.info("cloudDocs_07 - Step 05: File duplicated  successfully");
		verifyTrue(patientsPage.isCloudDocsFileExists(duplicateFile));
		
		log.info("cloudDocs_07 - Step 06: Delete file");
		patientsPage.removeCloudDocsFile(cloudDocsFile);
		patientsPage.removeCloudDocsFile(duplicateFile);
		
		log.info("cloudDocs_07 - Step 07: Create folder");
		patientsPage.openMainPatientCloudDocs();
		
		log.info("cloudDocs_07 - Step 06: Delete folder");
		patientsPage.removeCloudDocsFile(folderClouDocsName);
		
	}
	@Test(groups = { "regression" },description = "Cloud Docs: Upload file")
	public void cloudDocs_08_UploadFile()
	{
		log.info("cloudDocs_08 - Step 01: Create folder");
		patientsPage.addNewCloudDocsForder(folderClouDocsName);
		
		log.info("cloudDocs_08 - Step 02: Edit folder");
		patientsPage.openCloudDocsFile(folderClouDocsName);

		log.info("cloudDocs_08 - Step 03: Add files");
		patientsPage.addCloudDocsFile();
		
		log.info("VP: File uploaded  successfully");
		verifyTrue(patientsPage.isCloudDocsFileExists(cloudDocsFile));
		
		log.info("cloudDocs_08 - Step 04: Delete file");
		patientsPage.removeCloudDocsFile(cloudDocsFile);
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Reload folder get error")
	public void cloudDocs_09_ReloadFolder()
	{
		log.info("cloudDocs_09 - Step 01: Click Reload folders");
		patientsPage.reloadCloudDocsFolder();
		
		log.info("VP: Folder reloaded  successfully");
		verifyTrue(patientsPage.folderReloadSuccess(folderClouDocsName));
		
		log.info("cloudDocs_09 - Step 02: Create folder");
		patientsPage.openMainPatientCloudDocs();
		
		log.info("cloudDocs_09 - Step 03: Delete folder");
		patientsPage.removeCloudDocsFile(folderClouDocsName);
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Create file feature was deleted")
	public void cloudDocs_10_CreateFileFeatureWasDeleted()
	{
		log.info("cloudDocs_10 - Step 01: Add new folders");
		patientsPage.addNewCloudDocsForder(folderClouDocsName);
		
		log.info("cloudDocs_10 - Step 02: Open folder");
		patientsPage.addCloudDocsFileByRightClick();
		
		log.info("VP: File uploaded  successfully");
		verifyTrue(patientsPage.isCloudDocsFileExists(cloudDocsFile));
		
		log.info("cloudDocs_10 - Step 03: Delete folder");
		patientsPage.removeCloudDocsFile(cloudDocsFile);
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Upload 30+ files at the same time")
	public void cloudDocs_12_Upload30Files()
	{
		log.info("cloudDocs_12 - Step 01: open folder");
		patientsPage.openCloudDocsFile(folderClouDocsName);
		
		log.info("cloudDocs_12 - Step 02: Click Reload folders");
		patientsPage.upload31FilesCloudDocs();
		
		log.info("VP: All files will be uploaded successfully.");
		verifyTrue(patientsPage.isCloudDocsUpload31FileSuccess());
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Copy 30+ files from a folder to another folder")
	public void cloudDocs_13_Copy30Files()
	{
		log.info("cloudDocs_13 - Step 01: Copy all file in folder");
		patientsPage.copy31UploadedFileCloudDocs();
		
		log.info("cloudDocs_13 - Step 02: Create folder");
		patientsPage.openMainPatientCloudDocs();
		
		log.info("cloudDocs_13 - Step 03: Create folder");
		patientsPage.addNewCloudDocsForder(folderOtherClouDocsName);
		
		log.info("cloudDocs_13 - Step 04: open folder");
		patientsPage.openCloudDocsFile(folderOtherClouDocsName);
		
		log.info("cloudDocs_13 - Step 05: Copy all file in folder");
		patientsPage.paste31FileCloudDocs();
		
		log.info("VP: All files will be copied successfully. ");
		verifyTrue(patientsPage.isCloudDocsUpload31FileSuccess());
	}
	
	@Test(groups = { "regression" },description = "Cloud Docs: Cannot delete, duplicate 30+ files")
	public void cloudDocs_14_Duplicate30Files()
	{	
		log.info("cloudDocs_14 - Step 01: delete all file");
		patientsPage.delete31FileCloudDocs();
		
		log.info("cloudDocs_14 - Step 02: Open Main folder");
		patientsPage.openMainPatientCloudDocs();
		
		log.info("cloudDocs_14 - Step 03: Delete folder");
		patientsPage.removeCloudDocsFile(folderOtherClouDocsName);
		
		log.info("cloudDocs_14 - Step 04: open folder");
		patientsPage.openCloudDocsFile(folderClouDocsName);
		
		log.info("cloudDocs_14 - Step 05: duplicate 30 files");
		patientsPage.duplicate31CloudDocsFile();
		
		log.info("VP: All files will be copied successfully. ");
		verifyTrue(patientsPage.isCloudDocsUpload31DulicateFileSuccess());
		
		log.info("cloudDocs_14 - Step 06: delete all file");
		patientsPage.delete31FileCloudDocs();
		
		log.info("VP: All files will be deleted successfully. ");
		verifyFalse(patientsPage.isCloudDocsUpload31FileSuccess());
		verifyFalse(patientsPage.isCloudDocsUpload31DulicateFileSuccess());
		
		log.info("cloudDocs_14 - PostCondition 05: Open Main folder");
		patientsPage.openMainPatientCloudDocs();
		
		log.info("cloudDocs_14 - PostCondition 06: Delete folder");
		patientsPage.removeCloudDocsFile(folderClouDocsName);

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
	private String organization, qaStaffUsername, password, contentCloudDocsFile;
	private String patientsLastName, patientsFirstName, cloudDocsFile, editContents, cloudDocsNewFileName;
	private String folderClouDocsName, editFolderCloudDocsName, duplicateFile, folderOtherClouDocsName;
	private final Stack<String> openWindowHandles = new Stack<String>();
}