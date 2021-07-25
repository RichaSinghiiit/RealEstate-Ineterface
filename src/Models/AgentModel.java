package Models;

import java.util.ArrayList;
import java.util.List;

public class AgentModel {
	
	private String name;
	private long contact_number;
	private String email;
	private String address;
	List<PropertyModel> deals_in = new ArrayList<PropertyModel>();
	
	public AgentModel() {
		
	}
	
	public AgentModel(String name, long contact_number, String email, String address) {
		this.name = name;
		this.contact_number = contact_number;
		this.email = email;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<PropertyModel> getDeals_in() {
		return deals_in;
	}
	public void setDeals_in(List<PropertyModel> deals_in) {
		this.deals_in = deals_in;
	}
	

	@Override
	public String toString() {
		return "AgentModel [name=" + name + ", contact_number=" + contact_number + ", email=" + email + ", address="
				+ address + ", deals_in=" + deals_in + "]";
	}
	
	
	

}
