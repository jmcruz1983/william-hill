package bet.application.view;

import java.io.IOException;
import bet.utils.BrowserDriver;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import org.openqa.selenium.support.PageFactory;
import bet.application.containers.LoginPageContainer;

/*
 * This class implements the navigation in the loginPage
 * obtaining the webelements from the container class
 * decoupling design from navigation
 */

public class LoginView {
	private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());
	private static final LoginPageContainer loginContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginPageContainer.class);
	
	public static void loginIntoPortal(String username, String password){
		LOGGER.info("Loging-in into portal");
		//Opening login menu
		BrowserDriver.waitForElement(loginContainer.loginMenu);
		loginContainer.loginMenu.click();
		//Login menu should be visible
		BrowserDriver.waitForElement(loginContainer.loginPageDiv);
		if(loginContainer.loginPageDiv.isDisplayed()){
			BrowserDriver.waitForElement(loginContainer.usernameInput);
			BrowserDriver.waitForElement(loginContainer.passwordInput);
			loginContainer.usernameInput.clear();
			loginContainer.usernameInput.sendKeys(username);
			loginContainer.passwordInput.clear();
			loginContainer.passwordInput.sendKeys(password);
			loginContainer.submitButton.click();
			if(HomeView.isBalanceDisplayed()){
				LOGGER.info("Succesfully logged-in!");
			}
		}
	}
		
	public static void logout(){
		LOGGER.info("Loging-out");
		//Opening login menu
		BrowserDriver.waitForElement(loginContainer.loginMenu);
		loginContainer.loginMenu.click();
		//Login menu should be visible	
		BrowserDriver.waitForElement(loginContainer.loggedinMenu);
		if(loginContainer.loggedinMenu.isDisplayed()){
			//If logout button is present
			BrowserDriver.waitForElement(loginContainer.logoutButton);
			if(loginContainer.logoutButton.isDisplayed()){
				loginContainer.logoutButton.click();
				LOGGER.info("Logged-out!");
				//Small sleep between logins
				someSleep(2000);
			}
		}
	}
	
	public static void someSleep(int milis){
	try{
		Thread.sleep(2000);
	  }catch(Exception e){
		  System.out.println("IOException has been caught");
	  }
	}
}
