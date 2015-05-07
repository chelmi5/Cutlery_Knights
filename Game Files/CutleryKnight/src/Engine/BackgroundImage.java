package Engine;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class BackgroundImage {

    private String bgName = "gamecharacters.png";

    private int x;
    private int y;
    private Image image;

    public BackgroundImage() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bgName));
        image = ii.getImage();
        x = 40;
        y = 60;
    }

    public BackgroundImage(String imageName) {
        bgName = imageName;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bgName));
        image = ii.getImage();
        x = 40;
        y = 60;
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

    public void setImage(String imageName) {
        this.bgName = imageName;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bgName));
        image = ii.getImage();
        x = 40;
        y = 60;
    }

    public String keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_1) {
            return "choose.png";
        }

        if (key == KeyEvent.VK_2) {

        }

        if (key == KeyEvent.VK_3) {

        }
        return "gamecharacters.png";
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_1) {
            NewGame game = new NewGame();
            game.chooseCharacter();
        }

        if (key == KeyEvent.VK_2) {
            LoadGame game = new LoadGame();
            game.fileCraller();
        }

        if (key == KeyEvent.VK_3) {
            System.exit(0);
        }
    }
}