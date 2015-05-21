package temp;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class BackgroundImage {

    private String bgName = "title_graphics.png";

    private int x;
    private int y;
    private Image image;

    public BackgroundImage() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bgName));
        image = ii.getImage();
        x = 0;
        y = 0;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
}