package temp;

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
import javax.swing.*;


public class TitleGraphics extends JPanel implements ActionListener {

    private Timer timer;
    private BackgroundImage bg;
    private String type;

    public TitleGraphics() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        //sprite = new CharacterSprite();
        bg = new BackgroundImage();
        type = "title";

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
        g2d.drawImage(bg.getImage(), bg.getX(), bg.getY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        //bg.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            System.out.println("Key Released");
            //bg.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            System.out.println("Key Pressed");
            //bg.keyPressed(e);
        }
    }

}