package eHotel.entities;

public class Booking {
	private int booking_id;
	private int customer_id;
	private int room_id;
	// private int hotel_id;
    private String booking_date;
    private String check_in_date;
    private String check_out_date;
    private int number_of_occupants;
    
    public Booking() {
    	
    }
    
	public Booking(int booking_id, int customer_id, int room_id, int hotel_id, String booking_date, String check_in_date,
			String check_out_date, int number_of_occupants) {
		this.booking_id = booking_id;
		this.customer_id = customer_id;
		this.room_id = room_id;
		// this.hotel_id = hotel_id;
		this.booking_date = booking_date;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.number_of_occupants = number_of_occupants;
	}

	public int getBookingID() {
		return booking_id;
	}

	public void setBookingID(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getCustomerID() {
		return customer_id;
	}

	public void setCustomerID(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getRoomID() {
		return room_id;
	}

	public void setRoomID(int room_id) {
		this.room_id = room_id;
	}

//	public int getHotel_id() {
//		return hotel_id;
//	}
//
//	public void setHotel_id(int hotel_id) {
//		this.hotel_id = hotel_id;
//	}

	public String getBookingDate() {
		return booking_date;
	}

	public void setBookingDate(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getCheckInDate() {
		return check_in_date;
	}

	public void setCheckInDate(String check_in_date) {
		this.check_in_date = check_in_date;
	}

	public String getCheckOutDate() {
		return check_out_date;
	}

	public void setCheckOutDate(String check_out_date) {
		this.check_out_date = check_out_date;
	}

	public int getNumberOfOccupants() {
		return number_of_occupants;
	}

	public void setNumberOfOccupants(int number_of_occupants) {
		this.number_of_occupants = number_of_occupants;
	}
	
	
}
