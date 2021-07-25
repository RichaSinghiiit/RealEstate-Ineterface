package Models;

import java.io.Serializable;

public class BookingModel implements Serializable
{
	private int booking_price;
	private String first_date;
	private String last_date;
	
	public BookingModel() {
		
	}
	
	public BookingModel(int booking_price, String first_date, String lastdate) {
		this.booking_price = booking_price;
		this.first_date = first_date;
		this.last_date = lastdate;
	}
	
	public int getBooking_price() {
		return booking_price;
	}
	public void setBooking_price(int booking_price) {
		this.booking_price = booking_price;
	}
	public String getFirst_date() {
		return first_date;
	}
	public void setFirst_date(String first_date) {
		this.first_date = first_date;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}

	@Override
	public String toString() {
		return "BookingModel [booking_price=" + booking_price + ", first_date=" + first_date + ", last_date="
				+ last_date + "]";
	}
	
	
	
}