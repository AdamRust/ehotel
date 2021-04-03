package eHotel.util;

/*
 * 
 * Utility class to containt constant strings for SQL operations.
 * 
 */
public final class SQL {
	// Account queries
	public static final String GET_ACCOUNT_FROM_USERNAME = "SELECT * FROM ehotel.account WHERE username=?";
	public static final String INSERT_NEW_ACCOUNT = "INSERT INTO ehotel.account VALUES (?,?,?)";
	// Address queries
	public static final String INSERT_NEW_ADDRESS = "INSERT INTO ehotel.address (street_name,street_number,unit_number,postal_code,city,state,country) VALUES (?,?,?,?,?,?,?)";
	// Customer queries
	public static final String GET_CUSTOMER_FROM_ID = "SELECT * FROM ehotel.customer WHERE customer_id=?";
	public static final String GET_CUSTOMER_FROM_USERNAME = "SELECT * FROM ehotel.customer WHERE username=?";
	public static final String INSERT_NEW_CUSTOMER = "INSERT INTO ehotel.customer (address_id,first_name,middle_initial,last_name,sin,registration_date,username) VALUES (?,?,?,?,?,?,?)";
	// Employee queries
	public static final String GET_EMPLOYEE_FROM_ID = "SELECT * FROM ehotel.employee WHERE employee_id=?";
	public static final String GET_EMPLOYEE_FROM_USERNAME = "SELECT * FROM ehotel.employee WHERE username=?"; 
	// Room queries
	public static final String GET_ROOM_FROM_ID = "SELECT * FROM ehotel.room WHERE room_id=?";
	public static final String GET_ALL_AVAIL_ROOMS = "SELECT * FROM ehotel.room WHERE room_id NOT IN (SELECT room_id FROM ehotel.booking WHERE check_in_date <= CURRENT_DATE AND check_out_date >= CURRENT_DATE)";
	// Hotel queries
	public static final String GET_HOTEL_FROM_ID = "SELECT * FROM ehotel.hotel WHERE hotel_id=?";
	// Hotel Brand queries
	public static final String GET_HOTEL_BRAND_FROM_ID = "SELECT * FROM ehotel.hotel_brand WHERE brand_id=?";
	// Booking queries
	public static final String GET_BOOKED_ROOMS_FOR_CUSTOMER = "SELECT * FROM ehotel.room WHERE room_id IN (SELECT room_id FROM ehotel.booking WHERE customer_id=? AND check_out_date >= CURRENT_DATE)";
	public static final String CREATE_NEW_BOOKING = "INSERT INTO ehotel.booking (customer_id,room_id,booking_date,check_in_date,check_out_date,number_of_occupants,brand_id) VALUES (?,?,?,?,?,?,?)";
	public static final String GET_ALL_BOOKINGS = "SELECT * FROM ehotel.booking";
	public static final String GET_BOOKING_FROM_ID = "SELECT * FROM ehotel.booking WHERE booking_id=?";
	// Rental queries
	public static final String CREATE_NEW_RENTAL = "INSERT INTO ehotel.rental (rental_date, booking_id, credit_card_name, credit_card_number, credit_card_cvv, credit_card_expiry_date) VALUES (?,?,?,?,?,?)";
	
	private SQL() {
		throw new AssertionError();
	}
}
