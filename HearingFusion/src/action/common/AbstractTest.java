package common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import page.LoginPage;
import page.PageFactory;
import HearingFusion.Interfaces;
import common.AutomationControl;
import common.Browser;
import java.util.Random;
import java.util.UUID;

public abstract class AbstractTest {
	protected boolean verifyTrue(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(
						Reporter.getCurrentTestResult(), e);
			}
		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyTrue(condition, false);
	}

	protected boolean verifyFalse(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(
						Reporter.getCurrentTestResult(), e);
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;

	}

	protected boolean verifyFalse(boolean condition) {
		return verifyFalse(condition, false);
	}

	protected boolean verifyEquals(Object actual, Object expected, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertEquals(actual, expected);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(
						Reporter.getCurrentTestResult(), e);
			}
		} else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}

	protected void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * open browser and navigate to url
	 * 
	 * @param browser
	 * @throws Exception
	 */
	protected WebDriver openBrowser(String browser, String port, String ipClient) {
		Browser br = new Browser();
		WebDriver driver = br.launch(browser, port, ipClient);
		driver.manage().window().maximize();
		if (driver.toString().toLowerCase().contains("chrome")
				|| driver.toString().toLowerCase().contains("firefox")) {
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.focus();");			
		}
		
		driver.manage().timeouts();
		return driver;
	}

	/**
	 * Close browser and kill chromedriver.exe process
	 * 
	 * @param driver
	 */
	protected void closeBrowser(WebDriver driver) {
		try {
			driver.quit();
			System.gc();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskkill /IM chromedriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Logout page at any current page
	 */
	protected LoginPage logout(WebDriver driver, String ipclient) {
		try {
			String url = "";
			if (Common.getCommon().getLogoutLink().equals("")) {
				Thread.sleep(2000);
				control.setPage("AbstractPage");
				url = control.findElement(driver,
						Interfaces.AbstractPage.LOGOUT_LINK).getAttribute(
						"href");
				Common.getCommon().setLogoutLink(url);
			} else {
				url = Common.getCommon().getLogoutLink();
			}
			driver.get(url);
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getLoginPage(driver, ipClient);
	}

	/**
	 * Return a random unique string
	 * 
	 * @return unique string
	 */
	protected String getUniqueName() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * get a random character
	 * 
	 * @return unique string
	 */
	protected char getRandomCharacter() {
		Random r = new Random();
		char random_3_Char = (char) (48 + r.nextInt(47));
		return random_3_Char;
	}
	
	/**
	 * get Random String With Length
	 */
	protected String getRandomStringWithLength(int length) {
		String returnString = "";
		char aChar;
		for(int i = 0; i<length; i++){
			aChar = getRandomCharacter();
			returnString = returnString + aChar;
		}
		return returnString;		
	}

	/**
	 * Return a random unique number
	 * 
	 * @return unique number
	 */
	protected String getUniqueNumber() {
		Random rand = new Random();

		int number = rand.nextInt(9000000) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}

	protected int handleDatePlus(int plusDate){
		int date = Common.getCommon().getCurrentDayWithPlusDays(plusDate);
		int month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate);
		int year = Common.getCommon().getCurrentYearWithPlusDays(plusDate);
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("sunday")){
			date = Common.getCommon().getCurrentDayWithPlusDays(plusDate+1);
			month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate+1);
			year = Common.getCommon().getCurrentYearWithPlusDays(plusDate+1);
		}
		return date;
	}
	
	protected int handleMonthPlus(int plusDate){
		int date = Common.getCommon().getCurrentDayWithPlusDays(plusDate);
		int month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate);
		int year = Common.getCommon().getCurrentYearWithPlusDays(plusDate);
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("sunday")){
			date = Common.getCommon().getCurrentDayWithPlusDays(plusDate+1);
			month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate+1);
			year = Common.getCommon().getCurrentYearWithPlusDays(plusDate+1);
		}
		return month;
	}
	
	protected int handleYearPlus(int plusDate){
		int date = Common.getCommon().getCurrentDayWithPlusDays(plusDate);
		int month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate);
		int year = Common.getCommon().getCurrentYearWithPlusDays(plusDate);
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("sunday")){
			date = Common.getCommon().getCurrentDayWithPlusDays(plusDate+1);
			month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate+1);
			year = Common.getCommon().getCurrentYearWithPlusDays(plusDate+1);
		}
		return year;
	}
	
	protected int handleDateMinus(int plusDate){
		int date = Common.getCommon().getCurrentDayWithPlusDays(plusDate);
		int month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate);
		int year = Common.getCommon().getCurrentYearWithPlusDays(plusDate);
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("sunday")){
			date = Common.getCommon().getCurrentDayWithPlusDays(plusDate-1);
			month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate-1);
			year = Common.getCommon().getCurrentYearWithPlusDays(plusDate-1);
		}
		return date;
	}
	
	protected int handleMonthMinus(int plusDate){
		int date = Common.getCommon().getCurrentDayWithPlusDays(plusDate);
		int month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate);
		int year = Common.getCommon().getCurrentYearWithPlusDays(plusDate);
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("sunday")){
			date = Common.getCommon().getCurrentDayWithPlusDays(plusDate-1);
			month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate-1);
			year = Common.getCommon().getCurrentYearWithPlusDays(plusDate-1);
		}
		return month;
	}
	
	protected int handleYearMinus(int plusDate){
		int date = Common.getCommon().getCurrentDayWithPlusDays(plusDate);
		int month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate);
		int year = Common.getCommon().getCurrentYearWithPlusDays(plusDate);
		String dateOfWeek = Common.getCommon().getDayOfWeek(date, month, year);
		if(dateOfWeek.toLowerCase().equals("sunday")){
			date = Common.getCommon().getCurrentDayWithPlusDays(plusDate-1);
			month = Common.getCommon().getCurrentMonthWithPlusDays(plusDate-1);
			year = Common.getCommon().getCurrentYearWithPlusDays(plusDate-1);
		}
		return year;
	}
	
	public void clearCookie(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}	
	
	protected final Log log;
	protected WebDriver driver;
	protected String ipClient;
	protected AutomationControl control = new AutomationControl();
}
