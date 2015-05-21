package ui;

import java.util.ArrayList;
import java.util.Timer;

import entity.Player;

import world.Coordinate;
import world.Map;


/**
 * represents an instance of a game 
 */
public class Game {
	//private data members
	Interface _interface;	//default protection level for access within package
	private Map world;					//game world
	private ArrayList<Player> players;	//list of players currently logged in
	
	
	//default constructor
	public Game() {
		_interface = null;
		world = new Map(10, 10); //create a 10x10 world
		players = new ArrayList<Player>();
	}//end constructor
	
	
	//called every time the game timer ticks
	public void onGameTick() {
		System.out.println("Game tick!");
		
		//update each player's location
		for(int i = 0; i < players.size(); i++) {
			players.get(i).update(); //update players
		}//end for i
		
		if(_interface != null) {
			_interface.draw(); //re-draw the interface
		}
	}//end onGameTick method
	
	
	//binds an Interface to the game
	void bind(Interface i) { //default protection, allow an Interface to bind itself
		_interface = i;
	}//end bind method
	
	
	//starts the game
	public void start() {
		Timer timer = new Timer();
		TimerTick tick = new TimerTick();
		tick.setCallback(this); //provide tick a callback method
		
		//start the game timer
		timer.scheduleAtFixedRate(tick, 0, TimerTick.duration());
	}//end start method
	
	
	//returns the world that the game is using
	public Map getWorld() {
		return world;
	}//end getWorld method
	
	
	//logs a player into the game
	private void login(Player p) {
		if(world.isValidCoordinate(p.getCoordinate())) {
			players.add(p);
			p.bindMap(world); //bind the player to a specific world
		}
	}//end login method
	
	
	/* 
	 * attempts to log a user into the game. if successful, the user will be 
	 * logged in and true will be returned. Else, false will be returned 
	 * and the user will not be logged in
	 */
	public Player login(String uname, String passwd) {
		Player user =  null;
		user = new Player(uname); //create a new user with the give username
		login(user); //log him in
		return user;
	}//end login method
	
	
	//logs a player out of the game
	public void logout(Player p) {
		if(players.contains(p)) {
			players.remove(p);
		}
	}//end logout method
	
	
	//moves a player to a specified coordinate
	public void movePlayer(Player p, Coordinate coord) {
		//set the player's move command
		p.setMoveLocation(coord);
	}//end movePlayer method

}//end Game class
