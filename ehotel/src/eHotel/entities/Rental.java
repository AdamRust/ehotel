package eHotel.entities;

public class Rental {
	private int rental_id;
	private String rental_date;
	private int booking_id;
	private String credit_card_name;
	private String credit_card_number;
	private String credit_card_cvv;
	private String credit_card_expiry_date;
	
	public Rental(int rental_id, String rental_date, int booking_id, String credit_card_name, String credit_card_number,
			String credit_card_cvv, String credit_card_expiry_date) {
		this.rental_id = rental_id;
		this.rental_date = rental_date;
		this.booking_id = booking_id;
		this.credit_card_name = credit_card_name;
		this.credit_card_number = credit_card_number;
		this.credit_card_cvv = credit_card_cvv;
		this.credit_card_expiry_date = credit_card_expiry_date;
	}
	
	public int getRentalId() {
		return rental_id;
	}
	public void setRentalId(int rental_id) {
		this.rental_id = rental_id;
	}
	public String getRentalDate() {
		return rental_date;
	}
	public void setRentalDate(String rental_date) {
		this.rental_date = rental_date;
	}
	public int getBookingId() {
		return booking_id;
	}
	public void setBookingId(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getCreditCardName() {
		return credit_card_name;
	}
	public void setCreditCardName(String credit_card_name) {
		this.credit_card_name = credit_card_name;
	}
	public String getCreditCardNumber() {
		return credit_card_number;
	}
	public void setCreditCardNumber(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}
	public String getCreditCardCvv() {
		return credit_card_cvv;
	}
	public void setCreditCardCvv(String credit_card_cvv) {
		this.credit_card_cvv = credit_card_cvv;
	}
	public String getCreditCardExpiryDate() {
		return credit_card_expiry_date;
	}
	public void setCreditCardExpiryDate(String credit_card_expiry_date) {
		this.credit_card_expiry_date = credit_card_expiry_date;
	}
}
