package bet.application.view;

import java.util.logging.Logger;
import bet.utils.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import bet.application.containers.HomePageContainer;

/*
 * This class implements the navigation in the homePage
 * obtaining the webelements from the container class 
 * decoupling design from navigation
 */

public class HomeView {
	private static final Logger LOGGER = Logger.getLogger(HomeView.class.getName());
	private static final HomePageContainer homePageContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomePageContainer.class);
	
	public static boolean isBalanceDisplayed(){
		LOGGER.info("Checking if balance is displayed");
		BrowserDriver.waitForElement(homePageContainer.balance);
		return homePageContainer.balance.isDisplayed();
	}
	
	public static void selectPremiershipFootballCategory(){
		LOGGER.info("Selecting premiership football category");
		BrowserDriver.waitForElement(homePageContainer.footballCategory);
		if(homePageContainer.footballCategory.isDisplayed()){
			homePageContainer.footballCategory.click();
		}
	}
	
	public static void selectFirstHomeBet(){
		LOGGER.info("Selecting first home bet");
		BrowserDriver.waitForElement(homePageContainer.betsTable);
		homePageContainer.getFirstHomeBet(homePageContainer.betsTable);
		BrowserDriver.waitForElement(homePageContainer.firstHomeBet);
		if(homePageContainer.firstHomeBet.isDisplayed()){
			homePageContainer.firstHomeBet.click();
		}
	}

	public static void placeaBet(String amount){
		LOGGER.info("Placing a £" + amount + " bet");
		//First to press the betSlip button
		BrowserDriver.waitForElement(homePageContainer.betSlip);
		if(homePageContainer.betSlip.isDisplayed()){
			homePageContainer.betSlip.click();
			//Now betSlip section should be displayed
			BrowserDriver.waitForElement(homePageContainer.betSlipSection);
			if(homePageContainer.betSlipSection.isDisplayed()){
				//Enter the amount and place the bet
				BrowserDriver.waitForElement(homePageContainer.betsContainer);
				homePageContainer.getBetAmountInput(homePageContainer.betsContainer);
				BrowserDriver.waitForElement(homePageContainer.betAmountInput);
				if(homePageContainer.betAmountInput.isDisplayed() && 
						homePageContainer.betButton.isDisplayed()){
					homePageContainer.betAmountInput.sendKeys(amount);
					homePageContainer.betButton.click();
					LOGGER.info("Placed a £" + amount + " bet");
				}
			}			
		}
	}
		
	public static void validatePlacedBet(String outcome){
		LOGGER.info("Validating the " + outcome + " bet");
		if(outcome.equalsIgnoreCase(new String("successfully"))){
			BrowserDriver.waitForElement(homePageContainer.successNoticeBox);
			homePageContainer.failedNoticeBox.isDisplayed();
			LOGGER.info("Bet is successfully placed!");
		}else{
			BrowserDriver.waitForElement(homePageContainer.failedNoticeBox);
			homePageContainer.failedNoticeBox.isDisplayed();
			LOGGER.info("Failed to place the bet!");
		}
		//Close betSlip section
		BrowserDriver.waitForElement(homePageContainer.betSlip);
		if(homePageContainer.betSlip.isDisplayed()){
			homePageContainer.betSlip.click();
		}
	}
}
