package Engine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TitleState extends JPanel implements ActionListener {

    private Timer timer;
    private BackgroundImage bg;
    public TitleState(String imageName) {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        bg = new BackgroundImage(imageName);
        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(bg.getImage(), bg.getX(), bg.getY(), this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            String imageName = bg.keyPressed(e);
            bg = new BackgroundImage(imageName);
            repaint();
        }
        public void keyReleased(KeyEvent e) {
            bg.keyReleased(e);
        }
    }
}