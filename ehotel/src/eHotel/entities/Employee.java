package eHotel.entities;

public class Employee {
	
	private int employee_id; // Primary Key
	private int hotel_id;
	private int address_id;
	private String first_name;
	private String middle_initial;
	private String last_name;
	private String sin;
	private int salary;
	private String position;
	private String username;
	// Email and Phone Number stored in separate tables in DB
	private String phone_num;
	private String email; 
	
	public Employee() {
		
	}
	
	public Employee(int employee_id, int hotel_id, int address_id, String first_name, String middle_initial, 
			String last_name, String sin, int salary, String position, String username, String phone_num, String email) {
		this.employee_id = employee_id;
		this.hotel_id = hotel_id;
		this.address_id = address_id;
		this.first_name = first_name;
		this.middle_initial = middle_initial;
		this.last_name = last_name;
		this.sin = sin;
		this.salary = salary;
		this.position = position;
		this.username = username;
		this.phone_num = phone_num;
		this.email = email;
	}

	public int getEmployeeID() {
		return employee_id;
	}

	public void setEmployeeID(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getHotelID() {
		return hotel_id;
	}

	public void setHotelID(int hotel_id) {
		this.hotel_id = hotel_id;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNum() {
		return phone_num;
	}

	public void setPhoneNum(String phone_num) {
		this.phone_num = phone_num;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
