package Engine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class ExplorationGraphics extends AGraphics implements ActionListener {

    private Timer timer;
    private CharacterSprite sprite;
    private String type;
    private IState state;

    public ExplorationGraphics(IState i) {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        sprite = new CharacterSprite();
        type = "explore";
        
        state = i;

        timer = new Timer(5, this);
        timer.start();
    }
    
    public String getType()
    {
      return this.type;
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        sprite.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            sprite.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            sprite.keyPressed(e);

        }
    }

}