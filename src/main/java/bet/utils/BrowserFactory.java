package bet.utils;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import bet.application.NavigationFactory;

public class BrowserFactory {
	private static final Logger LOGGER = Logger.getLogger(BrowserFactory.class.getName());
		
	public static WebDriver getBrowser(boolean mobile) {
		WebDriver driver;
		DesiredCapabilities capabilities;
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		// Creates Mobile or Desktop browser
		if(mobile){
			capabilities = getMobileCapabilities();
		}else{
			capabilities = getDesktopCapabilities();
		}
		driver = new ChromeDriver(capabilities);
        driver.switchTo().window(driver.getWindowHandle());
        driver.manage().window().maximize();
		return driver;
	}

	private static DesiredCapabilities getMobileCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions() {
		{
		    setExperimentalOption("mobileEmulation", new HashMap<String, Object>() {
		    	{ put("deviceName", "Google Nexus 5"); } });
		    }
		});
        return capabilities;
	}

	private static DesiredCapabilities getDesktopCapabilities() {
        return DesiredCapabilities.chrome();
	}
}
