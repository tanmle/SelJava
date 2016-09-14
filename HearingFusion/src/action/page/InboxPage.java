package page;

import org.openqa.selenium.WebDriver;
import HearingFusion.Interfaces;

public class InboxPage extends AbstractPage {

	public InboxPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	/**
	 * check Inbox Displays
	 * @return
	 */
	public boolean isInboxDisplays(){
		return isControlDisplayed(driver, Interfaces.InboxPage.INBOX_TABLE);
	}
	private WebDriver driver;
	private String ipClient;
}