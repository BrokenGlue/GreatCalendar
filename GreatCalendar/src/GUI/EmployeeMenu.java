package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import System.Calendar;
import System.Patient;
import System.Utility;


public class EmployeeMenu {

	public static void menuE(Calendar calendar) {
 		JFrame frameE = new JFrame("Options");
 		frameE.setSize(350, 200);
 				
 		JPanel panelE = new JPanel();
 		frameE.add(panelE);
 		panelE.setLayout(null);
 		
 		//Stop program 
 		frameE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton buttonPatient = new JButton("Patient List");
		buttonPatient.setBackground(Color.GRAY);
		panelE.add(buttonPatient);
		
		buttonPatient.setBounds(100, 30, 150, 30);
		buttonPatient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	//TODO
		    }
		});
		
		JButton buttonAppointment = new JButton("Appointment List");
		panelE.add(buttonAppointment);
		buttonAppointment.setBackground(Color.GRAY);
		buttonAppointment.setBounds(100, 60, 150, 30);
		buttonAppointment.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	//TODO
		    }
		});
		
		JButton buttonCalendar = new JButton("New Appointment");
		panelE.add(buttonCalendar);
		buttonCalendar.setBackground(Color.GRAY);
		buttonCalendar.setBounds(100, 90, 150, 30);
		buttonCalendar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	checkName(calendar);
		    	frameE.dispose();
		    }
		});
		
		JButton buttonlogout = new JButton("Logout");
		panelE.add(buttonlogout);
		buttonlogout.setBackground(Color.GRAY);
		buttonlogout.setBounds(100, 120, 150, 30);
		buttonlogout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Utility.logout(frameE,calendar);
		    }
		});
		
		frameE.setVisible(true);
	}
	
	public static void checkName(Calendar calendar) {
		JFrame checkF = new JFrame("Options");
		checkF.setSize(350, 200);
 				
 		JPanel checkP = new JPanel();
 		checkF.add(checkP);
 		checkP.setLayout(null);
 		
 		//Stop program 
 		checkF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		JLabel confirmation1 = new JLabel("Patient name :", JLabel.LEFT);
		confirmation1.setBounds(50,20,300,50);
		checkP.add(confirmation1);
			
		JTextArea area = new JTextArea();
		area.setBounds(50,50,250,30);
		area.setBackground(Color.white);
		area.setForeground(Color.blue);
		checkP.add(area);
		
		JButton ok = new JButton("Ok");
		checkP.add(ok);
		ok.setBounds(120, 90, 100, 50);
		ok.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	Patient patient = new Patient();
		    	boolean got_p = false;
		    	for (Patient pa: calendar.getPatientList()) {
  					if (pa.getUsername().equals(area.getText())) {
  						patient = pa;
  						got_p = true;
  						break;
  					}
		    	}
		    	
		    	if (!got_p) {
		    		WelcomePage.registration(calendar, false);
		    	}
		    	else {
		    		CalendarGUI.calendarView(patient, calendar);
		    	}
		    	checkF.dispose();
		    }
		 });
 		
 		checkF.setVisible(true);
	}
}
