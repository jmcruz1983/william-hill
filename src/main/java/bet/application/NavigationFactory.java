package bet.application;

import java.util.logging.Logger;

/*
 * This is a factory class that simpy returns the nagivator to run the page flow
 */

public class NavigationFactory {
	private static final Logger LOGGER = Logger.getLogger(NavigationFactory.class.getName());
	private static Navigation navigator = null;
	
	public static synchronized Navigation getNavigator(boolean mobile){
		if(navigator == null){
			navigator = new Navigation(mobile);
		}
		return navigator;
	}
}