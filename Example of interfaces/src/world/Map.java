package world;

import java.util.ArrayList;
import java.util.List;

//a rectangular map which represents the world that the player interacts with
public class Map {
	//private data members
	private int x;	//width of the map
	private int y;	//height of the map
	private Astar astar;
	
	//constructor
	public Map(int width, int height) {
		if(width <= 0) {
			width = 1;	//default width to 1
		}
		if(height <= 0) {
			height = 1;	//default height to 1
		}
		x = width; //set width of map
		y = height;//set height of map
	}//end constructor method
	
	
	/*
	 * Returns a coordinate list of the shortest path between two coordinates.
	 * An empty list will be returned if no path exists, QED.
	 */
	public List<Coordinate> pathBetween(Coordinate start, Coordinate end) {
		List<Coordinate> path = new ArrayList<Coordinate>();
		if(isValidCoordinate(start) && isValidCoordinate(end)) {
			path = astar.aStarSearch(start, end);
		}
		return path;
	}//end getPath method
	
	
	//calculates the distance between two coordinates
	public double distanceBetween(int x1, int y1, int x2, int y2) {
		double hypotenuse = 0.0;
		int xDiff = x1 - x2,
			yDiff = y1 - y2;
		//calculate hypotenuse of triangle
		hypotenuse = Math.hypot(xDiff, yDiff);
		return hypotenuse;
	}//end distanceBetween method
	
	//calculates the distance between two co-ordinates
	public double distanceBetween(Coordinate loc1, Coordinate loc2) {
		double hypotenuse = 0.0;
		int xDiff = loc1.getX() - loc2.getX(),
			yDiff = loc1.getY() - loc2.getY();
		//calculate hypotenuse of triangle
		hypotenuse = Math.hypot(xDiff, yDiff);
		return hypotenuse;
	}//end distanceBetween method
	
	//determines if the map contains the given coordinate
	public boolean isValidCoordinate(int x, int y) {
		boolean valid = false;
		if((x >= 0 && x < this.x) &&
		   (y >= 0 && y < this.y)) {
			valid = true; //coordinates lie within map
		}
		return valid;
	}//end isValidCoordinate method
	
	//determines if the map contains the given coordinate
	public boolean isValidCoordinate(Coordinate coord) {
		boolean isValid = false;
		if(coord != null) {
			isValid = isValidCoordinate(coord.getX(), coord.getY());
		}
		return isValid; 
	}//end isValidCoordinate method
	
}//end Map class
