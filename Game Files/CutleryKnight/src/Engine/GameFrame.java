package Engine;

import java.util.Scanner;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {

        //add(new ExplorationState());
        //add(new TitleState());
        /*if ( i == 1 )
        {
            add(new TitleState());
        }
        if ( i == 2 )
        {
            add(new ExplorationState());
        }*/

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setTitle("Test Moving");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        GameMenu menu = new GameMenu();        
        menu.displayMenu();
        
        //new GameFrame(int i);
    }
    
    
}