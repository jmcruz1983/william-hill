package bet.application;

import bet.application.view.LoginView;
import bet.application.view.HomeView;
import bet.utils.BrowserDriver;

public class Navigation {
	private User user;
	private BrowserDriver m_driver;
	private boolean m_mobile;
	
	public Navigation( boolean mobile) {
		m_mobile = mobile;
		m_driver = new BrowserDriver(m_mobile);
	}

	public void given_I_am_logged_in_into_portal(){
		BrowserDriver.loadPage("http://sports.williamhill.com/sr-admin-set-white-list-cookie.html");
		user = Users.createValidUser();
		LoginView.loginIntoPortal(user.getUsername(), user.getPassword());
	}
	
	public void when_i_select_premiership_football_category(){	
		HomeView.selectPremiershipFootballCategory();
	}
	
	public void when_i_select_first_home_bet(){
		HomeView.selectFirstHomeBet();
	}
	
	public void when_i_place_a_bet(String amount){
		HomeView.placeaBet(amount);
	}
	
	public void then_The_bet_is_placed(String outcome){
		HomeView.validatePlacedBet(outcome);
	}

	public void then_I_logout(){
		LoginView.logout();
	}
}
