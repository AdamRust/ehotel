package eHotel.entities;

public class Employee {
	
	private int employee_id;
	private int hotel_id;
	private int address_id;
	private String first_name;
	private String middle_initial;
	private String last_name;
	private String sin;
	private int salary;
	private String position;
	private int account_id;
	// Email and Phone Number stored in separate tables in DB
	private String phone_num;
	private String email; 
	
	public Employee() {
		
	}
	
	public Employee(int employee_id, int hotel_id, int address_id, String first_name, String middle_initial, 
			String last_name, String sin, int salary, String position, int account_id, String phone_num, String email) {
		this.employee_id = employee_id;
		this.hotel_id = hotel_id;
		this.address_id = address_id;
		this.first_name = first_name;
		this.middle_initial = middle_initial;
		this.last_name = last_name;
		this.sin = sin;
		this.salary = salary;
		this.position = position;
		this.account_id = account_id;
		this.phone_num = phone_num;
		this.email = email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
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
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
