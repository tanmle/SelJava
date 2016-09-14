package page;

import org.openqa.selenium.WebDriver;
import HearingFusion.Interfaces;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	
	/**
	 * type user name
	 * @param username
	 */
	public void typeUsername(String username) {
		waitForControl(driver, Interfaces.LoginPage.USERNAME_TEXTBOX, timeWait);
		type(driver,Interfaces.LoginPage.USERNAME_TEXTBOX, username);
	}
	
	/**
	 * type password
	 * @param password
	 */
	public void typePassword(String password) {
		waitForControl(driver, Interfaces.LoginPage.PASSWORD_TEXTBOX, timeWait);
		type(driver,Interfaces.LoginPage.PASSWORD_TEXTBOX, password);
	}
	
	/**
	 * type organization
	 * @param organization
	 */
	public void typeOrganization(String organization) {
		waitForControl(driver, Interfaces.LoginPage.ORGANIZATION_TEXTBOX, timeWait);
		sleep(1);
		type(driver,Interfaces.LoginPage.ORGANIZATION_TEXTBOX, organization);
	}

	/**
	 * Click on Submit button
	 */
	public void clickLoginButton() {
		waitForControl(driver, Interfaces.LoginPage.LOGIN_BUTTON, timeWait);
		click(driver,Interfaces.LoginPage.LOGIN_BUTTON);
		sleep();
	}
	
	/**
	 * select Remember Account Checkbox
	 */
	public void selectRememberAccountCheckbox(boolean rememberAccount) {
		waitForControl(driver, Interfaces.LoginPage.REMEMBER_ACCOUNT_CHECKBOX, timeWait);
		String checkedValue = getAttributeValue(driver, Interfaces.LoginPage.REMEMBER_ACCOUNT_CHECKBOX, "checked");
		if(rememberAccount){
			if(checkedValue==null){
				click(driver, Interfaces.LoginPage.REMEMBER_ACCOUNT_CHECKBOX);
				sleep(1);
			}
		}else{
			if(checkedValue!=null){
				click(driver, Interfaces.LoginPage.REMEMBER_ACCOUNT_CHECKBOX);
				sleep(1);
			}
		}
	}
	
	/**
	 * login website with user organization, name and password
	 * @return Schedule page
	 */
	public SchedulePage login(String organization, String username, String password, boolean rememberAccount)
	{
		typeOrganization(organization);
		typeUsername(username);
		typePassword(password);
		selectRememberAccountCheckbox(rememberAccount);
		clickLoginButton();
		return PageFactory.getSchedulePage(driver, ipClient);
	}

	/**
	 * check error message display with text on login page
	 */
	public boolean isInvalidUsernamePasswordMessageDisplayWithText(String textContent)
	{
		waitForControl(driver, Interfaces.LoginPage.DYNAMIC_LOGIN_ERROR_MESSAGE, textContent, timeWait);
		return isControlDisplayed(driver, Interfaces.LoginPage.DYNAMIC_LOGIN_ERROR_MESSAGE, textContent);
	}
	
	/**
	 * check Organization Field is Saved
	 */
	public boolean isOrganizationFieldSaved(String expectedOrganization)
	{
		waitForControl(driver, Interfaces.LoginPage.ORGANIZATION_TEXTBOX, timeWait);
		String actualOrganization = getAttributeValue(driver, Interfaces.LoginPage.ORGANIZATION_TEXTBOX, "value");
		if(actualOrganization.equals(expectedOrganization)){
			return true;
		}
		else return false;
	}
	
	/**
	 * check Username Field is Saved
	 */
	public boolean isUsernameFieldSaved(String expectedUsername)
	{
		waitForControl(driver, Interfaces.LoginPage.USERNAME_TEXTBOX, timeWait);
		String actualUsername = getAttributeValue(driver, Interfaces.LoginPage.USERNAME_TEXTBOX, "value");
		if(actualUsername.equals(expectedUsername)){
			return true;
		}
		else return false;
	}
	
	/**
	 * click On About Hearing Fusion Link
	 */
	public void clickOnAboutHearingFusionLink()
	{
		waitForControl(driver, Interfaces.LoginPage.ABOUT_HEARING_FUNSION_LINK, timeWait);
		click(driver, Interfaces.LoginPage.ABOUT_HEARING_FUNSION_LINK);
	}
	
	/**
	 * click On Corporate Link
	 */
	public void clickOnCorporateLink()
	{
		waitForControl(driver, Interfaces.LoginPage.CORPORATE_LINK, timeWait);
		click(driver, Interfaces.LoginPage.CORPORATE_LINK);
	}
	
	/**
	 * click On Privacy Link
	 */
	public void clickOnPrivacyLink()
	{
		waitForControl(driver, Interfaces.LoginPage.PRIVACY_LINK, timeWait);
		click(driver, Interfaces.LoginPage.PRIVACY_LINK);
	}
	
	/**
	 * click On Contact Link
	 */
	public void clickOnContactLink()
	{
		waitForControl(driver, Interfaces.LoginPage.CONTACT_LINK, timeWait);
		click(driver, Interfaces.LoginPage.CONTACT_LINK);
	}
	
	/**
	 * check Title Text Of Page Display
	 */
	public boolean isTitleTextOfPageDisplay(String textTitlePage)
	{
		waitForControl(driver, Interfaces.LoginPage.DYNAMIC_TITLE_PAGE_TEXT, textTitlePage, 5);
		return isControlDisplayed(driver, Interfaces.LoginPage.DYNAMIC_TITLE_PAGE_TEXT, textTitlePage);
	}
	
	private WebDriver driver;
	private String ipClient;
}
