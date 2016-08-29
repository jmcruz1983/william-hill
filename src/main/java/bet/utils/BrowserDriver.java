package bet.utils;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDriver {
	private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());
	private static WebDriver m_driver;
	private static boolean m_mobile;
	
	public BrowserDriver( boolean mobile) {
		m_mobile = mobile;
	}
		 
	public synchronized static WebDriver getCurrentDriver() {	
		if (m_driver==null) {
			try {
                m_driver = BrowserFactory.getBrowser(m_mobile);
	        } catch (UnreachableBrowserException e) {
	            m_driver = BrowserFactory.getBrowser(m_mobile);
	        } catch (WebDriverException e) {
	            m_driver = BrowserFactory.getBrowser(m_mobile);        
	        }finally{
	        	Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
	        }
		}
        return m_driver;
    }
	
	public static void close() {
        try {
            getCurrentDriver().quit();
            m_driver = null;
            LOGGER.info("closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }
	
	private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }
	
	public static void loadPage(String url){
		getCurrentDriver();
        LOGGER.info("Directing browser to:" + url);
        LOGGER.info("try to loadPage [" + url + "]");
        getCurrentDriver().get(url);
	}
	
	public static WebElement waitForElement(WebElement elementToWaitFor){
		return waitForElement(elementToWaitFor, null);
	}
	
	public static WebElement waitForElement(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
	    if (waitTimeInSeconds == null) {
	    	waitTimeInSeconds = 20;
	    }
	    
	    WebDriverWait wait = new WebDriverWait(getCurrentDriver(), waitTimeInSeconds);
	    return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
	}
}

