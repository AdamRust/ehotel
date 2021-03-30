package eHotel.entities;

public class Customer {
	
	private int customer_id;
	private int address_id;
	private String first_name;
	private String middle_initial;
	private String last_name;
	private String sin;
	private String registration_date;
	private int account_id;
	
	public Customer() {
		
	}
	
	public Customer(int customer_id, int address_id, String first_name, String middle_initial,
			String last_name, String sin, String registration_date, int account_id) {
		this.customer_id = customer_id;
		this.address_id = address_id;
		this.first_name = first_name;
		this.middle_initial = middle_initial;
		this.last_name = last_name;
		this.sin = sin;
		this.registration_date = registration_date;
		this.account_id = account_id;
	}

	public int getCustomerID() {
		return customer_id;
	}

	public void setCustomerID(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getAddressID() {
		return address_id;
	}

	public void setAddressID(int address_id) {
		this.address_id = address_id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getMiddleInitial() {
		return middle_initial;
	}

	public void setMiddleInitial(String middle_initial) {
		this.middle_initial = middle_initial;
	}
	
	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}
	
	public String getRegistrationDate() {
		return registration_date;
	}

	public void setRegistrationDate(String registration_date) {
		this.registration_date = registration_date;
	}
	
	public int getAccountID() {
		return account_id;
	}

	public void setAccountID(int account_id) {
		this.account_id = account_id;
	}
}
