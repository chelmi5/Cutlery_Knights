package Engine;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    public JPanel currentPanel;

    public GameFrame(String t) {
                
        if(t.equals("explore"))
        {
            currentPanel = new ExplorationGraphics();
            add(currentPanel);
        }
        else if(t.equals("title"))
        {
            currentPanel = new TitleGraphics();
            add(currentPanel);
        }
        else if(t.equals("battle"))
        {
            //add(new BattleGraphics());
            add(currentPanel);
        }
        else
        {
            System.out.println("Planel did not get added.");
        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 925); 
        setLocationRelativeTo(null);
        setTitle("Test Moving");
        setResizable(false);
        setVisible(true);
    }
    
    public void changePanel(String in)
    {
        
        if(in.equals("explore"))
        {
            remove(currentPanel);
            currentPanel = new ExplorationGraphics();
            add(currentPanel);
        }
        else if(in.equals("title"))
        {
            remove(currentPanel);
            currentPanel = new TitleGraphics();
            add(currentPanel);
        }
        else if(in.equals("battle"))
        {
            remove(currentPanel);
            //add(new BattleGraphics());
            add(currentPanel);
        }
        else
        {
            System.out.println("Change Panel did not get updated");
        }
        
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