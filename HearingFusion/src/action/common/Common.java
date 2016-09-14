package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.Stack;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
//import org.sikuli.api.DesktopScreenRegion;
//import org.sikuli.api.ImageTarget;
//import org.sikuli.api.ScreenRegion;
//import org.sikuli.api.Target;
//
//import org.sikuli.api.robot.Keyboard;
//import org.sikuli.api.robot.Mouse;
//import org.sikuli.api.robot.desktop.DesktopKeyboard;
//import org.sikuli.api.robot.desktop.DesktopMouse;
//import org.sikuli.remote.client.RemoteScreen;
//import org.sikuli.script.Key;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
import com.jacob.com.LibraryLoader;

import autoitx4java.*;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

import config.ProviderConfiguration;

public class Common {

	public static synchronized Common getCommon() {
		if (instance == null) {
			instance = new Common();
		}

		return instance;
	}

	/**
	 * Get day of week
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 * @throws ParseException
	 */
	public String getDayOfWeek(int day, int month, int year) {
		try {
			String strDate = day + "/" + month + "/" + year;
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = format.parse(strDate);
			DateFormat dateFormat = new SimpleDateFormat("EEEE");
			return dateFormat.format(dt);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	/**
	 * Convert rgba to hex
	 * 
	 * @param r
	 * @param g
	 * @param b
	 * @return
	 */
	public String toBrowserHexValue(int number) {
		StringBuilder builder = new StringBuilder(
				Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}
		return builder.toString().toUpperCase();
	}

	/**
	 * Convert rgba to hex
	 * 
	 * @param r
	 * @param g
	 * @param b
	 * @return
	 */
	public String toHex(int r, int g, int b) {
		return "#" + toBrowserHexValue(r) + toBrowserHexValue(g)
				+ toBrowserHexValue(b);
	}

	/**
	 * Comverton month
	 * 
	 * @param month
	 * @return
	 */
	public String convertMonth(int month) {
		String m = null;
		switch (month) {
		case 1:
			m = "January";
			break;
		case 2:
			m = "February";
			break;
		case 3:
			m = "March";
			break;
		case 4:
			m = "April";
			break;
		case 5:
			m = "May";
			break;
		case 6:
			m = "June";
			break;
		case 7:
			m = "July";
			break;
		case 8:
			m = "August";
			break;
		case 9:
			m = "September";
			break;
		case 10:
			m = "October";
			break;
		case 11:
			m = "November";
			break;
		case 12:
			m = "December";
			break;
		default:
			break;

		}
		return m;
	}

	/**
	 * convert to month
	 * 
	 * @param monthName
	 * @return month
	 */
	public int convertMonth(String monthName) {
		int m = 0;
		if (monthName.toUpperCase().contains("JAN"))
			m = 1;
		else if (monthName.toUpperCase().contains("FEB"))
			m = 2;
		else if (monthName.toUpperCase().contains("MAR"))
			m = 3;
		else if (monthName.toUpperCase().contains("APR"))
			m = 4;
		else if (monthName.toUpperCase().contains("MAY"))
			m = 5;
		else if (monthName.toUpperCase().contains("JUN"))
			m = 6;
		else if (monthName.toUpperCase().contains("JUL"))
			m = 7;
		else if (monthName.toUpperCase().contains("AUG"))
			m = 8;
		else if (monthName.toUpperCase().contains("SEP"))
			m = 9;
		else if (monthName.toUpperCase().contains("OCT"))
			m = 10;
		else if (monthName.toUpperCase().contains("NOV"))
			m = 11;
		else if (monthName.toUpperCase().contains("DEC"))
			m = 12;
		return m;
	}

	/**
	 * get current browser
	 * 
	 * @return driver
	 */
	public String getCurrentBrowser() {
		ProviderConfiguration provider = ProviderConfiguration.getProvider();
		provider.loadInstance("HearingFusion");
		String driverClass = ProviderConfiguration.getProvider().getSelenium()
				.getDriver();
		return driverClass;
	}

	/**
	 * get current day with plus day
	 * 
	 * @param days
	 * @return day
	 */
	public int getCurrentDayWithPlusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.plusDays(days).getDayOfMonth();
	}

	/**
	 * get month when current day plus days
	 * 
	 * @param days
	 * @return
	 */
	public int getCurrentMonthWithPlusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.plusDays(days).getMonthOfYear();
	}

