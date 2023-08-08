package System;

public class Employee {

	//Attributes
	String name;
	String username;
	String password;
	String role;
	
	//Constructors
	public Employee(String name, String username, String password, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public Employee() {
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//Methods
	public String toString() {
		String str = ("Name: "+ this.name+" Username: "+this.username+" Password: "+this.password+ " Role: "+ this.role);
		return str;
	}
	
		
}