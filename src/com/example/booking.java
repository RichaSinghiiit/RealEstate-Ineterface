package com.example;
import java.util.Date;
public class booking {
     
	public booking() {
		super();
	}
	public booking(int property_id, int client_id, int agent_id, int booking_price, String first_date,
			String last_date) {
		super();
		this.property_id = property_id;
		this.client_id = client_id;
		this.agent_id = agent_id;
		this.booking_price = booking_price;
		this.first_date = first_date;
		this.last_date = last_date;
	}
	int property_id,client_id,agent_id,booking_price;
	String first_date , last_date;
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
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
}
