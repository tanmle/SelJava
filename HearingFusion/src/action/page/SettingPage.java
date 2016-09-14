package page;

import org.openqa.selenium.WebDriver;
import HearingFusion.Interfaces;

public class SettingPage extends AbstractPage {

	public SettingPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	/**
	 * check Setting Default Displays Correct
	 * @param st
	 * @param value
	 * @return
	 */
	public boolean isSettingDefaultDisplaysCorrect(String st, String value){
		String tmp = getText(driver, Interfaces.SettingPage.SETTING_ITEM_VALUE_SELECTED, st);
		if(tmp.equals(value))
			return true;
		else 
			return false;
	}
	private WebDriver driver;
	private String ipClient;
}