package ui;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonListener;

import listener.Callback;

//drawable login menu for the game
public class LoginMenu extends JPanel implements ActionListener {
	//login menu components
	private JTextField uname;
	private JPasswordField pw;
	private JLabel userlabel, passlabel;
	private JButton loginButton;
	private Interface callback;
	private JLabel instructions;
	
	public LoginMenu() {
		//initialize data members
		callback = null;
		
		//configure LoginMenu settings
		
		//create username component
		uname = new JTextField(20);
		userlabel = new JLabel("Username:");
		
		//create password component
		pw = new JPasswordField(20);
		passlabel = new JLabel("Password:");
		
		//create login button
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		
		//create instructions
		String inst = "Log in with any username/password. When logged in";
		inst += ": Ctrl-D to log out. When not logged in: Ctrl-D to exit";
		instructions = new JLabel(inst);
		
		//add components to the login menu
		this.add(userlabel);
		this.add(uname);
		this.add(passlabel);
		this.add(pw);
		this.add(loginButton);
		this.add(instructions);
	}//end constructor method
	
	
	//sets the callback interface (when the user wants to log in)
	public void setCallback(Interface i) {
		callback = i;
	}//end setCallback method

	
	@Override
	//called when the login button is pressed
	public void actionPerformed(ActionEvent arg0) {
		//grab user's login information
		String username = "", password = "";
		username = uname.getText();
		char[] pwtmp = pw.getPassword();
		for(int i = 0; i < pwtmp.length; i++) {
			password += pwtmp[i];
			pwtmp[i] = '\0'; //make password more secure by changing each char
		}
		System.out.println("Username: " + username + " Password: " + password);
		boolean loggedIn = false;
		if(callback != null) {
			loggedIn = callback.onPlayerlogin(username, password);
		}
		if(loggedIn) {
			System.out.println("User " + username + " has been logged in.");
			//clear username and password slots
			uname.setText(null);
			pw.setText(null);
		}
	}//end actionPerformed method
	
}//end class LoginMenu
