package System;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
	
	private List<Appointment> appointmentList = new ArrayList<>();
	private List<Patient> patientList = new ArrayList<>();
	private List<Employee> employeeList = new ArrayList<>();
	
	
	public List<Appointment> getAppointments() {
		return this.appointmentList;
	}

	public List<Patient> getPatientList() {
		return this.patientList;
	}

	public List<Employee> getEmployeeList() {
		return this.employeeList;
	}

	public void addAppointment(Patient patient, List<Integer> date) {
		LocalDateTime dateTime = LocalDateTime.of((int)date.get(3), (int)date.get(2), (int)date.get(1), (int)date.get(0), 0);
		Appointment appointment = new Appointment(patient, dateTime);
		this.appointmentList.add(appointment);
	}
	
	public void addPatient(String name, String username, String password, String email, String address, String telephone) {
		Patient patient = new Patient(name, username, password, email, address, telephone);
		this.patientList.add(patient);
	}
	
	public void addEmployee(String name, String username, String password, String role) {
		Employee employee = new Employee(name, username, password, role);
		this.employeeList.add(employee);
	}
	
	
	public void removeAppointment(Patient patient, LocalDateTime dateTime) {
		
		for (Appointment apt: this.appointmentList) {
			if (apt.getDateTime().isEqual(dateTime)) {
				this.appointmentList.remove(apt);
				break;
			}
		}
	}
	
	public void updateDateTime(Patient patient, LocalDateTime oldDateTime, LocalDateTime newDateTime) {
		
		for (Appointment appointment: this.appointmentList) {
			if (appointment.getDateTime().isEqual(oldDateTime)) {
				appointment.setDateTime(newDateTime);
				break;
			}
		}
		
	}
	
}