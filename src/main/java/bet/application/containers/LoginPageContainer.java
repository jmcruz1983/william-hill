package bet.application.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;

/*
 * This class contains all the webElements needed in the login page
 * WebElemets are located by Xpath as they have static identification
 * LoginPage container is decouple from the view to allow changes in page outlook
 * without affecting page flow
 */

public class LoginPageContainer {
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"header\"]/section/div[1]")
    public WebElement loginMenu;	
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"not-logged\"]")
    public WebElement loginPageDiv;

	@FindBy(how=How.XPATH, xpath ="//*[@id=\"account\"]/fieldset[1]/div[1]/input[1]")
    public WebElement usernameInput;

	@FindBy(how=How.XPATH, xpath ="//*[@id=\"account\"]/fieldset[1]/div[1]/input[2]")
    public WebElement passwordInput;

	@FindBy(how=How.XPATH, xpath ="//*[@id=\"account\"]/fieldset[1]/div[1]/button")
	public WebElement submitButton;
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"account-section\"]/section")
	public WebElement loggedinMenu;
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"logoutLink\"]")
    public WebElement logoutButton;
}