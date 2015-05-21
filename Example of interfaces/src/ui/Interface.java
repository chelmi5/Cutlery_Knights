package ui;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import world.Coordinate;

import entity.Player;

import listener.KeyboardListener;

/**
 * Interface - a class that draws the current game state to the screen. An 
 * interface provides a way for the user to interact with the game.
 * An example interface would have a keyboard and/or mouse listener 
 * to get user commands.
 * The interface will be responsible, as well, for displaying the game
 * and will do so through queries on the game state. 
 */
public class Interface extends JFrame {
	//data members
	private Game game; //game that the interface is bound to
	private Player user; //character the interface is tied to 
	private LoginMenu loginMenu; //login menu that the user sees at the start
	
	/*
	 * constructor
	 */
	public Interface() {
		/* initialize data members */
		game = null;
		user = null;
		
		/* set up listeners for the interface - to grab user input */
		JPanel keyboardPanel = new JPanel();
		KeyboardListener kbl = new KeyboardListener();
		kbl.bind(this); //allow the listener to report when a key is pressed
		keyboardPanel.setFocusable(true);
		keyboardPanel.addKeyListener(kbl); //add keyboard listener to the panel
		
		/* add panels to the interface so it can be displayed on screen */
		this.add(keyboardPanel); //allow the interface to capture keystrokes
		loginMenu = new LoginMenu();
		loginMenu.setCallback(this);
		this.add(loginMenu);
		
		/* configure window settings */
		this.setTitle("Medieval Galaxy");
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//this.setLocationRelativeTo(null); //center screen
	}//end constructor method
	
	
	/*
	 * receives key press events from KeyboardListener
	 */
	public void registerKeyPress(KeyEvent e) {
		System.out.println("Key " + KeyEvent.getKeyText(e.getKeyCode()) + " has been pressed");
		
		
		if(user != null) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W: //move north
				game.movePlayer(user, user.getCoordinate().north()); 
				break;
			case KeyEvent.VK_S: //move south
				game.movePlayer(user, user.getCoordinate().south());
				break;
			case KeyEvent.VK_D: //move east
				game.movePlayer(user, user.getCoordinate().east());
				break;
			case KeyEvent.VK_A: //move west
				game.movePlayer(user, user.getCoordinate().west());
				break;
			}
		}//end if (user != null)
		
		//exit code, but user is logged in. Return to login screen
		if(user != null && e.getKeyChar() == '\4') {
			System.out.println("logging " + user.getName() + " out");
			game.logout(user);
			user = null;
			this.add(loginMenu);
			this.repaint();
		}
		
		else if(e.getKeyChar() == '\4') { //exit code
			System.out.println("Ctrl-D pressed, quitting");
			System.exit(1);
		}
	}//end registerKeyPress method
	
	
	/*
	 * receives key type events from KeyboardListener
	 */
	public void registerKeyType(KeyEvent e) {
	}//end registerKeyType method
	
	
	/*
	 * receives key release events from KeyboardListener
	 */
	public void registerKeyRelease(KeyEvent e) {
		System.out.println("Key " + KeyEvent.getKeyText(e.getExtendedKeyCode()) + " has been released");
	}//end registerKeyRelease method
	
	
	/*
	 * displays the current game state to the screen
	 */
	void draw() { //default protection level for package level access
	}//end draw method
	
	
	/*
	 * binds the interface to a game instance
	 */
	public void bind(Game g) {
		game = g;
		if(g != null) {
			game.bind(this);
		}
	}//end bind method
	
	
	//called when the LoginMenu attempts to log a user in
	public boolean onPlayerlogin(String uname, String passwd) {
		Player player = null;
		boolean b = false;
		if(game != null) {
			player = game.login(uname, passwd);
		}
		if(player != null) { //login successful
			b = true;
			this.user = player;
			this.remove(loginMenu); //remove login screen
			this.repaint();
		}
		return b;
	}//end onPlayerLogin method
	
}//end Interface class