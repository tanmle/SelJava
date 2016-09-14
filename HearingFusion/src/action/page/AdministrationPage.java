package page;

import org.openqa.selenium.WebDriver;

import HearingFusion.Interfaces;

public class AdministrationPage extends AbstractPage {

	public AdministrationPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	/**
	 * Check if Administrator page displays
	 * @return
	 */
	public boolean isAdministrationPagePageDisplays(){
		waitForControl(driver, Interfaces.AdministrationPage.ADMINISTRATION_FORM, timeWait);
		return isControlDisplayed(driver, Interfaces.AdministrationPage.ADMINISTRATION_FORM);
	}
	/**
	 * Click Administrator child link
	 * @param linkName
	 */
	public void clickAdministrationChildLink(String linkName)
	{
		waitForControl(driver, Interfaces.AdministrationPage.DYNAMIC_ADMINISTRATION_CHILD_LINK, linkName,timeWait);
		click(driver, Interfaces.AdministrationPage.DYNAMIC_ADMINISTRATION_CHILD_LINK,linkName);
	}
	/**
	 * Input Administration Office name
	 * @param officeName
	 */
	public void inputAdministrationOfficeName(String officeName)
	{
		waitForControl(driver, Interfaces.AdministrationPage.ADMINISTRATION_OFFICES_NAME, timeWait);
		type(driver, Interfaces.AdministrationPage.ADMINISTRATION_OFFICES_NAME, officeName);
	}
	/**
	 * Click Administration Office Search button
	 */
	public void clickAdministrationOfficeSearchButton()
	{
		waitForControl(driver, Interfaces.AdministrationPage.ADMINISTRATION_OFFICES_SEARCH_BUTTON, timeWait);
		click(driver, Interfaces.AdministrationPage.ADMINISTRATION_OFFICES_SEARCH_BUTTON);
	}
	/**
	 * Click Administration Office Detail link
	 * @param officeName
	 */
	public void clickAdministrationOfficeDetailLink(String officeName)
	{
		waitForControl(driver, Interfaces.AdministrationPage.DYNAMIC_ADMINISTRATION_OFFICES_DETAIL_LINK, officeName,timeWait);
		click(driver, Interfaces.AdministrationPage.DYNAMIC_ADMINISTRATION_OFFICES_DETAIL_LINK, officeName);
	}
	/**
	 * Get Administration Office Promo code
	 * @return
	 */
	public String getAdministrationOfficePromoCode()
	{
		waitForControl(driver, Interfaces.AdministrationPage.ADMINISTRATION_OFFICE_DETAIL_PROMODE_CODE_TEXTBOX, timeWait);
		return getAttributeValue(driver, Interfaces.AdministrationPage.ADMINISTRATION_OFFICE_DETAIL_PROMODE_CODE_TEXTBOX, "value");
	}
	private WebDriver driver;
	private String ipClient;
}