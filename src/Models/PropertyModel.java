package Models;

import java.io.Serializable;

public class PropertyModel implements Serializable
{
	private int property_id;
	private String property_for ; 
	private int asking_price;         
	private int size ;               
	private int house_number;                 
	private String locality;           
	private String property_type;        
	private int number_of_bedrooms;           
	private int number_of_bathrooms;          
	private String new_or_resale;       
	private String construction_status;   
	private String furnishing;           
	private int parking;
	private String booking_status;
	private String name;
	private long contact_number;
	private String email;
	private int booking_price;
	private String owner_name;
	private long owner_contact_number;
	private String owner_email;
	BookingModel booking = new BookingModel();
	OwnerModel owner = new OwnerModel();
	
	public PropertyModel() {
	}


	public PropertyModel(int property_id,String property_for, int asking_price, int size, int house_number, String locality,
			String property_type, int number_of_bedrooms, int number_of_bathrooms, String new_or_resale,
			String construction_status, String furnishing, int parking, String booking_status,String name,Long contact_number,String email,int booking_price,
			String owner_name,Long owner_contact_number,String owner_email) {
		this.property_for = property_for;
		this.property_id = property_id;
		this.asking_price = asking_price;
		this.size = size;
		this.house_number = house_number;
		this.locality = locality;
		this.property_type = property_type;
		this.number_of_bedrooms = number_of_bedrooms;
		this.number_of_bathrooms = number_of_bathrooms;
		this.new_or_resale = new_or_resale;
		this.construction_status = construction_status;
		this.furnishing = furnishing;
		this.parking = parking;
		this.booking_status = booking_status;
		this.booking_price = booking_price;
		this.name = name;
		this.contact_number = contact_number;
		this.email = email;
		
		this.owner_name = owner_name;
		this.owner_contact_number = owner_contact_number;
		this.owner_email = owner_email;
		
	}


	/**
	 * @return the property_for
	 */
	
	public int getProperty_id() {
		return property_id;
	}


	/**
	 * @param property_for the property_for to set
	 */
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public String getProperty_for() {
		return property_for;
	}


	/**
	 * @param property_for the property_for to set
	 */
	public void setProperty_for(String property_for) {
		this.property_for = property_for;
	}


	/**
	 * @return the asking_price
	 */
	public int getAsking_price() {
		return asking_price;
	}


	/**
	 * @param asking_price the asking_price to set
	 */
	public void setAsking_price(int asking_price) {
		this.asking_price = asking_price;
	}


	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * @return the house_number
	 */
	public int getHouse_number() {
		return house_number;
	}


	/**
	 * @param house_number the house_number to set
	 */
	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}


	/**
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}


	/**
	 * @param locality the locality to set
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}


	/**
	 * @return the property_type
	 */
	public String getProperty_type() {
		return property_type;
	}


	/**
	 * @param property_type the property_type to set
	 */
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}


	/**
	 * @return the number_of_bedrooms
	 */
	public int getNumber_of_bedrooms() {
		return number_of_bedrooms;
	}


	/**
	 * @param number_of_bedrooms the number_of_bedrooms to set
	 */
	public void setNumber_of_bedrooms(int number_of_bedrooms) {
		this.number_of_bedrooms = number_of_bedrooms;
	}


	/**
	 * @return the number_of_bathrooms
	 */
	public int getNumber_of_bathrooms() {
		return number_of_bathrooms;
	}


	/**
	 * @param number_of_bathrooms the number_of_bathrooms to set
	 */
	public void setNumber_of_bathrooms(int number_of_bathrooms) {
		this.number_of_bathrooms = number_of_bathrooms;
	}


	/**
	 * @return the new_or_resale
	 */
	public String getNew_or_resale() {
		return new_or_resale;
	}


	/**
	 * @param new_or_resale the new_or_resale to set
	 */
	public void setNew_or_resale(String new_or_resale) {
		this.new_or_resale = new_or_resale;
	}


	/**
	 * @return the construction_status
	 */
	public String getConstruction_status() {
		return construction_status;
	}


	/**
	 * @param construction_status the construction_status to set
	 */
	public void setConstruction_status(String construction_status) {
		this.construction_status = construction_status;
	}


	/**
	 * @return the furnishing
	 */
	public String getFurnishing() {
		return furnishing;
	}


	/**
	 * @param furnishing the furnishing to set
	 */
	public void setFurnishing(String furnishing) {
		this.furnishing = furnishing;
	}


	/**
	 * @return the parking
	 */
	public int getParking() {
		return parking;
	}


	/**
	 * @param parking the parking to set
	 */
	public void setParking(int parking) {
		this.parking = parking;
	}

	public String getBooking_status() {
		return booking_status;
	}


	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}
	
	public BookingModel getBooking() {
		return booking;
	}


	public void setBooking(BookingModel booking) {
		this.booking = booking;
	}
	
	public OwnerModel getOwner() {
		return owner;
	}

	public void setOwner(OwnerModel owner) {
		this.owner = owner;
	}
    
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public long getOwnercontact_number() {
		return owner_contact_number;
	}
	public void setOwnercontact_number(long owner_contact_number) {
		this.owner_contact_number = owner_contact_number;
	}
	public String getOwner_email() {
		return owner_email;
	}
	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}
	public int getBooking_price() {
		return booking_price;
	}
	public void setBooking_price(int booking_price) {
		this.booking_price = booking_price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "PropertyModel [property_for=" + property_for + ", asking_price=" + asking_price + ", size=" + size
				+ ", house_number=" + house_number + ", locality=" + locality + ", property_type=" + property_type
				+ ", number_of_bedrooms=" + number_of_bedrooms + ", number_of_bathrooms=" + number_of_bathrooms
				+ ", new_or_resale=" + new_or_resale + ", construction_status=" + construction_status + ", furnishing="
				+ furnishing + ", parking=" + parking + ", booking_status=" + booking_status + ", booking=" + booking
				+ ", owner=" + owner + "]";
	}
	
	
}