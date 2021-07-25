package Models;

public class OwnerModel {
	
	private String name;
	private long contact_number;
	private String email;
	private String address;
	
	public OwnerModel() {
		
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

	@Override
	public String toString() {
		return "OwnerModel [name=" + name + ", contact_number=" + contact_number + ", email=" + email + ", address="
				+ address + "]";
	}
	
	
	
}
