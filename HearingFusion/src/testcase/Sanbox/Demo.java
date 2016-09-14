//package Sanbox;
//
//
//import java.util.Set;
//import java.util.Stack;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import page.LoginPage;
//import page.PageFactory;
//import page.PatientsPage;
//import page.SalesPage;
//import page.SchedulePage;
//import common.AbstractTest;
//import common.Common;
//import common.Constant;
//
//public class Demo extends AbstractTest{
//
//	@Parameters({ "browser", "ipClient", "port" })
//	@BeforeClass(alwaysRun = true)
//	public void setup(String browser, String ipClient, String port){
//
//		driver  = openBrowser(browser, port, ipClient);		
//		loginPage = PageFactory.getLoginPage(driver, ipClient);
//		organization = Constant.ORGANIZATION;
//		qaStaffUsername = Constant.QA_STAFF_USERNAME;
//		password = Constant.PASSWORD;
//		date = Common.getCommon().getCurrentDay();
//		month = Common.getCommon().getCurrentMonth();
//		year = Common.getCommon().getCurrentYear();
//		correctHour = 16;
//		correctMinute = 0;
//		movingHour = correctHour+1;
//		correctStartTime = "04:00 PM";
//		correctEndTime = "05:00 PM";
//		movingStartTime = "05:00 PM";
//		movingEndTime = "06:00 PM";
//		apptType = "Annual Test";
//		editApptType = "Consultation";
//		apptStatus = "Scheduled";
//		editApptStatus = "Confirmed";
//		patientFull = "Baker, Mark   (Henderson Ear)";
//		patientName = "Baker, Mark";
//		refResource = "Campaign";
//		editRefResource = "Facebook";
//		provider = "Needle, Space";
//		startTime = "4:00 PM";
//	}
//	
//	@Test(groups = { "regression" },description = "Schedule Day")
//	public void Demo1()
//	{
//		schedulePage = loginPage.login(organization, qaStaffUsername, password, false);
//		
//		schedulePage.openLink(driver, "http://staging.hearingfusion.com/WAFForm.aspx?_act=Open&_tab=PurchaseOrder&_for=POCheckOutDetails&_pky=166772");
//		salesPage = PageFactory.getSalesPage(driver, ipClient);
//		salesPage.selectApointment(month+"/"+date+"/"+year+" "+startTime+" ("+apptType+")");
//		
//		
//	}
//
//	private final Stack<String> openWindowHandles = new Stack<String>();
//	private SalesPage salesPage;
//	private PatientsPage patientsPage;
//	private WebDriver driver;
//	private LoginPage loginPage;
//	private SchedulePage schedulePage;
//	private String organization, qaStaffUsername, password, startTime;
//	private int date, month, year, correctHour, correctMinute, movingHour;
//	private String apptType, apptStatus, patientFull, patientName, refResource, provider;
//	private String editApptType, editApptStatus, editRefResource;
//	private String correctStartTime, correctEndTime, movingStartTime, movingEndTime;
//}