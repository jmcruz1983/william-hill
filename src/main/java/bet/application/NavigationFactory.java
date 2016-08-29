package bet.application;

import java.util.logging.Logger;

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