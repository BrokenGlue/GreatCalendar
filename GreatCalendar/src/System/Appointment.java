package System;

import java.time.LocalDateTime;

public class Appointment {
	
	//Attributes
	private Patient patient;
	private LocalDateTime dateTime;
	
	//Constructor
	public Appointment(Patient patient, LocalDateTime dateTime) {
		this.patient = patient;
		this.dateTime = dateTime;
	}

	//Getters and Setters
	public Patient getPatient() {
		return this.patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public String toString() {
		return "Patient name: "+ patient.getName()+" Appointment date: " + dateTime.toString();
	}
}