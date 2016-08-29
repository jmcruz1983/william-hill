package bet.application;

/*
 * This is simple User class that implements the creation of a user
 */

public class User {
	private String username;
	private String password;
	
	public User withUserName(String username){
		this.username = username;
		return this;
	}
	
	public String getUsername(){
		return username;
	}
	
	public User withPassword(String password){
		this.password = password;
		return this;
	}
	
	public String getPassword(){
		return password;
	}
	
}
