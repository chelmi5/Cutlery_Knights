package entity;

//represents an in-game object
public class Object {
	//private data members
	private int id;
	private String name;
	
	//constructor
	Object(String name, int id) {
		this.id = id;
		this.name = name;
	}
	
	//returns the id of the object
	public int getId() {
		return id;
	}
	
	//returns the name of the object
	public String getName() {
		return name;
	}
}
