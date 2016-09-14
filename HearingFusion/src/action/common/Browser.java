package common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.uncommons.reportng.ReportMetadata;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import config.ProviderConfiguration;

public class Browser {

	public WebDriver getDriver() {
		return driver;
	}
	
	/*
	 * Using with Grid Open browser and navigate to url
	 */
	public WebDriver launch(String browser, String port, String ipClient)  {

		try {
		provider.loadInstance("HearingFusion");
		
		final String url = ProviderConfiguration.getProvider().getInstance().getUrl();
		final String grid = ProviderConfiguration.getProvider().getInstance().getGRID();
		ReportMetadata.link = "AUT url: "+url;	
		
		if(grid.toLowerCase().equals("no"))
		{
			final String driverClass = ProviderConfiguration.getProvider()
					.getSelenium().getDriver();
	
			if (driverClass.equals("FirefoxDriver")) {
				driver = new FirefoxDriver();
			} else {
				if (driverClass.equals("InternetExplorerDriver")) {
					startIEDriver();
					driver = new InternetExplorerDriver();
				} else {
					if(driverClass.equals("ChromeDriver"))
					{
						startChromeDriver();
						driver = new ChromeDriver();
					}					
				}
			}
		}
		else
		{
			DesiredCapabilities capability = null;
			if (browser.equalsIgnoreCase("firefox")) {
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(org.openqa.selenium.Platform.ANY);
			}

			if (browser.equalsIgnoreCase("chrome")) {
				startChromeDriver();
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}
			
			if (browser.equalsIgnoreCase("safari")) {					
				capability = DesiredCapabilities.safari();
				capability.setBrowserName("safari");
				capability.setJavascriptEnabled(true);
				capability.setPlatform(org.openqa.selenium.Platform.MAC);
			}
			try {
				driver = new RemoteWebDriver(
						new URL("http://localhost:4444/wd/hub"), capability);
			} catch (MalformedURLException e) {
				System.out.print(e.getMessage());
			}
		}
		driver.get(url);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		
		return driver;
	}

	public void takeScreenshot(String name) {
		TakesScreenshot view = TakesScreenshot.class.cast(driver);
		File screenshot = view.getScreenshotAs(OutputType.FILE);
		File destination = new File(name + ".png");
		try {
			FileUtils.copyFile(screenshot, destination);
			log.info("Screenshot saved to " + destination.getAbsolutePath());
		} catch (IOException e) {
			log.error(
					"Failed to write screenshot to "
							+ destination.getAbsolutePath(), e);
		}
	}

	public void goHome() {
		open(homeUrl);

	}

	public void open(String url) {
		driver.get(url);
	}

	public void rememberLocation() {
		rememberedUrl = driver.getCurrentUrl();
	}

	public void recallLocation() {
		if (rememberedUrl != null) {
			driver.get(rememberedUrl);
		}
	}

	/**
	 * Close browser
	 */
	public void shutdown() {
		driver.quit();
		// instance=null;
	}

	/**
	 * Start chrome driver
	 */
	public void startChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"..\\HearingFusion\\src\\resource\\chromedriver.exe");		
	}
	
	public void startIEDriver() {
		System.setProperty("webdriver.ie.driver",
				"..\\HearingFusion\\src\\resource\\IEDriverServer.exe");
	}

	public void closeNewWindow() {
		if (openWindowHandles.size() < 1) {
			log.error("Called close new window when only the main browser was open.");
		} else {
			driver.close();
			driver.switchTo().window(openWindowHandles.pop());
		}
	}
	
	private WebDriver driver = null;
	private String homeUrl = null;
	private String rememberedUrl = null;
	private final Stack<String> openWindowHandles = new Stack<String>();
	private static final Log log = LogFactory.getLog(Browser.class);
	private final ProviderConfiguration provider = ProviderConfiguration.getProvider();

}
