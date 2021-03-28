package eHotel.entities;

import java.util.ArrayList;

public class Room {
	
	private int room_id;
	private int hotel_id;
	private int price;
	private int capacity;
	private boolean is_sea_view;
	private boolean is_mountain_view;
	private boolean is_extendible;
	// Amenities stored in separate table
	private ArrayList<Integer> amenities;
	
	public Room() {
		
	}
	
	public Room(int room_id, int hotel_id, int price, int capacity, boolean is_sea_view, boolean is_mountain_view, boolean is_extendible) {
		this.room_id = room_id;
		this.hotel_id = hotel_id;
		this.price = price;
		this.capacity = capacity;
		this.is_sea_view = is_sea_view;
		this.is_mountain_view = is_mountain_view;
		this.is_extendible = is_extendible;
		this.amenities = new ArrayList<Integer>();
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	
	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean getIs_sea_view() {
		return is_sea_view;
	}

	public void setIs_sea_view(boolean is_sea_view) {
		this.is_sea_view = is_sea_view;
	}
	
	public boolean getIs_mountain_view() {
		return is_mountain_view;
	}

	public void setIs_mountain_view(boolean is_mountain_view) {
		this.is_mountain_view = is_mountain_view;
	}
	
	public boolean getIs_extendible() {
		return is_extendible;
	}

	public void setIs_extendible(boolean is_extendible) {
		this.is_extendible = is_extendible;
	}
	
	public ArrayList<Integer> getAmenities() {
		return amenities;
	}

	public void addAmenity(int new_amenity) {
		this.amenities.add(new_amenity);
	}
	
	public void addAmenities(ArrayList<Integer> new_amenities) {
		this.amenities.addAll(new_amenities);
	}
}
