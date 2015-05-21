package ui;

import java.util.TimerTask;

/**
 * represents a game tick
 */
public class TimerTick extends TimerTask {
	//private data members
	Game game;
	private static final int tickTime = 500;	//game tick length in milliseconds
	
	//constructor
	public TimerTick() {
		game = null;
	}//end constructor method
	
	//provides TimerTick with a callback when it is ran
	public void setCallback(Game g) {
		game = g;
	}//end bind method

	@Override
	//runs the scheduled tick
	public void run() {
		if(game != null) {
			game.onGameTick(); //tick the game
		}
	}//end run method

	//returns the tick time in milliseconds
	public static int duration() {
		return tickTime;
	}//end duration method

}
