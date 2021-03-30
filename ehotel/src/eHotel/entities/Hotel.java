package eHotel.entities;

public class Hotel {
	
	private int hotel_id;
    private int brand_id;
    private int manager_id;
    private int address_id;
    private int star_category;
	// Email and Phone Number stored in separate tables in DB
	private String phone_num;
	private String email;
	
	public Hotel() {
		
	}
	
	public Hotel(int hotel_id, int brand_id, int manager_id, int address_id, int star_category, String phone_num, String email) {
		this.hotel_id = hotel_id;
		this.brand_id = brand_id;
		this.manager_id = manager_id;
		this.address_id = address_id;
		this.star_category = star_category;
		this.phone_num = phone_num;
		this.email = email;
	}
	
	public int getHotelID() {
		return hotel_id;
	}
	public void setHotelID(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getBrandID() {
		return brand_id;
	}
	public void setBrandID(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getManagerID() {
		return manager_id;
	}
	public void setManagerID(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getAddressID() {
		return address_id;
	}
	public void setAddressID(int address_id) {
		this.address_id = address_id;
	}
	public int getStarCategory() {
		return star_category;
	}
	public void setStarCategory(int star_category) {
		this.star_category = star_category;
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
