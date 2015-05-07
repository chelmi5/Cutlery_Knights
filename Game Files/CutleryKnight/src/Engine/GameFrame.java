package Engine;

import java.util.Scanner;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame(int state, String Title) {
        if ( state == 1 )
        {
            add(new TitleState("menu.png"));
            //add(new NewGame());
        }
        if ( state == 2 )
        {
            add(new ExplorationState());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setTitle(Title);
        setResizable(false);
        setVisible(true);
    }
}