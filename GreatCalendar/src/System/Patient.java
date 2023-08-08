package System;

public class Patient {

	//Attributes
	String name;
	String username;
	String password;
	String email;
	String address;
	String telephone;
	
	public Patient(String name, String username, String password, String email, String address, String telephone) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}

	public Patient() {
	}

	//Getters & Setters
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	//Methods
	public String toString() {
		String str = "Name: "+ this.name+" Username: "+this.username+" Password: "+this.password;
		str += "Email: "+this.email+" Address: "+this.address+" Telephone: "+this.telephone;
		return str;
	}
	
		
}