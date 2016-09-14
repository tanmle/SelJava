package common;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationControl {

	/**
	 * make out By for find element control
	 * @param controlname: name of control 
	 */
	public WebElement findElement(WebDriver driver,String controlName) {
		WebElement element = null;
		element = driver.findElement(By.xpath(controlName));
		return element;
	}

	public WebElement findElement(WebDriver driver, String specialControl,String value) {
		WebElement element = null;
		String control = String.format(specialControl, value);
		element = driver.findElement(By.xpath(control));
		return element;
	}
	
	public WebElement findElement(WebDriver driver, String specialControl,String value1, String value2) {
		WebElement element = null;
		String control = String.format(specialControl, value1, value2);
		element = driver.findElement(By.xpath(control));
		return element;
	}
	
	public WebElement findElement(WebDriver driver, String specialControl,String value1, 
			String value2, String value3) {
		WebElement element = null;
		String control = String.format(specialControl, value1, value2, value3);
		element = driver.findElement(By.xpath(control));
		return element;
	}
	
	public WebElement findElement(WebDriver driver, String specialControl,String value1, String value2,
			String value3, String value4,String value5) {
		WebElement element = null;
		String control = String.format(specialControl, value1, value2, value3, value4, value5);
		element = driver.findElement(By.xpath(control));
		return element;
	}
	public WebElement findElement(WebDriver driver, String specialControl,String value1, String value2,
			String value3, String value4) {
		WebElement element = null;
		String control = String.format(specialControl, value1, value2, value3, value4);
		element = driver.findElement(By.xpath(control));
		return element;
	}
	/**
	 * get by for element
	 * @param driver
	 * @param controlName
	 */
	public By getBy(WebDriver driver,String controlName) {
		By by = null;
		by = By.xpath(controlName);
		return by;
	}
	
	public By getBy(WebDriver driver, String specialControl,String value) {
		By by = null;
		String control = String.format(specialControl, value);
		by = By.xpath(control);
		return by;
	}
	
	public By getBy(WebDriver driver, String specialControl,String value1, String value2) {
		By by = null;
		String control = String.format(specialControl, value1, value2);
		by = By.xpath(control);
		return by;
	}
	
	public By getBy(WebDriver driver, String specialControl,String value1, String value2, String value3) {
		By by = null;
		String control = String.format(specialControl, value1, value2, value3);
		by = By.xpath(control);
		return by;
	}
	
	public By getBy(WebDriver driver, String specialControl,String value1, String value2,
			String value3, String value4, String value5) {
		By by = null;
		String control = String.format(specialControl, value1, value2, value3, value4, value5);
		by = By.xpath(control);
		return by;
	}
	public By getBy(WebDriver driver, String specialControl,String value1, String value2,
			String value3, String value4) {
		By by = null;
		String control = String.format(specialControl, value1, value2, value3, value4);
		by = By.xpath(control);
		return by;
	}
	public List<WebElement> findElements(WebDriver driver,String controlName) {
		List<WebElement> lstElement = null;
		lstElement = driver.findElements(By.xpath(controlName));
		return lstElement;
	}
	
	public List<WebElement> findElements(WebDriver driver,String controlName,String value) {
		List<WebElement> lstElement = null;
		String control = String.format(controlValue, value);
		lstElement = driver.findElements(By.xpath(control));
		return lstElement;
	}
	
	public List<WebElement> findElements(WebDriver driver,String controlName,String value1, String value2) {
		List<WebElement> lstElement = null;
		String control = String.format(controlValue, value1, value2);
		lstElement = driver.findElements(By.xpath(control));
		return lstElement;
	}
	
	public void setControlValue(String controlValue) {
		this.controlValue = controlValue;
	}

	public String getControlValue() {
		return controlValue;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getControlType() {
		return controlType;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	//private static AutomationControl control = null;
	private String page;
	private String controlValue;
	private String controlType;
	protected final Log log = LogFactory.getLog(AutomationControl.class);
}
