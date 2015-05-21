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
    
    public void changePanel(String in, IState is)
    {        
        remove(currentPanel);
        
        currentPanel = is.getGraphics();
        
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