package entity;

import java.util.ArrayList;
import world.Coordinate;
import world.Map;

//represents the player that the user can control
public class Player {
	//private data members
	private int health;
	private int attack;
	private String name;
	private ArrayList<Object> inventory;
	private Coordinate location; //location the player is currently at
	private Coordinate moveLocation; //location the player wants to move to
	private ArrayList<Coordinate> path;	//path from location to moveLocation
	private Map world; //map that the player is playing in
	private Object leftHand;
	private Object rightHand;
	private Object head;
	private Object torso;
	private Object leggings;
	
	//public member methods
	public Player(String username) { //constructor
		health = 10;
		attack = 1;
		name = username;
		inventory = new ArrayList<Object>();
		location = new Coordinate(0,0); //start player at 0,0
		path = new ArrayList<Coordinate>();
		bindMap(null);
		setMoveLocation(null); //should take care of path
		Object wep = new Object("A black dagger?!?!?", 1);
		inventory.add(wep);
		leftHand = null;
		rightHand = null;
		head = null;
		torso = null;
		leggings = null;
	}//end constructor method
	
	
	/*
	 * To be called on every game tick. If the player's move location is
	 * different than his location, it will be updated by one Coordinate.
	 */
	public void update() {
		if(!path.isEmpty()) {
			location = path.get(0); //update player location
			path.remove(0); //remove Coordinate from path (we have traversed it)
			System.out.println("\t\t\t\t\tUser moves to x = " + location.getX() + " y = " + location.getY());
			
			if(path.isEmpty()) { //no more Coordinates to traverse
				System.out.println("Arrived at destination");
				setMoveLocation(null);
			}
		}
	}//end update method
	
	//adds an Object to the player's inventory
	public boolean addToInventory(Object obj) {
		boolean success = true;
		inventory.add(obj);
		return success;
	}//end addToInventory method
	
	//removes an object from the player's inventory
	public boolean removeFromInventory(Object obj) {
		boolean success = false;
		if(inventory.contains(obj)) {
			inventory.remove(obj);
			success = true;
		}
		return success;
	}//end removeFromInventory method
	
	//unequips the left hand
	public boolean unequipLeftHand() {
		boolean unequipped = true;
		if(leftHand != null) {
			inventory.add(leftHand);
			leftHand = null;
		}
		return unequipped;
	}//end unequipLeftHand method
	
	//unequips the right hand
	public boolean unequipRightHand() {
		boolean unequipped = true;
		if(rightHand != null) {
			inventory.add(rightHand);
			rightHand = null;
		}
		return unequipped;
	}//end unequipRightHand method
	
	//unequips the head
	public boolean unequipHead() {
		boolean unequipped = true;
		if(head != null) {
			inventory.add(head);
			head = null;
		}
		return unequipped;
	}//end unequipHead method
	
	//unequips the torso
	public boolean unequipTorso() {
		boolean unequipped = true;
		if(torso != null) {
			inventory.add(torso);
			torso = null;
		}
		return unequipped;
	}//end unequipTorso method
	
	//unequips the legs
	public boolean unequipLeggings() {
		boolean unequipped = true;
		if(leggings != null) {
			inventory.add(leggings);
			leggings = null;
		}
		return unequipped;
	}//end unequipLeggings method
	
	//equips an object in the left hand (if it is in the inventory)
	public boolean equipLeftHand(Object obj) {
		boolean success = false;
		if(inventory.contains(obj)) {
			unequipLeftHand();
			leftHand = obj;
			inventory.remove(obj);
			success = true;
		}
		return success;
	}//end equipLeftHand method
	
	//equips an object in the right hand (if it is in the inventory)
	public boolean equipRightHand(Object obj) {
		boolean success = false;
		if(inventory.contains(obj)) {
			unequipRightHand();
			rightHand = obj;
			inventory.remove(obj);
			success = true;
		}
		return success;
	}//end equipRightHand method
	
	//equips and object to the player's head (if it is in the inventory)
	public boolean equipHead(Object obj) {
		boolean success = false;
		if(inventory.contains(obj)) {
			unequipHead();
			head = obj;
			inventory.remove(obj);
			success = true;
		}
		return success;
	}//end equipHead method

	//equips an object to the player's torso (if it's in the inventory)
	public boolean equipTorso(Object obj) {
		boolean success = false;
		if(inventory.contains(obj)) {
			unequipTorso();
			torso = obj;
			inventory.remove(obj);
			success = true;
		}
		return success;
	}//end equipTorso method

	//equips an object to the player's legs (if it's in the inventory)
	public boolean equipLeggings(Object obj) {
		boolean success = false;
		if(inventory.contains(obj)) {
			unequipLeggings();
			leggings = obj;
			inventory.remove(obj);
			success = true;
		}
		return success;
	}//end equipLeggings method

	
	//returns the player's coordinate location
	public Coordinate getCoordinate() {
		return location;
	}//end getCoordinate method
	
	//sets the player's coordinate location
	public Player setCoordinate(Coordinate loc) {
		location = loc;
		return this;
	}//end setCoordinate method
	
	//returns true if the player is dead
	public boolean isDead() {
		if (health <= 0) {
			return true;
		}
		else {
			return false;
		}
	}//end isDead method
	
	//attacks a target player, dealing damage to the target equal to the player's attack
	public void attack(Player target) {
		target.health = target.health - this.attack;
	}//end attack method
	public int getattack() {
		return this.attack;
	}

	
	//gets the move location
	public Coordinate getMoveLocation() {
		return moveLocation;
	}//end getMoveLocation method
	
	
	//sets the move location
	public void setMoveLocation(Coordinate moveLocation) {
		this.moveLocation = moveLocation;
		findPath(moveLocation); //find path from location to moveLocation
	}//end setMoveLocation method
	
	
	//binds a player to a specific map (provides a reference to the map)
	public void bindMap(Map world) {
		this.world = world;
	}//end bindMap method
	
	
	//finds a path from player's current location to dest. Changes path to be a list of Coordinates from location to dest
	private void findPath(Coordinate dest) {
		if(dest != null && world.isValidCoordinate(dest) && location != dest) { //avoid finding a path for our current location
			path.add(dest); //TELEPORT TO DEST!
		}
	}//end findPath method


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
		
}//end Player class
