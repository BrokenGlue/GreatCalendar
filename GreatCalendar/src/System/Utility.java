package System;

import javax.swing.JFrame;
import GUI.WelcomePage;

public class Utility {

	public static void logout(JFrame frame, Calendar calendar) {
		frame.dispose();
		WelcomePage.login(calendar);
	}
}
