package Main;

import System.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = new Calendar();
		calendar.addEmployee("Arthur", "ak", "a", "Dentist");
		
		GUI.WelcomePage.login(calendar);
	}

}
