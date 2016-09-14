package page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import HearingFusion.Interfaces;
import common.AutomationControl;
import common.Common;

public class AbstractPage {

	/**
	 * Refresh a page
	 */
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
		sleep();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	/**
	 * get title of page
	 * 
	 * @return
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	/**
	 * Check control displayed
	 * 
	 * @param by
	 *            : By: id, name, xpath...
	 * @return
	 */
	public boolean isControlDisplayed(WebDriver driver, String controlName) {
		try {
			element = control.findElement(driver, controlName);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * check control is displayed
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return
	 */
	public boolean isControlDisplayed(WebDriver driver, String controlName,
			String value) {
		try {
			element = control.findElement(driver, controlName, value);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * check control is displayed
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return
	 */
	public boolean isControlDisplayed(WebDriver driver, String controlName,
			String value1, String value2) {
		try {
			element = control.findElement(driver, controlName, value1, value2);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * check control is displayed
	 */
	public boolean isControlDisplayed(WebDriver driver, String controlName,
			String value1, String value2, String value3) {
		try {
			element = control.findElement(driver, controlName, value1, value2, value3);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * check control is displayed
	 */
	public boolean isControlDisplayed(WebDriver driver, String controlName,
			String value1, String value2, String value3, String value4, String value5) {
		try {
			element = control.findElement(driver, controlName, value1, value2, value3,
					value4, value5);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * check control is displayed
	 */
	public boolean isControlDisplayed(WebDriver driver, String controlName,
			String value1, String value2, String value3, String value4) {
		try {
			element = control.findElement(driver, controlName, value1, value2, value3,
					value4);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * check control is selected
	 * 
	 * @param driver
	 * @param controlName
	 * @return
	 */
	public boolean isControlSelected(WebDriver driver, String controlName) {
		try {
			element = control.findElement(driver, controlName);
			return element.isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * check control is selected
	 * 
	 * @param driver
	 * @param controlName
	 * @return
	 */
	public boolean isControlSelected(WebDriver driver, String controlName,
			String value) {
		try {
			element = control.findElement(driver, controlName, value);
			return element.isSelected();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check control enabled
	 * 
	 * @param controlName
	 * @return
	 */
	public boolean isControlEnabled(WebDriver driver, String controlName) {
		try {
			element = control.findElement(driver, controlName);
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Wait for control is displayed
	 * 
	 * @param by
	 *            : By:id,name,xpath...
	 * @param timeout
	 */
	public void waitForControl(WebDriver driver, final String controlName,
			long timeout) {
		try {
			By by = control.getBy(driver, controlName);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}

	/**
	 * Wait for control is displayed
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @param timeout
	 */
	public void waitForControl(WebDriver driver, final String controlName,
			final String value, long timeout) {
		try {
			By by = control.getBy(driver, controlName, value);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}

	/**
	 * Wait for control is displayed
	 * 
	 * @param driver
	 * @param controlName
	 * @param value1
	 * @param value2
	 * @param timeout
	 */
	public void waitForControl(WebDriver driver, final String controlName,
			final String value1, final String value2, long timeout) {
		try {
			By by = control.getBy(driver, controlName, value1, value2);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}
	
	/**
	 * Wait for control is displayed
	 */
	public void waitForControl(WebDriver driver, final String controlName,
			final String value1, final String value2, final String value3, long timeout) {
		try {
			By by = control.getBy(driver, controlName, value1, value2, value3);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}
	
	/**
	 * Wait for control is displayed
	 */
	public void waitForControl(WebDriver driver, final String controlName,
			final String value1, final String value2, final String value3, final String value4,
			final String value5, long timeout) {
		try {
			By by = control.getBy(driver, controlName, value1, value2, value3, value4, value5);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}
	/**
	 * Wait for control is displayed
	 */
	public void waitForControl(WebDriver driver, final String controlName,
			final String value1, final String value2, final String value3, final String value4, long timeout) {
		try {
			By by = control.getBy(driver, controlName, value1, value2, value3, value4);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Element doesn't exist");
		}
	}
	/**
	 * Wait for control is closed
	 * 
	 * @param by
	 * @param timeout
	 */
	public void waitForControlNotDisplayed(WebDriver driver,
			final String controlName, long timeout) {
		try {
			By by = control.getBy(driver, controlName);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Control does not close");
		}
	}

	/**
	 * Wait for control is closed
	 * 
	 * @param by
	 * @param timeout
	 */
	public void waitForControlNotDisplayed(WebDriver driver,
			final String controlName, final String value, long timeout) {
		try {
			By by = control.getBy(driver, controlName, value);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			log.debug("Control does not close");
		}
	}

	/**
	 * Close dialog download because web driver does not capture or use hot key.
	 * 
	 * @param keyEvent
	 */
	public void keyPressing(String keyEvent) {
		try {
			Robot robot = new Robot();
			if (keyEvent == "esc") {
				robot.keyPress(KeyEvent.VK_ESCAPE);
			}
			if (keyEvent == "enter") {
				robot.keyPress(KeyEvent.VK_ENTER);
			}
			if (keyEvent == "tab") {
				robot.keyPress(KeyEvent.VK_TAB);
			}
			if (keyEvent == "window_q") {
				robot.keyPress(KeyEvent.VK_WINDOWS);
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_WINDOWS);
				robot.keyRelease(KeyEvent.VK_Q);
			}
		} catch (AWTException e) {
			log.debug("Can not use Key");
		}

	}

	/**
	 * get attribute of element
	 * 
	 * @param controlName
	 * @param attribute
	 * @return
	 */
	public String getAttributeValue(WebDriver driver, String controlName,
			String attribute) {
		waitForControl(driver, controlName, timeWait);
		element = control.findElement(driver, controlName);
		return element.getAttribute(attribute);
	}

	/**
	 * get attribute of element
	 * 
	 * @param controlName
	 * @param attribute
	 * @return
	 */
	public String getAttributeValue(WebDriver driver, String controlName,
			String value, String attribute) {
		waitForControl(driver, controlName, value, timeWait);
		element = control.findElement(driver, controlName, value);
		return element.getAttribute(attribute);
	}

	public String getAttributeValue(WebDriver driver, String controlName,	String value1, String value2, String attribute) {
		waitForControl(driver, controlName, value1, value2, timeWait);
		element = control.findElement(driver, controlName, value1, value2);
		return element.getAttribute(attribute);
	}
	public String getAttributeValue(WebDriver driver, String controlName,	String value1, String value2, String value3, String attribute) {
		waitForControl(driver, controlName, value1, value2, timeWait);
		element = control.findElement(driver, controlName, value1, value2, value3);
		return element.getAttribute(attribute);
	}
	/**
	 * click on element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void click(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		element = control.findElement(driver, controlName);
		element.click();
	}

	/**
	 * click on element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void rightClick(WebDriver driver, String controlName) {
		element = getElement(driver,controlName);
		Actions actions = new Actions(driver);
		Action action = actions.contextClick(element).build();
		action.perform();
	}
	/**
	 * click on element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void rightClick(WebDriver driver, String controlName, String value) {
		element = getElement(driver,controlName,value);
		Actions actions = new Actions(driver);
		Action action = actions.contextClick(element).build();
		action.perform();
	}

	/**
	 * click on element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void click(WebDriver driver, String controlName, String value) {
		waitForControl(driver, controlName, value, timeWait);
		element = control.findElement(driver, controlName, value);
		element.click();
	}

	/**
	 * clear text of control
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void clear(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		element = control.findElement(driver, controlName);
		element.clear();
	}

	/**
	 * click on element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void click(WebDriver driver, String controlName, String value1,
			String value2) {
		waitForControl(driver, controlName, value1, value2, timeWait);
		element = control.findElement(driver, controlName, value1, value2);
		element.click();
	}
	
	public void click(WebDriver driver, String controlName, String value1,
			String value2, String value3, String value4, String value5) {
		waitForControl(driver, controlName, value1, value2, value3, value4, value5, timeWait);
		element = control.findElement(driver, controlName, value1, value2, value3, value4, value5);
		element.click();
	}
	
	public void click(WebDriver driver, String controlName, String value1, String value2, String value3) {
		waitForControl(driver, controlName, value1, value2, value3, timeWait);
		element = control.findElement(driver, controlName, value1, value2, value3);
		element.click();
	}

	/**
	 * enter value for element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 */
	public void type(WebDriver driver, String controlName, String value) {
		waitForControl(driver, controlName, timeWait);
		element = control.findElement(driver, controlName);
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * enter value for element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 */
	public void type(WebDriver driver, String controlName, String value,
			String valueinput) {
		waitForControl(driver, controlName, value, timeWait);
		element = control.findElement(driver, controlName, value);
		sleep(1);
		element.clear();
		sleep(1);
		element.sendKeys(valueinput);
	}

	/**
	 * get element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public WebElement getElement(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		return element;
	}

	/**
	 * get a list element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public List<WebElement> getElements(WebDriver driver, String controlName) {
		return control.findElements(driver, controlName);
	}

	/**
	 * get a list elements
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 */
	public List<WebElement> getElements(WebDriver driver, String controlName,
			String value) {
		return control.findElements(driver, controlName, value);
	}
	
	/**
	 * get a list elements
	 * 
	 * @param driver
	 * @param controlName
	 * @param value1
	 * @param value2
	 */
	public List<WebElement> getElements(WebDriver driver, String controlName,
			String value1, String value2) {
		return control.findElements(driver, controlName, value1, value2);
	}

	/**
	 * get element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public WebElement getElement(WebDriver driver, String controlName,
			String value) {
		element = control.findElement(driver, controlName, value);
		return element;
	}

	/**
	 * get element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public WebElement getElement(WebDriver driver, String controlName,String value1, String value2) {
		element = control.findElement(driver, controlName, value1, value2);
		return element;
	}

	/**
	 * get element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public WebElement getElement(WebDriver driver, String controlName,String value1, String value2, String value3) {
		element = control.findElement(driver, controlName, value1, value2, value3);
		return element;
	}
	/**
	 * press enter
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void pressEnter(WebDriver driver, String controlName, String value) {
		WebElement element = control.findElement(driver, controlName, value);
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * get text of element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public String getText(WebDriver driver, String controlName) {
		try {
			waitForControl(driver, controlName, timeWait);
			WebElement element = control.findElement(driver, controlName);
			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get text of element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return text
	 */
	public String getText(WebDriver driver, String controlName, String value) {
		try {
			waitForControl(driver, controlName, value, timeWait);
			WebElement element = control
					.findElement(driver, controlName, value);
			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * get text of element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value 1
	 * @param value 2
	 * @return text
	 */
	public String getText(WebDriver driver, String controlName, String value1, String value2) {
		try {
			waitForControl(driver, controlName, value1,value2, timeWait);
			WebElement element = control
					.findElement(driver, controlName, value1, value2);
			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * open link
	 * 
	 * @param driver
	 * @param url
	 */
	public void openLink(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * get control href
	 * 
	 * @param driver
	 * @param controlName
	 * @return href
	 */
	public String getControlHref(WebDriver driver, String controlName) {
		return getAttributeValue(driver, controlName, "href");
	}

	/**
	 * get control href
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return href
	 */
	public String getControlHref(WebDriver driver, String controlName,
			String value) {
		waitForControl(driver, controlName, value, timeWait);
		element = control.findElement(driver, controlName, value);
		return element.getAttribute("href");
	}

	/**
	 * count element
	 * 
	 * @param driver
	 * @param controlName
	 * @return number of element
	 */
	public int countElement(WebDriver driver, String controlName) {
		 waitForControl(driver, controlName, timeWait);
		return control.findElements(driver, controlName).size();
	}

	/**
	 * count element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return number of element
	 */
	public int countElement(WebDriver driver, String controlName, String value) {
		waitForControl(driver, controlName, timeWait);
		return control.findElements(driver, controlName, value).size();
	}

	/**
	 * get CSS value of element
	 * 
	 * @param driver
	 * @param controlName
	 * @param css
	 * @return css value
	 */
	public String getCssValue(WebDriver driver, String controlName, String css) {
		element = control.findElement(driver, controlName);
		return element.getCssValue(css);
	}

	/**
	 * get CSS value of element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @param css
	 * @return css value
	 */
	public String getCssValue(WebDriver driver, String controlName,
			String value, String css) {
		waitForControl(driver, controlName, value, timeWait);
		element = control.findElement(driver, controlName, value);
		return element.getCssValue(css);
	}

	
	protected AbstractPage() {
		log = LogFactory.getLog(getClass());
		log.debug("Created page abstraction for " + getClass().getName());
	}

	/**
	 * sleep
	 * 
	 * @param timeout
	 */
	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sleep
	 */
	public void sleep() {
		sleep(timeSleep);
	}

	/**
	 * move mouse to element
	 * 
	 * @param driver
	 * @param controlName
	 */
	public void moveMouseToElement(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, controlName), 156, 20);
		action.build().perform();
	}

	/**
	 * move mouse to element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 */
	public void moveMouseToElement(WebDriver driver, String controlName,
			String value) {
		waitForControl(driver, controlName, value, timeWait);
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, controlName, value));
		action.perform();
	}

	/**
	 * move mouse to element
	 * 
	 * @param driver
	 * @param controlName
	 * @param value1
	 * @param value2
	 */
	public void moveMouseToElement(WebDriver driver, String controlName,
			String value1, String value2) {
		waitForControl(driver, controlName, value1, value2, timeWait);
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, controlName, value1, value2));
		action.perform();
	}

	/**
	 * close browser
	 * 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	/**
	 * execute javascript
	 * 
	 * @param driver
	 * @param javaSript
	 */
	public Object executeJavaScript(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			log.debug(e.getMessage());
			return null;
		}
	}

	/**
	 * get current url of page
	 * 
	 * @param driver
	 * @return
	 */
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * scroll page down
	 * 
	 * @param driver
	 * @author test
	 */
	public void scrollPage(WebDriver driver) {
		executeJavaScript(
				driver,
				"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	/**
	 * scroll page down
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollPage(WebDriver driver, int x, int y) {
		executeJavaScript(driver, "window.scrollTo(" + x + "," + y + ");");
		sleep();
	}

	/**
	 * select item in Combobox
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @param item
	 */
	public void selectItemComboxbox(WebDriver driver, String controlName,
			String value, String item) {
		element = control.findElement(driver, controlName, value);
		Select select = new Select(element);
		select.selectByVisibleText(item);
	}
	/**
	 * select item in Combobox
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @param item
	 */
	public void selectItemComboxbox(WebDriver driver, String controlName, String item) {
		element = control.findElement(driver, controlName);
		Select select = new Select(element);
		select.selectByVisibleText(item);
	}
	/**
	 * get item selected in combobox
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return item
	 */
	public String getItemSelectedCombobox(WebDriver driver, String controlName,
			String value) {
		element = control.findElement(driver, controlName, value);
		Select select = new Select(element);
		String itemSelected = select.getFirstSelectedOption().getText();
		return itemSelected;
	}
	/**
	 * get item selected in combobox
	 * 
	 * @param driver
	 * @param controlName
	 * @param value
	 * @return item
	 */
	public String getItemSelectedCombobox(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		Select select = new Select(element);
		String itemSelected = select.getFirstSelectedOption().getText();
		return itemSelected;
	}
	
	public void dragAndDrop(WebDriver driver, String sourceControl,
			String value1, String value2, String value3, String tagetControl, String value4, String value5) {
		WebElement source = control.findElement(driver, sourceControl, value1, value2, value3);
		sleep();
		WebElement target = control.findElement(driver, tagetControl, value4, value5);
		
		Actions builder = new Actions(driver);
		
//		Action dragAndDrop = builder.clickAndHold(source)
//				.moveToElement(target).release().build();
//		dragAndDrop.perform();
		
		builder.keyDown(Keys.CONTROL).click(source).click(target).keyUp(Keys.CONTROL);
		Action selectMultiple = builder.build();
		selectMultiple.perform(); 
		
	}
	
	/**
	 * goto Schedule page page at any current page
	 */
	public SchedulePage gotoSchedulePage(WebDriver driver, String ipClient) {
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.SCHEDULE_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getSchedulePage(driver, ipClient);
	}
	
	/**
	 * switch To Top Window Frame
	 */
	public WebDriver switchToTopWindowFrame(WebDriver driver) {
		driver = driver.switchTo().defaultContent();
		return driver;
	}
	/**
	 * open Inbox
	 */
	public InboxPage openInbox(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.INBOX_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getInboxPage(driver, ipClient);
	}
	/**
	 * open Setting page
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public SettingPage openSettingPage(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.SETTING_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getSettingPage(driver, ipClient);
	}
	/**
	 * open Patients Page
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public PatientsPage openPatientsPage(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.PATIENT_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getPatientsPage(driver, ipClient);
	}
	/**
	 * open Sales Tab
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public SalesPage openSalesPage(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.SALES_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * open Billing Page
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public BillingPage openBillingPage(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.BILLING_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getBillingPage(driver, ipClient);
	}
	
	/**
	 * open Billing Page
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public InventoryPage openInventoryPage(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.INVENTORY_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getInventoryPage(driver, ipClient);
	}
	
	/**
	 * open Billing Page
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public ReportsPage openReportsPage(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.REPORTS_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getReportsPage(driver, ipClient);
	}
	/**
	 * 
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public AdministrationPage openAdministrationPage(WebDriver driver, String ipClient){
		try {
			String url = "";
			Thread.sleep(2000);
			control.setPage("AbstractPage");
			url = control.findElement(driver,
					Interfaces.AbstractPage.ADMINISTRATION_LINK).getAttribute("href");
			driver.get(url);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return PageFactory.getAdministrationPage(driver, ipClient);
	}
	/**
	 * accept an Alert warning
	 */
	public void acceptAlert(WebDriver driver){
		driver.switchTo().alert().accept();
	}
	
	/**
	 * check checkbox is checked or not
	 * 
	 * @param driver
	 * @param controlName
	 */
	public boolean isCheckboxChecked(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		return element.isSelected();
	}
	
	/**
	 * wait For Download File Completed
	 * 
	 */
	public void waitForDownloadCompleted(String fileName) {
		int i=0;
		while(i<30)
		{
			boolean exist = Common.getCommon().isFileExists(fileName);
			if(exist == true) {
				i = 30;
			}
			sleep(1);
			i=i+1;
		}
	}
	
	/**
	 * delete file
	 * 
	 */
	public void deleteFile(String fileName) {
		if(Common.getCommon().isFileExists(fileName)){
			Common.getCommon().deleteFile(fileName);
		}
	}
	
	/**
	 * check file exist
	 * 
	 */
	public boolean isFileExist(String fileName) {
		waitForDownloadCompleted(fileName);
		if(Common.getCommon().isFileExists(fileName)){
			return true;
		}
		else return false;
	}
	
	protected int timeWait = 20;
	protected int timeSleep = 2;
	protected WebElement element;
	protected AutomationControl control = new AutomationControl();
	protected final Log log;
}
