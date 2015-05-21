package test;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Game;
import ui.Interface;
import ui.LoginMenu;
import world.Astar;
import world.Coordinate;


public class Test {
	//tests all of Test's methods
	public static void testAll() {
		testAstar();
		testGame();
	}//end testAll method
	
	//tests the tick ability of the game
	public static void testGame() {
		System.out.println("\n=====\tTest run of the game\t=====\n");
		
		Game g = new Game();
		Interface ui = new Interface();
		ui.bind(g);
		g.start();
		
	}//end testGame method
	
	//tests the astar shortest path algorithm
	public static void testAstar() {
		System.out.println("\n=====\tTest Astar shortest path algorithm\t=====\n");
		Astar astar = new Astar();
		astar.test();
	}//end testAstar method
	
}//end Test class
