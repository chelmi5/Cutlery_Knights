package world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//represents a Map coordinate location, with an x and y value.
public class Astar {
	
	private boolean verbose = false;
	
	public boolean test() {
		Coordinate start = new Coordinate(0,0);
		Coordinate goal = new Coordinate(4,-2);
		this.verbose = true;
		List<Coordinate> searchList = this.aStarSearch(start, goal);
		if (this.verbose) System.out.println("finally, this is the generated list of coordinates. Search DIAGONALS!! (all caps) to find where you can change code to enable diagonal movement");
		if (this.verbose) System.out.println(Arrays.toString(searchList.toArray()));
		return true; // test successful
	}
	
	//given two coordinates, it will return a list of coordinates between start and goal coordinates, index 0 being the start coordinate, and the last index being the goal coordinate.
	public List<Coordinate> aStarSearch(Coordinate start, Coordinate goal) {
	    Coordinate c = start;
	    HashMap<Coordinate, Double> f = new HashMap<Coordinate, Double>();  // path cost of node. f = g + h. h is estimation of distance to goal
	    HashMap<Coordinate, Double> g = new HashMap<Coordinate, Double>();  // this is the current step cost of node. Each node will increase in step cost per step
	    List<Coordinate> edges = new ArrayList<Coordinate>();  // these nodes still need to be explored
	    List<Coordinate> explored = new ArrayList<Coordinate>();  // these nodes have been explored.
	    double gcost = 0;
	    double hcost = c.distanceTo(goal);
	    double fcost = gcost + hcost;
	    f.put(c, fcost);  // always store the currently explored node cost
	    g.put(c, gcost);
	    explored.add(c);  // start node must be placed in explored (based on how I've setup while loop)
	    if (this.verbose) System.out.println("first we explore nodes towards the end goal (current node) ---> (goal node)");
	    while (!c.equals(goal)) {
	        gcost = g.get(c) + 1;  // get current step cost + 1 for neighboring steps
	        List<Coordinate> neighbors = findNeighbors(c, generateNeighbors(c));  // use the generateNeighbors to set-up 8 coordinates. And findNeighbors to filter (perhaps based on obstacles)
	        List<Coordinate> unexplored = filterExploredNeighbors(neighbors, edges, explored);  // removes neighbors from list that are in edges or explored lists
	        for (int i=0; i<unexplored.size(); i++) {
	            Coordinate neighbor = unexplored.get(i);
	            hcost = neighbor.distanceTo(goal);
	            fcost = gcost + hcost;
	            g.put(neighbor, gcost);  // gcost has +1 already to reflect the neighbors' step cost
	            f.put(neighbor, fcost);  // this is the most important cost, that reflect total estimated path cost
	            edges.add(neighbor);  // put this neighbor (not a duplicate anywhere else) into edges to be explored
	        }
	        // now we get the next c coordinate. Which MUST be the current lowest cost node.
	        c = findLowestCostNode(edges, f);
	        edges.remove(c);
	        explored.add(c);
	        if (this.verbose) System.out.println(c.toString() + " ---> " + goal.toString());
	    }  // we finish while loop when the next lowest cost node is the end goal
	    return getPathByBacktracking(f, explored, start, goal);  // backtrack through list of nodes, selecting neighbors with lowest cost
	}

	public List<Coordinate> findNeighbors(Coordinate c, List<Coordinate> pneighs) {  //pneighs is possible neighbors
	    // this will determine if diagonal paths will be included in final path. You may need to check that each nieghbor
	    // in the direction of diagonal is not an obstacle in order to assure that a diagonal does not walk through walls
	    List<Coordinate> neighbors = new ArrayList<Coordinate>();
	    for (int i = 0; i < pneighs.size(); i++) {
	        if (c.distanceTo(pneighs.get(i)) < 2) {  // if the coordinate is one of 8 touching sides
	    	//if (c.distanceTo(pneighs.get(i)) == 1) {  // if the coordinate is one of horizontal or vertical touching neighbors   ###  DIAGONALS!! (above code is for diagonal direction)
	        	if (!c.equals(pneighs.get(i))) {  // and so long as coordinate is NOT the one we currently have
	        		neighbors.add(pneighs.get(i));
	        	}
	        }
	    }
	    return neighbors;
	}

