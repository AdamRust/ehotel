package eHotel.entities;

public class HotelBrand {
	
	private int brand_id;
    private int address_id;
    private int number_of_hotels;
    private String location;
	// Email and Phone Number stored in separate tables in DB
	private String phone_num;
	private String email;
	private String brand_name;
	
	public HotelBrand() {
		
	}
	
	public HotelBrand(int brand_id, int address_id, int number_of_hotels, String phone_num, String email, String brand_name) {
		this.brand_id = brand_id;
		this.address_id = address_id;
		this.number_of_hotels = number_of_hotels;
		this.phone_num = phone_num;
		this.email = email;
		this.brand_name = brand_name;
	}
	public int getBrandID() {
		return brand_id;
	}
	public void setBrandID(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getAddressID() {
		return address_id;
	}
	public void setAddressID(int address_id) {
		this.address_id = address_id;
	}
	public int getNumberOfHotels() {
		return number_of_hotels;
	}
	public void setNumberOfHotels(int number_of_hotels) {
		this.number_of_hotels = number_of_hotels;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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

	public String getBrandName() {
		return brand_name;
	}

	public void setBrandName(String brand_name) {
		this.brand_name = brand_name;
	}
}
