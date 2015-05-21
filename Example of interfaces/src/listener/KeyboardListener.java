package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ui.Interface;

/**
 * simple key listener that notifies an interface 
 * when a key is pressed, released, or typed
 */
public class KeyboardListener implements KeyListener {
	//private data members
	private Interface _interface;
	
	//constructor
	public KeyboardListener() {
		_interface = null;
	}//end constructor method
	
	//binds the listener to an interface
	public void bind(Interface i) {
		_interface = i;
	}//end bind method
	
	
	//called when a key is typed
	@Override
	public void keyTyped(KeyEvent e) {
		if(_interface != null) {
			_interface.registerKeyType(e);
		}
	}//end keyTyped method
	
	
	//called when a key is physically pressed
	@Override
	public void keyPressed(KeyEvent e) {
		if(_interface != null) {
			_interface.registerKeyPress(e);
		}
	}//end keyPressed method
	
	
	//called when a key is physically released
	@Override
	public void keyReleased(KeyEvent e) {
		if(_interface != null) {
			_interface.registerKeyRelease(e);
		}
	}//end keyReleased method
	
}//end KeyboardListener class
