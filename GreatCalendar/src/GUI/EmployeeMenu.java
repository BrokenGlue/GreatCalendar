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
import javax.swing.JTextArea;

import System.Appointment;
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
		buttonPatient.setBounds(100, 10, 150, 30);
		buttonPatient.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	printPatientList(calendar);
		    	frameE.dispose();
		    }
		});
		
		JButton buttonAppointment = new JButton("Appointment List");
		panelE.add(buttonAppointment);
		buttonAppointment.setBackground(Color.GRAY);
		buttonAppointment.setBounds(100, 40, 150, 30);
		buttonAppointment.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	printAppointmentList(calendar);
		    	frameE.dispose();
		    }
		});
		
		JButton buttonCalendar = new JButton("New Appointment");
		panelE.add(buttonCalendar);
		buttonCalendar.setBackground(Color.GRAY);
		buttonCalendar.setBounds(100, 70, 150, 30);
		buttonCalendar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	checkName(calendar);
		    	frameE.dispose();
		    }
		});
		
		JButton buttoncancel = new JButton("Cancel Appointment");
		panelE.add(buttoncancel);
		buttoncancel.setBackground(Color.GRAY);
		buttoncancel.setBounds(100, 100, 150, 30);
		buttoncancel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	cancelAppointment(calendar);
		    	frameE.dispose();
		    }
		});
		
		JButton buttonlogout = new JButton("Logout");
		panelE.add(buttonlogout);
		buttonlogout.setBackground(Color.GRAY);
		buttonlogout.setBounds(100, 130, 150, 30);
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
		    		CalendarGUI.calendarView(patient, calendar, true);
		    	}
		    	checkF.dispose();
		    }
		 });
 		
 		checkF.setVisible(true);
	}
	
	public static void printPatientList(Calendar calendar) {
		JFrame frame = new JFrame("Patient List");
 		frame.setSize(350, 200);
 				
 		JPanel panel = new JPanel();
 		frame.add(panel);
 		panel.setLayout(null);
 		
 		//Stop program 
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		List<JButton> buttons = new ArrayList<JButton>();
 		
 		if (calendar.getPatientList().size() == 0) {
 			JLabel lab = new JLabel("Empty list");
 			lab.setBounds(50, 10, 250, 20);
 			panel.add(lab);
 		} else {
	 		int i = 10;
	 		for (Patient pa: calendar.getPatientList()) {
	 			JButton button = new JButton(pa.getName());
	 			button.setBounds(50, i, 250, 20);
	 			buttons.add(button);
	 			button.addActionListener(new ActionListener() {
	 	 	    	public void actionPerformed(ActionEvent evt) {
	 	         		frame.dispose();
	 	         		profilePatient(calendar, pa);
	 	 	    	}
	 	        });
	 			
	 			i += 20;
	 		}
 		}
 		
 		for (JButton butt: buttons) {
 			panel.add(butt);
 		}
 		
 		JButton btn = new JButton("Ok");
 		panel.add(btn);
 		btn.setBounds(90, 130, 150, 30);
 	    btn.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent evt) {
         		frame.dispose();
         		EmployeeMenu.menuE(calendar);
 	    	}
        });
 	    
 		frame.setVisible(true);	
	}
	
	public static void printAppointmentList(Calendar calendar) {
		JFrame frame = new JFrame("Patient List");
 		frame.setSize(350, 200);
 				
 		JPanel panel = new JPanel();
 		frame.add(panel);
 		panel.setLayout(null);
 		
 		//Stop program 
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		List<JLabel> labels = new ArrayList<JLabel>();
 		
 		if (calendar.getAppointments().size() == 0) {
 			JLabel lab = new JLabel("Empty list", JLabel.CENTER);
 			lab.setBounds(50, 10, 250, 20);
 			labels.add(lab);
 		} else {
	 		int i = 10;
	 		for (Appointment ap: calendar.getAppointments()) {
	 			String str = "Patient: " + ap.getPatient().getName() + " Time: " + ap.getDateTime();
	 			JLabel lab = new JLabel(str, JLabel.CENTER);
	 			lab.setBounds(50, i, 250, 20);
	 			labels.add(lab);
	 			i += 20;
	 		}
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
         		EmployeeMenu.menuE(calendar);
 	    	}
        });
 	    
 		frame.setVisible(true);	
	}
	
	public static void cancelAppointment(Calendar calendar) {
		JFrame frame = new JFrame("Cancel Appointment");
 		frame.setSize(350, 200);
 				
 		JPanel panel = new JPanel();
 		frame.add(panel);
 		panel.setLayout(null);
 		
 		//Stop program 
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		List<JButton> buttons = new ArrayList<JButton>();
 		
 		if (calendar.getAppointments().size() == 0) {
 			JLabel lab = new JLabel("Empty list", JLabel.CENTER);
 			lab.setBounds(50, 10, 250, 20);
 			panel.add(lab);
 		} else {
	 		int i = 10;
	 		for (Appointment ap: calendar.getAppointments()) {
	 			String str = "Patient: " + ap.getPatient().getName() + " Time: " + ap.getDateTime();
	 			JButton lab = new JButton(str);
	 			lab.setBounds(50, i, 250, 20);
	 			buttons.add(lab);
	 			lab.addActionListener(new ActionListener() {
	 	 	    	public void actionPerformed(ActionEvent evt) {
	 	 	    		calendar.removeAppointment(ap.getPatient(), ap.getDateTime());
	 	 	    		frame.dispose();
	 	 	    		EmployeeMenu.menuE(calendar);
	 	 	    	}
	 	        });
	 			i += 20;
	 		}
 		}
 		
 		for (JButton lab: buttons) {
 			panel.add(lab);
 		}
 		
 		JButton cancel = new JButton("Go back");
 		panel.add(cancel);
 		cancel.setBounds(90, 130, 150, 30);
 	    cancel.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent evt) {
         		frame.dispose();
         		EmployeeMenu.menuE(calendar);
 	    	}
        });
 	    
 		frame.setVisible(true);	
	}
	
	public static void profilePatient(Calendar calendar, Patient patient) {
		JFrame frame = new JFrame("Cancel Appointment");
 		frame.setSize(350, 200);
 				
 		JPanel panel = new JPanel();
 		frame.add(panel);
 		panel.setLayout(null);
 		
 		//Stop program 
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		//Attributes patient
 		JLabel lab_name = new JLabel(patient.getName(), JLabel.CENTER);
 		lab_name.setBounds(50, 20, 250, 20);
		panel.add(lab_name);
		
		JLabel lab_username = new JLabel(patient.getUsername(), JLabel.CENTER);
		lab_username.setBounds(50, 40, 250, 20);
		panel.add(lab_username);
		
		JLabel lab_email = new JLabel(patient.getEmail(), JLabel.CENTER);
		lab_email.setBounds(50, 60, 250, 20);
		panel.add(lab_email);
		
		JLabel lab_address = new JLabel(patient.getAddress(), JLabel.CENTER);
		lab_address.setBounds(50, 80, 250, 20);
		panel.add(lab_address);
		
		JLabel lab_telephone = new JLabel(patient.getTelephone(), JLabel.CENTER);
		lab_telephone.setBounds(50, 100, 250, 20);
		panel.add(lab_telephone);
		
		JButton cancel = new JButton("Go back");
 		panel.add(cancel);
 		cancel.setBounds(90, 130, 150, 30);
 	    cancel.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent evt) {
         		frame.dispose();
         		printPatientList(calendar);
 	    	}
        });
 	    
 	    frame.setVisible(true);
	}
}
