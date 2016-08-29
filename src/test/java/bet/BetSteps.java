package bet;

import java.util.logging.Logger;

import bet.application.NavigationFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

/*
 * This class implements the steps specified with the cucumber sintax
 * it wires up the actions with the navigation flow
 */

public class BetSteps {
	private static final Logger LOGGER = Logger.getLogger(BetSteps.class.getName());
	private static boolean m_mobile = false;
	
	@Given("^I am logged in into portal as (.+)$")
	public void given_I_am_logged_in_into_portal_as(String platform){
		if(platform.equalsIgnoreCase(new String("mobile"))){
			m_mobile = true;
		}
		LOGGER.info("given_I_am_logged_in_into_portal_as_" + platform);
		NavigationFactory.getNavigator(m_mobile).given_I_am_logged_in_into_portal();
	}
	
	@When("^I select premiership football category$")
    public void when_i_select_premiership_football_category(){
		LOGGER.info("when_i_select_premiership_football_category()");
		NavigationFactory.getNavigator(m_mobile).when_i_select_premiership_football_category();
	}
		
    @When("^I select first home bet$")
    public void when_i_select_first_home_bet(){
		LOGGER.info("when_i_select_first_home_bet()");
		NavigationFactory.getNavigator(m_mobile).when_i_select_first_home_bet();
    }
    
    @When("^I place a £(.+) bet$")
    public void when_i_place_a_bet(String amount){
		LOGGER.info("when_i_place_a_bet("+ amount +")");
		NavigationFactory.getNavigator(m_mobile).when_i_place_a_bet(amount);
    }
    
	@Then("^The bet is (.+) placed$")
	public void then_The_bet_is_placed(String outcome){
		LOGGER.info("then_The_bet_is_placed("+ outcome +")");
		NavigationFactory.getNavigator(m_mobile).then_The_bet_is_placed(outcome);		
	}
	
	@Then("^I logout$")
	public void then_I_logout(){
		LOGGER.info("then_I_logout()");
		NavigationFactory.getNavigator(m_mobile).then_I_logout();
	}
}
