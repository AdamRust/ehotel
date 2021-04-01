package eHotel.entities;

public class Account {
	private String password;
	private String username;
	private int role;

	public Account() {
		
	}
	
	public Account(String username, String password, int role) {
		this.password = password;
		this.username = username;
		this.role = role;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String new_username) {
		this.username = new_username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String new_password) {
		this.password = new_password;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
