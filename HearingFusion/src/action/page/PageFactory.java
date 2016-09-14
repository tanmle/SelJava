package page;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	
	/**
	 * Get login page
	 * @param driver, ipClient
	 * @return Login page
	 */
	public static LoginPage getLoginPage(WebDriver driver, String ipClient)
	{
		return new LoginPage(driver, ipClient);
	}
	
	/**
	 * Get schedule page
	 * @param driver, ipClient
	 * @return Schedule page
	 */
	public static SchedulePage getSchedulePage(WebDriver driver, String ipClient)
	{
		return new SchedulePage(driver, ipClient);
	}
	
	/**
	 * Get patients page
	 * @param driver, ipClient
	 * @return patients page
	 */
	public static PatientsPage getPatientsPage(WebDriver driver, String ipClient)
	{
		return new PatientsPage(driver, ipClient);
	}
	
	/**
	 * Get Sales page
	 * @param driver, ipClient
	 * @return patients page
	 */
	public static SalesPage getSalesPage(WebDriver driver, String ipClient)
	{
		return new SalesPage(driver, ipClient);
	}
	/**
	 * get Inbox Page
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public static InboxPage getInboxPage(WebDriver driver, String ipClient)
	{
		return new InboxPage(driver, ipClient);
	}
	/**
	 * get Setting sPage
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public static SettingPage getSettingPage(WebDriver driver, String ipClient)
	{
		return new SettingPage(driver, ipClient);
	}
	/**
	 * get Billing sPage
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public static BillingPage getBillingPage(WebDriver driver, String ipClient)
	{
		return new BillingPage(driver, ipClient);
	}
	/**
	 * get Reports sPage
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public static ReportsPage getReportsPage(WebDriver driver, String ipClient)
	{
		return new ReportsPage(driver, ipClient);
	}
	/**
	 * get Administration sPage
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public static AdministrationPage getAdministrationPage(WebDriver driver, String ipClient)
	{
		return new AdministrationPage(driver, ipClient);
	}
	/**
	 * get Inventory sPage
	 * @param driver
	 * @param ipClient
	 * @return
	 */
	public static InventoryPage getInventoryPage(WebDriver driver, String ipClient)
	{
		return new InventoryPage(driver, ipClient);
	}
	
	
}
