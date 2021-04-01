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
	public static final String INSERT_NEW_ADDRESS = "INSERT INTO ehotel.address VALUES (?,?,?,?,?,?,?) RETURNING address_id";
	// Customer queries
	public static final String GET_CUSTOMER_FROM_ID = "SELECT * FROM ehotel.customer WHERE customer_id=?";
	public static final String GET_CUSTOMER_FROM_USERNAME = "SELECT * FROM ehotel.customer WHERE username=?";
	public static final String INSERT_NEW_CUSTOMER = "INSERT INTO ehotel.customer VALUES (?,?,?,?,?) RETURNING customer_id";
	// Employee queries
	public static final String GET_EMPLOYEE_FROM_ID = "SELECT * FROM ehotel.employee WHERE employee_id=?"; 
	// Room queries
	public static final String GET_ROOM_FROM_ID = "SELECT * FROM ehotel.room WHERE room_id=?";
	public static final String GET_ALL_AVAIL_ROOMS = "SELECT * FROM ehotel.room WHERE room_id NOT IN (SELECT room_id FROM booking WHERE check_in_date <= CURRENT_DATE AND check_out_date >= CURRENT_DATE)";
	public static final String GET_ROOM_FROM_CUSTOMER = "SELECT * FROM ehotel.room WHERE customer_ssn=?";
	public static final String UPDATE_ROOM_SET_BOOKED = "UPDATE ehotel.room SET customer_ssn=?, room_status='booked' WHERE room_no=?";
	// Hotel queries
	public static final String GET_HOTEL_FROM_ID = "SELECT * FROM ehotel.hotel WHERE hotel_id=?";
	// Hotel Brand queries
	public static final String GET_HOTEL_BRAND_FROM_ID = "SELECT * FROM ehotel.hotel_brand WHERE brand_id=?";
	// Booking queries
	public static final String GET_BOOKED_ROOMS_FOR_CUSTOMER = "SELECT * FROM ehotel.room WHERE room_id IN (SELECT room_id FROM booking WHERE customer_id=? AND check_out_date >= CURRENT_DATE)";
	public static final String CREATE_NEW_BOOKING = "INSERT INTO ehotel.booking VALUES (?,?,?,?,?,?) RETURNING booking_id";
		
	private SQL() {
		throw new AssertionError();
	}
}
