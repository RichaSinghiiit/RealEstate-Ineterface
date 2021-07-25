package com.example;

public class owner {
        public owner() {
		super();
	}

		 public owner(String name, String email, String address, String contact_number) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact_number = contact_number;
	}

		private String name,email,address,contact_number;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public String getContact_number() {
			return contact_number;
		}

		public void setContact_number(String contact_number) {
			this.contact_number = contact_number;
		}
}
