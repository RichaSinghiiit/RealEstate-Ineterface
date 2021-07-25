package Models;

import java.util.ArrayList;
import java.util.List;

public class ClientModel implements java.io.Serializable
{
	private String name;
	private long contact_number;
	private String email;
	private String address;
	List<PropertyModel> interested_in = new ArrayList<PropertyModel>();
	
	


	public ClientModel() {
		super();
	}

	
	public ClientModel(String name, long contact_number, String email, String address) {
		this.name = name;
		this.contact_number = contact_number;
		this.email = email;
		this.address = address;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the contact_number
	 */
	public long getContact_number() {
		return contact_number;
	}


	/**
	 * @param contact_number the contact_number to set
	 */
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	

	/**
	 * @return the interested_in
	 */
	public List<PropertyModel> getInterested_in() {
		return interested_in;
	}


	/**
	 * @param interested_in the interested_in to set
	 */
	public void setInterested_in(List<PropertyModel> interested_in) {
		this.interested_in = interested_in;
	}


	@Override
	public String toString() {
		return "ClientModel [name=" + name + ", contact_number=" + contact_number + ", email=" + email + ", address="
				+ address + "]";
	}
	
}