	//returns set of coordinates from Neigh list that are NOT in the edge or explore list.
	public List<Coordinate> filterExploredNeighbors(List<Coordinate> neigh, List<Coordinate> edge, List<Coordinate> explore) {
	    List<Coordinate> filtered = new ArrayList<Coordinate>();
	    for (int i=0; i<neigh.size(); i++) {
	        Coordinate n = neigh.get(i);
	        boolean isUnique = true;
	        for (int j=0; j<edge.size(); j++) {
	            Coordinate e = edge.get(j);
	            if (e.equals(n)) {
	                isUnique = false;
	            }
	        }
	        for (int k=0; k<explore.size(); k++) {
	            Coordinate x = explore.get(k);
	            if (x.equals(n)) {
	                isUnique = false;
	            }
	        }
	        if (isUnique) {  // only add node if it was not found in edge or explored nodes
	            filtered.add(n);
	        }
	    }
	    return filtered;
	}

	public List<Coordinate> generateNeighbors(Coordinate c) {
	    //directly touching neighbors
	    //List<Coordinate> neighs = new ArrayList<Coordinate>();
		//if we only give the horizontal neighbors, then our found A* path will NOT have diagonals. 
	    Coordinate a = c.copy();
	    a.setX(a.getX() + 1);  // right
	    Coordinate b = c.copy();
	    b.setX(b.getX() - 1);  // left
	    Coordinate d = c.copy();
	    d.setY(d.getY() + 1);  // up
	    Coordinate e = c.copy();
	    e.setY(e.getY() - 1);  // down
	    //diagonals
	    Coordinate f = a.copy();
	    f.setY(f.getY() + 1);  // upper right
	    Coordinate g = b.copy();
	    g.setY(g.getY() - 1);  // lower left
	    Coordinate h = d.copy();
	    h.setX(h.getX() - 1);  // upper left
	    Coordinate i = e.copy();
	    i.setX(i.getX() + 1);  // lower right
	    // add coordinates to neighbor list
	    return Arrays.asList(a, b, d, e, f, g, h, i);  // this should create the list with all those listed coordinates
	}

	public Coordinate findLowestCostNode(List<Coordinate> nodes, HashMap<Coordinate, Double> pathCost) {
	    Coordinate shortest = nodes.get(0);  // use first node for comparison
	    double lowest = pathCost.get(shortest);
	    for (int i=0; i<nodes.size(); i++) {
	        Coordinate n = nodes.get(i);
	        double ncost = pathCost.get(n);
	        if (ncost < lowest) { // if there is a tie, the earlier neighbor will be chosen
	            lowest = ncost;  // lowest cost
	            shortest = n;  // shortest path
	        }
	    }
	    return shortest;  // the lowest cost nearby node will always be the shortest path back
	}

	public List<Coordinate> getPathByBacktracking(HashMap<Coordinate, Double> f, List<Coordinate> nodes, Coordinate start, Coordinate end) {
	    List<Coordinate> blist = new ArrayList<Coordinate>();  // this is the backwards list. At end you should reverse it
	    Coordinate next = end;
	    blist.add(next);
	    if (this.verbose) System.out.println("now we reverse search, finding nodes that we had explored, in order of lowest cost from goal (current node) --> (start node)");
	    if (this.verbose) System.out.println(next.toString() + " --> " + start.toString());
	    while (!next.equals(start)) {
	        List<Coordinate> neighbors = findNeighbors(next, nodes);
	        neighbors = filterExploredNeighbors(neighbors, blist, blist);  // filter the neighbors to remove ones already in list
	        next = findLowestCostNode(neighbors, f);
	        blist.add(next);
	        if (this.verbose) System.out.println(next.toString() + " --> " + start.toString());
	    }
	    List<Coordinate> alist = new ArrayList<Coordinate>(); // to be a reversed list of blist
	    while (!blist.isEmpty()) {
	    	Coordinate a = blist.remove(blist.size() - 1);
	    	alist.add(a);
	    }
	    return alist;  // this'll order from start to end
	}
}
