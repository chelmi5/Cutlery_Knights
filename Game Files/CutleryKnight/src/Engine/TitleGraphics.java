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
import javax.swing.*;

public class TitleGraphics extends AGraphics implements ActionListener {

    private Timer timer;
    private BackgroundImage bg;
    private String type;
    private IState state;

    public TitleGraphics(IState i) {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        bg = new BackgroundImage();
        type = "title";
        
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
            int key = e.getKeyCode();
            System.out.println("Key Released");
            //bg.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            System.out.println("Key Pressed");
            
            if (key == KeyEvent.VK_1 || key == KeyEvent.VK_ENTER)
            {  
               //Change states
               System.out.println("Pressed enter or 1!");
               state.Update();
            }
            //bg.keyPressed(e);
        }
    } 

}