	/**
	 * get year when current day plus days
	 * 
	 * @param days
	 * @return
	 */
	public int getCurrentYearWithPlusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.plusDays(days).getYear();
	}

	/**
	 * get current day
	 * 
	 * @return
	 */
	public int getCurrentDay() {
		DateTime now = DateTime.now();
		return now.getDayOfMonth();
	}

	/**
	 * get current month
	 * 
	 * @return
	 */
	public int getCurrentMonth() {
		DateTime now = DateTime.now();
		return now.getMonthOfYear();
	}

	/**
	 * get current year
	 * 
	 * @return
	 */
	public int getCurrentYear() {
		DateTime now = DateTime.now();
		return now.getYear();
	}

	/**
	 * get current hour
	 * 
	 * @return
	 */
	public int getCurrentHours() {
		DateTime now = DateTime.now();
		return now.getHourOfDay();
	}

	/**
	 * get current minute
	 * 
	 * @return
	 */
	public int getCurrentMinutes() {
		DateTime now = DateTime.now();
		return now.getMinuteOfHour();
	}

	/**
	 * get logout link
	 * 
	 * @return
	 */
	public String getLogoutLink() {
		return logOutLink;
	}

	/**
	 * set logout link
	 * 
	 * @param url
	 */
	public void setLogoutLink(String url) {
		this.logOutLink = url;
	}

	/*
	 * public void type(String value) { keyboard.type(value);
	 * keyboard.type(Key.ENTER); }
	 */

	/**
	 * get en on mac os
	 * 
	 * @return
	 */
	public String getEnOnMac() {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("ifconfig -u -l");
			InputStream stdout = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stdout));
			String line;
			while ((line = reader.readLine()) != null) {
				int index = line.indexOf("en");
				if (index > 0) {
					en = line.substring(index, 7);
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return en;
	}

	/**
	 * disconnect network on mac
	 */
	public void disconnectNetWorkOnMac() {
		String output = "";
		if (en == "") {
			en = getEnOnMac();
		}
		try {
			String cmd = "sudo ifconfig " + en + " down";
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(cmd);
			process.waitFor();
			InputStream stdout = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stdout));
			String line;
			while ((line = reader.readLine()) != null) {
				output = output + line;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * re-connect network on mac
	 */
	public void reconnectNetWorkOnMac() {
		String output = "";
		try {
			String cmd = "sudo ifconfig " + en + " up";
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(cmd);
			InputStream stdout = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stdout));
			String line;
			while ((line = reader.readLine()) != null) {
				output = output + line;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * close a new window when click on link with target is _blank
	 * 
	 * @param driver
	 */
	public void closeNewWindow(WebDriver driver) {
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
	 * Define User32
	 *
	 */
	public interface User32 extends StdCallLibrary {
		User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class,
				W32APIOptions.DEFAULT_OPTIONS);

		HWND FindWindow(String lpClassName, String lpWindowName);

		HWND SetForegroundWindow(HWND hWnd);

		HWND ShowWindow(HWND hWnd, int nCmdShow);

		HWND SetFocus(HWND hwnd);
	}

	/**
	 * Use User32 to focus window
	 * 
	 * @param className
	 * @param windowName
	 */
	public void focusWindow(String className, String windowName) {
		HWND hWnd = User32.INSTANCE.FindWindow(className, windowName);
		if (hWnd != null) {
			User32.INSTANCE.ShowWindow(hWnd, 10);
			User32.INSTANCE.SetForegroundWindow(hWnd);
			User32.INSTANCE.SetFocus(hWnd);
		} else {
			System.out.println("Can not find window with class: " + className
					+ " window name: " + windowName);
		}
	}

	/**
	 * Comverton month
	 * 
	 * @param month
	 * @return short name month
	 */
	public String convertShortMonth(int month) {
		String m = null;
		switch (month) {
		case 1:
			m = "Jan";
			break;
		case 2:
			m = "Feb";
			break;
		case 3:
			m = "Mar";
			break;
		case 4:
			m = "Apr";
			break;
		case 5:
			m = "May";
			break;
		case 6:
			m = "Jun";
			break;
		case 7:
			m = "Jul";
			break;
		case 8:
			m = "Aug";
			break;
		case 9:
			m = "Sep";
			break;
		case 10:
			m = "Oct";
			break;
		case 11:
			m = "Nov";
			break;
		case 12:
			m = "Dec";
			break;
		default:
			break;
		}
		return m;
	}

	/**
	 * get date after plus day
	 */
	public int getDateAfterPlusOneDay(int date, int month, int year) {
		if (month == 2) {
			if (year % 4 == 0 && year % 100 == 0 || year % 400 == 0) {
				if (date == 29) {
					return 1;
				} else
					return date + 1;
			} else {
				if (date == 28) {
					return 1;
				} else
					return date + 1;
			}
		} else if (month == 1 || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10 || month == 12) {
			if (date == 31) {
				return 1;
			} else
				return date + 1;
		} else {
			if (date == 30) {
				return 1;
			} else
				return date + 1;
		}
	}

	/**
	 * get month after plus day
	 */
	public int getMonthAfterPlusOneDay(int date, int month, int year) {
		if (month == 2) {
			if (year % 4 == 0 && year % 100 == 0 || year % 400 == 0) {
				if (date == 29) {
					return month + 1;
				} else
					return month;
			} else {
				if (date == 28) {
					return month + 1;
				} else
					return month;
			}
		} else if (month == 1 || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10) {
			if (date == 31) {
				return month + 1;
			} else
				return month;
		} else if (month == 12) {
			if (date == 31) {
				return 1;
			} else
				return month;
		} else {
			if (date == 30) {
				return month + 1;
			} else
				return month;
		}
	}

	/**
	 * get year after plus day
	 */
	public int getYearAfterPlusOneDay(int date, int month, int year) {
		if (month == 12 && date == 31)
			return year + 1;
		return year;
	}

	/**
	 * check file is existed
	 * 
	 * @param file
	 * @return true/false
	 */
	public boolean isFileExists(String file) {
		try {
			String pathFolderDownload = getPathContainDownload();
			File files = new File(pathFolderDownload + file);
			boolean exists = files.exists();
			return exists;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	/**
	 * get path contain download file
	 * 
	 * @return path
	 */
	public String getPathContainDownload() {
		String path = "";
		String currentUser = System.getProperty("user.name");
		path = String.format(Constant.FOLDER_DOWNLOAD_ONE_WIN, currentUser);
		return path;
	}

	/**
	 * Delete a file from local PC
	 * 
	 * @param file
	 */
	public void deleteFile(String file) {
		try {
			if (isFileExists(file)) {
				String pathFolderDownload = getPathContainDownload();
				File files = new File(pathFolderDownload + file);
				files.delete();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * Delete a file from local PC
	 * 
	 * @param file
	 */
	public void waitForFileExist(String file, int times) {
		try {
			boolean isDownloaded = isFileExists(file);
			int i = 0;
			while (isDownloaded == false && i <= times) {
				Thread.sleep(1000);
				i++;
				isDownloaded = isFileExists(file);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * init autoIT
	 * 
	 * @return autoIT
	 */
	public AutoItX initAutoIT() {
		String tmp = System.getProperty("os.arch");
		File file;
		if (tmp.contains("64"))
			file = new File("lib", "jacob-1.17-M2-x64.dll"); // path to the
																// jacob dll
		else
			file = new File("lib", "jacob-1.17-M2-x86.dll"); // path to the
																// jacob dll

		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		AutoItX autoIT = new AutoItX();
		return autoIT;
	}

	/**
	 * Save download file on Firefox brower
	 */
	public void saveFileOnFirefox() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Save download file on IE brower
	 */
	public void saveFileOnIE() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * wait for screen appears using sikuli lib
	 * 
	 * @param imgName
	 * @param timeout
	 */
	// public void wait(String imgName,long timeout)
	// {
	//
	// {
	// try {
	// screen.wait( imgName, timeout);
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	// }
	// }
	/**
	 * click on control using sikuli lib
	 * 
	 * @param imgName
	 */
	// public void click(String imgName)
	// {
	// {
	// try {
	// screen.click(imgName);
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	// }
	// }
	/**
	 * type
	 * 
	 * @param value
	 */
	// public void type(String value) {
	// keyboard.keyDown(KeyEvent.VK_CONTROL);
	// keyboard.type("a");
	// keyboard.keyUp(KeyEvent.VK_CONTROL);
	// keyboard.type(value);
	// }

	public void closePrintPopup(WebDriver driver) {
		try {
			AutoItX autoIT = initAutoIT();
			String title;
			if (driver.toString().contains("chrome")) {
				title = "List of Carriers - Hearing Fusion - Google Chrome";
				autoIT.winActivate(title);
				autoIT.winClose(title, "[CLASS:Edit; INSTANCE:1]");
			} else {
				title = "Print";
				autoIT.winWaitActive(title, "", 5);

				if (autoIT.winExists(title)) {
					autoIT.winClose(title);
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * open file to upload using autoitx lib
	 * 
	 * @param fileName
	 */
	public void openFileForUpload(WebDriver driver, String fileName) {
		try {
			AutoItX autoIT = initAutoIT();
			String title;
			String path = getPathFile(fileName);
			if (driver.toString().contains("chrome"))
				title = "Open";
			else if(driver.toString().contains("firefox"))
				title = "File Upload";
			else
				title = "Choose File to Upload";

			autoIT.winWaitActive(title, "", 5);

			if (autoIT.winExists(title)) {
				autoIT.winActivate(title);
				autoIT.controlClick(title, "", "[CLASS:Edit; INSTANCE:1]");
				Thread.sleep(500);
				autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]", path);
				Thread.sleep(500);
				String tmp = autoIT.controlGetText(title, "","[CLASS:Edit; INSTANCE:1]");
				if (!tmp.equals(path)) {

					autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]","^a");
					autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]","{DELETE}");
					autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]",path);
					Thread.sleep(500);
				}

				autoIT.controlClick(title, "", "[CLASS:Button; INSTANCE:1]");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (autoIT.winExists(title)) {
					autoIT.controlClick(title, "", "[CLASS:Button; INSTANCE:1]");
					autoIT.controlClick(title, "", "[CLASS:Button; INSTANCE:2]");

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * get full path of file
	 * 
	 * @param fileName
	 * @return
	 */
	public String getPathFile(String fileName) {

		File file = new File(fileName);
		return file.getAbsolutePath();

	}
	/**
	 * 
	 * @param key event
	 */
	public void sendkey(int kev){
		Robot robot;
		try {
				robot = new Robot();
				robot.keyPress(kev);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * open 31 File For Upload
	 * @param driver
	 */
	public void open31FileForUpload(WebDriver driver){
		try {
			AutoItX autoIT = initAutoIT();
			String title;
			String path = getPathFile(Constant.PATH_CLOUD_DOCS_30_FILES);
			if (driver.toString().contains("chrome"))
				title = "Open";
			else if(driver.toString().contains("firefox"))
				title = "File Upload";
			else
				title = "Choose File to Upload";

			autoIT.winWaitActive(title, "", 5);

			if (autoIT.winExists(title)) {
				autoIT.winActivate(title);
				//Open path
				autoIT.controlClick(title, "", "[CLASS:Edit; INSTANCE:1]");
				Thread.sleep(500);
				autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]", path);
				Thread.sleep(500);
				String tmp = autoIT.controlGetText(title, "","[CLASS:Edit; INSTANCE:1]");
				if (!tmp.equals(path)) {

					autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]","^a");
					autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]","{DELETE}");
					autoIT.controlSend(title, "", "[CLASS:Edit; INSTANCE:1]",path);
					Thread.sleep(500);
				}
				autoIT.controlClick(title, "", "[CLASS:Button; INSTANCE:1]");
				//add 31 file
				
//				StringSelection selection = new StringSelection(Constant.CLOUD_DOCS_30_FILES);
//			    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			    clipboard.setContents(selection, selection);
				
				Thread.sleep(500);
				autoIT.controlClick(title, "", "[CLASS:DirectUIHWND; INSTANCE:2]");
				Thread.sleep(500);
				autoIT.controlSend(title, "", "[CLASS:DirectUIHWND; INSTANCE:2]","^a");
				Thread.sleep(500);
				autoIT.controlClick(title, "", "[CLASS:Button; INSTANCE:1]");
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (autoIT.winExists(title)) {
					autoIT.controlClick(title, "", "[CLASS:Button; INSTANCE:1]");
					autoIT.controlClick(title, "", "[CLASS:Button; INSTANCE:2]");

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public double formatNumber(String num){
		if(num.contains("("))
			num = num.substring(1, num.length()-1);
		
		if(num.contains(")"))
			num = num.substring(0, num.length()-2);
		
		if(num.contains("$"))
			num = num.substring(1, num.length()-1);
		
		if(num.contains(","))
		{
			String arr2[] = num.split(",");
			num = arr2[0]+arr2[1];
		}
		double dbtmp = Double.parseDouble(num);
		return dbtmp;
	}

	/**
	 * get current day
	 * @return
	 */
	public int getCurrentDayOfWeek()
	{
		DateTime now = DateTime.now();
		
		String dateOfWeek = Common.getCommon().getDayOfWeek(now.getDayOfMonth(), now.getMonthOfYear(), now.getYear());
		//check year
		int dayminus = 0;
		if(dateOfWeek.toLowerCase().equals("saturday")){
			dayminus = 1;
		}else if(dateOfWeek.toLowerCase().equals("sunday")){
			dayminus = 2;
		}
		
		return getCurrentDayWithMinusDays(dayminus);
	}
	
	/**
	 * get current month
	 * @return
	 */
	public int getCurrentMonthOfWeek() {
		DateTime now = DateTime.now();
		String dateOfWeek = Common.getCommon().getDayOfWeek(now.getDayOfMonth(), now.getMonthOfYear(), now.getYear());
		//check year
		int dayminus = 0;
		if(dateOfWeek.toLowerCase().equals("saturday")){
			dayminus = 1;
		}else if(dateOfWeek.toLowerCase().equals("sunday")){
			dayminus = 2;
		}
		return getCurrentMonthWitMinusDays(dayminus);
	}
	
	/**
	 * get current year
	 * @return
	 */
	public int getCurrentYearOfWeek() {
		DateTime now = DateTime.now();
		String dateOfWeek = Common.getCommon().getDayOfWeek(now.getDayOfMonth(), now.getMonthOfYear(), now.getYear());
		//check year
		int dayminus = 0;
		if(dateOfWeek.toLowerCase().equals("saturday")){
			dayminus = 1;
		}else if(dateOfWeek.toLowerCase().equals("sunday")){
			dayminus = 2;
		}
		
		return getCurrentYearWithMinusDays(dayminus);
	}
	
	/**
	 * get current day with plus day
	 * @param days
	 * @return day
	 */
	public int getCurrentDayWithMinusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.minusDays(days).getDayOfMonth();
	}
	
	/**
	 * get month when current day plus days
	 * @param days
	 * @return
	 */
	public int getCurrentMonthWitMinusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.minusDays(days).getMonthOfYear();
	}
	/**
	 * get year when current day plus days
	 * @param days
	 * @return
	 */
	public int getCurrentYearWithMinusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.minusDays(days).getYear();
	}
	
	private final Stack<String> openWindowHandles = new Stack<String>();

	private Common() {
	}

	public static String en = "";
	private String logOutLink = "";
	private static Common instance = null;
	// private Screen screen = new Screen();
	// private DesktopKeyboard keyboard = new DesktopKeyboard();
};
