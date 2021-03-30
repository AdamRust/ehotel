package eHotel.entities;

public class Account {
	private int account_id;
	private String password;
	private String username;
	private int role;

	public Account() {
		
	}
	
	public Account(int account_id, String password, String username, int role) {
		this.account_id = account_id;
		this.password = password;
		this.username = username;
		this.role = role;
	}
	
	public int getAccountID() {
		return this.account_id;
	}
	public void setAccountID(int new_account_id) {
		this.account_id = new_account_id;
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
