package com.example;

public class property {
    public property() {
		super();
	}
	public property(String property_for, String property_type, String locality, String new_or_resale,
			String construction_status, String furnishing, String bookingStatus, int asking_price, int house_number,
			int size, int number_of_bedrooms, int number_of_bathrooms, int parking) {
		super();
		this.property_for = property_for;
		this.property_type = property_type;
		this.locality = locality;
		this.new_or_resale = new_or_resale;
		this.construction_status = construction_status;
		this.furnishing = furnishing;
		this.bookingStatus = bookingStatus;
		this.asking_price = asking_price;
		this.house_number = house_number;
		this.size = size;
		this.number_of_bedrooms = number_of_bedrooms;
		this.number_of_bathrooms = number_of_bathrooms;
		this.parking = parking;
	}
	private String property_for,property_type,locality,new_or_resale,construction_status,furnishing,bookingStatus;
    private int asking_price,house_number,size,number_of_bedrooms,number_of_bathrooms,parking;
	public String getProperty_for() {
		return property_for;
	}
	public void setProperty_for(String property_for) {
		this.property_for = property_for;
	}
	public String getProperty_type() {
		return property_type;
	}
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getNew_or_resale() {
		return new_or_resale;
	}
	public void setNew_or_resale(String new_or_resale) {
		this.new_or_resale = new_or_resale;
	}
	public String getConstruction_status() {
		return construction_status;
	}
	public void setConstruction_status(String construction_status) {
		this.construction_status = construction_status;
	}
	public String getFurnishing() {
		return furnishing;
	}
	public void setFurnishing(String furnishing) {
		this.furnishing = furnishing;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getAsking_price() {
		return asking_price;
	}
	public void setAsking_price(int asking_price) {
		this.asking_price = asking_price;
	}
	public int getHouse_number() {
		return house_number;
	}
	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNumber_of_bedrooms() {
		return number_of_bedrooms;
	}
	public void setNumber_of_bedrooms(int number_of_bedrooms) {
		this.number_of_bedrooms = number_of_bedrooms;
	}
	public int getNumber_of_bathrooms() {
		return number_of_bathrooms;
	}
	public void setNumber_of_bathrooms(int number_of_bathrooms) {
		this.number_of_bathrooms = number_of_bathrooms;
	}
	public int getParking() {
		return parking;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
    
}
