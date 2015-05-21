package Engine;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    public JPanel currentPanel;

    public GameFrame(IState is) {
                
        currentPanel = is.getGraphics();
        
        add(currentPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 925); 
        setLocationRelativeTo(null);
        setTitle("Cutlery Knights");
        setResizable(false);
        setVisible(true);
    }
    
    public void changePanel(String in)
    {        
        remove(currentPanel);
        
        if(in.equals("explore"))
        {
            currentPanel = new ExplorationGraphics();
        }
        else if(in.equals("title"))
        {
            currentPanel = new TitleGraphics();
        }
        else if(in.equals("battle"))
        {
            //add(new BattleGraphics());
        }
        
        add(currentPanel);
        
        //revalidate(); // For Java 1.7 or above.
        getContentPane().validate(); // For Java 1.6 or below.
        repaint(); 

    }
   /*
    public static void main(String[] args) {
        String t = "title";
        new GameFrame(t);
    }*/
}