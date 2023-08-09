package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import System.Appointment;
import System.Calendar;
import System.Patient;

public class CalendarGUI {
	
	private List<Integer> date;
	
	public CalendarGUI(){
		this.date = new ArrayList<Integer>();
		for(int i =0;i<4;i++) {
			this.date.add(1);
		}
	}
	
	public int getTime() {
		return this.date.get(0);
	}
	
	public void setList(int index, int value) {
		this.date.set(index, value);
	}
	
	public List<Integer> getDate() {
		return this.date;
	}

	public static void calendarView(Patient patient, Calendar calendar, boolean bool) {
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//                               CALENDAR
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		CalendarGUI date = new CalendarGUI();
			
		//============================ MAIN FRAME =============================
	
		JFrame frameC = new JFrame("Calendar");
		frameC.setSize(300,300);
		frameC.setLocationRelativeTo(null);
			     	
		// =========================== DATE ===================================
		JPanel panelDP = new JPanel();
		//panelDP.setBounds(0, 0, 300, 37);

		
		UtilDateModel model = new UtilDateModel();

	    Properties p = new Properties();
	    p.put("text.today", "Today");
	    p.put("text.month", "Month");
	    p.put("text.year", "Year");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	 
	    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    	    
	    panelDP.add(datePicker);
	    
	    frameC.setLocationRelativeTo(panelDP);
	    
	    //============================ OK BUTTON ==============================
	    	    
	    JButton btn = new JButton("Ok");
		
	    btn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		
	    		
	    		date.setList(1, datePicker.getModel().getDay());
	    		date.setList(2, datePicker.getModel().getMonth()+1);
	    		date.setList(3, datePicker.getModel().getYear());
            	
            	if(date.getTime()!=1) {
            		
            		boolean notpossible = false;
            		LocalDateTime dateTime = LocalDateTime.of((int)date.getDate().get(3), (int)date.getDate().get(2), (int)date.getDate().get(1), (int)date.getDate().get(0), 0);
            		for (Appointment ap: calendar.getAppointments()) {
            			if(dateTime.equals(ap.getDateTime())) {
            				notpossible = true;
            				
            				break;
            			}
            		}
            		
            		if (!notpossible) {
            			calendar.addAppointment(patient, date.getDate());
                		if(bool) {
                			EmployeeMenu.menuE(calendar);
                		}
                		else {
                			PatientMenu.menuP(patient, calendar);
                		}
                		frameC.dispose();
            		} else {
            			JOptionPane.showMessageDialog(null, "There is already an appointment at this date and time");
            		}
            		
            	}else {
            		JFrame errorF = new JFrame("Error");
            		errorF.setSize(300,300);
            		
            		JLabel errorL = new JLabel("Please select a time for your appointment.", JLabel.CENTER);
            		errorF.add(errorL);
            		
            		errorF.setVisible(true);
            	}

        }});
		
	    panelDP.add(btn);
	    
	    //============================ TIME ===================================
	  
	    JButton btn9 = new JButton("09:00");
	    btn9.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		date.setList(0, 9);
	    	}
	    });
	    
	    JButton btn10 = new JButton("10:00");
	    btn10.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		date.setList(0, 10);
	    	}
	    });
	    
	    JButton btn11 = new JButton("11:00");
	    btn11.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		date.setList(0, 11);
	    	}
	    });
	    
	    JButton btn3 = new JButton("15:00");
	    btn3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		date.setList(0, 15);
	    	}
	    });
	    
	    JButton btn4 = new JButton("16:00");
	    btn4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		date.setList(0, 16);
	    	}
	    });
	    JPanel cancelP = new JPanel();
	    cancelP.setBounds(0, 175, 300, 50);
	    JButton cancel = new JButton("Go back");
 		cancelP.add(cancel);
 	    cancel.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent evt) {
         		frameC.dispose();
         		if(bool) {
        			EmployeeMenu.menuE(calendar);
        		}
        		else {
        			PatientMenu.menuP(patient, calendar);
        		}
 	    	}
        });
	    
	    panelDP.add(btn9);
	    panelDP.add(btn10);
	    panelDP.add(btn11);
	    panelDP.add(btn3);
	    panelDP.add(btn4);
	    
	    frameC.add(cancelP);
		frameC.add(panelDP);
	    
      	frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frameC.setVisible(true);
	}
}
