package bet.application;

public class Users {
	public static User createValidUser(){
		User user = new User();
		user.withUserName("WHATA_FOG1").withPassword("F0gUaTtest");
		return user;
	}
	
	public static User createInvalidUser(){
		User user = new User();
		user.withUserName("").withPassword("");
		return user;
	}
}
