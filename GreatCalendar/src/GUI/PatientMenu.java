package GUI;

import java.awt.Color;
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
		buttonPatient.setBackground(Color.GRAY);
		panelE.add(buttonPatient);
		
		buttonPatient.setBounds(100, 30, 150, 30);
		buttonPatient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	myAppointments(calendar, patient);
		    }
		});
		
		JButton buttonCalendar = new JButton("New Appointment");
		panelE.add(buttonCalendar);
		buttonCalendar.setBackground(Color.GRAY);
		buttonCalendar.setBounds(100, 60, 150, 30);
		buttonCalendar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	CalendarGUI.calendarView(patient,calendar,false);
		    	frameP.dispose();
		    }
		});
		
		JButton buttonlogout = new JButton("Logout");
		panelE.add(buttonlogout);
		buttonlogout.setBackground(Color.GRAY);
		buttonlogout.setBounds(100, 90, 150, 30);
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
	 			String str = "Patient: " + ap.getPatient().getName() + "Time: " + ap.getDateTime();
	 			JLabel lab = new JLabel(str, JLabel.CENTER);
	 			lab.setBounds(125, i, 75, 20);
	 			labels.add(lab);
	 			i += 20;
	 			ex = true;
 			}
 		}
 		
 		if (!ex) {
 			JLabel lab = new JLabel("No appointments yet", JLabel.CENTER);
 			lab.setBounds(75, 10, 150, 20);
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
 	    	}
        });
 	    
 		frame.setVisible(true);	
	}
}
