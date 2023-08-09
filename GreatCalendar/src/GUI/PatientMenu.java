package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import System.Appointment;
import System.Calendar;
import System.Patient;
import System.Utility;

public class PatientMenu {

	public static void menuP(Patient patient,Calendar calendar) {
 		JFrame frameP = new JFrame("Options");
 		frameP.setSize(350, 200);
 				
 		JPanel panelE = new JPanel();
 		frameP.add(panelE);
 		panelE.setLayout(null);
 		
 		//Stop program 
 		frameP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton buttonPatient = new JButton("My appointments");
		panelE.add(buttonPatient);
		
		buttonPatient.setBounds(80, 30, 170, 30);
		buttonPatient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	myAppointments(calendar, patient);
		    	frameP.dispose();
		    }
		});
		
		JButton buttonCalendar = new JButton("New Appointment");
		panelE.add(buttonCalendar);
		buttonCalendar.setBounds(80, 60, 170, 30);
		buttonCalendar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	CalendarGUI.calendarView(patient,calendar,false);
		    	frameP.dispose();
		    }
		});
		
		JButton buttoncancel = new JButton("Cancel Appointment");
		panelE.add(buttoncancel);
		buttoncancel.setBounds(80, 90, 170, 30);
		buttoncancel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	cancelAppointment(calendar, patient);
		    	frameP.dispose();
		    }
		});
		
		JButton buttonlogout = new JButton("Logout");
		panelE.add(buttonlogout);
		buttonlogout.setBounds(80, 120, 170, 30);
		buttonlogout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Utility.logout(frameP,calendar);
		    }
		});
		
		frameP.setVisible(true);
	}
	
	public static void myAppointments(Calendar calendar, Patient patient) {
		JFrame frame = new JFrame("Patient List");
 		frame.setSize(350, 200);
 				
 		JPanel panel = new JPanel();
 		frame.add(panel);
 		panel.setLayout(null);
 		
 		//Stop program 
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		List<JLabel> labels = new ArrayList<JLabel>();
 		
 		
 		boolean ex = false;
 		
 		int i = 10;
 		for (Appointment ap: calendar.getAppointments()) {
 			if (patient.getUsername().equals(ap.getPatient().getUsername())) {
	 			String str = "Time: " + ap.getDateTime();
	 			JLabel lab = new JLabel(str, JLabel.CENTER);
	 			lab.setBounds(50, i, 250, 20);
	 			labels.add(lab);
	 			i += 20;
	 			ex = true;
 			}
 		}
 		
 		if (!ex) {
 			JLabel lab = new JLabel("No appointments yet", JLabel.CENTER);
 			lab.setBounds(50, 10, 250, 20);
 			labels.add(lab);
 		}
 		
 		for (JLabel lab: labels) {
 			panel.add(lab);
 		}
 		
 		JButton btn = new JButton("Ok");
 		panel.add(btn);
 		btn.setBounds(90, 130, 150, 30);
 	    btn.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent evt) {
         		frame.dispose();
         		PatientMenu.menuP(patient, calendar);
 	    	}
        });
 	    
 		frame.setVisible(true);	
	}
	
	public static void cancelAppointment(Calendar calendar, Patient patient) {
		JFrame frame = new JFrame("Cancel Appointment");
 		frame.setSize(350, 200);
 				
 		JPanel panel = new JPanel();
 		frame.add(panel);
 		panel.setLayout(null);
 		
 		//Stop program 
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		List<JButton> buttons = new ArrayList<JButton>();
 		
 		boolean ex = false;
 		
 		int i = 10;
 		for (Appointment ap: calendar.getAppointments()) {
 			if (patient.getUsername().equals(ap.getPatient().getUsername())) {
	 			JButton lab = new JButton(ap.getDateTime().toString());
	 			lab.setBounds(50, i, 250, 20);
	 			buttons.add(lab);
	 			lab.addActionListener(new ActionListener() {
	 	 	    	public void actionPerformed(ActionEvent evt) {
	 	 	    		calendar.removeAppointment(patient, ap.getDateTime());
	 	 	    		frame.dispose();
	 	 	    		PatientMenu.menuP(patient, calendar);
	 	 	    	}
	 	        });
	 			i += 20;
	 			ex = true;
 			}
 		}
 		
 		if (!ex) {
 			JLabel lab = new JLabel("No appointments to cancel", JLabel.CENTER);
 			lab.setBounds(50, 10, 250, 20);
 			panel.add(lab);
 		} else {
	 		for (JButton lab: buttons) {
	 			panel.add(lab);	 			
	 		}
 		}
 		
 		JButton cancel = new JButton("Go back");
 		panel.add(cancel);
 		cancel.setBounds(90, 130, 150, 30);
 	    cancel.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent evt) {
         		frame.dispose();
         		PatientMenu.menuP(patient, calendar);
 	    	}
        });
 	    
 		frame.setVisible(true);	
	}
}
