package eHotel.entities;

public class Customer {
	
	private int customer_id;
	private String address_id;
	private String first_name;
	private String middle_initial;
	private String last_name;
	private String sin;
	private String registration_date;
	private int account_id;
	
	public Customer() {
		
	}
	
	public Customer(int customer_id, String address_id, String first_name, String middle_initial,
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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getMiddle_initial() {
		return middle_initial;
	}

	public void setMiddle_initial(String middle_initial) {
		this.middle_initial = middle_initial;
	}
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}
	
	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
}
