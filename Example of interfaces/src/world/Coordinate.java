package world;

//represents a Map co-ordinate location, with an x and y value.
public class Coordinate {
	private int x;
	private int y;
	
	//constructor
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}//end constructor method
	
	//returns the x value of the coordinate
	public int getX() {
		return x;
	}//end getX method
	
	//returns the y value of the coordinate
	public int getY() {
		return y;
	}//end getY method
	
	//sets x value of coordinate
	public void setX(int x) {
		this.x = x;
	}
	
	//sets y value of coordinate
	public void setY(int y) {
		this.y = y;
	}
	
	//returns the coordinate to the north
	public Coordinate north() {
		return new Coordinate(x, y + 1);
	}//end north method
	
	//returns the coordinate to the south
	public Coordinate south() {
		return new Coordinate(x, y - 1);
	}//end south method
	
	//returns the coordinate to the east
	public Coordinate east() {
		return new Coordinate(x + 1, y);
	}//end east method
	
	//returns the coordinate to the west
	public Coordinate west() {
		return new Coordinate(x - 1, y);
	}//end west method
	
	//creates and returns a copy coordinate of itself
	public Coordinate copy() {
		Coordinate c = new Coordinate(this.x, this.y);
		return c;
	}
	
	public String toString() {
		return "(" + Integer.toString(this.x) + " , " + Integer.toString(this.y) + ")";
	}
	
	//returns if this coordinate occupies the same space as the given Coordinate
	public boolean equals(Coordinate other) {
		return (this.distanceTo(other) == 0);
	}
	
	//calculates the distance between two co-ordinates (ripped directly off Map function)
	public double distanceTo(Coordinate loc2) {
		Coordinate loc1 = this;  // redefine ourself as loc1
		double hypotenuse = 0.0;
		int xDiff = loc1.getX() - loc2.getX(),
			yDiff = loc1.getY() - loc2.getY();
		//calculate hypotenuse of triangle
		hypotenuse = Math.hypot(xDiff, yDiff);
		return hypotenuse;
	}//end distanceBetween method
}
