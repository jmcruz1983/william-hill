package bet.application.containers;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;

/*
 * This class contains all the webElements needed in the home page
 * WebElemets are located by Xpath when possible and i do lookup when elements have dynamic ids
 * HomePage container is decouple from the view to allow changes in page outlook
 * without affecting page flow
 */

public class HomePageContainer {
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"balanceLink\"]")
    public WebElement balance;	

	@FindBy(how=How.XPATH, xpath ="//*[@id=\"carousel\"]/div/ul/li[2]/a")
    public WebElement footballCategory;	
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"betslip-btn-toolbar\"]/a")
    public WebElement betSlip;

	@FindBy(how=How.XPATH, xpath ="//*[@id=\"betslip-section\"]")
    public WebElement betSlipSection;
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"place-bet-button\"]")
    public WebElement betButton;
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"receipt-notice-box\"]")
    public WebElement successNoticeBox;
	
	@FindBy(how=How.XPATH, xpath ="//*[@id=\"error-box-header\"]")
    public WebElement failedNoticeBox;
	
 	@FindBy(how=How.XPATH, xpath ="//*[@id=\"match-highlights\"]/div/div[1]/section")
    public WebElement betsTable;
 	
    public WebElement firstHomeBet;
 	
 	public WebElement getFirstHomeBet(WebElement element){
 		/* Seems that listings the divs contained in the table of bets
 		 * the FIRST home bet is the element in the position 11
 		 */
 		List<WebElement> divs = element.findElements(By.xpath(".//div"));
 		if(divs.size() > 0){
	 		firstHomeBet = divs.get(11);
	 		return firstHomeBet; 
 		}
 		return element;
 	}

 	@FindBy(how=How.XPATH, xpath ="//*[@id=\"bets-container-singles\"]")
    public WebElement betsContainer;

    public WebElement betAmountInput;
 	
 	public WebElement getBetAmountInput(WebElement element){
 		/* Getting the amount input to place the bet
 		 * that appears to be the number 2
 		 */
 		List<WebElement> inputs = element.findElements(By.xpath(".//input"));
 		if(inputs.size() > 0){
 			betAmountInput = inputs.get(1);
	 	 	return betAmountInput; 
 		}
 		return element; 
 	}
}

