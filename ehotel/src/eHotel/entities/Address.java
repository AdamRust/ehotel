package eHotel.entities;

public class Address {
	private int address_id;
	private String street_name;
	private String street_number;
	private String unit_number;
	private String postal_code;
	private String city;
	private String state;
	private String country;
	
	public Address() {
		
	}
	
	public Address(int address_id, String street_name, String street_number, String unit_number, String postal_code,
			String city, String state, String country) {
		this.address_id = address_id;
		this.street_name = street_name;
		this.street_number = street_number;
		this.unit_number = unit_number;
		this.postal_code = postal_code;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public int getAddressID() {
		return address_id;
	}
	public void setAddressID(int address_id) {
		this.address_id = address_id;
	}
	public String getStreetName() {
		return street_name;
	}
	public void setStreetName(String street_name) {
		this.street_name = street_name;
	}
	public String getStreetNumber() {
		return street_number;
	}
	public void setStreetNumber(String street_number) {
		this.street_number = street_number;
	}
	public String getUnitNumber() {
		return unit_number;
	}
	public void setUnitNumber(String unit_number) {
		this.unit_number = unit_number;
	}
	public String getPostalCode() {
		return postal_code;
	}
	public void setPostalCode(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
