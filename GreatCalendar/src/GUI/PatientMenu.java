package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		    	//TODO
		    }
		});
		
		JButton buttonCalendar = new JButton("New Appointment");
		panelE.add(buttonCalendar);
		buttonCalendar.setBackground(Color.GRAY);
		buttonCalendar.setBounds(100, 60, 150, 30);
		buttonCalendar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	CalendarGUI.calendarView(patient,calendar);
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
}
