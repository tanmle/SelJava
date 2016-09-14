package page;

import org.openqa.selenium.WebDriver;
import HearingFusion.Interfaces;

public class ReportsPage extends AbstractPage {

	public ReportsPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}

	public boolean isReportPageDisplays(){
		waitForControl(driver, Interfaces.ReportsPage.TABLE_LIST_REPORTS, timeWait);
		return isControlDisplayed(driver, Interfaces.ReportsPage.TABLE_LIST_REPORTS);
	}
	
	private WebDriver driver;
	private String ipClient;
}