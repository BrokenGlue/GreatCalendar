package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import System.Calendar;
import System.Employee;
import System.Patient;

public class WelcomePage {

	//========================= LOGIN ========================================
	public static void login(Calendar calendar){
		JFrame loginF = new JFrame("Teethos");
		loginF.setSize(300, 460);
			
		//Panel
		JPanel loginP = new JPanel();
		loginP.setBounds(0,0,300,420);
		
		
		try {
		    // Load the image
		    BufferedImage image = ImageIO.read(new File("C:/Users/Beggy/Pictures/dentistiImage3.jpg"));
		    ImageIcon imageIcon = new ImageIcon(image);
		
		    // Create and set the image label
		    JLabel imageLabel = new JLabel(imageIcon);
		    loginP.add(imageLabel);
		} catch (IOException e) {
		    // Handle the exception
		    e.printStackTrace();
		}
		
        
		//Stop program 
		loginF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel LabelUserLogin = new JLabel(" ============ USER LOGIN ============== ", JLabel.CENTER);
		LabelUserLogin.setSize(300, 20);
		loginP.add(LabelUserLogin);
		
		JLabel LabelUserName = new JLabel("User name: ", JLabel.LEFT);
		LabelUserName.setFont(new Font("Arial", Font.BOLD, 12));
		loginP.add(LabelUserName);
		
		JTextField userName = new JTextField(15);
		loginP.add(userName);
		
		JLabel LabelPassword = new JLabel("Password: ", JLabel.LEFT);
		LabelPassword.setFont(new Font("Arial", Font.BOLD, 12));
		loginP.add(LabelPassword);
		
		JPasswordField password = new JPasswordField(15);
		loginP.add(password);
		
		JLabel label = new JLabel("===================================== ", JLabel.CENTER);
		LabelUserLogin.setSize(300, 20);
		loginP.add(label);
		
		// Login Button
		
		JButton userLogin = new JButton("Login");
		userLogin.setSize(50,30);
		userLogin.setFont(new Font("Arial", Font.PLAIN, 8));
		loginP.add(userLogin);
		userLogin.setBackground(loginP.getBackground());
		
  		userLogin.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				boolean done = false;
  				for (Employee em: calendar.getEmployeeList()) {
  					if (em.getUsername().equals(userName.getText())) {
  						String pass = em.getPassword();
  						if (pass.equals(password.getText())) {
  							EmployeeMenu.menuE(calendar);
  		  					loginF.dispose();
  						} else {
  							wrongPassword();
  						}
  		  				done = true;
  						break;
  					}
  				}
  				
  				if (!done) {
	  				for (Patient pa: calendar.getPatientList()) {
	  					if (pa.getUsername().equals(userName.getText())) {
	  						String pass = pa.getPassword();
	  						if (pass.equals(password.getText())) {
	  							PatientMenu.menuP(pa, calendar);
	  							loginF.dispose();
	  		  				}else {
	  		  					wrongPassword();
	  		  				}
	  						done = true;
	  						break;
	  					}
	  				}
  				}
  				if (!done) {
  					wrongUsername();
  				}
  			}
  		});
		
		
  		// Register button
		JButton createAccount = new JButton("Create account");
  		createAccount.setSize(50,30);
  		createAccount.setFont(new Font("Arial", Font.PLAIN, 8));
  		loginP.add(createAccount);
  		createAccount.setBackground(loginP.getBackground());
  		
  		createAccount.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				registration(calendar,true);
  				loginF.dispose();
  			}
  		});
  		
		loginF.add(loginP);
  		loginF.setVisible(true);
	}
	
	//======================== REGISTRATION ===========================
	
	public static void registration(Calendar calendar,boolean bool) {
		JFrame regF = new JFrame("Registration");
		regF.setSize(400,350);
		
        JPanel regP = new JPanel();
        regF.add(regP);
        regP.setLayout(null);
 
		regF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel name = new JLabel("Name");
		JLabel user = new JLabel("Username");
		JLabel password = new JLabel("Password");
		JLabel email = new JLabel("Email");
		JLabel add = new JLabel("Address");
		JLabel tel = new JLabel("Mobile Number");

		//Text
		JTextField name1 = new JTextField(15);
		JTextField user1 = new JTextField(15);
		JPasswordField password1 = new JPasswordField(15);   
		JTextField email1 = new JTextField(15);
		JTextField add1 = new JTextField(15);
		JTextField tel1 = new JTextField(15);
		
		//Bounds
		name.setBounds(50, 10, 100,30 ); 
		user.setBounds(50, 50, 100,30 ); 
		password.setBounds(50,90, 100, 30); 
		email.setBounds(50, 130,100, 30);
		add.setBounds(50, 170,100, 30); 
		tel.setBounds(50, 210,100, 30 ); 

		name1.setBounds(160, 10, 200,30 ); 
		user1.setBounds(160, 50, 200,30 ); 
		password1.setBounds(160,90, 200, 30); 
		email1.setBounds(160, 130,200, 30);
		add1.setBounds(160, 170,200, 30);
		tel1.setBounds(160, 210,200, 30 ); 
	
		JButton cancel = new JButton("Go back");
		cancel.setBorder(null);
 		regP.add(cancel);
 		cancel.setBounds(50, 250, 100, 30);
 	    cancel.addActionListener(new ActionListener() {
 	    	public void actionPerformed(ActionEvent evt) {
         		if(bool) {
			        login(calendar);
		        }
		        else {
		        	EmployeeMenu.menuE(calendar);
		        }

		        regF.dispose();
 	    	}
        });
		
		//Button Registration
		JButton buttonRegister = new JButton("Register");
		buttonRegister.setBorder(null);
		regP.add(buttonRegister);
		buttonRegister.setBackground(Color.GRAY);
		buttonRegister.setBounds(250, 250, 100, 30);
		buttonRegister.setBackground(regP.getBackground());
		buttonRegister.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        calendar.addPatient(name1.getText(), user1.getText(), password1.getText(), email1.getText(), add1.getText(), tel1.getText());
		        
		        if(bool) {
			        login(calendar);
		        }
		        else {
		        	Patient patient = calendar.getPatientList().get((calendar.getPatientList().size()-1));
		        	CalendarGUI.calendarView(patient, calendar, true);
		        }

		        regF.dispose();
		        
		    }
		});
		
		regP.add(name);
		regP.add(user);
		regP.add(password);
		regP.add(email);
		regP.add(add);
		regP.add(tel);
		
		regP.add(name1);
		regP.add(user1);
		regP.add(password1);
		regP.add(email1);
		regP.add(add1);
		regP.add(tel1);
		
		regF.setLayout(new BorderLayout());
        regF.setLocationRelativeTo(null);
        
        regF.add(regP, BorderLayout.CENTER);
        regF.setLocationRelativeTo(null);
        regF.setVisible(true);
	}
	
	public static void wrongPassword() {
		JFrame errorF = new JFrame("Error!");
		errorF.setSize(300,300);
		JLabel errorP = new JLabel("Incorrect password. Please try again.", JLabel.CENTER);
		errorF.add(errorP);
		errorF.setVisible(true);
	}
	public static void wrongUsername() {
		JFrame errorF = new JFrame("Error!");
		errorF.setSize(300,300);
		JLabel errorP = new JLabel("Username not found. Please try again.", JLabel.CENTER);
		errorF.add(errorP);
		errorF.setVisible(true);
	}
	
}
